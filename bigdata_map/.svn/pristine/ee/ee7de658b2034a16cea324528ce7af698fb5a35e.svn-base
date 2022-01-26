package com.edgedo.timetask.driver;

import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.GpsPeriodFenxiTemVo;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayView;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionFenxiQueueVo;
import com.edgedo.util.GpsLogFenxiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author WangZhen
 * @description 司机相关的gps 轨迹分析
 * @date 2020/2/4
 */
@ConditionalOnProperty(
        value = {"timetask.driver.BigDataDriverPatitionGpsTrainFenxi.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigDataDriverPatitionGpsTrainFenxi {
    //日志工具
    private Logger LOGGER = LoggerFactory.getLogger(BigDataDriverPatitionGpsTrainFenxi.class);

    //历史文件文件夹
    @Value("${bigdata.dataHistoryGpsForder}")
    private String dataHistoryGpsForder;
    //默认编码模式
    @Value("${bigdata.jdkStartEncode}")
    private String jdkStartEncode;
    //车牌号前缀
    @Value("${bigdata.carPlatePrefix}")
    private String carPlatePrefix;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    GpsLogFenxiUtil gpsLogFenxiUtil;
    //格式化成整数
    SimpleDateFormat sdfDayInt = new SimpleDateFormat("yyyyMMdd");

    SimpleDateFormat sdfFull = new SimpleDateFormat("yyyy-MM-dd HH:mm");



    /**
     * @Author WangZhen
     * @Description 分析队列中的司机驾驶习惯
     * @Date 2020/2/4 15:06
     **/
//    @Scheduled(cron = "0 * * * * ?")
    @Scheduled(cron = "${timetask.driver.BigDataDriverPatitionGpsTrainFenxi.cron.fenxiPartitionQueue}")
    public void fenxiPartitionQueue(){
        if(jdkStartEncode==null || !jdkStartEncode.equals("GBK")){
            return;
        }
        LOGGER.info("-------  begin  -----");
        int count = 0;
        long startTimeLong = System.currentTimeMillis();
        while(true){
            LOGGER.info("-------  read  -----0");
            //从队列里pop一个map对象
            Object obj = redisUtil.rightPop(RedisDbKeyConstant.DRIVER_PARTITION_FENXI_QUEUE);
            LOGGER.info("-------  read  -----1-" + (obj==null));
            //根据car_id和时间和分段来共同解析
            if(obj != null){
                LOGGER.info("-------  read  -----2");
                BigdataDriverCarPartitionFenxiQueueVo queueVo = (BigdataDriverCarPartitionFenxiQueueVo)obj;

                List<BigdataDriverCarPartitionCountDayView> partitionList = queueVo.getPartitionList();
                String carId = queueVo.getCarId();
                Integer dayInt = queueVo.getDayInt();
                //接下来要分析车辆轨迹 直接按照车牌号和车牌颜色来干
                List<BigdataCarRealtimeGps> listRealTimeGps = new ArrayList<BigdataCarRealtimeGps>();

                String[] plateAndColor = carId.split("_");
                if(plateAndColor.length!=2) continue;
                String carPlateNum = plateAndColor[0];
                String carPlateColor = plateAndColor[1];
                try{
                    InputStreamReader isr = null;
                    BufferedReader br = null;
                    try {
                        File forder = new File(dataHistoryGpsForder+File.separator + carPlateNum);
                        File gpsFile = new File(forder, dayInt+".log");
                        if(!gpsFile.exists()){
                            continue;
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
                        continue;
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
                    LOGGER.error("读取轨迹错误",e);
                }
                for(BigdataDriverCarPartitionCountDayView carPartitionCountDay : partitionList){
                    fenxiOneDriverPartitionTimeAndMileOfDay(dayInt,listRealTimeGps,carPartitionCountDay);
                }
                //分析完成之后放入队列-->存一次触发一次统计
                redisUtil.leftPushAll(RedisDbKeyConstant.DRIVER_PARTITION_SAVE_QUEUE,partitionList);
                listRealTimeGps.clear();
                partitionList.clear();
            }else{
                break;
            }
        }

        long endTimeLong = System.currentTimeMillis();

        LOGGER.info(
                "----- fenxi " + count + " car driver partition use " + (endTimeLong-startTimeLong)/1000 + " sec"
         );

    }

    /**
     * @Author WangZhen
     * @Description 分析司机分段的里程时长和速度统计
     * --->参考 BigDataAnalysisRealGpsCar#fenxiOneCarTimeAndMileOfDay(java.lang.String, java.util.Date)
     * @Date 2020/2/4 16:19
     **/
    public void fenxiOneDriverPartitionTimeAndMileOfDay(
            int dayInt,
            List<BigdataCarRealtimeGps> listRealTimeGps,
            BigdataDriverCarPartitionCountDayView carPartitionCountDay
            ){
        Date startTime = carPartitionCountDay.getStartTime();
        Date endTime = carPartitionCountDay.getEndTime();
        //0.读到文件
        try{
            BigdataCarRealtimeGps lastGps = null;
            GpsPeriodFenxiTemVo todayTotalFenxiVo = new GpsPeriodFenxiTemVo();
            //凌晨(2点-5点)
            GpsPeriodFenxiTemVo lingChenDriveFenxiVo = new GpsPeriodFenxiTemVo();
            //清晨(5点-7点)
            GpsPeriodFenxiTemVo morningDriveFenxiVo = new GpsPeriodFenxiTemVo();
            //中午(12点-14点)
            GpsPeriodFenxiTemVo noonDriveFenxiVo = new GpsPeriodFenxiTemVo();
            //黄昏(17点-19点)
            GpsPeriodFenxiTemVo duskDriveFenxiVo = new GpsPeriodFenxiTemVo();
            //午夜(22-最后)
            GpsPeriodFenxiTemVo nightDriveFenxiVo = new GpsPeriodFenxiTemVo();
            ////白天 6-18点
            GpsPeriodFenxiTemVo baitianDriveFenxiVo = new GpsPeriodFenxiTemVo();
           //夜间 = 整天-白天
            GpsPeriodFenxiTemVo wanshangDriveFenxiVo = null;

                for (BigdataCarRealtimeGps tempGps:  listRealTimeGps.stream().filter(
                        t -> (t.getLastPositionTime().getTime()>startTime.getTime()&&t.getLastPositionTime().getTime()<endTime.getTime())
                ).collect(Collectors.toList())) {

                    BigDecimal mileage = tempGps.getMileage();
                    if(mileage==null || mileage.doubleValue()==0){
                        continue;
                    }
                    Date positionTime = tempGps.getLastPositionTime();
                    int hour = positionTime.getHours();
                    //过滤掉跳日期的
                    String positionDay = sdfDayInt.format(positionTime);
                    if(!positionDay.equals(dayInt+"")){//跳天数的点忽略
                        continue;
                    }
                    //跳时间的点

                    //如果两个点之间相差大于10分钟说明 就算他停车拉闸了
                    boolean  jumpTimeFlag = false;
                    if(lastGps!=null){
                        Date lastPositionTime = lastGps.getLastPositionTime();
                        long timeCha = positionTime.getTime() - lastPositionTime.getTime();
                        BigDecimal thisMile = tempGps.getMileage();
                        BigDecimal lastMile = lastGps.getMileage();

                        if(timeCha>=900000){
                            jumpTimeFlag = true;
                        }
                    }
                    double realSpeed = tempGps.getRealSpeed().doubleValue();
                    double gpsSpeed = tempGps.getGpsSpeed().doubleValue();
                    if(gpsSpeed>realSpeed){
                        realSpeed = gpsSpeed;
                    }
                    //速度如果大于0但是本次的坐标和上次的坐标一至就是速度误报
                    String thisPoint = tempGps.getPointLat()+"-" +tempGps.getPointLong();
                    if(lastGps!=null){
                        String lastPoint = lastGps.getPointLat() + "-" + lastGps.getPointLong();
                        if(thisPoint.equals(lastPoint)){
                            realSpeed = 0;
                            continue;
                        }
                    }
                    //总里程和时长
                    todayTotalFenxiVo.fenxiFunc(tempGps,jumpTimeFlag,realSpeed,lastGps);

                    //3.分段行驶时长
                    //凌晨(2点-5点)
                    if(hour>=2&& hour<5){
                        lingChenDriveFenxiVo.fenxiFunc(tempGps,jumpTimeFlag,realSpeed,lastGps);
                    }else if(hour>=5&& hour<7){//清晨(5点-7点)
                        morningDriveFenxiVo.fenxiFunc(tempGps,jumpTimeFlag,realSpeed,lastGps);
                    }else if(hour >=12 && hour<14){//中午(12点-14点)
                        noonDriveFenxiVo.fenxiFunc(tempGps,jumpTimeFlag,realSpeed,lastGps);
                    }else if(hour>=17 && hour<19){//黄昏(17点-19点)
                        duskDriveFenxiVo.fenxiFunc(tempGps,jumpTimeFlag,realSpeed,lastGps);

                    }else if(hour>22){//午夜(22-最后)
                        nightDriveFenxiVo.fenxiFunc(tempGps,jumpTimeFlag,realSpeed,lastGps);
                    }
                   if(hour>=6 && hour<=18){
                        baitianDriveFenxiVo.fenxiFunc(tempGps,jumpTimeFlag,realSpeed,lastGps);
                    }

                    //4.停车记录
                    if(jumpTimeFlag){
                        lastGps=null;
                    }else{
                        lastGps = tempGps;
                        todayTotalFenxiVo.setLatestMileage(lastGps.getMileage());
                    }


                }
               /* if(todayTotalFenxiVo.isDrive()){
                    return ;
                }*/
            todayTotalFenxiVo.sumData();
            lingChenDriveFenxiVo.sumData();
            morningDriveFenxiVo.sumData();
            noonDriveFenxiVo.sumData();
            duskDriveFenxiVo.sumData();
            nightDriveFenxiVo.sumData();
            baitianDriveFenxiVo.sumData();

            //夜间行驶 = 整天 - 白天
            wanshangDriveFenxiVo = todayTotalFenxiVo.subtract(baitianDriveFenxiVo);
            GpsPeriodFenxiTemVo dangerDriverVo = lingChenDriveFenxiVo;
            dangerDriverVo.plusSumData(
                    morningDriveFenxiVo,noonDriveFenxiVo,duskDriveFenxiVo,nightDriveFenxiVo
            );
            carPartitionCountDay.setSumMileage(todayTotalFenxiVo.getTotalMileage());
            carPartitionCountDay.setSumRunTimeLength(todayTotalFenxiVo.getTotalDriveMin());
            carPartitionCountDay.setAverageSpeed(todayTotalFenxiVo.getAverageSpeed());
            //这里也能做出分别的最高时速
            carPartitionCountDay.setHighestSpeed(new BigDecimal(todayTotalFenxiVo.getHighSpeed()));
            carPartitionCountDay.setDayRunMileage(baitianDriveFenxiVo.getTotalMileage());
            carPartitionCountDay.setDayRunTimeLength(baitianDriveFenxiVo.getTotalDriveMin());
            carPartitionCountDay.setDayRunAverageSpeed(baitianDriveFenxiVo.getAverageSpeed());

            carPartitionCountDay.setNightRunMileage(wanshangDriveFenxiVo.getTotalMileage());
            carPartitionCountDay.setNightRunTimeLength(wanshangDriveFenxiVo.getTotalDriveMin());
            carPartitionCountDay.setNightRunAverageSpeed(wanshangDriveFenxiVo.getAverageSpeed());

            carPartitionCountDay.setDangerRunMileage(dangerDriverVo.getTotalMileage());
            carPartitionCountDay.setDangerRunTimeLength(dangerDriverVo.getTotalDriveMin());
            carPartitionCountDay.setDangerRunAverageSpeed(dangerDriverVo.getAverageSpeed());



        }catch (Exception e){
            LOGGER.error("分析车辆轨迹报错误" ,e);
        }

    }



}
