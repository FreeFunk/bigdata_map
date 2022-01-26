package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionView;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionView;
import com.edgedo.bigdata.queryvo.CarQuXiangGroupCount;
import com.edgedo.bigdata.service.*;
import com.edgedo.common.util.BaiDuMapApiUtil;
import com.edgedo.sys.entity.SysCity;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.service.SysCityService;
import com.edgedo.sys.service.SysProviceService;
import com.edgedo.sys.service.SysXianquService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@ConditionalOnProperty(
        value = {"timetask.analysis.BigDataAnalysisQuXiangFenbu.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigDataAnalysisQuXiangFenbu {
    @Autowired
    BigdataCarStopRecordService carStopRecordService;
    @Autowired
    BaiDuMapApiUtil baiDuMapApiUtil;
    @Autowired
    SysProviceService sysProviceService;
    @Autowired
    SysXianquService sysXianquService;
    @Autowired
    SysCityService sysCityService;
    @Autowired
    CarInfoService carInfoService;

    @Autowired
    CarDayDirectionDistributionService carDayDirectionService;
    @Autowired
    CarMonthDirectionDistributionService carMonthDirectionDistributionService;
    @Autowired
    BigdataCarDayOftenrunRouteService carDayOftenrunRouteService;
    @Autowired
    CarMonthOftenrunRouteService carMonthOftenrunRouteService;
    @Autowired
    OftenrunRouteMonthCountService oftenrunRouteMonthCountService;

    //省份的map
    Map<String,SysProvice> proviceMap = new HashMap<String,SysProvice>();
    //城市的map
    Map<String,SysCity> cityMap = new HashMap<String,SysCity>();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //月份的格式化
    private SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyyMM");
    //日期数字的格式化
    private SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

    /**
     * 设置停车记录的地理位置
     */
//    @Scheduled(cron = "0 18 14 * * ?")
    //@Scheduled(cron = "0 0/24 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisQuXiangFenbu.cron.fenxiStopRecord}")
    public void fenxiStopRecord(){
        try{
            //分组统计当日的去向省情况
            Date curDate = new Date();
            String dateIntStr = sdfDateInt.format(curDate);
            int dateInt = new Integer(dateIntStr);
            int countMonth = dateInt/100;
            int yearNum = countMonth/100;
            //全部类型  城市去向分布
            List<CarQuXiangGroupCount> cityAllFenbu =
                    carStopRecordService.selectCityQuXiangGroup(null,dateInt,countMonth,yearNum);
            freshCarCityDirection(cityAllFenbu,"总");
            //全部的省份去向分布
            List<CarQuXiangGroupCount> provinceAllFenbu =
                    carStopRecordService.selectProvinceQuXiangGroup(null,dateInt,countMonth,yearNum);
            freshCarProvinceDirection(provinceAllFenbu,"总");

            //危货类型  城市去向分布
            List<CarQuXiangGroupCount> cityWeihuoFenbu = carStopRecordService.selectCityQuXiangGroup("危货",dateInt,countMonth,yearNum);
            freshCarCityDirection(cityWeihuoFenbu,"危货");
            //危货的去向分布
            List<CarQuXiangGroupCount> provinceWeihuoFenbu = carStopRecordService.selectProvinceQuXiangGroup("危货",dateInt,countMonth,yearNum);
            freshCarProvinceDirection(provinceWeihuoFenbu,"危货");

            //客运类型  城市去向分布
            List<CarQuXiangGroupCount> cityKeyunFenbu = carStopRecordService.selectCityQuXiangGroup("客运",dateInt,countMonth,yearNum);
            freshCarCityDirection(cityKeyunFenbu,"客运");
            //客运的去向分布
            List<CarQuXiangGroupCount> provinceKeyunFenbu = carStopRecordService.selectProvinceQuXiangGroup("客运",dateInt,countMonth,yearNum);
            freshCarProvinceDirection(provinceKeyunFenbu,"客运");

            //客运类型  城市去向分布
            List<CarQuXiangGroupCount> cityPuhuoFenbu = carStopRecordService.selectCityQuXiangGroup("普货",dateInt,countMonth,yearNum);
            freshCarCityDirection(cityPuhuoFenbu,"普货");
            //普货的去向分布
            List<CarQuXiangGroupCount> provincePuhuoFenbu = carStopRecordService.selectProvinceQuXiangGroup("普货",dateInt,countMonth,yearNum);
            freshCarProvinceDirection(provincePuhuoFenbu,"普货");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 当月去向分布月度汇总
     */
//    @Scheduled(cron = "0 0/5 * * * ?")
    //@Scheduled(cron = "0 0/58 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisQuXiangFenbu.cron.quXiangMonthSum}")
    public void quXiangMonthSum(){
        Date curDate = new Date();
        String monthIntStr = sdfMonth.format(curDate);
        Integer countMonth = new Integer(monthIntStr);
        Integer yearNum = countMonth/100;
        int yearQuarter = currentYearQuarter();
        //直接根据时间汇总各个类型的字段-去向分布日统计
        List<CarDayDirectionDistributionView> list = carDayDirectionService.listQuxiangGroupSumOfMonthProvince(countMonth,yearNum);
        //新增或者修改当月的汇总记录
        for(CarDayDirectionDistribution directionDistribution : list){
            String provinceId = directionDistribution.getProvinceId();
            String provinceName = directionDistribution.getProvinceName();
            String carType = directionDistribution.getCarType();
            Integer carNum = directionDistribution.getCarNum();
            String month = sdfMonth.format(curDate);
            String id = "M-"+month+"-" + provinceId + "-" + directionDistribution.getCarType();
            CarMonthDirectionDistribution temDistribution = carMonthDirectionDistributionService.loadById(id);
            if(temDistribution==null){
                //不存在 新增
                temDistribution = new CarMonthDirectionDistribution();
                temDistribution.setId(id);
                temDistribution.setCreateTime(new Date());
                temDistribution.setAreaCountType("province");
                temDistribution.setCarNum(carNum);
                temDistribution.setCarType(carType);
                temDistribution.setProvinceId(provinceId);
                temDistribution.setProvinceName(provinceName);
                temDistribution.setCountTime(new Date());
                temDistribution.setCountType("month");
                temDistribution.setQuarterType(yearQuarter);
                carMonthDirectionDistributionService.insert(temDistribution);
            }else{
                //存在 更新
                temDistribution.setCarNum(carNum);
                carMonthDirectionDistributionService.update(temDistribution);
            }
        }

        //开始月度的城市汇总
        List<CarDayDirectionDistributionView> listCity = carDayDirectionService.listQuxiangGroupSumOfMonthCity(countMonth,yearNum);
        //新增或者修改当月的汇总记录
        for(CarDayDirectionDistribution directionDistribution : listCity){
            String provinceId = directionDistribution.getProvinceId();
            String provinceName = directionDistribution.getProvinceName();
            String cityId = directionDistribution.getCityId();
            String cityName = directionDistribution.getCityName();

            String carType = directionDistribution.getCarType();
            Integer carNum = directionDistribution.getCarNum();
            String month = sdfMonth.format(curDate);
            String id = "M-" + month + "-" + provinceId + "-" + cityId + "-" + directionDistribution.getCarType();
            CarMonthDirectionDistribution temDistribution = carMonthDirectionDistributionService.loadById(id);
            if(temDistribution==null){
                //不存在 新增
                temDistribution = new CarMonthDirectionDistribution();
                temDistribution.setId(id);
                temDistribution.setCreateTime(new Date());
                temDistribution.setAreaCountType("city");
                temDistribution.setCarNum(carNum);
                temDistribution.setCarType(carType);
                temDistribution.setProvinceId(provinceId);
                temDistribution.setProvinceName(provinceName);
                temDistribution.setCityId(cityId);
                temDistribution.setCityName(cityName);
                temDistribution.setCountTime(new Date());
                temDistribution.setCountType("month");
                temDistribution.setQuarterType(yearQuarter);
                carMonthDirectionDistributionService.insert(temDistribution);
            }else{
                //存在 更新
                temDistribution.setCarNum(carNum);
                carMonthDirectionDistributionService.update(temDistribution);
            }
        }

    }

    /**
     * 当季度去向分布月度汇总
     */
//    @Scheduled(cron = "0 0/5 * * * ?")
    //@Scheduled(cron = "0 0/58 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisQuXiangFenbu.cron.quXiangJiDuSum}")
    public void quXiangJiDuSum(){
        try {
            int yearQuarter = currentYearQuarter();
            List<CarMonthDirectionDistributionView> list = carMonthDirectionDistributionService.listQuxiangGroupSumOfJiduProvince(yearQuarter);
            for (CarMonthDirectionDistributionView directionDistribution : list) {
                String provinceId = directionDistribution.getProvinceId();
                String provinceName = directionDistribution.getProvinceName();
                String carType = directionDistribution.getCarType();
                Integer carNum = directionDistribution.getCarNum();
                String id = "Q-" + yearQuarter + "-" + provinceId + "-" + directionDistribution.getCarType();
                CarMonthDirectionDistribution temDistribution = carMonthDirectionDistributionService.loadById(id);
                if (temDistribution == null) {
                    //不存在 新增
                    temDistribution = new CarMonthDirectionDistribution();
                    temDistribution.setId(id);
                    temDistribution.setCreateTime(new Date());
                    temDistribution.setAreaCountType("province");
                    temDistribution.setCarNum(carNum);
                    temDistribution.setCarType(carType);
                    temDistribution.setProvinceId(provinceId);
                    temDistribution.setProvinceName(provinceName);
                    temDistribution.setCountTime(new Date());
                    temDistribution.setCountType("quarter");
                    temDistribution.setQuarterType(yearQuarter);
                    carMonthDirectionDistributionService.insert(temDistribution);
                } else {
                    //存在 更新
                    temDistribution.setCarNum(carNum);
                    carMonthDirectionDistributionService.update(temDistribution);
                }
            }

            //城市的季度汇总
            List<CarMonthDirectionDistributionView> listCity = carMonthDirectionDistributionService.listQuxiangGroupSumOfJiduCity(yearQuarter);
            for (CarMonthDirectionDistributionView directionDistribution : listCity) {
                String provinceId = directionDistribution.getProvinceId();
                String provinceName = directionDistribution.getProvinceName();
                String cityId = directionDistribution.getCityId();
                String cityName = directionDistribution.getCityName();
                String carType = directionDistribution.getCarType();
                Integer carNum = directionDistribution.getCarNum();
                String id = "Q-" + yearQuarter + "-" + provinceId + "-" + directionDistribution.getCityId() + "-" + directionDistribution.getCarType();
                CarMonthDirectionDistribution temDistribution = carMonthDirectionDistributionService.loadById(id);
                if (temDistribution == null) {
                    //不存在 新增
                    temDistribution = new CarMonthDirectionDistribution();
                    temDistribution.setId(id);
                    temDistribution.setCreateTime(new Date());
                    temDistribution.setAreaCountType("city");
                    temDistribution.setCarNum(carNum);
                    temDistribution.setCarType(carType);
                    temDistribution.setProvinceId(provinceId);
                    temDistribution.setProvinceName(provinceName);
                    temDistribution.setCityId(cityId);
                    temDistribution.setCityName(cityName);
                    temDistribution.setCountTime(new Date());
                    temDistribution.setCountType("quarter");
                    temDistribution.setQuarterType(yearQuarter);
                    carMonthDirectionDistributionService.insert(temDistribution);
                } else {
                    //存在 更新
                    temDistribution.setCarNum(carNum);
                    carMonthDirectionDistributionService.update(temDistribution);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 车辆 长跑线路统计 后半夜统计长跑线路
     */
//    @Scheduled(cron = "0 0/5 * * * ?")
    //@Scheduled(cron = "0 0 22 * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisQuXiangFenbu.cron.changpaoXianluTj}")
    public void changpaoXianluTj(){
        try{


           // int totalCarNum = carInfoService.countAll();
            int totalCarNum = carInfoService.selectSortNum();

            int times = 20;
            final int oneNum = totalCarNum / times;
            //多线程遍历数据库
            for (int i = 0; i < times; i++) {
                final int fiIndex = i;

                Thread t = new Thread() {
                    @Override
                    public void run() {
                        int start = oneNum * fiIndex;
                        int end = oneNum * (fiIndex + 1) - 1;
                        List<CarInfo> carList = carInfoService.listByStartAndEndBySortNum(start, end);
                        // 统计每辆车的所跑的路线
                        //线程遍历所有的车
                        for (CarInfo car : carList) {
                            tongjiCarDayLuxian(car);
                        }
                    }
                };
                t.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 11点时候统计车辆月度长跑路线
     */

    //@Scheduled(cron = "0 0 23 * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisQuXiangFenbu.cron.changpaoCarMonthJiduCount}")
    public void changpaoCarMonthJiduCount(){
        try{
            //int totalCarNum = carInfoService.countAll();
            int totalCarNum = carInfoService.selectSortNum();
            int times = 20;
            final int oneNum = totalCarNum / times;
            //多线程遍历数据库
            for (int i = 0; i < times; i++) {
                final int fiIndex = i;

                Thread t = new Thread() {
                    @Override
                    public void run() {
                        int start = oneNum * fiIndex;
                        int end = oneNum * (fiIndex + 1) - 1;
                        List<CarInfo> carList = carInfoService.listByStartAndEndBySortNum(start, end);
                        // 统计每辆车的所跑的路线
                        //线程遍历所有的车
                        for (CarInfo car : carList) {
                            tongjiCarMonthJiDuLuxian(car);
                        }
                    }
                };
                t.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 非车辆月度季度常跑路线汇总
     */

//    @Scheduled(cron = "0 41 23 * * ?")
    //@Scheduled(cron = "0 7 11 * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisQuXiangFenbu.cron.changpaoMonthJiduSum}")
    public void changpaoMonthJiduSum(){
        try{
            String monthStr = sdfMonth.format(new Date());
            Integer jidu = currentYearQuarter();
            //分车辆类型的月度统计
            sumChangpaoMonth(monthStr,"总");
            sumChangpaoMonth(monthStr,"普货");
            sumChangpaoMonth(monthStr,"客运");
            sumChangpaoMonth(monthStr,"危货");
            //分车辆类型的季度统计
            sumChangpaoJidu(jidu,"总");
            sumChangpaoJidu(jidu,"普货");
            sumChangpaoJidu(jidu,"客运");
            sumChangpaoJidu(jidu,"危货");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //统计某个类型对应的季度常跑数据
    private void sumChangpaoJidu(int jidu,String carType){
        int yearNum = jidu/10;
        String carTypeParam = null;
        if(!carType.equals("总")){
            carTypeParam = carType;
        }
        List<OftenrunRouteMonthCount> listMonthGroupSum =
                oftenrunRouteMonthCountService.selectGroupSumOfQuarter(jidu,carTypeParam);
        for(OftenrunRouteMonthCount routeMonthCount : listMonthGroupSum){
            String id = carType + "-Q" + routeMonthCount.getStartCityName()
                    +jidu + routeMonthCount.getEndCityName();
            OftenrunRouteMonthCount dbRouteMonthCount = oftenrunRouteMonthCountService.loadByIdByDate(id,yearNum);
            if(dbRouteMonthCount==null){
                //新增
                routeMonthCount.setId(id);
                routeMonthCount.setCreateTime(new Date());
                routeMonthCount.setCountTime(new Date());
                routeMonthCount.setCountType("quarter");
                routeMonthCount.setCarType(carType);
                routeMonthCount.setQuarterType(jidu);
                routeMonthCount.setYearNum(yearNum);
                oftenrunRouteMonthCountService.insert(routeMonthCount);
            }else{
                //修改
                dbRouteMonthCount = new OftenrunRouteMonthCount();
                dbRouteMonthCount.setId(id);
                dbRouteMonthCount.setYearNum(null);
                dbRouteMonthCount.setRunNum(routeMonthCount.getRunNum());
                dbRouteMonthCount.setSumMileage(routeMonthCount.getSumMileage());
                oftenrunRouteMonthCountService.update(dbRouteMonthCount);
            }
        }

    }

    //统计某个类型对应的月度常跑数据
    private void sumChangpaoMonth(String monthStr, String carType) {
        String carTypeParam = null;
        if(!carType.equals("总")){
            carTypeParam = carType;
        }
        Integer jidu = currentYearQuarter();
        int monthInt = new Integer(monthStr);
        int yearNum = monthInt/100;
        List<CarMonthOftenrunRoute> listMonthGroupSum = carMonthOftenrunRouteService.selectGroupSumOfMonth(monthInt,carTypeParam);
        for(CarMonthOftenrunRoute carMonthOftenrunRoute : listMonthGroupSum){
            //统计主键 = 车辆类型 + M + 开始城市+月份+到达城市
            String id = carType + "-M" + carMonthOftenrunRoute.getStartCityName() + monthStr + carMonthOftenrunRoute.getEndCityName();
            OftenrunRouteMonthCount monthCount = oftenrunRouteMonthCountService.loadByIdByDate(id,yearNum);
            if(monthCount==null){
                //新增
                monthCount = new OftenrunRouteMonthCount();
                monthCount.setId(id);
                monthCount.setCarType(carType);
                monthCount.setCountTime(new Date());
                monthCount.setCountType("month");
                monthCount.setCreateTime(new Date());
                monthCount.setEndCityId(carMonthOftenrunRoute.getEndCityId());
                monthCount.setEndCityName(carMonthOftenrunRoute.getEndCityName());
                monthCount.setEndProvinceId(carMonthOftenrunRoute.getEndProvinceId());
                monthCount.setEndProvinceName(carMonthOftenrunRoute.getEndProvinceName());
                monthCount.setQuarterType(jidu);
                monthCount.setMonthStr(monthStr);
                monthCount.setCountMonth(monthInt);
                monthCount.setYearNum(yearNum);
                monthCount.setRunNum(carMonthOftenrunRoute.getRunNum());
                monthCount.setRunRoute(carMonthOftenrunRoute.getRunRoute());
                monthCount.setStartCityId(carMonthOftenrunRoute.getStartCityId());
                monthCount.setStartCityName(carMonthOftenrunRoute.getStartCityName());
                monthCount.setStartProvinceId(carMonthOftenrunRoute.getStartProvinceId());
                monthCount.setStartProvinceName(carMonthOftenrunRoute.getStartProvinceName());
                monthCount.setSumMileage(carMonthOftenrunRoute.getSumMileage());
                oftenrunRouteMonthCountService.insert(monthCount);

            }else{
                //修改
                monthCount = new OftenrunRouteMonthCount();
                monthCount.setId(id);
                monthCount.setCountMonth(null);
                monthCount.setYearNum(null);
                monthCount.setQuarterType(null);
                monthCount.setRunNum(carMonthOftenrunRoute.getRunNum());
                monthCount.setSumMileage(carMonthOftenrunRoute.getSumMileage());
                oftenrunRouteMonthCountService.update(monthCount);
            }

        }
    }


    //统计车辆的月度和季度的路线
    private void tongjiCarMonthJiDuLuxian(CarInfo car){
        Calendar cal = Calendar.getInstance();

        String dateIntStr = sdfDateInt.format(cal.getTime());
        int dateInt = new Integer(dateIntStr);
        int countMonth = dateInt/100;
        int yearNum = countMonth/100;
        String carRealId = car.getId();
        //拿到当前月度的单车统计
        List<BigdataCarDayOftenrunRoute> listGroupCar =
                carDayOftenrunRouteService.selectGroupSumOfMonth(countMonth,carRealId);

        int year = cal.get(Calendar.YEAR);
        int jidu = currentYearQuarter();

        for(BigdataCarDayOftenrunRoute dayOftenrunRoute : listGroupCar ){
            //月度统计的id = M+车牌号+车牌颜色+开始城市+统计月份+目标城市
            String id = "M" + dayOftenrunRoute.getCarRealId() +
                    "-" + dayOftenrunRoute.getStartCityName() + countMonth +
                    "-" + dayOftenrunRoute.getEndCityName() ;
            CarMonthOftenrunRoute carMonthOftenrunRoute = carMonthOftenrunRouteService.loadByIdAndDate(id,yearNum);
            if(carMonthOftenrunRoute==null){
                //新增
                carMonthOftenrunRoute = new CarMonthOftenrunRoute();
                carMonthOftenrunRoute.setId(id);
                carMonthOftenrunRoute.setCarFrameNum(dayOftenrunRoute.getCarFrameNum());
                carMonthOftenrunRoute.setCarPlateNum(dayOftenrunRoute.getCarPlateNum());
                carMonthOftenrunRoute.setCarType(dayOftenrunRoute.getCarType());
                carMonthOftenrunRoute.setCountTime(new Date());
                carMonthOftenrunRoute.setCountType("month");
                carMonthOftenrunRoute.setCreateTime(new Date());
                carMonthOftenrunRoute.setEndCityId(dayOftenrunRoute.getEndCityId());
                carMonthOftenrunRoute.setEndCityName(dayOftenrunRoute.getEndCityName());
                carMonthOftenrunRoute.setEndProvinceId(dayOftenrunRoute.getEndProvinceId());
                carMonthOftenrunRoute.setEndProvinceName(dayOftenrunRoute.getEndProvinceName());
                carMonthOftenrunRoute.setOwnerTeamId(dayOftenrunRoute.getOwnerTeamId());
                carMonthOftenrunRoute.setOwnerTeamName(dayOftenrunRoute.getOwnerTeamName());
                carMonthOftenrunRoute.setRunNum(dayOftenrunRoute.getRunLineNum());
                carMonthOftenrunRoute.setRunRoute(dayOftenrunRoute.getRunRoute());
                carMonthOftenrunRoute.setStartCityId(dayOftenrunRoute.getStartCityId());
                carMonthOftenrunRoute.setStartCityName(dayOftenrunRoute.getStartCityName());
                carMonthOftenrunRoute.setStartProvinceId(dayOftenrunRoute.getStartProvinceId());
                carMonthOftenrunRoute.setStartProvinceName(dayOftenrunRoute.getStartProvinceName());
                carMonthOftenrunRoute.setSumMileage(dayOftenrunRoute.getSumMileage());
                carMonthOftenrunRoute.setCarRealId(dayOftenrunRoute.getCarRealId());
                carMonthOftenrunRoute.setCarPlateColor(dayOftenrunRoute.getCarPlateColor());
                carMonthOftenrunRoute.setMonthStr(sdfMonth.format(cal.getTime()));
                carMonthOftenrunRoute.setCountMonth(countMonth);
                carMonthOftenrunRoute.setYearNum(yearNum);
                carMonthOftenrunRoute.setQuarterType(jidu);
                carMonthOftenrunRouteService.insert(carMonthOftenrunRoute);
            }else{
                //更新
                carMonthOftenrunRoute = new CarMonthOftenrunRoute();
                carMonthOftenrunRoute.setId(id);
                carMonthOftenrunRoute.setCountMonth(null);
                carMonthOftenrunRoute.setYearNum(null);
                carMonthOftenrunRoute.setQuarterType(null);
                carMonthOftenrunRoute.setRunNum(dayOftenrunRoute.getRunLineNum());
                carMonthOftenrunRoute.setSumMileage(dayOftenrunRoute.getSumMileage());
                carMonthOftenrunRouteService.update(carMonthOftenrunRoute);
            }

        }

        List<CarMonthOftenrunRoute> listJiDuGroupSum = carMonthOftenrunRouteService.selectGroupSumOfJidu(year,jidu,carRealId);
        //拿到当前季度的单车统计
        for(CarMonthOftenrunRoute carMonthOftenrunRoute : listJiDuGroupSum){
            //月度统计的id = Q+车牌号+车牌颜色+开始城市+统计年份+"-" + 季度+目标城市
            String id = "Q" + carMonthOftenrunRoute.getCarRealId() +
                    "-" + carMonthOftenrunRoute.getStartCityName() +
                     carMonthOftenrunRoute.getQuarterType() +
                    "-" + carMonthOftenrunRoute.getEndCityName() ;
            CarMonthOftenrunRoute dbJiduRouteCount = carMonthOftenrunRouteService.loadByIdAndDate(id,yearNum);
            if(dbJiduRouteCount==null){
                //新增
                carMonthOftenrunRoute.setCountTime(new Date());
                carMonthOftenrunRoute.setCreateTime(new Date());
                carMonthOftenrunRoute.setCountType("quarter");
                carMonthOftenrunRoute.setYearNum(yearNum);
                carMonthOftenrunRoute.setQuarterType(jidu);
                carMonthOftenrunRoute.setId(id);
                carMonthOftenrunRouteService.insert(carMonthOftenrunRoute);
            }else{
                //更新
                //更新
                dbJiduRouteCount = new CarMonthOftenrunRoute();
                dbJiduRouteCount.setId(id);
                dbJiduRouteCount.setYearNum(null);
                dbJiduRouteCount.setQuarterType(null);
                dbJiduRouteCount.setRunNum(carMonthOftenrunRoute.getRunNum());
                dbJiduRouteCount.setSumMileage(carMonthOftenrunRoute.getSumMileage());
                carMonthOftenrunRouteService.update(dbJiduRouteCount);
            }

        }
    }

    //统计路线
    private void tongjiCarDayLuxian(CarInfo car){
        Calendar cal = Calendar.getInstance();
        Date timeMax = cal.getTime();
        cal.add(Calendar.DAY_OF_MONTH,-10);
        Date timeMin = cal.getTime();



        //单车查出5天的停车记录
        List<BigdataCarStopRecord> list = carStopRecordService.listCarStopRecOfCar(
                car.getId(),timeMin,timeMax);

        List<BigdataCarStopRecord> listPointStopList = new ArrayList<BigdataCarStopRecord>();
        //线路的map
        Map<String,BigdataCarDayOftenrunRoute>  dayRouteMap = new HashMap<String,BigdataCarDayOftenrunRoute>();

        for(BigdataCarStopRecord stopRec : list){
            int pointSize = listPointStopList.size();
            if(pointSize>0){
                //如果列表中已经有了那么对比上次和这次的城市是否变动
                BigdataCarStopRecord rec = listPointStopList.get(pointSize-1);
                String lastCityName = rec.getMapCity();
                String lastCityId = rec.getMapCityId();
                String thisCityName = stopRec.getMapCity();
                String thisCityId = rec.getMapCityId();
                if(
                        lastCityName==null || lastCityName.length()==0
                        || thisCityName==null || thisCityName.length()==0
                        ||lastCityId==null || lastCityId.length()==0
                        || thisCityId==null || thisCityId.length()==0
                        ){
                    continue;
                }

                if(lastCityName.equals(thisCityName)){
                    //两个相等那么将列表中的上一个替换成现在这个
                    listPointStopList.remove(rec);
                    listPointStopList.add(stopRec);
                }else{
                    //不是一个城市那么就直接加入吧
                    listPointStopList.add(stopRec);
                }
            }else{
                //如果没有那么直接加入
                listPointStopList.add(stopRec);
            }

        }

        int seriSize = listPointStopList.size();
        for(int i=0;i<seriSize-1;i++){
            //线路的map
            Map<String,BigdataCarDayOftenrunRoute>  tempDayRouteMap = new HashMap<String,BigdataCarDayOftenrunRoute>();
            for(int j=i+1;j<seriSize;j++){
                BigdataCarStopRecord startPoint = listPointStopList.get(i);
                BigdataCarStopRecord endPoint = listPointStopList.get(j);
                String startCity = startPoint.getMapCity();
                String endCity = endPoint.getMapCity();
                //如果是又回到出发点那么不算线路
                if(startCity!=null && endCity!=null && startCity.equals(endCity)){
                    break;
                }
                //生成停车记录 停车记录的id  车牌号+车牌颜色+开始城市+开始城市的最后停车日期+目标城市
                String routerId =
                        endPoint.getCarRealId() +
                                "-" + startCity + sdfDateInt.format(startPoint.getEndTime()) +
                                "-" + endCity ;
                BigdataCarDayOftenrunRoute route = new BigdataCarDayOftenrunRoute();
                route.setId(routerId);
                route.setCarFrameNum(car.getCarFrameNum());
                route.setCarPlateColor(car.getCarPlateColour());
                route.setCarPlateNum(car.getCarPlateNum());
                route.setCarRealId(car.getId());
                route.setCarType(car.getCarType());
                route.setCountTime(endPoint.getEndTime());
                //起始城市
                route.setStartCityId(startPoint.getMapCityId());
                route.setStartCityName(startPoint.getMapCity());
                route.setStartProvinceId(startPoint.getMapProvinceId());
                route.setStartProvinceName(startPoint.getMapProvince());
                route.setStartTime(startPoint.getEndTime());
                //到达城市
                route.setEndCityId(endPoint.getMapCityId());
                route.setEndCityName(endPoint.getMapCity());
                route.setEndProvinceId(endPoint.getMapProvinceId());
                route.setEndProvinceName(endPoint.getMapProvince());
                route.setEndTime(endPoint.getEndTime());

                route.setOwnerTeamId(car.getOwnerTeamId());
                route.setOwnerTeamName(car.getOwnerTeamName());
                route.setRunLineNum(1);
                route.setRunRoute(startPoint.getMapCity() + "-" + endPoint.getMapCity());
                //TODO:计算行驶里程
                //                                        route.setSumMileage();
                if(startPoint.getMapProvince().equals(endPoint.getMapProvince())){
                    route.setIsTransProvincial("0");
                }else{
                    route.setIsTransProvincial("1");
                }
                BigdataCarDayOftenrunRoute bigdataCarDayOftenrunRoute = tempDayRouteMap.get(route.getId());
                if(bigdataCarDayOftenrunRoute==null){
                    tempDayRouteMap.put(route.getId(),route);
                }else{
                   continue;
                }
            }
            Collection<BigdataCarDayOftenrunRoute> routers =  tempDayRouteMap.values();
            Iterator<BigdataCarDayOftenrunRoute> it = routers.iterator();
            while(it.hasNext()){
                BigdataCarDayOftenrunRoute carRouter =  it.next();
                BigdataCarDayOftenrunRoute glCarRouter = dayRouteMap.get(carRouter.getId());
                if(glCarRouter==null){
                    dayRouteMap.put(carRouter.getId(),carRouter);
                }else{
                    glCarRouter.setRunLineNum(glCarRouter.getRunLineNum()+1);
                }
            }
        }
        //需要更新 记录线路名，起始和截止城市名和id，起始和截止时间,记录的创建时间
        Collection<BigdataCarDayOftenrunRoute> routers = dayRouteMap.values();
        Iterator<BigdataCarDayOftenrunRoute> iterator = routers.iterator();
        while(iterator.hasNext()){
            BigdataCarDayOftenrunRoute carDayOftenrunRoute = iterator.next();
            Date countDate = carDayOftenrunRoute.getCountTime();
            String countDateIntStr = sdfDateInt.format(countDate);
            Integer countDateInt = new Integer(countDateIntStr);
            Integer countMonthInt = countDateInt/100;
            String routeId = carDayOftenrunRoute.getId();
            BigdataCarDayOftenrunRoute dbCardayOftenRoute =
                    carDayOftenrunRouteService.loadByIdAndDate(routeId,countMonthInt);

            if(dbCardayOftenRoute==null){
                //新增
                carDayOftenrunRoute.setCountDate(countDateInt);
                carDayOftenrunRoute.setCountMonth(countMonthInt);
                carDayOftenrunRoute.setCreateTime(new Date());
                carDayOftenrunRouteService.insert(carDayOftenrunRoute);
            }else{
                //更新
                dbCardayOftenRoute.setCountDate(null);
                dbCardayOftenRoute.setCountMonth(null);
                dbCardayOftenRoute.setEndTime(carDayOftenrunRoute.getEndTime());
                //TODO:更新里程
                //                                        dbCardayOftenRoute.setSumMileage();
                carDayOftenrunRouteService.update(dbCardayOftenRoute);
            }

        }
    }


    private void freshCarCityDirection(List<CarQuXiangGroupCount> list , String carType){
        for(CarQuXiangGroupCount groupCount : list){
            //总的去向分布
            SysCity city = searchCity(groupCount.getMapCity());
            if(city == null){
                continue;
            }
            //将当日的去向插入表中
            Date currentDate = new Date();
            String dateIntStr = sdfDateInt.format(currentDate);
            Integer countDate = new Integer(dateIntStr);
            Integer countMonth = countDate/100;
            Integer yearNum = countMonth/100;
            int yearQuart = currentYearQuarter();
            String id = carType + "-" + countDate + "-" + city.getProvinceId() + "-" + city.getId();

            CarDayDirectionDistribution directionAnalysis = carDayDirectionService.loadByIdAndDate(id,yearNum);
            if(directionAnalysis == null){
                directionAnalysis = new CarDayDirectionDistribution();
                directionAnalysis.setId(id);
                directionAnalysis.setCreateTime(currentDate);
                directionAnalysis.setAreaCountType("city");
                directionAnalysis.setProvinceName(city.getProvinceNane());
                directionAnalysis.setProvinceId(city.getProvinceId());
                directionAnalysis.setCityId(city.getId());
                directionAnalysis.setCityName(city.getName());
                directionAnalysis.setCarType(carType);
                directionAnalysis.setCountTime(currentDate);
                directionAnalysis.setCarNum(groupCount.getCount());
                //设置季度
                directionAnalysis.setYearQuarter(yearQuart);
                directionAnalysis.setCountDate(countDate);
                directionAnalysis.setCountMonth(countMonth);
                //分片字段
                directionAnalysis.setYearNum(yearNum);
                carDayDirectionService.insert(directionAnalysis);
            }else{
                directionAnalysis.setCarNum(groupCount.getCount());
                directionAnalysis.setYearNum(null);
                carDayDirectionService.update(directionAnalysis);
            }
        }
    }



    private void freshCarProvinceDirection(List<CarQuXiangGroupCount> list , String carType){
        for(CarQuXiangGroupCount groupCount : list){
            //总的去向分布
            SysProvice provice = searchProvince(groupCount.getMapProvince());
            if(provice == null){
                continue;
            }
            //将当日的去向插入表中
            Date currentDate = new Date();
            String dateIntStr = sdfDateInt.format(currentDate);
            Integer countDate = new Integer(dateIntStr);
            Integer countMonth = countDate/100;
            Integer yearNum = countMonth/100;
            int yearQuart = currentYearQuarter();
            String id = carType + "-" + sdf.format(currentDate) + "-" + provice.getId();

            CarDayDirectionDistribution directionAnalysis = carDayDirectionService.loadByIdAndDate(id,yearNum);
            if(directionAnalysis == null){
                directionAnalysis = new CarDayDirectionDistribution();
                directionAnalysis.setId(id);
                directionAnalysis.setCreateTime(currentDate);
                directionAnalysis.setAreaCountType("province");
                directionAnalysis.setProvinceName(provice.getName());
                directionAnalysis.setProvinceId(provice.getId());
                directionAnalysis.setCarType(carType);
                directionAnalysis.setCountTime(currentDate);
                directionAnalysis.setCarNum(groupCount.getCount());
                //设置季度
                directionAnalysis.setYearQuarter(yearQuart);
                directionAnalysis.setCountDate(countDate);
                directionAnalysis.setCountMonth(countMonth);
                //分片字段
                directionAnalysis.setYearNum(yearNum);
                carDayDirectionService.insert(directionAnalysis);
            }else{
                directionAnalysis.setCarNum(groupCount.getCount());
                directionAnalysis.setYearNum(null);
                carDayDirectionService.update(directionAnalysis);
            }
        }
    }

    //查找省份
    private SysProvice searchProvince(String provinceName){
        SysProvice oraProvince = proviceMap.get(provinceName);
        if(oraProvince==null){
            oraProvince = sysProviceService.selectOneByName(provinceName);
            if(oraProvince!=null){
                proviceMap.put( provinceName , oraProvince);
            }
        }
        return oraProvince;
    }

    private SysCity searchCity(String cityName) {
        SysCity oraCity = cityMap.get(cityName);
        if(oraCity==null){
            oraCity = sysCityService.selectOneByName(cityName);
            if(oraCity!=null){
                cityMap.put( cityName , oraCity);
            }
        }
        return oraCity;
    }

    //获得当前日期的季度
    private Integer currentYearQuarter(){
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;//1-12
        int year = cal.get(Calendar.YEAR);
        int yearQuarter = 1;
        if(month<=3 && month>=1){
            yearQuarter = 1;
        }else if(month<=6 && month>=4 ){
            yearQuarter = 2;
        }else if(month<=9 && month>=7 ){
            yearQuarter = 3;
        }else if(month<=12 && month>=10 ){
            yearQuarter = 4;
        }
        String yearQuartStr = year + "" + yearQuarter;
        return new Integer(yearQuartStr);
    }



}
