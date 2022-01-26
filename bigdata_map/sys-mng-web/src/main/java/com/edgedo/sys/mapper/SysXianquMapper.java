package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.queryvo.SysXianquQuery;
import com.edgedo.sys.queryvo.SysXianquView;
import com.edgedo.sys.queryvo.SysXianquViewSyn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysXianquMapper  extends BaseMapper<SysXianqu>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysXianquView> listPage(SysXianquQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysXianquView> listByObj(SysXianquQuery query);


	public List<SysXianquViewSyn> selectByParentId(String parentId);

	/**
	 * 获得所有县区
	 * @return
	 */
    List<SysXianquView> selectAllXianqu();

	/**
	 * 根据城市id获得县区列表
	 * @param cityId
	 * @return
	 */
	List<SysXianquView> selectXianquByCityId(String cityId);



}