package com.edgedo.reportdata.service;

import com.edgedo.reportdata.entity.Agent;
import com.edgedo.reportdata.entity.YwTrainChargeBill;
import com.edgedo.reportdata.mapper.AgentMapper;
import com.edgedo.reportdata.queryvo.AgentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class AgentService {

    @Autowired
    private AgentMapper agentMapper;

    public Agent selectByQuery(AgentQuery query) {
        Date searchTime = query.getSearchTime();
        if(searchTime==null){
            searchTime = new Date();
        }
        boolean flag = compareDate(new Date(),searchTime);
        //去历史记录里面查记录
        if(!flag){
            Agent agent = agentMapper.selectByQuery(query);
        }
        //查询手机课时数
        //int phoneLessionNum = agentMapper.countPhoneLessionNum(query);
        return null;
    }

    //比较两个时间
    private boolean compareDate(Date date1,Date date2){
        //date1
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        int month1 = cal1.get(Calendar.MONTH);
        int year1 = cal1.get(Calendar.YEAR);

        //date2
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int month2 = cal2.get(Calendar.MONTH);
        int year2 = cal2.get(Calendar.YEAR);

        if(year2>year1 || (year2 ==year1 && month2>=month1)){
            return true;
        }
        return  false;
    }

    public List<YwTrainChargeBill> listPageForChargeBill(AgentQuery query) {
        List list = agentMapper.listPageForChargeBill(query);
        query.setList(list);
        return list;
    }

    public Agent countMoneyForDay(AgentQuery query) {
        Agent agent = new Agent();
        //统计总的课时数
        int countLessionNum = agentMapper.countLessionNum(query);
        agent.setCountLessionNum(countLessionNum);
        //统计手机学习课时数
        int phoneLessionNum = agentMapper.countphoneLessionNum(query);
        agent.setPhoneLessionNum(phoneLessionNum);
        //统计电脑学习的课时数
        int pcLessionNum = agentMapper.countpcLessionNum(query);
        agent.setPcLessionNum(pcLessionNum);
        //统计总的学习人数
        int countPersonNum = agentMapper.countPersonNum(query);
        agent.setCountPersonNum(countPersonNum);
        //统计应审车辆数
        int trialCarNum = agentMapper.counttrialCarNum(query);
        agent.setTrialCarNum(trialCarNum);
        //统计已审车辆数(暂时写死) TODO
        int finishedCarNum = agentMapper.countfinishedCarNum(query);
        agent.setFinishedCarNum(finishedCarNum);
        //应审人数数 TODO
       /* agent.setTrailEmpNum(0);
        //已审人员数 TODO
        agent.setFinishedEmpNum(0);*/
        //充值金额
        BigDecimal rechargeMoney = agentMapper.countrechargeMoney(query);
        if(rechargeMoney==null){
            rechargeMoney = new BigDecimal("0");
        }
        agent.setRechargeMoney(rechargeMoney);
        //消费金额
        BigDecimal consumeMoney =agentMapper.countconsumeMoney(query);
        if(consumeMoney==null){
            consumeMoney = new BigDecimal("0");
        }
        agent.setConsumeMoney(consumeMoney);
        return agent;
    }


    public List<YwTrainChargeBill> listPageForChargeBillByDay(AgentQuery query) {
        List list = agentMapper.listPageForChargeBillByDay(query);
        query.setList(list);
        return list;
    }

    public int sumXianQuLessionYear(String cityId, String xianquId, int year, String trainType) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("year",year);
        param.put("trainType",trainType);
        return agentMapper.sumXianQuLessionYear(param);
    }

    public int sumXianQuLessionMonth(
            String cityId, String xianquId,
            Date searchTime,String trainType) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        param.put("trainType",trainType);
        return agentMapper.sumXianQuLessionMonth(param);
    }

    public int sumXianQuLessionDay(
            String cityId, String xianquId,
            Date searchTime,String trainType) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        param.put("trainType",trainType);
        return agentMapper.sumXianQuLessionDay(param);
    }

    public int sumXianQuPersonYear(String cityId, String xianquId, int year) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("year",year);
        return agentMapper.sumXianQuPersonYear(param);

    }

    public int sumXianQuPersonMonth(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumXianQuPersonMonth(param);
    }

    public int sumXianQuPersonDay(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumXianQuPersonDay(param);
    }

    public BigDecimal sumXianQurechargeMoneyYear(String cityId, String xianquId, int year) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("year",year);
        return agentMapper.sumXianQurechargeMoneyYear(param);
    }

    public BigDecimal sumXianQurechargeMoneyMonth(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumXianQurechargeMoneyMonth(param);
    }

    public BigDecimal sumXianQurechargeMoneyDay(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumXianQurechargeMoneyDay(param);
    }

    public BigDecimal sumXianQureconsumeMoneyYear(String cityId, String xianquId, int year) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("year",year);
        return agentMapper.sumXianQureconsumeMoneyYear(param);
    }

    public BigDecimal sumXianQureconsumeMoneyMonth(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumXianQureconsumeMoneyMonth(param);
    }

    public BigDecimal sumXianQureconsumeMoneyDay(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumXianQureconsumeMoneyDay(param);
    }

    public int sumXianQuLessionForPcYear(String cityId, String xianquId, int year, String placeType) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("year",year);
        param.put("placeType",placeType);
        return agentMapper.sumXianQuLessionForPcYear(param);
    }

    public int sumXianQuLessionForPcMonth(String cityId, String xianquId, Date searchTime, String placeType) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        param.put("placeType",placeType);
        return agentMapper.sumXianQuLessionForPcMonth(param);

    }

    public int sumXianQuLessionForPcDay(String cityId, String xianquId, Date searchTime, String placeType) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        param.put("placeType",placeType);
        return agentMapper.sumXianQuLessionForPcDay(param);
    }

    public int sumPrestoredLessionYear(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumPrestoredLessionYear(param);
    }

    public int sumPrestoredLessionMonth(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumPrestoredLessionMonth(param);
    }

    public int sumPrestoredLessionDay(String cityId, String xianquId, Date searchTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        return agentMapper.sumPrestoredLessionDay(param);
    }
}
