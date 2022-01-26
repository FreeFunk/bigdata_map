package com.edgedo.sys.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysOrg;
import com.edgedo.sys.queryvo.SysOrgQuery;
import com.edgedo.sys.queryvo.SysOrgView;
import com.edgedo.sys.queryvo.SysOrgViewSyn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface SysOrgMapper  extends BaseMapper<SysOrg> {
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysOrgView> listPage(SysOrgQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysOrgView> listByObj(SysOrgQuery query);

	//根据父节节点加载子节点
    List<SysOrgViewSyn> selectByPreantID(String parentId);
}