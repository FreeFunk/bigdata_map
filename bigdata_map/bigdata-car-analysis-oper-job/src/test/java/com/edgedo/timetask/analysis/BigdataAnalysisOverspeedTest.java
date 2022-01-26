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
public class BigdataAnalysisOverspeedTest {

    @Autowired
    BigdataAnalysisOverspeed bigdataAnalysisOverspeed;

    @Test
    public void execute() throws InterruptedException {
        bigdataAnalysisOverspeed.execute();
        Thread.currentThread().sleep(600000000L);
    }

    @Test
    public void overSpeedSumCount() throws InterruptedException {
        bigdataAnalysisOverspeed.overSpeedSumCount();
        Thread.currentThread().sleep(600000000L);
    }

}
