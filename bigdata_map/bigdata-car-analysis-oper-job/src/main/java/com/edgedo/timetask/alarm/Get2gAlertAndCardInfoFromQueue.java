package com.edgedo.timetask.alarm;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.BigdataAlarmRecord;
import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.entity.BigdataDriverCardRec;
import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.bigdata.service.BigdataBeidouCompService;
import com.edgedo.bigdata.service.BigdataDriverCardRecService;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.constant.RedisDbKeyConstant;
import com.edgedo.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangZhen
 * @description 从队列中取出 809的2g报警
 * @date 2020/2/28
 */
@ConditionalOnProperty(
        value = {"timetask.alarm.Get2gAlertAndCardInfoFromQueue.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class Get2gAlertAndCardInfoFromQueue {

    private static final Logger LOGGER = LoggerFactory.getLogger(Get2gAlertAndCardInfoFromQueue.class);

    //ip地址和运营商对象的对应
    Map<String,BigdataBeidouComp> ip2GpsComp = new HashMap<String,BigdataBeidouComp>();
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    BigdataBeidouCompService beidouCompService;
    @Autowired
    BigdataAlarmRecordService bigdataAlarmRecordService;
    @Autowired
    BigdataDriverCardRecService driverCardRecService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //下载报警
//    @Scheduled(cron = "0/3 * * * * ?")
    @Scheduled(cron = "${timetask.alarm.Get2gAlertAndCardInfoFromQueue.cron.downQueueAlert2Db}")
    public void downQueueAlert2Db(){
        while (true) {
            Object obj = redisUtil.rightPop(RedisDbKeyConstant.ALERT_2G_INFO_REC_LIST_QUEUE_KEY);
            if (obj == null) {
                return;
            }
            try {
                String json = obj.toString();
                AlertInfo info = JSONObject.parseObject(json, AlertInfo.class);
                String alarmType = info.getTYPE();
                if (!alarmType.equals("2") && !alarmType.equals("4")) {
                    continue;
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
                        bigdataAlarmRecordService.insertAcceptAlarm(alarmRecord);
                    }
                }
            }catch (Exception e){
                LOGGER.error("插入报警异常，将报警重新放入队列"  + obj,e);
                redisUtil.leftPush(RedisDbKeyConstant.ALERT_2G_INFO_REC_LIST_QUEUE_KEY,obj);
            }
        }

    }
    @Scheduled(cron = "${timetask.alarm.Get2gAlertAndCardInfoFromQueue.cron.downQueueAlert2Db}")
    public void downQueueAlert2Db_1(){
        downQueueAlert2Db();
    }
    @Scheduled(cron = "${timetask.alarm.Get2gAlertAndCardInfoFromQueue.cron.downQueueAlert2Db}")
    public void downQueueAlert2Db_2(){
        downQueueAlert2Db();
    }
   /* @Scheduled(cron = "${timetask.alarm.Get2gAlertAndCardInfoFromQueue.cron.downQueueAlert2Db}")
    public void downQueueAlert2Db_3(){
        downQueueAlert2Db();
    }
    @Scheduled(cron = "${timetask.alarm.Get2gAlertAndCardInfoFromQueue.cron.downQueueAlert2Db}")
    public void downQueueAlert2Db_4(){
        downQueueAlert2Db();
    }*/

    /**
     * @Author WangZhen
     * @Description 下载司机卡记录到数据库中
     * @Date 2020/2/28 14:39
     **/
//    @Scheduled(cron = "0/3 * * * * ?")
    @Scheduled(cron = "${timetask.alarm.Get2gAlertAndCardInfoFromQueue.cron.downDriverCardRec2Db}")
    public void downDriverCardRec2Db(){
        while(true){
            Object obj = redisUtil.rightPop(RedisDbKeyConstant.DRIVER_CARD_REC_LIST_QUEUE_KEY);
            if (obj == null) {
                return;
            }
            try {
                String json = obj.toString();
                DriverCardRec driverCardRecInfo = JSONObject.parseObject(json, DriverCardRec.class);
                String dateStr = driverCardRecInfo.getRECV_TIME();
                Date recvTime = sdf.parse(dateStr);
                Date now = new Date();
                //判断超过两小时的记录忽略
                if(now.getTime()-recvTime.getTime()>2*60*60*1000){
                    return;
                }
                String carCode = driverCardRecInfo.getCAR_CODE();
                String serverInfo = driverCardRecInfo.getSERV_INFO();
                if (serverInfo != null && serverInfo.indexOf(":") >= 0 && carCode.indexOf("冀C") >= 0) {
                    String[] strArr = serverInfo.split(":");
                    String ip = strArr[0];
                    BigdataBeidouComp beidouComp = ip2GpsComp.get(ip);
                    if (beidouComp == null) {
                        beidouComp = beidouCompService.selectByIp809Addr(ip);
                        ip2GpsComp.put(ip, beidouComp);
                    }
                    if (beidouComp != null) {
                        BigdataDriverCardRec driverCardRec1 = driverCardRecInfo.formatToBigdataDriverCarRecInfo();
                        driverCardRec1.setCompName(beidouComp.getCompName());
                        driverCardRec1.setCompId(beidouComp.getId());
                        driverCardRecService.insertAcceptDriverCardRec(driverCardRec1);
                    }
                }
            }catch (Exception e){
                LOGGER.error("插入司机卡失败"+obj,e);
                redisUtil.leftPush(RedisDbKeyConstant.DRIVER_CARD_REC_LIST_QUEUE_KEY,obj);
            }
        }
    }

    public static class AlertInfo{
        //接收时间
        private String RECV_TIME;
        //经度
        private String LONGITUDE;
        //纬度
        private String LATITUDE;
        //驾驶员姓名
        private String DRIVER_NAME;
        //上传ip
        private String SERV_INFO;
        //报警来源 1车载终端，2企业监控平台，3政府监管平台，9 其他
        private Integer WARN_SRC;
        //808报警类型 1超速 2疲劳  其他的都不要可参考809协议
        private Integer WARN_TYPE;
        //报警时间
        private String WARN_TIME;
        /*分段限速道路等级41000 高速公路,42000 国道,43000 主要大街、城市快速路,51000 省道,
44000 主要道路,45000  次要道路,52000 乡公路,53000 县乡村内部道路
54000 县乡村内部道路,47000 普通道路,49 非导航道路*/
        private String ROAD_LEVEL;
        //路段限速值
        private String ROAD_LIMIT;
        //报警速度
        private String SPEED;
        //车牌号
        private String CAR_CODE;
        //车牌颜色
        private String CAR_COLOR;
        //处理人姓名
        private String HANDLER_NAME;
        //处理时间
        private String HANDLER_TIME;
        //处理结果
        private String HANDLER_CONTENT;
        //处理类型
        private String HANDLER_TYPE;
        //报警系统主键
        private String ID;
        //报警类型 1线路报警2超速报警3紧急报警4疲劳驾驶
        private String TYPE;
        //持续时间
        private String DURATION;


        public String getRECV_TIME() {
            return RECV_TIME;
        }

        public void setRECV_TIME(String RECV_TIME) {
            this.RECV_TIME = RECV_TIME;
        }

        public String getLONGITUDE() {
            return LONGITUDE;
        }

        public void setLONGITUDE(String LONGITUDE) {
            this.LONGITUDE = LONGITUDE;
        }

        public String getLATITUDE() {
            return LATITUDE;
        }

        public void setLATITUDE(String LATITUDE) {
            this.LATITUDE = LATITUDE;
        }

        public String getDRIVER_NAME() {
            return DRIVER_NAME;
        }

        public void setDRIVER_NAME(String DRIVER_NAME) {
            this.DRIVER_NAME = DRIVER_NAME;
        }

        public String getSERV_INFO() {
            return SERV_INFO;
        }

        public void setSERV_INFO(String SERV_INFO) {
            this.SERV_INFO = SERV_INFO;
        }

        public Integer getWARN_SRC() {
            return WARN_SRC;
        }

        public void setWARN_SRC(Integer WARN_SRC) {
            this.WARN_SRC = WARN_SRC;
        }

        public Integer getWARN_TYPE() {
            return WARN_TYPE;
        }

        public void setWARN_TYPE(Integer WARN_TYPE) {
            this.WARN_TYPE = WARN_TYPE;
        }

        public String getWARN_TIME() {
            return WARN_TIME;
        }

        public void setWARN_TIME(String WARN_TIME) {
            this.WARN_TIME = WARN_TIME;
        }

        public String getROAD_LEVEL() {
            return ROAD_LEVEL;
        }

        public void setROAD_LEVEL(String ROAD_LEVEL) {
            this.ROAD_LEVEL = ROAD_LEVEL;
        }

        public String getSPEED() {
            return SPEED;
        }

        public void setSPEED(String SPEED) {
            this.SPEED = SPEED;
        }

        public String getCAR_CODE() {
            return CAR_CODE;
        }

        public void setCAR_CODE(String CAR_CODE) {
            this.CAR_CODE = CAR_CODE;
        }

        public String getCAR_COLOR() {
            return CAR_COLOR;
        }

        public void setCAR_COLOR(String CAR_COLOR) {
            this.CAR_COLOR = CAR_COLOR;
        }

        public String getHANDLER_NAME() {
            return HANDLER_NAME;
        }

        public void setHANDLER_NAME(String HANDLER_NAME) {
            this.HANDLER_NAME = HANDLER_NAME;
        }

        public String getHANDLER_TIME() {
            return HANDLER_TIME;
        }

        public void setHANDLER_TIME(String HANDLER_TIME) {
            this.HANDLER_TIME = HANDLER_TIME;
        }

        public String getHANDLER_CONTENT() {
            return HANDLER_CONTENT;
        }

        public void setHANDLER_CONTENT(String HANDLER_CONTENT) {
            this.HANDLER_CONTENT = HANDLER_CONTENT;
        }

        public String getHANDLER_TYPE() {
            return HANDLER_TYPE;
        }

        public void setHANDLER_TYPE(String HANDLER_TYPE) {
            this.HANDLER_TYPE = HANDLER_TYPE;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public String getDURATION() {
            return DURATION;
        }

        public void setDURATION(String DURATION) {
            this.DURATION = DURATION;
        }

        public String getROAD_LIMIT() {
            return ROAD_LIMIT;
        }

        public void setROAD_LIMIT(String ROAD_LIMIT) {
            this.ROAD_LIMIT = ROAD_LIMIT;
        }

        @Override
        public String toString() {
            return "AlertInfo{" +
                    "RECV_TIME='" + RECV_TIME + '\'' +
                    ", LONGITUDE='" + LONGITUDE + '\'' +
                    ", LATITUDE='" + LATITUDE + '\'' +
                    ", DRIVER_NAME='" + DRIVER_NAME + '\'' +
                    ", SERV_INFO='" + SERV_INFO + '\'' +
                    ", WARN_SRC=" + WARN_SRC +
                    ", WARN_TYPE=" + WARN_TYPE +
                    ", WARN_TIME='" + WARN_TIME + '\'' +
                    ", ROAD_LEVEL='" + ROAD_LEVEL + '\'' +
                    ", ROAD_LIMIT='" + ROAD_LIMIT + '\'' +
                    ", SPEED='" + SPEED + '\'' +
                    ", CAR_CODE='" + CAR_CODE + '\'' +
                    ", CAR_COLOR='" + CAR_COLOR + '\'' +
                    ", HANDLER_NAME='" + HANDLER_NAME + '\'' +
                    ", HANDLER_TIME='" + HANDLER_TIME + '\'' +
                    ", HANDLER_CONTENT='" + HANDLER_CONTENT + '\'' +
                    ", HANDLER_TYPE='" + HANDLER_TYPE + '\'' +
                    ", ID='" + ID + '\'' +
                    ", TYPE='" + TYPE + '\'' +
                    ", DURATION='" + DURATION + '\'' +
                    '}';
        }

        /**
         * @Author WangZhen
         * @Description 将这个临时对象转换成大数据中的对象
         * @Date 2020/2/28 10:00
         **/
        public BigdataAlarmRecord formatToAlarm(){

            BigdataAlarmRecord bigdataAlarmRecord = new BigdataAlarmRecord();
            bigdataAlarmRecord.setRoadLevel(this.getROAD_LEVEL());
            String roadLimit = this.getROAD_LIMIT();
            bigdataAlarmRecord.setRoadSpeedLimit(roadLimit==null?null:new BigDecimal(roadLimit));
            bigdataAlarmRecord.setAlarmTimeInfo(this.getDURATION());
            Date warnTime = DateUtil.parseFullDateStr(this.getWARN_TIME());
            Date revTime = DateUtil.parseFullDateStr(this.getRECV_TIME());
            long warnTimeLong = warnTime.getTime();
            long revTimeLong = revTime.getTime();
            if(Math.abs(warnTimeLong-revTimeLong)>86400000){// 时间差超过1天
                bigdataAlarmRecord.setAlarmTime(revTime);
            }else{
                bigdataAlarmRecord.setAlarmTime(warnTime);
            }

            bigdataAlarmRecord.setLongitude(new BigDecimal(this.getLONGITUDE()));
            bigdataAlarmRecord.setLatitude(new BigDecimal(this.getLATITUDE()));
            bigdataAlarmRecord.setDriver(this.getDRIVER_NAME());
            bigdataAlarmRecord.setAlarmCls(this.getWARN_SRC()+"");

            bigdataAlarmRecord.setAlarmType(this.getTYPE()+"");
            bigdataAlarmRecord.setAlarmSpeed(new BigDecimal(this.getSPEED()));
            bigdataAlarmRecord.setCarPlateNum(this.getCAR_CODE());
            bigdataAlarmRecord.setCarPlateColor(this.getCAR_COLOR());
            bigdataAlarmRecord.setDealPerson(this.getHANDLER_NAME());
            bigdataAlarmRecord.setDealType(this.getHANDLER_TYPE());
            bigdataAlarmRecord.setDealRemark(this.getHANDLER_CONTENT());
            bigdataAlarmRecord.setBid(this.getID());
            bigdataAlarmRecord.setDealTime(
                    DateUtil.parseFullDateStr( this.getHANDLER_TIME())
            );
            //根据处理时间来判断是否处理
            return bigdataAlarmRecord;

        }

    }

    /**
     * @Author WangZhen
     * @Description 转换司机身份卡的临时类
     * @Date 2020/2/28 14:46
     **/
    private static class DriverCardRec{
        private Integer STATUS;
        private String CAR_CODE;
        private String RECV_TIME;
        private String DRIVER_NAME;
        private String DRIVER_ID;
        private String TIME;
        private String SERV_INFO;
        private String CAR_COLOR;

        public Integer getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(Integer STATUS) {
            this.STATUS = STATUS;
        }

        public String getCAR_CODE() {
            return CAR_CODE;
        }

        public void setCAR_CODE(String CAR_CODE) {
            this.CAR_CODE = CAR_CODE;
        }

        public String getRECV_TIME() {
            return RECV_TIME;
        }

        public void setRECV_TIME(String RECV_TIME) {
            this.RECV_TIME = RECV_TIME;
        }

        public String getDRIVER_NAME() {
            return DRIVER_NAME;
        }

        public void setDRIVER_NAME(String DRIVER_NAME) {
            this.DRIVER_NAME = DRIVER_NAME;
        }

        public String getDRIVER_ID() {
            return DRIVER_ID;
        }

        public void setDRIVER_ID(String DRIVER_ID) {
            this.DRIVER_ID = DRIVER_ID;
        }

        public String getTIME() {
            return TIME;
        }

        public void setTIME(String TIME) {
            this.TIME = TIME;
        }

        public String getSERV_INFO() {
            return SERV_INFO;
        }

        public void setSERV_INFO(String SERV_INFO) {
            this.SERV_INFO = SERV_INFO;
        }

        public String getCAR_COLOR() {
            return CAR_COLOR;
        }

        public void setCAR_COLOR(String CAR_COLOR) {
            this.CAR_COLOR = CAR_COLOR;
        }

        @Override
        public String toString() {
            return "DriverCardRec{" +
                    "STATUS=" + STATUS +
                    ", CAR_CODE='" + CAR_CODE + '\'' +
                    ", RECV_TIME='" + RECV_TIME + '\'' +
                    ", DRIVER_NAME='" + DRIVER_NAME + '\'' +
                    ", DRIVER_ID='" + DRIVER_ID + '\'' +
                    ", TIME='" + TIME + '\'' +
                    ", SERV_INFO='" + SERV_INFO + '\'' +
                    ", CAR_COLOR='" + CAR_COLOR + '\'' +
                    '}';
        }

        /**
         * @Author WangZhen
         * @Description 将对象转换成 大数据的bigdate
         * @Date 2020/2/28 14:52
         **/
        public BigdataDriverCardRec formatToBigdataDriverCarRecInfo() {
            BigdataDriverCardRec driverCardRec = new BigdataDriverCardRec();
            driverCardRec.setRecType(this.getSTATUS()+"");
            driverCardRec.setCarPlateNum(this.getCAR_CODE());
            driverCardRec.setCarPlateColor(this.getCAR_COLOR());
//            driverCardRec.setBid(null);
            Date revTime = DateUtil.parseFullDateStr(this.getRECV_TIME());
            Date tim =  DateUtil.parseFullDateStr(this.getTIME());

            long revTimeLong = revTime.getTime();
            long timLong = tim.getTime();
            if(Math.abs(revTimeLong-timLong)>86400000){// 时间差超过1天
                driverCardRec.setCardTime(revTime);
            }else{
                driverCardRec.setCardTime(tim);
            }

            driverCardRec.setDriverName(this.getDRIVER_NAME());
            driverCardRec.setLicenceNum(this.getDRIVER_ID());
            return driverCardRec;
        }

    }

}
