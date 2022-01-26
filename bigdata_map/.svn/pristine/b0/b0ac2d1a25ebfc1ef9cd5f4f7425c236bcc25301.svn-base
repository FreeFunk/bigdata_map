package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.mapper.BigdataDriverCardRecMapper;
import com.edgedo.common.util.IdCardUtil;
import com.edgedo.common.util.StringTool;
import com.edgedo.drawing.mapper.BigdataDriverChangeCarRecMapper;
import com.edgedo.drawing.mapper.BigdataDriverChangeTeamRecMapper;
import com.edgedo.bigdata.queryvo.BigdataDriverCardRecQuery;
import com.edgedo.bigdata.queryvo.BigdataDriverCardRecView;
import com.edgedo.common.util.Guid;
import com.edgedo.drawing.entity.BigdataDriverChangeCarRec;
import com.edgedo.drawing.entity.BigdataDriverChangeTeamRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataDriverCardRecService {
	
	
	@Autowired
	private BigdataDriverCardRecMapper mapper;

	@Autowired
	private BigdataDriverCardInfoService bigdataDriverCardInfoService;

	@Autowired
	private BigdataDriverChangeCarRecMapper bigdataDriverChangeCarRecMapper;

	@Autowired
	private BigdataDriverChangeTeamRecMapper bigdataDriverChangeTeamRecMapper;

	@Autowired
	private CarInfoService carInfoService;


	SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
	
	public List<BigdataDriverCardRecView> listPage(BigdataDriverCardRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataDriverCardRec voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataDriverCardRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataDriverCardRec voObj) {
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
	public BigdataDriverCardRec loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 接收司机身份卡插卡和拔卡记录
	 * @param cardRec
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void insertAcceptDriverCardRec(BigdataDriverCardRec cardRec) {


		String carPlateNum = cardRec.getCarPlateNum();
		//判断车辆信息是否存在
		List<CarInfo> carInfoList = carInfoService.selectByCarPlateNum(carPlateNum);
		if(carInfoList==null || carInfoList.size()==0 || carInfoList.size()>1){
			return;
		}
		CarInfo carInfo = carInfoList.get(0);
		cardRec.setCarPlateColor(carInfo.getCarPlateColour());
		cardRec.setCompany(carInfo.getOwnerTeamName());
		String compId = cardRec.getCompId();
		String bid = cardRec.getBid();
		Date cur = cardRec.getCardTime();
		String countDateStr = sdfDateInt.format(cur);
		Integer countDate = new Integer(countDateStr);
		Integer countMonth = countDate/100;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("compId",compId);
		param.put("bid",bid);
		param.put("countDate",countDate);
		param.put("countMonth",countMonth);
		int count = mapper.countByCompIdAndBid(param);
		if(count==0){
			//将记录插入数据库
			cardRec.setCreateTime(new Date());
			cardRec.setCountDate(countDate);
			cardRec.setCountMonth(countMonth);
			//判断记录是否合格
			String licenceNum = cardRec.getLicenceNum();
			//操作将营运证号的非数字部分去掉
			if(licenceNum!=null){
				licenceNum = licenceNum.replaceAll("[^a-zA-Z0-9]", "");
				cardRec.setLicenceNum(licenceNum);
			}
			String driverName = cardRec.getDriverName();
			if(carPlateNum==null || carPlateNum.equals("")
					|| licenceNum==null || (licenceNum.length()<10) || !IdCardUtil.isValidatedAllIdcard(licenceNum)
					|| driverName==null || driverName.equals("") || !StringTool.isChineseStr(driverName))
			{
				cardRec.setQualifiedFlag("0");
				insert(cardRec);
				return;
			}else {
				cardRec.setQualifiedFlag("1");
				insert(cardRec);
			}



			//车牌号  车牌颜色  2 黄色  3 蓝色
			TransitCarBaseinfo transitCarBaseinfo = null;
			if(cardRec.getCarPlateColor().equals("1")){//1 蓝色 2 黄色
				transitCarBaseinfo = bigdataDriverCardInfoService.selectByCarNumAndCarColor(cardRec.getCarPlateNum(),"3");
			}else {
				transitCarBaseinfo = bigdataDriverCardInfoService.selectByCarNumAndCarColor(cardRec.getCarPlateNum(),"2");
			}
			if(transitCarBaseinfo==null){
				return;
			}
			Emp emp = bigdataDriverCardInfoService.selectByLicenceCode(licenceNum);
			String newEmpId = Guid.guid();
			if(emp==null){//没有插入
				Emp newEmp = new Emp();
				newEmp.setId(newEmpId);//主键
				newEmp.setCreateTime(new Date());//创建时间
				newEmp.setOwnerCarTeamId(carInfo.getOwnerTeamId());//企业id
				newEmp.setOwnerCarTeamName(carInfo.getOwnerTeamName());//企业名
				newEmp.setEmpName(cardRec.getDriverName());//从业人员名字
				newEmp.setLicenceCode(cardRec.getLicenceNum());//电话
				newEmp.setPlateNum(transitCarBaseinfo.getId());
				newEmp.setCarPlateNum(carPlateNum);//车牌号
				newEmp.setProvinceId(carInfo.getProvinceId());//省
				newEmp.setProvinceName(carInfo.getProvinceName());
				newEmp.setCityId(carInfo.getCityId());
				newEmp.setCityName(carInfo.getCityName());
				newEmp.setXianQuId(carInfo.getXianquId());
				newEmp.setXianQuName(carInfo.getXianquName());
				newEmp.setDataState("1");
				newEmp.setEmpState("1");
				newEmp.setEmpType("1");
				bigdataDriverCardInfoService.insertEmp(newEmp);
			}else {
				newEmpId = emp.getId();
			}
			//有的不更新
			//查询该司机是否有记录
			BigdataDriverCardInfo bigdataDriverCardInfo = bigdataDriverCardInfoService.selectDriverInfo(cardRec.getLicenceNum());
			//判断是否为空
			if(bigdataDriverCardInfo==null){//插入
				bigdataDriverCardInfoService.delete(newEmpId);
				BigdataDriverCardInfo bigdataDriverCardInfoNew = new BigdataDriverCardInfo();

				bigdataDriverCardInfoNew.setId(newEmpId);//主键
				bigdataDriverCardInfoNew.setCreateTime(new Date());//创建时间
				bigdataDriverCardInfoNew.setCompId(cardRec.getCompId());//所属运营商
				bigdataDriverCardInfoNew.setCompName(cardRec.getCompName());//所属运营商名字
				bigdataDriverCardInfoNew.setDriverName(cardRec.getDriverName());//驾驶员姓名
				bigdataDriverCardInfoNew.setLastUseTime(new Date());//上次使用时间按
//			bigdataDriverCardInfoNew.setQualifiedFlag('');
				bigdataDriverCardInfoNew.setTeamId(carInfo.getOwnerTeamId());//企业id
				bigdataDriverCardInfoNew.setTeamName(carInfo.getOwnerTeamName());//企业名字
				bigdataDriverCardInfoNew.setProvinceId(carInfo.getProvinceId());//省
				bigdataDriverCardInfoNew.setProvinceName(carInfo.getProvinceName());
				bigdataDriverCardInfoNew.setCityId(carInfo.getCityId());//市
				bigdataDriverCardInfoNew.setCityName(carInfo.getCityName());
				bigdataDriverCardInfoNew.setXianquId(carInfo.getXianquId());//县区
				bigdataDriverCardInfoNew.setXianquName(carInfo.getXianquName());
				bigdataDriverCardInfoNew.setDriverCode(cardRec.getLicenceNum());//资格证号
				bigdataDriverCardInfoNew.setCarPlateNum(cardRec.getCarPlateNum());//车牌号
				bigdataDriverCardInfoNew.setCarFrameNum(carInfo.getCarFrameNum());//车架号

				bigdataDriverCardInfoNew.setCarPlateColor(cardRec.getCarPlateColor());//车牌颜色
				bigdataDriverCardInfoNew.setCarPlateColorText(getColor(cardRec.getCarPlateColor()));
				bigdataDriverCardInfoNew.setCarType(carInfo.getCarType());//车辆类型
				bigdataDriverCardInfoNew.setIsRealState("1");
				bigdataDriverCardInfoNew.setTeamBindTime(new Date());//企业关联时间
				bigdataDriverCardInfoNew.setCarBindTime(new Date());//车量关联时间
				bigdataDriverCardInfoService.insertNew(bigdataDriverCardInfoNew);
			}else {//存在 更新
				//查看是否与上次车牌号一样  企业一样
				String currCarPlateNum = cardRec.getCarPlateNum();//司机刷卡时 上传的车牌号
				String currTeamName = cardRec.getCompany();//司机刷卡时 上传的企业名
				String dataBaseCarPlateNum = bigdataDriverCardInfo.getCarPlateNum();//车牌号
				String dataBaseTeamName = bigdataDriverCardInfo.getTeamName();//企业
				if(currTeamName!=null && dataBaseTeamName!=null && !currTeamName.equals(dataBaseTeamName)){//判断企业
					//不一样 添加更换记录
					BigdataDriverChangeTeamRec bigdataDriverChangeTeamRec = new BigdataDriverChangeTeamRec();
					bigdataDriverChangeTeamRec.setId(Guid.guid());//主键
					bigdataDriverChangeTeamRec.setCreateTime(new Date());//创建时间
					bigdataDriverChangeTeamRec.setTeamId(bigdataDriverCardInfo.getTeamId());//所属企业
					bigdataDriverChangeTeamRec.setTeamName(bigdataDriverCardInfo.getTeamName());//企业名
					bigdataDriverChangeTeamRec.setProvinceId(carInfo.getProvinceId());//省
					bigdataDriverChangeTeamRec.setProvinceName(carInfo.getProvinceName());
					bigdataDriverChangeTeamRec.setCityId(carInfo.getCityId());//市
					bigdataDriverChangeTeamRec.setCityName(carInfo.getCityName());
					bigdataDriverChangeTeamRec.setXianquId(carInfo.getXianquId());//县区
					bigdataDriverChangeTeamRec.setXianquName(carInfo.getXianquName());
					bigdataDriverChangeTeamRec.setDriverId(bigdataDriverCardInfo.getId());//驾驶员id
					bigdataDriverChangeTeamRec.setDriverName(bigdataDriverCardInfo.getDriverName());//驾驶员姓名
					bigdataDriverChangeTeamRec.setDriverPhone(bigdataDriverCardInfo.getDriverPhone());//驾驶员电话
					bigdataDriverChangeTeamRec.setDriverCode(bigdataDriverCardInfo.getDriverCode());//驾驶资格证号
					bigdataDriverChangeTeamRec.setStartTime(bigdataDriverCardInfo.getTeamBindTime());//车辆一开始的开始时间
					bigdataDriverChangeTeamRec.setEndTime(new Date());//结束时间
					bigdataDriverChangeTeamRecMapper.insert(bigdataDriverChangeTeamRec);
					bigdataDriverCardInfo.setTeamId(carInfo.getOwnerTeamId());//新的企业
					bigdataDriverCardInfo.setTeamName(carInfo.getOwnerTeamName());
					bigdataDriverCardInfo.setTeamBindTime(new Date());//车辆关联更换时间
				}
				if(!(currCarPlateNum.equals(dataBaseCarPlateNum))){//判断车牌号
					//不一样 添加更换记录
					BigdataDriverChangeCarRec bigdataDriverChangeCarRec = new BigdataDriverChangeCarRec();
					bigdataDriverChangeCarRec.setId(Guid.guid());//主键
					bigdataDriverChangeCarRec.setCreateTime(new Date());//创建时间
					bigdataDriverChangeCarRec.setCompId(bigdataDriverCardInfo.getCompId());//所属运营商id
					bigdataDriverChangeCarRec.setCompName(bigdataDriverCardInfo.getCompName());//所属运营商
					bigdataDriverChangeCarRec.setTeamId(bigdataDriverCardInfo.getTeamId());//所属企业
					bigdataDriverChangeCarRec.setTeamName(bigdataDriverCardInfo.getTeamName());//企业名
					bigdataDriverChangeCarRec.setProvinceId(carInfo.getProvinceId());//省
					bigdataDriverChangeCarRec.setProvinceName(carInfo.getProvinceName());
					bigdataDriverChangeCarRec.setCityId(carInfo.getCityId());//市
					bigdataDriverChangeCarRec.setCityName(carInfo.getCityName());
					bigdataDriverChangeCarRec.setXianquId(carInfo.getXianquId());//县区
					bigdataDriverChangeCarRec.setXianquName(carInfo.getXianquName());
					bigdataDriverChangeCarRec.setDriverId(bigdataDriverCardInfo.getId());//驾驶员id
					bigdataDriverChangeCarRec.setDriverName(bigdataDriverCardInfo.getDriverName());//驾驶员姓名
					bigdataDriverChangeCarRec.setDriverPhone(bigdataDriverCardInfo.getDriverPhone());//驾驶员电话
					bigdataDriverChangeCarRec.setDriverCode(bigdataDriverCardInfo.getDriverCode());//驾驶资格证号
					bigdataDriverChangeCarRec.setStartTime(bigdataDriverCardInfo.getCarBindTime());//车辆一开始的开始时间
					bigdataDriverChangeCarRec.setEndTime(new Date());//结束时间
					bigdataDriverChangeCarRec.setCarPlateNum(bigdataDriverCardInfo.getCarPlateNum());
					bigdataDriverChangeCarRec.setCarPlateColor(bigdataDriverCardInfo.getCarPlateColor());
					bigdataDriverChangeCarRec.setCarPlateColorText(bigdataDriverCardInfo.getCarPlateColorText());
					bigdataDriverChangeCarRec.setCarFrameNum(bigdataDriverCardInfo.getCarFrameNum());
					bigdataDriverChangeCarRec.setCarType(bigdataDriverCardInfo.getCarType());
					bigdataDriverChangeCarRecMapper.insert(bigdataDriverChangeCarRec);
					//更新司机信息卡表
					bigdataDriverCardInfo.setCarPlateNum(cardRec.getCarPlateNum());//新的车牌号
					bigdataDriverCardInfo.setCarPlateColor(cardRec.getCarPlateColor());//新的车牌颜色
					bigdataDriverCardInfo.setCarPlateColorText(getColor(cardRec.getCarPlateColor()));
					bigdataDriverCardInfo.setCarBindTime(new Date());//车辆关联更换时间
					//更新车辆表的从业人员信息
					carInfo.setEmpId(bigdataDriverCardInfo.getId());
					carInfo.setEmpName(bigdataDriverCardInfo.getDriverName());
					carInfo.setEmpCode(bigdataDriverCardInfo.getDriverCode());
					carInfo.setEmpPhone(bigdataDriverCardInfo.getDriverPhone());
					carInfoService.update(carInfo);
				}
				//更新司机信息卡表
				bigdataDriverCardInfo.setLastUseTime(new Date());//刷卡时间
				bigdataDriverCardInfoService.updateById(bigdataDriverCardInfo);
			}

		}
    }


    public String getColor(String carColor){
    	//1-蓝色,2-黄色,3-黑色,4-白色,9-黄绿相间
		if(carColor.equals("1")){
			return "蓝色";
		}else if(carColor.equals("2")){
			return "黄色";
		}else if(carColor.equals("3")){
			return "黑色";
		}else if(carColor.equals("4")){
			return "白色";
		}else {
			return "黄绿相间";
		}
	}


	public int countDriverCardUpNum(Map<String, Object> param2) {
		return mapper.countDriverCardUpNum(param2);
	}
	/**
	 * @Author WangZhen
	 * @Description 根据车牌号和车牌颜色 获得某天的司机卡插卡记录列表
	 * @Date 2020/2/3 17:30
	 **/
    public List<BigdataDriverCardRecView> selectDriverCarRecOfChakaOfCar(
    		int countMonth, int countDate,
			String carPlateNum,
			String carPlateColour) {
    	Map<String,Object> param = new HashMap<String,Object>();
		param.put("countDate",countDate);
		param.put("countMonth",countMonth);
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColour",carPlateColour);
    	return mapper.selectDriverCarRecOfChakaOfCar(param);
    }
	/**
	 * @Author WangZhen
	 * @Description 根据车牌号和车牌颜色 获得某天的司机卡插卡记录最后一条
	 * @Date 2020/2/3 17:30
	 **/
	public BigdataDriverCardRecView selectLastDriverCarRecOfChakaOfCar(
			int countMonth, int countDate,
			String carPlateNum,
			String carPlateColour) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("countDate",countDate);
		param.put("countMonth",countMonth);
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColour",carPlateColour);
		return mapper.selectLastDriverCarRecOfChakaOfCar(param);
	}


	public int countSumNumByCompId(String compId, int dayInt) {
		Map<String,Object> map = new HashMap<>();
		map.put("compId",compId);
		map.put("countDate",dayInt);
		map.put("countMonth",dayInt/100);
		return mapper.countSumNumByCompId(map);
	}
}
