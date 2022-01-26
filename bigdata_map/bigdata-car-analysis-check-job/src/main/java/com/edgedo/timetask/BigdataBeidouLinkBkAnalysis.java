package com.edgedo.timetask;

import com.edgedo.bigdata.entity.BigdataBeidouLinkBkRec;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.bigdata.service.BigdataBeidouCompService;
import com.edgedo.bigdata.service.BigdataBeidouLinkBkRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BigdataBeidouLinkBkAnalysis
 * @Description TODO
 * @Author 床前明月光
 * @Date 2019/8/9 10:04
 **/
@Component
public class BigdataBeidouLinkBkAnalysis {

    @Autowired
    BigdataBeidouCompService bigdataBeidouCompService;
    @Autowired
    BigdataBeidouLinkBkRecService bigdataBeidouLinkBkRecService;

    //生成联通记录
    @Scheduled(cron = "0 0/2 * * * ?")
    public void countLinkBk(){
        SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
        Date nowDate = new Date();
        String countDateStr = sdfDateInt.format(nowDate);
        List<BigdataBeidouCompView> bigdataBeidouCompViewList =  bigdataBeidouCompService.listAll();
        for(BigdataBeidouCompView comp:bigdataBeidouCompViewList){
            Date lastUpTime = comp.getLastUpTime();
            if(lastUpTime==null){
                continue;
            }
            long t = (nowDate.getTime()-lastUpTime.getTime())/1000;
            if(t>300){
                //根据上一次联通时间去查询
                Map<String,Object> map = new HashMap<>();
                map.put("countMonth",Integer.valueOf(countDateStr)/100);
                map.put("compId",comp.getId());
                map.put("bkStartTime",lastUpTime);
                BigdataBeidouLinkBkRec bigdataBeidouLinkBkRec = bigdataBeidouLinkBkRecService.selectByTime(map);
                if(bigdataBeidouLinkBkRec!=null){
                    bigdataBeidouLinkBkRec.setBkEndTime(nowDate);
                    bigdataBeidouLinkBkRec.setBkMinuteNum((int)t/60);
                    bigdataBeidouLinkBkRecService.update(bigdataBeidouLinkBkRec);
                }else {
                    BigdataBeidouLinkBkRec bigdataBeidouLinkBkRec1 = new BigdataBeidouLinkBkRec();
                    bigdataBeidouLinkBkRec1.setBkStartTime(lastUpTime);
                    bigdataBeidouLinkBkRec1.setBkEndTime(nowDate);
                    bigdataBeidouLinkBkRec1.setCompId(comp.getId());
                    bigdataBeidouLinkBkRec1.setCompName(comp.getCompName());
                    bigdataBeidouLinkBkRec1.setCountMonth(Integer.valueOf(countDateStr)/100);
                    bigdataBeidouLinkBkRec1.setYearNum(Integer.valueOf(countDateStr)/10000);
                    bigdataBeidouLinkBkRec1.setBkMinuteNum((int)t/60);
                    bigdataBeidouLinkBkRecService.insert(bigdataBeidouLinkBkRec1);
                }
            }
        }
    }
}
