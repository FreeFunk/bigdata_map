package com.edgedo.bigdata.service;
		
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bigdata.entity.BigdataSafetyCheck;
import com.edgedo.bigdata.entity.BigdataSafetyProductionEchatsVo;
import com.edgedo.bigdata.queryvo.BigdataSafetyCheckQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyCheckView;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataSafetyProductionSituation;
import com.edgedo.bigdata.mapper.BigdataSafetyProductionSituationMapper;
import com.edgedo.bigdata.queryvo.BigdataSafetyProductionSituationQuery;
import com.edgedo.bigdata.queryvo.BigdataSafetyProductionSituationView;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataSafetyProductionSituationService {
	
	
	@Autowired
	private BigdataSafetyProductionSituationMapper mapper;
	@Autowired
	private BigdataSafetyCheckService bigdataSafetyCheckService;

	
	public List<BigdataSafetyProductionSituationView> listPage(BigdataSafetyProductionSituationQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataSafetyProductionSituation voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataSafetyProductionSituation voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataSafetyProductionSituation voObj) {
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
	public BigdataSafetyProductionSituation loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataSafetyProductionSituationView getSafetyProductionSituationData(BigdataSafetyProductionSituationQuery query) {
		return mapper.getSafetyProductionSituationData(query);
	}

	public BigdataSafetyProductionEchatsVo safetyProductionEchartsData(BigdataSafetyProductionSituationQuery query) {

		BigdataSafetyProductionEchatsVo bigdataSafetyProductionEchatsVo = new BigdataSafetyProductionEchatsVo();

		//获取本月的数据
		BigdataSafetyProductionSituationView bigdataSafetyProductionSituationView = mapper.getSafetyProductionSituationData(query);
		//获取年度考核数据
		BigdataSafetyCheckQuery bigdataSafetyCheckQuery = new BigdataSafetyCheckQuery();
		bigdataSafetyCheckQuery.getQueryObj().setCountTime(query.getQueryObj().getCountTime());
		List<BigdataSafetyCheckView> bigdataSafetyCheckViewList = bigdataSafetyCheckService.listPage(bigdataSafetyCheckQuery);
		if(bigdataSafetyCheckViewList!=null && bigdataSafetyCheckViewList.size()>0){
			bigdataSafetyProductionEchatsVo.setBigdataSafetyCheckView(bigdataSafetyCheckViewList.get(0));
		}
		//获取上月的数据
		Date  lastMonthDate = DateUtil.getLastMonthDate(query.getQueryObj().getCountTime());
		query.getQueryObj().setCountTime(lastMonthDate);
		BigdataSafetyProductionSituationView bigdataSafetyProductionSituationView1 = mapper.getSafetyProductionSituationData(query);
		bigdataSafetyProductionEchatsVo.setBigdataSafetyProductionSituationView(bigdataSafetyProductionSituationView);
		bigdataSafetyProductionEchatsVo.setBigdataSafetyProductionSituationViewLast(bigdataSafetyProductionSituationView1);
		return bigdataSafetyProductionEchatsVo;
	}
}
