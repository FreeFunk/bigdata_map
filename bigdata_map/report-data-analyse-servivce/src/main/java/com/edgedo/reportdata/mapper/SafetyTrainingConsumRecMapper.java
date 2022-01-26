package com.edgedo.reportdata.mapper;

import com.edgedo.reportdata.entity.SafetyTrainingRecEmp;
import com.edgedo.reportdata.entity.TransitCarBaseinfo;
import com.edgedo.reportdata.queryvo.SafetyTrainingConsumRecQuery;
import com.edgedo.reportdata.queryvo.TransitCarInfoQuery;
import com.edgedo.reportdata.queryvo.TransitCarTeamQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SafetyTrainingConsumRecMapper {

    List listPage(SafetyTrainingConsumRecQuery query);

    TransitCarBaseinfo selectCarInfoByCarFrameNum(TransitCarInfoQuery query);

    List<SafetyTrainingRecEmp>  listPageLessionDetailByCarFrameNum(TransitCarInfoQuery query);

    List listPageForTransitCarTeam(TransitCarTeamQuery query);
}
