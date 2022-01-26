package com.edgedo.bigdata.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.queryvo.CarInfoQuery;
import com.edgedo.bigdata.queryvo.CarInfoView;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface CarInfoMapper  extends BaseMapper<CarInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarInfoView> listPage(CarInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<CarInfoView> listByObj(CarInfoQuery query);
	
	public int countCarinfoByQuery(CarInfoQuery query);

	public List<CarInfoView> carinfoByQuery(CarInfoQuery query);

	public List<BigDecimal> searchMileageByCarInfo(CarInfoQuery query);

	public BigDecimal searchMileageOneByQuery(CarInfoQuery query);

	public List<BigDecimal> searchSpeedByCarInfo(CarInfoQuery query);

	public BigDecimal searchSpeedOneByQuery(CarInfoQuery query);

	public CarInfo selectByPlateNumFrameNum(Map<String,String> paramMap);

    int countZhygCarSumNum();

	int countCarSumNum(Map<String, Object> map);
}