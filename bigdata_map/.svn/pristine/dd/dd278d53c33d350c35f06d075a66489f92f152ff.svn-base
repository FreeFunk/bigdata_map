package com.edgedo.timetask.driver;

import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.drawing.entity.BigdataDriverStopCount;
import com.edgedo.bigdata.service.BigdataDriverCardInfoService;
import com.edgedo.drawing.service.BigdataDriverStopCountService;
import com.edgedo.drawing.service.BigdataDriverStopRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BigdataAnalysisDriverStopCount
 * @Description 统计司机的停车记录
 * @Author 床前明月光
 * @Date 2020/2/4 9:05
 **/
@ConditionalOnProperty(
        value = {"timetask.driver.BigdataAnalysisDriverStopCount.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisDriverStopCount {
    @Autowired
    BigdataDriverCardInfoService bigdataDriverCardInfoService;

    @Autowired
    BigdataDriverStopRecService bigdataDriverStopRecService;

    @Autowired
    BigdataDriverStopCountService bigdataDriverStopCountService;

    //@Scheduled(cron = "0 0 1 * * ?")
    @Scheduled(cron = "${timetask.driver.BigdataAnalysisDriverStopCount.cron.fenxiDriverStopCount}")
    public void fenxiDriverStopCount() {
        try {
            //0.确定统计时间
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
                        System.out.println(driverCardInfoList.size());
                        for (BigdataDriverCardInfo d:driverCardInfoList){
                            //统计司机的月停靠记录
                            List<BigdataDriverStopCount> driverStopCountList = bigdataDriverStopRecService.selectGroupCityIdById(d.getId(),monthInt);
                            for (BigdataDriverStopCount s:driverStopCountList){
                                s.setCountDate(dayInt);
                                s.setCountMonth(monthInt);
                                s.setYearNum(yearInt);
                                s.setCountType("MONTH");
                                bigdataDriverStopCountService.insertOrUpdateByCityId(s);
                            }
                            //统计司机的年停靠记录
                            List<BigdataDriverStopCount> driverStopCountList1 = bigdataDriverStopCountService.selectGroupCityIdById(d.getId(),yearInt);
                            for (BigdataDriverStopCount s:driverStopCountList1){
                                s.setCountDate(dayInt);
                                s.setCountMonth(monthInt);
                                s.setYearNum(yearInt);
                                s.setCountType("YEAR");
                                bigdataDriverStopCountService.insertOrUpdateByCityId(s);
                            }
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
