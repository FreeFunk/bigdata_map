package com.edgedo.timetask.beidou;

import com.edgedo.bigdata.entity.BigdataBeidouCompDayCheck;
import com.edgedo.bigdata.entity.BigdataBeidouCompMonthCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.bigdata.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 北斗数据接入日统计
 */
@ConditionalOnProperty(
        value = {"timetask.beidou.BigdataBeidouComDayAnalysis.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataBeidouComDayAnalysis {

    @Autowired
    BigdataBeidouCompService bigdataBeidouCompService;
    @Autowired
    BigdataBeidouCompDayCheckService bigdataBeidouCompDayCheckService;
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    BigdataAlarmRecordService bigdataAlarmRecordService;
    @Autowired
    BigdataSafetyWarningService bigdataSafetyWarningService;
    @Autowired
    BigdataDriverCardRecService bigdataDriverCardRecService;

    //分县区统计，客货危
    //@Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "${timetask.beidou.BigdataBeidouComDayAnalysis.cron.initData}")
    public void initData(){
        //初始化县区这里把城市也当做一个县区
        List<String> xianquList = new ArrayList<>();
        xianquList.add("130300");
        xianquList.add("130302");
        xianquList.add("130303");
        xianquList.add("130304");
        xianquList.add("130306");
        xianquList.add("130321");
        xianquList.add("130322");
        xianquList.add("130324");
        xianquList.add("130371");
        //初始化话车辆类型集合
        List<String> carTypeList = new ArrayList<>();
        carTypeList.add("总");
        carTypeList.add("客运");
        carTypeList.add("普货");
        carTypeList.add("危货");
        for (int i=0;i<xianquList.size();i++){
            for(int j=0;j<carTypeList.size();j++){
                updateComDayCheck(xianquList.get(i),carTypeList.get(j));
            }
        }
    }
    public void updateComDayCheck(String xianquId,String carType){
        //统计昨天的数据
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dayIntStr = sdf.format(date);
        int dayInt = new Integer(dayIntStr);
        int monthInt = dayInt / 100;
        int yearInt = monthInt / 100;
        //查询出所有的运营商
        List<BigdataBeidouCompView> bigdataBeidouCompViewList = bigdataBeidouCompService.listAll();
        //分别统计每个运营商的月度考核
        for(BigdataBeidouCompView comp:bigdataBeidouCompViewList){
            String compId = comp.getId();
            String compName = comp.getCompName();
            //车辆总数
            int carSumNum = carInfoService.countCarSumNumByCompIdNew(compId,xianquId,carType,"","");

            //统计上线的车数
            int onlineNum = carInfoService.countCarSumNumByCompIdNew(compId,xianquId,carType,"1","");
            //计算上线率
            BigDecimal onlineRate = new BigDecimal("0");
            if(carSumNum>0){
                onlineRate = new BigDecimal(onlineNum).divide(new BigDecimal(carSumNum),2,BigDecimal.ROUND_HALF_UP);
            }
            //统计运营数
            int operationNum = carInfoService.countCarSumNumByCompIdNew(compId,xianquId,carType,"","1");
            //计算运营率
            BigDecimal operationRate = new BigDecimal("0");
            if(onlineNum>0){
                operationRate =  new BigDecimal(operationNum).divide(new BigDecimal(onlineNum),2,BigDecimal.ROUND_HALF_UP);
            }
            //统计常规报警数
            int alarmNum = bigdataAlarmRecordService.countSumNumByCompId(compId,dayInt);
            //主动安全报警数
            int safetyNum = bigdataSafetyWarningService.countSumNumByCompId(compId,dayInt);
            //司机插卡记录数
            int driverCardRecNum = bigdataDriverCardRecService.countSumNumByCompId(compId,dayInt);
            BigdataBeidouCompDayCheck bigdataBeidouCompDayCheck = new BigdataBeidouCompDayCheck();
            bigdataBeidouCompDayCheck.setCompId(compId);
            bigdataBeidouCompDayCheck.setCompName(compName);
            bigdataBeidouCompDayCheck.setCarNum(carSumNum);
            bigdataBeidouCompDayCheck.setOnlineCarNum(onlineNum);
            bigdataBeidouCompDayCheck.setOnlineRate(onlineRate);
            bigdataBeidouCompDayCheck.setOperationNum(operationNum);
            bigdataBeidouCompDayCheck.setOperationRate(operationRate);
            bigdataBeidouCompDayCheck.setAlarmNum(alarmNum);
            bigdataBeidouCompDayCheck.setSafetyNum(safetyNum);
            bigdataBeidouCompDayCheck.setDriverCardRecNum(driverCardRecNum);
            bigdataBeidouCompDayCheck.setCarType(carType);
            bigdataBeidouCompDayCheck.setXianquType(xianquId);
            bigdataBeidouCompDayCheck.setCountDate(dayInt);
            bigdataBeidouCompDayCheck.setCountMonth(monthInt);
            bigdataBeidouCompDayCheck.setYearNum(yearInt);
            bigdataBeidouCompDayCheckService.insertOrUpdate(bigdataBeidouCompDayCheck);
        }
    }
}
