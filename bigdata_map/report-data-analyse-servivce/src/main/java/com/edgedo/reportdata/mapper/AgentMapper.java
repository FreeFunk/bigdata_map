package com.edgedo.reportdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.reportdata.entity.Agent;
import com.edgedo.reportdata.entity.YwTrainChargeBill;
import com.edgedo.reportdata.queryvo.AgentQuery;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface AgentMapper extends BaseMapper<Agent> {

    Agent selectByQuery(AgentQuery query);

    List<YwTrainChargeBill> listPageForChargeBill(AgentQuery query);

    int countLessionNum(AgentQuery query);

    int countphoneLessionNum(AgentQuery query);

    int countpcLessionNum(AgentQuery query);

    int countPersonNum(AgentQuery query);

    int counttrialCarNum(AgentQuery query);

    BigDecimal countrechargeMoney(AgentQuery query);

    BigDecimal countconsumeMoney(AgentQuery query);

    List listPageForChargeBillByDay(AgentQuery query);

    int sumXianQuLessionYear(Map<String, Object> param);

    int sumXianQuLessionMonth(Map<String, Object> param);

    int sumXianQuLessionDay(Map<String, Object> param);

    int sumXianQuPersonYear(Map<String, Object> param);

    int sumXianQuPersonMonth(Map<String, Object> param);

    int sumXianQuPersonDay(Map<String, Object> param);

    BigDecimal sumXianQurechargeMoneyYear(Map<String, Object> param);

    BigDecimal sumXianQurechargeMoneyMonth(Map<String, Object> param);

    BigDecimal sumXianQurechargeMoneyDay(Map<String, Object> param);

    BigDecimal sumXianQureconsumeMoneyYear(Map<String, Object> param);

    BigDecimal sumXianQureconsumeMoneyMonth(Map<String, Object> param);

    BigDecimal sumXianQureconsumeMoneyDay(Map<String, Object> param);

    int countfinishedCarNum(AgentQuery query);

    int sumXianQuLessionForPcYear(Map<String, Object> param);

    int sumXianQuLessionForPcMonth(Map<String, Object> param);

    int sumXianQuLessionForPcDay(Map<String, Object> param);

    int sumPrestoredLessionYear(Map<String, Object> param);

    int sumPrestoredLessionMonth(Map<String, Object> param);

    int sumPrestoredLessionDay(Map<String, Object> param);
}
