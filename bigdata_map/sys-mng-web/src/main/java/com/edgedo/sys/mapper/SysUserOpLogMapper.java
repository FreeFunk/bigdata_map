package com.edgedo.sys.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysUserOpLog;
import com.edgedo.sys.queryvo.SysUserOpLogQuery;
import com.edgedo.sys.queryvo.SysUserOpLogView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface SysUserOpLogMapper  extends BaseMapper<SysUserOpLog>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserOpLogView> listPage(SysUserOpLogQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserOpLogView> listByObj(SysUserOpLogQuery query);
	
	

}