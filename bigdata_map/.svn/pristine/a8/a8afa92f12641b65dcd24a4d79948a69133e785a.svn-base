package com.edgedo.timetask.driver;

import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.drawing.entity.BigdataDriverCountMonthAndYear;
import com.edgedo.bigdata.service.BigdataDriverCardInfoService;
import com.edgedo.drawing.service.BigdataDriverChangeTeamRecService;
import com.edgedo.drawing.service.BigdataDriverCountMonthAndYearService;
import com.edgedo.drawing.entity.BigdataDriverDrawInfo;
import com.edgedo.drawing.service.BigdataDriverDrawInfoService;
import com.edgedo.drawing.service.BigdataDriverStopCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BigdataAnalysisDriverDrawInfo
 * @Description 司机画像分析
 * @Author 床前明月光
 * @Date 2020/2/5 14:58
 **/
@ConditionalOnProperty(
        value = {"timetask.driver.BigdataAnalysisDriverDrawInfo.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisDriverDrawInfo {

    @Autowired
    BigdataDriverCardInfoService bigdataDriverCardInfoService;
    @Autowired
    BigdataDriverCountMonthAndYearService bigdataDriverCountMonthAndYearService;
    @Autowired
    BigdataDriverStopCountService bigdataDriverStopCountService;
    @Autowired
    BigdataDriverDrawInfoService bigdataDriverDrawInfoService;
    @Autowired
    BigdataDriverChangeTeamRecService bigdataDriverChangeTeamRecService;

    //@Scheduled(cron = "0 30 5 * * ?")
    @Scheduled(cron = "${timetask.driver.BigdataAnalysisDriverDrawInfo.cron.fenxiDriverDrawInfo}")
    public void fenxiDriverDrawInfo() {
        //统计昨天的数据
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,-1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dayIntStr = sdf.format(date);
        int dayInt = new Integer(dayIntStr);
        int monthInt = dayInt / 100;
        int yearInt = monthInt / 100;
        int totalDriverNum = bigdataDriverCardInfoService.selectSortNum();
        int oneNum = 1000;
        int times = totalDriverNum / oneNum + (totalDriverNum % oneNum == 0 ? 0 : 1);
        //多线程遍历数据库
        for (int i = 0; i < times; i++) {
            final int fiIndex = i;
            Thread t = new Thread() {
                int start = oneNum * fiIndex;
                int end = oneNum * (fiIndex + 1) - 1;
                @Override
                public void run() {
                    List<BigdataDriverCardInfo> driverCardInfoList = bigdataDriverCardInfoService.listByStartAndEndBySortNum(start,end);
                    for(BigdataDriverCardInfo d:driverCardInfoList){
                        BigdataDriverDrawInfo bigdataDriverDrawInfo = new BigdataDriverDrawInfo();
                        bigdataDriverDrawInfo.setId(d.getId()+"-"+yearInt);
                        bigdataDriverDrawInfo.setCompId(d.getCompId());
                        bigdataDriverDrawInfo.setCompName(d.getCompName());
                        bigdataDriverDrawInfo.setTeamId(d.getTeamId());
                        bigdataDriverDrawInfo.setTeamName(d.getTeamName());
                        bigdataDriverDrawInfo.setProvinceId(d.getProvinceId());
                        bigdataDriverDrawInfo.setProvinceName(d.getProvinceName());
                        bigdataDriverDrawInfo.setCityId(d.getCityId());
                        bigdataDriverDrawInfo.setCityName(d.getCityName());
                        bigdataDriverDrawInfo.setXianquId(d.getXianquId());
                        bigdataDriverDrawInfo.setXianquName(d.getXianquName());
                        bigdataDriverDrawInfo.setDriverId(d.getId());
                        bigdataDriverDrawInfo.setDriverAge(d.getDriverAge());
                        bigdataDriverDrawInfo.setDriverCarType(d.getCarType());
                        bigdataDriverDrawInfo.setDriverCode(d.getDriverCode());
                        bigdataDriverDrawInfo.setDriverEntryDay(d.getDriverEntryDay());
                        bigdataDriverDrawInfo.setDriverIdCard(d.getDriverIdCard());
                        bigdataDriverDrawInfo.setDriverLicenceNum(d.getDriverLicenceNum());
                        bigdataDriverDrawInfo.setDriverLicenceType(d.getDriverLicenceType());
                        bigdataDriverDrawInfo.setDriverName(d.getDriverName());
                        bigdataDriverDrawInfo.setDriverPhone(d.getDriverPhone());
                        bigdataDriverDrawInfo.setDriverPhotoUrl(d.getDriverPhotoUrl());
                        bigdataDriverDrawInfo.setDriverSex(d.getDriverSex());
                        bigdataDriverDrawInfo.setCarPlateNum(d.getCarPlateNum());
                        bigdataDriverDrawInfo.setCarPlateColor(d.getCarPlateColor());
                        bigdataDriverDrawInfo.setCarPlateColorText(d.getCarPlateColorText());
                        bigdataDriverDrawInfo.setCarFrameNum(d.getCarFrameNum());
                        bigdataDriverDrawInfo.setCarType(d.getCarType());
                        bigdataDriverDrawInfo.setBindTime(d.getCarBindTime());
                        bigdataDriverDrawInfo.setIsRealState(d.getIsRealState());
                        bigdataDriverDrawInfo.setSafeLevel(d.getSafeLevel());
                        bigdataDriverDrawInfo.setSinState(d.getSinState());
                        //查询司机的年统计
                        BigdataDriverCountMonthAndYear bigdataDriverCountMonthAndYear = bigdataDriverCountMonthAndYearService.selectByVo(d.getId(),yearInt);
                        if(bigdataDriverCountMonthAndYear!=null){
                            //行驶时长
                            bigdataDriverDrawInfo.setYearRunTimeLength(bigdataDriverCountMonthAndYear.getSumRunTimeLength());
                            bigdataDriverDrawInfo.setDangerRunTimeLength(bigdataDriverCountMonthAndYear.getDangerRunTimeLength());
                            bigdataDriverDrawInfo.setDayRunTimeLength(bigdataDriverCountMonthAndYear.getDayRunTimeLength());
                            bigdataDriverDrawInfo.setNightRunTimeLength(bigdataDriverCountMonthAndYear.getNightRunTimeLength());
                            //行驶里程
                            bigdataDriverDrawInfo.setYearRunMileage(bigdataDriverCountMonthAndYear.getSumMileage());
                            bigdataDriverDrawInfo.setDangerRunMileage(bigdataDriverCountMonthAndYear.getDangerRunMileage());
                            bigdataDriverDrawInfo.setDayRunMileage(bigdataDriverCountMonthAndYear.getDayRunMileage());
                            bigdataDriverDrawInfo.setNightRunMileage(bigdataDriverCountMonthAndYear.getNightRunMileage());
                            //行驶速度
                            bigdataDriverDrawInfo.setAverageSpeed(bigdataDriverCountMonthAndYear.getAverageSpeed());
                            bigdataDriverDrawInfo.setHighestSpeed(bigdataDriverCountMonthAndYear.getHighestSpeed());
                            bigdataDriverDrawInfo.setDangerRunAverageSpeed(bigdataDriverCountMonthAndYear.getDangerRunAverageSpeed());
                            bigdataDriverDrawInfo.setDayRunAverageSpeed(bigdataDriverCountMonthAndYear.getDayRunAverageSpeed());
                            bigdataDriverDrawInfo.setNightRunAverageSpeed(bigdataDriverCountMonthAndYear.getNightRunAverageSpeed());
                            //报警次数
                            bigdataDriverDrawInfo.setOverspeedNum(bigdataDriverCountMonthAndYear.getOverspeedNum());
                            bigdataDriverDrawInfo.setSeriousOverspeedNum(bigdataDriverCountMonthAndYear.getSeriousOverspeedNum());
                            bigdataDriverDrawInfo.setTiredNum(bigdataDriverCountMonthAndYear.getTiredNum());
                            bigdataDriverDrawInfo.setSeriousTiredNum(bigdataDriverCountMonthAndYear.getSeriousTiredNum());
                            bigdataDriverDrawInfo.setSafetyWarningNum(bigdataDriverCountMonthAndYear.getSafetyWarningNum());
                            //安全学习次数
                            bigdataDriverDrawInfo.setSafetrainNum(bigdataDriverCountMonthAndYear.getSafetrainNum());
                            //报警系数
                            bigdataDriverDrawInfo.setWarningRate(bigdataDriverCountMonthAndYear.getWarningRate());
                        }else {
                            //行驶时长
                            bigdataDriverDrawInfo.setYearRunTimeLength(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setDangerRunTimeLength(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setDayRunTimeLength(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setNightRunTimeLength(new BigDecimal("0"));
                            //行驶里程
                            bigdataDriverDrawInfo.setYearRunMileage(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setDangerRunMileage(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setDayRunMileage(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setNightRunMileage(new BigDecimal("0"));
                            //行驶速度
                            bigdataDriverDrawInfo.setAverageSpeed(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setHighestSpeed(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setDangerRunAverageSpeed(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setDayRunAverageSpeed(new BigDecimal("0"));
                            bigdataDriverDrawInfo.setNightRunAverageSpeed(new BigDecimal("0"));
                            //报警次数
                            bigdataDriverDrawInfo.setOverspeedNum(0);
                            bigdataDriverDrawInfo.setSeriousOverspeedNum(0);
                            bigdataDriverDrawInfo.setTiredNum(0);
                            bigdataDriverDrawInfo.setSeriousTiredNum(0);
                            bigdataDriverDrawInfo.setSafetyWarningNum(0);
                            //安全学习次数
                            bigdataDriverDrawInfo.setSafetrainNum(0);
                            //报警系数
                            bigdataDriverDrawInfo.setWarningRate(new BigDecimal("0"));
                        }
                        //常去城市统计(常去城市前三名)
                        String stopCitys = bigdataDriverStopCountService.listTopThree(d.getId(),yearInt);
                        bigdataDriverDrawInfo.setStopCity(stopCitys);
                        //本地从业情况
                        String empDesc = bigdataDriverChangeTeamRecService.isChangeTeam(d.getId(),yearInt);
                        bigdataDriverDrawInfo.setEmpDesc(empDesc);
                        //驾驶行为分析
                        BigDecimal warningRate = bigdataDriverDrawInfo.getWarningRate();
                        bigdataDriverDrawInfo.setDrivingDesc("百公里报警系数"+warningRate+"，驾驶习惯良好，稳健型驾驶员。");
                        //安全生产情况
                        String safetyDesc =  bigdataDriverDrawInfoService.countSafeFile(d.getId(),yearInt);
                        bigdataDriverDrawInfo.setSafetyDesc(safetyDesc);
                        //初始化描述
                        bigdataDriverDrawInfo.setRunMileageDesc("行驶里程正常");
                        bigdataDriverDrawInfo.setRunTimeLengthDesc("行驶时长正常");
                        bigdataDriverDrawInfo.setRunSpeedDesc("稳健型驾驶员");
                        bigdataDriverDrawInfo.setStopCityDesc("");
                        bigdataDriverDrawInfo.setAlarmDesc("驾驶习惯良好");
                        bigdataDriverDrawInfo.setSinDesc("");
                        bigdataDriverDrawInfo.setSinState("0");
                      /*  bigdataDriverDrawInfo.setCountDate(dayInt);
                        bigdataDriverDrawInfo.setCountMonth(monthInt);*/
                        bigdataDriverDrawInfo.setYearNum(yearInt);
                        bigdataDriverDrawInfoService.insertOrUpdate(bigdataDriverDrawInfo);
                    }
                }
            };
            t.start();
        }
    }
}
