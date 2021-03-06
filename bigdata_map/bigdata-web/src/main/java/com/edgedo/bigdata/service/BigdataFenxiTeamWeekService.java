package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFenxiTeamWeek;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamWeekMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamWeekView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFenxiTeamWeekService {
	
	
	@Autowired
	private BigdataFenxiTeamWeekMapper mapper;

	
	public List<BigdataFenxiTeamWeekView> listPage(BigdataFenxiTeamWeekQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFenxiTeamWeek voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFenxiTeamWeek voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFenxiTeamWeek voObj) {
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
	public BigdataFenxiTeamWeek loadById(String id) {
		return mapper.selectById(id);
	}


    public List<BigdataFenxiTeamWeek> selectByWeekAnQuanQianShi(String carType, String xianQuId, Integer timeChangeWeek) {
    	return mapper.selectByWeekAnQuanQianShi( carType,  xianQuId,  timeChangeWeek);
	}

	public List<BigdataFenxiTeamWeek> selectByWeekAnQuanHouShi(String carType, String xianQuId, Integer timeChangeWeek) {
		return mapper.selectByWeekAnQuanHouShi( carType,  xianQuId,  timeChangeWeek);
	}

	public List<BigdataFenxiTeamWeek> selectByWeekBaiGongLiQianShi(String carType, String xianQuId, Integer timeChangeWeek) {
		return mapper.selectByWeekBaiGongLiQianShi( carType,  xianQuId,  timeChangeWeek);
	}

	public List<BigdataFenxiTeamWeek> selectByWeekBaiGongLiHouShi(String carType, String xianQuId, Integer timeChangeWeek) {
		return mapper.selectByWeekBaiGongLiHouShi( carType,  xianQuId,  timeChangeWeek);
	}

	public BigdataFenxiTeamWeek selectById(BigdataFenxiTeamWeekQuery query){
		return mapper.selectById(query);
	}

	public BigdataFenxiTeamWeek selectByTeamId(BigdataFenxiTeamWeekQuery query){
		return mapper.selectByTeamId(query);
	}
}
