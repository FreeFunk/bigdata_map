package com.edgedo.sys.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysDictionaryKey;
import com.edgedo.sys.queryvo.SysDictionaryKeyQuery;
import com.edgedo.sys.queryvo.SysDictionaryKeyView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface SysDictionaryKeyMapper  extends BaseMapper<SysDictionaryKey> {

	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysDictionaryKeyView> listPage(SysDictionaryKeyQuery query);

	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysDictionaryKeyView> listByObj(SysDictionaryKeyQuery query);

	/**
	 * 根据父节点查询
	 * @param parentId
	 * @return
	 */
	public List<SysDictionaryKeyView> selectByParentId(String parentId);





}