package com.edgedo.bigdata.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecView;
import com.edgedo.bigdata.service.BigdataConfigLineService;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataTimeCarDayRec;
import com.edgedo.bigdata.queryvo.BigdataTimeCarDayRecQuery;
import com.edgedo.bigdata.service.BigdataTimeCarDayRecService;
import com.edgedo.common.util.StringTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.edgedo.bigdata.entity.BigdataConfigLine;
import com.edgedo.util.DateUtil;
import java.util.Calendar;
import java.util.Date;

@Api(tags = "BigdataTimeCarDayRec")
@Controller
@RequestMapping("/admin/bigdataTimeCarDayRec")
public class BigdataTimeCarDayRecController extends BaseController{
	
	@Autowired
	private BigdataTimeCarDayRecService service;
	@Autowired
	private CarInfoService carInfoService;
	@Autowired
	private BigdataConfigLineService bigdataConfigLineService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataTimeCarDayRec", notes = "分页查询BigdataTimeCarDayRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataTimeCarDayRecQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	@RequestMapping(value = "/qtlistpage",method = RequestMethod.POST)
	public ModelAndView qtlistpage(@ModelAttribute BigdataTimeCarDayRecQuery query){
		String carType = query.getQueryObj().getCarType();
		if(carType!=null && carType.equals("总")){
			query.getQueryObj().setCarType("");
		}
		ModelAndView modelAndView = new ModelAndView();
		service.listPageIsOverSpeed(query);
		List<BigdataTimeCarDayRecView> bigdataTimeCarDayRecViewList = query.getList();
		for(BigdataTimeCarDayRecView bigdataTimeCarDayRecView:bigdataTimeCarDayRecViewList){
			String  carPlateNum = bigdataTimeCarDayRecView.getCarPlateNum();
			String  carPlateColor = bigdataTimeCarDayRecView.getCarPlateColor();
			//查询车辆的信息
			CarInfo carInfo = carInfoService.loadById(carPlateNum+"_"+carPlateColor);
			bigdataTimeCarDayRecView.setCarFrameNum(StringTool.encodeImportentNum(carInfo.getCarFrameNum()));
			bigdataTimeCarDayRecView.setTeamName(carInfo.getOwnerTeamName());
			bigdataTimeCarDayRecView.setContactPerson(carInfo.getOwnerName());
			bigdataTimeCarDayRecView.setConctactphone(StringTool.encodeImportentNum(carInfo.getOwnerPhoneNum()));
			bigdataTimeCarDayRecView.setJyCertNumber(StringTool.encodeImportentNum(carInfo.getLicenseCode()));
			bigdataTimeCarDayRecView.setEmpCode(StringTool.encodeImportentNum(bigdataTimeCarDayRecView.getEmpCode()));
			bigdataTimeCarDayRecView.setEmpPhone(StringTool.encodeImportentNum(bigdataTimeCarDayRecView.getEmpPhone()));
			if(carPlateColor.equals("2")){
				bigdataTimeCarDayRecView.setCarPlateColor("黄色");
			}
			if(carPlateColor.equals("1")){
				bigdataTimeCarDayRecView.setCarPlateColor("蓝色");
			}
		}
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改BigdataTimeCarDayRec", notes = "新增修改BigdataTimeCarDayRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataTimeCarDayRec voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			errMsg = service.insert(voObj);
		}else{
			errMsg = service.update(voObj);
		}
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(modelAndView, errMsg);
		}else{
			buildResponse(modelAndView);
		}
		return modelAndView;
	}
	
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "根据ID批量删除BigdataTimeCarDayRec", notes = "根据ID批量删除BigdataTimeCarDayRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/deleteByIds",method = RequestMethod.POST)
	public ModelAndView delete(String ids){
		ModelAndView modelAndView = new ModelAndView();
		String[] arr = ids.split(",");
		List<String> list = new ArrayList<String>();
		for(String str : arr){
			list.add(str);
		}
		service.deleteByIds(list);		
		return buildResponse(modelAndView);
	}
	
	
	/**
	 * 根据主键加载
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "根据ID加载BigdataTimeCarDayRec", notes = "根据ID加载BigdataTimeCarDayRec")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}


	/**
	 * 初始化安全评分
	 * @return
	 */
	@RequestMapping(value = "/selectAnQuanPingFen",method = RequestMethod.POST)
	public ModelAndView  selectAnQuanPingFen(String carType,String xianQuId,Integer timeCount,
											 String timeType){
		//1.天  -- 对应县区  对应车辆类型  统计时间类型 20190909 DAY   ->list  升序(后十名) 降序(前十名)
		ModelAndView modelAndView = new ModelAndView();
		Map<String,Object> map = new HashMap<>();
        String[] timeCountStr = timeCount.toString().split("");
        Integer countMonth = new Integer(timeCountStr[0]+timeCountStr[1]+timeCountStr[2]+timeCountStr[3]+timeCountStr[4]+timeCountStr[5]);
		List<BigdataTimeCarDayRec> listQianShi = service.selectByDayQianShi(carType,xianQuId,timeCount,timeType,countMonth);
		List<BigdataTimeCarDayRec> listHouShi = service.selectByDayHouShi(carType,xianQuId,timeCount,timeType,countMonth);

		List<String> carNumQianShiList = new ArrayList<>();
		List<BigDecimal> scoreQianShiList = new ArrayList<>();
		List<String> carNumHouShiList = new ArrayList<>();
		List<BigDecimal> scoreHouShiList = new ArrayList<>();
		for(BigdataTimeCarDayRec bigdataTimeCarDayRec : listQianShi){
			carNumQianShiList.add(bigdataTimeCarDayRec.getCarPlateNum());
			scoreQianShiList.add(bigdataTimeCarDayRec.getSafeScore());
		}
		for(BigdataTimeCarDayRec bigdataTimeCarDayRec : listHouShi){
			carNumHouShiList.add(bigdataTimeCarDayRec.getCarPlateNum());
			scoreHouShiList.add(bigdataTimeCarDayRec.getSafeScore());
		}

		map.put("carNumQianShiList",carNumQianShiList);
		map.put("scoreQianShiList",scoreQianShiList);
		map.put("carNumHouShiList",carNumHouShiList);
		map.put("scoreHouShiList",scoreHouShiList);

		return buildResponse(modelAndView, map);
	}

	@RequestMapping(value = "/searchMileageByCarInfo",method = RequestMethod.POST)
	public ModelAndView searchMileageByCarInfo(@ModelAttribute BigdataTimeCarDayRecQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<BigDecimal> mileageList = new ArrayList<>();
		int searchCount = query.getSearchCount();
		if(searchCount != 0){
			Calendar calendar = Calendar.getInstance();
			for(int i=0;i<searchCount;i++){
				calendar.setTime(query.getQueryObj().getCountTimeEnd());
				int turnNum = i-searchCount+1;
				calendar.add(Calendar.DAY_OF_MONTH,turnNum);
				Date countTime = calendar.getTime();
				int countMonth = DateUtil.getCountMonth(countTime);
				int countDate = DateUtil.getCountDate(countTime);
				query.getQueryObj().setCountMonth(countMonth);
				query.getQueryObj().setCountDate(countDate);
				BigDecimal mileage = service.searchMileageByCarInfo(query);
				if(mileage != null){
					mileageList.add(mileage);
				}else{
					mileageList.add(new BigDecimal(0));
				}
			}
		}
		//获取里程标准线
		BigdataConfigLine bigdataConfigLine = bigdataConfigLineService.loadById("CAR_MILEAGE_ANALYSIS");
		String lineNumber = bigdataConfigLine.getLineValue();
		BigDecimal lineNum = new BigDecimal(lineNumber);
		mileageList.add(lineNum);

		buildResponse(modelAndView,mileageList);
		return modelAndView;
	}

	@RequestMapping(value = "/searchSpeedByCarInfo",method = RequestMethod.POST)
	public ModelAndView searchSpeedByCarInfo(@ModelAttribute BigdataTimeCarDayRecQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<BigDecimal> mileageList = new ArrayList<>();
		int searchCount = query.getSearchCount();
		if(searchCount != 0){
			Calendar calendar = Calendar.getInstance();
			for(int i=0;i<searchCount;i++){
				calendar.setTime(query.getQueryObj().getCountTimeEnd());
				int turnNum = i-searchCount+1;
				calendar.add(Calendar.DAY_OF_MONTH,turnNum);
				Date countTime = calendar.getTime();
				int countMonth = DateUtil.getCountMonth(countTime);
				int countDate = DateUtil.getCountDate(countTime);
				query.getQueryObj().setCountMonth(countMonth);
				query.getQueryObj().setCountDate(countDate);
				BigDecimal avgSpeed = service.searchSpeedByCarInfo(query);
				if(avgSpeed != null){
					mileageList.add(avgSpeed);
				}else{
					mileageList.add(new BigDecimal(0));
				}
			}
		}
		//获取里程标准线
		BigdataConfigLine bigdataConfigLine = bigdataConfigLineService.loadById("CAR_SPEED_ANALYSIS");
		String lineNumber = bigdataConfigLine.getLineValue();
		BigDecimal lineNum = new BigDecimal(lineNumber);
		mileageList.add(lineNum);

		buildResponse(modelAndView,mileageList);
		return modelAndView;
	}


}
