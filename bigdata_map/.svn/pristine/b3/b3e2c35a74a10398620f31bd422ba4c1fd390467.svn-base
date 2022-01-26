package com.edgedo.timetask.monitor;

import com.edgedo.bigdata.entity.SysMonitorAlarm;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsView;
import com.edgedo.bigdata.service.BigdataCarRealtimeGpsService;
import com.edgedo.bigdata.service.SysMonitorAlarmService;
import com.edgedo.phonemsgclient.ISysPhoneVoiceMsgClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author WangZhen
 * @description 监控大数据接收情况，发送手机电话报警
 * 临时先顶一阵，等系统性的进行服务监控系统开发时将这里优化
 * @date 2020/4/24
 */
@ConditionalOnProperty(
        value = {"timetask.monitor.BigdataMonitorTask.enable"},
        havingValue = "true",
        matchIfMissing = false
)
@Component
public class BigdataMonitorTask {

    @Autowired
    ISysPhoneVoiceMsgClientService voiceMsgClientService;

    @Autowired
    SysMonitorAlarmService sysMonitorAlarmService;
    @Autowired
    BigdataCarRealtimeGpsService realtimeGpsService;
    /**
     * @Author WangZhen
     * @Description 看下gps数据是否一致更新
     * @Scheduled(cron = "0 0/5 * * * ?")
     * @Date 2020/4/24 14:26
     **/
    @Scheduled(cron = "${timetask.monitor.BigdataMonitorTask.cron.monitorGpsData}")
    public void monitorGpsData(){
        //查找到最新的一辆车
        BigdataCarRealtimeGpsView lastestCar = realtimeGpsService.loadLatestOneCar();
        if(lastestCar!=null){
            //判断是否超过10分钟没有更新
            Date lastPositionTime = lastestCar.getLastPositionTime();
            long curLong  = System.currentTimeMillis();

            if(lastPositionTime!=null && Math.abs(curLong - lastPositionTime.getTime())>600000){
                //如果近期有提示那么就不在加信息的
                int count = sysMonitorAlarmService.countByAlaramTypeOfSysRecentMinute("大数据系统","809位置同步模块","809位置没更新",10);
                if(count==0){
                    //判断时间如果已经超过10分钟没有更新了就报警
                    SysMonitorAlarm sysMonitorAlarm = new SysMonitorAlarm();
                    //未处理
                    sysMonitorAlarm.setAlarmState("0");
                    sysMonitorAlarm.setAlarmType("809定位服务");
                    sysMonitorAlarm.setCreateTime(new Date());
                    sysMonitorAlarm.setSystemModel("809定位同步模块");
                    sysMonitorAlarm.setSystemName("大数据系统");
                    sysMonitorAlarmService.insert(sysMonitorAlarm);
                }
            }
        }
    }

    /**
     * @Author WangZhen
     * @Description 发送报警的提醒语音
     * @Scheduled(cron = "0 0/5 * * * ?")
     * @Date 2020/4/24 14:26
     **/
    @Scheduled(cron = "${timetask.monitor.BigdataMonitorTask.cron.monitorAlarmSendMsg}")
    public void monitorAlarmSendMsg(){
        List<SysMonitorAlarm> list = sysMonitorAlarmService.selectAllNotSendMsgAlarm();
        long curLong = System.currentTimeMillis();
        list.forEach((alarm)->{
            Date createTime = alarm.getCreateTime();
            long ctLong = createTime.getTime();
            if(curLong-ctLong>3600000){//超过一个小时不在发了
                alarm.setAlarmState("-1");
                sysMonitorAlarmService.update(alarm);
            }else{
                //TODO: 发送语音通知

                String res = voiceMsgClientService.sendVoiceNotice(
                        494708,"18716003907",2,
                        alarm.getAlarmType()
                );
                if(res!=null && res.toLowerCase().equals("ok")){
                    alarm.setAlarmState("1");
                    sysMonitorAlarmService.update(alarm);
                }else{
                    System.out.println("发送短信失败");
                }
            }
        });


    }


}
