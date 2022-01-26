package com.edgedo.drawing.service;

import com.edgedo.drawing.entity.BigdataDriverCountDay;
import com.edgedo.drawing.mapper.BigdataDriverCountDayMapper;
import com.edgedo.drawing.queryvo.BigdataDriverCountDayQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCountDayView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BigdataDriverCountDayService {
	
	
	@Autowired
	private BigdataDriverCountDayMapper mapper;

	
	public List<BigdataDriverCountDayView> listPage(BigdataDriverCountDayQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverCountDay voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverCountDay voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverCountDay voObj) {
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
	public BigdataDriverCountDay loadById(String id) {
		return mapper.selectById(id);
	}


	public void insertOrUpdate(BigdataDriverCountDay bigdataDriverCountDay) {
		BigdataDriverCountDay bigdataDriverCountDay1 = mapper.selectByVo(bigdataDriverCountDay);
		if(bigdataDriverCountDay1==null){
			bigdataDriverCountDay.setCreateTime(new Date());
			bigdataDriverCountDay.setId(bigdataDriverCountDay.getDriverId()+"-"+bigdataDriverCountDay.getCountDate());
			//初始化里程信息
			bigdataDriverCountDay.setNationalRoadMileage(new BigDecimal("0"));
			bigdataDriverCountDay.setHighSpeedMileage(new BigDecimal("0"));
			bigdataDriverCountDay.setOtherRoadMileage(new BigDecimal("0"));
			bigdataDriverCountDay.setDayRunMileage(new BigDecimal("0"));
			bigdataDriverCountDay.setNightRunMileage(new BigDecimal("0"));
			bigdataDriverCountDay.setDangerRunMileage(new BigDecimal("0"));
			bigdataDriverCountDay.setSumMileage(new BigDecimal("0"));
			//初始化时长
			bigdataDriverCountDay.setDayRunTimeLength(new BigDecimal("0"));
			bigdataDriverCountDay.setNightRunTimeLength(new BigDecimal("0"));
			bigdataDriverCountDay.setDangerRunTimeLength(new BigDecimal("0"));
			bigdataDriverCountDay.setSumRunTimeLength(new BigDecimal("0"));
			//初始化速度
			bigdataDriverCountDay.setDayRunAverageSpeed(new BigDecimal("0"));
			bigdataDriverCountDay.setNightRunAverageSpeed(new BigDecimal("0"));
			bigdataDriverCountDay.setDangerRunAverageSpeed(new BigDecimal("0"));
			bigdataDriverCountDay.setAverageSpeed(new BigDecimal("0"));
			bigdataDriverCountDay.setHighestSpeed(new BigDecimal("0"));
			bigdataDriverCountDay.setSafetrainNum(0);
			bigdataDriverCountDay.setWarningRate(new BigDecimal("0"));
			mapper.insert(bigdataDriverCountDay);
		}else {
			bigdataDriverCountDay.setId(bigdataDriverCountDay1.getId());
			bigdataDriverCountDay.setCreateTime(new Date());
			mapper.updateByFenPian(bigdataDriverCountDay);
		}
	}


	/**
	 * @Author WangZhen
	 * @Description 新增或者修改 某个日统计
	 * @Date 2020/2/4 20:40
	 **/
	public void insertOrUpdateByIdAndFenpian(
			BigdataDriverCountDay driverCountDay) {
		BigdataDriverCountDay ora = mapper.selectByIdAndFenpian(driverCountDay);
		if(ora==null){
			driverCountDay.setCreateTime(new Date());
			driverCountDay.setOverspeedNum(0);
			driverCountDay.setSeriousOverspeedNum(0);
			driverCountDay.setTiredNum(0);
			driverCountDay.setSeriousTiredNum(0);
			driverCountDay.setSafetyWarningNum(0);
			driverCountDay.setSafetrainNum(0);
			driverCountDay.setWarningRate(new BigDecimal(0));
			mapper.insert(driverCountDay);
		}else {
			driverCountDay.setCreateTime(null);
			mapper.updateByFenPian(driverCountDay);
		}
	}
}
