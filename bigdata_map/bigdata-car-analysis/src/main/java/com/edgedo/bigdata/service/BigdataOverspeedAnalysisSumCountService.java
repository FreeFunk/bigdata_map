package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataOverspeedAnalysisSumCount;
import com.edgedo.bigdata.mapper.BigdataOverspeedAnalysisSumCountMapper;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisSumCountQuery;
import com.edgedo.bigdata.queryvo.BigdataOverspeedAnalysisSumCountView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataOverspeedAnalysisSumCountService {
	
	
	@Autowired
	private BigdataOverspeedAnalysisSumCountMapper mapper;

	
	public List<BigdataOverspeedAnalysisSumCountView> listPage(BigdataOverspeedAnalysisSumCountQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataOverspeedAnalysisSumCount voObj) {
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
	public String update(BigdataOverspeedAnalysisSumCount voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataOverspeedAnalysisSumCount voObj) {
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
	public BigdataOverspeedAnalysisSumCount loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 新增或者修改
	 * @param sumcount
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public void addOrUpdate(BigdataOverspeedAnalysisSumCount sumcount) {
		String id = sumcount.getId();
		BigdataOverspeedAnalysisSumCount orSumCount = loadById(id);
		if(orSumCount==null){
			insert(sumcount);
		}else{
			sumcount.setCreateTime(null);
			sumcount.setCountTime(null);
			update(sumcount);
		}

    }

	/**
	 * 超速分析的年度统计
	 * @param countYear
	 * @return
	 */
	public List<BigdataOverspeedAnalysisSumCount> selectSumGroupByCarTypeYear(int countYear) {

		return mapper.selectSumGroupByCarTypeYear(countYear);
    }

}
