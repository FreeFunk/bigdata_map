package com.edgedo.timetask.fenxi;

import com.edgedo.bigdata.entity.BigdataFenxiTeamDay;
import com.edgedo.bigdata.entity.BigdataTimeCarDayRec;
import com.edgedo.bigdata.entity.TransitCarTeamQuery;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamDayMapper;
import com.edgedo.bigdata.mapper.BigdataTimeCarDayRecMapper;
import com.edgedo.bigdata.service.BigdataFenxiTeamDayService;
import com.edgedo.bigdata.service.BigdataTimeCarDayRecService;
import com.edgedo.common.util.Guid;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.ObjectUtil;
import com.edgedo.util.DateUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 大数据企业分析(按天)
 * 根据企业名和企业id  查出每一台车  计算总数
 */
@Component
public class BigdataFenXiTeamDay {

    @Autowired
    private BigdataTimeCarDayRecService bigdataTimeCarDayRecService;

    @Autowired
    private BigdataFenxiTeamDayMapper bigdataFenxiTeamDayMapper;

    @Autowired
    private BigdataFenxiTeamDayService bigdataFenxiTeamDayService;
    @Value("${ReportDataUrl}")
    private String ReportDataUrl;

    @Scheduled(cron = "0 5 0 * * ?")//0/2 * * * * ?每天九点更新0 0 1 * * ?
    public void execute(){
        TransitCarTeamQuery query = new TransitCarTeamQuery();
        String reportDataUrl = ReportDataUrl+"/sys/carTeam/selectTeamCarInfo.jsn";
        query.setCityId("130300");
        Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
        String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
        org.json.JSONObject jsonObject = new org.json.JSONObject(responseStr);
        JSONArray jsonArray = jsonObject.optJSONArray("list");
        List<BigdataFenxiTeamDay> listTeam =
                com.alibaba.fastjson.JSONArray.parseArray(jsonArray.toString(), BigdataFenxiTeamDay.class);
        for(int i = 0;i<listTeam.size();i++){
            listTeam.get(i).setTeamId(listTeam.get(i).getId());//设置企业id
            listTeam.get(i).setId(Guid.guid());//设置主键
            String teamType = jsonArray.getJSONObject(i).optString("companyLevel");
            if(teamType.equals("TEAM_KY")){
                listTeam.get(i).setTeamType(teamType);
                listTeam.get(i).setTransitType("客运");
            }else if(teamType.equals("TEAM_WXHWYS")){
                listTeam.get(i).setTeamType(teamType);
                listTeam.get(i).setTransitType("危货");
            }else{
                listTeam.get(i).setTeamType(teamType);
                listTeam.get(i).setTransitType("普货");
            }
        }
        insertAndupdateTeam(listTeam);
    }

    //企业对应车辆信息  年月 日
    public void insertAndupdateTeam(List<BigdataFenxiTeamDay> listTeam){
        //1.设置年月日
        Date dateCurr = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateCurr);
        calendar.add(Calendar.DATE,-1);
        dateCurr = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(dateCurr);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        Integer countMonth = new Integer(str[0]+str[1]);//月
        Integer countDay = new Integer(str[0]+str[1]+str[2]);//日
        for(BigdataFenxiTeamDay bigdataFenxiTeamDay : listTeam){
            String teamId = bigdataFenxiTeamDay.getTeamId();
            //一条企业记录  对应多个车辆信息
            //设置年月日
            bigdataFenxiTeamDay.setYearNum(yearNum);
            bigdataFenxiTeamDay.setCountMonth(countMonth);
            bigdataFenxiTeamDay.setCountDate(countDay);
            bigdataFenxiTeamDay.setCreateTime(new Date());//创建时间
            //统计企业下面的车辆数
            int carNum = bigdataTimeCarDayRecService.countCarNumByTeamId(teamId,yearNum,countMonth,countDay);
            bigdataFenxiTeamDay.setCountCarNum(carNum);
            if(carNum==0){
                bigdataFenxiTeamDay.setRunMileage(new BigDecimal(0));
                bigdataFenxiTeamDay.setRunTimeLength(new BigDecimal("0"));
                bigdataFenxiTeamDay.setAlarmNum(0);
                bigdataFenxiTeamDay.setRunTimeLengthHour(new BigDecimal(0));
                bigdataFenxiTeamDay.setRunTimeLengthText("0秒");
                bigdataFenxiTeamDay.setAlarmRate(new BigDecimal(0));
                bigdataFenxiTeamDay.setAverageSpeed(new BigDecimal(0));
                bigdataFenxiTeamDay.setAverageRunMileage(new BigDecimal(0));
                bigdataFenxiTeamDay.setAverageRunTimeLength(new BigDecimal(0));
                bigdataFenxiTeamDay.setAverageAlarmNum(new BigDecimal(0));
                bigdataFenxiTeamDay.setRunMileageTopThree("无");
                bigdataFenxiTeamDay.setAlarmNumTopThree("无");
                bigdataFenxiTeamDay.setCreateTime(new Date());
            }else {
                Map<String,Object> map = bigdataTimeCarDayRecService.countNum(teamId,yearNum,countMonth,countDay);
                //行驶里程  BigDecimal
                BigDecimal runMileage = (BigDecimal) map.get("runMileage");
                //行驶时长秒  Integer
                BigDecimal runTimeMinuter = (BigDecimal) map.get("runTimeLength");
                //报警数量  int
                BigDecimal baoJingNum =  (BigDecimal)map.get("alarmNum");
                //报警数量/百公里 BigDecimal
                bigdataFenxiTeamDay.setRunMileage(runMileage);
                bigdataFenxiTeamDay.setRunTimeLength(runTimeMinuter);
                bigdataFenxiTeamDay.setAlarmNum(baoJingNum.intValue());
                //行驶时长小时  Integer
                bigdataFenxiTeamDay.setRunTimeLengthHour(runTimeMinuter.divide(new BigDecimal(60),2, RoundingMode.HALF_UP));
                //行驶时长文本  String 几小时几分
                bigdataFenxiTeamDay.setRunTimeLengthText(DateUtil.getHourMinuteSecond(runTimeMinuter));
                //报警数量/百公里 BigDecimal
                bigdataFenxiTeamDay.setAlarmRate(getBaoJingAndBaiGongLi(baoJingNum.intValue(),runMileage));
                //平均速度  km/h行驶里程/行驶时长小时 BigDecimal
                bigdataFenxiTeamDay.setAverageSpeed(getAverageSpeed(runMileage,runTimeMinuter));
                //平均行驶里程   行驶里程/计算车辆总数  BigDecimal
                bigdataFenxiTeamDay.setAverageRunMileage(getAverageRunMileage(runMileage,carNum));
                //平均行驶时长（小时）  行驶时长小时/计算车辆总数 BigDecimal
                bigdataFenxiTeamDay.setAverageRunTimeLength(getAverageRunTimeLength(runTimeMinuter,carNum));
                //平均报警数量   报警数量/计算车辆总数 BigDecimal
                bigdataFenxiTeamDay.setAverageAlarmNum(getAverageAlarmNum(baoJingNum.intValue(),carNum));
                //行驶里程前三 String
                List<BigdataTimeCarDayRec> runMileageList = bigdataTimeCarDayRecService.selectRunMileageTopThree(teamId,yearNum,countMonth,countDay);
                bigdataFenxiTeamDay.setRunMileageTopThree(getTopThreeMileageText(runMileageList));
                //报警数量前三 String
                List<BigdataTimeCarDayRec> alarmList = bigdataTimeCarDayRecService.selectAlarmNumTopThree(teamId,yearNum,countMonth,countDay);
                bigdataFenxiTeamDay.setAlarmNumTopThree(getTopThreeAlarmNumText(alarmList));
            }
            //进行判断
            int count = bigdataFenxiTeamDayMapper.selectCountTeam(bigdataFenxiTeamDay.getTeamId(),yearNum,countMonth,countDay);
            if(count==0){//插入
                bigdataFenxiTeamDayMapper.insert(bigdataFenxiTeamDay);
            }else {
                bigdataFenxiTeamDay.setUpdateTime(new Date());//更新时间
                bigdataFenxiTeamDayService.updateByIdAndYearAndMonthAndDay(bigdataFenxiTeamDay);
            }
        }
    }

    private String getTopThreeMileageText(List<BigdataTimeCarDayRec> list) {
        String topThree = "";
        for(BigdataTimeCarDayRec c:list){
            if (topThree.equals("")){
                topThree = c.getCarPlateNum()+"("+c.getSumMileage()+")";
            }else {
                topThree += ","+c.getCarPlateNum()+"("+c.getSumMileage()+")";
            }
        }
        if(topThree.equals("")){
            topThree = "无";
        }
        return topThree;
    }

    private String getTopThreeAlarmNumText(List<BigdataTimeCarDayRec> list) {
        String topThree = "";
        for(BigdataTimeCarDayRec c:list){
            if (topThree.equals("")){
                topThree = c.getCarPlateNum()+"("+c.getAlarmNum()+")";
            }else {
                topThree += ","+c.getCarPlateNum()+"("+c.getAlarmNum()+")";
            }
        }
        if(topThree.equals("")){
            topThree = "无";
        }
        return topThree;
    }


    public void mapInsertTeam(BigdataFenxiTeamDay bigdataFenxiTeamDay,List<BigdataTimeCarDayRec> list,
                              Integer yearNum,Integer countMonth,Integer countDay){
        //1.拿到map之后  一个key对应一个企业id key对应的value就是所有的车辆

        bigdataFenxiTeamDay.setCountCarNum(list.size());
        if(list.size()==0){
            bigdataFenxiTeamDay.setRunMileage(new BigDecimal(0));
            bigdataFenxiTeamDay.setRunTimeLength(new BigDecimal("0"));
            bigdataFenxiTeamDay.setAlarmNum(0);
            bigdataFenxiTeamDay.setRunTimeLengthHour(new BigDecimal(0));
            bigdataFenxiTeamDay.setRunTimeLengthText("0秒");
            bigdataFenxiTeamDay.setAlarmRate(new BigDecimal(0));
            bigdataFenxiTeamDay.setAverageSpeed(new BigDecimal(0));
            bigdataFenxiTeamDay.setAverageRunMileage(new BigDecimal(0));
            bigdataFenxiTeamDay.setAverageRunTimeLength(new BigDecimal(0));
            bigdataFenxiTeamDay.setAverageAlarmNum(new BigDecimal(0));
            bigdataFenxiTeamDay.setRunMileageTopThree("无");
            bigdataFenxiTeamDay.setAlarmNumTopThree("无");
            bigdataFenxiTeamDay.setUpdateTime(new Date());
            bigdataFenxiTeamDayMapper.updateByIdAndYearAndMonthAndDay(bigdataFenxiTeamDay);
        }else {
            Map<String,Object> map = bigdataTimeCarDayRecService.countNum(bigdataFenxiTeamDay.getTeamId(),yearNum,countMonth,countDay);
            //行驶里程  BigDecimal
            BigDecimal runMileage = (BigDecimal) map.get("runMileage");
            //行驶时长秒  Integer
            //行驶时长文本  String 几小时几分
            //行驶时长分钟 BigDecimal
            BigDecimal runTimeMinuter = (BigDecimal) map.get("runTimeLength");
            //报警数量  int
            BigDecimal baoJingNum =  (BigDecimal)map.get("alarmNum");
            //报警数量/百公里 BigDecimal
            // 安全评分  BigDecimal
//                BigDecimal anQuanPingFen= new BigDecimal(0);
            //平均速度  km/h行驶里程/行驶时长小时 BigDecimal
            //平均行驶里程   行驶里程/计算车辆总数  BigDecimal
            //平均行驶时长（小时）  行驶时长小时/计算车辆总数 BigDecimal
            //平均报警数量   报警数量/计算车辆总数 BigDecimal
            bigdataFenxiTeamDay.setRunMileage(runMileage);
            bigdataFenxiTeamDay.setRunTimeLength(runTimeMinuter);
            bigdataFenxiTeamDay.setAlarmNum(baoJingNum.intValue());
            //行驶时长小时  Integer
            bigdataFenxiTeamDay.setRunTimeLengthHour(runTimeMinuter.divide(new BigDecimal(60),2, RoundingMode.HALF_UP));
            //行驶时长文本  String 几小时几分
            bigdataFenxiTeamDay.setRunTimeLengthText(getMinuteText(runTimeMinuter));
            //报警数量/百公里 BigDecimal
            bigdataFenxiTeamDay.setAlarmRate(getBaoJingAndBaiGongLi(baoJingNum.intValue(),runMileage));
            //平均速度  km/h行驶里程/行驶时长小时 BigDecimal
            bigdataFenxiTeamDay.setAverageSpeed(getAverageSpeed(runMileage,runTimeMinuter));
            //平均行驶里程   行驶里程/计算车辆总数  BigDecimal
            bigdataFenxiTeamDay.setAverageRunMileage(getAverageRunMileage(runMileage,list.size()));
            //平均行驶时长（小时）  行驶时长小时/计算车辆总数 BigDecimal
            bigdataFenxiTeamDay.setAverageRunTimeLength(getAverageRunTimeLength(runTimeMinuter,list.size()));
            //平均报警数量   报警数量/计算车辆总数 BigDecimal
            bigdataFenxiTeamDay.setAverageAlarmNum(getAverageAlarmNum(baoJingNum.intValue(),list.size()));
            //行驶里程前三 String
            bigdataFenxiTeamDay.setRunMileageTopThree(getTopThreeMileage(list));
            //报警数量前三 String
            bigdataFenxiTeamDay.setAlarmNumTopThree(getTopThreeAlarmNum(list));
        }
    }

    //报警数量前三
    private String getTopThreeAlarmNum(List<BigdataTimeCarDayRec> list) {
        String str = "";
        //取前三
        Collections.sort(list, new Comparator<BigdataTimeCarDayRec>(){
            @Override
            public int compare(BigdataTimeCarDayRec o1, BigdataTimeCarDayRec o2) {
                //按照Person的年龄进行升序排列
                if(o1.getAlarmNum().compareTo(o2.getAlarmNum())==-1){//o1小于o2
                    return 1;
                }
                if(o1.getAlarmNum().compareTo(o2.getAlarmNum())==0){//==
                    return 0;
                }
                return -1;
            }
        });
        if(list.size()>=3){
            //遍历取前三个
            for(int i = 0;i<3;i++){
                if(i==0){
                    String mlieage = list.get(i).getAlarmNum().toString();//报警数量
                    String carNum = list.get(i).getCarPlateNum();//车牌号
                    if(list.get(i).getAlarmNum()==0){
                        str = "无";
                        return str;
                    }
                    str = carNum+"("+mlieage+")";
                }else {
                    String mlieage = list.get(i).getAlarmNum().toString();//报警数量
                    String carNum = list.get(i).getCarPlateNum();//车牌号
                    if(list.get(i).getAlarmNum()==0){
                        return str;
                    }
                    str = str+"，"+carNum+"("+mlieage+")";
                }
            }
            return str;
        }else {
            //遍历取前三个
            for(int i = 0;i<list.size();i++){
                if(i==0){
                    String mlieage = list.get(i).getAlarmNum().toString();//报警数量
                    String carNum = list.get(i).getCarPlateNum();//车牌号
                    if(list.get(i).getAlarmNum()==0){
                        str = "无";
                        return str;
                    }
                    str = carNum+"("+mlieage+")";
                }else {
                    String mlieage = list.get(i).getAlarmNum().toString();//报警数量
                    String carNum = list.get(i).getCarPlateNum();//车牌号
                    if(list.get(i).getAlarmNum()==0){
                        return str;
                    }
                    str = str+"，"+carNum+"("+mlieage+")";
                }
            }
            return str;
        }
    }

    //行驶里程前三
    private String getTopThreeMileage(List<BigdataTimeCarDayRec> list) {
        String str = "";
        //取前三
        Collections.sort(list, new Comparator<BigdataTimeCarDayRec>(){
            @Override
            public int compare(BigdataTimeCarDayRec o1, BigdataTimeCarDayRec o2) {
                //按照Person的年龄进行升序排列
                if(o1.getSumMileage().compareTo(o2.getSumMileage())==-1){//o1小于o2
                    return 1;
                }
                if(o1.getSumMileage().compareTo(o2.getSumMileage())==0){//==
                    return 0;
                }
                return -1;
            }
        });
        if(list.size()>=3){
            //遍历取前三个
            for(int i = 0;i<3;i++){
                if(i==0){
                    String mlieage = list.get(i).getSumMileage().toString();//行驶里程
                    String carNum = list.get(i).getCarPlateNum();//车牌号
                    if(list.get(i).getSumMileage().compareTo(BigDecimal.ZERO)==0){
                        str = "无";
                        return str;
                    }
                    str = carNum+"("+mlieage+")";
                }else {
                    String mlieage = list.get(i).getSumMileage().toString();//行驶里程
                    String carNum = list.get(i).getCarPlateNum();//车牌号
                    if(list.get(i).getSumMileage().compareTo(BigDecimal.ZERO)==0){
                        return str;
                    }
                    str = str+"，"+carNum+"("+mlieage+")";
                }
            }
            return str;
        }else {
            //遍历取前三个
            for(int i = 0;i<list.size();i++){
                if(i==0){
                    String mlieage = list.get(i).getSumMileage().toString();//行驶里程
                    String carNum = list.get(i).getCarPlateNum();//车牌号
                    if(list.get(i).getSumMileage().compareTo(BigDecimal.ZERO)==0){
                        str = "无";
                        return str;
                    }
                    str = carNum+"("+mlieage+")";
                }else {
                    String mlieage = list.get(i).getSumMileage().toString();//行驶里程
                    String carNum = list.get(i).getCarPlateNum();//车牌号
                    if(list.get(i).getSumMileage().compareTo(BigDecimal.ZERO)==0){
                        return str;
                    }
                    str = str+"，"+carNum+"("+mlieage+")";
                }
            }
            return str;
        }
    }

    //计算平均报警数量
    private BigDecimal getAverageAlarmNum(Integer baoJingNum, Integer sumNum) {
        if(sumNum==0){
            return new BigDecimal(0);
        }else {
            BigDecimal bigDecimalBaoJingNum = new BigDecimal(baoJingNum);
            BigDecimal bigDecimalCarNum = new BigDecimal(sumNum);
            BigDecimal bigDecimal = bigDecimalBaoJingNum.divide(bigDecimalCarNum,2, RoundingMode.HALF_UP);
            return bigDecimal;
        }
    }

    //计算平均行驶时长（小时）
    private BigDecimal getAverageRunTimeLength(BigDecimal runTimeMinuter, Integer sumNum) {
        if(sumNum==0){
            return new BigDecimal(0);
        }else {
            runTimeMinuter = runTimeMinuter.divide(new BigDecimal(60),2, RoundingMode.HALF_UP);
            BigDecimal bigDecimalCarNum = new BigDecimal(sumNum);
            BigDecimal bigDecimal = runTimeMinuter.divide(bigDecimalCarNum,2, RoundingMode.HALF_UP);
            return bigDecimal;
        }
    }

    //计算平均行驶里程
    private BigDecimal getAverageRunMileage(BigDecimal runMileage, Integer sumNum) {
        if(sumNum==0){
            return new BigDecimal(0);
        }else {
            BigDecimal bigDecimalCarNum = new BigDecimal(sumNum);
            BigDecimal bigDecimal = runMileage.divide(bigDecimalCarNum,2, RoundingMode.HALF_UP);
            return bigDecimal;
        }
    }

    //计算平均速度
    private BigDecimal getAverageSpeed(BigDecimal runMileage, BigDecimal runTimeMinuter) {
        if(runTimeMinuter.compareTo(BigDecimal.ZERO)==0){
            return new BigDecimal(0);
        }else {
            runTimeMinuter = runTimeMinuter.divide(new BigDecimal(60),2, RoundingMode.HALF_UP);
            BigDecimal bigDecimal = runMileage.divide(runTimeMinuter,2, RoundingMode.HALF_UP);
            return bigDecimal;
        }
    }


    //计算报警数量/百公里
    private BigDecimal getBaoJingAndBaiGongLi(Integer baoJingNum, BigDecimal runMileage) {
        //a.divide(b, 2, RoundingMode.HALF_UP)
        if(runMileage.compareTo(BigDecimal.ZERO)==0){
            return new BigDecimal(0);
        }else {
            BigDecimal bigDecimalBaoJingNum = new BigDecimal(baoJingNum);
            BigDecimal bigDecimal = bigDecimalBaoJingNum.divide(runMileage,2, RoundingMode.HALF_UP);
            return bigDecimal;
        }

    }

    //生成行驶时长文本
    private String getMinuteText(BigDecimal runTimeMinuter) {
        runTimeMinuter = runTimeMinuter.divide(new BigDecimal(60),2, RoundingMode.HALF_UP);
        if (runTimeMinuter.compareTo(BigDecimal.ZERO)==0) {
            return "0";
        }else {
            if(new BigDecimal(runTimeMinuter.intValue()).compareTo(runTimeMinuter)==0){
                String hourStr = runTimeMinuter.toString();
                String[] strArr = hourStr.split("\\.");
                String sumMinuteText = strArr[0]+"小时"+"0分钟";
                return sumMinuteText;
            }else {
                String hourStr = runTimeMinuter.toString();
                String[] strArr = hourStr.split("\\.");
                BigDecimal xiaoShuMinute = new BigDecimal("0."+strArr[1]);//0.82*60
                xiaoShuMinute = xiaoShuMinute.multiply(new BigDecimal(60)).setScale(0, BigDecimal.ROUND_DOWN);
                String xiaoShuMinuteStr = xiaoShuMinute.toString();//"52"
                String[] strArr1 = xiaoShuMinuteStr.split("\\.");//{52,8}
                String sumMinuteText = strArr[0]+"小时"+strArr1[0]+"分钟";
                return sumMinuteText;
            }
        }
    }

    //生成行驶时长秒
    private Integer getMinute(BigDecimal hour) {
        if (hour.toString().equals("0")) {
            return 0;
        }else {
            if(new BigDecimal(hour.intValue()).compareTo(hour)==0){
                String hourStr = hour.toString();
                String[] strArr = hourStr.split("\\.");
                Integer hourMinute = new Integer(strArr[0])*60;
                Integer sumMinute =  hourMinute;
                return sumMinute;
            }else {
                String hourStr = hour.toString();
                String[] strArr = hourStr.split("\\.");
                Integer hourMinute = new Integer(strArr[0])*60;
                Integer xiaoShuMinute = new Integer("0."+strArr[1])*60;//0.82*60
                String xiaoShuMinuteStr = xiaoShuMinute.toString();//"52.8"
                String[] strArr1 = xiaoShuMinuteStr.split("\\.");//{52,8}
                Integer sumMinute =  hourMinute+new Integer(strArr1[0]);
                return sumMinute;
            }

        }
    }


}
