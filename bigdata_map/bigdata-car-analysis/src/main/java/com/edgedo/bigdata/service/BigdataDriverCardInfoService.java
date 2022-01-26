package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BigdataDriverCardInfo;
import com.edgedo.bigdata.entity.Emp;
import com.edgedo.bigdata.entity.TransitCarBaseinfo;
import com.edgedo.bigdata.mapper.BigdataDriverCardInfoMapper;
import com.edgedo.bigdata.queryvo.BigdataDriverCardInfoQuery;
import com.edgedo.bigdata.queryvo.BigdataDriverCardInfoView;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataDriverCardInfoService {
	
	
	@Autowired
	private BigdataDriverCardInfoMapper mapper;

	
	public List<BigdataDriverCardInfoView> listPage(BigdataDriverCardInfoQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataDriverCardInfo voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}

	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insertNew(BigdataDriverCardInfo voObj) {
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String update(BigdataDriverCardInfo voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String updateAll(BigdataDriverCardInfo voObj) {
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
	public BigdataDriverCardInfo loadById(String id) {
		return mapper.selectById(id);
	}


	public BigdataDriverCardInfo selectByLicenceNum(String licenceNum) {
		return mapper.selectByLicenceNum(licenceNum);
	}

	public int countDriverCarRec(Map<String, Object> map) {
		return mapper.countDriverCarRec(map);
	}

	public Emp selectByLicenceCode(String licenceNum) {
		return mapper.selectByLicenceCode(licenceNum);
	}

	public TransitCarBaseinfo selectByCarNumAndCarColor(String carPlateNum, String carPlateColor) {
		return mapper.selectByCarNumAndCarColor( carPlateNum,  carPlateColor);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertEmp(Emp newEmp) {
		mapper.insertEmp(newEmp);
	}
	/**
	 * @Author WangZhen
	 * @Description  根据司机卡 从业资格证号查询司机卡信息
	 * @Date 2020/2/3 17:35
	 **/
	public BigdataDriverCardInfo selectDriverInfo(String licenceNum) {
		return mapper.selectDriverInfo( licenceNum);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateById(BigdataDriverCardInfo bigdataDriverCardInfo) {
		mapper.updateByBigdataDriverCardInfoId( bigdataDriverCardInfo);
	}

	public TransitCarBaseinfo selectByCarNum(String carPlateNum) {
		return mapper.selectByCarNum(carPlateNum);
	}


	public List<BigdataDriverCardInfo> selectByCarPlateNumAndColor(Map<String, String> map) {
		return mapper.selectByCarPlateNumAndColor(map);
	}

	public int countDriverTotalNum() {
		return mapper.countDriverTotalNum();
	}

	public List<BigdataDriverCardInfo> listOrderById(int start, int end) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("start",start);
		param.put("end",end);
		return mapper.listOrderById(param);
	}

	public List<BigdataDriverCardInfo> listByStartAndEndBySortNum(int start, int end) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("start",start);
		param.put("end",end);
		return mapper.listByStartAndEndBySortNum(param);
	}

	public int selectSortNum() {
		return mapper.selectSortNum();
	}
}
