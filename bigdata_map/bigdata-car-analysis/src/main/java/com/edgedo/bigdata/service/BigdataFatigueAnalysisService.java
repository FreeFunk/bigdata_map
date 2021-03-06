package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataFatigueAnalysis;
import com.edgedo.bigdata.mapper.BigdataFatigueAnalysisMapper;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisQuery;
import com.edgedo.bigdata.queryvo.BigdataFatigueAnalysisView;
import com.edgedo.common.util.Guid;
import com.edgedo.util.DateUtil;
import freemarker.template.SimpleDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataFatigueAnalysisService {

	private SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	private BigdataFatigueAnalysisMapper mapper;

	
	public List<BigdataFatigueAnalysisView> listPage(BigdataFatigueAnalysisQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataFatigueAnalysis voObj) {
		String id = voObj.getId();
		if(id==null || id.length()==0){
			voObj.setId(Guid.guid());
		}
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataFatigueAnalysis voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataFatigueAnalysis voObj) {
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
	public BigdataFatigueAnalysis loadById(String id) {
		return mapper.selectById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void addOrUpdate(BigdataFatigueAnalysis bigdataFatigueAnalysis) {
		Date countTime = bigdataFatigueAnalysis.getCountTime();
		String countTimeStr = sdfDateInt.format(countTime);
		int countTimeInt = new Integer(countTimeStr);
		String id = bigdataFatigueAnalysis.getCarType() + "-" +countTimeStr;
		bigdataFatigueAnalysis.setId(id);
		bigdataFatigueAnalysis.setCountDate(countTimeInt);
		bigdataFatigueAnalysis.setCountMonth(countTimeInt/100);
		//查看当天的记录是否存在
		BigdataFatigueAnalysis  bigdataFatigueAnalysisView = loadById(id);
		//查询上一天的记录
		BigdataFatigueAnalysis bigdataOverspeedAnalysis1 = new BigdataFatigueAnalysis();
		Date lastDayDate= DateUtil.getLastDayDate(bigdataFatigueAnalysis.getCountTime());
		bigdataOverspeedAnalysis1.setCountTime(lastDayDate);
		bigdataOverspeedAnalysis1.setCarType(bigdataFatigueAnalysis.getCarType());
		BigdataFatigueAnalysisView  bigdataFatigueAnalysisViewLast = mapper.getVoByQuery(bigdataOverspeedAnalysis1);
		//和前一天对比得出箭头的标识
		if(bigdataFatigueAnalysisViewLast==null){
			bigdataFatigueAnalysis.setSeriousfatigueflAg("1");
			bigdataFatigueAnalysis.setNightfatigueflAg("1");
			bigdataFatigueAnalysis.setNightFatigueNoflAg("1");
		}else {
			if(bigdataFatigueAnalysisViewLast.getNightFatigueRate()==null){
				bigdataFatigueAnalysis.setNightfatigueflAg("1");
			}else {
				if(bigdataFatigueAnalysis.getNightFatigueRate()!=null){
					if(bigdataFatigueAnalysis.getNightFatigueRate().compareTo(bigdataFatigueAnalysisViewLast.getNightFatigueRate())>=0){
						bigdataFatigueAnalysis.setNightfatigueflAg("1");
					}else {
						bigdataFatigueAnalysis.setNightfatigueflAg("0");
					}
				}
			}
			if(bigdataFatigueAnalysisViewLast.getNightFatigueNoRate()==null){
				bigdataFatigueAnalysis.setNightFatigueNoflAg("1");
			}else {
				if(bigdataFatigueAnalysis.getNightFatigueNoRate()!=null){
					if(bigdataFatigueAnalysis.getNightFatigueNoRate().compareTo(bigdataFatigueAnalysisViewLast.getNightFatigueNoRate())>=0){
						bigdataFatigueAnalysis.setNightFatigueNoflAg("1");
					}else {
						bigdataFatigueAnalysis.setNightFatigueNoflAg("0");
					}
				}
			}
			if(bigdataFatigueAnalysisViewLast.getSeriousFatigueRate()==null){
				bigdataFatigueAnalysis.setSeriousfatigueflAg("1");
			}else {
				if(bigdataFatigueAnalysis.getSeriousFatigueRate()!=null){
					if(bigdataFatigueAnalysis.getSeriousFatigueRate().compareTo(bigdataFatigueAnalysisViewLast.getSeriousFatigueRate())>=0){
						bigdataFatigueAnalysis.setSeriousfatigueflAg("1");
					}else {
						bigdataFatigueAnalysis.setSeriousfatigueflAg("0");
					}
				}
			}
		}
		if(bigdataFatigueAnalysisView==null){
			bigdataFatigueAnalysis.setCreateTime(new Date());
			insert(bigdataFatigueAnalysis);
		}else {
			bigdataFatigueAnalysis.setId(bigdataFatigueAnalysisView.getId());
			update(bigdataFatigueAnalysis);
		}
	}

	/**
	 *
	 * @param monthInt
	 * @return
	 */
    public List<BigdataFatigueAnalysis> selectGroupSumCountMonth(int monthInt) {
		return mapper.selectGroupSumCountMonth(monthInt);
    }

	public BigdataFatigueAnalysisView getVoByQuery(BigdataFatigueAnalysis bigdataFatigueAnalysis) {
		return mapper.getVoByQuery(bigdataFatigueAnalysis);
	}
}
