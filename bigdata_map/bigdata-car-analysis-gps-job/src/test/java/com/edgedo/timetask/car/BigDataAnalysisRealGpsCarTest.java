package com.edgedo.timetask.car;

import com.edgedo.CarAnalysisGpsJob;
import com.edgedo.timetask.driver.BigDataDriverPatitionGpsTrainFenxi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CarAnalysisGpsJob.class)
@TestPropertySource(properties ={
        "app.scheduling.enable=false" , "bigdata.jdkStartEncode=GBK"
})
@SpringBootTest
public class BigDataAnalysisRealGpsCarTest {

    @Autowired
    BigDataAnalysisRealGpsCar bigDataAnalysisRealGpsCar;

    @Test
    public void UpdateReadGps() throws Exception {
        bigDataAnalysisRealGpsCar.UpdateReadGps();
    }
}
