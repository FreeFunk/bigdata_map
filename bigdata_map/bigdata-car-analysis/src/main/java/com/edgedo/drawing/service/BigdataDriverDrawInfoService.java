package com.edgedo.drawing.service;

import com.edgedo.common.util.Guid;
import com.edgedo.drawing.entity.BigdataDriverDrawInfo;
import com.edgedo.drawing.mapper.BigdataDriverDrawInfoMapper;
import com.edgedo.drawing.queryvo.BigdataDriverDrawInfoQuery;
import com.edgedo.drawing.queryvo.BigdataDriverDrawInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BigdataDriverDrawInfoService {
	
	
	@Autowired
	private BigdataDriverDrawInfoMapper mapper;

	
	public List<BigdataDriverDrawInfoView> listPage(BigdataDriverDrawInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataDriverDrawInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataDriverDrawInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataDriverDrawInfo voObj) {
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
	public BigdataDriverDrawInfo loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataDriverDrawInfoView selectByDriverId(String driverId) {
		Date currDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		Integer year = new Integer(simpleDateFormat.format(currDate));
		Map<String,Object> map = new HashMap<>();
		map.put("driverId",driverId);
		map.put("year",year);
		return mapper.selectByDriverId(map);
	}

	public void insertOrUpdate(BigdataDriverDrawInfo bigdataDriverDrawInfo) {
		BigdataDriverDrawInfo bigdataDriverDrawInfo1 = mapper.selectByVo(bigdataDriverDrawInfo);
		if(bigdataDriverDrawInfo1==null){
			bigdataDriverDrawInfo.setCreateTime(new Date());
			mapper.insert(bigdataDriverDrawInfo);
		}else {
			bigdataDriverDrawInfo.setId(bigdataDriverDrawInfo1.getId());
			bigdataDriverDrawInfo.setCreateTime(new Date());
			mapper.updateById(bigdataDriverDrawInfo);
		}
	}

	public String countSafeFile(String driverId, int yearNum) {
		//统计安全文件回复的次数
		Map<String,Object> map = new HashMap<>();
		map.put("driverId",driverId);
		map.put("yearNum",yearNum);
		int countSafeFile = mapper.countSafeFile(map);
		return "发文回复"+countSafeFile+"次。";
	}
}
