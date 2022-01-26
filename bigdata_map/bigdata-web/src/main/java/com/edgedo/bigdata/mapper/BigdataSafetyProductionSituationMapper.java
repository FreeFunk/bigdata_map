package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataSafetyProductionSituation;
import com.edgedo.bigdata.queryvo.BigdataSafetyProductionSituationQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyProductionSituationView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataSafetyProductionSituationMapper  extends BaseMapper<BigdataSafetyProductionSituation>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyProductionSituationView> listPage(BigdataSafetyProductionSituationQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyProductionSituationView> listByObj(BigdataSafetyProductionSituationQuery query);


    BigdataSafetyProductionSituationView getSafetyProductionSituationData(BigdataSafetyProductionSituationQuery query);
}