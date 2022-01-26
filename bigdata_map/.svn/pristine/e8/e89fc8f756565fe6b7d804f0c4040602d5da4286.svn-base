package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataGpsTransmitPlatform;
import com.edgedo.bigdata.mapper.BigdataGpsTransmitPlatformMapper;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitPlatformQuery;
import com.edgedo.bigdata.queryvo.BigdataGpsTransmitPlatformView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataGpsTransmitPlatformService {
	
	
	@Autowired
	private BigdataGpsTransmitPlatformMapper mapper;

	
	public List<BigdataGpsTransmitPlatformView> listPage(BigdataGpsTransmitPlatformQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataGpsTransmitPlatform voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataGpsTransmitPlatform voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataGpsTransmitPlatform voObj) {
		mapper.updateAllColumnById(voObj);
		return "";
	}
	
	
	
	/**
	 * 单个删除
	 * @param id
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int delete(String id) {
		
		return mapper.deleteById(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public int deleteByIds(List<String> ids) {
		
		return mapper.deleteBatchIds(ids);
	}
	
	
	
	/**
	 * 加载单个
	 * @param id
	 */
	public BigdataGpsTransmitPlatform loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * @Author WangZhen
	 * @Description 获得所有转发平台
	 * @Date 2020/1/16 14:08
	 **/
	public List<BigdataGpsTransmitPlatformView> selectAllPlatformOfUp() {
		return mapper.selectAllPlatformOfUp();
	}

}
