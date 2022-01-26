package com.edgedo.timetask.analysis;

import com.edgedo.CarAnalysisOperJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CarAnalysisOperJob.class)
@TestPropertySource(properties = "app.scheduling.enable=false")
@SpringBootTest
public class BigDataAnalysisQuXiangFenbuTest {

    @Autowired
    BigDataAnalysisQuXiangFenbu bigDataAnalysisQuXiangFenbu;
    @Autowired
    BigDataAnalysisCarStop bigDataAnalysisCarStop;


    @Test
    public void changpaoXianluTj() throws InterruptedException {
        bigDataAnalysisQuXiangFenbu.changpaoXianluTj();
        Thread.currentThread().sleep(600000000L);
    }

    @Test
    public void changpaoCarMonthJiduCount() throws InterruptedException {
        bigDataAnalysisQuXiangFenbu.changpaoCarMonthJiduCount();
        Thread.currentThread().sleep(600000000L);
    }

    @Test
    public void fenxiStopRecord() throws InterruptedException {
        bigDataAnalysisQuXiangFenbu.fenxiStopRecord();
        Thread.currentThread().sleep(600000000L);
    }


    @Test
    public void fenxiCarStopRec() throws InterruptedException {
        bigDataAnalysisCarStop.fenxiCarStopRec();
        Thread.currentThread().sleep(600000000L);
    }

}
