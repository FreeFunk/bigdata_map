package com.edgedo.sys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.SysDictProperty;
import com.edgedo.sys.queryvo.SysDictPropertyQuery;
import com.edgedo.sys.queryvo.SysDictPropertyView;
import com.edgedo.sys.service.SysDictPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysDictProperty")
public class SysDictPropertyController extends BaseController {

	@Autowired
	private SysDictPropertyService service;

	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysDictPropertyQuery query){
		ModelAndView modelAndView = new ModelAndView();
		service.listPage(query);
		buildResponse(modelAndView,query);
		return modelAndView;
	}

	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping("/listProByKey")
	public ModelAndView listProByKey(String dictKey){
		ModelAndView modelAndView = new ModelAndView();
		List<SysDictPropertyView> propertyList =  service.getDictPropertysByKeys(dictKey);
		buildResponse(modelAndView,propertyList);
		return modelAndView;
	}

	/**
	 * 新增修改
	 * @param voObj
	 * @return
	 */
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysDictProperty voObj){
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
	 * 新的新增修改
	 * @param list
	 * @return
	 */
	/*@RequestMapping("/saveOrUpdateList")
	public ModelAndView saveOrUpdateList(SysDictProperty sysDictProperty){
		int i = sysDictProperty.getName().split(",").length;
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		for(SysDictProperty voObj : list) {
			String id = voObj.getId();
			if (id == null || id.trim().equals("")) {
				errMsg = service.insert(voObj);
			} else {
				errMsg = service.update(voObj);
			}
			if (errMsg != null && !errMsg.equals("")) {
				buildErrorResponse(modelAndView, errMsg);
			} else {
				buildResponse(modelAndView);
			}
		}
		return modelAndView;
	}
	*/
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
