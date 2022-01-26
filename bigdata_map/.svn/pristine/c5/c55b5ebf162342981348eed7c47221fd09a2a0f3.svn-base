package com.edgedo.timetask.driver;


import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.bigdata.service.BigdataSafetyWarningService;
import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.drawing.entity.BigdataDriverCountDay;
import com.edgedo.bigdata.service.BigdataDriverCardInfoService;
import com.edgedo.drawing.service.BigdataDriverCountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BigdataAnalysisDriverAlarm
 * @Description 分析司机的报警情况
 * @Author 床前明月光
 * @Date 2020/2/4 14:34
 **/
@ConditionalOnProperty(
        value = {"timetask.driver.BigdataAnalysisDriverAlarm.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisDriverAlarm {

    @Autowired
    BigdataDriverCardInfoService bigdataDriverCardInfoService;
    @Autowired
    BigdataAlarmRecordService bigdataAlarmRecordService;
    @Autowired
    BigdataSafetyWarningService bigdataSafetyWarningService;
    @Autowired
    BigdataDriverCountDayService bigdataDriverCountDayService;

    //@Scheduled(cron = "0 0 2 * * ?")
    @Scheduled(cron = "${timetask.driver.BigdataAnalysisDriverAlarm.cron.fenxiDriverAlarmCount}")
    public void fenxiDriverAlarmCount() {
        try {
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
                            BigdataDriverCountDay bigdataDriverCountDay = new BigdataDriverCountDay();
                            //统计司机的报警情况
                            //统计当日超速报警的次数
                            int countOverSpeedNum = bigdataAlarmRecordService.countOverSpeedNum(d.getId(),dayInt);
                            //统计当日严重超速的次数
                            int countSeriousOverSpeedNum = bigdataAlarmRecordService.countSeriousOverSpeedNum(d.getId(),dayInt);
                            //统计当日疲劳报警次数
                            int countFatigueNum = bigdataAlarmRecordService.countFatigueNum(d.getId(),dayInt);
                            // 统计当日严重疲劳的次数
                            int countSeriousFatigueNum = 0;
                            if(countFatigueNum>30){
                                countSeriousFatigueNum = 1;
                            }
                            //统计主动安全报警次数
                            int countSafetyNum = bigdataSafetyWarningService.countSafetyNum(d.getId(),dayInt);

                            bigdataDriverCountDay.setId(d.getId()+"-"+dayInt);
                            bigdataDriverCountDay.setDriverId(d.getId());
                            bigdataDriverCountDay.setDriverAge(d.getDriverAge());
                            bigdataDriverCountDay.setDriverCode(d.getDriverCode());
                            bigdataDriverCountDay.setDriverIdCard(d.getDriverIdCard());
                            bigdataDriverCountDay.setDriverName(d.getDriverName());
                            bigdataDriverCountDay.setDriverPhone(d.getDriverPhone());
                            bigdataDriverCountDay.setDriverSex(d.getDriverSex());
                            bigdataDriverCountDay.setTeamId(d.getTeamId());
                            bigdataDriverCountDay.setTeamName(d.getTeamName());
                            bigdataDriverCountDay.setCompId(d.getCompId());
                            bigdataDriverCountDay.setCompName(d.getCompName());
                            bigdataDriverCountDay.setProvinceId(d.getProvinceId());
                            bigdataDriverCountDay.setProvinceName(d.getProvinceName());
                            bigdataDriverCountDay.setCityId(d.getCityId());
                            bigdataDriverCountDay.setCityName(d.getCityName());
                            bigdataDriverCountDay.setXianquId(d.getXianquId());
                            bigdataDriverCountDay.setXianquName(d.getXianquName());
                            bigdataDriverCountDay.setOverspeedNum(countOverSpeedNum);
                            bigdataDriverCountDay.setSeriousOverspeedNum(countSeriousOverSpeedNum);
                            bigdataDriverCountDay.setTiredNum(countFatigueNum);
                            bigdataDriverCountDay.setSeriousTiredNum(countSeriousFatigueNum);
                            bigdataDriverCountDay.setSafetyWarningNum(countSafetyNum);
                            bigdataDriverCountDay.setCountDate(dayInt);
                            bigdataDriverCountDay.setCountMonth(monthInt);
                            bigdataDriverCountDay.setYearNum(yearInt);
                            bigdataDriverCountDayService.insertOrUpdate(bigdataDriverCountDay);
                        }
                    }
                };
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
