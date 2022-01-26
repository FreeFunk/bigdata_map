package com.edgedo.bigdata.service;
		
import java.util.List;
import java.math.BigDecimal;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataTimeCarDayRec;
import com.edgedo.bigdata.mapper.BigdataTimeCarDayRecMapper;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataTimeCarDayRecService {
	
	
	@Autowired
	private BigdataTimeCarDayRecMapper mapper;
	
	public List<BigdataTimeCarDayRecView> listPage(BigdataTimeCarDayRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	public List<BigdataTimeCarDayRecView> listPageIsOverSpeed(BigdataTimeCarDayRecQuery query) {
		List list = mapper.listPageIsOverSpeed(query);
		query.setList(list);
		return list;
	}
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataTimeCarDayRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataTimeCarDayRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataTimeCarDayRec voObj) {
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
	public BigdataTimeCarDayRec loadById(String id) {
		return mapper.selectById(id);
	}


    public List<BigdataTimeCarDayRec> selectByDayQianShi(String carType, String xianQuId, Integer timeCount, String timeType,Integer countMonth) {
    	return mapper.selectByDayQianShi( carType,  xianQuId,  timeCount,  timeType,countMonth);
	}

	public List<BigdataTimeCarDayRec> selectByDayHouShi(String carType, String xianQuId, Integer timeCount, String timeType,Integer countMonth) {
		return mapper.selectByDayHouShi( carType,  xianQuId,  timeCount,  timeType,countMonth);
	}

	public BigDecimal searchMileageByCarInfo(BigdataTimeCarDayRecQuery query) {
		return mapper.searchMileageByCarInfo(query);
	}

	public BigDecimal searchSpeedByCarInfo(BigdataTimeCarDayRecQuery query) {
		return  mapper.searchSpeedByCarInfo(query);
	}

	//根据车架号和日期查询
	public BigdataTimeCarDayRec selectByCarFrameNumAndCountDate(BigdataTimeCarDayRecQuery query){
		return mapper.selectByCarFrameNumAndCountDate(query);
	}


}
