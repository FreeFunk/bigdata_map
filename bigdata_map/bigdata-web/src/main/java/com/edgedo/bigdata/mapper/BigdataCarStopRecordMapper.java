package com.edgedo.bigdata.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCarStopRecord;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecordView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataCarStopRecordMapper  extends BaseMapper<BigdataCarStopRecord>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarStopRecordView> listPage(BigdataCarStopRecordQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarStopRecordView> listByObj(BigdataCarStopRecordQuery query);
	
	

}