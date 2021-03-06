package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.BigdataCoefficientRec;
import com.edgedo.bigdata.entity.BigdataFatigueAnalysis;
import com.edgedo.bigdata.entity.BigdataOverspeedAnalysis;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisView;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisView;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisView;
import com.edgedo.bigdata.service.BigdataCoefficientRecService;
import com.edgedo.bigdata.service.BigdataFatigueAnalysisService;
import com.edgedo.bigdata.service.BigdataOverspeedAnalysisService;
import com.edgedo.bigdata.service.CityTransportCapacityAnalysisService;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

//系数统计
@ConditionalOnProperty(
        value = {"timetask.analysis.BigdataAnalysisCoefficient.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisCoefficient {

    @Autowired
    BigdataOverspeedAnalysisService bigdataOverspeedAnalysisService;
    @Autowired
    BigdataCoefficientRecService bigdataCoefficientRecService;
    @Autowired
    CityTransportCapacityAnalysisService cityTransportCapacityAnalysisService;
    @Autowired
    BigdataFatigueAnalysisService bigdataFatigueAnalysisService;

    //@Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisCoefficient.cron.execute}")
    public void execute(){
        /*String startDateStr = "2019-04-19";
        Date startDate = DateUtil.getDateByString(startDateStr,"yyyy-MM-dd");
        int daysBetween  = DateUtil.getDaysBetween(startDate,new Date());
        for(int i = 0;i<=daysBetween;i++){
            countByDate(startDate,"总");
            countByDate(startDate,"客运");
            countByDate(startDate,"普货");
            countByDate(startDate,"危货");
            startDate =DateUtil.getNextDayDate(startDate);
        }
*/
        countByDate(new Date(),"总");
        countByDate(new Date(),"客运");
        countByDate(new Date(),"普货");
        countByDate(new Date(),"危货");

    }

    public void countByDate(Date startDate,String carType){

        //计算超速安全系数
        BigdataOverspeedAnalysis bigdataOverspeedAnalysis = new BigdataOverspeedAnalysis();
        bigdataOverspeedAnalysis.setCarType(carType);
        bigdataOverspeedAnalysis.setCountTime(startDate);
        BigdataOverspeedAnalysisView bigdataOverspeedAnalysisView =bigdataOverspeedAnalysisService.getVoByQuery(bigdataOverspeedAnalysis);
        CityTransportCapacityAnalysisView cityTransportCapacityAnalysisView = cityTransportCapacityAnalysisService.getRealTimeData(carType);
        double t1 = 0.0;
        if(bigdataOverspeedAnalysisView!=null){
            //超速车辆
            int sumOverspeedNum = bigdataOverspeedAnalysisView.getSumOverspeedNum();
            DecimalFormat df = new DecimalFormat("#.00");
            t1 = Double.valueOf(df.format((double)(sumOverspeedNum)/(double)cityTransportCapacityAnalysisView.getOnlineNum()));
        }
        //计算疲劳安全系数
        BigdataFatigueAnalysis bigdataFatigueAnalysis = new BigdataFatigueAnalysis();
        bigdataFatigueAnalysis.setCarType(carType);
        bigdataFatigueAnalysis.setCountTime(startDate);
        BigdataFatigueAnalysisView bigdataFatigueAnalysisView =  bigdataFatigueAnalysisService.getVoByQuery(bigdataFatigueAnalysis);
        double t2 = 0.0;
        if(bigdataFatigueAnalysisView!=null){
            //超速车辆
            int sumFatigueNum = bigdataFatigueAnalysisView.getSumFatigueNum();
            DecimalFormat df = new DecimalFormat("#.00");
            t2 = Double.valueOf(df.format((double)(sumFatigueNum)/(double)cityTransportCapacityAnalysisView.getOnlineNum()));
        }

        BigdataCoefficientRec bigdataCoefficientRec = new BigdataCoefficientRec();
        bigdataCoefficientRec.setOverspeedWarningNum(new BigDecimal(t1+""));
        bigdataCoefficientRec.setFatigueRunNum(new BigDecimal(t2+""));
        bigdataCoefficientRec.setSafetyNium(new BigDecimal(t1+"").add(new BigDecimal(t2+"")).divide(new BigDecimal(2), 2, BigDecimal.ROUND_HALF_UP));
        bigdataCoefficientRec.setCarType(carType);
        bigdataCoefficientRec.setCountTime(startDate);
        bigdataCoefficientRecService.addOrUpdate(bigdataCoefficientRec);
    }
}
