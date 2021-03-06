package com.edgedo.util;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.BigdataCarTrailGps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangZhen
 * @description
 * @date 2019/11/19
 */
@Component
public class GpsLogFenxiUtil {

    @Value("${bigdata.carPlatePrefix}")
    private String carPlatePrefix;



    public BigdataCarRealtimeGps fenxiOneRealPosition(String temLine){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] arr = temLine.split(",");
        if(arr.length<13){
            return null;
        }
        String ip = arr[0];
        //更新缓存的ip的时间

        //车牌号
        String carPlateNum = arr[1];
        //上次的更新时间
        String lastPositionTime = arr[2];
        //经度
        String pointLong = arr[3];
        //纬度
        String pointLat = arr[4] ;
        //实时速度
        String realSpeed = arr[5];
        //gps速度
        String gpsSpeed = arr[6];
        //里程
        String mileage = arr[7];
        //方向
        String direction = arr[8];
        //海拔
        String altitude = arr[9];
        //车辆状态
        String carState = arr[10];
        //报警状态
        String alarmState = arr[11];
        //车牌颜色
        String carPlateColor = arr[12];
        if(carPlateColor!=null && carPlateColor.length()>1){
            return null;
        }
        if(arr.length==14){
            lastPositionTime = arr[13];
        }

        BigdataCarRealtimeGps bigdataCarRealtimeGps = new BigdataCarRealtimeGps();
        bigdataCarRealtimeGps.setGpsCarPlateNum(carPlateNum);
        bigdataCarRealtimeGps.setIp(ip);
        //先把配置的特殊符号去掉

        carPlateNum = trimCarPlateNum(carPlateNum);
        bigdataCarRealtimeGps.setCarPlateNum(carPlateNum);
        Date lastPostime = new Date();
        try{
            lastPostime = sdf.parse(lastPositionTime);
            bigdataCarRealtimeGps.setLastPositionTime(lastPostime);
            bigdataCarRealtimeGps.setPointLat(new BigDecimal(pointLat));
            bigdataCarRealtimeGps.setPointLong(new BigDecimal(pointLong));
            bigdataCarRealtimeGps.setRealSpeed(new BigDecimal(realSpeed));
            bigdataCarRealtimeGps.setGpsSpeed(new BigDecimal(gpsSpeed));
            bigdataCarRealtimeGps.setMileage(new BigDecimal(mileage));
            bigdataCarRealtimeGps.setDirection(new BigDecimal(direction));
            bigdataCarRealtimeGps.setAltitude(new BigDecimal(altitude));
            bigdataCarRealtimeGps.setCarState(carState);
            bigdataCarRealtimeGps.setAlarmState(alarmState);
            bigdataCarRealtimeGps.setCarPlateColor(carPlateColor);
            bigdataCarRealtimeGps.setLastUpTime(new Date());
            return bigdataCarRealtimeGps;
        }catch (Exception e){}
        return null;

    }

    /**
     * @Author WangZhen
     * @Description 分析
     * @Date 2019/11/19 15:09
     **/
    public BigdataCarTrailGps fenxiOneCarTrail(String temLine){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] arr = temLine.split(",");
        if(arr.length<13){
            return null;
        }
        String ip = arr[0];
        //更新缓存的ip的时间

        //车牌号
        String carPlateNum = arr[1];
        //上次的更新时间
        String lastPositionTime = arr[2];
        //经度
        String pointLong = arr[3];
        //纬度
        String pointLat = arr[4] ;
        //实时速度
        String realSpeed = arr[5];
        //gps速度
        String gpsSpeed = arr[6];
        //里程
        //方向
        String direction = arr[8];
        //海拔
        String altitude = arr[9];
        //车牌颜色
        String carPlateColor = arr[12];
        if(carPlateColor!=null && carPlateColor.length()>1){
            return null;
        }
        if(arr.length==14){
            lastPositionTime = arr[13];
        }

        BigdataCarTrailGps carTrailGps = new BigdataCarTrailGps();
        //先把配置的特殊符号去掉
        try{
            Date lastPostime = sdf.parse(lastPositionTime);
            carTrailGps.setLastPositionTime(lastPostime);
            carTrailGps.setPointLat(new BigDecimal(pointLat));
            carTrailGps.setPointLong(new BigDecimal(pointLong));
            carTrailGps.setRealSpeed(new BigDecimal(realSpeed));
            carTrailGps.setGpsSpeed(new BigDecimal(gpsSpeed));
            carTrailGps.setDirection(new BigDecimal(direction));
            carTrailGps.setAltitude(new BigDecimal(altitude));
            carTrailGps.setId(carPlateNum + "_" + carPlateColor);
            return carTrailGps;
        }catch (Exception e){}
        return null;

    }





    /**
     * 去掉车牌号的特殊字符
     * @param carPlateNum
     * @return
     */
    public String trimCarPlateNum(String carPlateNum){
        carPlateNum = carPlateNum.replaceAll("[- _ #]","");
        int index = carPlateNum.indexOf(carPlatePrefix);
        if(index>0){
            carPlateNum = carPlateNum.replaceAll(" ","");
            carPlateNum = carPlateNum.substring(carPlateNum.indexOf(carPlatePrefix));
        }
        return carPlateNum;
    }

}
