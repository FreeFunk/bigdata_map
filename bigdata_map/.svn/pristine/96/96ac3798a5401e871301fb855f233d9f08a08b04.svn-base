package com.edgedo.sys.service;

import java.util.Date;
import java.util.List;

import com.edgedo.sys.entity.SysConfig;
import com.edgedo.sys.mapper.SysConfigMapper;
import com.edgedo.sys.queryvo.SysConfigQuery;
import com.edgedo.sys.queryvo.SysConfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysConfigService {
	
	
	@Autowired
	private SysConfigMapper mapper;

	
	public List<SysConfigView> listPage(SysConfigQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysConfig voObj) {
		//voObj.setId(Guid.guid());
		SysConfig test = mapper.selectById(voObj.getId());
		if(test!=null){
			return "该运行参数已存在!";
		}else {
			mapper.insert(voObj);
		}
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysConfig voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysConfig voObj) {
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
	public SysConfig loadById(String id) {
		return mapper.selectById(id);
	}

	public String getValueById(String id) {
		return mapper.getValueById(id);
	}
	

}
