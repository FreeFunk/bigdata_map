package com.edgedo.sys.mapper;

import java.util.List;

import com.edgedo.sys.entity.SysWxUser;
import com.edgedo.sys.queryvo.SysWxUserQuery;
import com.edgedo.sys.queryvo.SysWxUserView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;


@Mapper
public interface SysWxUserMapper  extends BaseMapper<SysWxUser>{
	
	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysWxUserView> listPage(SysWxUserQuery query);
	
	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysWxUserView> listByObj(SysWxUserQuery query);

	/**
	 * 根据业务用户获取微信用户
	 * @param ywUserId
	 * @return
	 */
    SysWxUserView selectWxUserByYwUserID(String ywUserId);
	/**
	 * 根据openid获取微信用户
	 * @param openId
	 * @return
	 */
	SysWxUserView selectWxUserByOpenId(String openId);
}