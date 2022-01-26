package com.edgedo.drawing.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.drawing.entity.BigdataDriverCardInfo;
import com.edgedo.drawing.mapper.BigdataDriverCardInfoMapper;
import com.edgedo.drawing.queryvo.BigdataDriverCardInfoQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCardInfoView;
import com.edgedo.common.util.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataDriverCardInfoService {
	
	
	@Autowired
	private BigdataDriverCardInfoMapper mapper;

	
	public List<BigdataDriverCardInfoView> listPage(BigdataDriverCardInfoQuery query){
		List<BigdataDriverCardInfoView> list = mapper.listPage(query);
		for(BigdataDriverCardInfoView c:list){
			c.setDriverPhone(StringTool.encodeImportentNum(c.getDriverPhone()));
			c.setDriverCode(StringTool.encodeImportentNum(c.getDriverCode()));
		}
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverCardInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverCardInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverCardInfo voObj) {
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
	public BigdataDriverCardInfo loadById(String id) {
		BigdataDriverCardInfo bigdataDriverCardInfo = mapper.selectById(id);
		bigdataDriverCardInfo.setDriverPhone(StringTool.encodeImportentNum(bigdataDriverCardInfo.getDriverPhone()));
		bigdataDriverCardInfo.setDriverCode(StringTool.encodeImportentNum(bigdataDriverCardInfo.getDriverCode()));
		bigdataDriverCardInfo.setDriverIdCard(StringTool.encodeImportentNum(bigdataDriverCardInfo.getDriverIdCard()));
		return bigdataDriverCardInfo;
	}
	

}
