package com.edgedo.sys.service;

import java.util.Date;
import java.util.List;

import com.edgedo.sys.entity.SysRolePower;
import com.edgedo.sys.mapper.SysRolePowerMapper;
import com.edgedo.sys.queryvo.SysRolePowerQuery;
import com.edgedo.sys.queryvo.SysRolePowerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysRolePowerService {
	
	
	@Autowired
	private SysRolePowerMapper mapper;

	
	public List<SysRolePowerView> listPage(SysRolePowerQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysRolePower voObj) {
		//voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysRolePower voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysRolePower voObj) {
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
	public SysRolePower loadById(String id) {
		return mapper.selectById(id);
	}
	

}
