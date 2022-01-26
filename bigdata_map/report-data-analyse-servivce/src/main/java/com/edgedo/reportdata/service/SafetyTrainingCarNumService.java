package com.edgedo.reportdata.service;

import com.edgedo.reportdata.entity.SafetyTrainingCarDetail;
import com.edgedo.reportdata.entity.SafetyTrainingCarNum;
import com.edgedo.reportdata.mapper.SafetyTrainingCarNumMapper;
import com.edgedo.reportdata.queryvo.SafetyTrainingCarDetailQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafetyTrainingCarNumService {

    @Autowired
    private SafetyTrainingCarNumMapper safetyTrainingCarNumMapper;

    public List<SafetyTrainingCarNum> selectObjByCityId(SafetyTrainingCarNum safetyTrainingCarNum) {
        return safetyTrainingCarNumMapper.selectObjByCityId(safetyTrainingCarNum);
    }

    public List<SafetyTrainingCarDetail> listPageFinisheSafetyTrainingCarDetail(SafetyTrainingCarDetailQuery query) {
        List list = safetyTrainingCarNumMapper.listPageFinisheSafetyTrainingCarDetail(query);
        query.setList(list);
        return list;
    }
}
