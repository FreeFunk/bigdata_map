package com.edgedo.bigdata.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoView;
import com.edgedo.bigdata.service.CarInfoService;
import com.edgedo.common.base.BaseController;
import com.edgedo.bigdata.entity.BigdataTeamAnalysisInfo;
import com.edgedo.bigdata.queryvo.BigdataTeamAnalysisInfoQuery;
import com.edgedo.bigdata.service.BigdataTeamAnalysisInfoService;
import com.edgedo.common.base.annotation.Pass;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Api(tags = "BigdataTeamAnalysisInfo")
@Controller
@RequestMapping("/admin/bigdataTeamAnalysisInfo")
public class BigdataTeamAnalysisInfoController extends BaseController{
	
	@Autowired
	private BigdataTeamAnalysisInfoService service;
	@Autowired
	private CarInfoService carInfoService;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@ApiOperation(value = "分页查询BigdataTeamAnalysisInfo", notes = "分页查询BigdataTeamAnalysisInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/listpage",method = RequestMethod.POST)
	public ModelAndView listpage(@ModelAttribute BigdataTeamAnalysisInfoQuery query){
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
	@ApiOperation(value = "新增修改BigdataTeamAnalysisInfo", notes = "新增修改BigdataTeamAnalysisInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(BigdataTeamAnalysisInfo voObj){
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
	@ApiOperation(value = "根据ID批量删除BigdataTeamAnalysisInfo", notes = "根据ID批量删除BigdataTeamAnalysisInfo")
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
	@ApiOperation(value = "根据ID加载BigdataTeamAnalysisInfo", notes = "根据ID加载BigdataTeamAnalysisInfo")
	@ApiImplicitParam(name = "access-token", value = "用户登录秘钥", paramType = "header", required = true, dataType = "String")
	@RequestMapping(value = "/loadById",method = RequestMethod.POST)
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}

	@RequestMapping(value = "/listPageByCountDate",method = RequestMethod.POST)
	public ModelAndView listPageByCountDate(BigdataTeamAnalysisInfoQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPageByCountDate(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/*导出excel*/
	@RequestMapping(value = "/exportTeamCount",method = RequestMethod.GET)
	@ResponseBody
	@Pass
	public void exportTeamCount(BigdataTeamAnalysisInfo voObj) throws UnsupportedEncodingException {
		Integer countDate = voObj.getCountDate();
		String teamType = voObj.getTeamType();
		String teamName = voObj.getTeamName();
		String xianquId = voObj.getXianquId();
		if(countDate==null){
			return;
		}
		//统计平台车辆总数
		int zhygCarSumNum = carInfoService.countZhygCarSumNum();
		//统计数据上传完成车辆数
		int countCarSumNum = carInfoService.countCarSumNum("","");
		//统计上线数
		int countCarOnlineNum = carInfoService.countCarSumNum("1","");
		//统计运营数
		int countCarOperationNum = carInfoService.countCarSumNum("1","1");
		List<BigdataTeamAnalysisInfoView> phTeamList = null;
		List<BigdataTeamAnalysisInfoView> whTeamList = null;
		List<BigdataTeamAnalysisInfoView> kyTeamList = null;
		if(teamType==null || teamType.equals("")){
			//查询所有的普货企业
			phTeamList  = service.selectByTeamType(countDate,"普货",teamName,xianquId);
			//查询所有的危货企业
			whTeamList  = service.selectByTeamType(countDate,"危货",teamName,xianquId);
			//查询所有的客运企业
			kyTeamList  = service.selectByTeamType(countDate,"客运",teamName,xianquId);
		}else {
			if(teamType.equals("普货")){
				//查询所有的普货企业
				phTeamList  = service.selectByTeamType(countDate,teamType,teamName,xianquId);
			}
			if(teamType.equals("危货")) {
				//查询所有的危货企业
				whTeamList = service.selectByTeamType(countDate, teamType,teamName,xianquId);
			}
			if(teamType.equals("客运")) {
				//查询所有的客运企业
				kyTeamList = service.selectByTeamType(countDate, teamType,teamName,xianquId);
			}
		}
		Map<String,Object> map = new HashMap<>();
		map.put("zhygCarSumNum",zhygCarSumNum);
		map.put("countCarSumNum",countCarSumNum);
		map.put("countCarOnlineNum",countCarOnlineNum);
		map.put("countCarOperationNum",countCarOperationNum);
		map.put("phTeamList",phTeamList);
		map.put("whTeamList",whTeamList);
		map.put("kyTeamList",kyTeamList);
		try {
			String exportName = "全部";
			if(teamType!=null && !teamType.equals("")){
				exportName = teamType;
			}
			exportOfTemplate("teamcount.ftl",countDate+exportName+"企业统计.xls",map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//service.listPageByCountDate(query);
	}


}
