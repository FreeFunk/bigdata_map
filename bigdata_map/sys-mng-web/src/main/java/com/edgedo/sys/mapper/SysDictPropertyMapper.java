package com.edgedo.sys.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.edgedo.sys.entity.SysDictProperty;
import com.edgedo.sys.queryvo.SysDictPropertyQuery;
import com.edgedo.sys.queryvo.SysDictPropertyView;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface SysDictPropertyMapper  extends BaseMapper<SysDictProperty> {

	/**
	 * 分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysDictPropertyView> listPage(SysDictPropertyQuery query);

	/**
	 * 不分页条件查询
	 * @param query
	 * @return
	 */
	public List<SysDictPropertyView> listByObj(SysDictPropertyQuery query);

	/**
	 * 根据字典key获得字典属性
	 * @param dictKey
	 * @return
	 */
	List<SysDictPropertyView> getDictPropertysByKeys(String dictKey);


	/**
	 * 根据value值查出属性
	 * @param value
	 * @return
	 */
	public SysDictProperty selectByValue(String value);

	/**
	 * 根据字典key和属性值获得字典属性
	 * @return
	 */
	SysDictPropertyView getDictPropertysByKeyAndProValue(Map<String, Object> param);

}