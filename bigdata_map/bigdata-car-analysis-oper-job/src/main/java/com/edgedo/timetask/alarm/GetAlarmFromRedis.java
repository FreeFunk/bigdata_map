package com.edgedo.timetask.alarm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.bigdata.service.BigdataBeidouCompService;
import com.edgedo.bigdata.service.BigdataSafetyWarningFileService;
import com.edgedo.bigdata.service.BigdataSafetyWarningService;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.util.RedisUtil;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName GetAlarmFromRedis
 * @Description 从redis中获取天地通的主动安全报警信息和附件
 * @Author 床前明月光
 * @Date 2019/10/24 14:41
 **/
@ConditionalOnProperty(
        value = {"timetask.alarm.GetAlarmFromRedis.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class GetAlarmFromRedis {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    BigdataSafetyWarningService bigdataSafetyWarningService;
    @Autowired
    BigdataSafetyWarningFileService bigdataSafetyWarningFileService;
    @Autowired
    BigdataBeidouCompService bigdataBeidouCompService;
    @Autowired
    CarInfoService carInfoService;

    SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
    //报警列表
    String key = "alarmList";
    //报警临时
    String keyTemp = "alarmListTemp";

    String attachRequestKey = "attachRequest";
    //附件
    String safeFileKey = "attachList";
    //报警时间（分表）
    String alarmTimeKey = "ALARM_TIME_KEY";

    //从缓存中获取天地通的主动安全报警
    //@Scheduled(cron = "0/30 * * * * ?")
    @Scheduled(cron = "${timetask.alarm.GetAlarmFromRedis.cron.getAlarm}")
    public void getAlarm(){
        while(true){
            Object obj = redisUtil.rightPop(key);
            if(obj==null){
                return;
            }
            try {
                String jsonStr= obj.toString();
                AlarmInfo alarmInfo = JSON.parseObject(jsonStr, AlarmInfo.class);//json字符串转对象
                String sessionKey = alarmInfo.getSESSION_KEY();
                String servIp ="";
                if(sessionKey!=null && !sessionKey.equals("") && sessionKey.contains(":")){
                    servIp = sessionKey.split(":")[0];
                }else {
                    continue;
                }
                BigdataBeidouCompView bigdataBeidouCompView = bigdataBeidouCompService.selectByIp809Addr(servIp);
                if(bigdataBeidouCompView!=null){
                    BigdataSafetyWarning bigdataSafetyWarning = new BigdataSafetyWarning();
                    bigdataSafetyWarning.setCreateTime(new Date());
                    String compId = bigdataBeidouCompView.getId();
                    bigdataSafetyWarning.setCompId(compId);
                    bigdataSafetyWarning.setCompName(bigdataBeidouCompView.getCompName());
                    bigdataSafetyWarning.setBid(alarmInfo.getALARM_ID());
                    bigdataSafetyWarning.setLon(alarmInfo.getLONGITUDE());
                    bigdataSafetyWarning.setLat(alarmInfo.getLATITUDE());
                    String speed = alarmInfo.getSPEED().substring(2,4);
                    long dec_num = Long.parseLong(speed, 16);
                    bigdataSafetyWarning.setSpeed(new BigDecimal(dec_num));
                    bigdataSafetyWarning.setStarttime(alarmInfo.getWARN_TIME());
                    //查询车辆信息
                    CarInfo carInfo = carInfoService.loadById(alarmInfo.getCAR_CODE()+"_"+alarmInfo.getCAR_COLOR());
                    if(carInfo!=null) {
                        bigdataSafetyWarning.setCarPlateNum(carInfo.getCarPlateNum());
                        bigdataSafetyWarning.setCarFrameNum(carInfo.getCarFrameNum());
                        bigdataSafetyWarning.setCarPlateColor(carInfo.getCarPlateColour());
                        bigdataSafetyWarning.setCarPlateColorText(carInfo.getCarPlateColorText());
                        bigdataSafetyWarning.setCarType(carInfo.getCarType());
                        bigdataSafetyWarning.setEmpCode(carInfo.getEmpCode());
                        bigdataSafetyWarning.setEmpIdCard(carInfo.getEmpCode());
                        bigdataSafetyWarning.setEmpName(carInfo.getEmpPhone());
                        bigdataSafetyWarning.setEmpId(carInfo.getEmpId());
                        bigdataSafetyWarning.setOwnerTeamId(carInfo.getOwnerTeamId());
                        bigdataSafetyWarning.setOwnerTeamName(carInfo.getOwnerTeamName());
                        bigdataSafetyWarning.setProvinceId(carInfo.getProvinceId());
                        bigdataSafetyWarning.setProvinceName(carInfo.getProvinceName());
                        bigdataSafetyWarning.setCityId(carInfo.getCityId());
                        bigdataSafetyWarning.setCityName(carInfo.getCityName());
                        bigdataSafetyWarning.setXianquId(carInfo.getXianquId());
                        bigdataSafetyWarning.setXianquName(carInfo.getXianquName());

                        bigdataSafetyWarning.setUploadTime(alarmInfo.getRECV_TIME());

                        String HANDLER_NAME = alarmInfo.getHANDLER_NAME();

                        Date HANDLER_TIME= alarmInfo.getHANDLER_TIME();

                        String HANDLER_CONTENT= alarmInfo.getHANDLER_CONTENT();

                        String HANDLER_TYPE= alarmInfo.getHANDLER_TYPE();
                        if(
                                (HANDLER_NAME!=null&&HANDLER_NAME.length()>0) ||
                                HANDLER_TIME!=null ||
                                (HANDLER_CONTENT!=null&&HANDLER_CONTENT.length()>0) ||
                                (HANDLER_TYPE!=null&&HANDLER_TYPE.length()>0)
                        ){
                            bigdataSafetyWarning.setAlarmState("处理");
                            bigdataSafetyWarning.setHandleState("已处理");
                            bigdataSafetyWarning.setHandleTime(HANDLER_TIME);
                            bigdataSafetyWarning.setHandleType(HANDLER_TYPE);
                            bigdataSafetyWarning.setHandlePeople(HANDLER_NAME);
                            bigdataSafetyWarning.setDetailInfo(HANDLER_CONTENT);
                        }else{
                            bigdataSafetyWarning.setAlarmState("开始");
                            bigdataSafetyWarning.setHandleState("未处理");
                        }

                        bigdataSafetyWarning.setWarningInfo("");
                        String markStatus = alarmInfo.getMARK_STATUS();
                        //add by wangzhen  20200623 解决大小写问题
                        markStatus = markStatus.toUpperCase();
                        if (markStatus.equals("0X01") || markStatus.equals("0X00")) {
                            bigdataSafetyWarning.setStarttime(alarmInfo.getWARN_TIME());
                        } else if (markStatus.equals("0X02")) {
                            bigdataSafetyWarning.setEndtime(alarmInfo.getWARN_TIME());
                        }
                        String dateIntStr = sdfDateInt.format(alarmInfo.getWARN_TIME());
                        int dateInt = new Integer(dateIntStr);
                        int countMonth = dateInt / 100;
                        bigdataSafetyWarning.setCountDate(dateInt);
                        bigdataSafetyWarning.setCountMonth(countMonth);
                        //获取报警等级
                        String alarmGrade = alarmInfo.getALARM_GRADE();
                        bigdataSafetyWarning.setWarningLevel(getWarningLevel(alarmGrade));
                        //获取报警类型
                        Integer warnType = alarmInfo.getWARN_TYPE();
                        String eventType = alarmInfo.getEVENT_TYPE();
                        //add by wangzhen  20200623 解决大小写问题
                        eventType = eventType.toUpperCase();
                        if (warnType == 100) {
                            String eventType1 = getEventType1(eventType);
                            if(eventType1.equals("")){
                                continue;
                            }
                            bigdataSafetyWarning.setWarningType(eventType1);
                        } else if (warnType == 101) {
                            String eventType2 = getEventType2(eventType);
                            if(eventType2.equals("")){
                                continue;
                            }
                            bigdataSafetyWarning.setWarningType(getEventType2(eventType));
                        }
                        String id = compId + "_" + bigdataSafetyWarning.getBid();
                        bigdataSafetyWarning.setId(id);
                        int count = bigdataSafetyWarningService.countById(bigdataSafetyWarning);
                        if (count > 0) {
                            bigdataSafetyWarning.setUpdateTime(new Date());
                            bigdataSafetyWarningService.updateByPkSelectiveAndFenPian(bigdataSafetyWarning);
                        } else {
                            bigdataSafetyWarningService.insertNew(bigdataSafetyWarning);
                            /*
                             * 将报警信息加入到临时队列里，（请求附件）
                             * */
                            redisUtil.leftPush(keyTemp,obj);
                        }
                    }
                }
            }catch (Exception e){
                redisUtil.leftPush(key,obj);
            }
        }
    }

    //@Scheduled(cron = "0/30 * * * * ?")
    @Scheduled(cron = "${timetask.alarm.GetAlarmFromRedis.cron.leftPushAttachRequest}")
    public void leftPushAttachRequest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        while(true){
            Object obj = redisUtil.rightPop(keyTemp);
            if(obj==null){
                return;
            }
            try {
                String jsonStr= obj.toString();
                AlarmInfo alarmInfo = JSON.parseObject(jsonStr, AlarmInfo.class);//json字符串转对象
                //判断是否超过5分钟
                Date warnTime = alarmInfo.getWARN_TIME();
                Calendar beforeTime = Calendar.getInstance();
                beforeTime.add(Calendar.MINUTE, -5);
                Date beforeD = beforeTime.getTime();
                if(warnTime!=null && warnTime.compareTo(beforeD)<0){
                    String sessionKey = alarmInfo.getSESSION_KEY();
                    String alarmId = alarmInfo.getALARM_ID();
                    String carCode =alarmInfo.getCAR_CODE();
                    String carColor = alarmInfo.getCAR_COLOR();
                    AlarmTempVo alarmTempVo = new AlarmTempVo();
                    alarmTempVo.setSESSION_KEY(sessionKey);
                    alarmTempVo.setALARM_ID(alarmId);
                    alarmTempVo.setCAR_CODE(carCode);
                    alarmTempVo.setCAR_COLOR(carColor);
                    String jsonStr1 = JSON.toJSONString(alarmTempVo);
                    JSONObject jsonObj = JSONObject.parseObject(jsonStr1);
                    redisUtil.leftPush(attachRequestKey,jsonObj);
                    //将附件的报警时间添加到缓存
                    redisUtil.hset(alarmTimeKey,alarmId.toLowerCase(),sdf.format(warnTime));
                }else {
                    redisUtil.leftPush(keyTemp,obj);
                }
            }catch (Exception e){
                redisUtil.leftPush(keyTemp,obj);
            }
        }
    }


    //从缓存中回去附件信息
    //@Scheduled(cron = "0/30 * * * * ?")
    @Scheduled(cron = "${timetask.alarm.GetAlarmFromRedis.cron.getSafetyFileInfo}")
    public void getSafetyFileInfo(){
        while (true){
            Object obj = redisUtil.rightPop(safeFileKey);
            if(obj==null){
                return;
            }
            try {
                String jsonStr= obj.toString();
                AttachVo attachVo = JSON.parseObject(jsonStr, AttachVo.class);//json字符串转对象
                String servIp = attachVo.getSERV_IP();
                String servInfo = attachVo.getSERV_INFO();
                Integer servPort = attachVo.getSERV_PORT();
                String userName = attachVo.getUSER_NAME();
                String alarmId = attachVo.getALARM_ID();
                //add by wangzhen 判断运营商
                String compIp ="";
                if(servInfo!=null && !servInfo.equals("") && servInfo.contains(":")){
                    compIp = servInfo.split(":")[0];
                }else {
                    continue;
                }
                //判断FILE_LIST是否为空
                List<AttachFileVo> attachFileVoList = attachVo.getFILE_LIST();
                BigdataBeidouCompView bigdataBeidouCompView = bigdataBeidouCompService.selectByIp809Addr(compIp);
                if(bigdataBeidouCompView!=null){
                    Object object = redisUtil.hget(alarmTimeKey,alarmId);
                    if(object==null){
                        continue;
                    }
                    int countDate = Integer.parseInt((String)object);
                    int countMonth = countDate/100;
                    for(AttachFileVo f:attachFileVoList){
                        BigdataSafetyWarningFile bigdataSafetyWarningFile = new BigdataSafetyWarningFile();
                        bigdataSafetyWarningFile.setCreateTime(new Date());
                        bigdataSafetyWarningFile.setOwnerSafetyWarningId(bigdataBeidouCompView.getId()+"_"+alarmId);
                        bigdataSafetyWarningFile.setCountDate(countDate);
                        bigdataSafetyWarningFile.setCountMonth(countMonth);
                        //update by wangzhen  原来设置的servInfo 后来改成 servIp
                        bigdataSafetyWarningFile.setServInfo(servIp);
                        bigdataSafetyWarningFile.setServPort(servPort);
                        bigdataSafetyWarningFile.setUserName(userName);
                        bigdataSafetyWarningFile.setIsDownload("0");
                        bigdataSafetyWarningFile.setFileFtpName(f.getFILE_NAME());
                        bigdataSafetyWarningFile.setFileName(f.getFILE_NAME());
                        bigdataSafetyWarningFile.setFileFtpUrl(f.getFILE_URL());
                        String s = f.getFILE_URL().substring(f.getFILE_URL().lastIndexOf(".")+1);
                        if(s.equals("mp4")){
                            bigdataSafetyWarningFile.setFileType("video");
                        }
                        if(s.equals("jpg") || s.equals("png")){
                            bigdataSafetyWarningFile.setFileType("picture");
                        }
                        if(!s.equals("mp4") && !s.equals("jpg") && !s.equals("png")){
                            bigdataSafetyWarningFile.setFileType(s);
                        }
                        bigdataSafetyWarningFileService.insert(bigdataSafetyWarningFile);
                        //redisUtil.hdel(alarmTimeKey,alarmId);
                    }
                    //更新下附件的数量
                    /*bigdataSafetyWarning.setFileTotalNum(attachFileVoList.size());
                    bigdataSafetyWarningService.updateByPkSelectiveAndFenPian(bigdataSafetyWarning);*/
                }
            }catch (Exception e){
                redisUtil.leftPush(safeFileKey,obj);
            }
        }
    }

    //清理key
    //@Scheduled(cron = "0 0 6 * * ?")
    @Scheduled(cron = "${timetask.alarm.GetAlarmFromRedis.cron.deleteAlarmTimeKey}")
    public void deleteAlarmTimeKey(){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dayIntStr = sdf.format(date);
        while (true){
            Map<Object,Object> map = redisUtil.hmget(alarmTimeKey);
            if(map==null){
                return;
            }
            for(Map.Entry<Object, Object> entry : map.entrySet()){
                String alarmId = (String) entry.getKey();
                String countDate = (String)entry.getValue();
                if(!dayIntStr.equals(countDate)){
                    redisUtil.hdel(alarmTimeKey,alarmId);
                }
            }
        }
    }
    //返回报警等级
    public String getWarningLevel(String alarmGrade){
        if(alarmGrade.equals("0X01")){
            return "1";
        }
        if(alarmGrade.equals("0X02")){
            return "2";
        }
        return "";
    }
    //高级驾驶辅助系统报警
    public String getEventType1(String eventType){
        eventType = eventType.toUpperCase();
        if(eventType.equals("0X01")){
            return "前向碰撞预警";
        }
        if(eventType.equals("0X02")){
            return "车辆偏离预警";
        }
        if(eventType.equals("0X03")){
            return "车距过近预警";
        }
        if(eventType.equals("0X04")){
            return "行人碰撞报警";
        }
        if(eventType.equals("0X06")){
            return "限速标志识别";
        }
        return "";
    }
    //驾驶人状态监测系统报警
    public String getEventType2(String eventType){
        if(eventType.equals("0X01")){
            return "疲劳驾驶报警";
        }
        if(eventType.equals("0X02")){
            return "接打电话报警";
        }
        if(eventType.equals("0X03")){
            return "抽烟报警";
        }
        if(eventType.equals("0X04")){
            return "注意力分散报警";
        }
        if(eventType.equals("0X05")){
            return "异常报警";
        }
        return "";
    }

}
