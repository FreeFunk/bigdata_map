package com.edgedo.timetask;

import com.edgedo.bigdata.entity.BigdataBeidouSpeedAlarmDayCheck;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.bigdata.service.BigdataBeidouCompService;
import com.edgedo.bigdata.service.BigdataBeidouSpeedAlarmDayCheckService;
import com.edgedo.bigdata.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName BigdataBeidouSpeedAlarmDayCheckAnalysis
 * @Description 运营商分段限速报警日考核
 * @Author 床前明月光
 * @Date 2019/8/9 16:31
 **/
@Component
public class BigdataBeidouSpeedAlarmDayCheckAnalysis {

    @Autowired
    BigdataAlarmRecordService bigdataAlarmRecordService;
    @Autowired
    BigdataBeidouCompService bigdataBeidouCompService;
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    BigdataBeidouSpeedAlarmDayCheckService bigdataBeidouSpeedAlarmDayCheckService;

    //生成分段限速报警日考核
    @Scheduled(cron = "0 0 1 * * ?")
    public void updateSpeedAlarmDayCheck(){
        SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        Date countDate = calendar.getTime();
        String countDateStr = sdfDateInt.format(countDate);

        List<BigdataBeidouCompView> bigdataBeidouCompViewList = bigdataBeidouCompService.listAll();
        for(BigdataBeidouCompView comp:bigdataBeidouCompViewList){

            Map<String,Object> map = new HashMap<>();
            map.put("compId",comp.getId());
            map.put("countDate",Integer.valueOf(countDateStr));
            map.put("countMonth",Integer.valueOf(countDateStr)/100);
            int countByCompId = bigdataAlarmRecordService.countByCompId(map);
            //查询运营商的车辆总数
            int carSumNum = carInfoService.countCarSumNumByCompId(comp.getId());
            //判断基数
            int jugeBaseNum = carSumNum*5;
            BigdataBeidouSpeedAlarmDayCheck bigdataBeidouSpeedAlarmDayCheck = new BigdataBeidouSpeedAlarmDayCheck();
            if(new BigDecimal(countByCompId).compareTo(new BigDecimal(jugeBaseNum))>1){
                bigdataBeidouSpeedAlarmDayCheck.setSpeedAlarmQualified("1");
            }else {
                bigdataBeidouSpeedAlarmDayCheck.setSpeedAlarmQualified("0");
            }
            bigdataBeidouSpeedAlarmDayCheck.setCarNum(carSumNum);
            bigdataBeidouSpeedAlarmDayCheck.setJugeBaseNum(new BigDecimal(jugeBaseNum+""));
            bigdataBeidouSpeedAlarmDayCheck.setSpeedAlarmNum(countByCompId);
            bigdataBeidouSpeedAlarmDayCheck.setCompId(comp.getId());
            bigdataBeidouSpeedAlarmDayCheck.setCompName(comp.getCompName());
            bigdataBeidouSpeedAlarmDayCheck.setCountDate(Integer.valueOf(countDateStr));
            bigdataBeidouSpeedAlarmDayCheck.setCountMonth(Integer.valueOf(countDateStr)/100);
            bigdataBeidouSpeedAlarmDayCheck.setYearNum(Integer.valueOf(countDateStr)/10000);
            bigdataBeidouSpeedAlarmDayCheckService.insertOrUpdate(bigdataBeidouSpeedAlarmDayCheck);
        }
    }
}
