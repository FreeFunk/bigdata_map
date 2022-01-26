package com.edgedo.sys.controller;

import java.util.*;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.shiro.User;
import com.edgedo.sys.entity.SysCity;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.queryvo.SysProviceQuery;
import com.edgedo.sys.queryvo.SysXianquQuery;
import com.edgedo.sys.queryvo.SysXianquView;
import com.edgedo.sys.service.SysCityService;
import com.edgedo.sys.service.SysXianquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysXianqu")
public class SysXianquController extends BaseController {
	
	@Autowired
	private SysXianquService service;
	@Autowired
	private SysCityService cityService;

	/**
	 * 获得当前登录人所在城市能够看到的县区
	 * @return
	 */
	@RequestMapping("/listUserCityXianqu")
	public ModelAndView listUserCityXianqu(){
		ModelAndView modelAndView = new ModelAndView();
		User user = getLoginUser();
		String userCityId = user.getCityId();
		List<SysXianquView> xianquList = service.listAllXianquByCityId(userCityId);
		buildResponse(modelAndView,xianquList);
		return modelAndView;
	}

	/**
	 * 获得当前登录人的城市信息和县区列表
	 * @return
	 */
	@RequestMapping("/listUserCityAndXianquList")
	public ModelAndView listUserCityAndXianquList(){
		ModelAndView modelAndView = new ModelAndView();
		User user = getLoginUser();
		String userCityId = user.getCityId();
		SysCity sysCity = cityService.loadById(userCityId);
		List<SysXianquView> xianquList = service.listAllXianquByCityId(userCityId);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("city",sysCity);
		result.put("xianquList",xianquList);
		buildResponse(modelAndView,result);
		return modelAndView;
	}

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysXianquQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	/**
	 * @Author WangZhen
	 * @Description //根据城市查县区列表
	 * @Date 2019/1/3 14:57
	 * @return org.springframework.web.servlet.ModelAndView
	 **/
	@RequestMapping("/selectXianquByCity")
	public ModelAndView selectXianquByCity(String cityId){
		ModelAndView modelAndView = new ModelAndView();
		List<SysXianquView> list =  service.selectXianquByCity(cityId);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("list",list);
		buildResponse(modelAndView,result);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysXianqu voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		String cityName=voObj.getCityName();
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
	@RequestMapping("/deleteByIds")
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
	@RequestMapping("/loadById")
	public ModelAndView  loadById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id));
	}
	//异步加载树节点
	@RequestMapping("/loadMenu")
	public ModelAndView loadOrg(String id){
		ModelAndView modelAndView = new ModelAndView();
		List menuList = service.selectByParentId(id);
		return buildResponse(modelAndView, menuList);
	}
	
}
