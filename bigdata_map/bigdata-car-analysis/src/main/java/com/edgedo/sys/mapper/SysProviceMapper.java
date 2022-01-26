package com.edgedo.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.queryvo.SysProviceQuery;
import com.edgedo.sys.queryvo.SysProviceView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysProviceMapper  extends BaseMapper<SysProvice> {
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysProviceView> listPage(SysProviceQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysProviceView> listByObj(SysProviceQuery query);

	public List<SysProviceView> selectByParentId(String parentId);


	/**
	 * 根据省份名查询一个省份
	 * @param provinceName
	 * @return
	 */
    SysProvice selectOneByName(String provinceName);

}