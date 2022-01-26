package com.edgedo.reportdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.reportdata.entity.TransitCarBaseinfo;
import com.edgedo.reportdata.queryvo.TransitCarInfoQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TransitCarInfoMapper extends BaseMapper<TransitCarBaseinfo> {

    List<TransitCarBaseinfo> selectCarBaseinfoListPage(TransitCarInfoQuery query);

    int countCarinfoByQuuery(TransitCarInfoQuery query);

    List<TransitCarBaseinfo> selectCarListByCarTeam(Map<String,String> parameterMap);
    //车牌号查询车辆信息
    List<TransitCarBaseinfo> selectByCarPlateNum(TransitCarInfoQuery query);

    TransitCarBaseinfo selectCarInfoByQuery(TransitCarInfoQuery carInfoQuery);

    TransitCarBaseinfo selectCarInfoByQueryNew(TransitCarInfoQuery carInfoQuery);
}
