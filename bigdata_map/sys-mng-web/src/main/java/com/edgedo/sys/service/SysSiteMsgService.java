package com.edgedo.sys.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysOrg;
import com.edgedo.sys.entity.SysOrgLevelRole;
import com.edgedo.sys.entity.SysSiteMsg;
import com.edgedo.sys.entity.SysUser;
import com.edgedo.sys.mapper.SysSiteMsgMapper;
import com.edgedo.sys.queryvo.SysSiteMsgQuery;
import com.edgedo.sys.queryvo.SysSiteMsgView;
import com.edgedo.sys.queryvo.SysUserQuery;
import com.edgedo.sys.queryvo.SysUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Service
public class SysSiteMsgService {
	
	
	@Autowired
	private SysSiteMsgMapper mapper;
	@Autowired
	SysUserService sysUserService;
	@Autowired
	SysOrgService sysOrgService;
	@Autowired
	SysOrgLevelRoleService sysOrgLevelRoleService;

	
	public List<SysSiteMsgView> listPage(SysSiteMsgQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysSiteMsg voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	//新的新增方法
	public String insert(String title,String id,String content,Date createTime,String userids) {
		SysSiteMsg voObj = setPro(title,id,content,createTime);
		String[] userIds = userids.split(",");
		int j = userIds.length;
		for (int i = 0; i < j;i++){
			if( "发送失败".equals(newInsert(userIds[i],voObj))){
				return "发送失败";
			}
		}
		return "";
	}
	//设置共有属性
	public SysSiteMsg setPro(String title,String id,String content,Date createTime){
		SysSiteMsg voObj = new SysSiteMsg();
//		SysUser su = AdminUserLoginIntercepter.getCurrentUser();
		voObj.setTitle(title);
//		voObj.setSendUserId(su.getId());
//		voObj.setSenUserName(su.getUserName());
		voObj.setMsgType("0");
		voObj.setDateState("1");
		voObj.setOwnerMsg(id);
		voObj.setContent(content);
		voObj.setIsRead("否");
		voObj.setCreateTime(createTime);
		return voObj;
	}

	//插入
	public String newInsert(String id,SysSiteMsg voObj){
		SysUser sysUser = sysUserService.loadById(id);
		if(sysUser==null){
			SysOrg sysOrg = sysOrgService.loadById(id);
			if(sysOrg==null){
				SysOrgLevelRole sysOrgLevelRole = sysOrgLevelRoleService.loadById(id);
				if(sysOrgLevelRole==null){
					return "发送失败";
				}else {
					SysUserQuery sysUserQuery = new SysUserQuery();
					SysUserView sysUserView = new SysUserView();
					sysUserView.setDefaultRoleId(sysOrgLevelRole.getId());
					sysUserQuery.setQueryObj(sysUserView);
					List<SysUserView> list = sysUserService.listPageOther(sysUserQuery);
					if(list==null){
						return "发送失败";
					}else {
						for (SysUserView s : list) {
							voObj.setId(Guid.guid());
							voObj.setUserId(s.getId());
							voObj.setUserCode(s.getUserCode());
							voObj.setUserName(s.getUserName());
							mapper.insert(voObj);
						}
					}
				}
			}else {
				SysUserQuery sysUserQuery = new SysUserQuery();
				SysUserView sysUserView = new SysUserView();
				sysUserView.setDeptId(sysOrg.getId());
				sysUserQuery.setQueryObj(sysUserView);
				List<SysUserView> list = sysUserService.listPageOther(sysUserQuery);
				if(list==null){
					return "发送失败";
				}else {
					for (SysUserView s : list) {
						voObj.setId(Guid.guid());
						voObj.setUserId(s.getId());
						voObj.setUserCode(s.getUserCode());
						voObj.setUserName(s.getUserName());
						mapper.insert(voObj);
					}
				}
			}
		}else {
			voObj.setId(Guid.guid());
			voObj.setUserId(id);
			voObj.setUserCode(sysUser.getUserCode());
			voObj.setUserName(sysUser.getUserName());
			mapper.insert(voObj);
		}
		return "";
	}
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysSiteMsg voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysSiteMsg voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	/**
	 * 批量删除
	 * @param ownerMsg
	 */
	public int deleteByownerMsg(List<String> ids) {
		List<SysSiteMsgView> list = new ArrayList<SysSiteMsgView>();
		List<String> idList = new ArrayList<>();
		for(String ownerMsg:ids) {
			SysSiteMsgQuery sysSiteMsgQuery = new SysSiteMsgQuery();
			SysSiteMsgView sysSiteMsgView = new SysSiteMsgView();
			sysSiteMsgView.setOwnerMsg(ownerMsg);
			sysSiteMsgQuery.setQueryObj(sysSiteMsgView);
			list = listPage(sysSiteMsgQuery);
			for(SysSiteMsgView sysSiteMsg:list){
				idList.add(sysSiteMsg.getId());
			}
		}
		return mapper.deleteBatchIds(idList);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public SysSiteMsg loadById(String id) {
		return mapper.selectById(id);
	}
	/**
	 * 加载并更改单个
	 * @param id
	 * @param response
	 */
	public SysSiteMsg updataAndLoadById(String id, HttpSession session) {
		SysSiteMsg sysSiteMsg =  loadById(id);
		if(!("是".equals(sysSiteMsg.getIsRead()))) {
			sysSiteMsg.setIsRead("是");
			update(sysSiteMsg);
			Integer num = (Integer) session.getAttribute("msg");
			session.setAttribute("msg", (num - 1));
		}
		/*try{
			response.getWriter().write("<script type='text/javascript'>window.location.reload();</script>");
		}
		catch (IOException e){}*/
		return sysSiteMsg;
	}

}
