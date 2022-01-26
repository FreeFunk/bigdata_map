package com.edgedo.timetask;

import com.edgedo.bigdata.entity.BigdataBeidouMonthCheckSum;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompMonthCheckView;
import com.edgedo.bigdata.service.BigdataBeidouCompMonthCheckService;
import com.edgedo.bigdata.service.BigdataBeidouMonthCheckSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName BigdataBeidouMonthCheckSumAnalysis
 * @Description 北斗月度接入汇总统计
 * @Author 床前明月光
 * @Date 2019/8/20 9:12
 **/
@Component
public class BigdataBeidouMonthCheckSumAnalysis {

    @Autowired
    BigdataBeidouCompMonthCheckService bigdataBeidouCompMonthCheckService;
    @Autowired
    BigdataBeidouMonthCheckSumService bigdataBeidouMonthCheckSumService;

    //北斗月度接入汇总统计
    @Scheduled(cron = "0 0/5 * * * ?")
    public void countBeidouCheckSum(){
        SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        Date countDate = calendar.getTime();
        String countDateStr = sdfDateInt.format(countDate);
        Map<String,Object> map = new HashMap<>();
        map.put("countMonth",Integer.valueOf(countDateStr)/100);
        List<BigdataBeidouCompMonthCheckView> bigdataBeidouCompMonthCheckViewList = bigdataBeidouCompMonthCheckService.listBySearchDate(map);
        BigDecimal countCompSum = new BigDecimal(bigdataBeidouCompMonthCheckViewList.size());
        //上线率
        BigDecimal onlineRateSum = new BigDecimal("0");
        //联通率
        BigDecimal linkRateSum = new BigDecimal("0");
        //轨迹完整率
        BigDecimal traceCompleteRateSum = new BigDecimal("0");
        //数据合格率
        BigDecimal dataQualifiedRateSum = new BigDecimal("0");
        //司机卡上传率
        BigDecimal driverCardUploadRateSum = new BigDecimal("0");
        //司机卡准确率
        BigDecimal driverCardQualifiedRateSum = new BigDecimal("0");
        //分段限速报警率
        BigDecimal speedAlarmQualifiedRateSum = new BigDecimal("0");
        //车辆漂移率
        BigDecimal traceFlyRateSum = new BigDecimal("0");
        //回传间隔合格率
        BigDecimal gpsUploadTimeQualifiedRateSum = new BigDecimal("0");
        //得分
        BigDecimal scoreSum = new BigDecimal("0");
        for(BigdataBeidouCompMonthCheckView b:bigdataBeidouCompMonthCheckViewList){
            //得分
            BigDecimal score = b.getScore();
            scoreSum = scoreSum.add(score);
            //上线率
            BigDecimal onlineRate = b.getOnlineRate();
            onlineRateSum = onlineRateSum.add(onlineRate);
            //联通率
            BigDecimal linkRate = b.getLinkRate();
            linkRateSum = linkRateSum.add(linkRate);
            //轨迹完整率
            BigDecimal traceCompleteRate = b.getTraceCompleteRate();
            traceCompleteRateSum = traceCompleteRateSum.add(traceCompleteRate);
            //数据合格率
            BigDecimal dataQualifiedRate = b.getDataQualifiedRate();
            if(dataQualifiedRate==null){
                dataQualifiedRate = new BigDecimal("0");
            }
            dataQualifiedRateSum = dataQualifiedRateSum.add(dataQualifiedRate);
            //司机卡上传率
            BigDecimal driverCardUploadRate = b.getDriverCardUploadRate();
            driverCardUploadRateSum = driverCardUploadRateSum.add(driverCardUploadRate);
            //司机卡准确率
            BigDecimal driverCardQualifiedRate = b.getDriverCardQualifiedRate();
            driverCardQualifiedRateSum = driverCardQualifiedRateSum.add(driverCardQualifiedRate);
            //分段限速报警率
            BigDecimal speedAlarmQualifiedRate = b.getSpeedAlarmQualifiedRate();
            speedAlarmQualifiedRateSum = speedAlarmQualifiedRateSum.add(speedAlarmQualifiedRate);
            //车辆漂移率
            BigDecimal traceFlyRate = b.getTraceFlyRate();
            traceFlyRateSum = traceFlyRateSum.add(traceFlyRate);
            //回传间隔合格率
            BigDecimal gpsUploadTimeQualifiedRate = b.getGpsUploadTimeQualifiedRate();
            gpsUploadTimeQualifiedRateSum = gpsUploadTimeQualifiedRateSum.add(gpsUploadTimeQualifiedRate);
        }
        //
        BigdataBeidouMonthCheckSum bigdataBeidouMonthCheckSum = new BigdataBeidouMonthCheckSum();
        //计算得分
        BigDecimal score = scoreSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //计算上传率
        BigDecimal onlineRate = onlineRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //计算联通率
        BigDecimal linkRate = linkRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //轨迹完整率
        BigDecimal traceCompleteRate = traceCompleteRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //数据合格率
        BigDecimal dataQualifiedRate = dataQualifiedRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //司机卡上传率
        BigDecimal driverCardUploadRate = driverCardUploadRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //司机卡准确率
        BigDecimal driverCardQualifiedRate = driverCardQualifiedRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //分段限速报警率
        BigDecimal speedAlarmQualifiedRate = speedAlarmQualifiedRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //车辆漂移率
        BigDecimal traceFlyRate = traceFlyRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        //回传间隔合格率
        BigDecimal gpsUploadTimeQualifiedRate = gpsUploadTimeQualifiedRateSum.divide(countCompSum,2,BigDecimal.ROUND_HALF_UP);
        bigdataBeidouMonthCheckSum.setScore(score);
        bigdataBeidouMonthCheckSum.setOnlineRate(onlineRate);
        bigdataBeidouMonthCheckSum.setLinkRate(linkRate);
        bigdataBeidouMonthCheckSum.setTraceCompleteRate(traceCompleteRate);
        bigdataBeidouMonthCheckSum.setDataQualifiedRate(dataQualifiedRate);
        bigdataBeidouMonthCheckSum.setDriverCardUploadRate(driverCardUploadRate);
        bigdataBeidouMonthCheckSum.setDriverCardQualifiedRate(driverCardQualifiedRate);
        bigdataBeidouMonthCheckSum.setSpeedAlarmQualifiedRate(speedAlarmQualifiedRate);
        bigdataBeidouMonthCheckSum.setTraceFlyRate(traceFlyRate);
        bigdataBeidouMonthCheckSum.setGpsUploadTimeQualifiedRate(gpsUploadTimeQualifiedRate);
        bigdataBeidouMonthCheckSum.setCreateTime(new Date());
        bigdataBeidouMonthCheckSum.setUpdateTime(new Date());
        bigdataBeidouMonthCheckSum.setCountMonth(Integer.valueOf(countDateStr)/100);
        bigdataBeidouMonthCheckSum.setYearNum(Integer.valueOf(countDateStr)/10000);

        bigdataBeidouMonthCheckSumService.insertOrUpdate(bigdataBeidouMonthCheckSum);
    }
}
