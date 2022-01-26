package com.edgedo.bigdata.controller;

import com.alibaba.fastjson.JSON;
import com.edgedo.bigdata.entity.SysUser;
import com.edgedo.bigdata.queryvo.SysUserView;
import com.edgedo.bigdata.service.SysUserService;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.common.shiro.IUserTokenSign;
import com.edgedo.common.shiro.User;
import com.edgedo.common.util.CallBackInterface;
import com.edgedo.common.util.JWTUtil;
import com.edgedo.common.util.MD5;
import com.edgedo.common.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/sysUser")
public class SysUserController extends BaseController {
	@Autowired
	IUserTokenSign userTokenSign;
	@Autowired
	JWTUtil.JwtRsaSecKey secKey;
	@Autowired
	private SysUserService service;
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
	public ModelAndView login(@RequestParam(required=true) String userCode,
							  @RequestParam(required=true) String password,
							  final HttpSession session,
							  HttpServletRequest request,
							  HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		String errMsg = "";
		final SysUserView user = service.getAdminUserByCode(userCode);
		if(user==null){
			buildErrorResponse(modelAndView, "系统升级中！");
			//buildErrorResponse(modelAndView, "用户不存在");
			return modelAndView;
		}
		String userState = user.getUserState();
		if(userState==null || userState.equals("LOCK")){
			buildErrorResponse(modelAndView, "系统升级中！");
			//buildErrorResponse(modelAndView, "用户已被锁定！");
			return modelAndView;
		}
		String pwd = MD5.encode(MD5.encode(password)+user.getId());
		if(!pwd.equals(user.getPassword())){
			//buildErrorResponse(modelAndView, "密码错误！");
			buildErrorResponse(modelAndView, "系统升级中！");
			return modelAndView;
		}

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
				String userInfo = JSON.toJSONString(shiroUser);
				//将字符串使用RSA加密
				try {
					token[0] = userTokenSign.sign(userInfo);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		//操作日志
		buildResponse(modelAndView,token[0]);
		//将token写到cookie里面去
		Cookie cookie = new Cookie("access-token",token[0]);
		cookie.setPath("/");
		response.addCookie(cookie);
		return modelAndView;
		
	}

	/**
	 * 退出
	 * @return
	 */
	@RequestMapping("/getLoginUser")
	@ResponseBody
	public ModelAndView getLoginUser(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		User user = getLoginUser();
		return buildResponse(modelAndView,user);
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

	/*生成账号密码*/
	/*public static void main(String[] args) {
		System.out.println("11");
		String userId = "fbc2b6b7-4d67-4368-b6d1-894cf92ee32d";
		String password = "ningyue259900";
		String md5Pwd  = MD5.encode(MD5.encode(password)+userId);
		System.out.println("md5Pwd======"+md5Pwd);
	}*/
}
