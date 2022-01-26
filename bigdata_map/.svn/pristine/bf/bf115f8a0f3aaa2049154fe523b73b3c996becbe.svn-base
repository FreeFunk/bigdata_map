package com.edgedo.reportdata.service;

import com.edgedo.common.base.BusinessException;
import com.edgedo.common.util.Guid;
import com.edgedo.reportdata.entity.*;
import com.edgedo.reportdata.entity.Emp;
import com.edgedo.reportdata.mapper.AgentMapper;
import com.edgedo.reportdata.mapper.EmpMapper;
import com.edgedo.reportdata.queryvo.AgentQuery;
import com.edgedo.reportdata.queryvo.EmpQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class EmpService {

    SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy年MM月");
    SimpleDateFormat sdfMonth1 = new SimpleDateFormat("yyyyMM");

    @Autowired
    private EmpMapper empMapper;

    public int countEmpByQuery(EmpQuery query) {

        return empMapper.countEmpByQuery(query);
    }

    public List<Emp> selectEmpByQueryListPage(EmpQuery query) {
        return empMapper.selectEmpByQueryListPage(query);
    }

    public String selectHeadPhoto(Map param){
        return empMapper.selectHeadPhoto(param);
    }

    public Emp selectEmpDetail(EmpQuery query) {
        return empMapper.selectEmpDetail(query);
    }

    public List<SafetyTrainingRecEmp> selectEmpSafetyRec(EmpQuery query) {
        return empMapper.selectEmpSafetyRec(query);
    }

    public List<Emp> selectEmpByCarInfo(EmpQuery query){
        return empMapper.selectEmpByCarInfo(query);
    }

    public List<Emp> selectEmpListByCarTeam(Map<String,String> parameterMap){
        return empMapper.selectEmpListByCarTeam(parameterMap);
    }

    public List<Emp> listPageEmpByQuery(EmpQuery query) {
        List list = empMapper.listPageEmpByQuery(query);
        query.setList(list);
        return list;
    }

    public Emp selectEmpByCarInfoNew(EmpQuery query) {
        return empMapper.selectEmpByCarInfoNew(query);
    }


    public List<Emp> selectEmpByStartAndLimit(Map<String, Object> param) {
        return empMapper.selectEmpByStartAndLimit(param);
    }

    /**
     * 发送站内信消息和定向课件
     * @param empId  智慧运管的从业人员id
     * @param siteMsg 站内信消息内容
     * @param isFatigued 是否疲劳
     * @param fatiguedNumSum 疲劳次数
     * @param seriousFatiguedNumSum 严重疲劳次数
     * @param isOverSpeed  是否超速
     * @param overSpeedNumSum 超速次数
     * @param seriousOverSpeedNumSum  严重超速次数
     * @param countMonth  月份
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void updateSendLessionToEmp(
            String cityId,
            String empId, String siteMsg,
            String isFatigued, String fatiguedNumSum, String seriousFatiguedNumSum,
            String isOverSpeed, String overSpeedNumSum, String seriousOverSpeedNumSum,
            String countMonth) {

        Date monthDate = null;
        try {
            monthDate = sdfMonth.parse(countMonth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(monthDate);
        cal.add(Calendar.MONTH,1);
        Date nextMonth = cal.getTime();
        YwTrainStudent student = selectTrainStuByEmpId(cityId,empId);

        String ywUserId = student.getYwUserId();
        if(ywUserId!=null && ywUserId.length()>0){

            //2.随机选择疲劳课件
            if(isFatigued!=null && isFatigued.equals("true")){
                updateSendLession(cityId,"疲劳","疲劳定向课件"/*"疲劳定向课件"*/, countMonth, student , nextMonth,new Integer(fatiguedNumSum),new Integer(seriousFatiguedNumSum));
            }
            //3.随机选择超速课件
            if(isOverSpeed!=null && isOverSpeed.equals("true")){
                updateSendLession(cityId,"超速","超速定向课件"/*"超速定向课件"*/, countMonth, student , nextMonth,new Integer(overSpeedNumSum),new Integer(seriousOverSpeedNumSum));
            }
            //1.增加站内信
            updateSendSiteMsg(cityId,ywUserId,siteMsg,"驾驶情况分析",countMonth + "驾驶分析提醒");
        }


    }

    /**
     * 发送随机的定向课件
     * @param warningType
     * @param countMonth
     * @param student
     * @param nextMonth
     */
    private void updateSendLession(String cityId,
            String warningType,String lessionType, String countMonth,
            YwTrainStudent student, Date nextMonth,
            int warningCount,int seriousWarningCount) {
        //1.随机找到一个课件
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("lessionType",lessionType);
        int count = empMapper.countLessionByType(param);
        if(count==0){
            throw new BusinessException("未找到课件");
        }
        Random random = new Random();
        int start =  random.nextInt(count);
        param.put("start",start);
        YwTrainLession lession = empMapper.selectOneLessionByType(param);
        String id = warningType + student.getId() + sdfMonth1.format(nextMonth);
        param.put("id",id);
        int count1 = empMapper.countDirectLessionById(param);
        if(count1>0){//已经下发过
            return;
        }
        //2.下发下去

        param.put("createTime",new Date());
        param.put("studyDate",nextMonth);
        param.put("stuId" , student.getId());
        param.put("stuName",student.getStuName() );
        param.put("compId",student.getCompId());
        param.put("lessionId",lession.getId());
        param.put("lessionTitle",lession.getLessionTitle());
        param.put("warningCount" , warningCount);
        param.put("seriousWarningCount" , seriousWarningCount);
        param.put("warningType" , warningType);
        param.put("startMonth",countMonth);
        param.put("dataState","1");
        int row = empMapper.updateSendDirectLessionToStu(param);

    }

    /**
     * 根据从业人员id查询学员
     * @param cityId 城市id
     * @param empId  智慧运管从业人员id
     * @return
     */
    public YwTrainStudent selectTrainStuByEmpId(String cityId,String empId){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("empId",empId);
        return empMapper.selectTrainStuByEmpId(param);

    }


    /**
     * 发送站内信
     * @param userId
     * @param siteMsg
     * @param msgType
     * @param msgTitle
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void updateSendSiteMsg(String cityId,String userId, String siteMsg, String msgType, String msgTitle) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("userId",userId);
        param.put("msgType",msgType);
        param.put("content",siteMsg);
        param.put("title",msgTitle);
        param.put("createTime",new Date());
        param.put("isRead","0");
        param.put("dataState","1");
        param.put("id", Guid.guid());
        empMapper.updateSendSiteMsg(param);


    }


}
