package com.edgedo.reportdata.service;

import com.edgedo.reportdata.entity.SafetyTrainingConsumRec;
import com.edgedo.reportdata.entity.SafetyTrainingRecEmp;
import com.edgedo.reportdata.entity.TransitCarBaseinfo;
import com.edgedo.reportdata.entity.TransitCarTeam;
import com.edgedo.reportdata.mapper.SafetyTrainingConsumRecMapper;
import com.edgedo.reportdata.queryvo.SafetyTrainingConsumRecQuery;
import com.edgedo.reportdata.queryvo.TransitCarInfoQuery;
import com.edgedo.reportdata.queryvo.TransitCarTeamQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafetyTrainingConsumRecService {

    @Autowired
    private SafetyTrainingConsumRecMapper safetyTrainingConsumRecMapper;

    public List<SafetyTrainingConsumRec> listPage(SafetyTrainingConsumRecQuery query) {
        List list = safetyTrainingConsumRecMapper.listPage(query);
        query.setList(list);
        return list;
    }

    public TransitCarBaseinfo selectCarInfoByCarFrameNum(TransitCarInfoQuery query) {
        return safetyTrainingConsumRecMapper.selectCarInfoByCarFrameNum(query);
    }

    public List<SafetyTrainingRecEmp>  selectLessionDetailByCarFrameNum(TransitCarInfoQuery query) {
        List list = safetyTrainingConsumRecMapper.listPageLessionDetailByCarFrameNum(query);
        query.setList(list);
        return list;
    }

    public List<TransitCarTeam> listPageForTransitCarTeam(TransitCarTeamQuery query) {
        List list = safetyTrainingConsumRecMapper.listPageForTransitCarTeam(query);
        query.setList(list);
        return list;
    }
}
