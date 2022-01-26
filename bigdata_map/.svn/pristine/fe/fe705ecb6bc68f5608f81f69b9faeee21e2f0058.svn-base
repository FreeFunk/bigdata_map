package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFenxiTeamDay;
import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.bigdata.entity.BigdataFenxiTeamWeek;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamDayMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFenxiTeamDayService {
	
	
	@Autowired
	private BigdataFenxiTeamDayMapper mapper;

	
	public List<BigdataFenxiTeamDayView> listPage(BigdataFenxiTeamDayQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiTeamDay voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataFenxiTeamDay voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiTeamDay voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public BigdataFenxiTeamDay loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataFenxiTeamWeek countMileageByWeek(Map<String, Object> map) {
		return mapper.countMileageByWeek(map);
	}

	public BigdataFenxiTeamMonth countMileageByMonth(Map<String, Object> map) {
		return mapper.countMileageByMonth(map);
	}

	/*public List<BigdataFenxiTeamDay> selectByWeekTopRunMileage(Map<String, Object> map) {
		return mapper.selectByWeekTopRunMileage(map);
	}*/

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateByIdAndYearAndMonthAndDay(BigdataFenxiTeamDay bigdataFenxiTeamDay) {
		mapper.updateByIdAndYearAndMonthAndDay(bigdataFenxiTeamDay);
	}
}
