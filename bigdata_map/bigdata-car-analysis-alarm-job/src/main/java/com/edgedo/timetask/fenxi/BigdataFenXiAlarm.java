package com.edgedo.timetask.fenxi;

import com.edgedo.bigdata.entity.BigdataFenxiAlarm;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningQuery;
import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.bigdata.service.BigdataFenxiAlarmService;
import com.edgedo.bigdata.service.BigdataSafetyWarningService;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class BigdataFenXiAlarm {

    @Autowired
    BigdataFenxiAlarmService service;
    @Autowired
    BigdataAlarmRecordService alarmRecordService;
    @Autowired
    BigdataSafetyWarningService safetyWarningService;

    //主动安全报警类型
    String[] alarmTypeArrZdaq = {"180","182","152","186","189","188","187","190","183","184"};
    String[] alarmTypeDescArrBigdata = {"前向碰撞报警","车距过近报警","车道偏离报警","疲劳驾驶报警","分神驾驶报警","抽烟报警","接打电话报警","异常报警","交通标志识别","行人碰撞报警"};
    String[] alarmTypeDescArrZdaq = {"前向碰撞预警","车距过近预警","车道偏离预警","疲劳驾驶报警","注意力分散报警","抽烟报警","接打电话报警","异常报警","限速标志识别","行人碰撞报警"};
    //常规报警类型
    String[] alarmTypeArrCg = {"4","2"};
    String[] alarmTypeDescArrCg = {"疲劳报警","超速报警"};

    //县区
    String[] xianquIdArr = {"130302","130303","130304","130306","130321","130322","130324","130371"};
    String[] xianquNameArr = {"海港区","山海关区","北戴河区","抚宁区","青龙县","昌黎县","卢龙县","开发区"};

    SimpleDateFormat sdfDay = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyyMM");
    SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    @Scheduled(cron = "0 30 0 * * ?")
    public void execute(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        //车辆类型总的 常规报警
        analysisAlarmType("0","总",date);
        //车辆类型危货 常规报警
        analysisAlarmType("0","危货",date);
        //车辆类型普货 常规报警
        analysisAlarmType("0","普货",date);
        //车辆类型客运 常规报警
        analysisAlarmType("0","客运",date);
        //车辆类型总的  主动安全报警
        analysisAlarmType("1","总",date);
        //车辆类型危货  主动安全报警
        analysisAlarmType("1","危货",date);
        //车辆类型普货  主动安全报警
        analysisAlarmType("1","普货",date);
        //车辆类型客运  主动安全报警
        analysisAlarmType("1","客运",date);
    }

    public void analysisAlarmType(String alarmCls,String carType,Date date){
        Integer countDate = Integer.parseInt(sdfDay.format(date));
        Integer countMonth = Integer.parseInt(sdfMonth.format(date));
        Integer yearNum = Integer.parseInt(sdfYear.format(date));

        //存一些公共的东西
        BigdataFenxiAlarm alarm = new BigdataFenxiAlarm();
        alarm.setProvinceId("HEBEI");
        alarm.setProvinceName("河北省");
        alarm.setCityId("130300");
        alarm.setCityName("秦皇岛市");
        alarm.setYearNum(yearNum);
        alarm.setCountMonth(countMonth);
        alarm.setCountDate(countDate);
        alarm.setCarType(carType);

        if(alarmCls.equals("0")){
            //常规报警类型
            for(int i=0;i<alarmTypeArrCg.length;i++){
                alarm.setAlarmCls(alarmCls);
                String alarmType = alarmTypeArrCg[i];
                alarm.setAlarmType(alarmType);
                alarm.setAlarmTypeDesc(alarmTypeDescArrCg[i]);
                //查询市和天
                analysisAlarmTypeByCarTypeCountTypeTimeTypeCg(carType,"CITY","DAY",alarm,date);
                //查询市和周
                analysisAlarmTypeByCarTypeCountTypeTimeTypeCg(carType,"CITY","WEEK",alarm,date);
                //查询市和月份
                analysisAlarmTypeByCarTypeCountTypeTimeTypeCg(carType,"CITY","MONTH",alarm,date);
                //查询县区和天
                analysisAlarmTypeByCarTypeCountTypeTimeTypeCg(carType,"XIANQU","DAY",alarm,date);
                //查询县区和天
                analysisAlarmTypeByCarTypeCountTypeTimeTypeCg(carType,"XIANQU","WEEK",alarm,date);
                //查询县区和月份
                analysisAlarmTypeByCarTypeCountTypeTimeTypeCg(carType,"XIANQU","MONTH",alarm,date);
            }
        }else{
            //主动安全报警类型
            for(int i=0;i<alarmTypeArrZdaq.length;i++){
                alarm.setAlarmCls(alarmCls);
                String alarmType = alarmTypeArrZdaq[i];
                alarm.setAlarmType(alarmType);
                alarm.setAlarmTypeDesc(alarmTypeDescArrBigdata[i]);
                String alarmDescZdaq = alarmTypeDescArrZdaq[i];
                //查询市和天
                analysisAlarmTypeByCarTypeCountTypeTimeTypeZdaq(carType,"CITY","DAY",alarm,alarmDescZdaq,date);
                //查询市和天
                analysisAlarmTypeByCarTypeCountTypeTimeTypeZdaq(carType,"CITY","WEEK",alarm,alarmDescZdaq,date);
                //查询市和月份
                analysisAlarmTypeByCarTypeCountTypeTimeTypeZdaq(carType,"CITY","MONTH",alarm,alarmDescZdaq,date);
                //查询县区和天
                analysisAlarmTypeByCarTypeCountTypeTimeTypeZdaq(carType,"XIANQU","DAY",alarm,alarmDescZdaq,date);
                //查询县区和天
                analysisAlarmTypeByCarTypeCountTypeTimeTypeZdaq(carType,"XIANQU","WEEK",alarm,alarmDescZdaq,date);
                //查询县区和月份
                analysisAlarmTypeByCarTypeCountTypeTimeTypeZdaq(carType,"XIANQU","MONTH",alarm,alarmDescZdaq,date);
            }
        }
    }

    //常规报警类型统计
    public void analysisAlarmTypeByCarTypeCountTypeTimeTypeCg(String carType,String countType,String timeType,BigdataFenxiAlarm alarm,Date date){
        //将查询方式赋值上
        alarm.setTimeType(timeType);
        alarm.setCountType(countType);

        BigdataAlarmRecordQuery alarmRecordQuery = new BigdataAlarmRecordQuery();
        int analysisAlarmTypeCount = 0;
        String alarmType = alarm.getAlarmType();
        alarmRecordQuery.getQueryObj().setAlarmType(alarmType);
        if(alarmType.equals("4")){
            alarmRecordQuery.getQueryObj().setAlarmCls("2");
        }else{
            alarmRecordQuery.getQueryObj().setAlarmCls("1");
        }
        //一定有的查询条件
        alarmRecordQuery.getQueryObj().setProvinceId(alarm.getProvinceId());
        alarmRecordQuery.getQueryObj().setCityId(alarm.getCityId());
        alarmRecordQuery.getQueryObj().setCountMonth(alarm.getCountMonth());
        if(timeType.equals("DAY")){
            alarm.setCountWeek(null);
            alarmRecordQuery.getQueryObj().setCountDate(alarm.getCountDate());
        }else if(timeType.equals("WEEK")){
            //周统计
            setAlarmTypeForWeekCg(alarmRecordQuery,date);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int countWeek = c.get(Calendar.WEEK_OF_YEAR);
            alarm.setCountWeek(countWeek);
        }else{
            alarm.setCountWeek(null);
        }
        if(!carType.equals("总")){
            alarmRecordQuery.getQueryObj().setCarType(carType);
        }
        if(countType.equals("CITY")){
            analysisAlarmTypeCount = alarmRecordService.selectAlarmTypeCountByQuery(alarmRecordQuery);
            alarm.setXianquId(null);
            alarm.setXianquName(null);
            alarm.setId(Guid.guid());
            alarm.setCreateTime(new Date());
            alarm.setUpdateTime(new Date());
            alarm.setAlarmNum(analysisAlarmTypeCount);
            alarm.setCountType("CITY");
            //如果已经存在了就更新一下
            Integer countDate = alarm.getCountDate();
            BigdataFenxiAlarmQuery alarmQuery = new BigdataFenxiAlarmQuery();
            alarmQuery.getQueryObj().setCountWeek(alarm.getCountWeek());
            alarmQuery.getQueryObj().setCountType("CITY");
            alarmQuery.getQueryObj().setTimeType(alarm.getTimeType());
            alarmQuery.getQueryObj().setCarType(alarm.getCarType());
            alarmQuery.getQueryObj().setAlarmCls(alarm.getAlarmCls());
            alarmQuery.getQueryObj().setAlarmTypeDesc(alarm.getAlarmTypeDesc());
            alarmQuery.getQueryObj().setCountMonth(alarm.getCountMonth());
            alarmQuery.getQueryObj().setYearNum(alarm.getYearNum());
            if(timeType != null && timeType.equals("DAY")){
                alarmQuery.getQueryObj().setCountDate(alarm.getCountDate());
            }
            BigdataFenxiAlarm alarmUpdate = service.selectVoForWeekOrMonth(alarmQuery);
            if(alarmUpdate != null){
                alarmUpdate.setAlarmNum(analysisAlarmTypeCount);
                alarmUpdate.setCountDate(countDate);
                alarmUpdate.setUpdateTime(new Date());
                service.update(alarmUpdate);
            }else{
                service.insert(alarm);
            }
        }else{
            for(int i=0;i<xianquIdArr.length;i++){
                String xianquId = xianquIdArr[i];
                alarmRecordQuery.getQueryObj().setXianquId(xianquId);
                analysisAlarmTypeCount = alarmRecordService.selectAlarmTypeCountByQuery(alarmRecordQuery);
                alarm.setId(Guid.guid());
                alarm.setCreateTime(new Date());
                alarm.setUpdateTime(new Date());
                alarm.setAlarmNum(analysisAlarmTypeCount);
                alarm.setCountType("XIANQU");
                alarm.setXianquId(xianquId);
                alarm.setXianquName(xianquNameArr[i]);
                //如果已经存在了就更新一下
                Integer countDate = alarm.getCountDate();
                BigdataFenxiAlarmQuery alarmQuery = new BigdataFenxiAlarmQuery();
                alarmQuery.getQueryObj().setCountWeek(alarm.getCountWeek());
                alarmQuery.getQueryObj().setCountType("XIANQU");
                alarmQuery.getQueryObj().setTimeType(alarm.getTimeType());
                alarmQuery.getQueryObj().setXianquId(alarm.getXianquId());
                alarmQuery.getQueryObj().setCarType(alarm.getCarType());
                alarmQuery.getQueryObj().setAlarmCls(alarm.getAlarmCls());
                alarmQuery.getQueryObj().setAlarmTypeDesc(alarm.getAlarmTypeDesc());
                alarmQuery.getQueryObj().setCountMonth(alarm.getCountMonth());
                alarmQuery.getQueryObj().setYearNum(alarm.getYearNum());
                if(timeType != null && timeType.equals("DAY")){
                    alarmQuery.getQueryObj().setCountDate(alarm.getCountDate());
                }
                BigdataFenxiAlarm alarmUpdate = service.selectVoForWeekOrMonth(alarmQuery);
                if(alarmUpdate != null){
                    alarmUpdate.setAlarmNum(analysisAlarmTypeCount);
                    alarmUpdate.setCountDate(countDate);
                    alarmUpdate.setUpdateTime(new Date());
                    service.update(alarmUpdate);
                }else{
                    service.insert(alarm);
                }
            }
        }

    }

    //主动安全报警类型统计
    public void analysisAlarmTypeByCarTypeCountTypeTimeTypeZdaq(String carType,String countType,String timeType,BigdataFenxiAlarm alarm,String alarmDescZdaq,Date date){
        //将查询方式赋值上
        alarm.setTimeType(timeType);
        alarm.setCountType(countType);

        BigdataSafetyWarningQuery safetyWarningQuery = new BigdataSafetyWarningQuery();
        int analysisWarningTypeCount = 0;
        safetyWarningQuery.getQueryObj().setWarningType(alarmDescZdaq);
        //一定有的查询条件
        safetyWarningQuery.getQueryObj().setProvinceId(alarm.getProvinceId());
        safetyWarningQuery.getQueryObj().setCityId(alarm.getCityId());
        safetyWarningQuery.getQueryObj().setCountMonth(alarm.getCountMonth());
        if(timeType.equals("DAY")){
            safetyWarningQuery.getQueryObj().setCountDate(alarm.getCountDate());
            alarm.setCountWeek(null);
        }else if(timeType.equals("WEEK")){
            //周统计
            setAlarmTypeQueryForWeekZdaq(safetyWarningQuery,date);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int countWeek = c.get(Calendar.WEEK_OF_YEAR);
            alarm.setCountWeek(countWeek);
        }else{
            alarm.setCountWeek(null);
        }
        if(!carType.equals("总")){
            safetyWarningQuery.getQueryObj().setCarType(carType);
        }else{
            safetyWarningQuery.getQueryObj().setCarType("");
        }
        if(countType.equals("CITY")){
            analysisWarningTypeCount = safetyWarningService.selectWarningTypeCountByQuery(safetyWarningQuery);
            alarm.setXianquId(null);
            alarm.setXianquName(null);
            alarm.setId(Guid.guid());
            alarm.setCreateTime(new Date());
            alarm.setUpdateTime(new Date());
            alarm.setAlarmNum(analysisWarningTypeCount);
            alarm.setCountType("CITY");
            //如果是周和月查询，更新一下就好了
            Integer countDate = alarm.getCountDate();
            BigdataFenxiAlarmQuery alarmQuery = new BigdataFenxiAlarmQuery();
            alarmQuery.getQueryObj().setCountWeek(alarm.getCountWeek());
            alarmQuery.getQueryObj().setCountType("CITY");
            alarmQuery.getQueryObj().setTimeType(alarm.getTimeType());
            alarmQuery.getQueryObj().setCarType(alarm.getCarType());
            alarmQuery.getQueryObj().setAlarmCls(alarm.getAlarmCls());
            alarmQuery.getQueryObj().setAlarmTypeDesc(alarm.getAlarmTypeDesc());
            alarmQuery.getQueryObj().setCountMonth(alarm.getCountMonth());
            alarmQuery.getQueryObj().setYearNum(alarm.getYearNum());
            if(timeType != null && timeType.equals("DAY")){
                alarmQuery.getQueryObj().setCountDate(alarm.getCountDate());
            }
            BigdataFenxiAlarm alarmUpdate = service.selectVoForWeekOrMonth(alarmQuery);
            if(alarmUpdate != null){
                alarmUpdate.setAlarmNum(analysisWarningTypeCount);
                alarmUpdate.setCountDate(countDate);
                alarmUpdate.setUpdateTime(new Date());
                service.update(alarmUpdate);
            }else{
                service.insert(alarm);
            }
        }else{
            for(int i=0;i<xianquIdArr.length;i++){
                String xianquId = xianquIdArr[i];
                safetyWarningQuery.getQueryObj().setXianquId(xianquId);
                analysisWarningTypeCount = safetyWarningService.selectWarningTypeCountByQuery(safetyWarningQuery);
                alarm.setId(Guid.guid());
                alarm.setCreateTime(new Date());
                alarm.setUpdateTime(new Date());
                alarm.setAlarmNum(analysisWarningTypeCount);
                alarm.setCountType("XIANQU");
                alarm.setXianquId(xianquId);
                alarm.setXianquName(xianquNameArr[i]);
                Integer countDate = alarm.getCountDate();
                BigdataFenxiAlarmQuery alarmQuery = new BigdataFenxiAlarmQuery();
                alarmQuery.getQueryObj().setCountWeek(alarm.getCountWeek());
                alarmQuery.getQueryObj().setCountType("XIANQU");
                alarmQuery.getQueryObj().setTimeType(alarm.getTimeType());
                alarmQuery.getQueryObj().setXianquId(alarm.getXianquId());
                alarmQuery.getQueryObj().setCarType(alarm.getCarType());
                alarmQuery.getQueryObj().setAlarmCls(alarm.getAlarmCls());
                alarmQuery.getQueryObj().setAlarmTypeDesc(alarm.getAlarmTypeDesc());
                alarmQuery.getQueryObj().setCountMonth(alarm.getCountMonth());
                alarmQuery.getQueryObj().setYearNum(alarm.getYearNum());
                if(timeType != null && timeType.equals("DAY")){
                    alarmQuery.getQueryObj().setCountDate(countDate);
                }
                BigdataFenxiAlarm alarmUpdate = service.selectVoForWeekOrMonth(alarmQuery);
                if(alarmUpdate != null){
                    alarmUpdate.setAlarmNum(analysisWarningTypeCount);
                    alarmUpdate.setCountDate(countDate);
                    alarmUpdate.setUpdateTime(new Date());
                    service.update(alarmUpdate);
                }else{
                    service.insert(alarm);
                }
            }
        }

    }

    //根据日期查询一周的报警数量 常规报警
    public void setAlarmTypeForWeekCg(BigdataAlarmRecordQuery query,Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        //获取本周的第一天日期
        calendar.add(Calendar.DAY_OF_YEAR,(2-weekDay));
        Date dateStart = calendar.getTime();
        int countMonth = Integer.parseInt(sdfMonth.format(dateStart));
        query.getQueryObj().setCountMonth(countMonth);
        int countDateStart = Integer.parseInt(sdfDay.format(dateStart));
        query.setWeekDateStart(countDateStart);
        //获取本周的最后一天日期
        calendar.add(Calendar.DAY_OF_YEAR,6);
        Date dateEnd = calendar.getTime();
        int countMonthEnd = Integer.parseInt(sdfDay.format(dateEnd));
        query.setWeekDateEnd(countMonthEnd);
    }

    //根据日期查询一周的报警数量 主动安全
    public void setAlarmTypeQueryForWeekZdaq(BigdataSafetyWarningQuery query,Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        //获取本周的第一天日期
        calendar.add(Calendar.DAY_OF_YEAR,(2-weekDay));
        Date dateStart = calendar.getTime();
        int countMonth = Integer.parseInt(sdfMonth.format(dateStart));
        query.getQueryObj().setCountMonth(countMonth);
        int countDateStart = Integer.parseInt(sdfDay.format(dateStart));
        query.setWeekDateStart(countDateStart);
        //获取本周的最后一天日期
        calendar.add(Calendar.DAY_OF_YEAR,6);
        Date dateEnd = calendar.getTime();
        int countMonthEnd = Integer.parseInt(sdfDay.format(dateEnd));
        query.setWeekDateEnd(countMonthEnd);
    }


}
