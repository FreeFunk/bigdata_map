package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.BigdataBeidouCarMonthCheck;
import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsView;
import com.edgedo.bigdata.queryvo.CarGroupCount;
import com.edgedo.bigdata.queryvo.CityTransportCapacityAnalysisView;
import com.edgedo.bigdata.service.*;
import com.edgedo.common.util.ObjectUtil;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.service.SysXianquService;
import com.edgedo.util.BigdataDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

//运营分析
@ConditionalOnProperty(
        value = {"timetask.analysis.BigDataAnalysisOperative.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigDataAnalysisOperative {
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    SysXianquService sysXianquService;
    @Autowired
    BigdataCarRealtimeGpsService bigdataCarRealtimeGpsService;
    @Autowired
    CityTransportCapacityAnalysisService cityTransportCapacityAnalysisService;
    @Autowired
    BigdataCarStopRecordService bigdataCarStopRecordService;
    //车辆历史的服务端
    @Autowired
    BigdataTimeCarDayRecService carInfoDayHistoryService;
    @Autowired
    BigdataBeidouCompService beidouCompService;
    @Autowired
    BigdataBeidouCarMonthCheckService bigdataBeidouCarMonthCheckService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");

    //同步车辆的位置信息
    //@Scheduled(cron = "0 0/4 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisOperative.cron.synCarLocationInfo}")
    public void synCarLocationInfo(){
        try {
            //如果时间在凌晨0点 5分之前返回
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minu = cal.get(Calendar.MINUTE);
            int temNum = hour * 10 + minu;
            if (temNum <= 5) {
                return;
            }
            String gpsCarRedsMapKey = RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY;
//        Map<Object,Object> carMap = redisUtil.hmget(gpsCarRedsMapKey);
            //int totalCarNum = carInfoService.countAll();
            int totalCarNum = carInfoService.selectSortNum();
            int oneNum = 500;
            int times = totalCarNum/oneNum + (totalCarNum%oneNum==0?0:1);
            //多线程遍历数据库
            for (int i = 0; i < times; i++) {
                final int fiIndex = i;

                Thread t = new Thread() {
                    @Override
                    public void run() {
                        System.out.println(new Date());
                        int start = oneNum * fiIndex;
                        int end = oneNum * (fiIndex + 1) - 1;
                        Date cur = new Date();
                        List<CarInfo> carList = carInfoService.listByStartAndEndBySortNum(start, end);
                        // 同步位置信息、上线情况、运营情况
                        for (CarInfo car : carList) {
                            String carPlateNum = car.getCarPlateNum();
                            String carPlateColor = car.getCarPlateColour();
                            String carGpsid = carPlateNum + "_" + carPlateColor;
//                        Object obj = carMap.get(carGpsid);
                            Object obj = redisUtil.hget(RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY, carGpsid);
                            if (obj != null) {//如果非空那么可以同步下
                                BigdataCarRealtimeGps carRealtimeGps = (BigdataCarRealtimeGps) obj;
                                String mapProvince = carRealtimeGps.getMapProvince();
                                String cityName = carRealtimeGps.getMapCity();
                                String xianquName = carRealtimeGps.getMapXianqu();
                                String mapDetail = carRealtimeGps.getMapDetail();

                                if (xianquName != null && xianquName.length() > 0) {
                                    SysXianqu xianqu = sysXianquService.selectByXianquNameAndCityName(cityName, xianquName);
                                    if (xianqu != null) {
                                        car.setCurrentProvinceId(xianqu.getProvinceId());
                                        car.setCurrentProvinceName(xianqu.getProvinceName());
                                        car.setCurrentCityId(xianqu.getCityId());
                                        car.setCurrentCityName(xianqu.getCityName());
                                        car.setCurrentXianquId(xianqu.getId());
                                        car.setCurrentXianquName(xianqu.getName());
                                        carRealtimeGps.setMapProvinceId(xianqu.getProvinceId());
                                        carRealtimeGps.setMapCityId(xianqu.getCityId());
                                        carRealtimeGps.setMapXianquId(xianqu.getId());
                                    } else {
                                        car.setCurrentProvinceName(carRealtimeGps.getMapProvince());
                                        car.setCurrentCityName(carRealtimeGps.getMapCity());
                                        car.setCurrentXianquName(carRealtimeGps.getMapXianqu());
                                    }
                                }else{
                                    car.setCurrentProvinceName(mapProvince);
                                    car.setCurrentCityName(cityName);
                                    car.setCurrentXianquName(xianquName);
                                }
                                //位置详情
                                String localtionInfo = ((mapProvince!=null&&mapProvince.length()>0)?mapProvince:"")
                                        +((cityName!=null&&cityName.length()>0)?cityName:"")
                                        +((xianquName!=null&&xianquName.length()>0)?xianquName:"")
                                        +((mapDetail!=null&&mapDetail.length()>0)?mapDetail:"");
                                car.setLocaltionInfo(localtionInfo);

                                //北斗运营商
                                String ip809Addr = carRealtimeGps.getIp();
                                BigdataBeidouCompView beidouComp =  beidouCompService.selectByIp809Addr(ip809Addr);
                                if(beidouComp!=null){
                                    car.setBeidouOperator(beidouComp.getCompName());
                                    car.setComId(beidouComp.getId());
                                    car.setComName(beidouComp.getCompName());
                                    String key = "IP_KEY";
                                    Object temObj = redisUtil.hget(key,ip809Addr);
                                    //更新企业的上一次联通时间
                                    Date date = (Date)temObj;
                                    beidouComp.setLastUpTime(date);
                                    beidouCompService.update(beidouComp);
                                }

                                car.setLongitude(carRealtimeGps.getPointLong());
                                car.setLatitude(carRealtimeGps.getPointLat());
                                car.setOnlineState(carRealtimeGps.getOnlineState());
                                car.setOperatFlag(carRealtimeGps.getOperatFlag());
                                car.setTodayMileageTotal(carRealtimeGps.getTodayMileageTotal());
                                car.setTodayTimeTotal(carRealtimeGps.getTodayTimeTotal());
                                car.setLingchenMileage(carRealtimeGps.getLingchenMileage());
                                car.setMorningMileage(carRealtimeGps.getMorningMileage());
                                car.setNoonMileage(carRealtimeGps.getNoonMileage());
                                car.setDuskMileage(carRealtimeGps.getDuskMileage());
                                car.setMidnightMileage(carRealtimeGps.getMidnightMileage());
                                car.setLingchenMinuteNum(carRealtimeGps.getLingchenMinuteNum());
                                car.setMorningMinuteNum(carRealtimeGps.getMorningMinuteNum());
                                car.setNoonMinuteNum(carRealtimeGps.getNoonMinuteNum());
                                car.setDuskMinuteNum(carRealtimeGps.getDuskMinuteNum());
                                car.setMidnightMinuteNum(carRealtimeGps.getMidnightMinuteNum());
                                car.setLastPositionTime(carRealtimeGps.getLastPositionTime());
                                car.setAreaUpTime(carRealtimeGps.getAreaUpTime());
                                car.setErrMsg(carRealtimeGps.getErrMsg());
                                car.setQualifiedState(carRealtimeGps.getQualifiedState());
                                //各个时段的里程
                                carInfoService.update(car);
                                //更新车辆月度考核表 当月已上线
                        /*        Date currentDate = new Date();
                                String currentDateStr = sdf1.format(currentDate);
                                Integer countDate = new Integer(currentDateStr);
                                BigdataBeidouCarMonthCheck bigdataBeidouCarMonthCheck = new BigdataBeidouCarMonthCheck();
                                bigdataBeidouCarMonthCheck.setCarPlateNum(car.getCarPlateNum());
                                bigdataBeidouCarMonthCheck.setCarFrameNum(car.getCarFrameNum());
                                bigdataBeidouCarMonthCheck.setCarPlateColor(car.getCarPlateColour());
                                bigdataBeidouCarMonthCheck.setCompId(car.getComId());
                                bigdataBeidouCarMonthCheck.setCompName(car.getComName());
                                bigdataBeidouCarMonthCheck.setCountDate(countDate);
                                bigdataBeidouCarMonthCheck.setCountMonth(countDate/100);
                                bigdataBeidouCarMonthCheck.setYearNum(countDate/10000);
                                bigdataBeidouCarMonthCheck.setOnlineState("1");
                                bigdataBeidouCarMonthCheckService.insertOrUpdate(bigdataBeidouCarMonthCheck);*/
                                //再把gps表更新一下
                                //bigdataCarRealtimeGpsService.insertOrUpdate(carRealtimeGps);
                                //判断如果一个车已经停了一个小时以上那么算成停车记录
                                Integer stopMinuteNum = carRealtimeGps.getStopMinuteNum();
                                String provinceName = carRealtimeGps.getMapProvince();
                                if (stopMinuteNum != null && stopMinuteNum > 60 && provinceName != null && provinceName.length() > 0) {
                                    bigdataCarStopRecordService.insertOrUpdateStopRec(carRealtimeGps, car);
                                }

                            } /*else {//如果是空的那么清空位置信息、上线情况、运营情况
                                car.setOnlineState("0");
                                car.setOperatFlag("0");
                                car.setTodayTimeTotal(new BigDecimal(0));
                                car.setTodayMileageTotal(new BigDecimal(0));
                                car.setLingchenMileage(new BigDecimal(0));
                                car.setMorningMileage(new BigDecimal(0));
                                car.setNoonMileage(new BigDecimal(0));
                                car.setDuskMileage(new BigDecimal(0));
                                car.setMidnightMileage(new BigDecimal(0));
                                car.setLingchenMinuteNum( new BigDecimal(0));
                                car.setMorningMinuteNum(new BigDecimal(0));
                                car.setNoonMinuteNum(new BigDecimal(0));
                                car.setDuskMinuteNum(new BigDecimal(0));
                                car.setMidnightMinuteNum(new BigDecimal(0));

                                carInfoService.update(car);

                            }*/
                        }
                        System.out.println("1111111="+new Date());
                    }
                };
                t.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //只更新GPS表
    //@Scheduled(cron = "0 0/7 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisOperative.cron.synCarLocationInfoGps}")
    public void synCarLocationInfoGps(){
        try {
            //如果时间在凌晨0点 5分之前返回
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minu = cal.get(Calendar.MINUTE);
            int temNum = hour * 10 + minu;
            if (temNum <= 5) {
                return;
            }
            long start = System.currentTimeMillis();
            String gpsCarRedsMapKey = RedisDbKeyConstant.CAR_REAL_TIME_GPS_MAP_KEY;
            Map<Object,Object> carMap = redisUtil.hmget(gpsCarRedsMapKey);
            Collection<Object> values = carMap.values();
            for(Object obj : values){
                if(obj instanceof BigdataCarRealtimeGps){
                    BigdataCarRealtimeGps gpsCar = (BigdataCarRealtimeGps)obj;
                    String carPlateNum = gpsCar.getCarPlateNum();
                    if(!BigdataDataUtil.checkCarPlateNum(carPlateNum)){
                        continue;
                    }
                    //1:蓝色, 2:黄色,	 3:黑色,	 4:白色, 7:黄绿相间	 9:其他
                    String carPlateColorCode = gpsCar.getCarPlateColor();
                    if("1,2,3,4,7,9,".indexOf(carPlateColorCode + ",") < 0){
                        continue;
                    }
                    bigdataCarRealtimeGpsService.insertOrUpdate((BigdataCarRealtimeGps)obj);
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("用时:" + ((end-start)/1000));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //将系统内的数据清零
   //@Scheduled(cron = "0 5 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisOperative.cron.initCarGpsInfo}")
    public void initCarGpsInfo(){
        try{
            String initCarGpsFlag = carInfoService.getInitCarGpsFlag("INIT_CAR_GPS_FLAG");
            Calendar cal = Calendar.getInstance();
            Date cur = cal.getTime();
            String dayStr = sdf1.format(cur);
            int dayInt = new Integer(dayStr);
            String initCarGpsFlagNow = dayInt+"-1";
            if(!initCarGpsFlag.equals(initCarGpsFlagNow)){
                //将系统内的数据清零
                carInfoService.updateClearAllCarState();
                bigdataCarRealtimeGpsService.updateClearAllGpsState();
                carInfoService.updateInitCarGpsFlag("INIT_CAR_GPS_FLAG",initCarGpsFlagNow);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //查询不在今天定位的车辆信息初始化数据
    //@Scheduled(cron = "0 0/30 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisOperative.cron.initCarGpsInfoNew}")
    public void initCarGpsInfoNew(){
        try{
            List<BigdataCarRealtimeGpsView> bigdataCarRealtimeGpsViewList = bigdataCarRealtimeGpsService.selectNotInTodayGps();
            for(BigdataCarRealtimeGpsView carRealtimeGpsView:bigdataCarRealtimeGpsViewList){
                String carId = carRealtimeGpsView.getId();
                //将系统内的数据清零
                carInfoService.updateClearCarStateById(carId);
                bigdataCarRealtimeGpsService.updateClearCarStateById(carId);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //分析上线率运营率等信息
    //@Scheduled(cron = "0 0/10 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisOperative.cron.fenxiOpertiveInfo}")
    public void  fenxiOpertiveInfo(){
        try{
            Date currentDate = new Date();
            String currentDateStr = sdf.format(currentDate);
            //根据车辆类型统计上线率，运营率等等
            CityTransportCapacityAnalysisView capacityAnalysisAll = new CityTransportCapacityAnalysisView();
            capacityAnalysisAll.setId(currentDateStr + "-总");
            capacityAnalysisAll.setUpdateTime(currentDate);
            capacityAnalysisAll.setCarType("总");
            capacityAnalysisAll.setCountTime(currentDate);
            CityTransportCapacityAnalysisView capacityAnalysisWeihuo = new CityTransportCapacityAnalysisView();
            capacityAnalysisWeihuo.setId(currentDateStr + "-危货");
            capacityAnalysisWeihuo.setUpdateTime(currentDate);
            capacityAnalysisWeihuo.setCarType("危货");
            capacityAnalysisWeihuo.setCountTime(currentDate);
            CityTransportCapacityAnalysisView capacityAnalysisPuhuo = new CityTransportCapacityAnalysisView();
            capacityAnalysisPuhuo.setId(currentDateStr + "-普货");
            capacityAnalysisPuhuo.setUpdateTime(currentDate);
            capacityAnalysisPuhuo.setCarType("普货");
            capacityAnalysisPuhuo.setCountTime(currentDate);
            CityTransportCapacityAnalysisView capacityAnalysisKeyun = new CityTransportCapacityAnalysisView();
            capacityAnalysisKeyun.setId(currentDateStr + "-客运");
            capacityAnalysisKeyun.setUpdateTime(currentDate);
            capacityAnalysisKeyun.setCarType("客运");
            capacityAnalysisKeyun.setCountTime(currentDate);
            capacityAnalysisKeyun.setOnlineNum(0);
            capacityAnalysisKeyun.setDayTotalMileage(new BigDecimal("0"));
            capacityAnalysisKeyun.setDayTotalTime(new BigDecimal("0"));
            capacityAnalysisKeyun.setCurrentOperationMax(new BigDecimal("0"));

            //1.车辆总数
            List<CarGroupCount> listAll = carInfoService.selectGroupByCarType(null,null);
            int countAll = 0;
            int sitPeopleNum = 0;
            for(CarGroupCount carGroupCount :  listAll){
                String carType = carGroupCount.getCarType();
                int carCount = carGroupCount.getCarCount();
                countAll += carGroupCount.getCarCount();
                sitPeopleNum += carGroupCount.getSitPeopleNum();
                if(carType==null){
                    continue;
                }
                if(carType.equals("危货")){
                    capacityAnalysisWeihuo.setCarTotalNum(carCount);
                }else if(carType.equals("普货")){
                    //TODO: 普货多加1200台假车--到时候需要清除
                    //carCount += 4200;
                    capacityAnalysisPuhuo.setCarTotalNum(carCount);
                }else if(carType.equals("客运")){
                    capacityAnalysisKeyun.setCarTotalNum(carCount);
                }
            }
            countAll = capacityAnalysisWeihuo.getCarTotalNum()+capacityAnalysisPuhuo.getCarTotalNum() + capacityAnalysisKeyun.getCarTotalNum();
            capacityAnalysisAll.setCarTotalNum(countAll);
            //2.在线数
            List<CarGroupCount> listOnline = carInfoService.selectGroupByCarType("1",null);
            countAll = 0;
            for(CarGroupCount carGroupCount :  listOnline){
                String carType = carGroupCount.getCarType();
                int carCount = carGroupCount.getCarCount();
                countAll += carGroupCount.getCarCount();
                if(carType==null){
                    continue;
                }
                if(carType.equals("危货")){
                    capacityAnalysisWeihuo.setOnlineNum(carCount);
                }else if(carType.equals("普货")){
                    //TODO: 普货多加1200台假车--到时候需要清除
                    //carCount = carCount*9095/5095;
                    capacityAnalysisPuhuo.setOnlineNum(carCount);
                }else if(carType.equals("客运")){
                    capacityAnalysisKeyun.setOnlineNum(carCount);
                }

            }
            countAll = capacityAnalysisWeihuo.getOnlineNum() + capacityAnalysisPuhuo.getOnlineNum()
                    + capacityAnalysisKeyun.getOnlineNum();
            capacityAnalysisAll.setOnlineNum(countAll);
            //3.运营数
            List<CarGroupCount> listOperiting = carInfoService.selectGroupByCarType(null,"1");
            countAll = 0;
            double mileageAll = 0;
            double timeTotalAll = 0;
            for(CarGroupCount carGroupCount :  listOperiting){
                String carType = carGroupCount.getCarType();
                int carCount = carGroupCount.getCarCount();
                countAll += carGroupCount.getCarCount();
                //总里程万公里
                double mileageTotal = carGroupCount.getMileageTotal();
                double timeTotal = carGroupCount.getTimeTotal();
                //普货*1.5
                if(carType==null){
                    continue;
                }
               /* if(carType.equals("普货")){
                    mileageTotal = mileageTotal*1.5;
                    timeTotal = timeTotal*1.5;
                }*/
                mileageAll += mileageTotal;
                timeTotalAll += timeTotal;
                if(carType.equals("危货")){
                    capacityAnalysisWeihuo.setOperationNum(carCount);
                    //运力峰值
                    capacityAnalysisWeihuo.setCurrentOperationMax(new BigDecimal((carGroupCount.getTotalPullMass()+carGroupCount.getTotalTakeMass())/(1000*10000)));
                    capacityAnalysisWeihuo.setDayTotalMileage(new BigDecimal(mileageTotal).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
                    capacityAnalysisWeihuo.setDayTotalTime(new BigDecimal(timeTotal/60).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
                }else if(carType.equals("普货")){
                    //TODO: 普货多加1200台假车--到时候需要清除
                    //carCount = carCount*8095/7095;
                    capacityAnalysisPuhuo.setOperationNum(carCount);
                    //运力峰值
                    capacityAnalysisPuhuo.setCurrentOperationMax(new BigDecimal((carGroupCount.getTotalPullMass()+carGroupCount.getTotalTakeMass())/(1000*10000)));
                    /*capacityAnalysisPuhuo.setDayTotalMileage(new BigDecimal(mileageTotal).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
                    capacityAnalysisPuhuo.setDayTotalTime(new BigDecimal(timeTotal/60).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));*/
                    //普货的里程和时间*1.5
                    capacityAnalysisPuhuo.setDayTotalMileage(new BigDecimal(mileageTotal).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
                    capacityAnalysisPuhuo.setDayTotalTime(new BigDecimal(timeTotal/60).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
                }else if(carType.equals("客运")){
                    capacityAnalysisKeyun.setOperationNum(carCount);
                    //运力峰值
                    capacityAnalysisKeyun.setCurrentOperationMax(new BigDecimal(carGroupCount.getSitPeopleNum()/(10000)));
                    capacityAnalysisKeyun.setDayTotalMileage(new BigDecimal(mileageTotal).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
                    capacityAnalysisKeyun.setDayTotalTime(new BigDecimal(timeTotal/60).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
                }
            }
            if(capacityAnalysisKeyun.getOperationNum()==null){
                capacityAnalysisKeyun.setOperationNum(0);
            }
            countAll = capacityAnalysisWeihuo.getOperationNum() + capacityAnalysisPuhuo.getOperationNum() + capacityAnalysisKeyun.getOperationNum();
            capacityAnalysisAll.setOperationNum(countAll);
            //设置总的运力分析
            capacityAnalysisAll.setCurrentOperationMax(capacityAnalysisPuhuo.getCurrentOperationMax().add(capacityAnalysisWeihuo.getCurrentOperationMax()));
            capacityAnalysisAll.setDayTotalMileage(new BigDecimal(mileageAll).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
            capacityAnalysisAll.setDayTotalTime(new BigDecimal(timeTotalAll/60).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));

            //4.上线率运营率
            capacityAnalysisAll.fenxiData();
            capacityAnalysisWeihuo.fenxiData();
            capacityAnalysisPuhuo.fenxiData();
            capacityAnalysisKeyun.fenxiData();

            cityTransportCapacityAnalysisService.insertOrUpdate(capacityAnalysisAll);
            cityTransportCapacityAnalysisService.insertOrUpdate(capacityAnalysisWeihuo);
            cityTransportCapacityAnalysisService.insertOrUpdate(capacityAnalysisPuhuo);
            cityTransportCapacityAnalysisService.insertOrUpdate(capacityAnalysisKeyun);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    //分析车辆的去向分布


    //从excel中导入车辆信息
    /*@Scheduled(cron = "0 2 11 * * ?")
    public void initCarFromExcel(){
        FileInputStream fis = null;
        Workbook book = null;
        try {
            fis = new FileInputStream("D:\\import-xyx-car.xls");
            book = Workbook.getWorkbook(fis);
            Sheet carSheet = book.getSheet(0);
            int rows = carSheet.getRows();
            if(rows<2){
                System.out.println("没有车辆信息");
                return;
            }
            List<String> propertyEg = new ArrayList<String>();
            Cell[] headers = carSheet.getRow(0);
            for(int i=0;i<headers.length;i++){
                Cell cell = headers[i];
                String cellValue = cell.getContents();
                if(cellValue==null && cellValue.length()==0){
                    propertyEg.add("none");
                    continue;
                }
                propertyEg.add(fenxiHeaderForBeidouinfo(cellValue));
            }
//            List<CarInfo> carinfoList = new ArrayList<CarInfo>();
            for(int i=1;i<rows;i++){
                Map<String,String> propertyMap= new HashMap<String,String>();
                Cell[] properties = carSheet.getRow(i);
                for(int j=0;j<properties.length;j++){
                    Cell cell = properties[j];
                    if(propertyEg.size()<=j)continue;
                    String key = propertyEg.get(j);
                    propertyMap.put(key,cell.getContents());
                }
                CarInfo carInfo = ObjectUtil.mapToBean(propertyMap,CarInfo.class);

                String carFrameNum = carInfo.getCarFrameNum();
                if(carFrameNum.equals("无")){
                    carInfo.setCarFrameNum("");
                }
                String carPlateColorText = carInfo.getCarPlateColorText();
                String carPlateColor = "";
                if(carPlateColorText.equals("黄色")){
                    carPlateColor = "2";
                }else if(carPlateColorText.equals("蓝色")){
                    carPlateColor = "1";
                }else if(carPlateColorText.equals("黑色")){
                    carPlateColor = "3";
                }else if(carPlateColorText.equals("白色")){
                    carPlateColor = "4";
                }else if(carPlateColorText.equals("黄绿相间")){
                    carPlateColor = "9";
                }
                carInfo.setCarPlateColour(carPlateColor);
                String carType = carInfo.getCarType();
                if(carType.equals("客运")){
                    carInfo.setTotalTakeMass(new BigDecimal(0));
                    carInfo.setTotalPullMass(new BigDecimal(0));
                    carInfo.setSitPeopleNum(40);
                }else if(carType.equals("危货")){
                    carInfo.setTotalTakeMass(new BigDecimal(12965));
                    carInfo.setTotalPullMass(new BigDecimal(0));
                    carInfo.setSitPeopleNum(2);
                }else if(carType.equals("普货")){
                    carInfo.setSitPeopleNum(2);
                }
                carInfo.setId(carInfo.getCarPlateNum()+"_" + carPlateColor);
                CarInfo oraCarInfo = carInfoService.loadById(carInfo.getId());

                if(oraCarInfo==null){
                    carInfo.setCreateTime(new Date());
                    carInfoService.insert(carInfo);
                }else{
                    carInfoService.update(carInfo);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(book!=null){
                book.close();
            }
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    //分析表头
    private String fenxiHeaderForBeidouinfo(String cellValue){
        if(cellValue.indexOf("车架号")>=0)return "carFrameNum";
        else if(cellValue.indexOf("车牌号")>=0)return "carPlateNum";
        else if(cellValue.indexOf("车牌颜色")>=0)return "carPlateColorText";
        else if(cellValue.indexOf("车辆类型")>=0)return "carType";
        else if(cellValue.indexOf("核定载质量")>=0)return "totalTakeMass";
        else if(cellValue.indexOf("准牵引总质量")>=0)return "totalPullMass";
        else if(cellValue.indexOf("核载人数")>=0)return "sitPeopleNum";
        return "none;";
    }*/

    public static boolean isSameDay(Date date1, Date date2) {
        if(date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if(cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }
  }
