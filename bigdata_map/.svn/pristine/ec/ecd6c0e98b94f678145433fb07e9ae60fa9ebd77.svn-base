package com.edgedo.alarm.service;

import com.edgedo.alarm.entity.Alterlogs;
import com.edgedo.alarm.mapper.AlterlogsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AlterlogsService {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @Autowired
    AlterlogsMapper alterlogsMapper ;
    /**
     * 查询某个小时的报警信息
     * @param date
     * @return
     */
    public List<Alterlogs> listRecentLogs(Date date){
        Calendar cal = Calendar.getInstance();
        //读取8分钟内的数据
        cal.setTime(date);
        String searchTime1 = sdf.format(date);
        cal.add(Calendar.MINUTE,-1);
        String searchTime2 = sdf.format(cal.getTime());
        cal.add(Calendar.MINUTE,-1);
        String searchTime3 = sdf.format(cal.getTime());
        cal.add(Calendar.MINUTE,-1);
      /*  String searchTime4 = sdf.format(cal.getTime());
        cal.add(Calendar.MINUTE,-1);
        String searchTime5 = sdf.format(cal.getTime());
        cal.add(Calendar.MINUTE,-1);
        String searchTime6 = sdf.format(cal.getTime());
        cal.add(Calendar.MINUTE,-1);
        String searchTime7 = sdf.format(cal.getTime());
        cal.add(Calendar.MINUTE,-1);
        String searchTime8 = sdf.format(cal.getTime());*/
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("searchTime1",searchTime1);
        param.put("searchTime2",searchTime2);
        param.put("searchTime3",searchTime3);
     /*   param.put("searchTime4",searchTime4);
        param.put("searchTime5",searchTime5);
        param.put("searchTime6",searchTime6);
        param.put("searchTime7",searchTime7);
        param.put("searchTime8",searchTime8);*/
        return alterlogsMapper.listRecentLogs(param);
    }

}
