package com.edgedo.timetask;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.JT809.client.*;
import com.edgedo.JT809.constant.JT809WarnMsgWarnSrcConst;
import com.edgedo.JT809.constant.JT809WarnMsgWarnTypeConst;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.common.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 定位数据转发任务
 */
@Component
public class BigDataRealGps809SendJob {

    private Logger LOGGER = LoggerFactory
            .getLogger(BPClient.class);
    @Value("${jt809.gps809PlatId}")
    String gps809PlatId ;

    //转发gps队列的 前缀
    public static final String GPS_TRANSMIT_QUE_PREFIX = "gps-point-que-";
    //缓存工具
    @Autowired
    RedisUtil redisUtil ;


    //将定位数据插入转发队列
    @Scheduled(cron = "0/3 * * * * ?")
    public void transmit809(){
//        long startTime = System.currentTimeMillis();
//        int count = 0;
        try {
            if(!BPClient.isClientlogin()){return;}
            while (true) {

                Object obj = redisUtil.rightPop(GPS_TRANSMIT_QUE_PREFIX + gps809PlatId);
                if (obj == null) {
//                    long endTime = System.currentTimeMillis();
//                    LOGGER.error("-------------- push " + count + " points ,use time" + (endTime-startTime));
                    return;
                }
//                count++;
                BigdataCarRealtimeGps gpsObj = (BigdataCarRealtimeGps) obj;
                Date date = gpsObj.getLastPositionTime();
                double lng = gpsObj.getPointLong().doubleValue();
                double lat = gpsObj.getPointLat().doubleValue();
                short speed = gpsObj.getRealSpeed().shortValue();
                short gpsSpeed = gpsObj.getGpsSpeed().shortValue();
                int mileage = gpsObj.getMileage().intValue();
                //方向
                short direction = gpsObj.getDirection().shortValue();
                short higth = gpsObj.getAltitude().shortValue();
                int status = 0;
                try {
                    status = new Integer(gpsObj.getCarState());
                } catch (Exception e) {
                }
                String carCode = gpsObj.getCarPlateNum();

                int carcolour = 0;
                try {
                    carcolour = new Integer(gpsObj.getCarPlateColor());
                } catch (Exception e) {
                }

                BPGnssData gnssdata = new BPGnssData(
                        false, date, lng, lat, speed,
                        gpsSpeed, mileage, direction, (short) higth,
                        status, 0);
                byte bpdata[] = BPInterface.UpExgMsgRealLocation(
                        carCode, (short) carcolour, gnssdata);
                BPMessage sendmsg = new BPMessage(BPMessageType.UP_EXG_MSG, bpdata);
                BPClient.write(sendmsg);
                LOGGER.info("---------push gps of [" + carCode +"]");
            }
        }catch (Exception e){
            LOGGER.error("---------推送定位异常",e);
        }


    }

    /**
     * @Author WangZhen
     * @Description 报警信息上传
     * @Date 2020/2/12 16:42
     **/
   /* @Scheduled(cron = "0 * * * * ?")
    public void transmitAlarm(){
//        long startTime = System.currentTimeMillis();
//        int count = 0;
        try {
            if(!BPClient.isClientlogin()){return;}

                Date date = new Date();
                double lng = 119.322152;
                double lat = 39.712068;
                short speed = 65;
                short gpsSpeed = 68;
                int mileage = 257707;
                //方向
                short direction = 172;
                short higth = 0;
                int status = 0;

                String carCode = "冀C77059";

                short carcolour = 2;


                BPGnssData gnssdata = new BPGnssData(
                        false, date, lng, lat, speed,
                        gpsSpeed, mileage, direction, (short) higth,
                        status, 0);
                byte bpdata[] = BPInterface.UpWarnMsgAdptInfo(
                        carCode,carcolour, JT809WarnMsgWarnSrcConst.WARN_SRC_TERMINAL,
                        JT809WarnMsgWarnTypeConst.WARN_TYPE_OVER_SPEED,
                        System.currentTimeMillis(),1,"",gnssdata
                );
                BPMessage sendmsg = new BPMessage(BPMessageType.UP_WARN_MSG, bpdata);
                BPClient.write(sendmsg);
                LOGGER.info("---------push warn of [" + carCode +"]");

        }catch (Exception e){
            LOGGER.error("---------推送定位异常",e);
        }


    }*/

}
