package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.List;

import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordView;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataAlarmRecord;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataAlarmRecord")
@Controller
@RequestMapping("/admin/bigdataAlarmRecord")
public class BigdataAlarmRecordController extends BaseController{
	
	@Autowired
	private BigdataAlarmRecordService service;
	@Autowired
	private CarInfoService carInfoService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataAlarmRecord", notes = "分页查询BigdataAlarmRecord")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改BigdataAlarmRecord", notes = "新增修改BigdataAlarmRecord")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataAlarmRecord voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataAlarmRecord", notes = "根据ID批量删除BigdataAlarmRecord")
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
	@ApiOperation(value = "根据ID加载BigdataAlarmRecord", notes = "根据ID加载BigdataAlarmRecord")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/qtlistpage",method = RequestMethod.POST)
	public ModelAndView qtlistpage(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String  carType = query.getQueryObj().getCarType();
		if(carType!=null && carType.equals("总")){
			query.getQueryObj().setCarType("");
		}
		service.listPage(query);
		List<BigdataAlarmRecordView> bigdataAlarmRecordViewList = query.getList();
		for(BigdataAlarmRecordView bigdataAlarmRecordView:bigdataAlarmRecordViewList){
			String  carPlateNum = bigdataAlarmRecordView.getCarPlateNum();
			String  carPlateColor = bigdataAlarmRecordView.getCarPlateColor();
			//查询车辆的信息
			CarInfo carInfo = carInfoService.loadById(carPlateNum+"_"+carPlateColor);
			if(carInfo!=null){
				bigdataAlarmRecordView.setCarFrameNum(carInfo.getCarFrameNum());
				bigdataAlarmRecordView.setTeamName(carInfo.getOwnerTeamName());
				bigdataAlarmRecordView.setContactPerson(carInfo.getOwnerName());
				bigdataAlarmRecordView.setConctactphone(carInfo.getOwnerPhoneNum());
				bigdataAlarmRecordView.setJyCertNumber(carInfo.getLicenseCode());
			}


			if(carPlateColor.equals("2")){
				bigdataAlarmRecordView.setCarPlateColor("黄色");
			}
			if(carPlateColor.equals("1")){
				bigdataAlarmRecordView.setCarPlateColor("蓝色");
			}
		}
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/selectCarList",method = RequestMethod.POST)
	public ModelAndView selectCarList(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String  carType = query.getQueryObj().getCarType();
		if(carType!=null && carType.equals("总")){
			query.getQueryObj().setCarType("");
		}
		service.selectCarList(query);
		List<BigdataAlarmRecordView> bigdataAlarmRecordViewList = query.getList();
		for(BigdataAlarmRecordView bigdataAlarmRecordView:bigdataAlarmRecordViewList){
			String  carPlateNum = bigdataAlarmRecordView.getCarPlateNum();
			String  carPlateColor = bigdataAlarmRecordView.getCarPlateColor();
			//查询车辆的信息
			CarInfo carInfo = carInfoService.loadById(carPlateNum+"_"+carPlateColor);
			bigdataAlarmRecordView.setCarFrameNum(carInfo.getCarFrameNum());
			bigdataAlarmRecordView.setTeamName(carInfo.getOwnerTeamName());
			bigdataAlarmRecordView.setContactPerson(carInfo.getOwnerName());
			bigdataAlarmRecordView.setConctactphone(carInfo.getOwnerPhoneNum());
			bigdataAlarmRecordView.setJyCertNumber(carInfo.getLicenseCode());

			if(carPlateColor.equals("2")){
				bigdataAlarmRecordView.setCarPlateColor("黄色");
			}
			if(carPlateColor.equals("1")){
				bigdataAlarmRecordView.setCarPlateColor("蓝色");
			}
		}
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	//统计分段限速的数量

	@RequestMapping(value = "/alsrmCount",method = RequestMethod.POST)
	public ModelAndView alsrmCount(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		Integer countMonth = DateUtil.getCountMonth(query.getQueryObj().getAlarmTime());
		query.setCountMonth(countMonth);
		Integer countDate = DateUtil.getCountDate(query.getQueryObj().getAlarmTime());
		query.setCountDate(countDate);
		int alsrmCount = service.alsrmCount(query);
		buildResponse(modelAndView,alsrmCount);
		return modelAndView;
	}

	//查询从业人员和车辆违规信息
	@RequestMapping(value = "/selectByCarOrEmp",method = RequestMethod.POST)
	public ModelAndView selectByCarOrEmp(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.selectByCarOrEmp(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	//查询从业人员和车辆违规信息
	@RequestMapping(value = "/selectAlarmRecordByCar",method = RequestMethod.POST)
	public ModelAndView selectAlarmRecordByCar(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.selectAlarmRecordByCar(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	//查询超速点
	@RequestMapping(value = "/getOverSpeedPoint",method = RequestMethod.POST)
	public ModelAndView getOverSpeedPoint(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.getOverSpeedPoint(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	//查询疲劳点
	@RequestMapping(value = "/getPilaoPoint",method = RequestMethod.POST)
	public ModelAndView getPilaoPoint(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.getPilaoPoint(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	//查询疲劳点
	@RequestMapping(value = "/getSeriousPilaoPoint",method = RequestMethod.POST)
	public ModelAndView getSeriousPilaoPoint(@ModelAttribute BigdataAlarmRecordQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.getSeriousPilaoPoint(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}



}
