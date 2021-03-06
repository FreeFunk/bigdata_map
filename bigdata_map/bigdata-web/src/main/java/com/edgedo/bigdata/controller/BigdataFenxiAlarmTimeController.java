package com.edgedo.bigdata.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataFenxiAlarmTime;
import com.edgedo.bigdata.queryvo.BigdataFenxiAlarmTimeQuery;
import com.edgedo.bigdata.service.BigdataFenxiAlarmTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataFenxiAlarmTime")
@Controller
@RequestMapping("/admin/bigdataFenxiAlarmTime")
public class BigdataFenxiAlarmTimeController extends BaseController{
	
	@Autowired
	private BigdataFenxiAlarmTimeService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiAlarmTime", notes = "分页查询BigdataFenxiAlarmTime")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiAlarmTimeQuery query){
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
	@ApiOperation(value = "新增修改BigdataFenxiAlarmTime", notes = "新增修改BigdataFenxiAlarmTime")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiAlarmTime voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiAlarmTime", notes = "根据ID批量删除BigdataFenxiAlarmTime")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiAlarmTime", notes = "根据ID加载BigdataFenxiAlarmTime")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	/**
	 * 一天报警时间段
	 * @return
	 */
	@RequestMapping(value = "/selectBaoJingDay",method = RequestMethod.POST)
	public ModelAndView  selectBaoJingDay(String carType,String xianQuId,Integer timeCount,String timeType){
		ModelAndView modelAndView = new ModelAndView();
		List<BigdataFenxiAlarmTime> list = service.selectByDay(carType,xianQuId,timeCount,timeType);
		List<Integer> listChangGuiBaoJin = new ArrayList<>();//常规报警时间端
		List<Integer> listChangGuiChuLi = new ArrayList<>();//常规处理时间端
		List<Integer> listAnQuanBaoJin = new ArrayList<>();//安全报警时间端
		List<Integer> listAnQuanChuLi = new ArrayList<>();//安全处理时间端
		List<Integer> listQuanBuBaoJin = new ArrayList<>();//全部报警时间端
		List<Integer> listQuanBuChuLi = new ArrayList<>();//全部处理时间端
		for(BigdataFenxiAlarmTime bigdataFenxiAlarmTime : list){
			if(bigdataFenxiAlarmTime.getAlarmType().equals("常规") && bigdataFenxiAlarmTime.getDataType().equals("报警")){
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getZeroOne());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getOneTwo());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getTwoThree());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getThreeFour());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getFourFive());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getFiveSix());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getSixSeven());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getSevenEight());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getEightNine());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getNineTen());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getTenEleven());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getElevenTwelve());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getTwelveThirteen());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getThirteenFourteen());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getFourteenFifteen());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getFifteenSixteen());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getSixteenSeventeen());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getSeventeenEighteen());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getEighteenNineteen());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getNineteenTwenty());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getTwentyTwentyone());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getTwentyoneTwentytwo());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getTwentytwoTwentythree());
				listChangGuiBaoJin.add(bigdataFenxiAlarmTime.getTwentythreeTwentyfour());
			}else if (bigdataFenxiAlarmTime.getAlarmType().equals("常规") && bigdataFenxiAlarmTime.getDataType().equals("处理")){
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getZeroOne());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getOneTwo());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getTwoThree());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getThreeFour());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getFourFive());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getFiveSix());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getSixSeven());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getSevenEight());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getEightNine());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getNineTen());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getTenEleven());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getElevenTwelve());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getTwelveThirteen());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getThirteenFourteen());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getFourteenFifteen());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getFifteenSixteen());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getSixteenSeventeen());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getSeventeenEighteen());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getEighteenNineteen());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getNineteenTwenty());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getTwentyTwentyone());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getTwentyoneTwentytwo());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getTwentytwoTwentythree());
				listChangGuiChuLi.add(bigdataFenxiAlarmTime.getTwentythreeTwentyfour());
			}else if(bigdataFenxiAlarmTime.getAlarmType().equals("安全")&& bigdataFenxiAlarmTime.getDataType().equals("报警")){
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getZeroOne());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getOneTwo());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getTwoThree());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getThreeFour());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getFourFive());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getFiveSix());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getSixSeven());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getSevenEight());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getEightNine());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getNineTen());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getTenEleven());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getElevenTwelve());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getTwelveThirteen());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getThirteenFourteen());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getFourteenFifteen());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getFifteenSixteen());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getSixteenSeventeen());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getSeventeenEighteen());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getEighteenNineteen());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getNineteenTwenty());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getTwentyTwentyone());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getTwentyoneTwentytwo());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getTwentytwoTwentythree());
				listAnQuanBaoJin.add(bigdataFenxiAlarmTime.getTwentythreeTwentyfour());
			}else if(bigdataFenxiAlarmTime.getAlarmType().equals("安全")&& bigdataFenxiAlarmTime.getDataType().equals("处理")){
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getZeroOne());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getOneTwo());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getTwoThree());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getThreeFour());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getFourFive());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getFiveSix());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getSixSeven());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getSevenEight());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getEightNine());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getNineTen());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getTenEleven());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getElevenTwelve());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getTwelveThirteen());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getThirteenFourteen());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getFourteenFifteen());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getFifteenSixteen());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getSixteenSeventeen());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getSeventeenEighteen());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getEighteenNineteen());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getNineteenTwenty());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getTwentyTwentyone());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getTwentyoneTwentytwo());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getTwentytwoTwentythree());
				listAnQuanChuLi.add(bigdataFenxiAlarmTime.getTwentythreeTwentyfour());
			}else if(bigdataFenxiAlarmTime.getAlarmType().equals("全部")&& bigdataFenxiAlarmTime.getDataType().equals("报警")){
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getZeroOne());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getOneTwo());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getTwoThree());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getThreeFour());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getFourFive());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getFiveSix());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getSixSeven());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getSevenEight());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getEightNine());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getNineTen());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getTenEleven());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getElevenTwelve());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getTwelveThirteen());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getThirteenFourteen());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getFourteenFifteen());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getFifteenSixteen());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getSixteenSeventeen());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getSeventeenEighteen());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getEighteenNineteen());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getNineteenTwenty());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getTwentyTwentyone());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getTwentyoneTwentytwo());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getTwentytwoTwentythree());
				listQuanBuBaoJin.add(bigdataFenxiAlarmTime.getTwentythreeTwentyfour());
			}else if(bigdataFenxiAlarmTime.getAlarmType().equals("全部")&& bigdataFenxiAlarmTime.getDataType().equals("处理")) {
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getZeroOne());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getOneTwo());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getTwoThree());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getThreeFour());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getFourFive());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getFiveSix());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getSixSeven());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getSevenEight());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getEightNine());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getNineTen());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getTenEleven());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getElevenTwelve());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getTwelveThirteen());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getThirteenFourteen());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getFourteenFifteen());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getFifteenSixteen());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getSixteenSeventeen());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getSeventeenEighteen());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getEighteenNineteen());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getNineteenTwenty());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getTwentyTwentyone());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getTwentyoneTwentytwo());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getTwentytwoTwentythree());
				listQuanBuChuLi.add(bigdataFenxiAlarmTime.getTwentythreeTwentyfour());
			}
		}

		Map<String,Object> map = new HashMap<>();
		map.put("listChangGuiBaoJin",listChangGuiBaoJin);
		map.put("listChangGuiChuLi",listChangGuiChuLi);
		map.put("listAnQuanBaoJin",listAnQuanBaoJin);
		map.put("listAnQuanChuLi",listAnQuanChuLi);
		map.put("listQuanBuBaoJin",listQuanBuBaoJin);
		map.put("listQuanBuChuLi",listQuanBuChuLi);
		return buildResponse(modelAndView,map);
	}
	
}
