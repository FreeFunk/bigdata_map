package com.edgedo.sys.service;

import java.util.Date;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.entity.SysUserLoginLog;
import com.edgedo.sys.mapper.SysUserLoginLogMapper;
import com.edgedo.sys.queryvo.SysUserLoginLogQuery;
import com.edgedo.sys.queryvo.SysUserLoginLogView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysUserLoginLogService {
	
	
	@Autowired
	private SysUserLoginLogMapper mapper;

	
	public List<SysUserLoginLogView> listPage(SysUserLoginLogQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysUserLoginLog voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysUserLoginLog voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysUserLoginLog voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysUserLoginLog loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 用户登录插入登录日志
	 * @param user 系统登录用户对象
	 */
	public void insertLog(SysUser user, String ipAddress) {
		SysUserLoginLog log = new SysUserLoginLog();
		log.setId(Guid.guid());
		log.setLoginTime(new Date());
		log.setUserId(user.getId());
		log.setUserCode(user.getUserCode());
		log.setUserName(user.getUserName());
		log.setUserPhone(user.getPhone());
		log.setIp(ipAddress);
		mapper.insert(log);
	}
	

}
