package com.edgedo.timetask.analysis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.BigdataMonthEmpAlarmSum;
import com.edgedo.bigdata.entity.Employee;
import com.edgedo.bigdata.service.BigdataMonthEmpAlarmSumService;
import com.edgedo.bigdata.service.BigdataTimeCarDayRecService;
import com.edgedo.common.util.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@ConditionalOnProperty(
        value = {"timetask.analysis.BigdataEmpAlarmAnalysisToTrainLession.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataEmpAlarmAnalysisToTrainLession {

    @Value("${bigdata.cityId}")
    String appCityId;
    @Value("${ReportDataUrl}")
    private String ReportDataUrl;
    @Autowired
    private BigdataTimeCarDayRecService timeCarDayRecService;
    @Autowired
    private BigdataMonthEmpAlarmSumService monthEmpAlarmSumService;

    private SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyyMM");
    private SimpleDateFormat sdfMonthStr = new SimpleDateFormat("yyyy年MM月");


    //    //下次批次
    public static int nextBatchNum = 0;
    //    //上次批次
    public static int lastBatchNum = -1;
    //统计从业人员的月度报警情况 每月1号凌晨1点开整
    //@Scheduled(cron = "0 * * 1 * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataEmpAlarmAnalysisToTrainLession.cron.updateSumEmpMonthAlarm}")
    public void updateSumEmpMonthAlarm(){
        if(lastBatchNum>=nextBatchNum){
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-1);
        Date cur = cal.getTime();
        long begin = System.currentTimeMillis();

        lastBatchNum++;

        int limit = 200;
        int start = nextBatchNum * limit;
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",appCityId);
        param.put("start",start);
        param.put("limit",limit);
        String url = ReportDataUrl + "/sys/emp/selectEmpByStartAndLimit.jsn";
        String res = HttpRequestUtil.postRequest(url,param);
        JSONObject jsonObj = JSONObject.parseObject(res);
        String success = jsonObj.get("success")+"";
        if(success==null || !success.equals("true")){
            nextBatchNum = 0;
            lastBatchNum = -1;
            return;
        }
        String data = jsonObj.get("data")+"";
        List<Employee> empList = JSONArray.parseArray(data,Employee.class);
        //按顺序查询从业人员
        if (empList.size() == 0) {
            nextBatchNum = 0;
            lastBatchNum = -1;
            return;
        }

        String monthStr = sdfMonth.format(cur);

        Integer monthInt = new Integer(monthStr);
        int year = monthInt / 100;
        for (Employee emp : empList) {
            try {
                //某个月的统计
                List<BigdataMonthEmpAlarmSum> groupList =
                        timeCarDayRecService.selectGroupSumInfoForEmpAlarm(monthInt,emp.getId());
                for(BigdataMonthEmpAlarmSum empAlarmSum : groupList){
                    String id = emp.getId() + empAlarmSum.getCarPlateNum() +
                            "-" +empAlarmSum.getCarPlateColor()
                            + monthStr;
                    BigdataMonthEmpAlarmSum dbEmpAlarmSum = monthEmpAlarmSumService.loadById(id);
                    if(dbEmpAlarmSum != null){
                        continue;
                    }
                    Integer overSpeedNum = empAlarmSum.getOverSpeedNum();
                    Integer seriousOverSpeedNum = empAlarmSum.getSeriousOverSpeedNum();
                    Integer fatiguedNum = empAlarmSum.getFatiguedNum();
                    Integer seriousFatiguedNum = empAlarmSum.getSeriousFatiguedNum();
                    if(
                            (overSpeedNum == null &&
                                    seriousOverSpeedNum == null &&
                                    fatiguedNum == null &&
                                    seriousFatiguedNum == null)||
                                    (overSpeedNum == 0 &&
                                            seriousOverSpeedNum == 0 &&
                                            fatiguedNum == 0 &&
                                            seriousFatiguedNum == 0)
                            ){
                        continue;
                    }

                    dbEmpAlarmSum = empAlarmSum;
                    dbEmpAlarmSum.setId(id);
                    dbEmpAlarmSum.setCreateTime(new Date());
                    dbEmpAlarmSum.setEmpId(emp.getId());
                    dbEmpAlarmSum.setEmpCode(emp.getLicenceCode());
                    dbEmpAlarmSum.setEmpName(emp.getEmpName());
                    dbEmpAlarmSum.setEmpPhone(emp.getEmpPhone());
                    dbEmpAlarmSum.setCountMonth(monthInt);
                    dbEmpAlarmSum.setYearNum(year);
                    dbEmpAlarmSum.setStatus("0");
                    monthEmpAlarmSumService.insert(dbEmpAlarmSum);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        nextBatchNum++;
        long endtime = System.currentTimeMillis();

        System.out.println("batchNum="+nextBatchNum+" | data time:" + (endtime-begin)  + "mils");

    }


    //    //下次批次
    public static int nextBatchNum_1 = 0;
    //    //上次批次
    public static int lastBatchNum_1 = -1;
    //发送安全学习小程序的站内信提醒 每月2号凌晨开整
    //@Scheduled(cron = "0 * * 2 * ?")
    @Scheduled(cron = "${timetask.analysis.BigdataEmpAlarmAnalysisToTrainLession.cron.sendTrainSiteMsgOfAlarmEmp}")
    public void sendTrainSiteMsgOfAlarmEmp(){
        if(lastBatchNum_1 >= nextBatchNum_1){
            return;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH,-1);
        Date cur = cal.getTime();
        long begin = System.currentTimeMillis();

        lastBatchNum_1++;

        int limit = 200;
        int start = nextBatchNum_1 * limit;
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",appCityId);
        param.put("start",start);
        param.put("limit",limit);
        String url = ReportDataUrl + "/sys/emp/selectEmpByStartAndLimit.jsn";
        String res = HttpRequestUtil.postRequest(url,param);
        JSONObject jsonObj = JSONObject.parseObject(res);
        String success = jsonObj.get("success")+"";
        if(success==null || !success.equals("true")){
            nextBatchNum_1 = 0;
            lastBatchNum_1 = -1;
            return;
        }
        String data = jsonObj.get("data")+"";
        List<Employee> empList = JSONArray.parseArray(data,Employee.class);
        //按顺序查询从业人员
        if (empList.size() == 0) {
            nextBatchNum_1 = 0;
            lastBatchNum_1 = -1;
            return;
        }

        String monthStr = sdfMonth.format(cur);
        String monthYearMonth = sdfMonthStr.format(cur);
        Integer monthInt = new Integer(monthStr);
        int year = monthInt / 100;
        for (Employee emp : empList) {
            try {
                List<BigdataMonthEmpAlarmSum> monthEmpAlarmSumList =  monthEmpAlarmSumService.listEmpAlarmSumOfMonth(emp.getId(),monthInt);
                String siteMsg = "";
                boolean isOverSpeed = false;
                boolean isFatigued = false;
                Integer overSpeedNumSum = 0;
                Integer seriousOverSpeedNumSum = 0;
                Integer fatiguedNumSum = 0;
                Integer seriousFatiguedNumSum = 0;
                //发送站内信
                for(BigdataMonthEmpAlarmSum empAlarmSum : monthEmpAlarmSumList){
                    String temMsg = "";
                    String status = empAlarmSum.getStatus();
                    if(status!=null && status.equals("1")){
                        continue;
                    }
                    String carPlateNum = empAlarmSum.getCarPlateNum();
                    Integer overSpeedNum = empAlarmSum.getOverSpeedNum();
                    overSpeedNumSum += overSpeedNum;
                    Integer seriousOverSpeedNum = empAlarmSum.getSeriousOverSpeedNum();
                    seriousOverSpeedNumSum += seriousOverSpeedNum;
                    Integer fatiguedNum = empAlarmSum.getFatiguedNum();
                    fatiguedNumSum += fatiguedNum;
                    Integer seriousFatiguedNum = empAlarmSum.getSeriousFatiguedNum();
                    seriousFatiguedNumSum += seriousFatiguedNum;
                    if(
                            (overSpeedNum == null &&
                                    seriousOverSpeedNum == null &&
                                    fatiguedNum == null &&
                                    seriousFatiguedNum == null)||
                                    (overSpeedNum == 0 &&
                                            seriousOverSpeedNum == 0 &&
                                            fatiguedNum == 0 &&
                                            seriousFatiguedNum == 0)
                            ){
                        continue;
                    }
                    if(seriousOverSpeedNum>10){
                        isOverSpeed=true;
                        temMsg += "超速报警"+overSpeedNum+"次,严重超速报警"+seriousOverSpeedNum+"次";
                    }
                    if(seriousFatiguedNum>5){
                        isFatigued=true;
                        if(temMsg.length()>0){
                            temMsg = temMsg+";";
                        }
                        temMsg += "疲劳报警" + fatiguedNum + "次,严重疲劳报警"+seriousFatiguedNum+"次";
                    }

                    if(temMsg.length()>0){
                        temMsg = "关联车辆["+carPlateNum+"]出现"+temMsg +"。";
                        siteMsg = siteMsg + temMsg;
                    }

                }

                if(siteMsg.length()>0){
                    siteMsg = "您好，您在" + monthYearMonth  + siteMsg + "系统自动为您推送定向课件，请注意学习。消息由《秦皇岛市智慧交通北斗大数据分析平台》提供。";
                    String successStr = sendLessionToEmp(
                            appCityId,
                            emp.getId(),siteMsg,
                            isFatigued,fatiguedNumSum,seriousFatiguedNumSum,
                            isOverSpeed,overSpeedNumSum,seriousOverSpeedNumSum,
                            monthYearMonth
                    );
                    if(successStr.equals("true")){
                        //发送课件成功,将这几个记录修改成已经发送状态
                        int rows = monthEmpAlarmSumService.updateEmpAlarmSumToSendStatus(monthEmpAlarmSumList);
                    }
                }


            }catch(Exception e){
                e.printStackTrace();
            }
        }

        nextBatchNum_1++;
        long endtime = System.currentTimeMillis();

        System.out.println("batchNum="+ nextBatchNum_1 +" | data time:" + (endtime-begin)  + "mils");

    }


    private String sendLessionToEmp(String cityId,
            String empId,String siteMsg,
            boolean isFatigued,Integer fatiguedNumSum,Integer seriousFatiguedNumSum,
            boolean isOverSpeed,Integer overSpeedNumSum,Integer seriousOverSpeedNumSum,
            String monthYearMonth
            ){
        //推送站内信
        Map<String,Object>  paramSendLession = new HashMap<String,Object>();
        paramSendLession.put("cityId",cityId);
        paramSendLession.put("empId",empId);
        paramSendLession.put("siteMsg",siteMsg);
        paramSendLession.put("isFatigued",isFatigued);
        paramSendLession.put("fatiguedNumSum",fatiguedNumSum);
        paramSendLession.put("seriousFatiguedNumSum",seriousFatiguedNumSum);
        paramSendLession.put("isOverSpeed",isOverSpeed);
        paramSendLession.put("overSpeedNumSum",overSpeedNumSum);
        paramSendLession.put("seriousOverSpeedNumSum",seriousOverSpeedNumSum);
        paramSendLession.put("countMonth",monthYearMonth);
        String urlSendLession = ReportDataUrl + "/sys/emp/sendLessionToEmp.jsn";
        String res = HttpRequestUtil.postRequest(urlSendLession,paramSendLession);
        JSONObject jsonObj = JSONObject.parseObject(res);
        String success = jsonObj.get("success")+"";
        return success;
    }



}
