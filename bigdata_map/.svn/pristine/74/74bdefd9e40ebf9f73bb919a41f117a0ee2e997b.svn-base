package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysWxPayRecord;
import com.edgedo.sys.queryvo.SysWxPayRecordQuery;
import com.edgedo.sys.queryvo.SysWxPayRecordView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysWxPayRecordMapper  extends BaseMapper<SysWxPayRecord>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysWxPayRecordView> listPage(SysWxPayRecordQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysWxPayRecordView> listByObj(SysWxPayRecordQuery query);

	/**
	 * 修改预支付记录为已处理，需判断预支付记录状态
	 * @param record
	 * @return
	 */
    int updateSuccess(SysWxPayRecord record);

}