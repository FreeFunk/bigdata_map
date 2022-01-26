package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataCarDayOftenrunRoute;
import com.edgedo.bigdata.mapper.BigdataCarDayOftenrunRouteMapper;
import com.edgedo.bigdata.queryvo.BigdataCarDayOftenrunRouteQuery;
import com.edgedo.bigdata.queryvo.BigdataCarDayOftenrunRouteView;
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
public class BigdataCarDayOftenrunRouteService {
	
	
	@Autowired
	private BigdataCarDayOftenrunRouteMapper mapper;

	
	public List<BigdataCarDayOftenrunRouteView> listPage(BigdataCarDayOftenrunRouteQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataCarDayOftenrunRoute voObj) {
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
	public String update(BigdataCarDayOftenrunRoute voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataCarDayOftenrunRoute voObj) {
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
	public BigdataCarDayOftenrunRoute loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 统计某辆车的某个月的线路信息
	 * @param countMonth
	 * @param carRealId
	 * @return
	 */
    public List<BigdataCarDayOftenrunRoute> selectGroupSumOfMonth(
    		Integer countMonth, String carRealId) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("carRealId",carRealId);
		return mapper.selectGroupSumOfMonth(param);
    }

	/**
	 * 根据主键和统计月份
	 * @param id
	 * @param countMonth
	 * @return
	 */
    public BigdataCarDayOftenrunRoute loadByIdAndDate(String id, Integer countMonth) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		param.put("countMonth",countMonth);
		return mapper.loadByIdAndDate(param);
    }

}
