package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFenxiTeamDay;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamDayMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamDayView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFenxiTeamDayService {
	
	
	@Autowired
	private BigdataFenxiTeamDayMapper mapper;

	
	public List<BigdataFenxiTeamDayView> listPage(BigdataFenxiTeamDayQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFenxiTeamDay voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFenxiTeamDay voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFenxiTeamDay voObj) {
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
	public BigdataFenxiTeamDay loadById(String id) {
		return mapper.selectById(id);
	}


    public List<BigdataFenxiTeamDay> selectByDayAnQuanQianShi(String carType, String xianQuId, Integer timeCount, Integer yearNum, Integer countMonth) {
    	return mapper.selectByDayAnQuanQianShi( carType,  xianQuId,  timeCount,  yearNum,  countMonth);
	}

	public List<BigdataFenxiTeamDay> selectByDayAnQuanHouShi(String carType, String xianQuId, Integer timeCount, Integer yearNum, Integer countMonth) {
		return mapper.selectByDayAnQuanHouShi( carType,  xianQuId,  timeCount,  yearNum,  countMonth);
	}

	public List<BigdataFenxiTeamDay> selectByDayBaiGongLiQianShi(String carType, String xianQuId, Integer timeCount, Integer yearNum, Integer countMonth) {
		return mapper.selectByDayBaiGongLiQianShi( carType,  xianQuId,  timeCount,  yearNum,  countMonth);
	}

	public List<BigdataFenxiTeamDay> selectByDayBaiGongLiHouShi(String carType, String xianQuId, Integer timeCount, Integer yearNum, Integer countMonth) {
		return mapper.selectByDayBaiGongLiHouShi( carType,  xianQuId,  timeCount,  yearNum,  countMonth);
	}

	public BigdataFenxiTeamDay selectByIdAndCountDate(BigdataFenxiTeamDayQuery query){
		return mapper.selectByIdAndCountDate(query);
	}
}
