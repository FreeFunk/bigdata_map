package com.edgedo.timetask.alarm;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.CarAnalysisOperJob;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CarAnalysisOperJob.class)
@TestPropertySource(properties = "app.scheduling.enable=false")
@SpringBootTest
public class Get2gAlertAndCardInfoFromQueueTest {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    Get2gAlertAndCardInfoFromQueue get2gAlertAndCardInfoFromQueue;
    @Autowired
    GetAlarmFromRedis getAlarmFromRedis;
    @Test
    public void downQueueAlert2Db() throws Exception {
        get2gAlertAndCardInfoFromQueue.downQueueAlert2Db();
    }

    /**
     * @Author WangZhen
     * @Description 测试json正确性
     * @Date 2020/3/24 9:09
     **/

    @Test
    public void downDriverCardRec2Db() throws Exception {
        get2gAlertAndCardInfoFromQueue.downDriverCardRec2Db();
    }
    @Test
    public void getAlarm() throws Exception {
        getAlarmFromRedis.getAlarm();
    }
    @Test
    public void getSafetyFileInfo() throws Exception {
        getAlarmFromRedis.getSafetyFileInfo();
    }
    @Test
    public void deleteAlarmTimeKey() throws Exception {
        getAlarmFromRedis.deleteAlarmTimeKey();
    }



}