package com.edgedo.timetask.transmit;

import com.edgedo.bigdata.entity.BigdataGpsTransmitCarPermit;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitPlatformView;
import com.edgedo.bigdata.service.BigdataGpsTransmitCarPermitService;
import com.edgedo.bigdata.service.BigdataGpsTransmitPlatformService;
import com.edgedo.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author WangZhen
 * @description 加载数据转发权限的配置
 * @date 2020/1/16
 */
@ConditionalOnProperty(
        value = {"timetask.transmit.BigdataTransmitPlatLoadJob.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataTransmitPlatLoadJob {

    public static final String CAR_REAL_TIME_GPS_TRANSMIT_QUE_PERMIT_KEY = "car-real-time-gps-transmit-que-permit";
    public static final String GPS_TRANSMIT_QUE_PREFIX = "gps-point-que-";
    //对接 平台服务
    @Autowired
    BigdataGpsTransmitPlatformService gpsTransmitPlatformService;
    //权限设置服务
    @Autowired
    BigdataGpsTransmitCarPermitService gpsTransmitCarPermitService;
    @Autowired
    RedisUtil redisUtil;

    //@Scheduled(cron = "0 0/10 * * * ?")
    @Scheduled(cron = "${timetask.transmit.BigdataTransmitPlatLoadJob.cron.loadTransmitPlat}")
    public void loadTransmitPlat(){

        //查到所有平台
        List<BigdataGpsTransmitPlatformView> listPlat = gpsTransmitPlatformService.selectAllPlatformOfUp();

        //挨个查平台的权限设置
        for(BigdataGpsTransmitPlatformView plat : listPlat){
            String platId = plat.getId();
            String dataState = plat.getDataState();
            if(dataState!=null && dataState.equals("0")){
                //删除对应的队列权限
                redisUtil.hdel(
                        CAR_REAL_TIME_GPS_TRANSMIT_QUE_PERMIT_KEY,
                        GPS_TRANSMIT_QUE_PREFIX + platId);
            }else{
                //查询所有的车辆信息
                Set<String> permitCarSet = gpsTransmitCarPermitService.selectCarPermitByPlatId(platId);
                redisUtil.hset(CAR_REAL_TIME_GPS_TRANSMIT_QUE_PERMIT_KEY,
                        GPS_TRANSMIT_QUE_PREFIX + platId,permitCarSet);

            }
            plat.setIsUpdate("1");
            //取消更新状态
            gpsTransmitPlatformService.update(plat);

        }

    }


}
