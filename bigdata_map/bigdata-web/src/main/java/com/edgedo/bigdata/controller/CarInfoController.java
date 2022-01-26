package com.edgedo.bigdata.controller;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CancellationException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.BigdataConfigLine;
import com.edgedo.bigdata.entity.TransitCarBaseinfo;
import com.edgedo.bigdata.queryvo.*;
import com.edgedo.bigdata.service.BigdataConfigLineService;
import com.edgedo.bigdata.service.PeccancyRecService;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.CarInfo;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.util.HttpRequestUtil;
import com.edgedo.common.util.ObjectUtil;
import com.edgedo.common.util.StringTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jodd.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "CarInfo")
@Controller
@ResponseBody
@RequestMapping("/admin/carInfo")
public class CarInfoController extends BaseController{
	
	@Autowired
	private CarInfoService service;
	@Autowired
	private PeccancyRecService peccancyRecService;
	@Autowired
	private BigdataConfigLineService bigdataConfigLineService;
	@Value("${ReportDataUrl}")
	private String ReportDataUrl;
	@Value("${ZhygUrl}")
	private String ZhygUrl;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询CarInfo", notes = "分页查询CarInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute CarInfoQuery query){
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
	@ApiOperation(value = "新增修改CarInfo", notes = "新增修改CarInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(CarInfo voObj){
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
	@ApiOperation(value = "根据ID批量删除CarInfo", notes = "根据ID批量删除CarInfo")
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
	@ApiOperation(value = "根据ID加载CarInfo", notes = "根据ID加载CarInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * @author Zcc
	 * @Description  根据条件查询车辆的个数
	 * @date 2019/4/2
	 * @param
	 * @return org.springframework.web.servlet.ModelAndView
	*/
	@RequestMapping(value = "/countCarinfoByQuery",method = RequestMethod.POST)
	public ModelAndView countCarinfoByQuery(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		int carCount = service.countCarinfoByQuery(query);
		if(carCount > 1){
			modelAndView.setViewName("redirect:/views/bigdata/carInfo.html");
		}
		buildResponse(modelAndView,carCount);
		return modelAndView;
	}

	/**
	 * @author Zcc
	 * @Description  查询车辆信息
	 * @date 2019/4/2
	 * @param
	 * @return org.springframework.web.servlet.ModelAndView
	*/
	@RequestMapping(value = "/carinfoByQuery",method = RequestMethod.POST)
	public ModelAndView carinfoByQuery(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String carType = query.getQueryObj().getCarType();
		String reportDataUrl = getReportDataUrl() + "/sys/transitCarBaseinfo/carBaseinfoListByQuery.jsn";
		Map<String,String> parametersMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parametersMap);
		JSONObject jsonObj = (JSONObject) JSON.parse(responseStr);
		JSONArray jsonArray = jsonObj.getJSONArray("list");
		List<TransitCarBaseinfo> carBaseinfoList = new ArrayList<>();
		TransitCarBaseinfo carBaseinfo = null;
		if(jsonArray.size() > 0){
			for(int i=0;i<jsonArray.size();i++){
				carBaseinfo = JSONObject.toJavaObject(jsonArray.getJSONObject(i),TransitCarBaseinfo.class);
				if(carBaseinfo.getCarPlateColor()!=null && carBaseinfo.getCarPlateColor().equals("2")){
					carBaseinfo.setCarPlateColor("黄色");
				}
				if(carBaseinfo.getCarPlateColor()!=null && carBaseinfo.getCarPlateColor().equals("3")){
					carBaseinfo.setCarPlateColor("蓝色");
				}
				//设置车辆类型
				//carBaseinfo.setCarFunType(carType);
				//查询位置信息
				Map<String,String> paramMap = new HashMap<>();
				paramMap.put("carPlateNum",carBaseinfo.getCarPlateNum());
				paramMap.put("carFrameNum",carBaseinfo.getCarFrameNum());
				if(carType != null && !carType.equals("")){
					if(carType.equals("TEAM_WXHWYS")){
						paramMap.put("carType","危货");
					}
					if(carType.equals("TEAM_PTHW")){
						paramMap.put("carType","普货");
					}
					if(carType.equals("TEAM_KY")){
						paramMap.put("carType","客运");
					}
					paramMap.put("carType",carType);
				}else{
					paramMap.put("carType","");
				}
				CarInfo carInfo = service.selectByPlateNumFrameNum(paramMap);
				if(carInfo != null){
					carBaseinfo.setRunState(carInfo.getRunState());
					carBaseinfo.setLocationInfo(carInfo.getLocaltionInfo());
					/*if(carInfo.getCarType()!= null && !carInfo.getCarType().equals("")){
						carBaseinfo.setCarFunType(carInfo.getCarType());
					}else{
						carBaseinfo.setCarFunType(getCarFunType(carBaseinfo.getCarFunType()));
					}*/
					carBaseinfoList.add(carBaseinfo);
				}else{
					if(carType == null || carType.equals("")){
						carBaseinfoList.add(carBaseinfo);
					}
				}
			}
		}

		query.setTotalPage(jsonObj.getIntValue("totalPage"));
		query.setTotalCount(jsonObj.getIntValue("totalCount"));
		query.setStart(jsonObj.getIntValue("start"));
		query.setLimit(jsonObj.getIntValue("limit"));
		for(TransitCarBaseinfo c:carBaseinfoList){
			c.setContactPhone(StringTool.encodeImportentNum(c.getContactPhone()));
			c.setCarRecFileCode(StringTool.encodeImportentNum(c.getCarRecFileCode()));
			c.setJyCertNumber(StringTool.encodeImportentNum(c.getJyCertNumber()));
			c.setTransitLicenceNum(StringTool.encodeImportentNum(c.getTransitLicenceNum()));
		}
		query.setList(carBaseinfoList);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	public String getCarFunType(String carFunType){
		if(carFunType.equals("15")){
			return "牵引车";
		}
		if(carFunType.equals("7")){
			return "普通货车";
		}
		if(carFunType.equals("1")){
			return "普通客车";
		}
		return "";
	}

	/**
	 * @author Zcc
	 * @Description  根据车牌号和车架号查询违章信息
	 * @date 2019/4/2
	 * @param
	 * @return org.springframework.web.servlet.ModelAndView
	*/
	@RequestMapping(value = "/listPagePeccancyRec",method = RequestMethod.POST)
	public ModelAndView listPagePeccacyRec(@ModelAttribute PeccancyRecQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<PeccancyRecView> peccancyRecViewList = peccancyRecService.listPagePRByCarInfo(query);
		buildResponse(modelAndView,peccancyRecViewList);
		return modelAndView;
	}

	/**
	 * @author Zcc
	 * @Description 获取和车辆关联的人员信息
	 * @date 2019/4/2
	 * @param
	 * @return void
	*/
	@RequestMapping(value = "/listPageEmp",method = RequestMethod.POST)
	public void listPageEmp(@ModelAttribute EmpQuery query) throws IllegalAccessException,IOException{
		//查询车辆的从业人员
		String reportDataUrl = getReportDataUrl() + "/sys/emp/listPageEmpByCarInfo.jsn";
		Map<String,String> paramterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,paramterMap);
		outStringToBrowser(responseStr);
	}

	/*
	 * @author Zcc
	 * @Description 根据车辆信息查询里程
	 * @date 2019/4/2
	 * @param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	*/
	@RequestMapping(value = "/searchMileageByCarInfo",method = RequestMethod.POST)
	public ModelAndView searchMileageAnalyse(@ModelAttribute CarInfoQuery query){
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
				query.getQueryObj().setCountTime(countTime);
				BigDecimal mileage = service.searchMileageOneByQuery(query);
				if(mileage != null){
					mileageList.add(mileage);
				}else{
					mileageList.add(new BigDecimal(0));
				}
			}
		}
		/*Calendar calendar = Calendar.getInstance();
		calendar.setTime(query.getQueryObj().getCountTimeEnd());
		calendar.add(Calendar.DAY_OF_MONTH,-7);
		Date countTimeStart = calendar.getTime();
		query.getQueryObj().setCountTimeStart(countTimeStart);
		List<BigDecimal> mileageList = service.searchMileageByCarInfo(query);*/

		//获取里程标准线
		BigdataConfigLine bigdataConfigLine = bigdataConfigLineService.loadById("CAR_MILEAGE_ANALYSIS");
		String lineNumber = bigdataConfigLine.getLineValue();
		BigDecimal lineNum = new BigDecimal(lineNumber);
		mileageList.add(lineNum);

		buildResponse(modelAndView,mileageList);
		return modelAndView;
	}

	/*
	 * @author Zcc
	 * @Description 根据车辆信息查询速度
	 * @date 2019/4/2
	 * @param [query]
	 * @return org.springframework.web.servlet.ModelAndView
	*/
	@RequestMapping(value = "/searchSpeedByCarInfo",method = RequestMethod.POST)
	public ModelAndView searchSpeedAnalyse(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		List<BigDecimal> speedList = new ArrayList<>();
		int searchCount = query.getSearchCount();
		if(searchCount != 0){
			Calendar calendar = Calendar.getInstance();
			for(int i=0;i<searchCount;i++){
				calendar.setTime(query.getQueryObj().getCountTimeEnd());
				int turnNum = i-searchCount+1;
				calendar.add(Calendar.DAY_OF_MONTH,turnNum);
				Date countTime = calendar.getTime();
				query.getQueryObj().setCountTime(countTime);
				BigDecimal speed = service.searchSpeedOneByQuery(query);
				if(speed != null){
					speedList.add(speed);
				}else{
					speedList.add(new BigDecimal(0));
				}
			}
		}
		/*Calendar calendar = Calendar.getInstance();
		calendar.setTime(query.getQueryObj().getCountTimeEnd());
		calendar.add(Calendar.DAY_OF_MONTH,-7);
		Date countTimeStart = calendar.getTime();
		query.getQueryObj().setCountTimeStart(countTimeStart);
		List<BigDecimal> speedList = service.searchSpeedByCarInfo(query);*/

		//获取速度标准线
		BigdataConfigLine bigdataConfigLine = bigdataConfigLineService.loadById("CAR_SPEED_ANALYSIS");
		String lineNumber = bigdataConfigLine.getLineValue();
		BigDecimal lineNum = new BigDecimal(lineNumber);
		speedList.add(lineNum);

		buildResponse(modelAndView,speedList);
		return modelAndView;
	}

	/**
	 * @author Zcc
	 * @Description  根据车队查询车辆信息
	 * @date 2019/4/3
	 * @param
	 * @return void
	*/
	@RequestMapping(value = "/selectCarInfoByCarTeam",method = RequestMethod.POST)
	public void selectCarInfoByCarTeam(@ModelAttribute CarInfoQuery query){
		String reportDataUrl = getReportDataUrl() + "/sys/transitCarBaseinfo/selectCarByCarTeam.jsn";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(reportDataUrl,parameterMap);
		outStringToBrowser(responseStr);
	}


	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "/qtlistpage",method = RequestMethod.POST)
	public ModelAndView qtlistpage(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		query.getQueryObj().setOnlineState("1");
		String carType = query.getQueryObj().getCarType();
		if(!carType.equals("") && carType.equals("总")){
			query.getQueryObj().setCarType("");
		}
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	//查询维修保养记录
	@RequestMapping(value = "/selectWXBYJL",method = RequestMethod.POST)
	public ModelAndView selectWXBYJL(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String zhygUrl = getZhygUrl() + "/transitDocMaintainRecController!listForBigData.action";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
		if(responseStr!=null && !responseStr.equals("")){

			Map map = new HashMap();
			map = ObjectUtil.jsonToMap(responseStr);
			boolean f = Boolean.parseBoolean((String) map.get("success"));
			if(f){
				JSONObject jsonToArray = JSONObject.parseObject(responseStr);
				//方式一
				JSONArray data = jsonToArray.getJSONArray("data");
				buildResponse(modelAndView,data);
			}
		}
		return modelAndView;
	}

	//查询维修保养计划
	@RequestMapping(value = "/selectWXBYJH",method = RequestMethod.POST)
	public ModelAndView selectWXBYJH(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String zhygUrl = getZhygUrl() + "/transitDocMaintainPlanController!listForBigData.action";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
		if(responseStr!=null && !responseStr.equals("")){

			Map map = new HashMap();
			map = ObjectUtil.jsonToMap(responseStr);
			boolean f = Boolean.parseBoolean((String) map.get("success"));
			if(f){
				JSONObject jsonToArray = JSONObject.parseObject(responseStr);
				//方式一
				JSONArray data = jsonToArray.getJSONArray("data");
				buildResponse(modelAndView,data);
			}
		}
		return modelAndView;
	}

	//查询等级评定记录
	@RequestMapping(value = "/selectDJPDJL",method = RequestMethod.POST)
	public ModelAndView selectDJPDJL(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String zhygUrl = getZhygUrl() + "/transitDocLevelRecController!listForBigData.action";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
		if(responseStr!=null && !responseStr.equals("")){

			Map map = new HashMap();
			map = ObjectUtil.jsonToMap(responseStr);
			boolean f = Boolean.parseBoolean((String) map.get("success"));
			if(f){
				JSONObject jsonToArray = JSONObject.parseObject(responseStr);
				//方式一
				JSONArray data = jsonToArray.getJSONArray("data");
				buildResponse(modelAndView,data);
			}
		}
		return modelAndView;
	}

	//查询车辆变更记录
	@RequestMapping(value = "/selectCLBGJL",method = RequestMethod.POST)
	public ModelAndView selectCLBGJL(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String zhygUrl = getZhygUrl() + "/transitDocCarchangeRecController!listForBigData.action";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
		outStringToBrowser(responseStr);
		return modelAndView;
	}

	//查询车牌变更记录
	@RequestMapping(value = "/selectCPBGJL",method = RequestMethod.POST)
	public ModelAndView selectCPBGJL(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String zhygUrl = getZhygUrl() + "/transitDocPlateChangeController!listForBigData.action";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
		outStringToBrowser(responseStr);
		return modelAndView;
	}

	//查询车主变更记录
	@RequestMapping(value = "/selectCZBGJL",method = RequestMethod.POST)
	public ModelAndView selectCZBGJL(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String zhygUrl = getZhygUrl() + "/transitDocOwnerChangeController!listForBigData.action";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
		outStringToBrowser(responseStr);
		return modelAndView;
	}

	//查询机损事故记录
	@RequestMapping(value = "/selectJSSGJL",method = RequestMethod.POST)
	public ModelAndView selectJSSGJL(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String zhygUrl = getZhygUrl() + "/transitDocAccidentRecController!listForBigData.action";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
		outStringToBrowser(responseStr);
		return modelAndView;
	}

	//查询车辆部件变更记录
	@RequestMapping(value = "/selectCLBJBGJL",method = RequestMethod.POST)
	public ModelAndView selectCLBJBGJL(@ModelAttribute CarInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String zhygUrl = getZhygUrl() + "/transitDocChangePartRecController!listForBigData.action";
		Map<String,String> parameterMap = ObjectUtil.objectToMapString(query,"");
		String responseStr = HttpRequestUtil.sendPostRequest(zhygUrl,parameterMap);
		outStringToBrowser(responseStr);
		return modelAndView;
	}

	public String getReportDataUrl() {
		return ReportDataUrl;
	}

	public void setReportDataUrl(String reportDataUrl) {
		ReportDataUrl = reportDataUrl;
	}

	public String getZhygUrl() {
		return ZhygUrl;
	}

	public void setZhygUrl(String zhygUrl) {
		ZhygUrl = zhygUrl;
	}
}
