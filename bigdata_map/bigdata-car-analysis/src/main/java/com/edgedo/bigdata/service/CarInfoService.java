package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataBeidouTeamInfo;
import com.edgedo.bigdata.entity.BigdataLinshiBatch;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.entity.CountCarNum;
import com.edgedo.bigdata.mapper.CarInfoMapper;
import com.edgedo.bigdata.queryvo.CarGroupCount;
import com.edgedo.bigdata.queryvo.CarInfoQuery;
import com.edgedo.bigdata.queryvo.CarInfoView;
import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.queryvo.SysXianquView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(CarInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}

	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insertNew(CarInfo voObj) {
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(CarInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(CarInfo voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
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

	public List<BigDecimal> searchSpeedByCarInfo(CarInfoQuery query){
		return mapper.searchSpeedByCarInfo(query);
	}

	/**
	 * 统计所有数据
	 * @return
	 */
	public int countAll() {
		return mapper.countAll();
	}
	/**
	 * 统计所有合格的数据
	 * @return
	 */
	public int countAllNew() {
		return mapper.countAllNew();
	}


	//查询一批数据
	public List<CarInfo> listByStartAndEndBySortNum(int start, int end) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("start",start);
		param.put("end",end);
		return mapper.listByStartAndEndBySortNum(param);
	}



	//查询一批数据
	public List<CarInfo> listByStartAndEndBySortNumNew(int start, int end) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("start",start);
		param.put("end",end);
		return mapper.listByStartAndEndBySortNumNew(param);

	}

	public List<CountCarNum> countCarNumByXianQuId(String carType) {
		return mapper.countCarNumByXianQuId(carType);
	}

	public void updateCarNum(String countType,String carType) {
		Map<String,String> map = new HashMap<>();
		map.put("countType",countType);
		map.put("carType",carType);
		mapper.updateCarNum(map);
	}

	/**
	 * 根据车牌号和车牌颜色查找
	 * @param carInfo
	 * @return
	 */
    public CarInfo selectByCarPlateAndPlateColor(CarInfo carInfo) {
		return mapper.selectByCarPlateAndPlateColor(carInfo);
    }
	//分组统计车辆信息
    public List<CarGroupCount> selectGroupByCarType(String onlineState, String operatFlag) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("onlineState",onlineState);
		param.put("operatFlag",operatFlag);
		return mapper.selectGroupByCarType(param);
    }

	//查询出来未进行智慧运管同步的车辆
    public List<CarInfo> listUnSynCarInfo(int limit) {
		return mapper.listUnSynCarInfo(limit);
    }
	//根据排序号查询
    public CarInfo selectBySortNum(int sortNum) {
		return mapper.selectBySortNum(sortNum);
    }
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertBigdataLinshiBatch(String batchId) {
		mapper.insertBigdataLinshiBatch(batchId);
	}

	public List<BigdataLinshiBatch> selecBigdataLinshiBatch(String batchId) {
		return mapper.selecBigdataLinshiBatch(batchId);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void deleteTransitCarInfoById(String id) {
		mapper.deleteTransitCarInfoById(id);
	}

	//凌晨时候清理车辆状态
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public int updateClearAllCarState() {
		int rows = mapper.updateClearAllCarState();
		return rows;
    }
    public List<String> listAllVo(){
    	return mapper.listAll();
	}

	public int countCarSumNumByCompId(String id) {
		return mapper.countCarSumNumByCompId(id);
	}

	/**
	 * 车牌颜色文本和代码的转换
	 * 1:蓝色, 2:黄色,	 3:黑色,	 4:白色, 7:黄绿相间	 9:其他
	 * @param coloText
	 * @return
	 */
	public static String genCarPlateColorCodeFromText(String coloText){
		if(coloText!=null){
			if(coloText.indexOf("黄色")>=0){
				return "2";
			}else if(coloText.indexOf("蓝色")>=0){
				return "1";
			}else if(coloText.indexOf("黑色")>=0){
				return "3";
			}else if(coloText.indexOf("白色")>=0){
				return "4";
			}else if(coloText.indexOf("黄绿")>=0){
				return "7";
			}
		}
    	return "9";
	}


	/**
	 * 车牌颜色文本和代码的转换
	 * 1:蓝色, 2:黄色,	 3:黑色,	 4:白色, 7:黄绿相间	 9:其他
	 * @param colorCode
	 * @return
	 */
	public static String genCarPlateColorTextFromCode(String colorCode){
		if(colorCode.indexOf("2")>=0){
			return "黄色";
		}else if(colorCode.indexOf("1")>=0){
			return "蓝色";
		}else if(colorCode.indexOf("3")>=0){
			return "黑色";
		}else if(colorCode.indexOf("4")>=0){
			return "白色";
		}else if(colorCode.indexOf("9")>=0){
			return "黄绿";
		}
		return "其他";
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertOrUpdate(CarInfo carInfo) {
		String id = carInfo.getId();
		if(id!=null){
			CarInfo carInfo1 = loadById(id);
			if(carInfo1==null){
				CarInfo carInfo2 = loadById(carInfo.getCarPlateNum()+"_"+carInfo.getCarPlateColour());
				if(carInfo2!=null){
					//更新主键
					Map<String,Object> param = new HashMap<String,Object>();
					param.put("idOld",carInfo2.getId());
					param.put("idNew" , id);
					mapper.updateCarInfoPk(param);
				}else {
					carInfo.setId(id);
					carInfo.setCreateTime(new Date());
					mapper.insert(carInfo);
				}
			}else {

				carInfo.setId(id);
				update(carInfo);
			}
		}else{
			CarInfo carInfo1 = loadById(carInfo.getCarPlateNum()+"_"+carInfo.getCarPlateColour());
			if(carInfo1==null){
				carInfo.setId(carInfo.getCarPlateNum()+"_"+carInfo.getCarPlateColour());
				carInfo.setCreateTime(new Date());
				mapper.insert(carInfo);
			}else {
				carInfo.setId(carInfo.getCarPlateNum()+"_"+carInfo.getCarPlateColour());
				update(carInfo);
			}
		}

	}

	public int selectSortNum() {
		return mapper.selectSortNum();
	}

	public List<CarInfo> selectByCarPlateNum(String carPlateNum) {
		return mapper.selectByCarPlateNum(carPlateNum);
	}
	/**
	 * @Author WangZhen
	 * @Description 根据车架号查询车辆信息
	 * @Date 2020/2/3 15:34
	 **/
    public CarInfo selectByCarFrameNum(String carFrameNum) {
		return mapper.selectByCarFrameNum(carFrameNum);
    }

	public void updateIsImportant(String id) {
		mapper.updateIsImportant(id);
	}

	public int countCarSumNumByCompIdNew(String compId, String xianquId, String carType,String onlineState,String operatFlag) {
    	Map<String,Object> map =  new HashMap<>();
		map.put("compId",compId);
		map.put("xianquId",xianquId);
		map.put("carType",carType);
		map.put("onlineState",onlineState);
		map.put("operatFlag",operatFlag);
		return mapper.countCarSumNumByCompIdNew(map);
	}

	public List<SysXianqu> getXianquList() {
		return mapper.getXianquList();
	}

	public int countCarSumNumByXianQuId(String xianquId, String carType,String onlineState,String operatFlag) {
		Map<String,Object> map =  new HashMap<>();
		map.put("xianquId",xianquId);
		map.put("carType",carType);
		map.put("onlineState",onlineState);
		map.put("operatFlag",operatFlag);
		return mapper.countCarSumNumByXianQuId(map);
	}

	public int countCarSumNumByCityId(String cityId, String carType,String onlineState,String operatFlag) {
		Map<String,Object> map =  new HashMap<>();
		map.put("cityId",cityId);
		map.put("carType",carType);
		map.put("onlineState",onlineState);
		map.put("operatFlag",operatFlag);
		return mapper.countCarSumNumByCityId(map);
	}

	public List<BigdataBeidouTeamInfo> getTeamList() {
		return mapper.getTeamList();
	}

	public int countCarSumNumByTeamId(String teamId, String onlineState,String operatFlag) {
		Map<String,Object> map =  new HashMap<>();
		map.put("teamId",teamId);
		map.put("onlineState",onlineState);
		map.put("operatFlag",operatFlag);
		return mapper.countCarSumNumByTeamId(map);
	}

	public String getCompNameByTeamId(String teamId) {
		List<String> compNameList = mapper.getCompNameByTeamId(teamId);
		String compName = "";
		for(String c:compNameList){
			if(c!=null && !c.equals("")){
				if(compName.equals("")){
					compName = c;
				}else {
					compName += ","+c;
				}
			}
		}
		return compName;
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateClearCarStateById(String carId) {
		mapper.updateClearCarStateById(carId);
	}

	public String getInitCarGpsFlag(String id) {
		return mapper.getInitCarGpsFlag(id);
	}

	public void updateInitCarGpsFlag(String id, String initCarGpsFlagNow) {
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		map.put("initCarGpsFlagNow",initCarGpsFlagNow);
		mapper.updateInitCarGpsFlag(map);
	}
}
