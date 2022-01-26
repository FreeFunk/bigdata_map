package com.edgedo.reportdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.reportdata.entity.*;
import com.edgedo.reportdata.queryvo.AgentQuery;
import com.edgedo.reportdata.queryvo.EmpQuery;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {


    int countEmpByQuery(EmpQuery query);

    List<Emp> selectEmpByCarInfo(EmpQuery query);

    String selectHeadPhoto(Map param);

    List<Emp> selectEmpByQueryListPage(EmpQuery query);

    Emp selectEmpDetail(EmpQuery query);

    List<SafetyTrainingRecEmp> selectEmpSafetyRec(EmpQuery query);

    List<Emp> selectEmpListByCarTeam(Map<String,String> paramerMap);

    List<Emp> listPageEmpByQuery(EmpQuery query);

    Emp selectEmpByCarInfoNew(EmpQuery query);

    List<Emp> selectEmpByStartAndLimit(Map<String, Object> param);
    //根据智慧运管从业人员id查询学员的ywUserId
    String selectTrainStuYwUserId(Map<String, Object> param);
    //发送站内信
    int updateSendSiteMsg(Map<String, Object> param);
    //根据从业人员id查询学员
    YwTrainStudent selectTrainStuByEmpId(Map<String, Object> param);
    //统计某一个类型课件的数量-用于随机发课件
    int countLessionByType(Map<String, Object> param);
    //随机的一个课件
    YwTrainLession selectOneLessionByType(Map<String, Object> param);
    //下发定向课件
    int updateSendDirectLessionToStu(Map<String, Object> param);
    //查看定向课件是否已经发送
    int countDirectLessionById(Map<String,Object> param);
}
