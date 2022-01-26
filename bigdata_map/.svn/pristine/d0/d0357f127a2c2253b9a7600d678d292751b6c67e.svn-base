package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.OftenrunRouteMonthCount;
import com.edgedo.bigdata.mapper.OftenrunRouteMonthCountMapper;
import com.edgedo.bigdata.queryvo.OftenrunRouteMonthCountQuery;
import com.edgedo.bigdata.queryvo.OftenrunRouteMonthCountView;
import com.edgedo.util.DateUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OftenrunRouteMonthCountService {
	
	
	@Autowired
	private OftenrunRouteMonthCountMapper mapper;

	
	public List<OftenrunRouteMonthCountView> listPage(OftenrunRouteMonthCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(OftenrunRouteMonthCount voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(OftenrunRouteMonthCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(OftenrunRouteMonthCount voObj) {
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
	public OftenrunRouteMonthCount loadById(String id) {
		return mapper.selectById(id);
	}


	public List<OftenrunRouteMonthCountView> getOftenRunRoute(OftenrunRouteMonthCountQuery query) {
		String countType = query.getQueryObj().getCountType();
		if(countType!=null && countType.equals("QUARTER")){
			Integer quarter = DateUtil.getQuarter1(query.getQueryObj().getCountTime());
			query.getQueryObj().setQuarterType(quarter);
		}
		return mapper.getOftenRunRoute(query);
	}
}
