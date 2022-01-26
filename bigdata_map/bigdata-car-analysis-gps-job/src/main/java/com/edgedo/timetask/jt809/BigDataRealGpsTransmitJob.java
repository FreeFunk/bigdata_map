package com.edgedo.timetask.jt809;

import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.service.BigdataCarRealtimeGpsService;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 定位数据转发任务
 */
@ConditionalOnProperty(
        value = {"timetask.jt809.BigDataRealGpsTransmitJob.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigDataRealGpsTransmitJob {
    //转发队列权限不同的上级平台转发的车辆不同
    public static final String CAR_REAL_TIME_GPS_TRANSMIT_QUE_PERMIT_KEY = "car-real-time-gps-transmit-que-permit";
    //转发gps队列的 前缀
    public static final String GPS_TRANSMIT_QUE_PREFIX = "gps-point-que-";
    //缓存工具
    @Autowired
    RedisUtil redisUtil ;
    //原始对比Map
    Map<String,BigdataCarRealtimeGps> oraGpsMap = new HashMap<String,BigdataCarRealtimeGps>();
    //转发队列权限
    Map<String,Set<String>>  transmitQueCarPermit = new HashMap<String,Set<String>>();

    @Value("${bigdata.jdkStartEncode}")
    private String jdkStartEncode;

    //将定位数据插入转发队列
    //@Scheduled(cron = "0/3 * * * * ?")
    @Scheduled(cron = "${timetask.jt809.BigDataRealGpsTransmitJob.cron.compareGpsAndTransfer}")
    public void compareGpsAndTransfer(){
        try {
            Map<Object, Object> gpsMap = redisUtil.hmget(RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY);
            if (gpsMap == null) {
                return;
            }
            Collection<Object> gpsObjSet = gpsMap.values();
            List<BigdataCarRealtimeGps> changeList = new ArrayList<BigdataCarRealtimeGps>();
            for (Object obj : gpsObjSet) {
                BigdataCarRealtimeGps gpsObj = (BigdataCarRealtimeGps) obj;
                String carId = gpsObj.getId();
                BigdataCarRealtimeGps oraGpsObj = oraGpsMap.get(carId);
                if (oraGpsObj == null) {
                    oraGpsMap.put(carId, gpsObj);
//                pushGpsIntoQues(gpsObj);
                    changeList.add(gpsObj);
                } else {
                    Date gpsLpt = gpsObj.getLastPositionTime();
                    Date oraGpsLpt = oraGpsObj.getLastPositionTime();
                    long gpsTimeLong = gpsLpt.getTime();
                    long oraGpsTimeLong = oraGpsLpt.getTime();
                    if (gpsTimeLong > oraGpsTimeLong) {
                        oraGpsMap.put(carId, gpsObj);
                        //pushGpsIntoQues(gpsObj);
                        changeList.add(gpsObj);
                    }
                }

            }
            if (changeList.size() > 0) {
                pushAllGpsIntoQues(changeList);
                System.out.println(new Date() + "-----------put "+changeList.size()+" points to que" );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //将转发队列的车辆权限重新加载到内存
//    @Scheduled(cron = "0 0/7 * * * ?")
    @Scheduled(cron = "${timetask.jt809.BigDataRealGpsTransmitJob.cron.loadTransmitQueCarPermit}")
    public void loadTransmitQueCarPermit(){
        Map<Object,Object> redisQueCarPermit = redisUtil.hmget(CAR_REAL_TIME_GPS_TRANSMIT_QUE_PERMIT_KEY);
        if(redisQueCarPermit==null){
            return;
        }
        Collection<Object> transmitQueCarPermitSet = redisQueCarPermit.keySet();
        for(Object obj : transmitQueCarPermitSet){
            Set<String> carSet = (Set<String>)redisQueCarPermit.get(obj);
            transmitQueCarPermit.put(obj.toString(),carSet);
        }
        Set<String> permitSet = transmitQueCarPermit.keySet();
        for(String k : permitSet){
            Object obj = redisQueCarPermit.get(k);
            if(obj==null){
                transmitQueCarPermit.remove(obj);
            }
        }
    }

    /**
     * @Author WangZhen
     * @Description 将需要转发的点放到转发队列
     * @Date 2020/1/16 11:29
     **/
    private void pushGpsIntoQues(BigdataCarRealtimeGps gpsObj){
        String carId = gpsObj.getId();
        //获得所有需要转发的队列key
        Set<String> queKeySet = transmitQueCarPermit.keySet();
        for(String k : queKeySet){
            Set<String> carPermitSet = transmitQueCarPermit.get(k);
            if(carPermitSet.contains(carId)){
                redisUtil.leftPush(k,gpsObj);
            }
        }
    }

    /**
     * @Author WangZhen
     * @Description  将所有的记录放入到队列中
     * @Date 2020/1/17 13:59
     **/
    private void pushAllGpsIntoQues(Collection<BigdataCarRealtimeGps> col){
        //获得所有需要转发的队列key
        Set<String> queKeySet = transmitQueCarPermit.keySet();
        //TODO:根据权限转发
        /*for(String k : queKeySet){
            List<BigdataCarRealtimeGps> pushSet = new ArrayList<BigdataCarRealtimeGps>();
            for( BigdataCarRealtimeGps gpsObj : col){
                String carId = gpsObj.getId();
                Set<String> carPermitSet = transmitQueCarPermit.get(k);
                if(carPermitSet.contains(carId)){
                    pushSet.add(gpsObj);
                }
            }
            redisUtil.leftPushAll(k,pushSet);
        }*/
        //TODO:全量转发
        for(String k : queKeySet){
            redisUtil.leftPushAll(k,col);
        }
    }

}
