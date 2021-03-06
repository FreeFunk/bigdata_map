package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFenxiCarMonth;
import com.edgedo.bigdata.mapper.BigdataFenxiCarMonthMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarMonthView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFenxiCarMonthService {
	
	
	@Autowired
	private BigdataFenxiCarMonthMapper mapper;

	
	public List<BigdataFenxiCarMonthView> listPage(BigdataFenxiCarMonthQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFenxiCarMonth voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFenxiCarMonth voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFenxiCarMonth voObj) {
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
	public BigdataFenxiCarMonth loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiCarMonth> selectByMonthQianShi(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByMonthQianShi( carType,  xianQuId,  timeCount,  timeType);
	}

	public List<BigdataFenxiCarMonth> selectByMonthHouShi(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByMonthHouShi( carType,  xianQuId,  timeCount,  timeType);
	}

	public BigdataFenxiCarMonth selectById(BigdataFenxiCarMonthQuery query){
		return mapper.selectById(query);
	}

	public List<BigdataFenxiCarMonth> selectTopTenRunMileageByTeamId(BigdataFenxiCarMonthQuery query){
		return mapper.selectTopTenRunMileageByTeamId(query);
	}

	public List<BigdataFenxiCarMonth> selectTopTenAlarmNumByTeamId(BigdataFenxiCarMonthQuery query){
		return mapper.selectTopTenAlarmNumByTeamId(query);
	}

}
