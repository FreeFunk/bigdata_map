package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.BigdataFatigueAnalysis;
import com.edgedo.bigdata.entity.BigdataFatigueAnalysisSumCount;
import com.edgedo.bigdata.entity.BigdataOverspeedAnalysisSumCount;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisSumCountView;
import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.bigdata.service.BigdataFatigueAnalysisService;
import com.edgedo.bigdata.service.BigdataFatigueAnalysisSumCountService;
import com.edgedo.bigdata.service.BigdataOverspeedAnalysisSumCountService;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//疲劳驾驶分析
@ConditionalOnProperty(
        value = {"timetask.analysis.BigdataAnalysisFatigue.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisFatigue {

    @Autowired
    BigdataFatigueAnalysisService bigdataFatigueAnalysisService;
    @Autowired
    BigdataFatigueAnalysisSumCountService fatigueAnalysisSumCountService;
    @Autowired
    BigdataAlarmRecordService bigdataAlarmRecordService;

    SimpleDateFormat sdfMonthInt = new SimpleDateFormat("yyyyMM");

    SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

    //@Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisFatigue.cron.execute}")
    public void execute(){
        /*String startDateStr = "2019-05-09";
        Date startDate = DateUtil.getDateByString(startDateStr,"yyyy-MM-dd");
        int daysBetween  = DateUtil.getDaysBetween(startDate,new Date());
        for(int i = 0;i<=daysBetween;i++){
            countByDate(startDate);
             startDate =DateUtil.getNextDayDate(startDate);
        }*/
        countByDate(DateUtil.getLastDayDate(new Date()));
        countByDate(new Date());

    }

    /**
     * 疲劳驾驶的年度统计
     */
    //@Scheduled(cron = "0 52 23 * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisFatigue.cron.fatigueSumCount}")
    public void fatigueSumCount(){
        Date cur = new Date();
        String monthIntStr = sdfMonthInt.format(cur);
        int monthInt = new Integer(monthIntStr);
        //总的疲劳月度统计
        BigdataFatigueAnalysisSumCountView fatigueSumCountMonthAll =
                new BigdataFatigueAnalysisSumCountView(monthInt,"month","总",cur);
        //总的疲劳统计
        BigdataFatigueAnalysisSumCountView fatigueSumCountMonthWeihuo =
                new BigdataFatigueAnalysisSumCountView(monthInt,"month","危货",cur);
        //总的疲劳统计
        BigdataFatigueAnalysisSumCountView fatigueSumCountMonthPuhuo =
                new BigdataFatigueAnalysisSumCountView(monthInt,"month","普货",cur);
        //总的疲劳统计
        BigdataFatigueAnalysisSumCountView fatigueSumCountMonthKeyun =
                new BigdataFatigueAnalysisSumCountView(monthInt,"month","客运",cur);

        //根据车辆类型分组统计
        List<BigdataFatigueAnalysis> listMonth = bigdataFatigueAnalysisService.selectGroupSumCountMonth(monthInt);
        for(BigdataFatigueAnalysis bigdataFatigueAnalysis : listMonth){
            String carType = bigdataFatigueAnalysis.getCarType();
            BigdataFatigueAnalysisSumCount sumCount = null;
            if(carType.equals("总")){
                sumCount =  fatigueSumCountMonthAll;
            }else if(carType.equals("危货")){
                sumCount =  fatigueSumCountMonthWeihuo;
            }else if(carType.equals("客运")){
                sumCount =  fatigueSumCountMonthKeyun;
            }else if(carType.equals("普货")){
                sumCount =  fatigueSumCountMonthPuhuo;
            }
            //查出来赋值
            if(bigdataFatigueAnalysis.getSumFatigueMileage()!=null) {
                sumCount.setSumFatigueMileage(bigdataFatigueAnalysis.getSumFatigueMileage());
            }else{
                sumCount.setSumFatigueMileage(new BigDecimal(0));
            }
            if(bigdataFatigueAnalysis.getSumFatigueNum()!=null){
                sumCount.setSumFatigueNum(bigdataFatigueAnalysis.getSumFatigueNum());
            }else{
                sumCount.setSumFatigueNum(0);
            }

            if(bigdataFatigueAnalysis.getSumFatigueTime()!=null){
                sumCount.setSumFatigueTime(bigdataFatigueAnalysis.getSumFatigueTime());
            }else{
                sumCount.setSumFatigueTime(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumNightFatigueMileage()!=null){
                sumCount.setSumNightFatigueMileage(bigdataFatigueAnalysis.getSumNightFatigueMileage());
            }else{
                sumCount.setSumNightFatigueMileage(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumNightFatigueNum()!=null){
                sumCount.setSumNightFatigueNum(bigdataFatigueAnalysis.getSumNightFatigueNum());
            }else{
                sumCount.setSumNightFatigueNum(0);
            }

            if(bigdataFatigueAnalysis.getSumNightFatigueTime()!=null){
                sumCount.setSumNightFatigueTime(bigdataFatigueAnalysis.getSumNightFatigueTime());
            }else{
                sumCount.setSumNightFatigueTime(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumSeriousFatigueMileage()!=null){
                sumCount.setSumSeriousFatigueMileage(bigdataFatigueAnalysis.getSumSeriousFatigueMileage());
            }else{
                sumCount.setSumSeriousFatigueMileage(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumSeriousFatigueNum()!=null){
                sumCount.setSumSeriousFatigueNum(bigdataFatigueAnalysis.getSumSeriousFatigueNum());
            }else{
                sumCount.setSumSeriousFatigueNum(0);
            }

            if(bigdataFatigueAnalysis.getSumSeriousFatigueTime()!=null){
                sumCount.setSumSeriousFatigueTime(bigdataFatigueAnalysis.getSumSeriousFatigueTime());
            }else{
                sumCount.setSumSeriousFatigueTime(new BigDecimal(0));
            }

            //有就更新，没有就新增
            fatigueAnalysisSumCountService.addOrUpdate(sumCount);

        }

        //总的疲劳月度统计
        BigdataFatigueAnalysisSumCountView fatigueSumCountYearAll =
                new BigdataFatigueAnalysisSumCountView(monthInt,"year","总",cur);
        //总的疲劳统计
        BigdataFatigueAnalysisSumCountView fatigueSumCountYearWeihuo =
                new BigdataFatigueAnalysisSumCountView(monthInt,"year","危货",cur);
        //总的疲劳统计
        BigdataFatigueAnalysisSumCountView fatigueSumCountYearPuhuo =
                new BigdataFatigueAnalysisSumCountView(monthInt,"year","普货",cur);
        //总的疲劳统计
        BigdataFatigueAnalysisSumCountView fatigueSumCountYearKeyun =
                new BigdataFatigueAnalysisSumCountView(monthInt,"year","客运",cur);
        //把月度的信息分组查出来
        List<BigdataFatigueAnalysisSumCount> listYearCount = fatigueAnalysisSumCountService.selectGroupYearSumCount(monthInt/100);
        for(BigdataFatigueAnalysisSumCount bigdataFatigueAnalysis : listYearCount){
            String carType = bigdataFatigueAnalysis.getCarType();
            BigdataFatigueAnalysisSumCount sumCount = null;
            if(carType.equals("总")){
                sumCount =  fatigueSumCountYearAll;
            }else if(carType.equals("危货")){
                sumCount =  fatigueSumCountYearWeihuo;
            }else if(carType.equals("客运")){
                sumCount =  fatigueSumCountYearKeyun;
            }else if(carType.equals("普货")){
                sumCount =  fatigueSumCountYearPuhuo;
            }
            //查出来赋值
            if(bigdataFatigueAnalysis.getSumFatigueMileage()!=null){
                sumCount.setSumFatigueMileage(bigdataFatigueAnalysis.getSumFatigueMileage());
            }else{
                sumCount.setSumFatigueMileage(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumFatigueNum()!=null){
                sumCount.setSumFatigueNum(bigdataFatigueAnalysis.getSumFatigueNum());
            }else{
                sumCount.setSumFatigueNum(bigdataFatigueAnalysis.getSumFatigueNum());
            }

            if(bigdataFatigueAnalysis.getSumFatigueTime()!=null){
                sumCount.setSumFatigueTime(bigdataFatigueAnalysis.getSumFatigueTime());
            }else{
                sumCount.setSumFatigueTime(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumNightFatigueMileage()!=null){
                sumCount.setSumNightFatigueMileage(bigdataFatigueAnalysis.getSumNightFatigueMileage());
            }else{
                sumCount.setSumNightFatigueMileage(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumNightFatigueNum()!=null){
                sumCount.setSumNightFatigueNum(bigdataFatigueAnalysis.getSumNightFatigueNum());
            }else{
                sumCount.setSumNightFatigueNum(0);
            }
            if(bigdataFatigueAnalysis.getSumNightFatigueTime()!=null){
                sumCount.setSumNightFatigueTime(bigdataFatigueAnalysis.getSumNightFatigueTime());
            }else{
                sumCount.setSumNightFatigueTime(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumSeriousFatigueMileage()!=null){
                sumCount.setSumSeriousFatigueMileage(bigdataFatigueAnalysis.getSumSeriousFatigueMileage());
            }else{
                sumCount.setSumSeriousFatigueMileage(new BigDecimal(0));
            }

            if(bigdataFatigueAnalysis.getSumSeriousFatigueNum()!=null){
                sumCount.setSumSeriousFatigueNum(bigdataFatigueAnalysis.getSumSeriousFatigueNum());
            }else{
                sumCount.setSumSeriousFatigueNum(0);
            }

            if(bigdataFatigueAnalysis.getSumSeriousFatigueTime()!=null){
                sumCount.setSumSeriousFatigueTime(bigdataFatigueAnalysis.getSumSeriousFatigueTime());
            }else{
                sumCount.setSumSeriousFatigueTime(new BigDecimal(0));
            }

            //有就更新，没有就新增
            fatigueAnalysisSumCountService.addOrUpdate(sumCount);

        }



    }

    public void countByDate(Date date){

        try{
            //总
            analysisFatigue(date,"总");
            analysisSeriousFatigue(date,"总");
            analysisDangerTimeFatigue(date,"总");
            //客运
            analysisFatigue(date,"客运");
            analysisSeriousFatigue(date,"客运");
            analysisDangerTimeFatigue(date,"客运");
            //普货
            analysisFatigue(date,"普货");
            analysisSeriousFatigue(date,"普货");
            analysisDangerTimeFatigue(date,"普货");
            //危货
            analysisFatigue(date,"危货");
            analysisSeriousFatigue(date,"危货");
            analysisDangerTimeFatigue(date,"危货");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //疲劳分析
    public void analysisFatigue(Date date,String carType){

        BigdataAlarmRecordQuery bigdataAlarmRecordQuery = new BigdataAlarmRecordQuery();
        bigdataAlarmRecordQuery.getQueryObj().setAlarmCls("2");
        bigdataAlarmRecordQuery.getQueryObj().setAlarmType("4");
        //bigdataAlarmRecordQuery.getQueryObj().setAlarmTime(date);
        String dateIntStr = sdfDateInt.format(date);
        Integer dateInt = new Integer(dateIntStr);
        bigdataAlarmRecordQuery.getQueryObj().setCountDate(dateInt);
        bigdataAlarmRecordQuery.getQueryObj().setCountMonth(dateInt/100);
        if(carType!=null && !carType.equals("总")){
            bigdataAlarmRecordQuery.getQueryObj().setCarType(carType);
        }
       /* //统计疲劳总次数
        int countNum = bigdataAlarmRecordService.countByQueryNew(bigdataAlarmRecordQuery);*/
        //统计疲劳总车辆
        int countNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //统计总的疲劳时长
        //int countTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);

        BigdataFatigueAnalysis bigdataFatigueAnalysis = new BigdataFatigueAnalysis();
        bigdataFatigueAnalysis.setCountTime(date);
        bigdataFatigueAnalysis.setCarType(carType);
        //疲劳次数
        bigdataFatigueAnalysis.setSumFatigueNum(countNum);
        //疲劳时长转为小时
       /* DecimalFormat df = new DecimalFormat("#.00");
        double t4 =Double.valueOf(df.format( (double)countTime/(double)3600));
        bigdataFatigueAnalysis.setSumFatigueTime(new BigDecimal(t4));*/

        bigdataFatigueAnalysisService.addOrUpdate(bigdataFatigueAnalysis);
    }
    //严重疲劳
    public void analysisSeriousFatigue(Date date,String carType){

        BigdataAlarmRecordQuery bigdataAlarmRecordQuery = new BigdataAlarmRecordQuery();
        bigdataAlarmRecordQuery.getQueryObj().setAlarmCls("2");
        bigdataAlarmRecordQuery.getQueryObj().setAlarmType("4");
//        bigdataAlarmRecordQuery.getQueryObj().setAlarmTime(date);
        String dateIntStr = sdfDateInt.format(date);
        Integer dateInt = new Integer(dateIntStr);
        bigdataAlarmRecordQuery.getQueryObj().setCountDate(dateInt);
        bigdataAlarmRecordQuery.getQueryObj().setCountMonth(dateInt/100);
        if(carType!=null && !carType.equals("总")){
            bigdataAlarmRecordQuery.getQueryObj().setCarType(carType);
        }
        //统计疲劳总次数
        int countNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //统计严重疲劳总次数
        int countSeriousNum = bigdataAlarmRecordService.countSeriousByQueryNew(bigdataAlarmRecordQuery);
        //统计严重疲劳时长
        /*int countSeriousTime = bigdataAlarmRecordService.sumSeriousByQuery(bigdataAlarmRecordQuery);*/

        BigdataFatigueAnalysis bigdataFatigueAnalysis = new BigdataFatigueAnalysis();
        bigdataFatigueAnalysis.setCountTime(date);
        bigdataFatigueAnalysis.setCarType(carType);
        //严重疲劳次数
        bigdataFatigueAnalysis.setSumSeriousFatigueNum(countSeriousNum);
        //严重疲劳时长转为小时
        DecimalFormat df = new DecimalFormat("#.00");
       /* double t4 =Double.valueOf(df.format( (double)countSeriousTime/(double)3600));
        bigdataFatigueAnalysis.setSumSeriousFatigueTime(new BigDecimal(t4));*/
        //严重疲劳占比
        if(countNum!=0){
            //严重占比
            double f1 = Double.valueOf(df.format((double)countSeriousNum/(double)countNum));
            bigdataFatigueAnalysis.setSeriousFatigueRate(new BigDecimal(String.valueOf(f1)));
        }else {
            bigdataFatigueAnalysis.setSeriousFatigueRate(new BigDecimal(0));
        }
        bigdataFatigueAnalysisService.addOrUpdate(bigdataFatigueAnalysis);
    }
    //危险时段疲劳分析
    public void analysisDangerTimeFatigue(Date date,String carType){

        BigdataAlarmRecordQuery bigdataAlarmRecordQuery = new BigdataAlarmRecordQuery();
        bigdataAlarmRecordQuery.getQueryObj().setAlarmCls("2");
        bigdataAlarmRecordQuery.getQueryObj().setAlarmType("4");
//        bigdataAlarmRecordQuery.getQueryObj().setAlarmTime(date);
        String dateIntStr = sdfDateInt.format(date);
        Integer dateInt = new Integer(dateIntStr);
        bigdataAlarmRecordQuery.getQueryObj().setCountDate(dateInt);
        bigdataAlarmRecordQuery.getQueryObj().setCountMonth(dateInt/100);
        if(carType!=null && !carType.equals("总")){
            bigdataAlarmRecordQuery.getQueryObj().setCarType(carType);
        }
        //统计疲劳总次数
        int countNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        bigdataAlarmRecordQuery.getQueryObj().setDangerTimeFlag("1");
        //统计危险时段疲劳总次数
        int countDangerTimeNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //统计危险时段疲劳时长
        /*int countDangerTimeTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);*/
        //统计非危险时段疲劳车数

        int otherDangerTimeNum = bigdataAlarmRecordService.countNotCarNumByQuery(bigdataAlarmRecordQuery);

        BigdataFatigueAnalysis bigdataFatigueAnalysis = new BigdataFatigueAnalysis();
        bigdataFatigueAnalysis.setCountTime(date);
        bigdataFatigueAnalysis.setCarType(carType);
        //危险时段疲劳次数
        bigdataFatigueAnalysis.setSumNightFatigueNum(countDangerTimeNum);
        bigdataFatigueAnalysis.setSumNightFatigueNumNo(otherDangerTimeNum);
        //危险时段疲劳时长转为小时
        DecimalFormat df = new DecimalFormat("#.00");
        //double t4 =Double.valueOf(df.format( (double)countDangerTimeTime/(double)3600));
        //bigdataFatigueAnalysis.setSumNightFatigueTime(new BigDecimal(t4));
        //危险时段占比
        if(countNum!=0){
            //危险占比
            double f1 = Double.valueOf(df.format((double)countDangerTimeNum/(double)countNum));
            //非危险时段占比
            double f2 = Double.valueOf(df.format((double)otherDangerTimeNum/(double)countNum));
            bigdataFatigueAnalysis.setNightFatigueRate(new BigDecimal(String.valueOf(f1)));
            bigdataFatigueAnalysis.setNightFatigueNoRate(new BigDecimal(String.valueOf(f2)));
        }else {
            bigdataFatigueAnalysis.setNightFatigueRate(new BigDecimal(0));
            bigdataFatigueAnalysis.setNightFatigueNoRate(new BigDecimal(0));
        }
        bigdataFatigueAnalysisService.addOrUpdate(bigdataFatigueAnalysis);
    }
}
