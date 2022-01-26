package com.edgedo.bigdata.service;
		
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataBeidouSafetyCarInfo;
import com.edgedo.bigdata.mapper.BigdataBeidouSafetyCarInfoMapper;
import com.edgedo.bigdata.queryvo.BigdataBeidouSafetyCarInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouSafetyCarInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataBeidouSafetyCarInfoService {
	
	
	@Autowired
	private BigdataBeidouSafetyCarInfoMapper mapper;

	
	public List<BigdataBeidouSafetyCarInfoView> listPage(BigdataBeidouSafetyCarInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataBeidouSafetyCarInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataBeidouSafetyCarInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataBeidouSafetyCarInfo voObj) {
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
	public BigdataBeidouSafetyCarInfo loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataBeidouSafetyCarInfo selectByCarPlateNumAndColor(String carPlateNum, String carPlateColor) {
		Map<String,String> map = new HashMap<>();
		map.put("carPlateNum",carPlateNum);
		map.put("carPlateColor",carPlateColor);
		return mapper.selectByCarPlateNumAndColor(map);
	}
}
