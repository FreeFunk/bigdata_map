package com.edgedo.sys.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysWxTemplateMsgconfig;
import com.edgedo.sys.mapper.SysWxTemplateMsgconfigMapper;
import com.edgedo.sys.queryvo.SysWxTemplateMsgconfigQuery;
import com.edgedo.sys.queryvo.SysWxTemplateMsgconfigView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysWxTemplateMsgconfigService {
	
	
	@Autowired
	private SysWxTemplateMsgconfigMapper mapper;

	
	public List<SysWxTemplateMsgconfigView> listPage(SysWxTemplateMsgconfigQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysWxTemplateMsgconfig voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysWxTemplateMsgconfig voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysWxTemplateMsgconfig voObj) {
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
	public SysWxTemplateMsgconfig loadById(String id) {
		return mapper.selectById(id);
	}
	

}
