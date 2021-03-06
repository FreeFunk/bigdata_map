package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataSafetyWarning;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyWarningView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataSafetyWarningMapper  extends BaseMapper<BigdataSafetyWarning>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyWarningView> listPage(BigdataSafetyWarningQuery query);

	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyWarningView> qtlistPage(BigdataSafetyWarningQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataSafetyWarningView> listByObj(BigdataSafetyWarningQuery query);


	int safetyWarningCount(BigdataSafetyWarningQuery query);

    List<BigdataSafetyWarningView> selectSafetyWarningByCar(BigdataAlarmRecordQuery query);
}