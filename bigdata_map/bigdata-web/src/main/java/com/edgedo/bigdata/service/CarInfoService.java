package com.edgedo.bigdata.service;
		
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.bigdata.queryvo.PeccancyRecQuery;
import com.edgedo.bigdata.queryvo.PeccancyRecView;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.mapper.CarInfoMapper;
import com.edgedo.bigdata.queryvo.CarInfoQuery;
import com.edgedo.bigdata.queryvo.CarInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarInfoService {
	
	
	@Autowired
	private CarInfoMapper mapper;

	
	public List<CarInfoView> listPage(CarInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(CarInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(CarInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(CarInfo voObj) {
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
	public CarInfo loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * @author Zcc
	 * @Description 根据查询条件查询车辆的数量
	 * @date 2019/4/1
	 * @param
	 * @return int
	*/
	public int countCarinfoByQuery(CarInfoQuery query){
		return mapper.countCarinfoByQuery(query);
	}

	/**
	 * @author Zcc
	 * @Description
	 * @date 2019/4/1
	 * @param
	 * @return java.util.List<com.edgedo.bigdata.queryvo.CarInfoView>
	*/
	public List<CarInfoView> carinfoByQuery(CarInfoQuery query){
		return mapper.carinfoByQuery(query);
	}

	public List<BigDecimal> searchMileageByCarInfo(CarInfoQuery query){
		return mapper.searchMileageByCarInfo(query);
	}

	public BigDecimal searchMileageOneByQuery(CarInfoQuery query){
		return mapper.searchMileageOneByQuery(query);
	}

	public List<BigDecimal> searchSpeedByCarInfo(CarInfoQuery query){
		return mapper.searchSpeedByCarInfo(query);
	}

	public BigDecimal searchSpeedOneByQuery(CarInfoQuery query){
		return mapper.searchSpeedOneByQuery(query);
	}

	public CarInfo selectByPlateNumFrameNum(Map<String,String> paramMap){
		return mapper.selectByPlateNumFrameNum(paramMap);
	}

	public int countZhygCarSumNum() {
		return mapper.countZhygCarSumNum();
	}

	public int countCarSumNum(String onlineState,String operatFlag) {
		Map<String,Object> map =  new HashMap<>();
		map.put("onlineState",onlineState);
		map.put("operatFlag",operatFlag);
		return mapper.countCarSumNum(map);
	}
}
