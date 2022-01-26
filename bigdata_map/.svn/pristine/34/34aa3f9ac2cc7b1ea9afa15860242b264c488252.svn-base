package com.edgedo.sys.service;

import java.util.Date;
import java.util.List;


import com.edgedo.common.util.CallBackInterface;
import com.edgedo.common.util.Guid;
import com.edgedo.common.util.MD5;
import com.edgedo.sys.entity.SysOrgLevelRole;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.entity.SysUserRole;
import com.edgedo.sys.mapper.SysOrgLevelRoleMapper;
import com.edgedo.sys.mapper.SysUserMapper;
import com.edgedo.sys.queryvo.SysSiteMsgQuery;
import com.edgedo.sys.queryvo.SysSiteMsgView;
import com.edgedo.sys.queryvo.SysUserQuery;
import com.edgedo.sys.queryvo.SysUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;


@Service
public class SysUserService {
	
	
	@Autowired
	private SysUserMapper mapper;

	@Autowired
	private SysOrgLevelRoleMapper mapper1;
	
	@Autowired
	private SysOrgLevelRoleService sysOrgLevelRoleService ;
	
	@Autowired
	private SysUserRoleService sysUserRoleService ;
	
	@Autowired
	private SysUserLoginLogService loginLogService;
	@Autowired
	private SysSiteMsgService sysSiteMsgService;


	public String findHomeId(String defaultRoleId){
		String path;
		if(defaultRoleId==null||defaultRoleId.equals("")){
			path = "";
		}else{
			SysOrgLevelRole sysOrgLevelRole = mapper1.selectById(defaultRoleId);
			path = sysOrgLevelRole.getRoleHomePagePath();
		}
		return  path;
	}

	public void listPage(SysUserQuery query){
		List list = mapper.listPage(query);
		if(list.size()==0){
			query.getQueryObj().setUserName(query.getQueryObj().getUserCode());
			query.getQueryObj().setUserCode(null);
			List list2 = mapper.listPage(query);
			query.setList(list2);
		}else{
			query.setList(list);
		}
	}
	//又一个listPage
	public List<SysUserView> listPageOther(SysUserQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	/*public String insert(SysUser voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}*/
	
	public String insert(SysUser voObj) {
		   String result = "";
			//验证返回的结果,无错返回""，否则返回错误信息

			result = test(voObj);
			String defaultRoleId = voObj.getDefaultRoleId();
			SysOrgLevelRole role = sysOrgLevelRoleService.loadById(defaultRoleId);
			if ("".equals(result)) {
				String userId = "";
				if(voObj.getId()!=null && !voObj.getId().equals("")){
					userId = voObj.getId();
				}else {
					userId = Guid.guid();
				}
				voObj.setId(userId);
				voObj.setDefaultRoleName(role.getRoleName());
				voObj.setCreateTime(new Date());
				voObj.setDataState("1");
				voObj.setUserState("ACTIVE");
				voObj.setLoginState("OFFLINE");
				String password = MD5.encode(MD5.encode(voObj.getPassword()) + voObj.getId());
				voObj.setPassword(password);
				mapper.insert(voObj);
				if (defaultRoleId != null && defaultRoleId.length() > 0) {
					if (role != null) {
						//插入角色关联
						SysUserRole userRole = new SysUserRole();
						userRole.setRoleId(role.getId());
						userRole.setUserId(userId);
						sysUserRoleService.insert(userRole);
					}
				}

				return result;
			}
		return result;
	}
	//校验
	public String test(SysUser voObj){
		//账号和密码正则表达式
		String capReg = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
		//查看身份证是否存在
		String sign=mapper.selectIdCardNum(voObj.getIdCardNum());
		if (sign!=null&&!sign.equals("")){
			return "该身份证号已存在!";
		}
		//手机号
		//String telReg = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
		//身份证号
		//String cardReg1 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
		//String cardReg2 = "^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$";
		//重复验证
		SysUser user = getAdminUserByCode(voObj.getUserCode());
		//开始验证
		if(user!=null){
			return "账户已存在!";
		}else if(voObj.getUserSex()==""||voObj.getUserSex()==null){
			return "请选择性别!";
		}else if(voObj.getDefaultRoleId()==""||voObj.getDefaultRoleId()==null){
			return "请选择主角色!";
		}/*else if(!voObj.getUserCode().matches(capReg)){
			return "账号格式错误!";
		}else if(!voObj.getPassword().matches(capReg)){
			return "密码格式错误!";
		}*//*else if(!(voObj.getIdCardNum().matches(cardReg1)||voObj.getIdCardNum().matches(cardReg2))){
			return "请输入正确的身份证号";
		}else if(!voObj.getPhone().matches(telReg)){
			return "请输入正确的电话号码";
		}*/
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysUser voObj) {
		//根据userId加载数据库中未进行修改的user数据
		//王斌 2019-01-19 首先修改sys_user表中的数据信息;
		SysUser sysUser = loadById(voObj.getId());

		//获取未经修改的user默认Role的关联
		String oldDefaultRoleId = sysUser.getDefaultRoleId();
		sysUser.setAge(voObj.getAge());
		if(voObj.getAge()>100){
			return "年龄输入不合法";
		}
		sysUser.setPhone(voObj.getPhone());
		sysUser.setIdCardNum(voObj.getIdCardNum());
		sysUser.setUserSex(voObj.getUserSex());
		sysUser.setUserName(voObj.getUserName());
		sysUser.setDefaultRoleId(voObj.getDefaultRoleId());
		SysOrgLevelRole role = sysOrgLevelRoleService.loadById(voObj.getDefaultRoleId());
		sysUser.setDefaultRoleName(role.getRoleName());
		mapper.updateById(sysUser);
		//王斌 2019-01-19 2.进行sys_user_role表的数据的修改
		//删除上一个默认关联的角色
		sysUserRoleService.deleteByUserAndRole(sysUser.getId(),oldDefaultRoleId);
		//获取到前台传来的id;
		String newDefaultRoleId = voObj.getDefaultRoleId();
		//王斌 2019-01-19 3.删除sys_user_role表中userId和roleId的数据
		sysUserRoleService.deleteByUserAndRole(sysUser.getId(),oldDefaultRoleId);
		SysUserRole userRole = new SysUserRole();
		userRole.setRoleId(newDefaultRoleId);
		userRole.setUserId(sysUser.getId());
		sysUserRoleService.insert(userRole);
		/*//如果不是空的就进行修改操作
		if (newDefaultRoleId != null && newDefaultRoleId.length() > 0) {
			//根据新的角色id查询这个角色相关的信息;
			SysOrgLevelRole role = sysOrgLevelRoleService.loadById(newDefaultRoleId);
			//是否有这个相关的角色
			if (role != null) {
				voObj.setDefaultRoleName(role.getRoleName());
				//插入角色关联
				SysUserRole userRole = new SysUserRole();
				userRole.setRoleId(role.getId());
				userRole.setUserId(voObj.getId());
				if(sysUserRoleService.selectByUserIdAndRoleId(userRole.getUserId(),userRole.getRoleId())==null){
					sysUserRoleService.insert(userRole);
					//在这修改用户的基本信息;
				}else{
					return "修改失败";
				}

			}
		}
		mapper.updateById(voObj);*/
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysUser voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	public int delete(String id) {
		mapper.logicDeleteById(id);
		return 0;
	}
	
	/**
	 * 逻辑批量删除
	 * @param ids
	 */
	/*public int deleteByIds(List<String> ids) {

		//进行删除与ids相关的数据userIdRoleId;
		for(String userId : ids){
			//删除user_role表中的这个user的所有数据;
			sysUserRoleService.deleteByUserId(userId);
		}
		return mapper.deleteBatchIds(ids);
	}*/
	public int deleteByIds(List<String> ids) {

		//进行删除与ids相关的数据userIdRoleId;
		for(String userId : ids){
			//删除user_role表中的这个user的所有数据;
			sysUserRoleService.deleteByUserId(userId);
			mapper.logicDeleteById(userId);
		}
		return 0;
	}
	//逻辑删除企业管理员
	public int deleteByCompId(String compId) {

		mapper.deleteByCompId(compId);
		return 0;
	}
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysUser loadById(String id) {
		return mapper.selectById(id);
	}


	/**
	 * 重置密码
	 * @param sysUserId 系统用户id
	 */
	public void updateResetPwd(String sysUserId) {
		SysUser sysUser = mapper.selectById(sysUserId);
		String pwdStr = MD5.encode(MD5.encode("888888") + sysUserId);
		sysUser.setPassword(pwdStr);
		mapper.updateUserPwd(sysUser);
	}

	/**
	 * 根据账号查询用户
	 * @param userCode
	 * @return
	 */
	public SysUserView getAdminUserByCode(String userCode) {
		return mapper.getAdminUserByCode(userCode);
	}
	//获取站内信未读的数量
	public Integer getMsgNum( SysUserView user){
		SysSiteMsgQuery sysSiteMsgQuery = new SysSiteMsgQuery();
		SysSiteMsgView sysSiteMsgView = new SysSiteMsgView();
		sysSiteMsgView.setIsRead("否");
		sysSiteMsgView.setUserId(user.getId());
		sysSiteMsgQuery.setQueryObj(sysSiteMsgView);
		List<SysSiteMsgView> list = sysSiteMsgService.listPage(sysSiteMsgQuery);
		return list.size();
	}

	/**
	 * 修改用户登录状态和登录时间
	 * @param user 用户
	 * @param  ipAddress IP地址
	 */
	public void updateLoginStateLogin(SysUserView user, String ipAddress, CallBackInterface call) {
		loginLogService.insertLog(user,ipAddress);
		//插入登录日志
		mapper.updateLoginStateLogin(user.getId());
		call.callBack();
	}

	/**
	 * 用户退出
	 * @param userId 用户id
	 */
	public void updateUserLogout(String userId) {
		mapper.updateUserLogout(userId);
	}

	/**
	 * 修改用户密码
	 * @param id 用户id
	 * @param pwd  密码
	 */
	public void updateUserPwd(String id, String pwd) {
		SysUser user = mapper.selectByPrimaryKey(id);
		String pwdStr = MD5.encode(MD5.encode(pwd) + id);
		//原密码和新密码一样就不操作数据库了
		if(pwdStr.equals(user.getPassword())){
			return;
		}
		user.setPassword(pwdStr);
		mapper.updateUserPwd(user);
	}

	public String selectByUserCode(String code) {
		return mapper.selectByUserCode(code);
	}

	public SysUserView getByUserId(String userId) {
		return mapper.getByUserId(userId);
	}
}
