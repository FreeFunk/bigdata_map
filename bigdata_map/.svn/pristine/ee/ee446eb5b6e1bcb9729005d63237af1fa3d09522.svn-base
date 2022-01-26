package com.edgedo.reportdata.service;

import com.edgedo.reportdata.entity.TransitCarBaseinfo;
import com.edgedo.reportdata.mapper.TransitCarInfoMapper;
import com.edgedo.reportdata.queryvo.TransitCarInfoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Zcc
 * @description 车辆信息
 * @date 2019/3/30
 */
@Service
public class TransitCarInfoService {

    @Autowired
    private TransitCarInfoMapper transitCarInfoMapper;

    public List<TransitCarBaseinfo> selectCarBaseinfoListPage(TransitCarInfoQuery query){
        return transitCarInfoMapper.selectCarBaseinfoListPage(query);
    }

    public int countCarinfoByQuuery(TransitCarInfoQuery query){
        return transitCarInfoMapper.countCarinfoByQuuery(query);
    }

    public List<TransitCarBaseinfo> selectCarListByCarTeam(Map<String,String> parameterMap){
        return transitCarInfoMapper.selectCarListByCarTeam(parameterMap);
    }

    //根据车牌号查询车辆
    public List<TransitCarBaseinfo> selectByCarPlateNum(TransitCarInfoQuery transitCarInfoQuery ) {
        return transitCarInfoMapper.selectByCarPlateNum(transitCarInfoQuery);
    }

    public TransitCarBaseinfo selectCarInfoByQuery(TransitCarInfoQuery carInfoQuery) {
        return transitCarInfoMapper.selectCarInfoByQuery(carInfoQuery);
    }
    public TransitCarBaseinfo selectCarInfoByQueryNew(TransitCarInfoQuery carInfoQuery) {
        return transitCarInfoMapper.selectCarInfoByQueryNew(carInfoQuery);
    }
}
