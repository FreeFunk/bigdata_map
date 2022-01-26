package com.edgedo.timetask.driver;

import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.bigdata.entity.BigdataDriverCardRec;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.queryvo.BigdataDriverCardRecView;
import com.edgedo.bigdata.service.BigdataDriverCardInfoService;
import com.edgedo.bigdata.service.BigdataDriverCardRecService;
import com.edgedo.bigdata.service.BigdataTimeCarDayRecService;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import com.edgedo.drawing.entity.BigdataDriverCountDay;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayView;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionFenxiQueueVo;
import com.edgedo.drawing.service.BigdataDriverCarPartitionCountDayService;
import com.edgedo.drawing.service.BigdataDriverCountMonthAndYearService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author WangZhen
 * @description 分析司机的相关的行驶情况
 * @date 2020/2/3
 */
@ConditionalOnProperty(
        value = {"timetask.driver.BigdataAnalysisDriverTimeJob.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisDriverTimeJob {
    private Logger LOGGER = LoggerFactory
            .getLogger(BigdataAnalysisDriverTimeJob.class);

    @Autowired
    BigdataTimeCarDayRecService bigdataTimeCarDayRecService;
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    BigdataDriverCardRecService driverCardRecService;
    //负责司机车辆驾驶记录表业务
    @Autowired
    BigdataDriverCarPartitionCountDayService driverCarPartitionService;
    @Autowired
    BigdataDriverCardInfoService driverCardInfoService;
    @Autowired
    BigdataDriverCountMonthAndYearService driverCountMonthAndYearService;
    @Autowired
    RedisUtil redisUtil;


    //车辆和司机每日的分段划分一个车某天是哪些司机开过
    //@Scheduled(cron = "1 0 1 * * ?")
    @Scheduled(cron = "${timetask.driver.BigdataAnalysisDriverTimeJob.cron.fenxiCarDriverDayPartition}")
    public void fenxiCarDriverDayPartition(){

        //0.确定统计时间
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,-1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dayIntStr = sdf.format(date);
        int dayInt = new Integer(dayIntStr);
        int monthInt = dayInt/100;
        int yearInt = monthInt/100;
        Date startTime = null;
        //一天的起点
        try {
            startTime = sdf.parse(dayIntStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH,-1);
        String yestodayIntStr = sdf.format(cal.getTime());
        int yestodayInt = new Integer(yestodayIntStr);
        int yestodayMonthInt = yestodayInt/100;
        //初始化昨天的分段表
       initDriverCarPatition(startTime,yearInt,monthInt,dayInt,yestodayMonthInt,yestodayInt);
    }


    //车辆和司机每日的分段划分一个车某天是哪些司机开过
    //@Scheduled(cron = "0 50 * * * ?")
    @Scheduled(cron = "${timetask.driver.BigdataAnalysisDriverTimeJob.cron.saveDayPartitionAndSumDriverDayRun}")
    public void saveDayPartitionAndSumDriverDayRun(){
        Set<String> driverWaitDaySum = new HashSet<>();
        while(true){
            Object obj = null;
            try {
                obj = redisUtil.rightPop(RedisDbKeyConstant.DRIVER_PARTITION_SAVE_QUEUE);
                if (obj == null) break;
                BigdataDriverCarPartitionCountDayView partitionCountDay = (BigdataDriverCarPartitionCountDayView) obj;
                String driverId = partitionCountDay.getDriverId();
                int countDay = partitionCountDay.getCountDate();
                driverWaitDaySum.add(driverId + "-" + countDay);
                driverCarPartitionService.insertNotExist(partitionCountDay);
            }catch (Exception e){
                LOGGER.error("司机分段驾驶保存失败将任务交回队列-----"+obj,e);
                redisUtil.leftPush(RedisDbKeyConstant.DRIVER_PARTITION_SAVE_QUEUE,obj);
            }
        }
        //TODO:统计司机日统计的部分不稳妥需要单独做任务
        for(String driverAndDay : driverWaitDaySum){
            driverCarPartitionService.updateSumDriverDayCount(driverAndDay);
        }

    }

    /**
     * @Author WangZhen
     * @Description 每天 3点多统计当月
     * @Date 2020/2/6 15:22
     **/
    //@Scheduled(cron = "0 9 3 * * ?")
    @Scheduled(cron = "${timetask.driver.BigdataAnalysisDriverTimeJob.cron.sumDriverCurMonthAndYearCount}")
    public void sumDriverCurMonthAndYearCount() {
        try {
            //统计昨天的数据
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            int dateNum = cal.get(Calendar.DAY_OF_MONTH);
            int monthNum = cal.get(Calendar.MONTH);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dayIntStr = sdf.format(date);
            int dayInt = new Integer(dayIntStr);
            int monthInt = dayInt / 100;
            int yearNum = monthInt/100;
            int totalDriverNum = driverCardInfoService.selectSortNum();
            int oneNum = 1000;
            int times = totalDriverNum / oneNum + (totalDriverNum % oneNum == 0 ? 0 : 1);
            //多线程遍历数据库
            for (int i = 0; i < times; i++) {
                final int fiIndex = i;
//                int start = oneNum * fiIndex;
//                List<BigdataDriverCardInfo> driverCardInfoList = bigdataDriverCardInfoService.listOrderByIdlistByStartAndEndBySortNum(start,end);
               /* for(BigdataDriverCardInfo dri:driverCardInfoList){
                    driverCountMonthAndYearService.updateDriverCountSumMonth(dri,monthInt,yearNum);
                    //判断如果是每月的月初1号那么统计一下上个月的数据
                    if(dateNum==1){
                        cal.add(Calendar.DAY_OF_MONTH,-1);
                        Date date1 = cal.getTime();
                        String dayIntStr1 = sdf.format(date1);
                        int dayInt1 = new Integer(dayIntStr1);
                        int monthInt1 = dayInt1 / 100;
                        int yearNum1 = monthInt1/100;
                        driverCountMonthAndYearService.updateDriverCountSumMonth(dri,monthInt1,yearNum1);
                        //如果是1月1号那么还得整理统计去年的数据
                        if(monthNum==0){
                            driverCountMonthAndYearService.updateDriverCountSumYear(dri,yearNum1);
                        }
                    }
                    //年份
                    driverCountMonthAndYearService.updateDriverCountSumYear(dri,yearNum);

                }*/
                Thread t = new Thread() {
                    int start = oneNum * fiIndex;
                    int end = oneNum * (fiIndex + 1) - 1;
                    @Override
                    public void run() {
                        List<BigdataDriverCardInfo> driverCardInfoList = driverCardInfoService.listByStartAndEndBySortNum(start,end);
                       /* List<BigdataDriverCardInfo> driverCardInfoList = new ArrayList<>();
                        BigdataDriverCardInfo bigdataDriverCardInfo= driverCardInfoService.loadById("b83c55bc114d45c8973e8fe1322d9d46");
                        driverCardInfoList.add(bigdataDriverCardInfo);*/
                        for(BigdataDriverCardInfo dri:driverCardInfoList){
                            driverCountMonthAndYearService.updateDriverCountSumMonth(dri,monthInt,yearNum);
                            //判断如果是每月的月初1号那么统计一下上个月的数据
                            if(dateNum==1){
                                cal.add(Calendar.DAY_OF_MONTH,-1);
                                Date date1 = cal.getTime();
                                String dayIntStr1 = sdf.format(date1);
                                int dayInt1 = new Integer(dayIntStr1);
                                int monthInt1 = dayInt1 / 100;
                                int yearNum1 = monthInt1/100;
                                driverCountMonthAndYearService.updateDriverCountSumMonth(dri,monthInt1,yearNum1);
                                //如果是1月1号那么还得整理统计去年的数据
                                if(monthNum==0){
                                    driverCountMonthAndYearService.updateDriverCountSumYear(dri,yearNum1);
                                }
                            }
                            //年份
                            driverCountMonthAndYearService.updateDriverCountSumYear(dri,yearNum);

                        }
                    }
                };
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Author WangZhen
     * @Description 数据库中初始化分段记录
     * @Date 2020/2/4 11:23
     **/
    private void initDriverCarPatition(
           Date startTime,int yearInt,int monthInt,int dayInt,
           int yestodayMonthInt,int yestodayInt
    ){
        long startTimeLong = System.currentTimeMillis();
        List<String> listCarFrames = bigdataTimeCarDayRecService.selectOperatedCarIdsOfDay(yearInt,monthInt,dayInt);

        for(String carFrameNum :listCarFrames ){

            List<BigdataDriverCarPartitionCountDayView> partitionList = new ArrayList<BigdataDriverCarPartitionCountDayView>();
            try {
                //1.根据根据时间日内的车辆记录确定车辆的驾驶记录
                CarInfo carInfo = carInfoService.selectByCarFrameNum(carFrameNum);
                //2.根据车辆的驾驶记录(司机卡)来汇总驾驶员的驾驶记录
                List<BigdataDriverCardRecView> driverCardRecList = driverCardRecService.selectDriverCarRecOfChakaOfCar(monthInt,dayInt,carInfo.getCarPlateNum(),carInfo.getCarPlateColour());
                String empId = carInfo.getEmpId();
                //3.插入车辆驾驶员驾驶日统计表
                if(driverCardRecList.size()==0){
                    if(empId!=null && empId.length()>0 ){
                        //直接就是一条记录 关联车辆的维护的从业人员
                        BigdataDriverCarPartitionCountDayView driverCarPartitionCountDay
                                = new BigdataDriverCarPartitionCountDayView();
                        driverCarPartitionCountDay.initByCarInfoAndDriverCardInfoOnlyOne(
                                carInfo,startTime,yearInt,monthInt, dayInt,null,0);
                        //插入记录
//                        driverCarPartitionService.insertNotExist(driverCarPartitionCountDay);
                        partitionList.add(driverCarPartitionCountDay);
                    }

                }else{
                    //根据昨天最后一条决定从凌晨到今日第一条这段时间的开车记录
                    BigdataDriverCarPartitionCountDayView lastpartition = null;
                    int count = 0;
                    BigdataDriverCardRecView todayFirstCarRec = driverCardRecList.get(0);
                    //多条记录
                    BigdataDriverCardRecView yestodayLastCardRecView =  driverCardRecService.selectLastDriverCarRecOfChakaOfCar(yestodayMonthInt,yestodayInt,carInfo.getCarPlateNum(),carInfo.getCarPlateColour());
                    if(yestodayLastCardRecView!=null){
                        //昨天没有记录那么第一条就是今天的这条
                        //否则对比这个记录的今天的第一条是不是一个司机卡
                        String driverCode1 = yestodayLastCardRecView.getLicenceNum();
                        String driverCode2 = todayFirstCarRec.getLicenceNum();
                        if(!driverCode1.equals(driverCode2)){
                            //第一条和昨天的不一致,那么今天的第一条就是昨天的这条产生的
                            //直接就是一条记录 关联车辆的维护的从业人员
                            BigdataDriverCardInfo driverCardInfo = driverCardInfoService.selectDriverInfo(driverCode1);
                            if(driverCardInfo!=null) {
                                BigdataDriverCarPartitionCountDayView driverCarPartitionCountDay
                                        = new BigdataDriverCarPartitionCountDayView();
                                driverCarPartitionCountDay.initByCarInfoAndDriverCardInfoOnlyOne(
                                        carInfo, startTime, yearInt, monthInt, dayInt, driverCardInfo,count++
                                );
                                lastpartition = driverCarPartitionCountDay;
                            }
                        }
                    }

                    for(BigdataDriverCardRecView driverCardRec : driverCardRecList){
                        String thisDriverCode = driverCardRec.getLicenceNum();
                        if(lastpartition==null){//昨天的为空-第一次今天这个是第一次
                            BigdataDriverCardInfo driverCardInfo = driverCardInfoService.selectDriverInfo(thisDriverCode);
                            if(driverCardInfo!=null) {
                                BigdataDriverCarPartitionCountDayView driverCarPartitionCountDay  = new BigdataDriverCarPartitionCountDayView();
                                driverCarPartitionCountDay.initByCarInfoAndDriverCardInfoOnlyOne(
                                        carInfo, startTime, yearInt, monthInt, dayInt, driverCardInfo,count++
                                );
                                lastpartition = driverCarPartitionCountDay;
                            }
                        }else{//否则就是正常判断是否相同如果相同那么合并
                            String lastDriverCode = lastpartition.getDriverCode();

                            //如果昨天最后一条和今天的第一条是一个司机那么第一条的开始时间就是凌晨
                            //否则需要创建一条新的驾驶记录和昨日最后一条关联
                            if(!lastDriverCode.equals(thisDriverCode)){
                                //下一条的开始时间是上一条的结束时间
                                //两个不一致那么将本次的开始时间设置为上次的结束时间
                                lastpartition.setEndTime(driverCardRec.getCardTime());
                                //插入数据库并且创建下一次的开始记录
//                                driverCarPartitionService.insertNotExist(lastpartition);
                                partitionList.add(lastpartition);
                                //直接就是一条记录 关联车辆的维护的从业人员
                                BigdataDriverCardInfo driverCardInfo = driverCardInfoService.selectDriverInfo(thisDriverCode);
                                if(driverCardInfo!=null) {
                                    lastpartition = new BigdataDriverCarPartitionCountDayView();
                                    lastpartition.initByCarInfoAndDriverCardInfoOnlyOne(
                                            carInfo, driverCardRec.getCardTime(), yearInt, monthInt, dayInt, driverCardInfo,count++
                                    );
                                }

                            }
                        }
                    }
                    if(lastpartition!=null){
                        //最后一条的结束时间是到一天的结束
                        lastpartition.setEndTime(new Date(startTime.getTime()+86340000L));
                        //插入最后一条
//                        driverCarPartitionService.insertNotExist(lastpartition);
                        partitionList.add(lastpartition);
                    }
                }
                if(partitionList.size()>0){
                    BigdataDriverCarPartitionFenxiQueueVo fenxiQueueVo
                            = new BigdataDriverCarPartitionFenxiQueueVo();
                    fenxiQueueVo.setPartitionList(partitionList);
                    fenxiQueueVo.setCarId(carInfo.getId());
                    fenxiQueueVo.setDayInt(dayInt);
                    //将这个存入待处理队列
                    redisUtil.leftPush(RedisDbKeyConstant.DRIVER_PARTITION_FENXI_QUEUE , fenxiQueueVo);
                }

            }catch (Exception e){
                LOGGER.error("----分析驾驶员行驶记录异常",e);
            }

        }
        long endTimeLong = System.currentTimeMillis();

        LOGGER.info(new Date() + "----initDriverCarPatition done " + (endTimeLong-startTimeLong)/1000);

    }



}
