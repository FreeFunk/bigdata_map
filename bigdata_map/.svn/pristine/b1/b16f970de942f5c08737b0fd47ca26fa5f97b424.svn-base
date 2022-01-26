package com.edgedo.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.sequrity.CheckPermission;
import com.edgedo.common.shiro.JwtRsaSecKey;
import com.edgedo.common.shiro.User;
import com.edgedo.common.util.CallBackInterface;
import com.edgedo.common.util.JWTUtil;
import com.edgedo.common.util.MD5;
import com.edgedo.common.util.RSAUtil;
import com.edgedo.sys.entity.*;
import com.edgedo.sys.queryvo.*;
import com.edgedo.sys.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/sysUser")
public class SysUserController extends BaseController {
	@Autowired
	JwtRsaSecKey secKey;
	@Autowired
	private SysUserService service;
	
	@Autowired
	private SysPowerService sysPowerService;
	
	@Autowired
	private SysOrgLevelRoleService sysOrgLevelRoleService ;

	@Autowired
	private SysMenueService sysMenueService ;
	@Autowired
	private SysXianquService xianquService;
	@Autowired
	private SysCityService cityService;
	@Autowired
	private SysProviceService proviceService;

	/**
	 * 根据登录用户初始化主页
	 *
	 * @return
	 */
	@RequestMapping("/loadCurrUser")
	public ModelAndView loadCurrUser(HttpServletRequest request){

		ModelAndView modelAndView = new ModelAndView();
		try {
			User shiroUser = getLoginUser();
			return buildResponse(modelAndView,shiroUser);
		} catch (Exception e) {
			return buildErrorResponse(modelAndView,"获取用户信息错误");
		}
	}

	/**
	 * 加载当前登录用户的信息携带着省份县市
	 *
	 * @return
	 */
	@RequestMapping("/loadCurrUserWithArea")
	public ModelAndView loadCurrUserWithArea(){

		ModelAndView modelAndView = new ModelAndView();
		try {
			Map<String,Object> result = new HashMap<String,Object>();
			User shiroUser = getLoginUser();
			String xianquId = shiroUser.getXianquId();

			if(xianquId!=null){
				SysXianqu xianqu = xianquService.loadById(xianquId);
				if(xianqu!=null){
					result.put("xianquId",xianqu.getId());
					result.put("xianquName",xianqu.getName());
					result.put("cityId",xianqu.getCityId());
					result.put("cityName",xianqu.getCityName());
					result.put("provinceId",xianqu.getProvinceId());
					result.put("provinceName",xianqu.getProvinceName());
				}

			}else{
				String cityId = shiroUser.getCityId();
				if(cityId != null){
					SysCity city = cityService.loadById(cityId);
					if(city != null){
						result.put("cityId",city.getId());
						result.put("cityName",city.getName());
						result.put("provinceId",city.getProvinceId());
						result.put("provinceName",city.getProvinceNane());
					}
				}else {
					String provincId = shiroUser.getProvinceId();
					if(provincId!=null){
						SysProvice provice = proviceService.loadById(provincId);
						if(provice != null){
							result.put("provinceId",provice.getId());
							result.put("provinceName",provice.getName());
						}
					}
				}
			}
			return buildResponse(modelAndView,result);
		} catch (Exception e) {
			return buildErrorResponse(modelAndView,"获取用户信息错误");
		}
	}

	/**
	 * 根据登录用户初始化主页
	 *
	 * @return
	 */
	@RequestMapping("/findHome")
	public ModelAndView findHome(){
		ModelAndView modelAndView = new ModelAndView();
		User user = getLoginUser();
		String defaultRoleId = user.getDefaultRole();
		String homePath = service.findHomeId(defaultRoleId);
		buildResponse(modelAndView,homePath);
		return modelAndView;
	}
	
	/**
	 * 分页查询
	 * @param query
	 * @return
	 */
	@RequestMapping("/listpage")
	public ModelAndView listpage(@ModelAttribute SysUserQuery query){
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
	public ModelAndView saveOrUpdate(SysUser voObj){
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
	 * 批量删除
	 * @return
	 */
	@RequestMapping("/jugeUserUpPwd")
	public ModelAndView jugeUserUpPwd(){
		ModelAndView modelAndView = new ModelAndView();
		SysUser user = null;//AdminUserLoginIntercepter.getCurrentUser();
		String userId = user.getId();
		SysUser dbUser = service.loadById(userId);
		String isUpPwd = dbUser.getIsUpPwd();
		return buildResponse(modelAndView,isUpPwd);
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
	 *  管理员重置用户密码
	 * @param userId 密码
	 * @return
	 */
	@RequestMapping("/resetPwd")
	@ResponseBody
	public ModelAndView resetPwd(@RequestParam String userId){
		ModelAndView modelAndView = new ModelAndView();
		SysUser user = null;//AdminUserLoginIntercepter.getCurrentUser();
		if(user.getId().equals(userId)){
			buildErrorResponse(modelAndView,"请使用修改密码,修改自己的密码!");
			return modelAndView;
		}
		service.updateResetPwd(userId);
		//ptOpLoger.addLog(PtUserOpLogService.UPDATE, "PtUser", user.getId(), "系统用户修改自己密码", getIpAddr(), getDiviceType());
		return buildResponse(modelAndView);
	}
	
	/***
	 * 用户登录的方法
	 * @param userCode
	 * @param password
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	@Pass
	public ModelAndView login(@RequestParam(required=true) String userCode,@RequestParam(required=true) String password, final HttpSession session,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		final SysUserView user = service.getAdminUserByCode(userCode);
		if(user==null){
			buildErrorResponse(modelAndView, "用户不存在");
			return modelAndView;
		}
		String userState = user.getUserState();
		if(userState==null || userState.equals("LOCK")){
			buildErrorResponse(modelAndView, "用户已被锁定！");
			return modelAndView;
		}
		String pwd = MD5.encode(MD5.encode(password)+user.getId());
		if(!pwd.equals(user.getPassword())){
			buildErrorResponse(modelAndView, "密码错误！");
			return modelAndView;
		}
		//设置未读站内信的数量
		Integer num = service.getMsgNum(user);
		session.setAttribute("msg",num);

		//修改用户登录状态和本次登录时间
		String ipAddress = getIpAddr();
		final String[] token = new String[1];
		service.updateLoginStateLogin(user, ipAddress, new CallBackInterface() {
			@Override
			public void callBack() {
				User shiroUser = new User();
				shiroUser.setUserId(user.getId());
				shiroUser.setUserName(user.getUserName());
				shiroUser.setProvinceId(user.getProvinceId());
				shiroUser.setCityId(user.getCityId());
				shiroUser.setXianquId(user.getXianquId());
				shiroUser.setDefaultRole(user.getDefaultRoleId());
				//角色首页
				String defaultRoleId = user.getDefaultRoleId();
				if(defaultRoleId!=null && defaultRoleId.length()>0){
					SysOrgLevelRole role = sysOrgLevelRoleService.loadById(defaultRoleId);
//					if(role != null){
//						shiroUser.setHomePage(role.getRoleHomePagePath());
//						shiroUser.setHomePageTitle(role.getRoleHomePage());
//					}
				}
				//获得所有角色
//				List<SysOrgLevelRoleView> roles = sysOrgLevelRoleService.selectAllUserRolesByUserId(shiroUser.getUserId());
//				String[] roleStrs = new String[roles.size()];
//				int i =0;
//				for(SysOrgLevelRoleView roleObj :roles ){
//					roleStrs[i++] = roleObj.getId();
//				}
//				shiroUser.setUserRoles(roleStrs);
				String userInfo = JSON.toJSONString(shiroUser);
				//将字符串使用RSA加密
				try {
					String userInfoRsa = RSAUtil.encode(userInfo,secKey);
					token[0] = JWTUtil.sign(userInfoRsa,secKey.getJwtSecretkey());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		//操作日志
		buildResponse(modelAndView,token[0]);
		return modelAndView;
		
	}


	@RequestMapping("/loadUserMenueAll")
	@ResponseBody
//	@CheckPermission("sss")
	public ModelAndView loadUserMenueAll(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		List<SysMenueViewSyn> menueList = new ArrayList<SysMenueViewSyn>();
		//从数据库中读取用户菜单
		User user = User.getCurrentUser();
		List<SysMenueView> list = sysMenueService.getUserMenuByPidAndUserid(null, user.getUserId());
		Map<String,List<SysMenueViewSyn>> temMap = new HashMap<String,List<SysMenueViewSyn>>();
		menueList  = new ArrayList<SysMenueViewSyn>();
		for(SysMenueView menue : list){
			String parentId = menue.getParentId();
			if(parentId!=null && parentId.equals("ROOT")){
				menueList.add(SysMenueViewSyn.genSysMenueViewSyn(menue));
			}else{
				List<SysMenueViewSyn> listChild = temMap.get(parentId);
				if(listChild==null){
					listChild = new ArrayList<SysMenueViewSyn>();
				}
				listChild.add(SysMenueViewSyn.genSysMenueViewSyn(menue));
				temMap.put(parentId,listChild);
			}
		}
		recursive(menueList,temMap);
		buildResponse(modelAndView,menueList);
		return modelAndView;
	}
	
	/**
	 * 递归组装菜单树
	 * @param menueList
	 * @param temMap
	 */
	public void recursive(List<SysMenueViewSyn> menueList, Map<String,List<SysMenueViewSyn>> temMap){
		if(menueList==null){
			return;
		}
		for(SysMenueViewSyn pmv : menueList){
			String id = pmv.getId();
			pmv.setLabel();
			List<SysMenueViewSyn> children = temMap.get(id);
			if(children != null){
				pmv.setChildren(children);
			}
			temMap.remove(id);
			recursive(children,temMap);
		}

	}
	
	/**
	 * 用户访问菜单数据
	 * @return
	 */
	@RequestMapping("/nav")
	public ModelAndView nav(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("tpl/blocks/nav");
		return modelAndView;
	}
	
	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public ModelAndView logout(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		SysUser user = null;//AdminUserLoginIntercepter.getCurrentUser();

		return buildResponse(modelAndView);
	}
	
	/**
	 * 用户修改密码
	 * @param pwd 密码
	 * @return
	 */
	@RequestMapping("/updatePwd")
	@ResponseBody
	public ModelAndView updatePwd(@RequestParam String oldpwd,String pwd){
		ModelAndView modelAndView = new ModelAndView();
		SysUser user = null;//AdminUserLoginIntercepter.getCurrentUser();
		SysUserView thisUser = service.getAdminUserByCode(user.getUserCode());
		oldpwd = MD5.encode(MD5.encode(oldpwd)+user.getId());
		if(oldpwd.equals(thisUser.getPassword())) {
			/*pwd = MD5.encode(MD5.encode(pwd)+user.getId());*/
			service.updateUserPwd(user.getId(), pwd);
			buildResponse(modelAndView);
		}else {
			buildErrorResponse(modelAndView, "原密码错误！");
		}
		//ptOpLoger.addLog(PtUserOpLogService.UPDATE, "PtUser", user.getId(), "系统用户修改自己密码", getIpAddr(), getDiviceType());
		return modelAndView;
	}
}
