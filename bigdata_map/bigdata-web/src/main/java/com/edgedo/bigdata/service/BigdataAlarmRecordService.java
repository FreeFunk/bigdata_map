package com.edgedo.bigdata.service;
		
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edgedo.bigdata.queryvo.BigdataSafetyWarningView;
import com.edgedo.common.util.Guid;
import com.edgedo.bigdata.entity.BigdataAlarmRecord;
import com.edgedo.bigdata.mapper.BigdataAlarmRecordMapper;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordQuery;
import com.edgedo.bigdata.queryvo.BigdataAlarmRecordView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigdataAlarmRecordService {
	
	
	@Autowired
	private BigdataAlarmRecordMapper mapper;

	@Autowired
	private BigdataSafetyWarningService bigdataSafetyWarningService;

	
	public List<BigdataAlarmRecordView> listPage(BigdataAlarmRecordQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(BigdataAlarmRecord voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(BigdataAlarmRecord voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(BigdataAlarmRecord voObj) {
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
	public BigdataAlarmRecord loadById(String id) {
		return mapper.selectById(id);
	}


	public int alsrmCount(BigdataAlarmRecordQuery query) {
		return mapper.alsrmCount(query);
	}

	public List<BigdataAlarmRecordView> selectByCarOrEmp(BigdataAlarmRecordQuery query){
		List list = mapper.selectByQueryInfo(query);
		query.setList(list);
		return list;
	}

	public List<BigdataAlarmRecordView> selectCarList(BigdataAlarmRecordQuery query) {
		List list = new ArrayList();
		String seriousFlag = query.getQueryObj().getSeriousFlag();
		if(seriousFlag!=null && seriousFlag.equals("1")){
			list = mapper.selectseriousCarList(query);
			query.setList(list);
			int countCarList  =mapper.countseriousCarList(query);
			query.setTotalCount(countCarList);
		}else {
			list = mapper.selectCarList(query);
			query.setList(list);
			int countCarList  =mapper.countCarList(query);
			query.setTotalCount(countCarList);
		}
		return list;
	}

	public List selectAlarmRecordByCar(BigdataAlarmRecordQuery query) {
		List<BigdataAlarmRecordView> list = mapper.selectAlarmRecordByCar(query);
		List list1 = new ArrayList();
		//去除超速道路类型为空的值
		for(BigdataAlarmRecordView b:list){
			if(b.getAlarmType().equals("2")){
				if(b.getRoadLevel()!=null && !b.getRoadLevel().equals("")){
					list1.add(b);
				}
			}else {
				list1.add(b);
			}
		}
		//查询主动安全报警加上
		List<BigdataAlarmRecordView> list2 = new ArrayList<>();
		List<BigdataSafetyWarningView> bigdataSafetyWarningViewList = bigdataSafetyWarningService.selectSafetyWarningByCar(query);
		for (BigdataSafetyWarningView safety:bigdataSafetyWarningViewList){
			BigdataAlarmRecordView bigdataAlarmRecordView = new BigdataAlarmRecordView();
			bigdataAlarmRecordView.setCountDate(safety.getCountDate());
			bigdataAlarmRecordView.setCountMonth(safety.getCountMonth());
			bigdataAlarmRecordView.setCreateTime(safety.getStarttime());
			bigdataAlarmRecordView.setCarPlateNum(safety.getCarPlateNum());
			bigdataAlarmRecordView.setCarPlateColor(safety.getCarPlateColor());
			bigdataAlarmRecordView.setEmpName(safety.getEmpName());
			bigdataAlarmRecordView.setAlarmType(safety.getWarningType());
			bigdataAlarmRecordView.setRoadLevel("");
			bigdataAlarmRecordView.setAlarmSpeed(safety.getSpeed());
			list2.add(bigdataAlarmRecordView);
		}
		list1.addAll(list2);
		query.setList(list1);
		return list;
	}

	public List<BigdataAlarmRecordView> getOverSpeedPoint(BigdataAlarmRecordQuery query) {
		String id = query.getQueryObj().getId();
		if(id==null || id.equals("")){
			SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
			Date startTime = query.getStartTime();
			if(startTime!=null){
				String dateIntStr = sdfDateInt.format(query.getStartTime());
				Integer dateInt = new Integer(dateIntStr);
				query.getQueryObj().setCountDate(dateInt);
				query.getQueryObj().setCountMonth(dateInt/100);
			}
		}
		List<BigdataAlarmRecordView> list = mapper.getOverSpeedPoint(query);
		query.setList(list);
		return list;
	}

	public List<BigdataAlarmRecordView> getPilaoPoint(BigdataAlarmRecordQuery query) {
		String id = query.getQueryObj().getId();
		if(id==null || id.equals("")){
			SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
			Date startTime = query.getStartTime();
			if(startTime!=null){
				String dateIntStr = sdfDateInt.format(query.getStartTime());
				Integer dateInt = new Integer(dateIntStr);
				query.getQueryObj().setCountDate(dateInt);
				query.getQueryObj().setCountMonth(dateInt/100);
			}
		}
		//疲劳点
		List<BigdataAlarmRecordView> list = mapper.getPilaoPoint(query);
		query.setList(list);
		return list;
	}

	public List<BigdataAlarmRecordView> getSeriousPilaoPoint(BigdataAlarmRecordQuery query) {
		String id = query.getQueryObj().getId();
		if(id==null || id.equals("")){
			SimpleDateFormat sdfDateInt = new SimpleDateFormat("yyyyMMdd");
			Date startTime = query.getStartTime();
			if(startTime!=null){
				String dateIntStr = sdfDateInt.format(query.getStartTime());
				Integer dateInt = new Integer(dateIntStr);
				query.getQueryObj().setCountDate(dateInt);
				query.getQueryObj().setCountMonth(dateInt/100);
			}
		}
		//严重疲劳点
		List<BigdataAlarmRecordView> list = mapper.getSeriousPilaoPoint(query);
		query.setList(list);
		return list;
	}
}
