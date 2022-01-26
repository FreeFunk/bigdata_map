package com.edgedo.timetask.transmit;


import com.edgedo.CarAnalysisOperJob;
import com.edgedo.timetask.analysis.BigDataAnalysisQuXiangFenbu;
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
public class BigdataTransmitPlatLoadJobTest {

    @Autowired
    BigdataTransmitPlatLoadJob bigdataTransmitPlatLoadJob;

    @Test
    public void loadTransmitPlat() throws InterruptedException {
        bigdataTransmitPlatLoadJob.loadTransmitPlat();
        Thread.currentThread().sleep(600000000L);
    }
}
