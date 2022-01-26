package com.edgedo.timetask;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.alarm.entity.Alterlogs;
import com.edgedo.alarm.entity.BigdataAlarmRecord;
import com.edgedo.alarm.entity.BigdataDriverCardRec;
import com.edgedo.alarm.service.AlterlogsService;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.util.BeidouCompSignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 分析车辆任务
 */
@Component
public class BigDataTongBuAlarm {
    @Value("${bigdata.beidouCompId}")
    private String compId;
    @Value("${bigdata.acceptAlarmUrl}")
    private String acceptAlarmUrl;
    @Value("${bigdata.beidouCompSignKey}")
    private String beidouCompSignKey;


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    AlterlogsService alterlogsService;

    //5分钟一次的同步报警
    @Scheduled(cron = "0 0/1 * * * ?")
    public void tongbuAlarm(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        //读取8分钟内的数据
        cal.setTime(date);
        cal.add(Calendar.MINUTE,-7);
        synAlarmOfDate(cal.getTime());
//        testDriverCard();

    }
    //30分钟一次的同步处理信息
    @Scheduled(cron = "0 0/1 * * * ?")
    public void tongbuAlarmDetail(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        //读取8分钟内的数据
        cal.setTime(date);
        cal.add(Calendar.MINUTE,-30);
        synAlarmOfDate(cal.getTime());
//        testDriverCard();

    }

    //测试同步司机身份卡信息
    private static void testDriverCard() {
        List<BigdataDriverCardRec> listDriverCard = new ArrayList<BigdataDriverCardRec>();
        BigdataDriverCardRec cardRec = new BigdataDriverCardRec();
        cardRec.setBid("2");
        cardRec.setCardTime(new Date());
        cardRec.setCarPlateColor("1");
        cardRec.setCarPlateNum("冀C34567");
        cardRec.setCompany("企业");
        cardRec.setDriverName("赵大福");
        cardRec.setLicenceNum("130302234934873453");
        cardRec.setRecType("插卡");
        cardRec.setSysReceiveTime(new Date());
        listDriverCard.add(cardRec);
        String json = JSONArray.toJSONString(listDriverCard);
        SortedMap<String,Object> param = new TreeMap<String,Object>();
        param.put("compId","10001");
        param.put("cardRecs",json);
        String sign = BeidouCompSignUtil.createSign("utf-8",
                param, "10001" );
        param.put("sign",sign);
        String res = HttpRequestUtil.postRequest("http://localhost:8098/beidouData/acceptDriverCard.jsn",param);

        System.out.println(json);


    }
    //一个小时一次的同步上一个小时内的数据
   /* @Scheduled(cron = "10 1 * * * ?")
    public void tongBuLastHour(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR,-1);
        Date time = cal.getTime();
        synAlarmOfDate(time);

    }*/


    private void synAlarmOfDate(Date time){
        List<Alterlogs> list = alterlogsService.listRecentLogs(time);
        List<BigdataAlarmRecord> listAlarmRecord = new ArrayList<BigdataAlarmRecord>();
        for(Alterlogs alterlogs : list){
            try {
                BigdataAlarmRecord alarmRec = fenxiAlarm(alterlogs);
                listAlarmRecord.add(alarmRec);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String json = JSONObject.toJSONString(listAlarmRecord);
        System.out.println(json);
        SortedMap<String,Object> param = new TreeMap<String,Object>();
        param.put("compId",compId);
        param.put("alarms",json);
        String sign = BeidouCompSignUtil.createSign("utf-8",
                param, beidouCompSignKey );
        param.put("sign",sign);
        String res = HttpRequestUtil.postRequest(acceptAlarmUrl,param);
    }

    //将原始报警表分析成报警记录
    private BigdataAlarmRecord fenxiAlarm(Alterlogs alterlogs) throws ParseException {
        BigdataAlarmRecord alarmRec = new BigdataAlarmRecord();
        alarmRec.setAlarmCls(alterlogs.getType()+"");
        alarmRec.setAlarmSpeed(new BigDecimal(alterlogs.getAspeed()));
        alarmRec.setAlarmTime(sdf.parse(alterlogs.getAtime()));
        String remark = alterlogs.getRemark();
        String[] arr = remark.split(",");
        if(arr.length==3){
            String daolu = arr[0];
            String xiansu = arr[1];
            String timeStr = arr[2];
            alarmRec.setAlarmTimeInfo(timeStr);
            if(xiansu!=null && xiansu.length()>0){
                alarmRec.setRoadSpeedLimit(new BigDecimal(xiansu));
            }

            alarmRec.setRoadLevel(daolu);
        }
        alarmRec.setAlarmSpeed(new BigDecimal(alterlogs.getAspeed()));
        alarmRec.setAlarmType(alterlogs.getAtype()+"");
        alarmRec.setBid(alterlogs.getAid()+"");
        alarmRec.setCarPlateColor(alterlogs.getTcarcolour()+"");
        alarmRec.setCarPlateNum(alterlogs.getAcarcode());
        alarmRec.setDriver(alterlogs.getDrivers());
        alarmRec.setLatitude(new BigDecimal(alterlogs.getLatitude()));
        alarmRec.setLongitude(new BigDecimal(alterlogs.getLongitude()));
        alarmRec.setSimCode(alterlogs.getAphone());
        //处理时间
        alarmRec.setDealTime(sdf.parse(alterlogs.getDtime()));
        //处理备注
        alarmRec.setDealRemark(alterlogs.getDremark());
        //处理方式
        alarmRec.setDealType(alterlogs.getDtype());
        return alarmRec;
    }


    public static void main(String[] args) {
        testDriverCard();
    }
}

