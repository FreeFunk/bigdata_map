package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataPassProvinceRate;
import com.edgedo.bigdata.mapper.BigdataPassProvinceRateMapper;
import com.edgedo.bigdata.queryvo.BigdataPassProvinceRateQuery;
import com.edgedo.bigdata.queryvo.BigdataPassProvinceRateView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataPassProvinceRateService {
	
	
	@Autowired
	private BigdataPassProvinceRateMapper mapper;

	
	public List<BigdataPassProvinceRateView> listPage(BigdataPassProvinceRateQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataPassProvinceRate voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataPassProvinceRate voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataPassProvinceRate voObj) {
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
	public BigdataPassProvinceRate loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataPassProvinceRateView getPassProvinceRate(BigdataPassProvinceRateQuery query) {

		String countType = query.getQueryObj().getCountType();
		if(countType!=null && countType.equals("QUARTER")){
			String quarter = DateUtil.getQuarter(query.getQueryObj().getCountTime());
			query.getQueryObj().setQuarterType(quarter);
		}
		//本月记录
		BigdataPassProvinceRateView bigdataPassProvinceRateView = mapper.getPassProvinceRate(query);
		return bigdataPassProvinceRateView;
	}
}
