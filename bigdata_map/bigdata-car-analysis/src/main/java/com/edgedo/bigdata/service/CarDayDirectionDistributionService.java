package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.CarDayDirectionDistribution;
import com.edgedo.bigdata.mapper.CarDayDirectionDistributionMapper;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionQuery;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class CarDayDirectionDistributionService {

	private SimpleDateFormat sdfMonth = new SimpleDateFormat("yyyy-MM");
	
	@Autowired
	private CarDayDirectionDistributionMapper mapper;

	
	public List<CarDayDirectionDistributionView> listPage(CarDayDirectionDistributionQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(CarDayDirectionDistribution voObj) {
		String id = voObj.getId();
		if(id==null){
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
	public String update(CarDayDirectionDistribution voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(CarDayDirectionDistribution voObj) {
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
	public CarDayDirectionDistribution loadById(String id) {
		return mapper.selectById(id);
	}


	public List<CarDayDirectionDistributionView> getDataForCarDirection(CarDayDirectionDistributionQuery query) {
		//查询前五名的省份
		List<CarDayDirectionDistributionView> carDayDirectionDistributionViewList = mapper.getDataForCarDirection(query);
		//查询出其他的汇总的车辆数
		Integer countOtherCarNum = mapper.countOtherCarNum(query);
		if(countOtherCarNum==null){
			countOtherCarNum = 0;
		}
		return carDayDirectionDistributionViewList;
	}

	/**
	 * 分组统计去向分布
	 * @param countMonth 统计月度整数
	 * @param yearNum 统计年份-分片
	 * @return
	 */
    public List<CarDayDirectionDistributionView> listQuxiangGroupSumOfMonthProvince(
    		Integer countMonth,Integer yearNum
	) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("yearNum",yearNum);
		return mapper.listQuxiangGroupSumOfMonthProvince(param);
    }

	/**
	 * 汇总月度的去向统计
	 * @param countMonth 统计月度整数
	 * @param yearNum 统计年份-分片
	 * @return
	 */
    public List<CarDayDirectionDistributionView> listQuxiangGroupSumOfMonthCity(Integer countMonth,Integer yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countMonth",countMonth);
		param.put("yearNum",yearNum);
		return mapper.listQuxiangGroupSumOfMonthCity(param);
    }

	/**
	 * 根据主键和分片字段查询
	 * @param id
	 * @param yearNum
	 * @return
	 */
    public CarDayDirectionDistribution loadByIdAndDate(String id, Integer yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		param.put("yearNum",yearNum);
		return mapper.loadByIdAndDate(param);
    }

}
