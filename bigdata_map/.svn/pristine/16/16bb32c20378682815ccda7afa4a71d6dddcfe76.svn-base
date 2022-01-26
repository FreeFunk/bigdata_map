package com.edgedo.sys.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysBzModel;
import com.edgedo.sys.entity.SysPower;
import com.edgedo.sys.queryvo.SysPowerQuery;
import com.edgedo.sys.queryvo.SysPowerView;
import com.edgedo.sys.queryvo.SysPowerViewSyn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface SysPowerMapper  extends BaseMapper<SysPower> {
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysPowerView> listPage(SysPowerQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysPowerView> listByObj(SysPowerQuery query);

	/**
	 * 根据用户获得用户所拥有的权限
	 * @param userId 用户id
	 * @return
	 */
	public List<SysPowerView> selectPowerByUserId(String userId);


	/**
	 * 根据父节点查询;
	 * @param parentId
	 */
	List<SysPowerViewSyn> selectByPreantID(String parentId);

	/**
	 * 查询菜单的名字
	 * @param menueId
	 * @return
	 */
    List<SysBzModel> selectModelById(String menueId);
}