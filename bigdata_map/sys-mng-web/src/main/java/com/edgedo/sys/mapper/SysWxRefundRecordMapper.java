package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysWxRefundRecord;
import com.edgedo.sys.queryvo.SysWxRefundRecordQuery;
import com.edgedo.sys.queryvo.SysWxRefundRecordView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysWxRefundRecordMapper  extends BaseMapper<SysWxRefundRecord>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysWxRefundRecordView> listPage(SysWxRefundRecordQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysWxRefundRecordView> listByObj(SysWxRefundRecordQuery query);
	
	

}