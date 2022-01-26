package com.edgedo.timetask.fenxi;

import com.edgedo.bigdata.entity.TransitCarTeam;
import com.edgedo.bigdata.entity.TransitCarTeamQuery;
import com.edgedo.bigdata.service.BigdataFenxiTeamMonthService;
import com.edgedo.bigdata.service.BigdataFenxiTeamWeekService;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.ObjectUtil;
import com.edgedo.util.DateUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BigdataFenxiTeam
 * @Description 企业统计汇总
 * @Author 床前明月光
 * @Date 2019/10/8 10:13
 **/

@Component
public class BigdataFenXiTeamWeekAndMonth {

    @Value("${ReportDataUrl}")
    private String ReportDataUrl;
    @Autowired
    private BigdataFenxiTeamWeekService bigdataFenxiTeamWeekService;
    @Autowired
    private BigdataFenxiTeamMonthService bigdataFenxiTeamMonthService;

    SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

    @Scheduled(cron = "0 0 1 * * ?")
    public void fenxiTeamWeekAndMonth(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        String dateIntStr = sdfDateInt.format(date);
        int dateInt = new Integer(dateIntStr);
        int countMonth = dateInt/100;
        int weekYear = DateUtil.getYear(date);
        int weekOfYear =  DateUtil.getWeekOfYear(date);
        Date  beginDate = DateUtil.getBeginDayOfWeek(date);
        Date endDate = DateUtil.getEndDayOfWeek(date);
        TransitCarTeamQuery query = new TransitCarTeamQuery();
        String reportDataUrl = ReportDataUrl+"/sys/carTeam/selectTeamCarInfo.jsn";
        query.setCityId("130300");
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        org.json.JSONObject jsonObject = new org.json.JSONObject(responseStr);
        JSONArray jsonArray = jsonObject.optJSONArray("list");
        List<TransitCarTeam> teamList = com.alibaba.fastjson.JSONArray.parseArray(jsonArray.toString(), TransitCarTeam.class);
        if (teamList!=null){
            int totalCarNum = teamList.size();
            final int oneNum = 150;
            int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
            //多线程遍历数据库
            for(int i=0;i<times;i++){
                final int fiIndex = i;
                Thread t = new Thread(){
                    @Override
                    public void run(){
                        int start = oneNum*fiIndex ;
                        int end = oneNum*(fiIndex+1)-1;
                        for(int j=start;j<=end; j++){
                            if(j>totalCarNum-1){
                                break;
                            }
                            bigdataFenxiTeamWeekService.insertOrUpdate(teamList.get(j),weekYear,weekOfYear,beginDate,endDate);
                            bigdataFenxiTeamMonthService.insertOrUpdateAndMonth(teamList.get(j),weekYear,countMonth,dateInt);
                        }
                    }
                };
                t.start();
            }
        }
    }

    //@Scheduled(cron = "0 25 5 * * ?")//0/2 * * * * ?每天10点
    public void fenxiTeamWeek(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        int weekYear = DateUtil.getYear(date);
        int weekOfYear =  DateUtil.getWeekOfYear(date);
        Date  beginDate = DateUtil.getBeginDayOfWeek(date);
        Date endDate = DateUtil.getEndDayOfWeek(date);
        TransitCarTeamQuery query = new TransitCarTeamQuery();
        String reportDataUrl = ReportDataUrl+"/sys/carTeam/selectTeamCarInfo.jsn";
        query.setCityId("130300");
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        org.json.JSONObject jsonObject = new org.json.JSONObject(responseStr);
        JSONArray jsonArray = jsonObject.optJSONArray("list");
        List<TransitCarTeam> teamList = com.alibaba.fastjson.JSONArray.parseArray(jsonArray.toString(), TransitCarTeam.class);
        if (teamList!=null){
            int totalCarNum = teamList.size();
            final int oneNum = 200;
            int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
            //多线程遍历数据库
            for(int i=0;i<times;i++){
                final int fiIndex = i;
                Thread t = new Thread(){
                    @Override
                    public void run(){
                        int start = oneNum*fiIndex ;
                        int end = oneNum*(fiIndex+1)-1;
                        for(int j=start;j<=end; j++){
                            if(j>totalCarNum-1){
                                break;
                            }
                            bigdataFenxiTeamWeekService.insertOrUpdate(teamList.get(j),weekYear,weekOfYear,beginDate,endDate);
                        }
                    }
                };
                t.start();
            }
        }
    }

    //@Scheduled(cron = "0 16 4 * * ?")//0/2 * * * * ?每天10点50
    public void fenxiTeaMonth(){
        //设置日期
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        Integer countMonth = new Integer(str[0]+str[1]);//月
        Integer countDay = new Integer(str[0]+str[1]+str[2]);//日
        TransitCarTeamQuery query = new TransitCarTeamQuery();
        String reportDataUrl = ReportDataUrl+"/sys/carTeam/selectTeamCarInfo.jsn";
        query.setCityId("130300");
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        org.json.JSONObject jsonObject = new org.json.JSONObject(responseStr);
        JSONArray jsonArray = jsonObject.optJSONArray("list");
        List<TransitCarTeam> teamList = com.alibaba.fastjson.JSONArray.parseArray(jsonArray.toString(), TransitCarTeam.class);
        if(teamList!=null){
            int totalCarNum = teamList.size();
            final int oneNum = 200;
            int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
            //多线程遍历数据库
            for(int i=0;i<times;i++){
                final int fiIndex = i;
                Thread t = new Thread(){
                    @Override
                    public void run(){
                        int start = oneNum*fiIndex ;
                        int end = oneNum*(fiIndex+1)-1;
                        for(int j=start;j<=end; j++){
                            if(j>totalCarNum-1){
                                break;
                            }
                            bigdataFenxiTeamMonthService.insertOrUpdateAndMonth(teamList.get(j),yearNum,countMonth,countDay);
                        }
                    }
                };
                t.start();
            }
        }
    }
}
