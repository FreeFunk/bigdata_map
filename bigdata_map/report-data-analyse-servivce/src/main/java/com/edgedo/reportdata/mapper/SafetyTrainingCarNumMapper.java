package com.edgedo.reportdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.reportdata.entity.SafetyTrainingCarNum;
import com.edgedo.reportdata.queryvo.SafetyTrainingCarDetailQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SafetyTrainingCarNumMapper extends BaseMapper<SafetyTrainingCarNum> {

    List<SafetyTrainingCarNum> selectObjByCityId(SafetyTrainingCarNum safetyTrainingCarNum);

    List listPageFinisheSafetyTrainingCarDetail(SafetyTrainingCarDetailQuery query);
}
