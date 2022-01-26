package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataCarRealtimeGps;
import com.edgedo.bigdata.entity.BigdataLinshiBatch;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsQuery;
import com.edgedo.bigdata.queryvo.BigdataCarRealtimeGpsView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface BigdataCarRealtimeGpsMapper extends BaseMapper<BigdataCarRealtimeGps>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarRealtimeGpsView> listPage(BigdataCarRealtimeGpsQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<BigdataCarRealtimeGpsView> listByObj(BigdataCarRealtimeGpsQuery query);

	/**
	 * 更新开始的里程信息
	 */
    int updateBeginMileageAndOperateStateAndOnlineState();

	/**
	 * 更新是否运营
	 */
	void updateOperatingFlag();

	/**
	 * 设置是否在线
	 */
	void updateOnlineState();

	//根据车牌号和车牌颜色查询车辆信息
    BigdataCarRealtimeGps selectCarByCarPlateAndPlateColor(Map<String, Object> param);
	//清理gps信息
    int updateClearAllGpsState();

	/**
	 * 根据主键查询
	 * @param ids
	 * @return
	 */
    List<BigdataCarRealtimeGps> selectCarGpsInfoByIds(String[] ids);


    void insertBigdataLinshiBatch(String batchId);

	List<BigdataLinshiBatch> selecBigdataLinshiBatch(String batchId);

    int selectOrderNumDesc(String batchId);

	List<BigdataLinshiBatch> listByStartAndEndBySortNum(Map<String, Object> param);
	/**
	 * @Author WangZhen
	 * @Description
	 * @Date 2019/11/26 17:14
	 **/
    List<BigdataCarRealtimeGpsView> selectGpsCarNotInCarInfo();


	List<BigdataCarRealtimeGpsView> selectNotInTodayGps();

	void updateClearCarStateById(String carId);
	//查询一套最新的车
    BigdataCarRealtimeGpsView loadLatestOneCar();

}