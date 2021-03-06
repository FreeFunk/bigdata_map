package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordView;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisSumCountView;
import com.edgedo.bigdata.service.*;
import com.edgedo.common.util.BaiDuMapApiUtil;
import com.edgedo.common.util.MapPointInfo;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * θΆιεζ
 */
@ConditionalOnProperty(
        value = {"timetask.analysis.BigdataAnalysisOverspeed.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisOverspeed {

    @Autowired
    BigdataOverspeedAnalysisService bigdataOverspeedAnalysisService;
    @Autowired
    BigdataAlarmRecordService bigdataAlarmRecordService;
    @Autowired
    BaiDuMapApiUtil baiDuMapApiUtil;
    @Autowired
    BigdataOverspeedAnalysisSumCountService analysisSumCountService;
    @Value("${localcityname}")
    String localcityname ;
    @Autowired
    BigdataDangerRoadClsMonthService bigdataDangerRoadClsMonthService;
    @Autowired
    BigdataDangerRoadAnalysisService bigdataDangerRoadAnalysisService;

    SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

    //@Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisOverspeed.cron.execute}")
    public void execute(){
        /*String startDateStr = "2019-05-09";
        Date startDate = DateUtil.getDateByString(startDateStr,"yyyy-MM-dd");
        int daysBetween  = DateUtil.getDaysBetween(startDate,new Date());
        for(int i = 0;i<=daysBetween;i++){
            countByDate(startDate);
            startDate =DateUtil.getNextDayDate(startDate);
        }*/
        //countByDate(DateUtil.getLastDayDate(new Date()));
        countByDate(new Date());
    }

    /**
     * θΆιζ±ζ»η»θ?‘
     */
    //@Scheduled(cron = "0 52 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisOverspeed.cron.overSpeedSumCount}")
    public void overSpeedSumCount(){
        Date cur = new Date();
        String dateIntStr = sdfDateInt.format(cur);
        String monthIntStr = dateIntStr.substring(0,6);
        //ζ»ηθ½¦θΎη±»εζ±ζ»
        BigdataOverspeedAnalysisSumCountView overspeedSumCountMonthAll = new BigdataOverspeedAnalysisSumCountView();
        overspeedSumCountMonthAll.initData("month", "ζ»",new Integer(monthIntStr),cur);
        //ε±θ΄§ηθ½¦θΎη±»εζ±ζ»
        BigdataOverspeedAnalysisSumCountView overspeedSumCountMonthWeihuo = new BigdataOverspeedAnalysisSumCountView();
        overspeedSumCountMonthWeihuo.initData("month", "ε±θ΄§",new Integer(monthIntStr),cur);
        //ζ?θ΄§θ½¦θΎη±»εζ±ζ»
        BigdataOverspeedAnalysisSumCountView overspeedSumCountMonthPuhuo = new BigdataOverspeedAnalysisSumCountView();
        overspeedSumCountMonthPuhuo.initData("month", "ζ?θ΄§",new Integer(monthIntStr),cur);
        //ε?’θΏθ½¦θΎη±»εζ±ζ»
        BigdataOverspeedAnalysisSumCountView overspeedSumCountMonthKeyun = new BigdataOverspeedAnalysisSumCountView();
        overspeedSumCountMonthKeyun.initData("month", "ε?’θΏ",new Integer(monthIntStr),cur);
        int monthInt = new Integer(monthIntStr);
        //ζ Ήζ?θ½¦θΎη±»εεη»ζ±ζ»
        List<BigdataOverspeedAnalysis> groupList = bigdataOverspeedAnalysisService.selectSumGroupByCarTypeMonth(monthInt);
        for(BigdataOverspeedAnalysis monthAnalysis : groupList ){
            BigdataOverspeedAnalysisSumCountView temSum = null;
            String carType = monthAnalysis.getCarType();
            if(carType.equals("ζ?θ΄§")){
                temSum = overspeedSumCountMonthPuhuo;
            }else if(carType.equals("ε±θ΄§")){
                temSum = overspeedSumCountMonthWeihuo;
            }else if(carType.equals("ε?’θΏ")){
                temSum = overspeedSumCountMonthKeyun;
            }else if(carType.equals("ζ»")){
                temSum = overspeedSumCountMonthAll;
            }
            if(monthAnalysis.getSumSeriousOverspeedTime()!=null)
            temSum.setSumSeriousOverspeedTime(monthAnalysis.getSumSeriousOverspeedTime());
            if(monthAnalysis.getSumSeriousOverspeedNum()!=null)
            temSum.setSumSeriousOverspeedNum(monthAnalysis.getSumSeriousOverspeedNum());
            if(monthAnalysis.getSumSeriousOverspeedMileage()!=null)
            temSum.setSumSeriousOverspeedMileage(monthAnalysis.getSumSeriousOverspeedMileage());
            if(monthAnalysis.getSumOverspeedTime()!=null)
            temSum.setSumOverspeedTime(monthAnalysis.getSumOverspeedTime());
            if(monthAnalysis.getSumOverspeedNum()!=null)
            temSum.setSumOverspeedNum(monthAnalysis.getSumOverspeedNum());
            if(monthAnalysis.getSumOverspeedMileage()!=null)
            temSum.setSumOverspeedMileage(monthAnalysis.getSumOverspeedMileage());
            if(monthAnalysis.getSumNightOverspeedTime()!=null)
            temSum.setSumNightOverspeedTime(monthAnalysis.getSumNightOverspeedTime());
            if(monthAnalysis.getSumNightOverspeedNum()!=null)
            temSum.setSumNightOverspeedNum(monthAnalysis.getSumNightOverspeedNum());
            if(monthAnalysis.getSumNightOverspeedMileage()!=null)
            temSum.setSumNightOverspeedMileage(monthAnalysis.getSumNightOverspeedMileage());
            //ζε°±ζ΄ζ°
            //ζ²‘ζε°±ζ°ε’
            analysisSumCountService.addOrUpdate(temSum);
        }

        //ζ»ηθ½¦θΎη±»εζ±ζ»
        BigdataOverspeedAnalysisSumCountView overspeedSumCountYearAll = new BigdataOverspeedAnalysisSumCountView();
        overspeedSumCountYearAll.initData("year", "ζ»",new Integer(monthIntStr),cur);
        //ε±θ΄§ηθ½¦θΎη±»εζ±ζ»
        BigdataOverspeedAnalysisSumCountView overspeedSumCountYearWeihuo = new BigdataOverspeedAnalysisSumCountView();
        overspeedSumCountYearWeihuo.initData("year", "ε±θ΄§",new Integer(monthIntStr),cur);
        //ζ?θ΄§θ½¦θΎη±»εζ±ζ»
        BigdataOverspeedAnalysisSumCountView overspeedSumCountYearPuhuo = new BigdataOverspeedAnalysisSumCountView();
        overspeedSumCountYearPuhuo.initData("year", "ζ?θ΄§",new Integer(monthIntStr),cur);
        //ε?’θΏθ½¦θΎη±»εζ±ζ»
        BigdataOverspeedAnalysisSumCountView overspeedSumCountYearKeyun = new BigdataOverspeedAnalysisSumCountView();
        overspeedSumCountYearKeyun.initData("year", "ε?’θΏ",new Integer(monthIntStr),cur);

        List<BigdataOverspeedAnalysisSumCount > yearGroupList = analysisSumCountService.selectSumGroupByCarTypeYear(monthInt/100);
        for(BigdataOverspeedAnalysisSumCount yearAnalysis : yearGroupList ){
            BigdataOverspeedAnalysisSumCountView temSum = null;
            String carType = yearAnalysis.getCarType();
            if(carType.equals("ζ?θ΄§")){
                temSum = overspeedSumCountYearPuhuo;
            }else if(carType.equals("ε±θ΄§")){
                temSum = overspeedSumCountYearWeihuo;
            }else if(carType.equals("ε?’θΏ")){
                temSum = overspeedSumCountYearKeyun;
            }else if(carType.equals("ζ»")){
                temSum = overspeedSumCountYearAll;
            }
            if(yearAnalysis.getSumSeriousOverspeedTime()!=null)
                temSum.setSumSeriousOverspeedTime(yearAnalysis.getSumSeriousOverspeedTime());
            if(yearAnalysis.getSumSeriousOverspeedNum()!=null)
                temSum.setSumSeriousOverspeedNum(yearAnalysis.getSumSeriousOverspeedNum());
            if(yearAnalysis.getSumSeriousOverspeedMileage()!=null)
                temSum.setSumSeriousOverspeedMileage(yearAnalysis.getSumSeriousOverspeedMileage());
            if(yearAnalysis.getSumOverspeedTime()!=null)
                temSum.setSumOverspeedTime(yearAnalysis.getSumOverspeedTime());
            if(yearAnalysis.getSumOverspeedNum()!=null)
                temSum.setSumOverspeedNum(yearAnalysis.getSumOverspeedNum());
            if(yearAnalysis.getSumOverspeedMileage()!=null)
                temSum.setSumOverspeedMileage(yearAnalysis.getSumOverspeedMileage());
            if(yearAnalysis.getSumNightOverspeedTime()!=null)
                temSum.setSumNightOverspeedTime(yearAnalysis.getSumNightOverspeedTime());
            if(yearAnalysis.getSumNightOverspeedNum()!=null)
                temSum.setSumNightOverspeedNum(yearAnalysis.getSumNightOverspeedNum());
            if(yearAnalysis.getSumNightOverspeedMileage()!=null)
                temSum.setSumNightOverspeedMileage(yearAnalysis.getSumNightOverspeedMileage());
            //ζε°±ζ΄ζ°
            //ζ²‘ζε°±ζ°ε’
            analysisSumCountService.addOrUpdate(temSum);
        }

    }

    public void countByDate(Date date){

        try{
            //ζ»
            analysisOverspeed(date,"ζ»");
            analysisSeriousOverspeed(date,"ζ»");
            analysisDangerTimeOverspeed(date,"ζ»");
            //ε?’θΏ
            analysisOverspeed(date,"ε?’θΏ");
            analysisSeriousOverspeed(date,"ε?’θΏ");
            analysisDangerTimeOverspeed(date,"ε?’θΏ");
            //ζ?θ΄§
            analysisOverspeed(date,"ζ?θ΄§");
            analysisSeriousOverspeed(date,"ζ?θ΄§");
            analysisDangerTimeOverspeed(date,"ζ?θ΄§");
            //ε±θ΄§
            analysisOverspeed(date,"ε±θ΄§");
            analysisSeriousOverspeed(date,"ε±θ΄§");
            analysisDangerTimeOverspeed(date,"ε±θ΄§");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //θΆιεζ
    public void analysisOverspeed(Date date,String carType){

        BigdataAlarmRecordQuery bigdataAlarmRecordQuery = new BigdataAlarmRecordQuery();
        bigdataAlarmRecordQuery.getQueryObj().setAlarmCls("1");
        bigdataAlarmRecordQuery.getQueryObj().setAlarmType("2");
        //bigdataAlarmRecordQuery.getQueryObj().setAlarmTime(date);
        String dateIntStr = sdfDateInt.format(date);
        Integer dateInt = new Integer(dateIntStr);
        bigdataAlarmRecordQuery.getQueryObj().setCountDate(dateInt);
        bigdataAlarmRecordQuery.getQueryObj().setCountMonth(dateInt/100);


        if(carType!=null && !carType.equals("ζ»")){
            bigdataAlarmRecordQuery.getQueryObj().setCarType(carType);
        }
       /* //η»θ?‘θΆιζ»ζ¬‘ζ°
        int countNum = bigdataAlarmRecordService.countByQuery(bigdataAlarmRecordQuery);*/
        //η»θ?‘θΆιηθ½¦θΎζ°
        int countCarNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //η»θ?‘ζ»ηθΆιζΆιΏ
        int countTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);
       /* 41000 ι«ιε¬θ·―,42000 ε½ι,43000 δΈ»θ¦ε€§θ‘γεεΈεΏ«ιθ·―,51000 ηι,
                44000 δΈ»θ¦ιθ·―,45000  ζ¬‘θ¦ιθ·―,52000 δΉ‘ε¬θ·―,53000 εΏδΉ‘ζει¨ιθ·―
        54000 εΏδΉ‘ζει¨ιθ·―,47000 ζ?ιιθ·―,49 ιε―Όθͺιθ·―*/
       /* bigdataAlarmRecordQuery.getQueryObj().setRoadLevel("42000");
        //ε½ιθΆιζ¬‘ζ°
        int nationalNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //ε½ιθΆιζΆιΏ
        int nationalTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);*/

        bigdataAlarmRecordQuery.getQueryObj().setRoadLevel("41000");
        //ι«ιθΆιζ¬‘ζ°
        int highSpeedNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //ι«ιθΆιζΆιΏ
        int highSpeedTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);

     /*   //η»θ?‘εΆδ»ιθ·―ηθΆιζ¬‘ζ°
        int otherNum =countCarNum-nationalNum-highSpeedNum;
        //η»θ?‘εΆδ»ιθ·―ηθΆιζΆιΏ
        int otherTime = countTime-nationalTime-highSpeedTime;*/

        //η»θ?‘ιι«ιηθΆιθ½¦θΎζ°
        int otherNum = bigdataAlarmRecordService.countNotOverSpeedCarNumByQuery(bigdataAlarmRecordQuery);
        //η»θ?‘εΆδ»ιθ·―ηθΆιζΆιΏ
        //ι«ιθΆιζΆιΏ
        int otherTime = bigdataAlarmRecordService.sumNotOverSpeedByQuery(bigdataAlarmRecordQuery);

        BigdataOverspeedAnalysis bigdataOverspeedAnalysis = new BigdataOverspeedAnalysis();
        bigdataOverspeedAnalysis.setCountTime(date);
        bigdataOverspeedAnalysis.setCarType(carType);
        //θΆιζ¬‘ζ°
        //bigdataOverspeedAnalysis.setNationalOverspeedNum(nationalNum);
         bigdataOverspeedAnalysis.setHighOverspeedNum(highSpeedNum);
        bigdataOverspeedAnalysis.setOtherOverspeedNum(otherNum);
        bigdataOverspeedAnalysis.setSumOverspeedNum(countCarNum);
        //θΆιζΆιΏθ½¬δΈΊε°ζΆ
        DecimalFormat df = new DecimalFormat("#.00");
        //double t1 = Double.valueOf(df.format((double)nationalTime/(double)3600));
        double t2 =Double.valueOf(df.format( (double)highSpeedTime/(double)3600));
        double t3 =Double.valueOf(df.format( (double)otherTime/(double)3600));
        double t4 =Double.valueOf(df.format( (double)countTime/(double)3600));
        //bigdataOverspeedAnalysis.setNationalOverspeedTime(new BigDecimal(String.valueOf(t1)));
        bigdataOverspeedAnalysis.setHighOverspeedTime(new BigDecimal(String.valueOf(t2)));
        bigdataOverspeedAnalysis.setOtherOverspeedTime(new BigDecimal(String.valueOf(t3)));
        bigdataOverspeedAnalysis.setSumOverspeedTime(new BigDecimal(String.valueOf(t4)));
        //θΆιε ζ―
        if(countCarNum!=0){
            //ε½ιιε ζ―
            //double f1 = Double.valueOf(df.format((double)nationalNum/(double)countCarNum));
            //ι«ιε ζ―
            double f2 =Double.valueOf(df.format( (double)highSpeedNum/(double)countCarNum));
            //εΆδ»ιθ·―ε ζ―
            double f3 =Double.valueOf(df.format( (double)otherNum/(double)countCarNum));
            //double f3 = 1.00-f1-f2;
            //bigdataOverspeedAnalysis.setNationalOverspeedRate(new BigDecimal(String.valueOf(f1)));
            bigdataOverspeedAnalysis.setHighOverspeedRate(new BigDecimal(String.valueOf(f2)));
            bigdataOverspeedAnalysis.setOtherOverspeedRate(new BigDecimal(String.valueOf(f3)));
        }else {
            bigdataOverspeedAnalysis.setNationalOverspeedRate(new BigDecimal(0));
            bigdataOverspeedAnalysis.setHighOverspeedRate(new BigDecimal(0));
            bigdataOverspeedAnalysis.setOtherOverspeedRate(new BigDecimal(0));
        }
        bigdataOverspeedAnalysisService.addOrUpdate(bigdataOverspeedAnalysis);
    }
    //δΈ₯ιθΆι
    public void analysisSeriousOverspeed(Date date,String carType){

        BigdataAlarmRecordQuery bigdataAlarmRecordQuery = new BigdataAlarmRecordQuery();
        bigdataAlarmRecordQuery.getQueryObj().setAlarmCls("1");
        bigdataAlarmRecordQuery.getQueryObj().setAlarmType("2");
        //bigdataAlarmRecordQuery.getQueryObj().setAlarmTime(date);
        String dateIntStr = sdfDateInt.format(date);
        Integer dateInt = new Integer(dateIntStr);
        bigdataAlarmRecordQuery.getQueryObj().setCountDate(dateInt);
        bigdataAlarmRecordQuery.getQueryObj().setCountMonth(dateInt/100);
        if(carType!=null && !carType.equals("ζ»")){
            bigdataAlarmRecordQuery.getQueryObj().setCarType(carType);
        }
        //η»θ?‘θΆιηθ½¦θΎζ°
        int countCarNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        bigdataAlarmRecordQuery.getQueryObj().setSeriousFlag("1");
        //η»θ?‘δΈ₯ιθΆιζ»ζ¬‘ζ°
        int countSeriousNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //η»θ?‘δΈ₯ιθΆιζΆιΏ
        int countSeriousTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);
       /* 41000 ι«ιε¬θ·―,42000 ε½ι,43000 δΈ»θ¦ε€§θ‘γεεΈεΏ«ιθ·―,51000 ηι,
                44000 δΈ»θ¦ιθ·―,45000  ζ¬‘θ¦ιθ·―,52000 δΉ‘ε¬θ·―,53000 εΏδΉ‘ζει¨ιθ·―
        54000 εΏδΉ‘ζει¨ιθ·―,47000 ζ?ιιθ·―,49 ιε―Όθͺιθ·―*/
      /*  bigdataAlarmRecordQuery.getQueryObj().setRoadLevel("42000");
        //ε½ιδΈ₯ιθΆιζ¬‘ζ°
        int nationalSeriousNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //ε½ιδΈ₯ιθΆιζΆιΏ
        int nationalSeriousTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);
*/
        bigdataAlarmRecordQuery.getQueryObj().setRoadLevel("41000");
        //ι«ιδΈ₯ιθΆιζ¬‘ζ°
        int highSpeedSeriousNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //ι«ιδΈ₯ιθΆιζΆιΏ
        int highSpeedSeriousTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);

        //η»θ?‘εΆδ»ιθ·―ηδΈ₯ιθΆιζ¬‘ζ°
        int otherSeriousNum =countSeriousNum-highSpeedSeriousNum;
        //η»θ?‘εΆδ»ιθ·―ηδΈ₯ιθΆιζΆιΏ
        int otherSeriousTime = countSeriousTime-highSpeedSeriousTime;
      /*  //η»θ?‘εΆδ»ιθ·―ηδΈ₯ιθΆιζ¬‘ζ°
        int otherSeriousNum =countSeriousNum-nationalSeriousNum-highSpeedSeriousNum;
        //η»θ?‘εΆδ»ιθ·―ηδΈ₯ιθΆιζΆιΏ
        int otherSeriousTime = countSeriousTime-nationalSeriousTime-highSpeedSeriousTime;*/

        BigdataOverspeedAnalysis bigdataOverspeedAnalysis = new BigdataOverspeedAnalysis();
        bigdataOverspeedAnalysis.setCountTime(date);
        bigdataOverspeedAnalysis.setCarType(carType);
        //δΈ₯ιθΆιζ¬‘ζ°
       // bigdataOverspeedAnalysis.setNationalSeriousOverspeedNum(nationalSeriousNum);
        bigdataOverspeedAnalysis.setHighSeriousOverspeedNum(highSpeedSeriousNum);
        bigdataOverspeedAnalysis.setOtherSeriousOverspeedNum(otherSeriousNum);
        bigdataOverspeedAnalysis.setSumSeriousOverspeedNum(countSeriousNum);
        //δΈ₯ιθΆιζΆιΏθ½¬δΈΊε°ζΆ
        DecimalFormat df = new DecimalFormat("#.00");
        //double t1 = Double.valueOf(df.format((double)nationalSeriousTime/(double)3600));
        double t2 =Double.valueOf(df.format( (double)highSpeedSeriousTime/(double)3600));
        double t3 =Double.valueOf(df.format( (double)otherSeriousTime/(double)3600));
        double t4 =Double.valueOf(df.format( (double)countSeriousTime/(double)3600));
       // bigdataOverspeedAnalysis.setNationalSeriousOverspeedTime(new BigDecimal(String.valueOf(t1)));
        bigdataOverspeedAnalysis.setHighSeriousOverspeedTime(new BigDecimal(String.valueOf(t2)));
        bigdataOverspeedAnalysis.setOtherSeriousOverspeedTime(new BigDecimal(String.valueOf(t3)));
        bigdataOverspeedAnalysis.setSumSeriousOverspeedTime(new BigDecimal(String.valueOf(t4)));
        //δΈ₯ιθΆιε ζ―
        if(countCarNum!=0){
            //δΈ₯ιε ζ―
            double f1 = Double.valueOf(df.format((double)countSeriousNum/(double)countCarNum));
            bigdataOverspeedAnalysis.setSeriousOverspeedRate(new BigDecimal(String.valueOf(f1)));
        }else {
            bigdataOverspeedAnalysis.setSeriousOverspeedRate(new BigDecimal(0));
        }
        bigdataOverspeedAnalysisService.addOrUpdate(bigdataOverspeedAnalysis);
    }
    //ε±ι©ζΆζ?΅θΆιεζ
    public void analysisDangerTimeOverspeed(Date date,String carType){

        BigdataAlarmRecordQuery bigdataAlarmRecordQuery = new BigdataAlarmRecordQuery();
        bigdataAlarmRecordQuery.getQueryObj().setAlarmCls("1");
        bigdataAlarmRecordQuery.getQueryObj().setAlarmType("2");
        //bigdataAlarmRecordQuery.getQueryObj().setAlarmTime(date);
        String dateIntStr = sdfDateInt.format(date);
        Integer dateInt = new Integer(dateIntStr);
        bigdataAlarmRecordQuery.getQueryObj().setCountDate(dateInt);
        bigdataAlarmRecordQuery.getQueryObj().setCountMonth(dateInt/100);
        if(carType!=null && !carType.equals("ζ»")){
            bigdataAlarmRecordQuery.getQueryObj().setCarType(carType);
        }
        /*//η»θ?‘θΆιζ»ζ¬‘ζ°
        int countNum = bigdataAlarmRecordService.countByQuery(bigdataAlarmRecordQuery);*/
        //η»θ?‘θΆιηθ½¦θΎζ°
        int countCarNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        bigdataAlarmRecordQuery.getQueryObj().setDangerTimeFlag("1");
        //η»θ?‘ε±ι©ζΆζ?΅θΆιζ»ζ¬‘ζ°
        int countDangerTimeNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //η»θ?‘ε±ι©ζΆζ?΅θΆιζΆιΏ
        int countDangerTimeTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);
       /* 41000 ι«ιε¬θ·―,42000 ε½ι,43000 δΈ»θ¦ε€§θ‘γεεΈεΏ«ιθ·―,51000 ηι,
                44000 δΈ»θ¦ιθ·―,45000  ζ¬‘θ¦ιθ·―,52000 δΉ‘ε¬θ·―,53000 εΏδΉ‘ζει¨ιθ·―
        54000 εΏδΉ‘ζει¨ιθ·―,47000 ζ?ιιθ·―,49 ιε―Όθͺιθ·―*/
      /*  bigdataAlarmRecordQuery.getQueryObj().setRoadLevel("42000");
        //ε½ιε±ι©ζΆζ?΅θΆιζ¬‘ζ°
        int nationalDangerTimeNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //ε½ιε±ι©ζΆζ?΅θΆιζΆιΏ
        int nationalDangerTimeTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);*/

        bigdataAlarmRecordQuery.getQueryObj().setRoadLevel("41000");
        //ι«ιε±ι©ζΆζ?΅θΆιζ¬‘ζ°
        int highSpeedDangerTimeNum = bigdataAlarmRecordService.countCarNumByQuery(bigdataAlarmRecordQuery);
        //ι«ιε±ι©ζΆζ?΅θΆιζΆιΏ
        int highSpeedDangerTimeTime = bigdataAlarmRecordService.sumByQuery(bigdataAlarmRecordQuery);

        //η»θ?‘εΆδ»ιθ·―ηε±ι©ζΆζ?΅θΆιζ¬‘ζ°
        int otherDangerTimeNum =countDangerTimeNum-highSpeedDangerTimeNum;
        //η»θ?‘εΆδ»ιθ·―ηε±ι©ζΆζ?΅θΆιζΆιΏ
        int otherDangerTimeTime = countDangerTimeTime-highSpeedDangerTimeTime;
    /*    //η»θ?‘εΆδ»ιθ·―ηε±ι©ζΆζ?΅θΆιζ¬‘ζ°
        int otherDangerTimeNum =countDangerTimeNum-nationalDangerTimeNum-highSpeedDangerTimeNum;
        //η»θ?‘εΆδ»ιθ·―ηε±ι©ζΆζ?΅θΆιζΆιΏ
        int otherDangerTimeTime = countDangerTimeTime-nationalDangerTimeTime-highSpeedDangerTimeTime;
*/
        BigdataOverspeedAnalysis bigdataOverspeedAnalysis = new BigdataOverspeedAnalysis();
        bigdataOverspeedAnalysis.setCountTime(date);
        bigdataOverspeedAnalysis.setCarType(carType);
        //ε±ι©ζΆζ?΅θΆιζ¬‘ζ°
        //bigdataOverspeedAnalysis.setNationalNightOverspeedNum(nationalDangerTimeNum);
        bigdataOverspeedAnalysis.setHighNightOverspeedNum(highSpeedDangerTimeNum);
        bigdataOverspeedAnalysis.setOtherNightOverspeedNum(otherDangerTimeNum);
        bigdataOverspeedAnalysis.setSumNightOverspeedNum(countDangerTimeNum);
        //ε±ι©ζΆζ?΅θΆιζΆιΏθ½¬δΈΊε°ζΆ
        DecimalFormat df = new DecimalFormat("#.00");
        //double t1 = Double.valueOf(df.format((double)nationalDangerTimeTime/(double)3600));
        double t2 =Double.valueOf(df.format( (double)highSpeedDangerTimeTime/(double)3600));
        double t3 =Double.valueOf(df.format( (double)otherDangerTimeTime/(double)3600));
        double t4 =Double.valueOf(df.format( (double)countDangerTimeTime/(double)3600));
        //bigdataOverspeedAnalysis.setNationalNightOverspeedTime(new BigDecimal(String.valueOf(t1)));
        bigdataOverspeedAnalysis.setHighNightOverspeedTime(new BigDecimal(String.valueOf(t2)));
        bigdataOverspeedAnalysis.setOtherNightOverspeedTime(new BigDecimal(String.valueOf(t3)));
        bigdataOverspeedAnalysis.setSumNightOverspeedTime(new BigDecimal(String.valueOf(t4)));
        bigdataOverspeedAnalysisService.addOrUpdate(bigdataOverspeedAnalysis);
    }


    @Scheduled(cron = "0 0/2 * * * ?")
    public void synAlarLocation(){
        try {
            Date cur = new Date();
            String countDateStr = sdfDateInt.format(cur);
            Integer countDate = new Integer(countDateStr);
            Integer countMonth = countDate/100;
            //θΆιζ₯θ­¦ηδ½η½?εζ­₯
            //ζ₯εΊ500ζ‘θ°η¨500ζ‘
            List<BigdataAlarmRecord> listAlarm = bigdataAlarmRecordService.listUnLocationAlarm(500,countMonth,countDate);
            for (BigdataAlarmRecord alarmRec : listAlarm) {
                //ζ₯θ―’ηΎεΊ¦api
                BigDecimal lng = alarmRec.getLongitude();
                BigDecimal lat = alarmRec.getLatitude();
                String address = baiDuMapApiUtil.roadSearch(lat+"",lng+"");
                if(address!=null && address.length()>0){
                    BigdataAlarmRecord param = new BigdataAlarmRecord();
                    param.setId(alarmRec.getId());
                    param.setLocationInfoDesc(address);

                    //ζ²³εηεε±±εΈζ»¦εΏ183δΉ‘ι.η¦»ε?εεΊε·₯εεε±(δΈε)ηΊ¦932η±³
                    String simpleAddress = address.replaceAll(".η¦»",".");
                    String regText = "ηΊ¦\\d+η±³";
                    simpleAddress.replaceAll(regText,"");
                    if(simpleAddress.lastIndexOf("(")>0){
                        simpleAddress = simpleAddress.substring(0,simpleAddress.lastIndexOf("("))+"ιθΏ";
                    }else {
                        simpleAddress = simpleAddress + "ιθΏ";
                    }
                    param.setLocationInfoSimple(simpleAddress);
                    param.setIsReadLocation("1");
                    param.setCountMonth(alarmRec.getCountMonth());
                    if(address.indexOf(localcityname)>=0){
                        param.setIsLocalplace("1");
                    }else{
                        param.setIsLocalplace("0");
                    }
                    if(address.indexOf("ι«ι")>=0){
                        param.setIsHighWay("1");
                    }else{
                        param.setIsHighWay("0");
                    }
                    bigdataAlarmRecordService.updateByFenPian(param);
                }


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //ζ¨δΈͺηε―ΉηΎεΊ¦apiζ₯θ―’δ½η½?δΏ‘ζ―

    }

   /* public static void main(String[] args) {
        String regText = "ηΊ¦\\d+η±³";

        String str = "ζ²³εηεε±±εΈζ»¦εΏ183δΉ‘ι.η¦»ε?εεΊε·₯εεε±(δΈε)ηΊ¦932η±³";
        System.out.println(str.replaceAll(regText,""));
        String simpleAddress = str.replaceAll(".η¦»",".");
        simpleAddress = simpleAddress.substring(0,simpleAddress.indexOf("("))+"ιθΏ";
        System.out.println(simpleAddress);
    }*/

   //ζ Ήζ?θΆιηδΏ‘ζ―η»θ?‘ε±ι©
   @Scheduled(cron = "0 0/49 * * * ?")
    public void countDangerRoad(){
        Calendar cal = Calendar.getInstance();
        String dateIntMaxStr = sdfDateInt.format(cal.getTime());
        cal.set(Calendar.DAY_OF_MONTH,1);
        String dateIntMinStr = sdfDateInt.format(cal.getTime());
        Integer dateIntMax = new Integer(dateIntMaxStr);
        Integer dateIntMin = new Integer(dateIntMinStr);
        int countMonth = dateIntMin/100;
        try{
            Map<String,BigdataDangerRoadClsMonth> dangerRoadMap = new HashMap<String,BigdataDangerRoadClsMonth>();
            for(int i=dateIntMin;i<=dateIntMax;i++){
                //ζεΊ¦ζ±ζ»ε±ι©θ·―ζ?΅
                List<BigdataDangerRoadClsMonth> listGroup
                        = bigdataAlarmRecordService.selectGroupCountOfDangerRoad(countMonth,i);
                for(BigdataDangerRoadClsMonth roadCount :  listGroup){
                    String roadName = roadCount.getDangerRoadClsName();
                    BigdataDangerRoadClsMonth mapRoad = dangerRoadMap.get(roadName);
                    if(mapRoad!=null){
                        int num = mapRoad.getDangerRoadPassNum()+roadCount.getDangerRoadPassNum();
                        mapRoad.setDangerRoadPassNum(num);
                    }else{
                        dangerRoadMap.put(roadName , roadCount);
                    }
                }
            }
            Collection<BigdataDangerRoadClsMonth> cls = dangerRoadMap.values();
            Iterator<BigdataDangerRoadClsMonth> it = cls.iterator();
            while(it.hasNext()){
                BigdataDangerRoadClsMonth month = it.next();
                String dangerRoadName = month.getDangerRoadClsName();
                String id = countMonth +"-" + dangerRoadName;
                BigdataDangerRoadClsMonth dbRoad = bigdataDangerRoadClsMonthService.loadById(id);
                if(dbRoad==null){
                    month.setId(id);
                    month.setCountMonth(countMonth);
                    month.setYearNum(countMonth/100);
                    month.setCreateTime(new Date());
                    bigdataDangerRoadClsMonthService.insert(month);
                }else{
                    dbRoad.setDangerRoadPassNum(month.getDangerRoadPassNum());
                    bigdataDangerRoadClsMonthService.update(dbRoad);
                }

            }
            //ζ Ήζ?ζεΊ¦ζ±ζ»ζ»ηε±ι©θ·―ζ?΅ζ°
            List<BigdataDangerRoadClsMonth> dangerList = bigdataDangerRoadClsMonthService.selectGroupByDangerRoadName();
            for(BigdataDangerRoadClsMonth count : dangerList){
                String id = count.getDangerRoadClsName();
                BigdataDangerRoadAnalysis dbAnalysis = bigdataDangerRoadAnalysisService.loadById(id);
                if(dbAnalysis==null){
                    dbAnalysis = new BigdataDangerRoadAnalysis();
                    dbAnalysis.setId(id);
                    dbAnalysis.setDangerRoadNum(count.getDangerRoadPassNum());
                    dbAnalysis.setCountTime(new Date());
                    dbAnalysis.setCreateTime(new Date());
                    dbAnalysis.setDangerRoadCls(count.getDangerRoadClsName());
                    dbAnalysis.setOwnerDangerRoadName(count.getDangerRoadClsName());
                    dbAnalysis.setLatitude(count.getLatitude());
                    dbAnalysis.setLongitude(count.getLongitude());
                    bigdataDangerRoadAnalysisService.insert(dbAnalysis);
                }else{
                    dbAnalysis.setDangerRoadNum(count.getDangerRoadPassNum());
                    bigdataDangerRoadAnalysisService.update(dbAnalysis);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
