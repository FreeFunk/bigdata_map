package com.edgedo.sys.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.SysDictionaryKey;
import com.edgedo.sys.queryvo.SysDictionaryKeyQuery;
import com.edgedo.sys.queryvo.SysDictionaryKeyView;
import com.edgedo.sys.service.SysDictionaryKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysDictionaryKey")
public class SysDictionaryKeyController extends BaseController {
	
	@Autowired
	private SysDictionaryKeyService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysDictionaryKeyQuery query){
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
	@RequestMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(SysDictionaryKey voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(service.loadById(id)==null||service.loadById(id).equals("")){
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
		String errMsg = "";
		errMsg = service.deleteByIds(list);
		if(errMsg!=null && !errMsg.equals("")){
			buildErrorResponse(modelAndView, errMsg);
		}else{
			buildResponse(modelAndView);
		}
		return modelAndView;
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

	/**
	 * 根据主键加载名字
	 * @param id
	 * @return
	 */
	@RequestMapping("/loadNameById")
	public ModelAndView  loadNameById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadById(id).getDictName());
	}

	/**
	 * 根据主键加载父节点
	 * @param id
	 * @return
	 */
	@RequestMapping("/loadparentById")
	public ModelAndView  loadparentById(String id){
		ModelAndView modelAndView = new ModelAndView();
		return buildResponse(modelAndView, service.loadparentById(id));
	}
	
	
	/**
	 * 加载树
	 * @param id
	 * @return
	 */
	@RequestMapping("/loadTree")
	public ModelAndView  loadTree(String id){
		if(id==null || id==""){
			id="ROOT";
		}
		ModelAndView modelAndView = new ModelAndView();
		List<SysDictionaryKeyView> tree = service.selectByParentId(id);
		diguiselect(tree);
		return buildResponse(modelAndView,tree);
	}
	/*@RequestMapping("/loadTree")
	public void  loadTree(String parentId,HttpServletResponse response){
		if(parentId==null || parentId==""){
			parentId="ROOT";
		}
		List<SysDictionaryKeyView> tree = service.selectByParentId(parentId);
		*//*
		for(SysDictionaryKeyView s :tree){
			s.setLabel();
		}*//*
		diguiselect(tree);
		String json = JSON.toJSONString(tree);
		*//*String json = "[{\"label\":\"节点\",\"children\":["
				+ "{\"label\":\"节点1\"},"
				+ "{\"label\":\"节点2\"}"
				+ "]}]";*//*
		*//*List<TreeVo> list = new ArrayList<TreeVo>();
		String json = JSON.toJSONString(list);*//*
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


	private void diguiselect(List<SysDictionaryKeyView> tree) {
		if(tree.size()==0 || tree==null){
			return;
		}
		for(SysDictionaryKeyView sys : tree){
			sys.setName();
			List<SysDictionaryKeyView> chilelist = service.selectByParentId(sys.getId());
			sys.setChildren(chilelist);
			diguiselect(chilelist);
		}

	}

	private void recursive(List<SysDictionaryKeyView> list){

		for(SysDictionaryKeyView pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setText();
			pmv.setLabel();
			recursive(pmv.getChildren());
		}

	}
	
	
	
}
