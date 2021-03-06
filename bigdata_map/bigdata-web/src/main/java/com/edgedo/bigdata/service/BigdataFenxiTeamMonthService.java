package com.edgedo.bigdata.service;
		
import java.util.List;

import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataFenxiTeamMonth;
import com.edgedo.bigdata.mapper.BigdataFenxiTeamMonthMapper;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamMonthQuery;
import com.edgedo.bigdata.queryvo.BigdataFenxiTeamMonthView;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataFenxiTeamMonthService {
	
	
	@Autowired
	private BigdataFenxiTeamMonthMapper mapper;

	
	public List<BigdataFenxiTeamMonthView> listPage(BigdataFenxiTeamMonthQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataFenxiTeamMonth voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataFenxiTeamMonth voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataFenxiTeamMonth voObj) {
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
	public BigdataFenxiTeamMonth loadById(String id) {
		return mapper.selectById(id);
	}


	public List<BigdataFenxiTeamMonth> selectByMonthAnQuanQianShi(String carType, String xianQuId, Integer timeCount) {
		return mapper.selectByMonthAnQuanQianShi( carType,  xianQuId,  timeCount);
	}

	public List<BigdataFenxiTeamMonth> selectByMonthAnQuanHouShi(String carType, String xianQuId, Integer timeCount) {
		return mapper.selectByMonthAnQuanHouShi( carType,  xianQuId,  timeCount);
	}

	public List<BigdataFenxiTeamMonth> selectByMonthBaiGongLiQianShi(String carType, String xianQuId, Integer timeCount) {
		return mapper.selectByMonthBaiGongLiQianShi( carType,  xianQuId,  timeCount);
	}

	public List<BigdataFenxiTeamMonth> selectByMonthBaiGongLiHouShi(String carType, String xianQuId, Integer timeCount) {
		return mapper.selectByMonthBaiGongLiHouShi( carType,  xianQuId,  timeCount);
	}

	public BigdataFenxiTeamMonth selectById(BigdataFenxiTeamMonthQuery query){
		return mapper.selectById(query);
	}

	public BigdataFenxiTeamMonth selectByTeamId(BigdataFenxiTeamMonthQuery query){
		return mapper.selectByTeamId(query);
	}
}
