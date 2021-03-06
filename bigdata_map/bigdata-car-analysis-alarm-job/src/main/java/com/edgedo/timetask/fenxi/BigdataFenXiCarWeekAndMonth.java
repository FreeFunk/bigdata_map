package com.edgedo.timetask.fenxi;

import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.service.BigdataFenxiCarMonthService;
import com.edgedo.bigdata.service.BigdataFenxiCarWeekService;
import com.edgedo.bigdata.service.BigdataTimeCarDayRecService;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BigdataFenxiCar
 * @Description 车辆统计汇总
 * @Author 床前明月光
 * @Date 2019/9/25 8:56
 **/
@Component
public class BigdataFenXiCarWeekAndMonth {

    @Autowired
    CarInfoService carInfoService;
    @Autowired
    BigdataTimeCarDayRecService bigdataTimeCarDayRecService;
    @Autowired
    BigdataFenxiCarWeekService bigdataFenxiCarWeekService;
    @Autowired
    BigdataFenxiCarMonthService bigdataFenxiCarMonthService;

    SimpleDateFormat sdfMonthInt = new SimpleDateFormat("yyyyMM");

    SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

    //车辆周的统计分析
    @Scheduled(cron = "0 0 4 * * ?")
    public void fenxiCarWeekAndMonth(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        String dateIntStr = sdfDateInt.format(date);
        int dateInt = new Integer(dateIntStr);
        int weekYear = DateUtil.getYear(date);
        int weekOfYear =  DateUtil.getWeekOfYear(date);
        Date  beginDate = DateUtil.getBeginDayOfWeek(date);
        Date endDate = DateUtil.getEndDayOfWeek(date);
        int totalCarNum = carInfoService.countAll();
        final int oneNum = 1000;
        int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
        //多线程遍历数据库
        for(int i=0;i<times;i++){
            final int fiIndex = i;
            Thread t = new Thread(){
                @Override
                public void run(){
                    int start = oneNum*fiIndex ;
                    int end = oneNum*(fiIndex+1)-1;
                    List<CarInfo> carList = carInfoService.listByStartAndEndBySortNumNew(start,end);
                    for(CarInfo car : carList){
                        //统计该周的记录
                        bigdataFenxiCarWeekService.insertOrUpdate(car,weekYear,weekOfYear,beginDate,endDate);
                        bigdataFenxiCarMonthService.insertOrUpdate(car,dateInt);
                    }
                }
            };
            t.start();
        }
    }


    //车辆周的统计分析
    //@Scheduled(cron = "0 0 2 * * ?")
    public void fenxiCarWeek(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        int weekYear = DateUtil.getYear(date);
        int weekOfYear =  DateUtil.getWeekOfYear(date);
        Date  beginDate = DateUtil.getBeginDayOfWeek(date);
        Date endDate = DateUtil.getEndDayOfWeek(date);
        int totalCarNum = carInfoService.countAll();
        final int oneNum = 1000;
        int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
        //多线程遍历数据库
        for(int i=0;i<times;i++){
            final int fiIndex = i;
            Thread t = new Thread(){
                @Override
                public void run(){
                    int start = oneNum*fiIndex ;
                    int end = oneNum*(fiIndex+1)-1;
                    List<CarInfo> carList = carInfoService.listByStartAndEndBySortNumNew(start,end);
                    for(CarInfo car : carList){
                        //统计该周的记录
                        bigdataFenxiCarWeekService.insertOrUpdate(car,weekYear,weekOfYear,beginDate,endDate);
                    }
                }
            };
            t.start();
        }
    }

    //车辆月的统计分析
    //@Scheduled(cron = "0 0 1 * * ?")
    public void fenxiCarMonth(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        String dateIntStr = sdfDateInt.format(date);
        int dateInt = new Integer(dateIntStr);
        int totalCarNum = carInfoService.countAll();
        final int oneNum = 1000;
        int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
        //多线程遍历数据库
        for(int i=0;i<times;i++){
            final int fiIndex = i;
            Thread t = new Thread(){
                @Override
                public void run(){
                    int start = oneNum*fiIndex ;
                    int end = oneNum*(fiIndex+1)-1;
                    List<CarInfo> carList = carInfoService.listByStartAndEndBySortNumNew(start,end);
                    for(CarInfo car : carList){
                        //统计该周的记录
                        bigdataFenxiCarMonthService.insertOrUpdate(car,dateInt);
                    }
                }
            };
            t.start();
        }
    }
}