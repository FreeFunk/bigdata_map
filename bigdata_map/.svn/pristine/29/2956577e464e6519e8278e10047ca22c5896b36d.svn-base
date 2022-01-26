package com.edgedo.sys.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysMenue;
import com.edgedo.sys.queryvo.SysMenueQuery;
import com.edgedo.sys.queryvo.SysMenueView;
import com.edgedo.sys.queryvo.SysMenueViewSyn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface SysMenueMapper  extends BaseMapper<SysMenue> {
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysMenueView> listPage(SysMenueQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysMenueView> listByObj(SysMenueQuery query);

	/**
	 * 根据父节点和用户id获得菜单子节点
	 * @param param :pid父节点,:userId用户id
	 * @return
	 */
	public List<SysMenueView> getUserMenuByPidAndUserId(Map<String, Object> param);

	public List<SysMenueViewSyn> selectByPreantID(String parentId);


    String selectParentIdById(String menuId);
}