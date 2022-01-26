package com.edgedo.reportdata.service;

import com.edgedo.reportdata.entity.TransitCarVarify;
import com.edgedo.reportdata.mapper.TransitCarVarifyMapper;
import com.edgedo.reportdata.queryvo.TransitCarVarifyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransitCarVarifyService {
    @Autowired
    TransitCarVarifyMapper carVarifyMapper;

    /**
     * 统计县区年度的车辆审车情况
     * @param cityId 所属城市  appId
     * @param xianquId 县区id
     * @param year 年度
     * @param doneFlag 是否已经完成审车
     * @return
     */
    public int sumCarVarifyXianquYear(
            String cityId,
            String xianquId,
            int year,String doneFlag) {

        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("year",year);
        param.put("doneFlag",doneFlag);

        return carVarifyMapper.sumCarVarifyXianquYear(param);
    }

    /**
     * 统计县区月度 审车情况
     * @param cityId
     * @param xianquId
     * @param searchTime
     * @param doneFlag
     * @return
     */
    public int sumCarVarifyXianquMonth(
            String cityId, String xianquId,
            Date searchTime,String doneFlag) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        param.put("doneFlag",doneFlag);
        return carVarifyMapper.sumCarVarifyXianquMonth(param);
    }



    /**
     * 统计县区月度 审车情况
     * @param cityId
     * @param xianquId
     * @param searchTime
     * @param doneFlag
     * @return
     */
    public int sumCarVarifyXianquDay(
            String cityId, String xianquId,
            Date searchTime,String doneFlag) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("cityId",cityId);
        param.put("xianquId",xianquId);
        param.put("searchTime",searchTime);
        param.put("doneFlag",doneFlag);
        return carVarifyMapper.sumCarVarifyXianquDay(param);
    }


    /**
     * 分页查询车辆审车情况
     * @param query
     */
    public List<TransitCarVarify> listCarVarifyPage(TransitCarVarifyQuery query) {
        List<TransitCarVarify> list = carVarifyMapper.selectCarVarifyListPage(query);
        query.setList(list);
        return list;
    }

}
