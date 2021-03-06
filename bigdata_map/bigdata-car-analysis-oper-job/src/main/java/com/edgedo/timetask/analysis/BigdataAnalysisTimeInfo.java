package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordView;
import com.edgedo.bigdata.queryvo.BigdataTimeAnalysisView;
import com.edgedo.bigdata.service.*;
import com.edgedo.constant.RedisDbKeyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@ConditionalOnProperty(
        value = {"timetask.analysis.BigdataAnalysisTimeInfo.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisTimeInfo {

    @Autowired
    CarInfoService carInfoService;
    @Autowired
    BigdataTimeAnalysisService bigdataTimeAnalysisService;
    @Autowired
    BigdataTimeCarDayRecService bigdataTimeCarDayRecService;
    @Autowired
    BigdataTimeCarSumCountService bigdataTimeCarSumCountService;
    @Autowired
    BigdataAlarmRecordService alarmRecordService;

    //时间格式化工具
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //日期格式化
    private SimpleDateFormat sdfDayInt = new SimpleDateFormat("yyyyMMdd");
    //日期格式化
    private SimpleDateFormat sdfMonthInt = new SimpleDateFormat("yyyyMM");

    //每日生成车辆的时段里程信息
    //@Scheduled(cron = "0 55 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisTimeInfo.cron.carDayTimeInfo}")
    public void  carDayTimeInfo(){
        System.out.println(sdf.format(new Date())+"=====每日生成车辆的时段里程信息=====");
        //如果时间在凌晨0点 5分之前返回s
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minu = cal.get(Calendar.MINUTE);
        int temNum = hour*10 +minu;
        if(temNum<=5){
            return;
        }
        String gpsCarRedsMapKey = RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY;
//        Map<Object,Object> carMap = redisUtil.hmget(gpsCarRedsMapKey);
        //int totalCarNum = carInfoService.countAll();
        int totalCarNum = carInfoService.selectSortNum();
        final int oneNum = 1000;
        int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
        //多线程遍历数据库
        for(int i=0;i<times;i++){
            final int fiIndex = i;
            Date cur = new Date();
            //更新或者插入车辆的历史状态记录 每晚的23点50之后不再更新了
            Calendar temCal = Calendar.getInstance();
            temCal.setTime(cur);
            int hour1 = temCal.get(Calendar.HOUR_OF_DAY);
            int minute = temCal.get(Calendar.MINUTE);
           if(hour1==23 && minute>56){
                continue;
            }
             Thread t = new Thread(){
                @Override
                public void run(){
                    int start = oneNum*fiIndex ;
                    int end = oneNum*(fiIndex+1)-1;
                    List<CarInfo> carList = carInfoService.listByStartAndEndBySortNum(start,end);
                    // 同步位置信息、上线情况、运营情况
                    for(CarInfo car : carList){
                        //将每日的记录更新到记录统计表中
//                        bigdataTimeCarDayRecService.updateSynCarDayRec(car);
                        bigdataTimeCarDayRecService.insertOrUpdateCarDayHis(car,cur);

                    }
                }
            };
            t.start();
        }
    }


    //每日生成车辆的时段里程信息
    //@Scheduled(cron = "0 2/10 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisTimeInfo.cron.carDayTimeOverSpeedAndFatigueInfo}")
    public void  carDayTimeOverSpeedAndFatigueInfo(){
        //如果时间在凌晨0点 5分之前返回
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minu = cal.get(Calendar.MINUTE);
        int temNum = hour*10 +minu;
        if(temNum<=5){
            return;
        }
        Date cur = cal.getTime();
        String dayStr = sdfDayInt.format(cur);
        int dayInt = new Integer(dayStr);
        int monthInt = dayInt/100;
        Map<String,BigdataTimeCarDayRec> timeCarDayRecMap = new HashMap<String,BigdataTimeCarDayRec>();
        //统计超速次数
        List<BigdataAlarmRecordView> overSpeedNumCarList = alarmRecordService.selectGroupCountDayOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : overSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();

            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsOverSpeed("1");
            }else{
                timeCarDayrec.setIsOverSpeed("0");
            }
            timeCarDayrec.setOverSpeedNum(alarmRecordView.getGroupCount());
        }
        overSpeedNumCarList=null;//释放内存o(*￣︶￣*)o
        //统计疲劳次数
        List<BigdataAlarmRecordView> fatigueNumCarList = alarmRecordService.selectGroupCountDayFatigueOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : fatigueNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsFatigue("1");
            }else{
                timeCarDayrec.setIsFatigue("0");
            }
            if(count>=20){
                timeCarDayrec.setIsSeriousFatigue("1");
            }else{
                timeCarDayrec.setIsSeriousFatigue("0");
            }
            timeCarDayrec.setFatigueNum(count);
        }
        fatigueNumCarList=null;//释放内存o(*￣︶￣*)o

        //统计危险时段疲劳次数
        List<BigdataAlarmRecordView> dangerFatigueNumCarList = alarmRecordService.selectGroupCountDayDangerFatigueOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : dangerFatigueNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsDangerFatigue("1");
            }else{
                timeCarDayrec.setIsDangerFatigue("0");
            }
            timeCarDayrec.setDangerFatigueNum(count);
        }
        dangerFatigueNumCarList=null;//释放内存o(*￣︶￣*)o

        //统计高速超速次数
        List<BigdataAlarmRecordView> highWayOverSpeedNumCarList = alarmRecordService.selectGroupCountDayHighWayOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : highWayOverSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }

            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsHighWayOverSpeed("1");
            }else{
                timeCarDayrec.setIsHighWayOverSpeed("0");
            }
            timeCarDayrec.setHighWayOverSpeedNum(count);
        }
        highWayOverSpeedNumCarList=null;//释放内存o(*￣︶￣*)o
        //统计国道超速次数
        List<BigdataAlarmRecordView> guodaoOverSpeedNumCarList = alarmRecordService.selectGroupCountDayGuodaoWayOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : guodaoOverSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsGuodaoOverSpeed("1");
            }else{
                timeCarDayrec.setIsGuodaoOverSpeed("0");
            }
            timeCarDayrec.setGuodaoOverSpeedNum(count);
        }
        guodaoOverSpeedNumCarList=null;//释放内存o(*￣︶￣*)o

        //统计严重超速次数
        List<BigdataAlarmRecordView> seriousOverSpeedNumCarList = alarmRecordService.selectGroupCountDaySeriousWayOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : seriousOverSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsSeriousOverSpeed("1");
            }else{
                timeCarDayrec.setIsSeriousOverSpeed("0");
            }
            timeCarDayrec.setSeriousOverSpeedNum(count);
        }
        seriousOverSpeedNumCarList=null;//释放内存o(*￣︶￣*)o
        //统计危险时段超速次数
        List<BigdataAlarmRecordView> dangerOverSpeedNumCarList = alarmRecordService.selectGroupCountDayDangerWayOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : dangerOverSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsDangerOverSpeed("1");
            }else{
                timeCarDayrec.setIsDangerOverSpeed("0");
            }
            timeCarDayrec.setDangerOverSpeedNum(count);
        }
        dangerOverSpeedNumCarList=null;//释放内存o(*￣︶￣*)o


        //高速严重超速次数
        List<BigdataAlarmRecordView> highWaySerOverSpeedNumCarList = alarmRecordService.selectGroupDayHighWaySerOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : highWaySerOverSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsHighWaySerOverSpeed("1");
            }else{
                timeCarDayrec.setIsHighWaySerOverSpeed("0");
            }
            timeCarDayrec.setHighWaySerOverSpeedNum(count);
        }
        highWaySerOverSpeedNumCarList=null;//释放内存o(*￣︶￣*)o
        //国道严重超速次数
        List<BigdataAlarmRecordView> guodaoSerOverSpeedNumCarList = alarmRecordService.selectGroupCountDayGuodaoWaySerOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : guodaoSerOverSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsGuodaoSerOverSpeed("1");
            }else{
                timeCarDayrec.setIsGuodaoSerOverSpeed("0");
            }
            timeCarDayrec.setGuodaoSerOverSpeedNum(count);
        }
        guodaoSerOverSpeedNumCarList=null;//释放内存o(*￣︶￣*)o

        //高速危险时段超速次数
        List<BigdataAlarmRecordView> highWayDangerOverSpeedNumCarList = alarmRecordService.selectGroupDayHighWayDangerOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : highWayDangerOverSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsHighWayDangerOverSpeed("1");
            }else{
                timeCarDayrec.setIsHighWayDangerOverSpeed("0");
            }
            timeCarDayrec.setHighWayDangerOverSpeedNum(count);
        }
        highWayDangerOverSpeedNumCarList=null;//释放内存o(*￣︶￣*)o

        //国道危险时段超速次数
        List<BigdataAlarmRecordView> guodaoDangerOverSpeedNumCarList = alarmRecordService.selectGroupDayGuodaoWayDangerOverSpeedOfCar(cur);
        for(BigdataAlarmRecordView alarmRecordView : guodaoDangerOverSpeedNumCarList){
             String carRealId = dayInt + "-" + alarmRecordView.getCarPlateNum() + "-" + alarmRecordView.getCarPlateColor();
            BigdataTimeCarDayRec timeCarDayrec = timeCarDayRecMap.get(carRealId);
            if(timeCarDayrec==null){
                timeCarDayrec = new BigdataTimeCarDayRec();
                timeCarDayrec.setId(carRealId);
                timeCarDayRecMap.put(carRealId,timeCarDayrec);
            }
            int count = alarmRecordView.getGroupCount();
            if(count>0){
                timeCarDayrec.setIsGuodaoDangerOverSpeed("1");
            }else{
                timeCarDayrec.setIsGuodaoDangerOverSpeed("0");
            }
            timeCarDayrec.setGuodaoDangerOverSpeedNum(count);
        }
        guodaoDangerOverSpeedNumCarList=null;//释放内存o(*￣︶￣*)o

        //更新所有车辆的记录
        Collection<BigdataTimeCarDayRec> coll = timeCarDayRecMap.values();
        for(BigdataTimeCarDayRec carDayRec : coll){
            carDayRec.setCountMonth(monthInt);
            bigdataTimeCarDayRecService.updateByFenPian(carDayRec);
        }

    }


    //汇总三种类型车辆的日统计信息
    //@Scheduled(cron = "0 0/10 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisTimeInfo.cron.sumCarDayTimeInfo}")
    public void  sumCarDayTimeInfo(){
        try{
            //如果时间在凌晨0点 5分之前返回
            Date cur = new Date();
            String dateStr = sdfDayInt.format(cur);
            int dateInt = new Integer(dateStr);
            BigdataTimeAnalysisView bigdataTimeAnalysisAll = new BigdataTimeAnalysisView("总",dateInt);
            BigdataTimeAnalysisView bigdataTimeAnalysisWeihuo = new BigdataTimeAnalysisView("危货",dateInt);
            BigdataTimeAnalysisView bigdataTimeAnalysisPuhuo = new BigdataTimeAnalysisView("普货",dateInt);
            BigdataTimeAnalysisView bigdataTimeAnalysisKeyun = new BigdataTimeAnalysisView("客运",dateInt);
            //分组统计各个类型的车辆的各个时段的信息
            List<BigdataTimeCarDayRec> list = bigdataTimeCarDayRecService.sumGroupByCarTypeOfDay(new Integer(dateStr));
            for(BigdataTimeCarDayRec cardayGroupRec : list){
                BigdataTimeAnalysis temAnalys = null;
                BigDecimal duskMileage = cardayGroupRec.getDuskMileage();
                if(duskMileage==null)duskMileage= new BigDecimal(0);
                BigDecimal duskTime = cardayGroupRec.getDuskTime();
                if(duskTime==null)duskTime=new BigDecimal(0);
                BigDecimal earlyMorningMileage = cardayGroupRec.getEarlyMorningMileage();
                if(earlyMorningMileage==null)earlyMorningMileage=new BigDecimal(0);
                BigDecimal earlyMorningTime = cardayGroupRec.getEarlyMorningTime();
                if(earlyMorningTime==null)earlyMorningTime=new BigDecimal(0);
                BigDecimal lingchenMileage = cardayGroupRec.getLingchenMileage();
                if(lingchenMileage==null)lingchenMileage=new BigDecimal(0);
                BigDecimal lingchenTime = cardayGroupRec.getLingchenTime();
                if(lingchenTime==null)lingchenTime=new BigDecimal(0);
                BigDecimal nightMileage = cardayGroupRec.getNightMileage();
                if(nightMileage==null)nightMileage=new BigDecimal(0);
                BigDecimal nightTime = cardayGroupRec.getNightTime();
                if(nightTime==null)nightTime=new BigDecimal(0);
                BigDecimal noonMileage = cardayGroupRec.getNoonMileage();
                if(noonMileage==null)noonMileage=new BigDecimal(0);
                BigDecimal noonTime = cardayGroupRec.getNoonTime();
                if(noonTime==null)noonTime=new BigDecimal(0);
                BigDecimal sumDuration = cardayGroupRec.getSumDuration();
                if(sumDuration==null)sumDuration=new BigDecimal(0);
                BigDecimal sumMileage = cardayGroupRec.getSumMileage();
                if(sumMileage==null)sumMileage=new BigDecimal(0);
                String carType = cardayGroupRec.getCarType();
                if (carType==null){
                    continue;
                }
                if(carType.equals("普货")){
                    temAnalys = bigdataTimeAnalysisPuhuo;

                }else if(carType.equals("危货")){
                    temAnalys = bigdataTimeAnalysisWeihuo;
                }else if(carType.equals("客运")){
                    temAnalys = bigdataTimeAnalysisKeyun;
                }
//                temAnalys.setId(dateStr + "-" + carType);
                temAnalys.setCarType(carType);
                temAnalys.setDuskMileage(duskMileage);
                temAnalys.setDuskTime(duskTime);
                temAnalys.setEarlyMorningMileage(earlyMorningMileage);
                temAnalys.setEarlyMorningTime(earlyMorningTime);
                temAnalys.setNightMileage(nightMileage);
                temAnalys.setNightTime(nightTime);
                temAnalys.setLingchenMileage(lingchenMileage);
                temAnalys.setLingchenTime(lingchenTime);
                temAnalys.setNoonMileage(noonMileage);
                temAnalys.setNoonTime(noonTime);
                temAnalys.setSumDuration(sumDuration);
                temAnalys.setSumMileage(sumMileage);
                temAnalys.setCountTime(cur);
                temAnalys.setFirstDangerTimeNum(cardayGroupRec.getFirstDangerTimeFlag());
                temAnalys.setSecondDangerTimeNum(cardayGroupRec.getSecondDangerTimeFlag());
                temAnalys.setThirdDangerTimeNum(cardayGroupRec.getThirdDangerTimeFlag());

            }
//            bigdataTimeAnalysisAll.setId(dateStr + "-总" );
            bigdataTimeAnalysisAll.setCarType("总");
            bigdataTimeAnalysisAll.setDuskMileage(
                    bigdataTimeAnalysisWeihuo.getDuskMileage()
                            .add(bigdataTimeAnalysisPuhuo.getDuskMileage())
                            .add(bigdataTimeAnalysisKeyun.getDuskMileage())
            );
            bigdataTimeAnalysisAll.setDuskTime(
                    bigdataTimeAnalysisWeihuo.getDuskTime()
                            .add(bigdataTimeAnalysisPuhuo.getDuskTime())
                            .add(bigdataTimeAnalysisKeyun.getDuskTime())

            );
            bigdataTimeAnalysisAll.setEarlyMorningMileage(
                    bigdataTimeAnalysisWeihuo.getEarlyMorningMileage()
                            .add(bigdataTimeAnalysisPuhuo.getEarlyMorningMileage())
                            .add(bigdataTimeAnalysisKeyun.getEarlyMorningMileage())
            );
            bigdataTimeAnalysisAll.setEarlyMorningTime(
                    bigdataTimeAnalysisWeihuo.getEarlyMorningTime()
                            .add(bigdataTimeAnalysisPuhuo.getEarlyMorningTime())
                            .add(bigdataTimeAnalysisKeyun.getEarlyMorningTime())
            );
            bigdataTimeAnalysisAll.setNightMileage(
                    bigdataTimeAnalysisWeihuo.getNightMileage()
                            .add(bigdataTimeAnalysisPuhuo.getNightMileage())
                            .add(bigdataTimeAnalysisKeyun.getNightMileage())
            );
            bigdataTimeAnalysisAll.setNightTime(
                    bigdataTimeAnalysisWeihuo.getNightTime()
                            .add(bigdataTimeAnalysisPuhuo.getNightTime())
                            .add(bigdataTimeAnalysisKeyun.getNightTime())
            );
            bigdataTimeAnalysisAll.setLingchenMileage(
                    bigdataTimeAnalysisWeihuo.getLingchenMileage()
                            .add(bigdataTimeAnalysisPuhuo.getLingchenMileage())
                            .add(bigdataTimeAnalysisKeyun.getLingchenMileage())
            );
            bigdataTimeAnalysisAll.setLingchenTime(
                    bigdataTimeAnalysisWeihuo.getLingchenTime()
                            .add(bigdataTimeAnalysisPuhuo.getLingchenTime())
                            .add(bigdataTimeAnalysisKeyun.getLingchenTime())

            );
            bigdataTimeAnalysisAll.setNoonMileage(
                    bigdataTimeAnalysisWeihuo.getNoonMileage()
                            .add(bigdataTimeAnalysisPuhuo.getNoonMileage())
                            .add(bigdataTimeAnalysisKeyun.getNoonMileage())
            );
            bigdataTimeAnalysisAll.setNoonTime(
                    bigdataTimeAnalysisWeihuo.getNoonTime()
                            .add(bigdataTimeAnalysisPuhuo.getNoonTime())
                            .add(bigdataTimeAnalysisKeyun.getNoonTime())
            );
            bigdataTimeAnalysisAll.setSumDuration(
                    bigdataTimeAnalysisWeihuo.getSumDuration()
                            .add(bigdataTimeAnalysisPuhuo.getSumDuration())
                            .add(bigdataTimeAnalysisKeyun.getSumDuration())
            );
            bigdataTimeAnalysisAll.setSumMileage(
                    bigdataTimeAnalysisWeihuo.getSumMileage()
                            .add(bigdataTimeAnalysisPuhuo.getSumMileage())
                            .add(bigdataTimeAnalysisKeyun.getSumMileage())
            );
            //设置第一时段的里程
            bigdataTimeAnalysisAll.setFirstDangerMileage(
                    bigdataTimeAnalysisWeihuo.getFirstDangerMileage()
                    .add(bigdataTimeAnalysisPuhuo.getFirstDangerMileage())
                    .add(bigdataTimeAnalysisKeyun.getFirstDangerMileage())
            );
            bigdataTimeAnalysisAll.setSecondDangerMileage(
                    bigdataTimeAnalysisWeihuo.getSecondDangerMileage()
                            .add(bigdataTimeAnalysisPuhuo.getSecondDangerMileage())
                            .add(bigdataTimeAnalysisKeyun.getSecondDangerMileage())
            );
            bigdataTimeAnalysisAll.setThirdDangerMileage(
                    bigdataTimeAnalysisWeihuo.getThirdDangerMileage()
                            .add(bigdataTimeAnalysisPuhuo.getThirdDangerMileage())
                            .add(bigdataTimeAnalysisKeyun.getThirdDangerMileage())
            );
            bigdataTimeAnalysisAll.setFirstDangerTimeNum(
                    bigdataTimeAnalysisWeihuo.getFirstDangerTimeNum() +
                    bigdataTimeAnalysisPuhuo.getFirstDangerTimeNum() +
                    bigdataTimeAnalysisKeyun.getFirstDangerTimeNum()

            );
            bigdataTimeAnalysisAll.setSecondDangerTimeNum(
                    bigdataTimeAnalysisWeihuo.getSecondDangerTimeNum() +
                            bigdataTimeAnalysisPuhuo.getSecondDangerTimeNum() +
                            bigdataTimeAnalysisKeyun.getSecondDangerTimeNum()
            );

            bigdataTimeAnalysisAll.setThirdDangerTimeNum(
                    bigdataTimeAnalysisWeihuo.getThirdDangerTimeNum() +
                            bigdataTimeAnalysisPuhuo.getThirdDangerTimeNum() +
                            bigdataTimeAnalysisKeyun.getThirdDangerTimeNum()
            );


            bigdataTimeAnalysisAll.setCountTime(cur);
            //分析各种率
            bigdataTimeAnalysisAll.fenxiRate();
            bigdataTimeAnalysisWeihuo.fenxiRate();
            bigdataTimeAnalysisPuhuo.fenxiRate();
            bigdataTimeAnalysisKeyun.fenxiRate();
            bigdataTimeAnalysisService.updateSynTimeAnalysis(bigdataTimeAnalysisAll);
            bigdataTimeAnalysisService.updateSynTimeAnalysis(bigdataTimeAnalysisWeihuo);
            bigdataTimeAnalysisService.updateSynTimeAnalysis(bigdataTimeAnalysisPuhuo);
            bigdataTimeAnalysisService.updateSynTimeAnalysis(bigdataTimeAnalysisKeyun);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    //汇总分类型的危险时段的统计
    //@Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisTimeInfo.cron.sumMonthOrYearDanger}")
    public void  sumMonthOrYearDanger(){
        try{
            Date cur = new Date();
            String countMonth = sdfMonthInt.format(cur);
            int countMonthInt = new Integer(countMonth);
            //危货的统计
            BigdataTimeCarSumCount bigdataTimeCarDayRecWeihuo = sumDangerTimeMonthOfType("危货",countMonth);
            //普货的统计
            BigdataTimeCarSumCount bigdataTimeCarDayRecPuhuo = sumDangerTimeMonthOfType("普货",countMonth);
            //客运的统计
            BigdataTimeCarSumCount bigdataTimeCarDayRecKeyun = sumDangerTimeMonthOfType("客运",countMonth);
            //汇总的统计
            BigdataTimeCarSumCount bigdataTimeCarSumCountAll = new BigdataTimeCarSumCount();
            String id = "总-" + countMonthInt;
            bigdataTimeCarSumCountAll.setId(id);
            bigdataTimeCarSumCountAll.setLastUpTime(new Date());
            bigdataTimeCarSumCountAll.setCreateTime(new Date());
            bigdataTimeCarSumCountAll.setCountYear(new Integer(countMonth.substring(0,4)));
            bigdataTimeCarSumCountAll.setCountMonth(countMonthInt);
            bigdataTimeCarSumCountAll.setCountType("month");
            bigdataTimeCarSumCountAll.setCountTime(new Date());
            bigdataTimeCarSumCountAll.setCarType("总");
            bigdataTimeCarSumCountAll.setFirstDangerTimeNum(
                    bigdataTimeCarDayRecWeihuo.getFirstDangerTimeNum()
                            + bigdataTimeCarDayRecPuhuo.getFirstDangerTimeNum()
                            + bigdataTimeCarDayRecKeyun.getFirstDangerTimeNum()
            );
            bigdataTimeCarSumCountAll.setSecondDangerTimeNum(
                    bigdataTimeCarDayRecWeihuo.getSecondDangerTimeNum()
                            + bigdataTimeCarDayRecPuhuo.getSecondDangerTimeNum()
                            + bigdataTimeCarDayRecKeyun.getSecondDangerTimeNum()
            );
            bigdataTimeCarSumCountAll.setThirdDangerTimeNum(
                    bigdataTimeCarDayRecWeihuo.getThirdDangerTimeNum()
                            + bigdataTimeCarDayRecPuhuo.getThirdDangerTimeNum()
                            + bigdataTimeCarDayRecKeyun.getThirdDangerTimeNum()
            );

            bigdataTimeCarSumCountService.insertOrUpdate(bigdataTimeCarDayRecWeihuo);
            bigdataTimeCarSumCountService.insertOrUpdate(bigdataTimeCarDayRecPuhuo);
            bigdataTimeCarSumCountService.insertOrUpdate(bigdataTimeCarDayRecKeyun);
            bigdataTimeCarSumCountService.insertOrUpdate(bigdataTimeCarSumCountAll);

            int countYear = bigdataTimeCarSumCountAll.getCountYear();
            //危货的统计
            BigdataTimeCarSumCount bigdataTimeCarDayRecYearWeihuo = new BigdataTimeCarSumCount();
            bigdataTimeCarDayRecYearWeihuo.setCarType("危货");
            bigdataTimeCarDayRecYearWeihuo.setCountType("year");
            bigdataTimeCarDayRecYearWeihuo.setId("危货-" + countYear);
            bigdataTimeCarDayRecYearWeihuo.setCreateTime(cur);
            bigdataTimeCarDayRecYearWeihuo.setCountTime(cur);
            bigdataTimeCarDayRecYearWeihuo.setLastUpTime(cur);
            bigdataTimeCarDayRecYearWeihuo.setCountYear(countYear);
            //普货的统计
            BigdataTimeCarSumCount bigdataTimeCarDayRecYearPuhuo = new BigdataTimeCarSumCount();
            bigdataTimeCarDayRecYearPuhuo.setCarType("普货");
            bigdataTimeCarDayRecYearPuhuo.setCountType("year");
            bigdataTimeCarDayRecYearPuhuo.setId("普货-" + countYear);
            bigdataTimeCarDayRecYearPuhuo.setCreateTime(cur);
            bigdataTimeCarDayRecYearPuhuo.setCountTime(cur);
            bigdataTimeCarDayRecYearPuhuo.setLastUpTime(cur);
            bigdataTimeCarDayRecYearPuhuo.setCountYear(countYear);

            //客运的统计
            BigdataTimeCarSumCount bigdataTimeCarDayRecYearKeyun = new BigdataTimeCarSumCount();
            bigdataTimeCarDayRecYearKeyun.setCarType("客运");
            bigdataTimeCarDayRecYearKeyun.setCountType("year");
            bigdataTimeCarDayRecYearKeyun.setId("客运-" + countYear);
            bigdataTimeCarDayRecYearKeyun.setCreateTime(cur);
            bigdataTimeCarDayRecYearKeyun.setCountTime(cur);
            bigdataTimeCarDayRecYearKeyun.setLastUpTime(cur);
            bigdataTimeCarDayRecYearKeyun.setCountYear(countYear);

            //汇总的统计
            BigdataTimeCarSumCount bigdataTimeCarSumCountYearAll = new BigdataTimeCarSumCount();
            bigdataTimeCarSumCountYearAll.setCarType("总");
            bigdataTimeCarSumCountYearAll.setCountType("year");
            bigdataTimeCarSumCountYearAll.setId("总-" + countYear);
            bigdataTimeCarSumCountYearAll.setCreateTime(cur);
            bigdataTimeCarSumCountYearAll.setCountTime(cur);
            bigdataTimeCarSumCountYearAll.setLastUpTime(cur);
            bigdataTimeCarSumCountYearAll.setCountYear(countYear);

            List<BigdataTimeCarSumCount> bigdataTimeCountList =
                    bigdataTimeCarSumCountService.selectSumGroupCarInfoYear(countYear);
            for(BigdataTimeCarSumCount temSum : bigdataTimeCountList){
                String carType = temSum.getCarType();
                if(carType.equals("危货")){
                    bigdataTimeCarDayRecYearWeihuo.setFirstDangerTimeNum(temSum.getFirstDangerTimeNum());
                    bigdataTimeCarDayRecYearWeihuo.setSecondDangerTimeNum(temSum.getSecondDangerTimeNum());
                    bigdataTimeCarDayRecYearWeihuo.setThirdDangerTimeNum(temSum.getThirdDangerTimeNum());
                }else if(carType.equals("普货")){
                    bigdataTimeCarDayRecYearPuhuo.setFirstDangerTimeNum(temSum.getFirstDangerTimeNum());
                    bigdataTimeCarDayRecYearPuhuo.setSecondDangerTimeNum(temSum.getSecondDangerTimeNum());
                    bigdataTimeCarDayRecYearPuhuo.setThirdDangerTimeNum(temSum.getThirdDangerTimeNum());
                }else if(carType.equals("客运")){
                    bigdataTimeCarDayRecYearKeyun.setFirstDangerTimeNum(temSum.getFirstDangerTimeNum());
                    bigdataTimeCarDayRecYearKeyun.setSecondDangerTimeNum(temSum.getSecondDangerTimeNum());
                    bigdataTimeCarDayRecYearKeyun.setThirdDangerTimeNum(temSum.getThirdDangerTimeNum());
                }
            }

            bigdataTimeCarSumCountYearAll.setFirstDangerTimeNum(
                    bigdataTimeCarDayRecYearWeihuo.getFirstDangerTimeNum()
                            + bigdataTimeCarDayRecYearPuhuo.getFirstDangerTimeNum()
                            + bigdataTimeCarDayRecYearKeyun.getFirstDangerTimeNum()
            );
            bigdataTimeCarSumCountYearAll.setSecondDangerTimeNum(
                    bigdataTimeCarDayRecYearWeihuo.getSecondDangerTimeNum()
                            + bigdataTimeCarDayRecYearPuhuo.getSecondDangerTimeNum()
                            + bigdataTimeCarDayRecYearKeyun.getSecondDangerTimeNum()
            );
            bigdataTimeCarSumCountYearAll.setThirdDangerTimeNum(
                    bigdataTimeCarDayRecYearWeihuo.getThirdDangerTimeNum()
                            + bigdataTimeCarDayRecYearPuhuo.getThirdDangerTimeNum()
                            + bigdataTimeCarDayRecYearKeyun.getThirdDangerTimeNum()
            );
            bigdataTimeCarSumCountService.insertOrUpdate(bigdataTimeCarDayRecYearWeihuo);
            bigdataTimeCarSumCountService.insertOrUpdate(bigdataTimeCarDayRecYearPuhuo);
            bigdataTimeCarSumCountService.insertOrUpdate(bigdataTimeCarDayRecYearKeyun);
            bigdataTimeCarSumCountService.insertOrUpdate(bigdataTimeCarSumCountYearAll);

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    private BigdataTimeCarSumCount sumDangerTimeMonthOfType(String carType,String countMonth){
        int countMonthInt = new Integer(countMonth);
        BigdataTimeCarSumCount bigdataTimeCount = bigdataTimeCarDayRecService.selectSumGroupCarInfoMonth(
                countMonthInt,carType );
        bigdataTimeCount.setCarType(carType);
        bigdataTimeCount.setCountMonth(countMonthInt );
        bigdataTimeCount.setCountType("month");
        bigdataTimeCount.setCountYear(new Integer(countMonth.substring(0,4)));
        bigdataTimeCount.setCreateTime(new Date());
        bigdataTimeCount.setLastUpTime(new Date());
        bigdataTimeCount.setCountTime(new Date());
        String id = carType + "-" + countMonthInt;
        bigdataTimeCount.setId(id);
        return bigdataTimeCount;
    }


   /* public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
//				cal.setTime(alarmTime);
        int hour =  cal.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
    }*/



}
