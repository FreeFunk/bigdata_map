package com.edgedo.reportdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.reportdata.entity.*;
import com.edgedo.reportdata.queryvo.EmpQuery;
import com.edgedo.reportdata.queryvo.TransitCarInfoQuery;
import com.edgedo.reportdata.queryvo.TransitCarTeamQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TransitCarTeamMapper extends BaseMapper<Emp> {

    int selectCountCarTeam(TransitCarTeamQuery query);

    List<TransitCarTeam> selectCarTeamInfoListPage(TransitCarTeamQuery query);

    List<TeamReceive> selectTeamReceiveByTeamId(TransitCarTeamQuery query);

    TeamReceive selectTeamReceiveInfoById(Map paramMap);

    List<TransitCarTeam> selectCarTeamInfo(TransitCarTeamQuery query);
}
