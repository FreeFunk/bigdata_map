package com.edgedo.timetask.analysis;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.service.*;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.timetask.alarm.Get2gAlertAndCardInfoFromQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

//运营分析详情
@ConditionalOnProperty(
        value = {"timetask.analysis.BigDataAnalysisOperativeInfo.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigDataAnalysisOperativeInfo {

    @Autowired
    CarInfoService carInfoService;
    @Autowired
    CityTransportCapacityAnalysisInfoService cityTransportCapacityAnalysisInfoService;
    @Autowired
    BigdataTeamAnalysisInfoService bigdataTeamAnalysisInfoService;
    @Autowired
    BigdataZhygService bigdataZhygService;

    //ip地址和运营商对象的对应
    Map<String,BigdataBeidouComp> ip2GpsComp = new HashMap<String,BigdataBeidouComp>();
    @Autowired
    BigdataBeidouCompService beidouCompService;

    @Autowired
    BigdataAlarmRecordService bigdataAlarmRecordService;

    //客货危
    //@Scheduled(cron = "0 0/5 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisOperativeInfo.cron.initData}")
    public void initData(){
        //初始化话车辆类型集合
        List<String> carTypeList = new ArrayList<>();
        carTypeList.add("总");
        carTypeList.add("客运");
        carTypeList.add("普货");
        carTypeList.add("危货");
        for(int j=0;j<carTypeList.size();j++){
            updateCityAnalysisDay(carTypeList.get(j));
        }
    }

    public void updateCityAnalysisDay(String carType){
        //统计当日的数据
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dayIntStr = sdf.format(date);
        int dayInt = new Integer(dayIntStr);
        int monthInt = dayInt / 100;
        int yearInt = monthInt / 100;
        //获取所有的县区,统计县区
        List<SysXianqu> sysXianquList = carInfoService.getXianquList();
        for(SysXianqu xianqu:sysXianquList){
            String xianquId = xianqu.getId();
            //车辆总数
            int carSumNum = carInfoService.countCarSumNumByXianQuId(xianquId,carType,"","");
            //统计上线的车数
            int onlineNum = carInfoService.countCarSumNumByXianQuId(xianquId,carType,"1","");
            //计算上线率
            BigDecimal onlineRate = new BigDecimal("0");
            if(carSumNum>0){
                onlineRate = new BigDecimal(onlineNum).divide(new BigDecimal(carSumNum),2,BigDecimal.ROUND_HALF_UP);
            }
            //统计运营数
            int operationNum = carInfoService.countCarSumNumByXianQuId(xianquId,carType,"","1");
            //计算运营率
            BigDecimal operationRate = new BigDecimal("0");
            if(onlineNum>0){
                operationRate =  new BigDecimal(operationNum).divide(new BigDecimal(onlineNum),2,BigDecimal.ROUND_HALF_UP);
            }
            CityTransportCapacityAnalysisInfo cityTransportCapacityAnalysisInfo = new CityTransportCapacityAnalysisInfo();
            cityTransportCapacityAnalysisInfo.setProvinceId(xianqu.getProvinceId());
            cityTransportCapacityAnalysisInfo.setProvinceName(xianqu.getProvinceName());
            cityTransportCapacityAnalysisInfo.setCityId(xianqu.getCityId());
            cityTransportCapacityAnalysisInfo.setCityName(xianqu.getCityName());
            cityTransportCapacityAnalysisInfo.setXianquId(xianqu.getId());
            cityTransportCapacityAnalysisInfo.setXianquName(xianqu.getName());
            cityTransportCapacityAnalysisInfo.setCarNum(carSumNum);
            cityTransportCapacityAnalysisInfo.setOnlineCarNum(onlineNum);
            cityTransportCapacityAnalysisInfo.setOnlineRate(onlineRate);
            cityTransportCapacityAnalysisInfo.setOperationNum(operationNum);
            cityTransportCapacityAnalysisInfo.setOperationRate(operationRate);
            cityTransportCapacityAnalysisInfo.setCarType(carType);
            cityTransportCapacityAnalysisInfo.setCountType("XIANQU");
            cityTransportCapacityAnalysisInfo.setCountDate(dayInt);
            cityTransportCapacityAnalysisInfo.setCountMonth(monthInt);
            cityTransportCapacityAnalysisInfo.setYearNum(yearInt);
            cityTransportCapacityAnalysisInfoService.insertOrUpdate(cityTransportCapacityAnalysisInfo);
        }
        //统计城市
        String cityId = "130300";
        //车辆总数
        int carSumNum = carInfoService.countCarSumNumByCityId(cityId,carType,"","");
        //统计上线的车数
        int onlineNum = carInfoService.countCarSumNumByCityId(cityId,carType,"1","");
        //计算上线率
        BigDecimal onlineRate = new BigDecimal("0");
        if(carSumNum>0){
            onlineRate = new BigDecimal(onlineNum).divide(new BigDecimal(carSumNum),2,BigDecimal.ROUND_HALF_UP);
        }
        //统计运营数
        int operationNum = carInfoService.countCarSumNumByCityId(cityId,carType,"","1");
        //计算运营率
        BigDecimal operationRate = new BigDecimal("0");
        if(onlineNum>0){
            operationRate =  new BigDecimal(operationNum).divide(new BigDecimal(onlineNum),2,BigDecimal.ROUND_HALF_UP);
        }
        CityTransportCapacityAnalysisInfo cityTransportCapacityAnalysisInfo = new CityTransportCapacityAnalysisInfo();
        cityTransportCapacityAnalysisInfo.setProvinceId("HEBEI");
        cityTransportCapacityAnalysisInfo.setProvinceName("河北省");
        cityTransportCapacityAnalysisInfo.setCityId("130300");
        cityTransportCapacityAnalysisInfo.setCityName("秦皇岛市");
        cityTransportCapacityAnalysisInfo.setCarNum(carSumNum);
        cityTransportCapacityAnalysisInfo.setOnlineCarNum(onlineNum);
        cityTransportCapacityAnalysisInfo.setOnlineRate(onlineRate);
        cityTransportCapacityAnalysisInfo.setOperationNum(operationNum);
        cityTransportCapacityAnalysisInfo.setOperationRate(operationRate);
        cityTransportCapacityAnalysisInfo.setCarType(carType);
        cityTransportCapacityAnalysisInfo.setCountType("CITY");
        cityTransportCapacityAnalysisInfo.setCountDate(dayInt);
        cityTransportCapacityAnalysisInfo.setCountMonth(monthInt);
        cityTransportCapacityAnalysisInfo.setYearNum(yearInt);
        cityTransportCapacityAnalysisInfoService.insertOrUpdate(cityTransportCapacityAnalysisInfo);
    }


    //统计企业
    //@Scheduled(cron = "0 0/30 * * * ?")
    @Scheduled(cron = "${timetask.analysis.BigDataAnalysisOperativeInfo.cron.initTeamCount}")
    public void initTeamCount(){
        //统计当日的数据
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dayIntStr = sdf.format(date);
        int dayInt = new Integer(dayIntStr);
        int monthInt = dayInt / 100;
        int yearInt = monthInt / 100;
        //获取所有的企业的集合
        List<TransitCarTeam> teamList = bigdataZhygService.selectTeamList();
        for(TransitCarTeam team:teamList){
            String teamId = team.getId();
            //企业类型
            String companyLevel = team.getCompanyLevel();
            //统计智慧运管的车辆总数
            int zhygCarSumNum = bigdataZhygService.countCarSumByTeamId(teamId);
            //统计运营商
            String compName = carInfoService.getCompNameByTeamId(teamId);
            //车辆总数
            int carSumNum = carInfoService.countCarSumNumByTeamId(teamId,"","");
            //统计上线的车数
            int onlineNum = carInfoService.countCarSumNumByTeamId(teamId,"1","");
            //计算上线率
            BigDecimal onlineRate = new BigDecimal("0");
            if(carSumNum>0){
                onlineRate = new BigDecimal(onlineNum).divide(new BigDecimal(carSumNum),2,BigDecimal.ROUND_HALF_UP);
            }
            //统计运营数
            int operationNum = carInfoService.countCarSumNumByTeamId(teamId,"","1");
            //计算运营率
            BigDecimal operationRate = new BigDecimal("0");
            if(onlineNum>0){
                operationRate =  new BigDecimal(operationNum).divide(new BigDecimal(onlineNum),2,BigDecimal.ROUND_HALF_UP);
            }
            BigdataTeamAnalysisInfo bigdataTeamAnalysisInfo = new BigdataTeamAnalysisInfo();
            bigdataTeamAnalysisInfo.setProvinceId(team.getProvinceId());
            bigdataTeamAnalysisInfo.setProvinceName(team.getProvinceName());
            bigdataTeamAnalysisInfo.setCityId(team.getCityId());
            bigdataTeamAnalysisInfo.setCityName(team.getCityName());
            bigdataTeamAnalysisInfo.setXianquId(team.getXianquId());
            bigdataTeamAnalysisInfo.setXianquName(team.getXianquName());
            bigdataTeamAnalysisInfo.setTeamId(teamId);
            bigdataTeamAnalysisInfo.setTeamName(team.getTeamName());
            bigdataTeamAnalysisInfo.setTeamType(getTeamType(companyLevel));
            //企业分类（自有，挂靠）
            bigdataTeamAnalysisInfo.setTeamCls(team.getTeamType());
            bigdataTeamAnalysisInfo.setCompName(compName);
            bigdataTeamAnalysisInfo.setZhygCarNum(zhygCarSumNum);
            bigdataTeamAnalysisInfo.setCarNum(carSumNum);
            bigdataTeamAnalysisInfo.setOnlineCarNum(onlineNum);
            bigdataTeamAnalysisInfo.setOnlineRate(onlineRate);
            bigdataTeamAnalysisInfo.setOperationNum(operationNum);
            bigdataTeamAnalysisInfo.setOperationRate(operationRate);
            bigdataTeamAnalysisInfo.setCountDate(dayInt);
            bigdataTeamAnalysisInfo.setCountMonth(monthInt);
            bigdataTeamAnalysisInfo.setYearNum(yearInt);
            bigdataTeamAnalysisInfoService.insertOrUpdate(bigdataTeamAnalysisInfo);
        }
    }

    //获取企业类型
    public String getTeamType(String companyLevel){
        if(companyLevel!=null && !companyLevel.equals("")){
            if(companyLevel.equals("TEAM_KY")){
                return "客运";
            }
            if(companyLevel.equals("TEAM_WXHWYS")){
                return "危货";
            }
        }
        return "普货";
    }

    public void insertAlarmInfoVo(Get2gAlertAndCardInfoFromQueue.AlertInfo info) {

        String alarmType = info.getTYPE();
        if (!alarmType.equals("2") && !alarmType.equals("4")) {
            return;
        }
        //182.92.67.1:36152
        String serverInfo = info.getSERV_INFO();
        String carCode = info.getCAR_CODE();
        if (serverInfo != null && serverInfo.indexOf(":") >= 0 && carCode.indexOf("冀C")>=0) {
            String[] strArr = serverInfo.split(":");
            String ip = strArr[0];
            BigdataBeidouComp beidouComp = ip2GpsComp.get(ip);
            if (beidouComp == null) {
                beidouComp = beidouCompService.selectByIp809Addr(ip);
                ip2GpsComp.put(ip, beidouComp);
            }
            if (beidouComp != null) {
                BigdataAlarmRecord alarmRecord = info.formatToAlarm();
                alarmRecord.setCompName(beidouComp.getCompName());
                alarmRecord.setCompId(beidouComp.getId());
                //调用service方法插入
                bigdataAlarmRecordService.insertAcceptAlarmNew(alarmRecord);
            }
        }
    }
}
