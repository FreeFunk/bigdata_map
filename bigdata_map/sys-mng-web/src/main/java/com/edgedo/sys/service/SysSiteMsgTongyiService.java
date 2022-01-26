package com.edgedo.sys.service;

import java.util.Date;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysSiteMsgTongyi;
import com.edgedo.sys.mapper.SysSiteMsgTongyiMapper;
import com.edgedo.sys.queryvo.SysSiteMsgTongyiQuery;
import com.edgedo.sys.queryvo.SysSiteMsgTongyiView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysSiteMsgTongyiService {
	
	
	@Autowired
	private SysSiteMsgTongyiMapper mapper;
	@Autowired
	private SysSiteMsgService sysSiteMsgService;



	public List<SysSiteMsgTongyiView> listPage(SysSiteMsgTongyiQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysSiteMsgTongyi voObj, String userids) {
		voObj.setId(Guid.guid());
//		SysUser su = AdminUserLoginIntercepter.getCurrentUser();
//		voObj.setSendUserId(su.getId());
//		voObj.setSendUserName(su.getUserName());
		String title = voObj.getTitle();
		String id = voObj.getId();
		String content = voObj.getContent();
		Date createTime = new Date();
		voObj.setCreateTime(createTime);
		mapper.insert(voObj);
		sysSiteMsgService.insert(title,id,content,createTime,userids);
		return "";

	}


	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysSiteMsgTongyi voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysSiteMsgTongyi voObj) {
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
		sysSiteMsgService.deleteByownerMsg(ids);
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysSiteMsgTongyi loadById(String id) {
		return mapper.selectById(id);
	}
	

}
