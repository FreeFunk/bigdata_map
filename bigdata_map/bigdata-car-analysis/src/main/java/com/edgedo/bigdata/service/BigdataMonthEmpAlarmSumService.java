package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataMonthEmpAlarmSum;
import com.edgedo.bigdata.mapper.BigdataMonthEmpAlarmSumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataMonthEmpAlarmSumService {

    @Autowired
    BigdataMonthEmpAlarmSumMapper monthEmpAlarmSumMapper;

    //根据主键加载
    public BigdataMonthEmpAlarmSum loadById(String id) {
        return monthEmpAlarmSumMapper.selectById(id);
    }

    //插入记录
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insert(BigdataMonthEmpAlarmSum dbEmpAlarmSum) {
        monthEmpAlarmSumMapper.insert(dbEmpAlarmSum);
    }
    //查询某个从业人员的某个月的报警情况
    public List<BigdataMonthEmpAlarmSum> listEmpAlarmSumOfMonth(String empId, Integer countMonth) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("empId",empId);
        param.put("countMonth",countMonth);
        return monthEmpAlarmSumMapper.listEmpAlarmSumOfMonth(param);
    }

    //修改报警汇总未已经发送状态
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int updateEmpAlarmSumToSendStatus(List<BigdataMonthEmpAlarmSum> monthEmpAlarmSumList) {
        if(monthEmpAlarmSumList.size() > 0){
            return monthEmpAlarmSumMapper.updateEmpAlarmSumToSendStatus(monthEmpAlarmSumList);
        }else{
            return 0;
        }
    }

}
