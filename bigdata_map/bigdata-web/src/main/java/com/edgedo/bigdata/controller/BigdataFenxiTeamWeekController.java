package com.edgedo.bigdata.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataFenxiTeamWeek;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamWeekQuery;
import com.edgedo.bigdata.service.BigdataFenxiTeamWeekService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataFenxiTeamWeek")
@Controller
@RequestMapping("/admin/bigdataFenxiTeamWeek")
public class BigdataFenxiTeamWeekController extends BaseController{
	
	@Autowired
	private BigdataFenxiTeamWeekService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataFenxiTeamWeek", notes = "分页查询BigdataFenxiTeamWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataFenxiTeamWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String weekCountStr = query.getQueryObj().getWeekCountStr();
		if(weekCountStr != null && !weekCountStr.equals("")){
			String[] weekCountArr = weekCountStr.split("@@");
			query.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			query.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
		}
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * 根据id查询企业详细信息
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "根据id查询企业详细信息", notes = "根据id查询企业详细信息")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/selectVoById",method = RequestMethod.POST)
	public ModelAndView selectVoById(@ModelAttribute BigdataFenxiTeamWeekQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String weekCountStr = query.getQueryObj().getWeekCountStr();
		if(weekCountStr != null && !weekCountStr.equals("")){
			String[] weekCountArr = weekCountStr.split("@@");
			query.getQueryObj().setCountWeek(Integer.parseInt(weekCountArr[0]));
			query.getQueryObj().setCountMonth(Integer.parseInt(weekCountArr[1]));
		}
		BigdataFenxiTeamWeek teamWeek = service.selectById(query);
		buildResponse(modelAndView,teamWeek);
		return modelAndView;
	}

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@ApiOperation(value = "新增修改BigdataFenxiTeamWeek", notes = "新增修改BigdataFenxiTeamWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataFenxiTeamWeek voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataFenxiTeamWeek", notes = "根据ID批量删除BigdataFenxiTeamWeek")
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
	@ApiOperation(value = "根据ID加载BigdataFenxiTeamWeek", notes = "根据ID加载BigdataFenxiTeamWeek")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@RequestMapping(value = "/selectQiYeBaoJingPaiMing",method = RequestMethod.POST)
	public ModelAndView  selectQiYeBaoJingPaiMing(String carType,String xianQuId,
												  String timeChangeAge,String timeChangeWeek,String timeType){
		ModelAndView modelAndView = new ModelAndView();
		//周数 企业类型

		if(timeChangeWeek.indexOf("@@")==-1){
			//安全评分前十
			List<BigdataFenxiTeamWeek> listAnQuanQianShi = service.selectByWeekAnQuanQianShi(carType,xianQuId,new Integer(timeChangeWeek));
			//安全评分到十
			List<BigdataFenxiTeamWeek> listAnQuanHouShi = service.selectByWeekAnQuanHouShi(carType,xianQuId,new Integer(timeChangeWeek));
			//报警数/百公里前十  越高越差
			List<BigdataFenxiTeamWeek> listBaiGongLiQianShi = service.selectByWeekBaiGongLiQianShi(carType,xianQuId,new Integer(timeChangeWeek));

			//报警数/百公里后十
			List<BigdataFenxiTeamWeek> listBaiGongLiHouShi = service.selectByWeekBaiGongLiHouShi(carType,xianQuId,new Integer(timeChangeWeek));

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
			for(BigdataFenxiTeamWeek bigdataFenxiTeamWeek : listAnQuanQianShi){
				anQuanQianShiQiYeName.add(bigdataFenxiTeamWeek.getTeamName());
				anQuanQianShiQiYePingFen.add(bigdataFenxiTeamWeek.getSafeScore());
			}
			//后十
			for(BigdataFenxiTeamWeek bigdataFenxiTeamWeek : listAnQuanHouShi){
				anQuanHouShiQiYeName.add(bigdataFenxiTeamWeek.getTeamName());
				anQuanHouShiQiYePingFen.add(bigdataFenxiTeamWeek.getSafeScore());
			}

			//前十
			for(BigdataFenxiTeamWeek bigdataFenxiTeamWeek : listBaiGongLiQianShi){
				baiGongLiQianShiQiYeName.add(bigdataFenxiTeamWeek.getTeamName());
				baiGongLiQianShiQiYePingFen.add(bigdataFenxiTeamWeek.getAlarmRate());
			}
			//后十
			for(BigdataFenxiTeamWeek bigdataFenxiTeamWeek : listBaiGongLiHouShi){
				baiGongLiHouShiQiYeName.add(bigdataFenxiTeamWeek.getTeamName());
				baiGongLiHouShiQiYePingFen.add(bigdataFenxiTeamWeek.getAlarmRate());
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
		}else {
			//安全评分前十
			String[] str = timeChangeWeek.split("@@");
			String[] str1 = str[0].split("");
			List<BigdataFenxiTeamWeek> listAnQuanQianShi = service.selectByWeekAnQuanQianShi(carType,xianQuId,new Integer(str1[1]+str1[2]));
			//安全评分到十
			List<BigdataFenxiTeamWeek> listAnQuanHouShi = service.selectByWeekAnQuanHouShi(carType,xianQuId,new Integer(str1[1]+str1[2]));
			//报警数/百公里前十  越高越差
			List<BigdataFenxiTeamWeek> listBaiGongLiQianShi = service.selectByWeekBaiGongLiQianShi(carType,xianQuId,new Integer(str1[1]+str1[2]));

			//报警数/百公里后十
			List<BigdataFenxiTeamWeek> listBaiGongLiHouShi = service.selectByWeekBaiGongLiHouShi(carType,xianQuId,new Integer(str1[1]+str1[2]));

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
			for(BigdataFenxiTeamWeek bigdataFenxiTeamWeek : listAnQuanQianShi){
				anQuanQianShiQiYeName.add(bigdataFenxiTeamWeek.getTeamName());
				anQuanQianShiQiYePingFen.add(bigdataFenxiTeamWeek.getSafeScore());
			}
			//后十
			for(BigdataFenxiTeamWeek bigdataFenxiTeamWeek : listAnQuanHouShi){
				anQuanHouShiQiYeName.add(bigdataFenxiTeamWeek.getTeamName());
				anQuanHouShiQiYePingFen.add(bigdataFenxiTeamWeek.getSafeScore());
			}

			//前十
			for(BigdataFenxiTeamWeek bigdataFenxiTeamWeek : listBaiGongLiQianShi){
				baiGongLiQianShiQiYeName.add(bigdataFenxiTeamWeek.getTeamName());
				baiGongLiQianShiQiYePingFen.add(bigdataFenxiTeamWeek.getAlarmRate());
			}
			//后十
			for(BigdataFenxiTeamWeek bigdataFenxiTeamWeek : listBaiGongLiHouShi){
				baiGongLiHouShiQiYeName.add(bigdataFenxiTeamWeek.getTeamName());
				baiGongLiHouShiQiYePingFen.add(bigdataFenxiTeamWeek.getAlarmRate());
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

	}
	
	
}
