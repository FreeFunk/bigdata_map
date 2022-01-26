package com.edgedo.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.shiro.User;
import com.edgedo.sys.entity.SysCity;
import com.edgedo.sys.entity.SysProvice;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.entity.SysXianqu;
import com.edgedo.sys.queryvo.SysCityQuery;
import com.edgedo.sys.queryvo.SysCityView;
import com.edgedo.sys.queryvo.SysXianquView;
import com.edgedo.sys.service.SysCityService;
import com.edgedo.sys.service.SysProviceService;
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
@RequestMapping("/admin/sysCity")
public class SysCityController extends BaseController {
	
	@Autowired
	private SysCityService service;
	@Autowired
	private SysProviceService sysProviceService;
	@Autowired
	private SysXianquService sysXianquService;

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysCityQuery query, String xianquId){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query,xianquId);
		buildResponse(modelAndView,query);
		return modelAndView;
	}


	@RequestMapping("/listUserProvinceAndCityList.jsn")
	public ModelAndView listUserProvinceAndCityList(){
		ModelAndView modelAndView = new ModelAndView();

		User user  = getLoginUser();
		String provinceId = user.getProvinceId();
		Map<String,Object> result = new HashMap<String,Object>();

		if(provinceId!=null && provinceId.length()>0){
			SysProvice province = sysProviceService.loadById(provinceId);
			result.put("province",province);
			List<SysCityView> cityList = service.selectCityByProvinceId(provinceId);
			result.put("cityList",cityList);
		}

		buildResponse(modelAndView,result);
		return modelAndView;
	}

	/**
	 * 获得城市列表，县区列表
	 * @return
	 */
	@RequestMapping("/listUserProvAndCityAndXianquList.jsn")
	public ModelAndView listUserProvAndCityAndXianquList(String xianquId){
		ModelAndView modelAndView = new ModelAndView();

		User user  = getLoginUser();
		String provinceId = user.getProvinceId();
		Map<String,Object> result = new HashMap<String,Object>();

		if(provinceId!=null && provinceId.length()>0){
			SysProvice province = sysProviceService.loadById(provinceId);
			result.put("province",province);
			List<SysCityView> cityList = service.selectCityByProvinceId(provinceId);
			result.put("cityList",cityList);
		}
		SysXianqu xianqu = sysXianquService.loadById(xianquId);
		List<SysXianquView> xianquList = sysXianquService.listAllXianquByCityId(xianqu.getCityId());
		result.put("xianqu",xianqu);
		result.put("xianquList",xianquList);

		buildResponse(modelAndView,result);
		return modelAndView;
	}


	@RequestMapping("/selectCityByProvince.jsn")
	public ModelAndView selectCityByProvince(@ModelAttribute SysCityQuery query){
		ModelAndView modelAndView = new ModelAndView();
		String provinceId = query.getQueryObj().getProvinceId();
		if(provinceId==null||provinceId.equals("")){
			User user  = getLoginUser();
			query.getQueryObj().setProvinceId(user.getProvinceId());
			service.listByObj(query);
			buildResponse(modelAndView,query);
		}else{
			service.listByObj(query);
			buildResponse(modelAndView,query);
		}
		return modelAndView;
	}

	@RequestMapping("/listpageOn")
	public ModelAndView listpageOn(@ModelAttribute SysCityQuery query,String xianquId){
		ModelAndView modelAndView = new ModelAndView();
		query.getQueryObj().setStatus("on");
		service.listPage(query,xianquId);
		buildResponse(modelAndView,query);
		return modelAndView;
	}
	

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysCity voObj){
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
	
	
}
