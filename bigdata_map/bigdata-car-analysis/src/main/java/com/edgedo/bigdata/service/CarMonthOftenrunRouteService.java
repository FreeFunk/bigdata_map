package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.CarMonthOftenrunRoute;
import com.edgedo.bigdata.mapper.CarMonthOftenrunRouteMapper;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteQuery;
import com.edgedo.bigdata.queryvo.CarMonthOftenrunRouteView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class CarMonthOftenrunRouteService {
	
	
	@Autowired
	private CarMonthOftenrunRouteMapper mapper;

	
	public List<CarMonthOftenrunRouteView> listPage(CarMonthOftenrunRouteQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(CarMonthOftenrunRoute voObj) {
		String id = voObj.getId();
		if(id==null || id.length()==0){
			voObj.setId(Guid.guid());
		}
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(CarMonthOftenrunRoute voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(CarMonthOftenrunRoute voObj) {
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
	public CarMonthOftenrunRoute loadById(String id) {
		return mapper.selectById(id);
	}
	
	public List<CarMonthOftenrunRouteView> searchOftenRunRoute(CarMonthOftenrunRouteQuery query){
		return mapper.searchOftenRunRoute(query);
	}

	//分组统计车辆的季度的线路情况
	public List<CarMonthOftenrunRoute>  selectGroupSumOfJidu(
			int yearNum, int quarterType,
			String carRealId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("quarterType" , quarterType);
		param.put("carRealId" , carRealId);
		return mapper.selectGroupSumOfJidu(param);

	}

	/**
	 * 根据不同类型汇总月度统计
	 * @param countMonth
	 * @param carType
	 * @return
	 */
    public List<CarMonthOftenrunRoute> selectGroupSumOfMonth(Integer countMonth, String carType) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("yearNum",countMonth/100);
		param.put("carType",carType);
		return mapper.selectGroupSumOfMonth(param);
    }

	/**
	 * 因为分片的高速分表的查询
	 * @param id
	 * @param yearNum
	 * @return
	 */
	public CarMonthOftenrunRoute loadByIdAndDate(String id, int yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		param.put("yearNum",yearNum);
		return mapper.loadByIdAndDate(param);
	}

}
