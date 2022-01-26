package com.edgedo.sys.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.queryvo.SysProviceQuery;
import com.edgedo.sys.queryvo.SysProviceView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
	 * @Author 王斌
	 * 根据省的名字查省份
	 * @param provinceName
	 * @return
	 */
	public List selectByName(String provinceName);
}