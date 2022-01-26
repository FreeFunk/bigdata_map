package com.edgedo.bigdata.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamMonthQuery;
import com.edgedo.bigdata.service.BigdataFenxiTeamMonthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataFenxiTeamMonth")
@Controller
@RequestMapping("/admin/bigdataFenxiTeamMonth")
public class BigdataFenxiTeamMonthController extends BaseController{
	
	@Autowired
	private BigdataFenxiTeamMonthService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiTeamMonth", notes = "分页查询BigdataFenxiTeamMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiTeamMonthQuery query){
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
	@ApiOperation(value = "新增修改BigdataFenxiTeamMonth", notes = "新增修改BigdataFenxiTeamMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiTeamMonth voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiTeamMonth", notes = "根据ID批量删除BigdataFenxiTeamMonth")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiTeamMonth", notes = "根据ID加载BigdataFenxiTeamMonth")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@RequestMapping(value = "/selectQiYeBaoJingPaiMing",method = RequestMethod.POST)
	public ModelAndView  selectQiYeBaoJingPaiMing(String carType,String xianQuId,Integer timeCount,
												  String timeChangeAge,String timeChangeWeek,String timeType){
		ModelAndView modelAndView = new ModelAndView();
		//1.企业类型 == 车辆类型
		//2.查询  carType  xianQuId timeCount yearNum  倒序(前十名)  升序(后十名)
		//安全评分前十
		List<BigdataFenxiTeamMonth> listAnQuanQianShi = service.selectByMonthAnQuanQianShi(carType,xianQuId,timeCount);
		//安全评分到十
		List<BigdataFenxiTeamMonth> listAnQuanHouShi = service.selectByMonthAnQuanHouShi(carType,xianQuId,timeCount);
		//报警数/百公里前十  越高越差
		List<BigdataFenxiTeamMonth> listBaiGongLiHouShi = service.selectByMonthBaiGongLiHouShi(carType,xianQuId,timeCount);

		//报警数/百公里后十
		List<BigdataFenxiTeamMonth> listBaiGongLiQianShi = service.selectByMonthBaiGongLiQianShi(carType,xianQuId,timeCount);
		//3.获取  企业名list  安全评分list  报警数/百公里list  5个list
		List<String> anQuanQianShiQiYeName = new ArrayList<>();//安全评分list前十企业名
		List<BigDecimal> anQuanQianShiQiYePingFen = new ArrayList<>();//安全评分list前十评分
		List<String> anQuanHouShiQiYeName = new ArrayList<>();//安全评分list后十企业名
		List<BigDecimal> anQuanHouShiQiYePingFen = new ArrayList<>();//安全评分list后十评分

		List<String> baiGongLiQianShiQiYeName = new ArrayList<>();//报警数/百公里list前十企业名
		List<BigDecimal> baiGongLiQianShiQiYePingFen = new ArrayList<>();//报警数/百公里list前十评分
		List<String> baiGongLiHouShiQiYeName = new ArrayList<>();//报警数/百公里list后十企业名
		List<BigDecimal> baiGongLiHouShiQiYePingFen = new ArrayList<>();//报警数/百公里list后十评分

		//前十
		for(BigdataFenxiTeamMonth bigdataFenxiTeamMonth : listAnQuanQianShi){
			anQuanQianShiQiYeName.add(bigdataFenxiTeamMonth.getTeamName());
			anQuanQianShiQiYePingFen.add(bigdataFenxiTeamMonth.getSafeScore());
		}
		//后十
		for(BigdataFenxiTeamMonth bigdataFenxiTeamMonth : listAnQuanHouShi){
			anQuanHouShiQiYeName.add(bigdataFenxiTeamMonth.getTeamName());
			anQuanHouShiQiYePingFen.add(bigdataFenxiTeamMonth.getSafeScore());
		}

		//前十
		for(BigdataFenxiTeamMonth bigdataFenxiTeamMonth : listBaiGongLiQianShi){
			baiGongLiQianShiQiYeName.add(bigdataFenxiTeamMonth.getTeamName());
			baiGongLiQianShiQiYePingFen.add(bigdataFenxiTeamMonth.getAlarmRate());
		}
		//后十
		for(BigdataFenxiTeamMonth bigdataFenxiTeamMonth : listBaiGongLiHouShi){
			baiGongLiHouShiQiYeName.add(bigdataFenxiTeamMonth.getTeamName());
			baiGongLiHouShiQiYePingFen.add(bigdataFenxiTeamMonth.getAlarmRate());
		}

		Map<String,Object> map = new HashMap<>();
		map.put("anQuanQianShiQiYeName",anQuanQianShiQiYeName);
		map.put("anQuanQianShiQiYePingFen",anQuanQianShiQiYePingFen);
		map.put("anQuanHouShiQiYeName",anQuanHouShiQiYeName);
		map.put("anQuanHouShiQiYePingFen",anQuanHouShiQiYePingFen);
		map.put("baiGongLiQianShiQiYeName",baiGongLiQianShiQiYeName);
		map.put("baiGongLiQianShiQiYePingFen",baiGongLiQianShiQiYePingFen);
		map.put("baiGongLiHouShiQiYeName",baiGongLiHouShiQiYeName);
		map.put("baiGongLiHouShiQiYePingFen",baiGongLiHouShiQiYePingFen);

		return buildResponse(modelAndView,map);
	}

	@RequestMapping(value = "/selectVoById",method = RequestMethod.POST)
	public ModelAndView selectVoById(@ModelAttribute BigdataFenxiTeamMonthQuery query){
		ModelAndView modelAndView = new ModelAndView();
		BigdataFenxiTeamMonth teamMonth = service.selectById(query);
		return buildResponse(modelAndView,teamMonth);
	}

}
