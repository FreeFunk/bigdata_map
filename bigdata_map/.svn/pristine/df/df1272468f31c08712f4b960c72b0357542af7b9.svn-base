package com.edgedo.bigdata.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.bigdata.entity.BigdataBeidouTeamInfo;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.entity.CountCarNum;
import com.edgedo.bigdata.queryvo.CarGroupCount;
import com.edgedo.bigdata.queryvo.CarInfoQuery;
import com.edgedo.bigdata.queryvo.CarInfoView;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.queryvo.SysXianquView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


@Mapper
public interface CarInfoMapper extends BaseMapper<CarInfo>{
	
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

	public List<BigDecimal> searchSpeedByCarInfo(CarInfoQuery query);
	//统计所有记录
	int countAll();
	//统计所有合格的记录
	int countAllNew();
	//根据排序号查询出来一批车辆信息
	List<CarInfo> listByStartAndEndBySortNum(Map<String, Object> param);

	//根据车牌号和车牌颜色查找
	CarInfo selectByCarPlateAndPlateColor(CarInfo carInfo);

    List<CountCarNum> countCarNumByXianQuId(@Param("carType") String carType);

	void updateCarNum(Map map);

	/**
	 * 动态的分组统计
	 * @param param
	 * @return
	 */
    List<CarGroupCount> selectGroupByCarType(Map<String, Object> param);

	/**
	 * 查询出来未同步的车辆信息
	 * @param limit
	 * @return
	 */
    List<CarInfo> listUnSynCarInfo(int limit);
	//根据排序号查询
    CarInfo selectBySortNum(int sortNum);

    void insertBigdataLinshiBatch(String batchId);

	List<com.edgedo.bigdata.entity.BigdataLinshiBatch> selecBigdataLinshiBatch(String batchId);

    void deleteTransitCarInfoById(String id);
	//清理车辆所有的数据
    int updateClearAllCarState();

    List<String> listAll();

    int countCarSumNumByCompId(String id);

	List<CarInfo> listByStartAndEndBySortNumNew(Map<String, Object> param);

	int selectSortNum();
	//更新主键
    void updateCarInfoPk(Map<String, Object> param);

	List<CarInfo> selectByCarPlateNum(String carPlateNum);
	/**
	 * @Author WangZhen
	 * @Description 根据车架号查询车辆信息
	 * @Date 2020/2/3 15:34
	 **/
    CarInfo selectByCarFrameNum(String carFrameNum);

    void updateIsImportant(String id);

	int countCarSumNumByCompIdNew(Map<String, Object> map);

    List<SysXianqu> getXianquList();

	int countCarSumNumByXianQuId(Map<String, Object> map);

	int countCarSumNumByCityId(Map<String, Object> map);

    List<BigdataBeidouTeamInfo> getTeamList();


	int countCarSumNumByTeamId(Map<String, Object> map);

    List<String> getCompNameByTeamId(String teamId);

	void updateClearCarStateById(String carId);

    String getInitCarGpsFlag(String id);

	void updateInitCarGpsFlag(Map<String, Object> map);

}