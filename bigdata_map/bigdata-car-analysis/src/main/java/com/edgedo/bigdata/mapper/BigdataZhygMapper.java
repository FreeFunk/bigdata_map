package com.edgedo.bigdata.mapper;

import com.edgedo.bigdata.entity.Emp;
import com.edgedo.bigdata.entity.TransitCarBaseinfo;
import com.edgedo.bigdata.entity.TransitCarTeam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataZhygMapper{

    //根据车牌号和车牌颜色
    TransitCarBaseinfo selectCarWithEmpInfoByCarPlateAndColor(Map<String,Object> param);

    /**
     * @Author WangZhen
     * @Description 根据车辆id查询
     * @Date 2019/11/27 9:24
     **/
    Emp selectEmpByCarId(String id);
    /**
     * @Author WangZhen
     * @Description 根据主键查询车队
     * @Date 2019/11/27 10:13
     **/
    TransitCarTeam selectTeamInfoById(String teamId);

    List<TransitCarTeam> selectTeamList();

    int countCarSumByTeamId(String teamId);
}