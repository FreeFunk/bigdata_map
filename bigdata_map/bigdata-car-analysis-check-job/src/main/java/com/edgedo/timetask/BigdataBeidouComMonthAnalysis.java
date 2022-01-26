package com.edgedo.timetask;

import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.entity.BigdataBeidouCompMonthCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.bigdata.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName BigdataBeidouComMonthAnalysis
 * @Description
 * @Author 床前明月光
 * @Date 2019/8/5 11:38
 **/
@Component
public class BigdataBeidouComMonthAnalysis {

    @Autowired
    BigdataBeidouCompService bigdataBeidouCompService;
    @Autowired
    BigdataBeidouCompMonthCheckService bigdataBeidouCompMonthCheckService;
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    BigdataBeidouCarMonthCheckService bigdataBeidouCarMonthCheckService;
    @Autowired
    BigdataBeidouLinkBkRecService bigdataBeidouLinkBkRecService;
    @Autowired
    BigdataDriverCardInfoService bigdataDriverCardInfoService;
    @Autowired
    BigdataBeidouSpeedAlarmDayCheckService bigdataBeidouSpeedAlarmDayCheckService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void updateComMonthCheck(){

        SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        Date countDate = calendar.getTime();
        String countDateStr = sdfDateInt.format(countDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(countDate);
        int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
        //查询出所有的运营商
        List<BigdataBeidouCompView> bigdataBeidouCompViewList = bigdataBeidouCompService.listAll();
        //分别统计每个运营商的月度考核
        for(BigdataBeidouCompView comp:bigdataBeidouCompViewList){
            //车辆总数
            int carSumNum = carInfoService.countCarSumNumByCompId(comp.getId());
            if(carSumNum==0){
                continue;
            }
            //统计上线的车数
            Map<String,Object> param = new HashMap<>();
            param.put("compId",comp.getId());
            param.put("countMonth",Integer.valueOf(countDateStr)/100);
            param.put("onlineState","1");
            int onlineNum = bigdataBeidouCarMonthCheckService.countOnlineByCompId(param);
            //计算上线率
            BigDecimal onlineRate = new BigDecimal(onlineNum).divide(new BigDecimal(carSumNum),2,BigDecimal.ROUND_HALF_UP);
            //统计当月轨迹不完整车数
            Map<String,Object> param1 = new HashMap<>();
            param1.put("compId",comp.getId());
            param1.put("countMonth",Integer.valueOf(countDateStr)/100);
            int traceUncompleteNum = bigdataBeidouCarMonthCheckService.countTraceUncompleteNumByCompId(param1);
            //计算轨迹完整率
            BigDecimal traceCompleteRate = new BigDecimal("0");
            if(onlineNum>0){
                traceCompleteRate = new BigDecimal(onlineNum-traceUncompleteNum).divide(new BigDecimal(carSumNum),2,BigDecimal.ROUND_HALF_UP);
            }
            //统计轨迹漂移车数
            Map<String,Object> param2 = new HashMap<>();
            param2.put("compId",comp.getId());
            param2.put("countMonth",Integer.valueOf(countDateStr)/100);
            int traceFlayCarNum = bigdataBeidouCarMonthCheckService.countTraceFlayCarNumByCompId(param2);
            //计算车辆漂移率
            BigDecimal traceFlyRate = new BigDecimal("0");
            if(onlineNum>0){
                traceFlyRate = new BigDecimal(traceFlayCarNum).divide(new BigDecimal(onlineNum),2,BigDecimal.ROUND_HALF_UP);
            }
            //统计回传间隔不合格的车辆
            Map<String,Object> param3 = new HashMap<>();
            param3.put("compId",comp.getId());
            param3.put("countMonth",Integer.valueOf(countDateStr)/100);
            int ungpsUploadTimeQualifiedNum = bigdataBeidouCarMonthCheckService.countGpsUploadTimeQualifiedNumByCompId(param3);
            int gpsUploadTimeQualifiedNum = onlineNum-ungpsUploadTimeQualifiedNum;
            //计算回传间隔合格率
            BigDecimal gpsUploadTimeQualifiedRate = new BigDecimal(gpsUploadTimeQualifiedNum).divide(new BigDecimal(carSumNum),2,BigDecimal.ROUND_HALF_UP);
            //统计中断的分钟数
            Map<String,Object> param4 = new HashMap<>();
            param4.put("compId",comp.getId());
            param4.put("countMonth",Integer.valueOf(countDateStr)/100);
            int sumLinkMinNum = bigdataBeidouLinkBkRecService.sumLinkMinNum(param4);
            //联通时间
            int linkNum = day_of_month*24*60 - sumLinkMinNum;
            //计算连通率
            BigDecimal linkRate = new BigDecimal(linkNum).divide(new BigDecimal(day_of_month*24*60),2,BigDecimal.ROUND_HALF_UP);
            //统计上传过司机卡的车辆
            Map<String,Object> param5 = new HashMap<>();
            param5.put("compId",comp.getId());
            param5.put("countMonth",Integer.valueOf(countDateStr)/100);
            int driverCardUpNum = bigdataBeidouCarMonthCheckService.countDriverCardUpNumByCompId(param5);
            //计算司机卡的上传率
            BigDecimal driverCardUploadRate = new BigDecimal(driverCardUpNum).divide(new BigDecimal(carSumNum),2,BigDecimal.ROUND_HALF_UP);
            //统计司机卡的总数
            Map<String,Object> param6 = new HashMap<>();
            param6.put("compId",comp.getId());
            int driverCarRecCount = bigdataDriverCardInfoService.countDriverCarRec(param6);
            //统计司机卡的合格数
            Map<String,Object> param7 = new HashMap<>();
            param7.put("compId",comp.getId());
            param7.put("qualifiedFlag","1");
            int driverCardQualifiedNum = bigdataDriverCardInfoService.countDriverCarRec(param7);
            //计算司机卡的准确率
            BigDecimal driverCardQualifiedRate = new BigDecimal("0");
            if(driverCarRecCount>0){
                driverCardQualifiedRate = new BigDecimal(driverCardQualifiedNum).divide(new BigDecimal(driverCarRecCount),2,BigDecimal.ROUND_HALF_UP);
            }
            //统计分段限速报警准确率
            //查询当月的总的记录数
            Map<String,Object> param8 = new HashMap<>();
            param8.put("compId",comp.getId());
            param8.put("countMonth",Integer.valueOf(countDateStr)/100);
            int countSpeedAlarm = bigdataBeidouSpeedAlarmDayCheckService.countSpeedAlarm(param8);
            param8.put("speedAlarmQualified","1");
            int countSpeedAlarmQualified = bigdataBeidouSpeedAlarmDayCheckService.countSpeedAlarm(param8);
            BigDecimal speedAlarmQualifiedRate = new BigDecimal("0");
            if(countSpeedAlarm>0){
                speedAlarmQualifiedRate = new BigDecimal(countSpeedAlarmQualified).divide(new BigDecimal(countSpeedAlarm),2,BigDecimal.ROUND_HALF_UP);
            }
            BigdataBeidouCompMonthCheck bigdataBeidouCompMonthCheck = new BigdataBeidouCompMonthCheck();
            bigdataBeidouCompMonthCheck.setCompId(comp.getId());
            bigdataBeidouCompMonthCheck.setCompName(comp.getCompName());
            bigdataBeidouCompMonthCheck.setCompFlag(comp.getCompFlag());
            bigdataBeidouCompMonthCheck.setCarNum(carSumNum);
            bigdataBeidouCompMonthCheck.setOnlineCarNum(onlineNum);
            bigdataBeidouCompMonthCheck.setOnlineRate(onlineRate);
            bigdataBeidouCompMonthCheck.setTraceUncompleteCarNum(traceUncompleteNum);
            bigdataBeidouCompMonthCheck.setTraceCompleteRate(traceCompleteRate);
            bigdataBeidouCompMonthCheck.setTraceFlayCarNum(traceFlayCarNum);
            bigdataBeidouCompMonthCheck.setTraceFlyRate(traceFlyRate);
            bigdataBeidouCompMonthCheck.setGpsUploadTimeQualifiedNum(gpsUploadTimeQualifiedNum);
            bigdataBeidouCompMonthCheck.setGpsUploadTimeQualifiedRate(gpsUploadTimeQualifiedRate);
            bigdataBeidouCompMonthCheck.setLinkBreakMinute(sumLinkMinNum);
            bigdataBeidouCompMonthCheck.setLinkRate(linkRate);
            bigdataBeidouCompMonthCheck.setDriverCardUpCarNum(driverCardUpNum);
            bigdataBeidouCompMonthCheck.setDriverCardUploadRate(driverCardUploadRate);
            bigdataBeidouCompMonthCheck.setDriverCarRecCount(driverCarRecCount);
            bigdataBeidouCompMonthCheck.setDriverCardQualifiedNum(driverCardQualifiedNum);
            bigdataBeidouCompMonthCheck.setDriverCardQualifiedRate(driverCardQualifiedRate);
            bigdataBeidouCompMonthCheck.setSpeedAlarmQualifiedRate(speedAlarmQualifiedRate);
            bigdataBeidouCompMonthCheck.setCountMonth(Integer.valueOf(countDateStr)/100);
            bigdataBeidouCompMonthCheck.setYearNum(Integer.valueOf(countDateStr)/10000);
            bigdataBeidouCompMonthCheckService.insertOrUpdate(bigdataBeidouCompMonthCheck);
        }
    }
}
