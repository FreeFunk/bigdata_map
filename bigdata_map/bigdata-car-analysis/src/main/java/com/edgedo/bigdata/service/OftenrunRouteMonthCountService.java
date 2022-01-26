package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.CarMonthOftenrunRoute;
import com.edgedo.bigdata.entity.OftenrunRouteMonthCount;
import com.edgedo.bigdata.mapper.OftenrunRouteMonthCountMapper;
import com.edgedo.bigdata.queryvo.OftenrunRouteMonthCountQuery;
import com.edgedo.bigdata.queryvo.OftenrunRouteMonthCountView;
import com.edgedo.common.util.Guid;
import com.edgedo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(OftenrunRouteMonthCount voObj) {
		String id = voObj.getId();
		if(id==null  || id.length()==0){
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
	public String update(OftenrunRouteMonthCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(OftenrunRouteMonthCount voObj) {
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
	public OftenrunRouteMonthCount loadById(String id) {
		return mapper.selectById(id);
	}


	public List<OftenrunRouteMonthCountView> getOftenRunRoute(OftenrunRouteMonthCountQuery query) {
		String countType = query.getQueryObj().getCountType();
		if(countType!=null && countType.equals("QUARTER")){
			//TODO:-----------------------------------类型改变
			Integer quarter = DateUtil.getQuarter1(query.getQueryObj().getCountTime());
			query.getQueryObj().setQuarterType(quarter);
		}
		return mapper.getOftenRunRoute(query);
	}

	/**
	 * 根据不同类型汇总季度统计
	 * @param jidu
	 * @param carType
	 * @return
	 */
	public List<OftenrunRouteMonthCount> selectGroupSumOfQuarter(int jidu, String carType) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("quarterType" , jidu);
		param.put("carType" , carType);
		return mapper.selectGroupSumOfQuarter(param);
	}

	/**
	 * 分表做出的高效的查询
	 * @param id
	 * @param yearNum
	 * @return
	 */
    public OftenrunRouteMonthCount loadByIdByDate(String id, int yearNum) {
    	Map<String,Object> param = new HashMap<String,Object>();
		param.put("id",id);
		param.put("yearNum",yearNum);
		return mapper.loadByIdByDate(param);
    }

}
