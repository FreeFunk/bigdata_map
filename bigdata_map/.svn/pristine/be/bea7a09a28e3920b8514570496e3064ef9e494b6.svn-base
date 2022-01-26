package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataMonthEmpAlarmSum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BigdataMonthEmpAlarmSumMapper  extends BaseMapper<BigdataMonthEmpAlarmSum> {

    //查询从业人员的某月的报警汇总情况
    List<BigdataMonthEmpAlarmSum> listEmpAlarmSumOfMonth(Map<String, Object> param);
    //根据月度报警汇总为已发送
    int updateEmpAlarmSumToSendStatus(List<BigdataMonthEmpAlarmSum> monthEmpAlarmSumList);

}
