package com.edgedo.timetask;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.alarm.entity.Alterlogs;
import com.edgedo.alarm.entity.BigdataAlarmRecord;
import com.edgedo.alarm.entity.BigdataDriverCardRec;
import com.edgedo.alarm.entity.Iclogs;
import com.edgedo.alarm.service.AlterlogsService;
import com.edgedo.alarm.service.IclogsService;
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
 * 同步司机卡拔插卡记录
 */
@Component
public class BigDataTongBuDriverCardRec {
    @Value("${bigdata.beidouCompId}")
    private String compId;
    @Value("${bigdata.acceptDriverCardRecUrl}")
    private String acceptDriverCardRecUrl;
    @Value("${bigdata.beidouCompSignKey}")
    private String beidouCompSignKey;


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    IclogsService iclogsService;

    //1分钟一次的同步司机卡拔插卡记录
    @Scheduled(cron = "0 0/1 * * * ?")
    public void tongbuAlarm(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        //读取8分钟内的数据
        cal.setTime(date);
        cal.add(Calendar.MINUTE,-3);
        synDriverCardRecOfDate(cal.getTime());
    }


    private void synDriverCardRecOfDate(Date time){
        List<Iclogs> list = iclogsService.listIcLogs(time);
        List<BigdataDriverCardRec> driverCardRecList = new ArrayList<BigdataDriverCardRec>();
        for(Iclogs iclogs : list){
            try {
                BigdataDriverCardRec driverCardRec = fenxiDriverCardRec(iclogs);
                driverCardRecList.add(driverCardRec);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String json = JSONObject.toJSONString(driverCardRecList);
        System.out.println(json);
        SortedMap<String,Object> param = new TreeMap<String,Object>();
        param.put("compId",compId);
        param.put("cardRecs",json);
        String sign = BeidouCompSignUtil.createSign("utf-8",
                param, beidouCompSignKey );
        param.put("sign",sign);
        System.out.println("cardRecs===="+json);
        String res = HttpRequestUtil.postRequest(acceptDriverCardRecUrl,param);
    }

    //将原始报警表分析成报警记录
    private BigdataDriverCardRec fenxiDriverCardRec(Iclogs iclogs) throws ParseException {
        BigdataDriverCardRec driverCardRec = new BigdataDriverCardRec();
        driverCardRec.setBid(iclogs.getTid()+"");
        driverCardRec.setCarPlateNum(iclogs.getTcarcode());
        driverCardRec.setDriverName(iclogs.getTname());
        driverCardRec.setLicenceNum(iclogs.getTids());
        driverCardRec.setRecType(iclogs.getTstauts()+"");
        driverCardRec.setCardTime(sdf.parse(iclogs.getTtimes()));
        driverCardRec.setSysReceiveTime(new Date());
        return driverCardRec;
    }
}

