package com.edgedo.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.edgedo.common.util.Guid;
import com.edgedo.sys.entity.SysDictProperty;
import com.edgedo.sys.mapper.SysDictPropertyMapper;
import com.edgedo.sys.queryvo.SysDictPropertyQuery;
import com.edgedo.sys.queryvo.SysDictPropertyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SysDictPropertyService {


	@Autowired
	private SysDictPropertyMapper mapper;


	public List<SysDictPropertyView> listPage(SysDictPropertyQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}

	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysDictProperty voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}

	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysDictProperty voObj) {
		mapper.updateById(voObj);
		return "";
	}

	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysDictProperty voObj) {
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
	public SysDictProperty loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 加载单个
	 * @param value
	 */
	public SysDictProperty loadByValue(String value) {
		return mapper.selectByValue(value);
	}

	/**
	 * 根据字典key获得字典属性
	 * @param dictKey
	 * @return
	 */
	public List<SysDictPropertyView> getDictPropertysByKeys(String dictKey) {
		return mapper.getDictPropertysByKeys(dictKey);
	}

	/**
	 * 根据字典key和属性值获得字典属性
	 * @param dictKey
	 * @param proValue
	 * @return
	 */
	public SysDictPropertyView getDictPropertysByKeyAndProValue(String dictKey, String proValue) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("dictKey" , dictKey);
		param.put("value" , proValue);
		return mapper.getDictPropertysByKeyAndProValue(param);
	}


}
