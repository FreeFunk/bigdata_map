package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.CarDayDirectionDistribution;
import com.edgedo.bigdata.mapper.CarDayDirectionDistributionMapper;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionQuery;
import com.edgedo.bigdata.queryvo.CarDayDirectionDistributionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDayDirectionDistributionService {
	
	
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
	public String insert(CarDayDirectionDistribution voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(CarDayDirectionDistribution voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(CarDayDirectionDistribution voObj) {
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
	public CarDayDirectionDistribution loadById(String id) {
		return mapper.selectById(id);
	}


	public List<CarDayDirectionDistributionView> getDataForCarDirection(CarDayDirectionDistributionQuery query) {
		//查询前五名的省份
 		List<CarDayDirectionDistributionView> carDayDirectionDistributionViewList = mapper.getDataForCarDirection(query);
		//统计前五名的车辆数
		int carNum = 0;
		for(CarDayDirectionDistributionView c:carDayDirectionDistributionViewList){
			carNum += c.getCarNum();
		}
		//查询总的车辆数
		Integer countSumCarNum = mapper.countSumCarNum(query);
		if(countSumCarNum==null){
			countSumCarNum = 0;
		}
		int countOtherCarNum = countSumCarNum -carNum;
		CarDayDirectionDistributionView carDayDirectionDistributionView = new CarDayDirectionDistributionView();
		carDayDirectionDistributionView.setProvinceName("其他");
		carDayDirectionDistributionView.setCarNum(countOtherCarNum);
		carDayDirectionDistributionViewList.add(carDayDirectionDistributionView);
		return carDayDirectionDistributionViewList;
	}
}
