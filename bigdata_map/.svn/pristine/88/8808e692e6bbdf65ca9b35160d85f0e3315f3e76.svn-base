package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouSafetyCarInfo;
import com.edgedo.bigdata.queryvo.BigdataBeidouSafetyCarInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataBeidouSafetyCarInfoView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BigdataBeidouSafetyCarInfoMapper extends BaseMapper<BigdataBeidouSafetyCarInfo>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouSafetyCarInfoView> listPage(BigdataBeidouSafetyCarInfoQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataBeidouSafetyCarInfoView> listByObj(BigdataBeidouSafetyCarInfoQuery query);


    int countByCarPlateNumAndColor(BigdataBeidouSafetyCarInfo beidouSafetyCarInfo);

	void updateByCarPlateNumAndColor(BigdataBeidouSafetyCarInfo beidouSafetyCarInfo);

	BigdataBeidouSafetyCarInfo selectByCarPlateNumAndColor(BigdataBeidouSafetyCarInfo beidouSafetyCarInfo);

}