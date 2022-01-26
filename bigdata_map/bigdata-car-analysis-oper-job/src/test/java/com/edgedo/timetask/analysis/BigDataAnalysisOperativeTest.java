package com.edgedo.timetask.analysis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.CarAnalysisOperJob;
import com.edgedo.bigdata.entity.AlarmInfo;
import com.edgedo.bigdata.entity.BigdataAlarmInfoVo;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayView;
import com.edgedo.timetask.alarm.Get2gAlertAndCardInfoFromQueue;
import com.edgedo.timetask.alarm.GetAlarmFromRedis;
import com.edgedo.timetask.beidou.BigdataBeidouComDayAnalysis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CarAnalysisOperJob.class)
@TestPropertySource(properties = "app.scheduling.enable=false")
@SpringBootTest
public class BigDataAnalysisOperativeTest {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    BigDataAnalysisOperative bigDataAnalysisOperative;
    @Autowired
    BigdataUpdateCarInfo bigdataUpdateCarInfo;
    @Autowired
    BigdataAnalysisTimeInfo bigdataAnalysisTimeInfo;
    @Autowired
    GetAlarmFromRedis getAlarmFromRedis;
    @Autowired
    BigdataBeidouComDayAnalysis bigdataBeidouComDayAnalysis;
    @Autowired
    UpdateMapPoint updateMapPoint;
    @Autowired
    BigDataAnalysisOperativeInfo bigDataAnalysisOperativeInfo;
    @Autowired
    BigdataAnalysisOverspeed bigdataAnalysisOverspeed;
    @Autowired
    BigdataAnalysisPushLearnRec bigdataAnalysisPushLearnRec;

    @Test
    public void fenxiPushLearnRec() throws Exception {
        bigdataAnalysisPushLearnRec.initData();
        Thread.currentThread().sleep(60000000L);
    }
    @Test
    public void synCarLocationInfo() throws Exception {
        bigDataAnalysisOperative.synCarLocationInfo();
        Thread.currentThread().sleep(60000000L);
    }
    @Test
    public void bigdataAnalysisOverspeed() throws Exception {
        bigdataAnalysisOverspeed.execute();
        Thread.currentThread().sleep(6000000L);
    }

    @Test
    public void synCarLocationInfoGps() throws Exception {
        bigDataAnalysisOperative.synCarLocationInfoGps();
        Thread.currentThread().sleep(600000L);
    }


    @Test
    public void initCarGpsInfo() throws Exception {
        bigDataAnalysisOperative.initCarGpsInfo();
    }

    @Test
    public void fenxiOpertiveInfo() throws Exception {
        bigDataAnalysisOperative.fenxiOpertiveInfo();
    }



    @Test
    public void redisTest() throws Exception {
//        Object obj = redisUtil.hget(RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY, "冀C32663_2");
//        Object obj = redisUtil.rightPop("alarmList");
//        String jsonStr= JSON.toJSONString(obj);
//        AlarmInfo alarmInfo = JSON.parseObject(jsonStr, AlarmInfo.class);
//        System.out.println(obj);
    }

    @Test
    public void tongBuCarInfoByGps1() throws Exception {
        bigdataUpdateCarInfo.tongBuCarInfoByGps1();
        Thread.currentThread().sleep(600000L);
    }

    @Test
    public void carDayTimeInfo() throws Exception {
        bigdataAnalysisTimeInfo.carDayTimeInfo();
        Thread.currentThread().sleep(60000000000L);
    }

    @Test
    public void sumCarDayTimeInfo() throws Exception {
        bigdataAnalysisTimeInfo.sumCarDayTimeInfo();
        Thread.currentThread().sleep(60000000000L);
    }

    @Test
    public void getSafetyFileInfo() throws Exception {
        getAlarmFromRedis.getSafetyFileInfo();
        Thread.currentThread().sleep(600000L);
    }

    @Test
    public void updateCarInfo() throws Exception {
        bigdataUpdateCarInfo.updateCarInfo();
        Thread.currentThread().sleep(600000L);
    }

    @Test
    public void updateComDayCheck() throws Exception {
        bigdataBeidouComDayAnalysis.initData();
        Thread.currentThread().sleep(6000000);
    }


    @Test
    public void countByCarType() throws Exception {
        updateMapPoint.countByCarType();
        Thread.currentThread().sleep(600000L);
    }

    @Test
    public void updateCityAnalysisDay() throws Exception {
        bigDataAnalysisOperativeInfo.initData();
        Thread.currentThread().sleep(600000L);
    }

    @Test
    public void initTeamCount() throws Exception {
        bigDataAnalysisOperativeInfo.initTeamCount();
        Thread.currentThread().sleep(60000000);
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(Get2gAlertAndCardInfoFromQueue.class);
    @Test
    public void fenxiOneAlarmInfoVo() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //接下来要分析车辆轨迹 直接按照车牌号和车牌颜色来干
        List<Get2gAlertAndCardInfoFromQueue.AlertInfo> alarmInfoVoList = new ArrayList<Get2gAlertAndCardInfoFromQueue.AlertInfo>();
        List<String> stringList = new ArrayList<>();
        stringList.add("alert1.log");
        stringList.add("alert2.log");
        stringList.add("alert3.log");
        stringList.add("alert4.log");
        try{
            InputStreamReader isr = null;
            BufferedReader br = null;
            try {
                for(String s:stringList){
                    File forder = new File("E:\\gps");
                    File gpsFile = new File(forder, s);
                    if(!gpsFile.exists()){
                        System.out.println("文件不存在");
                        return;
                    }
                    isr = new InputStreamReader(new FileInputStream(gpsFile), "UTF-8");
                    br = new BufferedReader(isr);
                    String temLine = null;

                    while ((temLine = br.readLine()) != null) {
                        Get2gAlertAndCardInfoFromQueue.AlertInfo bigdataAlarmInfoVo = fenxiOneAlarmInfo(temLine);
                        if(bigdataAlarmInfoVo==null){
                            continue;
                        }
                        alarmInfoVoList.add(bigdataAlarmInfoVo);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    if(br!=null){
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(isr!=null){
                        isr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        int count = 0;
        System.out.println(alarmInfoVoList.size());
        LOGGER.error(alarmInfoVoList.size()+"");
        for(Get2gAlertAndCardInfoFromQueue.AlertInfo a:alarmInfoVoList){
            bigDataAnalysisOperativeInfo.insertAlarmInfoVo(a);
            System.out.println(count++);
        }
        System.out.println("分析完成======================");
        try {
            Thread.currentThread().sleep(6000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }

    public Get2gAlertAndCardInfoFromQueue.AlertInfo fenxiOneAlarmInfo(String temLine){
        //2020-04-10 07:38:02.782  {"HANDLER_TYPE":"下发短信","RECV_TIME":"2020-04-10 07:38:02",
        // "LONGITUDE":"91.893303","HANDLER_NAME":"admin","DRIVER_NAME":"王红刚","SERV_INFO":"182.92.67.1:46642",
        // "WARN_SRC":2,"HANDLER_TIME":"2020-04-10 07:35:32","WARN_TIME":"2020-04-10 07:37:48","SPEED":"103",
        // "CAR_CODE":"冀CA8596","HANDLER_CONTENT":"您已超速，请减速慢行，注意安全驾驶！","WARN_TYPE":256,"ID":"33122788",
        // "TYPE":"2","LATITUDE":"43.402055","DURATION":"21秒","CAR_COLOR":"2"}
        String jieguo = temLine.substring(temLine.indexOf("{"),temLine.indexOf("}")+1);
        System.out.println(jieguo);
        Get2gAlertAndCardInfoFromQueue.AlertInfo bigdataAlarmInfoVo = (Get2gAlertAndCardInfoFromQueue.AlertInfo) JSONObject.parseObject(jieguo, Get2gAlertAndCardInfoFromQueue.AlertInfo.class);
        return bigdataAlarmInfoVo;

    }

}