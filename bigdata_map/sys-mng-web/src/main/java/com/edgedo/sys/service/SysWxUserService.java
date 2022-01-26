package com.edgedo.sys.service;

import java.util.Date;
import java.util.List;

import com.edgedo.common.util.EmojiUtil;
import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysWxUser;
import com.edgedo.sys.mapper.SysWxUserMapper;
import com.edgedo.sys.queryvo.SysWxUserQuery;
import com.edgedo.sys.queryvo.SysWxUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysWxUserService {
	
	
	@Autowired
	private SysWxUserMapper mapper;

	
	public List<SysWxUserView> listPage(SysWxUserQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysWxUser voObj) {
		voObj.setId(Guid.guid());
		String nickName = voObj.getNickName();
		if(nickName!=null){
			String encNick = EmojiUtil.emojiConverterUnicodeStr(nickName);
			voObj.setNickName(encNick);
		}
		try {
			mapper.insert(voObj);
		}catch (Exception e){
			voObj.setNickName(null);
			mapper.insert(voObj);
		}
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysWxUser voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysWxUser voObj) {
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
	 * 加载单个
	 * @param id
	 */
	public SysWxUser loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 根据业务用户id获取微信用户id
	 * @param ywUserId
	 * @return
	 */
    public SysWxUserView selectWxUserByYwUserId(String ywUserId) {

    	return mapper.selectWxUserByYwUserID(ywUserId);
    }

	/**
	 * 根据openid获取微信用户
	 * @param openId
	 * @return
	 */
	public SysWxUserView selectWxUserByOpenId(String openId) {
    	return mapper.selectWxUserByOpenId(openId);
	}

}
