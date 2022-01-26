package com.edgedo.timetask.car;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.GpsPeriodFenxiTemVo;
import com.edgedo.bigdata.service.BigdataCarRealtimeGpsService;
import com.edgedo.common.util.BaiDuMapApiUtil;
import com.edgedo.common.util.MapPointInfo;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import com.edgedo.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 分析车辆任务
 */
@ConditionalOnProperty(
        value = {"timetask.car.BigDataAnalysisRealGpsCar.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigDataAnalysisRealGpsCar {

    Logger LOGGER = LoggerFactory.getLogger(BigDataAnalysisRealGpsCar.class);

    //实时文件的路径
    @Value("${bigdata.dataRealTimeGpsFilePath}")
    private String dataRealTimeGpsFilePath;
    @Value("${bigdata.dataHistoryGpsForder}")
    private String dataHistoryGpsForder;
    @Value("${bigdata.jdkStartEncode}")
    private String jdkStartEncode;
    @Value("${bigdata.carPlatePrefix}")
    private String carPlatePrefix;
    @Value("${bigdata.carGpsPriorityIpAddresses}")
    private String carGpsPriorityIpAddresses;



    @Autowired
    BigdataCarRealtimeGpsService bigdataCarRealtimeGpsService;
    @Autowired
    RedisUtil redisUtil ;
    @Autowired
    BaiDuMapApiUtil baiDuMapApiUtil;
    @Autowired
    GpsLogFenxiUtil gpsLogFenxiUtil;
    //格式化

    //格式化成整数
    SimpleDateFormat sdfDayInt = new SimpleDateFormat("yyyyMMdd");

    //清空地图点
//    @Scheduled(cron = "0 2 0 * * ?")
    @Scheduled(cron = "${timetask.car.BigDataAnalysisRealGpsCar.cron.clearCatchGps}")
    public void clearCatchGps(){

        try{
            redisUtil.del(RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY);
            bigdataCarRealtimeGpsService.delCarPlateIdSet();
//            redisUtil.del(BigdataCarRealtimeGpsService.CAR_REAL_TIME_STOP_MAP_KEY);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    //分析车辆实时位置
//    @Scheduled(cron = "0/10 * * * * ?")
    @Scheduled(cron = "${timetask.car.BigDataAnalysisRealGpsCar.cron.UpdateReadGps}")
    public void UpdateReadGps(){
        //如果时间在凌晨0点 5分之前返回
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minu = cal.get(Calendar.MINUTE);
        int temNum = hour*10 + minu;
        if(temNum<=5){
            return;
        }
        try{
            long start = System.currentTimeMillis();
            Set<String> carIdSet = new HashSet<String>();
            List<BigdataCarRealtimeGps> listAnalysysGps = new ArrayList<BigdataCarRealtimeGps>();
            Map<String,Object>  ipTimeMap = new HashMap<String,Object>();
            InputStreamReader isr = null;
            BufferedReader br = null;

            try {
                isr = new InputStreamReader(new FileInputStream(dataRealTimeGpsFilePath), "GBK");
                br = new BufferedReader(isr);
                String temLine = null;


                while ((temLine = br.readLine()) != null) {
                    BigdataCarRealtimeGps realtimeGps = gpsLogFenxiUtil.fenxiOneRealPosition(temLine);
                    if(realtimeGps==null){
                        continue;
                    }
                    String ip = realtimeGps.getIp();
                    if(!ipTimeMap.containsKey(ip)){
                        ipTimeMap.put(ip,new Date());
                    }

                    String carPlateNum = realtimeGps.getCarPlateNum();
                    if(!checkCarPlateNum(carPlateNum)){
                        continue;
                    }
                    if(carPlateNum==null || carPlateNum.indexOf(carPlatePrefix)<0){
                        continue;
                    }
                    //1:蓝色, 2:黄色,	 3:黑色,	 4:白色, 7:黄绿相间	 9:其他
                    String carPlateColorCode = realtimeGps.getCarPlateColor();
                    if("1,2,3,4,7,9,".indexOf(carPlateColorCode + ",") < 0){
                        continue;
                    }

                    String id = carPlateNum + "_" + realtimeGps.getCarPlateColor();
                    //如果有两个车指向同一个ip那么需要做一下优先级了 目前只针对瑞明和 轩易行
                   /* if(carIdSet.contains(id)){//已经有了要看看这次的ip是否在优先里
                        if(carGpsPriorityIpAddresses.indexOf(ip)<0){//不是优先ip那么后来的弃用了
                            continue;//结束更新
                        }
                    }*/

                    realtimeGps.setId(id);
                    listAnalysysGps.add(realtimeGps);

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

            for(BigdataCarRealtimeGps carRealtimeGps : listAnalysysGps){
                Date lastPositionTime = carRealtimeGps.getLastPositionTime();
                Date now = new Date();
                long nowLong = now.getTime();
                long lastPositionTimeLong = lastPositionTime.getTime();
                boolean delCarFlag = false;
                //如果上次定位时间和当前时间对比超过1个小时那么从缓存中清除
                if(Math.abs( nowLong - lastPositionTimeLong ) > 3600000){
                    delCarFlag = true;
                }
                //如果定位时间不是今天那么从缓存中清除
                String  positionTimeStr = DateUtil.formatYmdDate(lastPositionTime);
                String todayTimeStr = DateUtil.formatYmdDate(now);
                if(!positionTimeStr.equals(todayTimeStr)){
                    delCarFlag = true;
                }
                if(delCarFlag){
                    carIdSet.remove(carRealtimeGps.getId());
                    redisUtil.hdel(RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY,carRealtimeGps.getId());
                }else {
                    carIdSet.add(carRealtimeGps.getId());
                    bigdataCarRealtimeGpsService.updateCarLocaltion(carRealtimeGps);
                }
            }
            redisUtil.sSet(RedisDbKeyConstant.CAR_REAL_TIME_GPS_CAR_PLATE_ID_KEY , carIdSet.toArray());
            redisUtil.hmset("IP_KEY",ipTimeMap);
            listAnalysysGps.clear();
            carIdSet.clear();
            ipTimeMap.clear();
            long end = System.currentTimeMillis();
            LOGGER.info( "===== fenxi gps done-realgps- " + (end-start)  + " sec");
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    //将redis缓存中的数据存入数据库并且查询出来地理区域
//    @Scheduled(cron = "0 13/30 * * * ?")
    @Scheduled(cron = "${timetask.car.BigDataAnalysisRealGpsCar.cron.saveGpsWithCityInfoToRedis}")
    public void saveGpsWithCityInfoToRedis(){
        String key = RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY;
        long startMill = System.currentTimeMillis();
        Map<Object,Object> gpsMap = redisUtil.hmget(key);
        Set<Map.Entry<Object,Object>> mapEntrySet = gpsMap.entrySet();
        Object[] arr = mapEntrySet.toArray();
        int length = arr.length;
        int batchNum = 1000000;
        int times = length/batchNum + 1;
        for(int i=0;i<=times;i++){
            int finalI = i;
            Thread t = new Thread(){
                public void run(){
                    int index = finalI *batchNum;
                    int end = (finalI +1)*batchNum;
                    for( ; index<end&&index<arr.length; index++){
                        Object temO = arr[index];
                        Map.Entry<Object,Object> temEntry = (Map.Entry<Object,Object>)temO;
                        Object obj = temEntry.getValue();
                        if(obj!=null && obj instanceof  BigdataCarRealtimeGps){
                            //查询地址

                            BigdataCarRealtimeGps carGps = (BigdataCarRealtimeGps)obj;
                            BigDecimal lng = carGps.getPointLong();
                            BigDecimal lat = carGps.getPointLat();
                            try {
                                MapPointInfo mapPointInfo =  baiDuMapApiUtil.latLongSearch(lat + "," + lng);
                                Object temObj = redisUtil.hget(key,carGps.getId());

                                if(temObj!=null && mapPointInfo!=null){
                                    carGps = (BigdataCarRealtimeGps)temObj;
                                    carGps.setMapCountry(mapPointInfo.getCountry());
                                    carGps.setMapProvince(mapPointInfo.getProvince());
                                    String cityName = mapPointInfo.getCity();
                                    if(cityName==null || cityName.equals("")){
                                        carGps.setMapCity(mapPointInfo.getDistrict());
                                    }else{
                                        carGps.setMapCity(mapPointInfo.getCity());
                                    }
                                    carGps.setMapXianqu(mapPointInfo.getDistrict());
                                    carGps.setMapDetail(mapPointInfo.getSematic_description());
                                    carGps.setAreaUpTime(new Date());
                                    redisUtil.hset(key,carGps.getId(),carGps);

                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        try {
                            Thread.currentThread().sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    long endMill = System.currentTimeMillis();
                    System.out.print("总共耗时:" + (endMill - startMill));
                }
            };
            t.start();
        }



    }

    //一小时统计一次
    // TODO: 第二天统计前一天的数据待做
//    @Scheduled(cron = "0 17 * * * ?")
    @Scheduled(cron = "${timetask.car.BigDataAnalysisRealGpsCar.cron.fenxiAllCarTrailOfToday}")
    public void fenxiAllCarTrailOfToday()throws Exception{
        System.out.println("===== fenxiAllCarTrainOfToday======任务开始");
        Calendar cal = Calendar.getInstance();
        long start = System.currentTimeMillis();
        //分析
        Set<Object> carPlateSet =  redisUtil.sGet(RedisDbKeyConstant.CAR_REAL_TIME_GPS_CAR_PLATE_ID_KEY);
        List<Object> carPlateList = new ArrayList<>(carPlateSet);
/*

        int totalCarNum = carPlateList.size();
        System.out.println("totalCarNum===="+totalCarNum);
        final int oneNum = 20000;
        int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
        System.out.println("times===="+times);
        //多线程遍历数据库
        for(int i=0;i<times;i++){
            final int fiIndex = i;
            Thread t = new Thread(){
                @Override
                public void run(){
                    int start = oneNum*fiIndex ;
                    int end = oneNum*(fiIndex+1);
                    List<Object> carList = new ArrayList<>();
                    if(fiIndex+1==times){
                        carList= carPlateList.subList(start,totalCarNum);
                    }else {
                        carList= carPlateList.subList(start,end);
                    }
                    // 同步位置信息、上线情况、运营情况
                    for(Object obj : carList) {
                        String carPlateId = obj + "";
                        fenxiOneCarTimeAndMileOfDay(carPlateId, cal.getTime());
                    }
                }
            };
            t.start();
        }
*/

        for(Object obj : carPlateList) {
           String carPlateId = obj + "";
           fenxiOneCarTimeAndMileOfDay(carPlateId, cal.getTime());
        }
        long end = System.currentTimeMillis();
        System.out.println("===== fenxiAllCarTrainOfToday " + (end-start)  + " sec");
    }


    //分析一辆车一天的行驶情况
    public BigdataCarRealtimeGps fenxiOneCarTimeAndMileOfDay(String carPlateId,Date dayInt){
        String[] plateAndColor = carPlateId.split("_");
        if(plateAndColor.length!=2)return null;
        String carPlateNum = plateAndColor[0];
        String carPlateColor = plateAndColor[1];
        String dayStr = sdfDayInt.format(dayInt);
        BigdataCarRealtimeGps carTodayInfo = new BigdataCarRealtimeGps();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<BigdataCarRealtimeGps> listRealTimeGps = new ArrayList<BigdataCarRealtimeGps>();
        //0.读到文件
        try{
            InputStreamReader isr = null;
            BufferedReader br = null;
            try {
//                File forder = new File(dataHistoryGpsForder+File.separator+new String(carPlateNum.getBytes(),"GBK"));
                File forder = new File(dataHistoryGpsForder+File.separator + carPlateNum);
                File gpsFile = new File(forder, dayStr+".log");
                if(!gpsFile.exists()){
                    return null;
                }
                isr = new InputStreamReader(new FileInputStream(gpsFile), "GBK");
                br = new BufferedReader(isr);
                String temLine = null;
                //0.读到文件
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
                while ((temLine = br.readLine()) != null) {
                    BigdataCarRealtimeGps tempGps = gpsLogFenxiUtil.fenxiOneRealPosition(temLine);
                    if(tempGps==null){
                        continue;
                    }
                    BigDecimal mileage = tempGps.getMileage();
                    if(mileage==null || mileage.doubleValue()==0){
                        continue;
                    }
                    Date positionTime = tempGps.getLastPositionTime();
                    int hour = positionTime.getHours();
                    //过滤掉跳日期的
                    String positionDay = sdfDayInt.format(positionTime);
                    if(!positionDay.equals(dayStr)){//跳天数的点忽略
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
                    //4.停车记录
                    if(jumpTimeFlag){
                        lastGps=null;
                    }else{
                        lastGps = tempGps;
                        todayTotalFenxiVo.setLatestMileage(lastGps.getMileage());
                    }
                    //listRealTimeGps.add(tempGps);
                }
                /* if(todayTotalFenxiVo.isDrive()){
                    return null;
                }*/
                todayTotalFenxiVo.sumData();
                lingChenDriveFenxiVo.sumData();
                morningDriveFenxiVo.sumData();
                noonDriveFenxiVo.sumData();
                duskDriveFenxiVo.sumData();
                nightDriveFenxiVo.sumData();
                //总
                carTodayInfo.setTodayMileageTotal(todayTotalFenxiVo.getTotalMileage());
                carTodayInfo.setTodayTimeTotal(todayTotalFenxiVo.getTotalDriveMin());
                //凌晨
                carTodayInfo.setLingchenMileage(lingChenDriveFenxiVo.getTotalMileage());
                carTodayInfo.setLingchenMinuteNum(lingChenDriveFenxiVo.getTotalDriveMin());
                //清晨
                carTodayInfo.setMorningMileage(morningDriveFenxiVo.getTotalMileage());
                carTodayInfo.setMorningMinuteNum(morningDriveFenxiVo.getTotalDriveMin());
                //中午
                carTodayInfo.setNoonMileage(noonDriveFenxiVo.getTotalMileage());
                carTodayInfo.setNoonMinuteNum(noonDriveFenxiVo.getTotalDriveMin());
                //黄昏
                carTodayInfo.setDuskMileage(duskDriveFenxiVo.getTotalMileage());
                carTodayInfo.setDuskMinuteNum(duskDriveFenxiVo.getTotalDriveMin());
                //午夜
                carTodayInfo.setMidnightMileage(nightDriveFenxiVo.getTotalMileage());
                carTodayInfo.setMidnightMinuteNum(nightDriveFenxiVo.getTotalDriveMin());
                String errMsg = checkCarGpsInfo(carTodayInfo);
                //更新缓存数据
                //转一下车牌号
                String trimedCarPlateId = gpsLogFenxiUtil.trimCarPlateNum(carPlateNum) + "_" + carPlateColor;
                Object temObj = redisUtil.hget(
                        RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY,
                        trimedCarPlateId);

                if(temObj!=null ){
                    BigdataCarRealtimeGps carGps = (BigdataCarRealtimeGps)temObj;
                    carGps.setBeginMileage(carTodayInfo.getBeginMileage());
                    //设置统计信息
//                    System.out.println("totol drive time = " + carTodayInfo.getTodayTimeTotal());
                    carGps.setTodayTimeTotal(carTodayInfo.getTodayTimeTotal());
//                    System.out.println("totol drive mile = " + carTodayInfo.getTodayMileageTotal());
                    carGps.setTodayMileageTotal(carTodayInfo.getTodayMileageTotal());
//                    System.out.println("lingchen drive mile = " + carTodayInfo.getLingchenMileage());
                    carGps.setLingchenMileage(carTodayInfo.getLingchenMileage());
//                    System.out.println("lingchen drive time = " + carTodayInfo.getLingchenMinuteNum());
                    carGps.setLingchenMinuteNum(carTodayInfo.getLingchenMinuteNum());
//                    System.out.println("morning drive mile = " + carTodayInfo.getMorningMileage());
                    carGps.setMorningMileage(carTodayInfo.getMorningMileage());
//                    System.out.println("morning drive time = " + carTodayInfo.getMorningMinuteNum());
                    carGps.setMorningMinuteNum(carTodayInfo.getMorningMinuteNum());
//                    System.out.println("noon drive mile = " + carTodayInfo.getNoonMileage());
                    carGps.setNoonMileage(carTodayInfo.getNoonMileage());
//                    System.out.println("noon drive time = " + carTodayInfo.getNoonMinuteNum());
                    carGps.setNoonMinuteNum(carTodayInfo.getNoonMinuteNum());
//                    System.out.println("Dusk drive mile = " + carTodayInfo.getDuskMileage());
                    carGps.setDuskMileage(carTodayInfo.getDuskMileage());
//                    System.out.println("Dusk drive time = " + carTodayInfo.getDuskMinuteNum());
                    carGps.setDuskMinuteNum(carTodayInfo.getDuskMinuteNum());
//                    System.out.println("Midnight drive mile = " + carTodayInfo.getMidnightMileage());
                    carGps.setMidnightMileage(carTodayInfo.getMidnightMileage());
//                    System.out.println("Midnight drive time = " + carTodayInfo.getMidnightMinuteNum());
                    carGps.setMidnightMinuteNum(carTodayInfo.getMidnightMinuteNum());
                    carGps.setOnlineState("1");
                    //上线情况和运营情况
                    BigDecimal todayMileageTotal = carTodayInfo.getTodayMileageTotal();
                    if(todayMileageTotal!=null && todayMileageTotal.doubleValue()>0){
                        carGps.setOperatFlag("1");
                    }


                    if(errMsg!=null && errMsg.length()>0){
                        carGps.setQualifiedState(0);
//                        System.out.println("-------------"  + carPlateNum +":" + errMsg);
                    }else{
                        carGps.setQualifiedState(1);
                    }
                    carGps.setErrMsg(errMsg);
                    redisUtil.hset(
                            RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY
                            ,carGps.getId(),carGps);

                }
            }catch (IOException e){
                e.printStackTrace();
                return null;
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
            System.out.println(carTodayInfo+"-" + carTodayInfo.getMileage() + "-" + carTodayInfo.getBeginMileage());
        }
        return carTodayInfo;
    }
    /*public BigdataCarRealtimeGps fenxiOneCarTimeAndMileOfDay(String carPlateId,Date dayInt){
        String[] plateAndColor = carPlateId.split("_");
        if(plateAndColor.length!=2)return null;
        String carPlateNum = plateAndColor[0];
        String carPlateColor = plateAndColor[1];
        String dayStr = sdfDayInt.format(dayInt);
        BigdataCarRealtimeGps carTodayInfo = new BigdataCarRealtimeGps();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<BigdataCarRealtimeGps> listRealTimeGps = new ArrayList<BigdataCarRealtimeGps>();
        //0.读到文件
        try{
            InputStreamReader isr = null;
            BufferedReader br = null;
            try {
//                File forder = new File(dataHistoryGpsForder+File.separator+new String(carPlateNum.getBytes(),"GBK"));
                File forder = new File(dataHistoryGpsForder+File.separator + carPlateNum);
                File gpsFile = new File(forder, dayStr+".log");
                if(!gpsFile.exists()){
                    return null;
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
                return null;
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
                //0.读到文件
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

                for (BigdataCarRealtimeGps tempGps:  listRealTimeGps) {
                    BigDecimal mileage = tempGps.getMileage();
                    if(mileage==null || mileage.doubleValue()==0){
                        continue;
                    }
                    Date positionTime = tempGps.getLastPositionTime();
                    int hour = positionTime.getHours();
                    //过滤掉跳日期的
                    String positionDay = sdfDayInt.format(positionTime);
                    if(!positionDay.equals(dayStr)){//跳天数的点忽略
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
                    //4.停车记录
                    if(jumpTimeFlag){
                        lastGps=null;
                    }else{
                        lastGps = tempGps;
                        todayTotalFenxiVo.setLatestMileage(lastGps.getMileage());
                    }


                }
               *//* if(todayTotalFenxiVo.isDrive()){
                    return null;
                }*//*
                todayTotalFenxiVo.sumData();
                lingChenDriveFenxiVo.sumData();
                morningDriveFenxiVo.sumData();
                noonDriveFenxiVo.sumData();
                duskDriveFenxiVo.sumData();
                nightDriveFenxiVo.sumData();
                //总
                carTodayInfo.setTodayMileageTotal(todayTotalFenxiVo.getTotalMileage());
                carTodayInfo.setTodayTimeTotal(todayTotalFenxiVo.getTotalDriveMin());
                //凌晨
                carTodayInfo.setLingchenMileage(lingChenDriveFenxiVo.getTotalMileage());
                carTodayInfo.setLingchenMinuteNum(lingChenDriveFenxiVo.getTotalDriveMin());
                //清晨
                carTodayInfo.setMorningMileage(morningDriveFenxiVo.getTotalMileage());
                carTodayInfo.setMorningMinuteNum(morningDriveFenxiVo.getTotalDriveMin());
                //中午
                carTodayInfo.setNoonMileage(noonDriveFenxiVo.getTotalMileage());
                carTodayInfo.setNoonMinuteNum(noonDriveFenxiVo.getTotalDriveMin());
                //黄昏
                carTodayInfo.setDuskMileage(duskDriveFenxiVo.getTotalMileage());
                carTodayInfo.setDuskMinuteNum(duskDriveFenxiVo.getTotalDriveMin());
                //午夜
                carTodayInfo.setMidnightMileage(nightDriveFenxiVo.getTotalMileage());
                carTodayInfo.setMidnightMinuteNum(nightDriveFenxiVo.getTotalDriveMin());
                String errMsg = checkCarGpsInfo(carTodayInfo);
                //更新缓存数据
                //转一下车牌号
                String trimedCarPlateId = gpsLogFenxiUtil.trimCarPlateNum(carPlateNum) + "_" + carPlateColor;
                Object temObj = redisUtil.hget(
                        RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY,
                        trimedCarPlateId);

                if(temObj!=null ){
                    BigdataCarRealtimeGps carGps = (BigdataCarRealtimeGps)temObj;
                    carGps.setBeginMileage(carTodayInfo.getBeginMileage());
                    //设置统计信息
//                    System.out.println("totol drive time = " + carTodayInfo.getTodayTimeTotal());
                    carGps.setTodayTimeTotal(carTodayInfo.getTodayTimeTotal());
//                    System.out.println("totol drive mile = " + carTodayInfo.getTodayMileageTotal());
                    carGps.setTodayMileageTotal(carTodayInfo.getTodayMileageTotal());
//                    System.out.println("lingchen drive mile = " + carTodayInfo.getLingchenMileage());
                    carGps.setLingchenMileage(carTodayInfo.getLingchenMileage());
//                    System.out.println("lingchen drive time = " + carTodayInfo.getLingchenMinuteNum());
                    carGps.setLingchenMinuteNum(carTodayInfo.getLingchenMinuteNum());
//                    System.out.println("morning drive mile = " + carTodayInfo.getMorningMileage());
                    carGps.setMorningMileage(carTodayInfo.getMorningMileage());
//                    System.out.println("morning drive time = " + carTodayInfo.getMorningMinuteNum());
                    carGps.setMorningMinuteNum(carTodayInfo.getMorningMinuteNum());
//                    System.out.println("noon drive mile = " + carTodayInfo.getNoonMileage());
                    carGps.setNoonMileage(carTodayInfo.getNoonMileage());
//                    System.out.println("noon drive time = " + carTodayInfo.getNoonMinuteNum());
                    carGps.setNoonMinuteNum(carTodayInfo.getNoonMinuteNum());
//                    System.out.println("Dusk drive mile = " + carTodayInfo.getDuskMileage());
                    carGps.setDuskMileage(carTodayInfo.getDuskMileage());
//                    System.out.println("Dusk drive time = " + carTodayInfo.getDuskMinuteNum());
                    carGps.setDuskMinuteNum(carTodayInfo.getDuskMinuteNum());
//                    System.out.println("Midnight drive mile = " + carTodayInfo.getMidnightMileage());
                    carGps.setMidnightMileage(carTodayInfo.getMidnightMileage());
//                    System.out.println("Midnight drive time = " + carTodayInfo.getMidnightMinuteNum());
                    carGps.setMidnightMinuteNum(carTodayInfo.getMidnightMinuteNum());
                    carGps.setOnlineState("1");
                    //上线情况和运营情况
                    BigDecimal todayMileageTotal = carTodayInfo.getTodayMileageTotal();
                    if(todayMileageTotal!=null && todayMileageTotal.doubleValue()>0){
                        carGps.setOperatFlag("1");
                    }


                    if(errMsg!=null && errMsg.length()>0){
                        carGps.setQualifiedState(0);
//                        System.out.println("-------------"  + carPlateNum +":" + errMsg);
                    }else{
                        carGps.setQualifiedState(1);
                    }
                    carGps.setErrMsg(errMsg);
                    redisUtil.hset(
                            RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY
                            ,carGps.getId(),carGps);
                    if (carPlateId.contains("C25378")){
                        System.out.println(JSONObject.toJSONString(carGps));
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(carTodayInfo+"-" + carTodayInfo.getMileage() + "-" + carTodayInfo.getBeginMileage());
        }
        return carTodayInfo;
    }*/


    private String checkCarGpsInfo(BigdataCarRealtimeGps carInfo){
        //判断数据是否合格不合格
        //整日平均速度和时长0 里程有值情况不合格
        String errMsg = "";
        BigDecimal todayTimeTotal = carInfo.getTodayTimeTotal();
        BigDecimal todayMileTotal = carInfo.getTodayMileageTotal();
        if(todayTimeTotal.doubleValue()<0){
            errMsg += "当日时间跳点时间负值;";
        }
        if(todayMileTotal.doubleValue()<0){
            errMsg += "当日里程跳点时间负值;";
        }
        if(todayTimeTotal.doubleValue()==0 ){
            if(todayMileTotal.doubleValue()>0){
                errMsg += "当日平均速度基数是0;";
            }
        }else{
            if(todayTimeTotal.doubleValue()>10&&todayMileTotal.doubleValue()==0){
                errMsg += "里程有值时长为0;";
            }
            double avgSpeed = todayMileTotal.divide(todayTimeTotal,2,BigDecimal.ROUND_FLOOR).doubleValue() * 60;
            if(avgSpeed>130){
                errMsg += "当日平均速度超130公里/小时;";
            }
        }



        //凌晨
//        BigDecimal lingchenTimeTotal = carInfo.getLingchenMinuteNum();
        BigDecimal lingchenMileTotal = carInfo.getLingchenMileage();
        /*if(lingchenTimeTotal.doubleValue()<0){
            errMsg += "凌晨时间跳点时间负值;";
        }*/
        if(lingchenMileTotal.doubleValue()<0){
            errMsg += "凌晨里程跳点里程负值;";
        }
       /* if(lingchenTimeTotal.doubleValue()==0 ){
            if(lingchenMileTotal.doubleValue()>0){
                errMsg += "凌晨平均速度基数是0;";
            }
        }else{
            double avgSpeed = lingchenMileTotal.divide(lingchenTimeTotal,2,BigDecimal.ROUND_FLOOR).doubleValue() * 60;
            if(avgSpeed>130){
                errMsg += "凌晨平均速度超130公里/小时;";
            }
        }*/

        //清晨
//        BigDecimal morningTimeTotal = carInfo.getMorningMinuteNum();
        BigDecimal morningMileTotal = carInfo.getMorningMileage();
       /* if(morningTimeTotal.doubleValue()<0){
            errMsg += "清晨时间跳点时间负值;";
        }*/
        if(morningMileTotal.doubleValue()<0){
            errMsg += "清晨里程跳点里程负值;";
        }
      /*  if(morningTimeTotal.doubleValue()==0 ){
            if(morningMileTotal.doubleValue()>0){
                errMsg += "清晨平均速度基数是0;";
            }
        }else{
            double avgSpeed = morningMileTotal.divide(morningTimeTotal,2,BigDecimal.ROUND_FLOOR).doubleValue() * 60;
            if(avgSpeed>130){
                errMsg += "清晨平均速度超130公里/小时;";
            }
        }*/

        //中午
//        BigDecimal noonTimeTotal = carInfo.getNoonMinuteNum();
        BigDecimal noonMileTotal = carInfo.getNoonMileage();
       /* if(noonTimeTotal.doubleValue()<0){
            errMsg += "中午时间跳点时间负值;";
        }*/
        if(noonMileTotal.doubleValue()<0){
            errMsg += "中午里程跳点里程负值;";
        }
       /* if(noonTimeTotal.doubleValue()==0 ){
            if(noonMileTotal.doubleValue()>0){
                errMsg += "中午平均速度基数是0;";
            }
        }else{
            double avgSpeed = noonMileTotal.divide(noonTimeTotal,2,BigDecimal.ROUND_FLOOR).doubleValue() * 60;
            if(avgSpeed>130){
                errMsg += "中午平均速度超130公里/小时;";
            }
        }*/


        //黄昏
//        BigDecimal duskTimeTotal = carInfo.getDuskMinuteNum();
        BigDecimal duskMileTotal = carInfo.getDuskMileage();
        /*if(duskTimeTotal.doubleValue()<0){
            errMsg += "黄昏时间跳点时间负值;";
        }*/
        if(duskMileTotal.doubleValue()<0){
            errMsg += "黄昏里程跳点里程负值;";
        }
        /*if(duskTimeTotal.doubleValue()==0 ){
            if(duskMileTotal.doubleValue()>0){
                errMsg += "黄昏平均速度基数是0;";
            }
        }else{
            double avgSpeed = duskMileTotal.divide(duskTimeTotal,2,BigDecimal.ROUND_FLOOR).doubleValue() * 60;
            if(avgSpeed>130){
                errMsg += "黄昏平均速度超130公里/小时;";
            }
        }*/

        //午夜
        BigDecimal midnightTimeTotal = carInfo.getMidnightMinuteNum();
        BigDecimal midnightMileTotal = carInfo.getMidnightMileage();
       /* if(midnightTimeTotal.doubleValue()<0){
            errMsg += "午夜时间跳点时间负值;";
        }*/
        if(midnightMileTotal.doubleValue()<0){
            errMsg += "午夜里程跳点里程负值;";
        }
        /*if(midnightTimeTotal.doubleValue()==0 ){
            if(midnightMileTotal.doubleValue()>0){
                errMsg += "午夜平均速度基数是0;";
            }
        }else{
            double avgSpeed = midnightMileTotal.divide(midnightTimeTotal,2,BigDecimal.ROUND_FLOOR).doubleValue() * 60;
            if(avgSpeed>130){
                errMsg += "午夜平均速度超130公里/小时;";
            }
        }*/

        return errMsg;

    }





  /*  public static void main(String[] args) {
        System.out.println(checkCarPlateNum("冀CFD590590"));
    }*/

    public static boolean checkCarPlateNum(String carnumber) {
        String carnumRegex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})";
        return carnumber.matches(carnumRegex);
    }






}



