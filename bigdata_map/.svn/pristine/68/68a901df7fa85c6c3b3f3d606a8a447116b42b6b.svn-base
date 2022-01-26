package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.queryvo.SysUserQuery;
import com.edgedo.sys.queryvo.SysUserView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;

@Mapper
public interface SysUserMapper  extends BaseMapper<SysUser>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserView> listPage(SysUserQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysUserView> listByObj(SysUserQuery query);

	/**
	 * 修改用户密码
	 * @param sysUser
	 */
	public void updateUserPwd(SysUser sysUser);

	/**
	 * 根据账号查询用户
	 * @param userCode
	 * @return
	 */
	public SysUserView getAdminUserByCode(String userCode);

	//修改登录状态和登录时间
	public void updateLoginStateLogin(String id);

	//逻辑删除
	public void logicDeleteById(String id);
	//逻辑删除企业管理员
	public void deleteByCompId(String compId);

	/**
	 * 退出登录
	 * @param userId
	 */
	void updateUserLogout(String userId);

	/**
	 * 根据Id查询用户
	 * @param id
	 * @return
	 */
	public SysUser selectByPrimaryKey(String id);
	
	public String selectByUserCode(String code);

	SysUserView getByUserId(String userId);

	/**
	 * 查看身份证是否已经存在
	 * @param idCardNum
	 * @return
	 */
	public String selectIdCardNum(String idCardNum);
}