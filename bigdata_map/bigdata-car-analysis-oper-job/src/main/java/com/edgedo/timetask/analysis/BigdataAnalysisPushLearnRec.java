package com.edgedo.timetask.analysis;

import com.edgedo.bigdata.entity.BigdataAlarmRecord;
import com.edgedo.bigdata.entity.BigdataPushLearnRec;
import com.edgedo.bigdata.entity.YwTrainLession;
import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.bigdata.service.BigdataPushLearnRecService;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *@Author:ZhaoSiDa
 *@Description: 分析司机的定向推送记录
 *@DateTime: 2020/4/16 17:17
 */

@ConditionalOnProperty(
        value = {"timetask.analysis.BigdataAnalysisPushLearnRec.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataAnalysisPushLearnRec {

    @Autowired
    BigdataPushLearnRecService bigdataPushLearnRecService;
    @Autowired
    BigdataAlarmRecordService bigdataAlarmRecordService;
    SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");

    public void initData(){
    /*    Date cur = new Date();
        String startDateStr = "20200201";
        try {
            Date startDate = sdfDateInt.parse(startDateStr);
            for(int i =0;i<3;i++){
                fenxiPushLearnRecOverspeed(startDate);
                fenxiPushLearnRecPilao(startDate);
                startDate = DateUtil.getNextMonthDate(startDate);
                System.out.println(sdfDateInt.format(startDate));
            }
            System.out.println("结束======");
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }

    //分析超速的定向课件
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisPushLearnRec.cron.fenxiPushLearnRecOverspeed}")
    public void fenxiPushLearnRecOverspeed(){
        Date date = new Date();
        String dateIntStr = sdfDateInt.format(date);
        int countDate = new Integer(dateIntStr);
        int countMonth = countDate/100;
        int yearNum =countMonth/100;

        Date lastMonthDate = DateUtil.getLastMonthDate(date);
        String lastMonthDateStr = sdfDateInt.format(lastMonthDate);
        int lastCountDate = new Integer(lastMonthDateStr);
        int lastCountMonth = lastCountDate/100;
        //查询超速的报警
        List<BigdataAlarmRecord> overSpeedAlarmList = bigdataAlarmRecordService.selectGroupEmpId(lastCountMonth,"2");
        for(BigdataAlarmRecord b:overSpeedAlarmList){
            String empId = b.getEmpId();
            String empCode = b.getEmpCode();
            BigdataPushLearnRec bigdataPushLearnRec = new BigdataPushLearnRec();
            bigdataPushLearnRec.setEmpId(empId);
            bigdataPushLearnRec.setEmpCode(empCode);
            bigdataPushLearnRec.setAlarmType("超速");
            //随机获取超速课件
            YwTrainLession ywTrainLession = bigdataPushLearnRecService.getLessionByClsId("2333c3ec2c184bac9a029b50b21a103a");
            bigdataPushLearnRec.setLessionId(ywTrainLession.getId());
            bigdataPushLearnRec.setLessonName(ywTrainLession.getLessonTitle());
            bigdataPushLearnRec.setCreateTime(new Date());
            bigdataPushLearnRec.setCountDate(countDate);
            bigdataPushLearnRec.setCountMonth(countMonth);
            bigdataPushLearnRec.setYearNum(yearNum);
            //统计学习的课时数
            int count = bigdataPushLearnRecService.countSafetyRec(empCode,countMonth);
            if(count>1){
                bigdataPushLearnRec.setStudyState("已学习");
            }else {
                bigdataPushLearnRec.setStudyState("未学习");
            }
            //新增或修改
            bigdataPushLearnRecService.insertOrUpdate(bigdataPushLearnRec);
        }
    }

    //分析疲劳的定向课件
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisPushLearnRec.cron.fenxiPushLearnRecPilao}")
    public void fenxiPushLearnRecPilao(){
        Date date = new Date();
        String dateIntStr = sdfDateInt.format(date);
        int countDate = new Integer(dateIntStr);
        int countMonth = countDate/100;
        int yearNum =countMonth/100;
        Date lastMonthDate = DateUtil.getLastMonthDate(date);
        String lastMonthDateStr = sdfDateInt.format(lastMonthDate);
        int lastCountDate = new Integer(lastMonthDateStr);
        int lastCountMonth = lastCountDate/100;
        //查询疲劳的报警
        List<BigdataAlarmRecord> pilaoAlarmList = bigdataAlarmRecordService.selectGroupEmpId(lastCountMonth,"4");
        for(BigdataAlarmRecord b:pilaoAlarmList){
            String empId = b.getEmpId();
            String empCode = b.getEmpCode();
            BigdataPushLearnRec bigdataPushLearnRec = new BigdataPushLearnRec();
            bigdataPushLearnRec.setEmpId(empId);
            bigdataPushLearnRec.setEmpCode(empCode);
            bigdataPushLearnRec.setAlarmType("疲劳");
            //随机获取超速课件
            YwTrainLession ywTrainLession = bigdataPushLearnRecService.getLessionByClsId("6805177d5e8e48afb8308fa1b54bf5eb");
            bigdataPushLearnRec.setLessionId(ywTrainLession.getId());
            bigdataPushLearnRec.setLessonName(ywTrainLession.getLessonTitle());
            bigdataPushLearnRec.setCreateTime(new Date());
            bigdataPushLearnRec.setCountDate(countDate);
            bigdataPushLearnRec.setCountMonth(countMonth);
            bigdataPushLearnRec.setYearNum(yearNum);
            int count = bigdataPushLearnRecService.countSafetyRec(empCode,countMonth);
            if(count>1){
                bigdataPushLearnRec.setStudyState("已学习");
            }else {
                bigdataPushLearnRec.setStudyState("未学习");
            }
            bigdataPushLearnRecService.insertOrUpdate(bigdataPushLearnRec);
        }
    }

    //查询从业人员是否已经完成学习
    @Scheduled(cron = "${timetask.analysis.BigdataAnalysisPushLearnRec.cron.fenxiEmpPushLearnRec}")
    public void fenxiEmpPushLearnRec(){
        Date date = new Date();
        String dateIntStr = sdfDateInt.format(date);
        int countDate = new Integer(dateIntStr);
        int countMonth = countDate/100;
        int yearNum =countMonth/100;
        List<BigdataPushLearnRec> bigdataPushLearnRecList = bigdataPushLearnRecService.selectUnLearnRec(yearNum);
        for(BigdataPushLearnRec b:bigdataPushLearnRecList){
            String empCode = b.getEmpCode();
            int countMonth1 =  b.getCountMonth();
            int count = bigdataPushLearnRecService.countSafetyRec(empCode,countMonth1);
            if(count>1){
                b.setStudyState("已学习");
            }else {
                b.setStudyState("未学习");
            }
            bigdataPushLearnRecService.insertOrUpdate(b);
        }
        //查询
        Date lastYearDate = DateUtil.getLastYearDate(date);
        String lastYearDateIntStr = sdfDateInt.format(lastYearDate);
        int countLastDate = new Integer(lastYearDateIntStr);
        int countLastMonth = countLastDate/100;
        int lastYearNum =countLastMonth/100;
        List<BigdataPushLearnRec> bigdataPushLearnRecList1 = bigdataPushLearnRecService.selectUnLearnRec(lastYearNum);
        for(BigdataPushLearnRec b:bigdataPushLearnRecList1){
            String empCode = b.getEmpCode();
            int countMonth1 =  b.getCountMonth();
            int count = bigdataPushLearnRecService.countSafetyRec(empCode,countMonth1);
            if(count>1){
                b.setStudyState("已学习");
            }else {
                b.setStudyState("未学习");
            }
            bigdataPushLearnRecService.insertOrUpdate(b);
        }
    }
}
