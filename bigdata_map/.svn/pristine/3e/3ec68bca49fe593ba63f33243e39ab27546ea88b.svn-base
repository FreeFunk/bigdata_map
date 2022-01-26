package com.edgedo.reportdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.reportdata.entity.Agent;
import com.edgedo.reportdata.entity.TransitCarVarify;
import com.edgedo.reportdata.entity.YwTrainChargeBill;
import com.edgedo.reportdata.queryvo.AgentQuery;
import com.edgedo.reportdata.queryvo.TransitCarVarifyQuery;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface TransitCarVarifyMapper extends BaseMapper<TransitCarVarify> {
    /**
     * 统计县区年度的 审车情况
     * @param param
     * @return
     */
    int sumCarVarifyXianquYear(Map<String, Object> param);

    /**
     * 统计县区月度的审车情况
     * @param param
     * @return
     */
    int sumCarVarifyXianquMonth(Map<String, Object> param);

    /**
     * 分页查询
     * @param query
     */
    List<TransitCarVarify> selectCarVarifyListPage(TransitCarVarifyQuery query);


    /**
     * 统计县区每天的审车情况
     * @param param
     * @return
     */
    int sumCarVarifyXianquDay(Map<String, Object> param);
}
