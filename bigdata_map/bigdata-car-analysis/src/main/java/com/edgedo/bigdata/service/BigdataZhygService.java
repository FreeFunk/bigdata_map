package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.Emp;
import com.edgedo.bigdata.entity.TransitCarBaseinfo;
import com.edgedo.bigdata.entity.TransitCarTeam;
import com.edgedo.bigdata.mapper.BigdataZhygMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataZhygService {

	@Autowired
	BigdataZhygMapper bigdataZhygMapper;

	//查询车辆信息和从业人员信息
	@Transactional(readOnly = true)
	public TransitCarBaseinfo selectCarWithEmpInfoByCarPlateAndColor(String carPlateNum, String color) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("carPlateNum",carPlateNum);
		param.put("carPlateColor",color);
		TransitCarBaseinfo carInfo = bigdataZhygMapper.selectCarWithEmpInfoByCarPlateAndColor(param);
		if(carInfo != null){
			//这里用carPlateNum代表carId
			Emp emp = bigdataZhygMapper.selectEmpByCarId(carInfo.getId());
			if(emp!=null){
				carInfo.setEmpId(emp.getId());
				carInfo.setEmpName(emp.getEmpName());
				carInfo.setEmpCode(emp.getLicenceCode());
				carInfo.setEmpPhone(emp.getEmpPhone());
			}else {
				carInfo.setEmpId("");
				carInfo.setEmpName("");
				carInfo.setEmpCode("");
				carInfo.setEmpPhone("");
			}
		}
		return carInfo;

	}

	/**
	 * @Author WangZhen
	 * @Description 根据主键查询车队
	 * @Date 2019/11/27 10:13
	 **/
    public TransitCarTeam selectTeamInfoById(String teamId) {
		return bigdataZhygMapper.selectTeamInfoById(teamId);
    }


    //获取所有的车队
	public List<TransitCarTeam> selectTeamList() {
		return bigdataZhygMapper.selectTeamList();
	}

	public int countCarSumByTeamId(String teamId) {
		return bigdataZhygMapper.countCarSumByTeamId(teamId);
	}
}
