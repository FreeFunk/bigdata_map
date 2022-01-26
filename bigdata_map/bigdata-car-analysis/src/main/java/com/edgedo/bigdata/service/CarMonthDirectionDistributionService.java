package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.CarMonthDirectionDistribution;
import com.edgedo.bigdata.mapper.CarMonthDirectionDistributionMapper;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionQuery;
import com.edgedo.bigdata.queryvo.CarMonthDirectionDistributionView;
import com.edgedo.common.util.Guid;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class CarMonthDirectionDistributionService {
	
	
	@Autowired
	private CarMonthDirectionDistributionMapper mapper;

	
	public List<CarMonthDirectionDistributionView> listPage(CarMonthDirectionDistributionQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(CarMonthDirectionDistribution voObj) {
		String id = voObj.getId();
		if(id==null || id.equals("")){
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
	public String update(CarMonthDirectionDistribution voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(CarMonthDirectionDistribution voObj) {
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
	public CarMonthDirectionDistribution loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 分组统计季度的去向汇总 --省份
	 * @param quarterType
	 * @return
	 */
	public List<CarMonthDirectionDistributionView> listQuxiangGroupSumOfJiduProvince(int quarterType) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("quarterType",quarterType);
		return mapper.listQuxiangGroupSumOfJiduProvince(param);
	}

	/**
	 * 分组统计季度的去向汇总 --城市
	 * @param quarterType
	 * @return
	 */
    public List<CarMonthDirectionDistributionView> listQuxiangGroupSumOfJiduCity(int quarterType) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("quarterType",quarterType);
		return mapper.listQuxiangGroupSumOfJiduCity(param);
    }

}
