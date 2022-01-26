package com.edgedo.timetask.driver;

import com.edgedo.CarAnalysisGpsJob;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayView;
import com.edgedo.timetask.car.BigDataAnalysisRealGpsCar;
import com.edgedo.util.GpsLogFenxiUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CarAnalysisGpsJob.class)
@TestPropertySource(properties ={
        "app.scheduling.enable=false" , "bigdata.jdkStartEncode=GBK"
})
@SpringBootTest
public class BigDataDriverPatitionGpsTrainFenxiTest {
    @Autowired
    BigDataDriverPatitionGpsTrainFenxi dataDriverPatitionGpsTrainFenxi;
    @Autowired
    GpsLogFenxiUtil gpsLogFenxiUtil;
    @Autowired
    BigDataAnalysisRealGpsCar bigDataAnalysisRealGpsCar;

    @Test
    public void fenxiPartitionQueue() throws Exception {
        dataDriverPatitionGpsTrainFenxi.fenxiPartitionQueue();
    }


    @Test
    public void fenxiOneDriverPartitionTimeAndMileOfDay() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int dayInt = 20200218;
        //接下来要分析车辆轨迹 直接按照车牌号和车牌颜色来干
        List<BigdataCarRealtimeGps> listRealTimeGps = new ArrayList<BigdataCarRealtimeGps>();
        String carId = "冀C68376_2";
        String[] plateAndColor = carId.split("_");

        String carPlateNum = plateAndColor[0];
        String carPlateColor = plateAndColor[1];
        try{
            InputStreamReader isr = null;
            BufferedReader br = null;
            try {
                File forder = new File("D:\\gps"+File.separator + carPlateNum);
                File gpsFile = new File(forder, dayInt+".log");
                if(!gpsFile.exists()){
                    System.out.println("文件不存在");
                    return;
                }
                isr = new InputStreamReader(new FileInputStream(gpsFile), "GBK");
                br = new BufferedReader(isr);
                String temLine = null;

                while ((temLine = br.readLine()) != null) {
                    BigdataCarRealtimeGps tempGps = gpsLogFenxiUtil.fenxiOneRealPosition(temLine);
                    if(tempGps==null){
                        continue;
                    }
                    BigDecimal mileage = tempGps.getMileage();
                    if(mileage==null || mileage.doubleValue()==0){
                        continue;
                    }

                    listRealTimeGps.add(tempGps);
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
        BigdataDriverCarPartitionCountDayView carPartitionCountDay
                =new BigdataDriverCarPartitionCountDayView();
        carPartitionCountDay.setStartTime(sdf.parse("2020-02-18 00:00:00"));
        carPartitionCountDay.setEndTime(sdf.parse("2020-02-18 23:59:00"));


        dataDriverPatitionGpsTrainFenxi.fenxiOneDriverPartitionTimeAndMileOfDay(
                dayInt , listRealTimeGps , carPartitionCountDay);
        try {
            Thread.currentThread().sleep(6000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }


    @Test
    public void fenxiOneCarTimeAndMileOfDay() throws Exception {
        bigDataAnalysisRealGpsCar.fenxiOneCarTimeAndMileOfDay("冀C05573_2",new Date());
        try {
            Thread.currentThread().sleep(6000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }


}