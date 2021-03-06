package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCarStopRecord;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataCarStopRecordView;
import com.edgedo.bigdata.queryvo.CarQuXiangGroupCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataCarStopRecordMapper extends BaseMapper<BigdataCarStopRecord>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarStopRecordView> listPage(BigdataCarStopRecordQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarStopRecordView> listByObj(BigdataCarStopRecordQuery query);

	/**
	 * 查询停留超过一定时间并且没有进行poi定位的
	 * @param minMinuteNum
	 * @return
	 */
    List<BigdataCarStopRecord> listUnPoiStopRec(int minMinuteNum);

	/**
	 * 根据类型统计省的去向分布
	 */
    List<CarQuXiangGroupCount> selectProvinceQuXiangGroup(Map<String, Object> param);

	/**
	 * 根据类型统计城市的去向分布
	 * @param param
	 * @return
	 */
	List<CarQuXiangGroupCount> selectCityQuXiangGroup(Map<String, Object> param);

	/**
	 *  查出某辆车几天内的停车列表，根据时间正序排列一下
	 * @param param
	 * @return
	 */
    List<BigdataCarStopRecord> listCarStopRecOfCar(Map<String, Object> param);

	/**
	 * 根据主键和分片字段查询
	 * @param param
	 * @return
	 */
    BigdataCarStopRecord loadByIdAndDate(Map<String, Object> param);

	/**
	 * 查询停车记录，根据城市和车辆分组
	 * @param param
	 * @return
	 */
    List<BigdataCarStopRecord> selectCityQuXiangGroupOfCar(Map<String, Object> param);

	List<BigdataCarStopRecord> selectCityQuXiangGroupOfCarNew(Map<String, Object> param);

	/**
	 * 查询停车记录根据 省份和车辆分组
	 * @param param
	 * @return
	 */
	List<BigdataCarStopRecord> selectProvinceQuXiangGroupOfCar(Map<String, Object> param);

	/**
	 * 根据主键和分片字段修改
	 * @param voObj
	 */
    void updateByFenPian(BigdataCarStopRecord voObj);
}