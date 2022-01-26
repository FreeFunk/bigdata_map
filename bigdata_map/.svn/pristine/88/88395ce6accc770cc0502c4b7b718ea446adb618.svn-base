package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataFenxiCarWeek;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiCarWeekView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataFenxiCarWeekMapper  extends BaseMapper<BigdataFenxiCarWeek>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarWeekView> listPage(BigdataFenxiCarWeekQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataFenxiCarWeekView> listByObj(BigdataFenxiCarWeekQuery query);


    List<BigdataFenxiCarWeek> selectByWeekQianShi(String carType, String xianQuId, Integer timeChangeAge, String timeChangeWeek, Integer countMonth);
	List<BigdataFenxiCarWeek> selectByWeekHouShi(String carType, String xianQuId, Integer timeChangeAge, String timeChangeWeek, Integer countMonth);

    BigdataFenxiCarWeek selectByFenqu(Map<String, Object> map);

    void updateByfenPian(BigdataFenxiCarWeek bigdataFenxiCarWeek);
}