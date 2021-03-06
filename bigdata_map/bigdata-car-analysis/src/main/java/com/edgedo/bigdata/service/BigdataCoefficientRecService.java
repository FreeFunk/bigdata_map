package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataCoefficientRec;
import com.edgedo.bigdata.mapper.BigdataCoefficientRecMapper;
import com.edgedo.bigdata.queryvo.BigdataCoefficientRecQuery;
import com.edgedo.bigdata.queryvo.BigdataCoefficientRecView;
import com.edgedo.common.util.Guid;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataCoefficientRecService {
	
	
	@Autowired
	private BigdataCoefficientRecMapper mapper;

	
	public List<BigdataCoefficientRecView> listPage(BigdataCoefficientRecQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataCoefficientRec voObj) {
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
	public String update(BigdataCoefficientRec voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataCoefficientRec voObj) {
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
	public BigdataCoefficientRec loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataCoefficientRecView getCoefficientNum(BigdataCoefficientRecQuery query) {
		return mapper.getCoefficientNum(query);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void addOrUpdate(BigdataCoefficientRec bigdataCoefficientRec) {
		//查看当天的记录是否存在
		BigdataCoefficientRecView  bigdataCoefficientRecView = mapper.getVoByQuery(bigdataCoefficientRec);
		//查询上一天的记录
		BigdataCoefficientRec bigdataCoefficientRec1 = new BigdataCoefficientRec();
		Date lastDayDate= DateUtil.getLastDayDate(bigdataCoefficientRec.getCountTime());
		bigdataCoefficientRec1.setCountTime(lastDayDate);
		bigdataCoefficientRec1.setCarType(bigdataCoefficientRec.getCarType());
		BigdataCoefficientRecView  bigdataCoefficientRecViewLast = mapper.getVoByQuery(bigdataCoefficientRec1);
		//和前一天对比得出箭头的标识
		if(bigdataCoefficientRecViewLast==null){
			bigdataCoefficientRec.setOverspeedWarningNumFlag("1");
		}else {
			if(bigdataCoefficientRec.getOverspeedWarningNum()!=null){
				if(bigdataCoefficientRec.getOverspeedWarningNum().compareTo(bigdataCoefficientRecViewLast.getOverspeedWarningNum())>=0){
					bigdataCoefficientRec.setOverspeedWarningNumFlag("1");
				}else {
					bigdataCoefficientRec.setOverspeedWarningNumFlag("0");
				}
			}
			if(bigdataCoefficientRec.getFatigueRunNum()!=null){

			}else {
				bigdataCoefficientRec.setFatigueRunNum(new BigDecimal(0));
			}
			if(bigdataCoefficientRec.getDangerRoadPassNum()!=null){

			}else {
				bigdataCoefficientRec.setDangerRoadPassNum(new BigDecimal(0));
			}

			if(bigdataCoefficientRec.getDangerRoadRunNum()!=null){

			}else {
				bigdataCoefficientRec.setDangerRoadRunNum(new BigDecimal(0));
			}
			if(bigdataCoefficientRec.getSafetyNium()!=null){

			}else {
				bigdataCoefficientRec.setSafetyNium(new BigDecimal(0));
			}
		}
		if(bigdataCoefficientRecView==null){
			bigdataCoefficientRec.setCreateTime(new Date());
			insert(bigdataCoefficientRec);
		}else {
			bigdataCoefficientRec.setId(bigdataCoefficientRecView.getId());
			update(bigdataCoefficientRec);
		}
	}
}
