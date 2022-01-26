package com.edgedo.drawing.service;

import com.edgedo.common.util.Guid;
import com.edgedo.drawing.entity.BigdataDriverCarPartitionCountDay;
import com.edgedo.drawing.entity.BigdataDriverCountDay;
import com.edgedo.drawing.mapper.BigdataDriverCarPartitionCountDayMapper;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayQuery;
import com.edgedo.drawing.queryvo.BigdataDriverCarPartitionCountDayView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BigdataDriverCarPartitionCountDayService {
	
	
	@Autowired
	private BigdataDriverCarPartitionCountDayMapper mapper;
	@Autowired
	private BigdataDriverCountDayService countDayService;

	
	public List<BigdataDriverCarPartitionCountDayView> listPage(BigdataDriverCarPartitionCountDayQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverCarPartitionCountDay voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverCarPartitionCountDay voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverCarPartitionCountDay voObj) {
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
	public BigdataDriverCarPartitionCountDay loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * @Author WangZhen
	 * @Description 没有才插入
	 * @Date 2020/2/3 21:05
	 **/
    public void insertNotExist(
    		BigdataDriverCarPartitionCountDayView driverCarPartitionCountDay) {
		int count  = mapper.selectCountByIdAndFenPian(driverCarPartitionCountDay);
		if(count==0){
			mapper.insert(driverCarPartitionCountDay);
		}
    }

    /**
     * @Author WangZhen
     * @Description 统计
     * @Date 2020/2/4 20:06
     **/
	public void updateSumDriverDayCount(String countId) {
		String[] temArr = countId.split("-");
		String driverId = temArr[0];
		String countDayStr = temArr[1];
		int countDate = new Integer(countDayStr);
		int countMonth = countDate/100;
		int yearNum = countMonth/100;
		BigdataDriverCarPartitionCountDayView
				sumPartitionCountDay = sumDriverPartitionOfDay(driverId,countDate,countMonth,yearNum);
		BigdataDriverCountDay driverCountDay = new BigdataDriverCountDay();
		driverCountDay.setId(countId);
		driverCountDay.setCountDate(countDate);
		driverCountDay.setCountMonth(countMonth);
		driverCountDay.setYearNum(yearNum);
		driverCountDay.setDriverId(driverId);


		if(sumPartitionCountDay!=null){
			driverCountDay.setCompName(sumPartitionCountDay.getCompName());
			driverCountDay.setCompId(sumPartitionCountDay.getCompId());
			driverCountDay.setTeamId(sumPartitionCountDay.getTeamId());
			driverCountDay.setTeamName(sumPartitionCountDay.getTeamName());
			driverCountDay.setProvinceId(sumPartitionCountDay.getProvinceId());
			driverCountDay.setProvinceName(sumPartitionCountDay.getProvinceName());
			driverCountDay.setCityId(sumPartitionCountDay.getCityId());
			driverCountDay.setCityName(sumPartitionCountDay.getCityName());
			driverCountDay.setXianquId(sumPartitionCountDay.getXianquId());
			driverCountDay.setXianquName(sumPartitionCountDay.getXianquName());
			driverCountDay.setDriverId(sumPartitionCountDay.getDriverId());
			driverCountDay.setDriverName(sumPartitionCountDay.getDriverName());
			driverCountDay.setDriverSex(sumPartitionCountDay.getDriverSex());
			driverCountDay.setDriverAge(sumPartitionCountDay.getDriverAge());
			driverCountDay.setDriverPhone(sumPartitionCountDay.getDriverPhone());
			driverCountDay.setDriverIdCard(sumPartitionCountDay.getDriverIdCard());
			driverCountDay.setDriverCode(sumPartitionCountDay.getDriverCode());

			//里程
			BigDecimal sumMileage = sumPartitionCountDay.getSumMileage();
			sumMileage = sumMileage==null?new BigDecimal(0):sumMileage;
			driverCountDay.setSumMileage(sumMileage);
			BigDecimal dayRunMileage = sumPartitionCountDay.getDayRunMileage();
			dayRunMileage = dayRunMileage==null?new BigDecimal(0):dayRunMileage;
			driverCountDay.setDayRunMileage(dayRunMileage);
			BigDecimal nightRunMileage = sumPartitionCountDay.getNightRunMileage();
			nightRunMileage = nightRunMileage==null?new BigDecimal(0):nightRunMileage;
			driverCountDay.setNightRunMileage(nightRunMileage);
			BigDecimal dangerRunMileage = sumPartitionCountDay.getDangerRunMileage();
			dangerRunMileage = dangerRunMileage==null?new BigDecimal(0):dangerRunMileage;
			driverCountDay.setDangerRunMileage(dangerRunMileage);
			//时长
			BigDecimal sumRunTimeLength = sumPartitionCountDay.getSumRunTimeLength();
			sumRunTimeLength = sumRunTimeLength==null?new BigDecimal(0):sumRunTimeLength;
			driverCountDay.setSumRunTimeLength(sumRunTimeLength);
			BigDecimal dayRunTimeLength = sumPartitionCountDay.getDayRunTimeLength();
			dayRunTimeLength = dayRunTimeLength==null?new BigDecimal(0):dayRunTimeLength;
			driverCountDay.setDayRunTimeLength(dayRunTimeLength);
			BigDecimal nightRunTimeLength = sumPartitionCountDay.getNightRunTimeLength();
			nightRunTimeLength = nightRunTimeLength==null?new BigDecimal(0):nightRunTimeLength;
			driverCountDay.setNightRunTimeLength(nightRunTimeLength);
			BigDecimal dangerRunTimeLength = sumPartitionCountDay.getDangerRunTimeLength();
			dangerRunTimeLength = dangerRunTimeLength==null?new BigDecimal(0):dangerRunTimeLength;
			driverCountDay.setDangerRunTimeLength(dangerRunTimeLength);

			//平均速度
			if(sumRunTimeLength.intValue()==0){
				driverCountDay.setAverageSpeed(new BigDecimal(0));
			}else{
				driverCountDay.setAverageSpeed(
						sumMileage.multiply(new BigDecimal(60))
						.divide( sumRunTimeLength,3, BigDecimal.ROUND_FLOOR ));
			}

			if(dayRunTimeLength.intValue()==0){
				driverCountDay.setDayRunAverageSpeed(new BigDecimal(0));
			}else{
				//求平均速度
				driverCountDay.setDayRunAverageSpeed(
						dayRunMileage.multiply(new BigDecimal(60))
								.divide( dayRunTimeLength,3, BigDecimal.ROUND_FLOOR ));
			}

			if(nightRunTimeLength.intValue()==0){
				driverCountDay.setNightRunAverageSpeed(new BigDecimal(0));
			}else{
				//求平均速度
				driverCountDay.setNightRunAverageSpeed(
						nightRunMileage.multiply(new BigDecimal(60))
								.divide(nightRunTimeLength,3, BigDecimal.ROUND_FLOOR ));
			}
			if(dangerRunTimeLength.intValue()==0){
				driverCountDay.setDangerRunAverageSpeed(new BigDecimal(0));
			}else{
				//求平均速度
				driverCountDay.setDangerRunAverageSpeed(
						dangerRunMileage.multiply(new BigDecimal(60))
								.divide(dangerRunTimeLength,3, BigDecimal.ROUND_FLOOR ));
			}
			driverCountDay.setHighestSpeed(sumPartitionCountDay.getHighestSpeed());

		}else{
			//里程
			driverCountDay.setSumMileage(new BigDecimal(0));
			driverCountDay.setDayRunMileage(new BigDecimal(0));
			driverCountDay.setNightRunMileage(new BigDecimal(0));
			driverCountDay.setDangerRunMileage(new BigDecimal(0));
			//时长
			driverCountDay.setSumRunTimeLength(new BigDecimal(0));
			driverCountDay.setDayRunTimeLength(new BigDecimal(0));
			driverCountDay.setNightRunTimeLength(new BigDecimal(0));
			driverCountDay.setDangerRunTimeLength(new BigDecimal(0));

			//平均速度
			driverCountDay.setAverageSpeed(new BigDecimal(0));
			driverCountDay.setDayRunAverageSpeed(new BigDecimal(0));
			driverCountDay.setNightRunAverageSpeed(new BigDecimal(0));
			driverCountDay.setDangerRunAverageSpeed(new BigDecimal(0));
			driverCountDay.setHighestSpeed(new BigDecimal(0));
		}
		countDayService.insertOrUpdateByIdAndFenpian(driverCountDay);


	}

	/**
	 * @Author WangZhen
	 * @Description 查询某个司机某一天的分段统计
	 * 汇总某个人的某天的 总里程 总时长，白天 晚上 危险时段
	 * @Date 2020/2/4 20:14
	 **/
	public BigdataDriverCarPartitionCountDayView sumDriverPartitionOfDay(
			String driverId, int countDate, int countMonth, int yearNum) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("driverId",driverId);
		param.put("countDate",countDate);
		param.put("countMonth",countMonth);
		param.put("yearNum",yearNum);
		return mapper.sumDriverPartitionOfDay(param);
	}

}
