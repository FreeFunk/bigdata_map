package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionView;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionView;
import com.edgedo.bigdata.queryvo.CarQuXiangGroupCount;
import com.edgedo.bigdata.service.*;
import com.edgedo.common.util.BaiDuMapApiUtil;
import com.edgedo.sys.entity.SysCity;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.service.SysCityService;
import com.edgedo.sys.service.SysProviceService;
import com.edgedo.sys.service.SysXianquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@ConditionalOnProperty(
        value = {"timetask.analysis.BigDataAnalysisCarStop.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigDataAnalysisCarStop {
    @Autowired
    BigdataCarStopRecordService carStopRecordService;
    @Autowired
    BigdataCarStopRecService carStopRecService;
    //日期数字的格式化
    private SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

    /**
     * 设置停车记录的地理位置
     */
    //@Scheduled(cron = "0 24 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisCarStop.cron.fenxiCarStopRec}")
    public void fenxiCarStopRec(){
        try{
            //分组统计当日的去向省情况
            Date curDate = new Date();
            String dateIntStr = sdfDateInt.format(curDate);
            int dateInt = new Integer(dateIntStr);
            int countMonth = dateInt/100;
            int yearNum = countMonth/100;
            carStopRecService.insertCarStopRec(null,dateInt,countMonth,yearNum);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
