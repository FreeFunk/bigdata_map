package com.edgedo.timetask.driver;

import com.edgedo.CarAnalysisOperJob;
import com.edgedo.bigdata.service.SysMonitorAlarmService;
import com.edgedo.phonemsgclient.ISysPhoneVoiceMsgClientService;
import com.edgedo.timetask.driver.BigdataAnalysisDriverTimeJob;
import com.edgedo.timetask.monitor.BigdataMonitorTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author WangZhen
 * @description
 * @date 2020/2/5
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CarAnalysisOperJob.class)
@TestPropertySource(properties = "app.scheduling.enable=false")
@SpringBootTest
public class BigdataAnalysisDriverTimeJobUnitTest {

    @Autowired
    BigdataAnalysisDriverTimeJob driverTimeJob;
    @Autowired
    BigdataAnalysisDriverAlarm bigdataAnalysisDriverAlarm;
    @Autowired
    BigdataAnalysisDriverDrawInfo bigdataAnalysisDriverDrawInfo;
    @Autowired
    ISysPhoneVoiceMsgClientService voiceMsgClientService;

    @Test
    public void fenxiCarDriverDayPartition(){
        driverTimeJob.fenxiCarDriverDayPartition();
        try {
            Thread.currentThread().sleep(6000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveDayPartitionAndSumDriverDayRun(){
        driverTimeJob.saveDayPartitionAndSumDriverDayRun();
        try {
            Thread.currentThread().sleep(6000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void sumDriverCurMonthCount(){
        driverTimeJob.sumDriverCurMonthAndYearCount();
        try {
            Thread.currentThread().sleep(6000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void fenxiDriverAlarmCount(){
        bigdataAnalysisDriverAlarm.fenxiDriverAlarmCount();
        try {
            Thread.currentThread().sleep(6000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fenxiDriverDrawInfo(){
        bigdataAnalysisDriverDrawInfo.fenxiDriverDrawInfo();
        try {
            Thread.currentThread().sleep(6000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Autowired
    BigdataMonitorTask task;
    @Test
    public void monitorGpsData(){
      task.monitorGpsData();
    }








}
