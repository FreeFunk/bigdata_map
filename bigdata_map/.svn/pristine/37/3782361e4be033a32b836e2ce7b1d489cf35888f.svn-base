package com.edgedo.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.edgedo.common.base.BaseController;
import com.edgedo.common.shiro.User;
import com.edgedo.sys.entity.SysOrg;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.queryvo.SysOrgQuery;
import com.edgedo.sys.queryvo.SysOrgViewSyn;
import com.edgedo.sys.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysOrg")
public class SysOrgController extends BaseController {
	
	@Autowired
	private SysOrgService service;
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysOrgQuery query){
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
	public ModelAndView saveOrUpdate(SysOrg voObj){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		String id = voObj.getId();
		if(id==null || id.trim().equals("")){
			//获取当前的登录用户
			User user = getLoginUser();
			if(user!=null){
				voObj.setCreateUserName(user.getUserName());
				voObj.setCreateUserId(user.getUserId());
			}
			voObj.setCreateTime(new Date());
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
		String errMsg = service.deleteByIdsAndUpadteParentIsLeaf(list);
		if(errMsg.length()>0){
			buildErrorResponse(modelAndView,errMsg);
			return modelAndView;
		}
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
	@RequestMapping("/loadOrg")
	public ModelAndView  loadOrg(String id){
		ModelAndView modelAndView = new ModelAndView();
		List<SysOrgViewSyn> orgList = new ArrayList<>();
//		List<SysOrgViewSyn> orgList = service.selectByPreantID(id);
		SysOrgViewSyn sysOrgViewSyn = new SysOrgViewSyn ();
		sysOrgViewSyn.setId("ROOT");
		sysOrgViewSyn.setOrgName("组织机构树");
		sysOrgViewSyn.setName();
		List<SysOrgViewSyn> childList = service.selectByPreantID(sysOrgViewSyn.getId());
		sysOrgViewSyn.setChildren(childList);
		recursive(childList);
		orgList.add(sysOrgViewSyn);
		recursive(orgList);
		return buildResponse(modelAndView,orgList);
	}

	private void recursive(List<SysOrgViewSyn> list){

		for(SysOrgViewSyn pmv : list){
			if(pmv==null){
				return;
			}
			pmv.setText();
			pmv.setName();
			List<SysOrgViewSyn> childList = service.selectByPreantID(pmv.getId());
			pmv.setChildren(childList);
			recursive(pmv.getChildren());
		}
	}
	
}
