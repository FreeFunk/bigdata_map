package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFenxiCount;
import com.edgedo.bigdata.mapper.BigdataFenxiCountMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiCountQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCountView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFenxiCountService {
	
	
	@Autowired
	private BigdataFenxiCountMapper mapper;

	
	public List<BigdataFenxiCountView> listPage(BigdataFenxiCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFenxiCount voObj) {
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
	public String update(BigdataFenxiCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFenxiCount voObj) {
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
	public BigdataFenxiCount loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataFenxiCount selectByCarTypeAndXianQuIdAndTimeCount(String carType, String xianQuId,Integer dateNum,String timeType) {
		return mapper.selectByCarTypeAndXianQuIdAndTimeCount( carType,  xianQuId,dateNum,timeType);
	}

	public BigdataFenxiCount selectByDay(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByDay( carType,  xianQuId,  timeCount,  timeType);
	}

	public BigdataFenxiCount selectByMonth(String carType, String xianQuId, Integer timeCount, String timeType) {
		return mapper.selectByMonth( carType,  xianQuId,  timeCount,  timeType);
	}

	public BigdataFenxiCount selectByWeek(String carType, String xianQuId, String timeChangeAge, Integer timeChangeWeek, String timeType) {
		return mapper.selectByWeek( carType,  xianQuId,  timeChangeAge,timeChangeWeek,  timeType);
	}

	public List<BigdataFenxiCount> selectByTime(Integer bettTime, Integer currTime, String carType, String xianQuId, String timeType) {
		return mapper.selectByTime( bettTime,  currTime,  carType,  xianQuId,  timeType);
	}

	public List<BigdataFenxiCount> selectByTimeMonth(Integer firstArr, Integer lastArr, String carType, String xianQuId, String timeType) {
		return mapper.selectByTimeMonth( firstArr,  lastArr,  carType,  xianQuId,  timeType);
	}
}
