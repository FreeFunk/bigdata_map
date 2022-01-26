package com.edgedo.timetask;

import com.edgedo.bigdata.entity.BigdataBeidouCheckScoreRec;
import com.edgedo.bigdata.queryvo.BigdataBeidouCheckStandardView;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompMonthCheckView;
import com.edgedo.bigdata.service.BigdataBeidouCheckScoreRecService;
import com.edgedo.bigdata.service.BigdataBeidouCheckStandardService;
import com.edgedo.bigdata.service.BigdataBeidouCompMonthCheckService;
import com.edgedo.bigdata.service.BigdataBeidouCompService;
import com.edgedo.score.Standard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName BigdataBeidouCheckScoreRecAnalysis
 * @Description 计算运营商的分数考核结果
 * @Author 床前明月光
 * @Date 2019/8/21 10:41
 **/
@Component
public class BigdataBeidouCheckScoreRecAnalysis {

    @Autowired
    BigdataBeidouCompMonthCheckService bigdataBeidouCompMonthCheckService;
    @Autowired
    BigdataBeidouCheckStandardService bigdataBeidouCheckStandardService;
    @Autowired
    BigdataBeidouCheckScoreRecService bigdataBeidouCheckScoreRecService;

    @Scheduled(cron = "0 0/10 * * * ?")
    public void countCheckScoreRec() throws IllegalAccessException, InstantiationException {
        SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        Date countDate = calendar.getTime();
        String countDateStr = sdfDateInt.format(countDate);

        //查询出运营商的月度考核
        Map<String,Object> param = new HashMap<>();
        param.put("countMonth",Integer.valueOf(countDateStr)/100);
        List<BigdataBeidouCompMonthCheckView> bigdataBeidouCompMonthCheckViewList = bigdataBeidouCompMonthCheckService.listBySearchDate(param);
        //查询所有的动态处理类
        List<BigdataBeidouCheckStandardView> bigdataBeidouCheckStandardViewList  = bigdataBeidouCheckStandardService.listAll();
        for(BigdataBeidouCompMonthCheckView b:bigdataBeidouCompMonthCheckViewList){
            //获取所有的
            for(BigdataBeidouCheckStandardView s:bigdataBeidouCheckStandardViewList){
                Class c = null;
                try {
                    c = Class.forName("com.edgedo.score."+s.getDealClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Standard standard = (Standard)c.newInstance();
                BigdataBeidouCheckScoreRec bigdataBeidouCheckScoreRec = standard.computeScore(b,s.getId());
                bigdataBeidouCheckScoreRecService.insertOrUpdate(bigdataBeidouCheckScoreRec);
            }
            //统计运营商的得分情况
            Map<String,Object> map = new HashMap<>();
            map.put("compId",b.getCompId());
            map.put("countMonth",b.getCountMonth());
            BigDecimal compScore = bigdataBeidouCheckScoreRecService.countCompScore(map);
            b.setScore(compScore);
            bigdataBeidouCompMonthCheckService.update(b);
        }
    }
}
