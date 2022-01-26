package com.edgedo.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysBzModel;
import com.edgedo.sys.entity.SysPower;
import com.edgedo.sys.mapper.SysBzModelMapper;
import com.edgedo.sys.mapper.SysPowerMapper;
import com.edgedo.sys.queryvo.SysBzModelViewSyn;
import com.edgedo.sys.queryvo.SysPowerQuery;
import com.edgedo.sys.queryvo.SysPowerView;
import com.edgedo.sys.queryvo.SysPowerViewSyn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysPowerService {
	
	
	@Autowired
	private SysPowerMapper mapper;
	@Autowired
	private SysBzModelMapper mapper2;

	public SysBzModelMapper getMapper2() {
		return mapper2;
	}

	public void setMapper2(SysBzModelMapper mapper2) {
		this.mapper2 = mapper2;
	}

	public List<SysPowerView> listPage(SysPowerQuery query){
		List <SysPowerView> list = mapper.listPage(query);
		for(SysPowerView s: list){
			if(s.getMenueId().equals("ROOT")){
				s.setModelName("模块权限管理");
			}else{
				//获取他的菜单的名字;
				List<SysBzModel> list2 =mapper.selectModelById(s.getMenueId());
				for(SysBzModel sysBzModel :list2){
					sysBzModel.getModelName();
					s.setModelName(sysBzModel.getModelName());
				}
			}
		}
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysPower voObj) {
		voObj.setId(Guid.guid());
		voObj.setCreateTime(new Date());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysPower voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysPower voObj) {
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
	public SysPower loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 用户的权限map
	 * @param userId 用户id
	 */
	public Map<String, Boolean> getUserPowerMap(String userId) {
		List<SysPowerView> list = mapper.selectPowerByUserId(userId);
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		for(SysPowerView power:list){
			String key = power.getPowerKey();
			map.put(key,true);
			String diKey = power.getDiKey();
			if(diKey!=null && diKey.length()>0){
				String[] keys = diKey.split(",");
				for(String s:keys){
					map.put(s,true);
				}
			}
		}
		return map;
	}


    public List<SysPowerViewSyn> selectByPreantID(String parentId) {
		return mapper.selectByPreantID(parentId);
    }

	/**
	 * 根据用户的id获得所有用户的权限
	 * @param userId
	 * @return
	 */
    public List<SysPowerView> selectPowerByUserId(String userId) {
		return mapper.selectPowerByUserId(userId);
    }

	/**
	 *
	 * @param parentId
	 * @return
	 */
	public List<SysBzModelViewSyn> selectBzModelByParentId(String parentId) {
    	return mapper2.selectBzModelByParentId(parentId);
	}

	public List<SysBzModelViewSyn> selectBzModelById(String id) {
		return mapper2.selectBzModelById(id);
	}
}
