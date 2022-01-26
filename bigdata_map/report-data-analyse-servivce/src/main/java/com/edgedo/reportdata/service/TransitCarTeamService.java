package com.edgedo.reportdata.service;

import com.edgedo.reportdata.entity.TeamReceive;
import com.edgedo.reportdata.entity.TransitCarTeam;
import com.edgedo.reportdata.mapper.TransitCarTeamMapper;
import com.edgedo.reportdata.queryvo.TransitCarTeamQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransitCarTeamService {

    @Autowired
    private TransitCarTeamMapper carTeamMapper;

    public int selectCountCarTeam(TransitCarTeamQuery query){
        return carTeamMapper.selectCountCarTeam(query);
    }

    public List<TransitCarTeam> selectCarTeamInfoListPage(TransitCarTeamQuery query){
        return carTeamMapper.selectCarTeamInfoListPage(query);
    }

    public List<TeamReceive> selectRectificationRecByTeamId(TransitCarTeamQuery query){
        return carTeamMapper.selectTeamReceiveByTeamId(query);
    }

    public TeamReceive selectTeamReceiveInfoById(Map paramMap){
        return carTeamMapper.selectTeamReceiveInfoById(paramMap);
    }

    public List<TransitCarTeam> selectCarTeamInfo(TransitCarTeamQuery query) {
        return carTeamMapper.selectCarTeamInfo(query);
    }
}
