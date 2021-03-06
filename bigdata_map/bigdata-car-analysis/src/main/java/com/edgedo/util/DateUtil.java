package com.edgedo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
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
     * @Author WangZhen
     * @Description 转化 年月日时分秒的字符串到日期
     * @Date 2020/2/28 10:11
     **/
    public static Date parseFullDateStr(String fullDateStr){
        SimpleDateFormat sdfFullDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if(fullDateStr==null || fullDateStr.equals("")){
                return null;
            }
            return sdfFullDate.parse(fullDateStr);
        } catch (ParseException e) {
            return null;
        }
    }


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
    //获取传入时间的后一天的时间
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
                for(int i = 0;i<Math.abs(num);i++){
                    calendar.setTime(startDate);
                    calendar.add(Calendar.DATE,1);
                    startDate = calendar.getTime();
                    dateList.add(sdf1.format(startDate));
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
    //获取下一月时间
    public static Date getNextMonthDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH,1);
        Date nextMonthDate = cal.getTime();
        return  nextMonthDate;
    }

    //获取上一年时间
    public static Date getLastYearDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR,-1);
        Date lastYearDate = cal.getTime();
        return  lastYearDate;
    }

    //字符串转date
    public static Date getDateByString(String dateStr,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date =  sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    //获取两个时间相差的天数
    public static int getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int)(toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24);
    }

    public static Integer getNowDate(Date date){
        if(date==null){
            date = new Date();
        }
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
        String str = sdf.format(date);
        return Integer.parseInt(str);
    }
    //判断时间是第几周
    public static Integer getWeekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int mouth = calendar.get(Calendar.MONTH);
        //如果月份是12月，且求出来的周数是第一周，说明该日期实质上是这一年的第53周，也是下一年的第一周
        if (mouth >= 11 && week <= 1) {
            week += 52;
        }
        return week;
    }
    //获取时间的年份
    public static int getYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);//获得当前的年
        return year;
    }
    //获取本周的开始时间
    public static Date getBeginDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        int weekOfYear = getWeekOfYear(date);
        int year = getYear(date);
        if(weekOfYear==1){
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(Calendar.YEAR, year);
            return calendar.getTime();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return cal.getTime();
    }
    //获取本周的结束时间
    public static Date getEndDayOfWeek(Date date){
        int weekOfYear = getWeekOfYear(date);
        int year = getYear(date);
        if(weekOfYear==53){
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(Calendar.YEAR, year);
            calendar.roll(Calendar.DAY_OF_YEAR, -1);
            return calendar.getTime();
        }
        if(weekOfYear==1){
            Calendar cal = Calendar.getInstance();
            cal.setTime(getBeginDayOfWeek(date));
            int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
            if(dayofweek==1){
                Date weekEndSta = cal.getTime();
                return weekEndSta;
            }else {
                cal.add(Calendar.DAY_OF_WEEK, 8-dayofweek);
                Date weekEndSta = cal.getTime();
                return weekEndSta;
            }
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek(date));
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return weekEndSta;
    }
    //判断两个日期是否在同一个月
    public static boolean equalsDate(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        int month1 = calendar1.get(Calendar.MONTH);
        int month2 = calendar2.get(Calendar.MONTH);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
    }

    //根据分钟返回时分秒
    public static String getHourMinuteSecond(BigDecimal runTimeLength){
        String runTimeLengthText = "";
        int hours = (int) Math.floor(runTimeLength.divide(new BigDecimal("60"),2, RoundingMode.HALF_UP).intValue());
        if(hours>0){
            runTimeLengthText += hours+"时";
        }
        int minute = runTimeLength.divideAndRemainder(new BigDecimal("60"))[1].intValue();
        if(minute>0){
            runTimeLengthText += minute+"分";
        }
        int second = (int) Math.floor(runTimeLength.divideAndRemainder(new BigDecimal("60"))[1].
                subtract(new BigDecimal(minute)).multiply(new BigDecimal("60")).doubleValue());
        if(second>=0){
            runTimeLengthText += second+"秒";
        }
        if(runTimeLengthText.equals("")){
            runTimeLengthText = "0秒";
        }
        return runTimeLengthText;
    }

}
