package com.edgedo.sys.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.sys.entity.SysPower;
import com.edgedo.sys.queryvo.SysBzModelViewSyn;
import com.edgedo.sys.queryvo.SysPowerQuery;
import com.edgedo.sys.queryvo.SysPowerViewSyn;
import com.edgedo.sys.service.SysPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysPower")
public class SysPowerController extends BaseController {
	
	@Autowired
	private SysPowerService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysPowerQuery query){
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
	public ModelAndView saveOrUpdate(SysPower voObj){
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


	//异步加载树节点
	@RequestMapping("/loadLession")
	public ModelAndView  loadOrg(String parentId){
		ModelAndView modelAndView = new ModelAndView();
		List<SysPowerViewSyn> powerList = service.selectByPreantID(parentId);
		recursive(powerList);
		return buildResponse(modelAndView,powerList);
	}

	private void recursive(List<SysPowerViewSyn> list){

		for(SysPowerViewSyn pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setText();
			recursive(pmv.getChildren());
		}

	}

	@RequestMapping("/loadTree")
	public ModelAndView loadTree(HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		String parentId = "ROOT";
		List<SysBzModelViewSyn> bzModelList = service.selectBzModelById(parentId);
		if(bzModelList.size()!=0||bzModelList!=null){
			for(SysBzModelViewSyn l : bzModelList){
				l.setModelName("模块树");
				l.setName();
				l.setLabel();
			}
		}
		diguiSelect(bzModelList);
		buildResponse(modelAndView,bzModelList);
		return modelAndView;
	}

	private void diguiSelect(List<SysBzModelViewSyn> list) {
		if(list.size()==0||list==null){
			return;
		}
		for(SysBzModelViewSyn l : list){
			l.setName();
//			l.setLabel();
			List<SysBzModelViewSyn> childList = service.selectBzModelByParentId(l.getId());
			l.setChildren(childList);
			diguiSelect(childList);
		}
	}
	
}
