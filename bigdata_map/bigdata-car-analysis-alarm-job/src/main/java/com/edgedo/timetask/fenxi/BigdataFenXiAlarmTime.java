package com.edgedo.timetask.fenxi;

import com.edgedo.bigdata.entity.BigdataFenxiAlarmTime;
import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.bigdata.service.BigdataFenxiAlarmTimeService;
import com.edgedo.bigdata.service.BigdataSafetyWarningService;
import com.edgedo.common.util.Guid;
import com.edgedo.sys.service.SysXianquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 *  大数据报警时段统计(一天的每个小时的记录) bigdata_fenxi_alarm_time
 *  大数据报警周月统计(7天和30天) bigdata_fenxi_count
 *  报警数量 (全部   常规报警-bigdata_alarm_record   主动安全-bigdata_safety_warning)
 *  处理数量 (全部   常规报警-bigdata_alarm_record   主动安全-bigdata_safety_warning)
 */

@Component
public class BigdataFenXiAlarmTime {

    @Autowired
    private BigdataAlarmRecordService bigdataAlarmRecordService;

    @Autowired
    private BigdataSafetyWarningService bigdataSafetyWarningService;
    @Autowired
    private BigdataFenxiAlarmTimeService bigdataFenxiAlarmTimeService;
    @Autowired
    private SysXianquService sysXianquService;


    //bigdata_fenxi_alarm_time 一天的数据  查出统计时间  对应当天的时段
    @Scheduled(cron = "0 0 3 * * ?")//0/2 * * * * ?每天九点更新0 0 9 * * ?
    public void countAlarmAndSafeDay(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,-1);
        date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);
        String[] str = dateStr.split("-");// 2019  09 08
        Integer yearNum = new Integer(str[0]);//年
        Integer countMonth = new Integer(str[0]+str[1]);//月
        Integer countDay = new Integer(str[0]+str[1]+str[2]);//日
        //1.先从表中查出当天数据 bigdata_alarm_record bigdata_safety_warning
        //主动安全插入
        String[] xianQuId = {"130302","130371","130321","130304","130322","130324","130303","130306",""};
        String[] carType = {"普货","总","危货","客运"};
        for (String strXianQuId :xianQuId){
            for(String strCarType :carType){
                setSafetyInsert(yearNum,countMonth, countDay,strXianQuId,strCarType);
            }
        }
        //常规 插入
        for (String strXianQuId :xianQuId){
            for(String strCarType :carType){
                setAlarmInsert(yearNum,countMonth, countDay,strXianQuId,strCarType);
            }
        }
        //int num1 = bigdataAlarmRecordMapper.selectAlarmNumAndHandlerDay(yearNum,countMonth,countDay,"06:00","07:00");

        for (String strXianQuId :xianQuId){
            for(String strCarType :carType){
                SetAllInsert(yearNum,countMonth, countDay,strXianQuId,strCarType);
            }
        }
    }


    //全部报警 处理
    private void SetAllInsert(Integer yearNum, Integer countMonth, Integer countDay, String xianQuId, String carType) {
        String[] time = {"00:00-01:00", "01:00-02:00", "02:00-03:00", "03:00-04:00", "04:00-05:00", "05:00-06:00",
                "06:00-07:00","07:00-08:00","08:00-09:00","09:00-10:00","10:00-11:00","11:00-12:00",
                "12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00","17:00-18:00",
                "18:00-19:00","19:00-20:00","20:00-21:00","21:00-22:00","22:00-23:00","23:00-24:00"};
        BigdataFenxiAlarmTime bigdataFenxiAlarmTimeSafetyAlarm = new BigdataFenxiAlarmTime();//常规报警
        bigdataFenxiAlarmTimeSafetyAlarm.setId(Guid.guid());//主键
        bigdataFenxiAlarmTimeSafetyAlarm.setCreateTime(new Date());//创建时间
        bigdataFenxiAlarmTimeSafetyAlarm.setAlarmType("全部");//报警分类
        bigdataFenxiAlarmTimeSafetyAlarm.setDataType("报警");//数据类型
        bigdataFenxiAlarmTimeSafetyAlarm.setCarType(carType);//车辆类型
        bigdataFenxiAlarmTimeSafetyAlarm.setCountDate(countDay);
        bigdataFenxiAlarmTimeSafetyAlarm.setCountMonth(countMonth);
        bigdataFenxiAlarmTimeSafetyAlarm.setYearNum(yearNum);
        BigdataFenxiAlarmTime bigdataFenxiAlarmTimeSafetyHandler = new BigdataFenxiAlarmTime();//常规处理
        bigdataFenxiAlarmTimeSafetyHandler.setId(Guid.guid());//主键
        bigdataFenxiAlarmTimeSafetyHandler.setCreateTime(new Date());//创建时间
        bigdataFenxiAlarmTimeSafetyHandler.setAlarmType("全部");//报警分类
        bigdataFenxiAlarmTimeSafetyHandler.setDataType("处理");//数据类型
        bigdataFenxiAlarmTimeSafetyHandler.setCarType(carType);//车辆类型
        bigdataFenxiAlarmTimeSafetyHandler.setCountDate(countDay);
        bigdataFenxiAlarmTimeSafetyHandler.setCountMonth(countMonth);
        bigdataFenxiAlarmTimeSafetyHandler.setYearNum(yearNum);
        if(xianQuId.equals("")){
            bigdataFenxiAlarmTimeSafetyAlarm.setCountType("CITY");
            bigdataFenxiAlarmTimeSafetyHandler.setCountType("CITY");
            //1.遍历循环
            for(String date : time){
                String[] str = date.split("-");
                int alarmNum = bigdataAlarmRecordService.selectAlarm(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int handlerNum =  bigdataAlarmRecordService.selectHandler(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int alarmNumSafety = bigdataSafetyWarningService.selectAlarmNumDay(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int handlerNumSafety =  bigdataSafetyWarningService.selectHandlerDay(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int allAlarmNum = alarmNum+alarmNumSafety;
                int allSafety = handlerNum+handlerNumSafety;
                setTimeNum(bigdataFenxiAlarmTimeSafetyAlarm,bigdataFenxiAlarmTimeSafetyHandler,date,allAlarmNum,allSafety);
            }
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceId("HEBEI");
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceName("河北省");
            bigdataFenxiAlarmTimeSafetyAlarm.setCityId("130300");
            bigdataFenxiAlarmTimeSafetyAlarm.setCityName("秦皇岛市");
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceId("HEBEI");
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceName("河北省");
            bigdataFenxiAlarmTimeSafetyHandler.setCityId("130300");
            bigdataFenxiAlarmTimeSafetyHandler.setCityName("秦皇岛市");
        }else {
            bigdataFenxiAlarmTimeSafetyAlarm.setCountType("XIANQU");//区域统计
            bigdataFenxiAlarmTimeSafetyHandler.setCountType("XIANQU");
            //1.遍历循环
            for(String date : time){
                String[] str = date.split("-");
                int alarmNum = bigdataAlarmRecordService.selectAlarm(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int handlerNum =  bigdataAlarmRecordService.selectHandler(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int alarmNumSafety = bigdataSafetyWarningService.selectAlarmNumDay(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int handlerNumSafety =  bigdataSafetyWarningService.selectHandlerDay(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int allAlarmNum = alarmNum+alarmNumSafety;
                int allSafety = handlerNum+handlerNumSafety;
                setTimeNum(bigdataFenxiAlarmTimeSafetyAlarm,bigdataFenxiAlarmTimeSafetyHandler,date,allAlarmNum,allSafety);
            }
            Map<String,String> map = bigdataAlarmRecordService.selectCountType(countMonth,countDay,xianQuId,carType);
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceId(map.get("provinceId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceName(map.get("provinceName"));
            bigdataFenxiAlarmTimeSafetyAlarm.setCityId(map.get("cityId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setCityName(map.get("cityName"));
            bigdataFenxiAlarmTimeSafetyAlarm.setXianquId(map.get("xianquId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setXianquName(map.get("xianquName"));
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceId(map.get("provinceId"));
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceName(map.get("provinceName"));
            bigdataFenxiAlarmTimeSafetyHandler.setCityId(map.get("cityId"));
            bigdataFenxiAlarmTimeSafetyHandler.setCityName(map.get("cityName"));
            bigdataFenxiAlarmTimeSafetyHandler.setXianquId(map.get("xianquId"));
            bigdataFenxiAlarmTimeSafetyHandler.setXianquName(map.get("xianquName"));
        }
        //查询是否存在
        int flag = bigdataFenxiAlarmTimeService.selectByCountAll(yearNum,countMonth,countDay,xianQuId,carType,"处理","全部");
        int flag1 = bigdataFenxiAlarmTimeService.selectByCountAll(yearNum,countMonth,countDay,xianQuId,carType,"报警","全部");
        if(flag==0 && flag1==0){
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyHandler);
        }else if (flag==1 && flag1==0){
            bigdataFenxiAlarmTimeSafetyHandler.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyHandler);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyAlarm);
        }else if (flag==0 && flag1==1){
            bigdataFenxiAlarmTimeSafetyAlarm.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyHandler);
        }else {
            bigdataFenxiAlarmTimeSafetyAlarm.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeSafetyHandler.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyHandler);
        }
    }




    //常规报警 处理
    private void setAlarmInsert(Integer yearNum, Integer countMonth, Integer countDay, String xianQuId, String carType) {
        String[] time = {"00:00-01:00", "01:00-02:00", "02:00-03:00", "03:00-04:00", "04:00-05:00", "05:00-06:00",
                "06:00-07:00","07:00-08:00","08:00-09:00","09:00-10:00","10:00-11:00","11:00-12:00",
                "12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00","17:00-18:00",
                "18:00-19:00","19:00-20:00","20:00-21:00","21:00-22:00","22:00-23:00","23:00-24:00"};
        BigdataFenxiAlarmTime bigdataFenxiAlarmTimeSafetyAlarm = new BigdataFenxiAlarmTime();//常规报警
        bigdataFenxiAlarmTimeSafetyAlarm.setId(Guid.guid());//主键
        bigdataFenxiAlarmTimeSafetyAlarm.setCreateTime(new Date());//创建时间
        bigdataFenxiAlarmTimeSafetyAlarm.setAlarmType("常规");//报警分类
        bigdataFenxiAlarmTimeSafetyAlarm.setDataType("报警");//数据类型
        bigdataFenxiAlarmTimeSafetyAlarm.setCarType(carType);//车辆类型
        bigdataFenxiAlarmTimeSafetyAlarm.setCountDate(countDay);
        bigdataFenxiAlarmTimeSafetyAlarm.setCountMonth(countMonth);
        bigdataFenxiAlarmTimeSafetyAlarm.setYearNum(yearNum);
        BigdataFenxiAlarmTime bigdataFenxiAlarmTimeSafetyHandler = new BigdataFenxiAlarmTime();//常规处理
        bigdataFenxiAlarmTimeSafetyHandler.setId(Guid.guid());//主键
        bigdataFenxiAlarmTimeSafetyHandler.setCreateTime(new Date());//创建时间
        bigdataFenxiAlarmTimeSafetyHandler.setAlarmType("常规");//报警分类
        bigdataFenxiAlarmTimeSafetyHandler.setDataType("处理");//数据类型
        bigdataFenxiAlarmTimeSafetyHandler.setCarType(carType);//车辆类型
        bigdataFenxiAlarmTimeSafetyHandler.setCountDate(countDay);
        bigdataFenxiAlarmTimeSafetyHandler.setCountMonth(countMonth);
        bigdataFenxiAlarmTimeSafetyHandler.setYearNum(yearNum);
        if(xianQuId.equals("")){
            bigdataFenxiAlarmTimeSafetyAlarm.setCountType("CITY");
            bigdataFenxiAlarmTimeSafetyHandler.setCountType("CITY");
            //1.遍历循环
            for(String date : time){
                String[] str = date.split("-");
                int alarmNum = bigdataAlarmRecordService.selectAlarm(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int handlerNum =  bigdataAlarmRecordService.selectHandler(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                setTimeNum(bigdataFenxiAlarmTimeSafetyAlarm,bigdataFenxiAlarmTimeSafetyHandler,date,alarmNum,handlerNum);
            }
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceId("HEBEI");
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceName("河北省");
            bigdataFenxiAlarmTimeSafetyAlarm.setCityId("130300");
            bigdataFenxiAlarmTimeSafetyAlarm.setCityName("秦皇岛市");
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceId("HEBEI");
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceName("河北省");
            bigdataFenxiAlarmTimeSafetyHandler.setCityId("130300");
            bigdataFenxiAlarmTimeSafetyHandler.setCityName("秦皇岛市");
        }else {
            bigdataFenxiAlarmTimeSafetyAlarm.setCountType("XIANQU");//区域统计
            bigdataFenxiAlarmTimeSafetyHandler.setCountType("XIANQU");
            //1.遍历循环
            for(String date : time){
                String[] str = date.split("-");
                int alarmNum = bigdataAlarmRecordService.selectAlarm(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int handlerNum =  bigdataAlarmRecordService.selectHandler(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                setTimeNum(bigdataFenxiAlarmTimeSafetyAlarm,bigdataFenxiAlarmTimeSafetyHandler,date,alarmNum,handlerNum);
            }
            Map<String,String> map = bigdataAlarmRecordService.selectCountType(countMonth,countDay,xianQuId,carType);
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceId(map.get("provinceId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceName(map.get("provinceName"));
            bigdataFenxiAlarmTimeSafetyAlarm.setCityId(map.get("cityId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setCityName(map.get("cityName"));
            bigdataFenxiAlarmTimeSafetyAlarm.setXianquId(map.get("xianquId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setXianquName(map.get("xianquName"));
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceId(map.get("provinceId"));
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceName(map.get("provinceName"));
            bigdataFenxiAlarmTimeSafetyHandler.setCityId(map.get("cityId"));
            bigdataFenxiAlarmTimeSafetyHandler.setCityName(map.get("cityName"));
            bigdataFenxiAlarmTimeSafetyHandler.setXianquId(map.get("xianquId"));
            bigdataFenxiAlarmTimeSafetyHandler.setXianquName(map.get("xianquName"));
        }
        //查询是否存在
        int flag = bigdataFenxiAlarmTimeService.selectByCountChangGui(yearNum,countMonth,countDay,xianQuId,carType,"处理","常规");
        int flag1 = bigdataFenxiAlarmTimeService.selectByCountChangGui(yearNum,countMonth,countDay,xianQuId,carType,"报警","常规");
        if(flag==0 && flag1==0){
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyHandler);
        }else if (flag==1 && flag1==0){
            bigdataFenxiAlarmTimeSafetyHandler.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyHandler);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyAlarm);
        }else if (flag==0 && flag1==1){
            bigdataFenxiAlarmTimeSafetyAlarm.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyHandler);
        }else {
            bigdataFenxiAlarmTimeSafetyAlarm.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeSafetyHandler.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyHandler);
        }
    }


    private void setSafetyInsert(Integer yearNum, Integer countMonth, Integer countDay, String xianQuId, String carType) {
        String[] time = {"00:00-01:00", "01:00-02:00", "02:00-03:00", "03:00-04:00", "04:00-05:00", "05:00-06:00",
                "06:00-07:00","07:00-08:00","08:00-09:00","09:00-10:00","10:00-11:00","11:00-12:00",
                "12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00","17:00-18:00",
                "18:00-19:00","19:00-20:00","20:00-21:00","21:00-22:00","22:00-23:00","23:00-24:00"};
        BigdataFenxiAlarmTime bigdataFenxiAlarmTimeSafetyAlarm = new BigdataFenxiAlarmTime();//主动报警
        bigdataFenxiAlarmTimeSafetyAlarm.setId(Guid.guid());//主键
        bigdataFenxiAlarmTimeSafetyAlarm.setCreateTime(new Date());//创建时间
        bigdataFenxiAlarmTimeSafetyAlarm.setAlarmType("安全");//报警分类
        bigdataFenxiAlarmTimeSafetyAlarm.setDataType("报警");//数据类型
        bigdataFenxiAlarmTimeSafetyAlarm.setCarType(carType);//车辆类型
        bigdataFenxiAlarmTimeSafetyAlarm.setCountDate(countDay);
        bigdataFenxiAlarmTimeSafetyAlarm.setCountMonth(countMonth);
        bigdataFenxiAlarmTimeSafetyAlarm.setYearNum(yearNum);
        BigdataFenxiAlarmTime bigdataFenxiAlarmTimeSafetyHandler = new BigdataFenxiAlarmTime();//主动处理
        bigdataFenxiAlarmTimeSafetyHandler.setId(Guid.guid());//主键
        bigdataFenxiAlarmTimeSafetyHandler.setCreateTime(new Date());//创建时间
        bigdataFenxiAlarmTimeSafetyHandler.setAlarmType("安全");//报警分类
        bigdataFenxiAlarmTimeSafetyHandler.setDataType("处理");//数据类型
        bigdataFenxiAlarmTimeSafetyHandler.setCarType(carType);//车辆类型
        bigdataFenxiAlarmTimeSafetyHandler.setCountDate(countDay);
        bigdataFenxiAlarmTimeSafetyHandler.setCountMonth(countMonth);
        bigdataFenxiAlarmTimeSafetyHandler.setYearNum(yearNum);
        if(xianQuId.equals("")){
            bigdataFenxiAlarmTimeSafetyAlarm.setCountType("CITY");
            bigdataFenxiAlarmTimeSafetyHandler.setCountType("CITY");
            //1.遍历循环
            for(String date : time){
                String[] str = date.split("-");
                int alarmNum = bigdataSafetyWarningService.selectAlarmNumDay(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int handlerNum =  bigdataSafetyWarningService.selectHandlerDay(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                setTimeNum(bigdataFenxiAlarmTimeSafetyAlarm,bigdataFenxiAlarmTimeSafetyHandler,date,alarmNum,handlerNum);
            }
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceId("HEBEI");
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceName("河北省");
            bigdataFenxiAlarmTimeSafetyAlarm.setCityId("130300");
            bigdataFenxiAlarmTimeSafetyAlarm.setCityName("秦皇岛市");
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceId("HEBEI");
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceName("河北省");
            bigdataFenxiAlarmTimeSafetyHandler.setCityId("130300");
            bigdataFenxiAlarmTimeSafetyHandler.setCityName("秦皇岛市");
        }else {
            bigdataFenxiAlarmTimeSafetyAlarm.setCountType("XIANQU");//区域统计
            bigdataFenxiAlarmTimeSafetyHandler.setCountType("XIANQU");
            //1.遍历循环
            for(String date : time){
                String[] str = date.split("-");
                int alarmNum = bigdataSafetyWarningService.selectAlarmNumDay(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                int handlerNum =  bigdataSafetyWarningService.selectHandlerDay(yearNum,countMonth,
                        countDay,xianQuId,carType,str[0],str[1]);
                setTimeNum(bigdataFenxiAlarmTimeSafetyAlarm,bigdataFenxiAlarmTimeSafetyHandler,date,alarmNum,handlerNum);
            }
            Map<String,String> map = bigdataAlarmRecordService.selectCountType(countMonth,countDay,xianQuId,carType);
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceId(map.get("provinceId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setProvinceName(map.get("provinceName"));
            bigdataFenxiAlarmTimeSafetyAlarm.setCityId(map.get("cityId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setCityName(map.get("cityName"));
            bigdataFenxiAlarmTimeSafetyAlarm.setXianquId(map.get("xianquId"));
            bigdataFenxiAlarmTimeSafetyAlarm.setXianquName(map.get("xianquName"));
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceId(map.get("provinceId"));
            bigdataFenxiAlarmTimeSafetyHandler.setProvinceName(map.get("provinceName"));
            bigdataFenxiAlarmTimeSafetyHandler.setCityId(map.get("cityId"));
            bigdataFenxiAlarmTimeSafetyHandler.setCityName(map.get("cityName"));
            bigdataFenxiAlarmTimeSafetyHandler.setXianquId(map.get("xianquId"));
            bigdataFenxiAlarmTimeSafetyHandler.setXianquName(map.get("xianquName"));
        }
        //查询是否存在
        int flag = bigdataFenxiAlarmTimeService.selectByCount(yearNum,countMonth,countDay,xianQuId,carType,"处理","安全");
        int flag1 = bigdataFenxiAlarmTimeService.selectByCount(yearNum,countMonth,countDay,xianQuId,carType,"报警","安全");
        if(flag==0 && flag1==0){
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyHandler);
        }else if (flag==1 && flag1==0){
            bigdataFenxiAlarmTimeSafetyHandler.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyHandler);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyAlarm);
        }else if (flag==0 && flag1==1){
            bigdataFenxiAlarmTimeSafetyAlarm.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.insert(bigdataFenxiAlarmTimeSafetyHandler);
        }else {
            bigdataFenxiAlarmTimeSafetyAlarm.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeSafetyHandler.setUpdateTime(new Date());
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyAlarm);
            bigdataFenxiAlarmTimeService.updateRecord(bigdataFenxiAlarmTimeSafetyHandler);
        }
    }


    private void setTimeNum(BigdataFenxiAlarmTime bigdataFenxiAlarmTimeSafetyAlarm,
                            BigdataFenxiAlarmTime bigdataFenxiAlarmTimeSafetyHandler,
                            String date, int alarmNum, int handlerNum) {
        if(date.equals("00:00-01:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setZeroOne(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setZeroOne(handlerNum);
        }else if(date.equals("01:00-02:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setOneTwo(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setOneTwo(handlerNum);
        }else if(date.equals("02:00-03:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setTwoThree(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setTwoThree(handlerNum);
        }else if(date.equals("03:00-04:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setThreeFour(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setThreeFour(handlerNum);
        }else if(date.equals("04:00-05:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setFourFive(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setFourFive(handlerNum);
        }else if(date.equals("05:00-06:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setFiveSix(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setFiveSix(handlerNum);
        }else if(date.equals("06:00-07:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setSixSeven(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setSixSeven(handlerNum);
        }else if(date.equals("07:00-08:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setSevenEight(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setSevenEight(handlerNum);
        }else if(date.equals("08:00-09:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setEightNine(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setEightNine(handlerNum);
        }else if(date.equals("09:00-10:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setNineTen(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setNineTen(handlerNum);
        }else if(date.equals("10:00-11:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setTenEleven(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setTenEleven(handlerNum);
        }else if(date.equals("11:00-12:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setElevenTwelve(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setElevenTwelve(handlerNum);
        }else if(date.equals("12:00-13:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setTwelveThirteen(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setTwelveThirteen(handlerNum);
        }else if(date.equals("13:00-14:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setThirteenFourteen(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setThirteenFourteen(handlerNum);
        }else if(date.equals("14:00-15:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setFourteenFifteen(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setFourteenFifteen(handlerNum);
        }else if(date.equals("15:00-16:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setFifteenSixteen(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setFifteenSixteen(handlerNum);
        }else if(date.equals("16:00-17:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setSixteenSeventeen(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setSixteenSeventeen(handlerNum);
        }else if(date.equals("17:00-18:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setSeventeenEighteen(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setSeventeenEighteen(handlerNum);
        }else if(date.equals("18:00-19:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setEighteenNineteen(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setEighteenNineteen(handlerNum);
        }else if(date.equals("19:00-20:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setNineteenTwenty(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setNineteenTwenty(handlerNum);
        }else if(date.equals("20:00-21:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setTwentyTwentyone(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setTwentyTwentyone(handlerNum);
        }else if(date.equals("21:00-22:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setTwentyoneTwentytwo(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setTwentyoneTwentytwo(handlerNum);
        }else if(date.equals("22:00-23:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setTwentytwoTwentythree(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setTwentytwoTwentythree(handlerNum);
        }else if(date.equals("23:00-24:00")){
            bigdataFenxiAlarmTimeSafetyAlarm.setTwentythreeTwentyfour(alarmNum);
            bigdataFenxiAlarmTimeSafetyHandler.setTwentythreeTwentyfour(handlerNum);
        }
    }

}
