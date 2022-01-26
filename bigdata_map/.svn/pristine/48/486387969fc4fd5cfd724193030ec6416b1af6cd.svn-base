package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysConfig;
import com.edgedo.sys.queryvo.SysConfigQuery;
import com.edgedo.sys.queryvo.SysConfigView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysConfigMapper  extends BaseMapper<SysConfig>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysConfigView> listPage(SysConfigQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysConfigView> listByObj(SysConfigQuery query);


    String getValueById(String id);
}