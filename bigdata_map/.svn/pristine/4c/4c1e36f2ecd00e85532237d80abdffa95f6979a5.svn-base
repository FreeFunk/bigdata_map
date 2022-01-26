package com.edgedo.util;

import io.swagger.models.auth.In;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName DateUtil
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/2/20 10:35
 **/
public class DateUtil {

    /**
     * @Author ZhaoSiDa
     * @Description //判断时间是第几季度
     * @Date 2019/2/20 10:43
     * @Param [date]
     * @return java.lang.String
     **/
    public static String getQuarter(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(cal.MONTH) + 1;
        int quarter = 0;
        //判断季度
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return quarter+"";
    }

    /**
     * @Author ZhaoSiDa
     * @Description //判断时间是第几季度
     * @Date 2019/2/20 10:43
     * @Param [date]
     * @return java.lang.String
     **/
    public static Integer getQuarter1(Date date){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;//1-12
        int year = cal.get(Calendar.YEAR);
        int yearQuarter = 1;
        if(month<=3 && month>=1){
            yearQuarter = 1;
        }else if(month<=6 && month>=4 ){
            yearQuarter = 2;
        }else if(month<=9 && month>=7 ){
            yearQuarter = 3;
        }else if(month<=12 && month>=10 ){
            yearQuarter = 4;
        }
        String yearQuartStr = year + "" + yearQuarter;
        return new Integer(yearQuartStr);
    }

    /**
     * @Author ZhaoSiDa
     * @Description //判断时间是第几季度
     * @Date 2019/2/20 10:43
     * @Param [date]
     * @return java.lang.String
     **/
    public static int getYearAndQuarter(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH) + 1;
        int quarter = 0;
        //判断季度
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return Integer.parseInt(year+""+quarter);
    }

    public static List<String> getMonthAllDays(Date date){
        List<String> stringList = new ArrayList<>();
        int  daysOfMonth = getDaysOfMonth(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String month = (cal.get(Calendar.MONTH)+1)+"";
        for(int i =0;i<daysOfMonth;i++){
            String monthAndDay = month+"-"+(i+1);
            stringList.add(monthAndDay);
        }
        return stringList;
    }

    //获取该月的天数
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    //获取传入时间的前一天的时间
    public static Date getLastDayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date!=null){
            calendar.setTime(date);
            calendar.add(Calendar.DATE,-1);
        }
        return calendar.getTime();
    }

    //获取传入时间的前一天的时间
    public static Date getNextDayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if(date!=null){
            calendar.setTime(date);
            calendar.add(Calendar.DATE,1);
        }
        return calendar.getTime();
    }

    //获取日期的集合
    public static List<String> getDateList(Date date, int num) {
        List<String> dateList = new ArrayList<>();
        //获取limit之前的日期开始便利
        if(num<0){
            if(date!=null){
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DATE,num);
                Date startDate = cal.getTime();
                SimpleDateFormat sdf1 =new SimpleDateFormat("MM月dd日" );
                Calendar calendar = Calendar.getInstance();
                for(int i = 0;i<=Math.abs(num);i++){
                    dateList.add(sdf1.format(startDate));
                    calendar.setTime(startDate);
                    calendar.add(Calendar.DATE,1);
                    startDate = calendar.getTime();
                }
            }
        }
        return dateList;
    }

    //获取几天之前的日期
    public static Date getLastDate(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,num);
        Date startDate = cal.getTime();
        return  startDate;
    }

    //获取上一月时间
    public static Date getLastMonthDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH,-1);
        Date lastMonthDate = cal.getTime();
        return  lastMonthDate;
    }

    //起始时间，返回日期集合
    public static List<String> getDateListByStartAndEndMonth(Date startMonthDate, Date endMonthDate) {
        List<String> dateList = new ArrayList<>();
        if(startMonthDate!=null && endMonthDate!=null){
            Calendar startCal = Calendar.getInstance();
            Calendar endCal = Calendar.getInstance();
            startCal.setTime(startMonthDate);
            endCal.setTime(endMonthDate);
            int result = endCal.get(Calendar.MONTH) - startCal.get(Calendar.MONTH);
            int month = (endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR)) * 12;
            int sumMonth = result+month;

            Date startDate = startCal.getTime();
            SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy年MM月" );
            Calendar calendar = Calendar.getInstance();
            for(int i = 0;i<=sumMonth;i++){
                dateList.add(sdf1.format(startDate));
                calendar.setTime(startDate);
                calendar.add(Calendar.MONTH,1);
                startDate = calendar.getTime();
            }
        }
        return dateList;
    }

    //返回int类型的年月
    public static int getCountMonth(Date startMonthDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startMonthDate);
        int year  = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        String month1 = "";
        if(month<10){
            month1 = "0"+month;
        }else {
            month1 = ""+month;
        }
        int countMonth = Integer.parseInt(year+""+month1);
        return countMonth;
    }

    //返回int类型的年月日
    public static int getCountDate(Date startMonthDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startMonthDate);
        int year  = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String month1 = "";
        String day1 = "";
        if(month<10){
            month1 = "0"+month;
        }else {
            month1 = ""+month;
        }
        if(day<10){
            day1 = "0"+day;
        }else {
            day1 = ""+day;
        }
        int countDate = Integer.parseInt(year+""+month1+""+day1);
        return countDate;
    }

    //返回int类型的年
    public static int getCountYear(Date startMonthDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startMonthDate);
        int year  = cal.get(Calendar.YEAR);
        return year;
    }

    public static Date getNextMonth(Date startMonthDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startMonthDate);
        cal.add(Calendar.MONTH,1);
        return cal.getTime();
    }

    public static Date getNextYear(Date startMonthDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startMonthDate);
        cal.add(Calendar.YEAR,1);
        return cal.getTime();
    }

    //返回年的日期集合
    public static List<String> getDateListByStartAndEndYear(Date startMonthDate, Date endMonthDate) {
        List<String> dateList = new ArrayList<>();
        if(startMonthDate!=null && endMonthDate!=null){
            Calendar startCal = Calendar.getInstance();
            Calendar endCal = Calendar.getInstance();
            startCal.setTime(startMonthDate);
            endCal.setTime(endMonthDate);
            int sumYear = endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
            Date startDate = startCal.getTime();
            SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy年" );
            Calendar calendar = Calendar.getInstance();
            for(int i = 0;i<=sumYear;i++){
                dateList.add(sdf1.format(startDate));
                calendar.setTime(startDate);
                calendar.add(Calendar.YEAR,1);
                startDate = calendar.getTime();
            }
        }
        return dateList;
    }
}
