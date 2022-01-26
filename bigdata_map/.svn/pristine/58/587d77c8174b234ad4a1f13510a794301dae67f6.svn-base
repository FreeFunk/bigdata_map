package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.bigdata.entity.BigdataFenxiCarMonth;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFenxiCarWeek;
import com.edgedo.bigdata.mapper.BigdataFenxiCarWeekMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekView;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFenxiCarWeekService {


	@Autowired
	private BigdataFenxiCarWeekMapper mapper;


	public List<BigdataFenxiCarWeekView> listPage(BigdataFenxiCarWeekQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFenxiCarWeek voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}

	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFenxiCarWeek voObj) {
		mapper.updateById(voObj);
		return "";
	}

	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFenxiCarWeek voObj) {
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
	public BigdataFenxiCarWeek loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiCarWeek> selectByWeekQianShi(String carType, String xianQuId, Integer timeChangeAge, Integer timeChangeWeek, Integer countMonth) {
		return mapper.selectByWeekQianShi( carType,  xianQuId,  timeChangeAge,  timeChangeWeek,countMonth);
	}
	public List<BigdataFenxiCarWeek> selectByWeekHouShi(String carType, String xianQuId, Integer timeChangeAge, Integer timeChangeWeek,Integer countMonth) {
		return mapper.selectByWeekHouShi( carType,  xianQuId,  timeChangeAge,  timeChangeWeek,countMonth);
	}

	/**
	 * 根据id查询记录
	 * @param query
	 * @return
	 */
	public BigdataFenxiCarWeek selectById(BigdataFenxiCarWeekQuery query){
		return mapper.selectById(query);
	}

	/**
	 * 根据企业查询出行驶里程前10的车
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarWeek> selectTopTenRunMileageByTeamId(BigdataFenxiCarWeekQuery query){
		return mapper.selectTopTenRunMileageByTeamId(query);
	}

	/**
	 * 根据企业查询出报警数量前10的车
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarWeek> selectTopTenAlarmNumByTeamId(BigdataFenxiCarWeekQuery query){
		return mapper.selectTopTenAlarmNumByTeamId(query);
	}

}
