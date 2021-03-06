package com.edgedo.bigdata.mapper;

import java.util.List;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataTimeCarDayRec;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecQuery;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface BigdataTimeCarDayRecMapper  extends BaseMapper<BigdataTimeCarDayRec>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTimeCarDayRecView> listPage(BigdataTimeCarDayRecQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataTimeCarDayRecView> listByObj(BigdataTimeCarDayRecQuery query);


    List<BigdataTimeCarDayRec> selectByDayQianShi(String carType, String xianQuId, Integer timeCount, String timeType,Integer countMonth);

	List<BigdataTimeCarDayRec> selectByDayHouShi(String carType, String xianQuId, Integer timeCount, String timeType,Integer countMonth);
	BigDecimal searchMileageByCarInfo(BigdataTimeCarDayRecQuery query);

	BigDecimal searchSpeedByCarInfo(BigdataTimeCarDayRecQuery query);

	public BigdataTimeCarDayRec selectByCarFrameNumAndCountDate(BigdataTimeCarDayRecQuery query);

	List<BigdataTimeCarDayRecView> listPageIsOverSpeed(BigdataTimeCarDayRecQuery query);
}