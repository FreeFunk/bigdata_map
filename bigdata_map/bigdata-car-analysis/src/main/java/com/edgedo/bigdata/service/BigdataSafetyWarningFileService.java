package com.edgedo.bigdata.service;

import com.edgedo.bigdata.entity.BeidouProactiveSecurityAlarm1;
import com.edgedo.bigdata.entity.BeidouSafetyWarning;
import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.entity.BigdataSafetyWarningFile;
import com.edgedo.bigdata.mapper.BigdataSafetyWarningFileMapper;
import com.edgedo.common.util.Guid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
public class BigdataSafetyWarningFileService {
	
	
	@Autowired
	private BigdataSafetyWarningFileMapper mapper;
	@Autowired
	private BigdataSafetyWarningService bigdataSafetyWarningService;
	@Autowired
	private BigdataBeidouCompService beidouCompService;

	
	/***
	 * 新增方法
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insert(BigdataSafetyWarningFile voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}

	/**
	 * 接收报警附件
	 * @param alarmFileList
	 * @param userid
	 * @param userkey
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateAccepAlarmsFiles(
			List<BeidouProactiveSecurityAlarm1.BeidouProactiveSecurityAlarm1File> alarmFileList,
			String userid, String userkey) {
		//查询运营商
		//查询运营商
		BigdataBeidouComp beidouComp = null;
		if(userid!=null && userid.equals("200000")){
			userid= "10001";
			beidouComp = beidouCompService.loadById(userid);
			if(beidouComp==null){
				return;
			}
		}else {
			beidouComp = beidouCompService.loadById(userid);
			if(beidouComp==null){
				return;
			}
			String key = beidouComp.getSingKey();
			if(!key.equals(userkey)){
				return;
			}
		}
		Calendar cal = Calendar.getInstance();
		Date cur = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dayStr = sdf.format(cur);
		int dayInt = new Integer(dayStr);
		int curMonth = dayInt/100;
	/*	cal.add(Calendar.DAY_OF_MONTH,-1);
		Date lastDay = cal.getTime();
		String lastDayStr = sdf.format(lastDay);
		int lastInt = new Integer(lastDayStr);
		int lastMonth = lastInt/100;*/



		//查询报警数据
		for(BeidouProactiveSecurityAlarm1.BeidouProactiveSecurityAlarm1File alarm1File : alarmFileList){
			String alarmId = alarm1File.getAlarmid();
			String alarmPk = userid + "_" + alarmId;
			BigdataSafetyWarningFile safetyWarningFile = new BigdataSafetyWarningFile();
			safetyWarningFile.setCountDate(dayInt);
			safetyWarningFile.setCountMonth(curMonth);
			safetyWarningFile.setCreateTime(new Date());
			String fileName = alarm1File.getFile_name();
			safetyWarningFile.setFileName(fileName);
			int fileType = alarm1File.getFile_type();
			if(fileType==0){
				safetyWarningFile.setFileType("picture");
			}else{
				safetyWarningFile.setFileType("video");
			}
			String filePath = alarm1File.getFile_path();
			String fileUrl = filePath + fileName;
			safetyWarningFile.setFileUrl(fileUrl);
			safetyWarningFile.setIsDownload("0");
			safetyWarningFile.setId(Guid.guid());
			safetyWarningFile.setOwnerSafetyWarningId(alarmPk);
			mapper.insert(safetyWarningFile);
		}

	}


	/**
	 * 接收报警附件
	 * @param safetyWarningFileList
	 * @param compId
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
	public void acceptSaftyWarningFiles(
			List<BeidouSafetyWarning.BeidouSafetyWarningFile> safetyWarningFileList,
			String compId) {
		//查询运营商
		BigdataBeidouComp beidouComp = beidouCompService.loadById(compId);
		if(beidouComp==null){
			return;
		}
		Calendar cal = Calendar.getInstance();
		Date cur = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dayStr = sdf.format(cur);
		int dayInt = new Integer(dayStr);
		int curMonth = dayInt/100;
	/*	cal.add(Calendar.DAY_OF_MONTH,-1);
		Date lastDay = cal.getTime();
		String lastDayStr = sdf.format(lastDay);
		int lastInt = new Integer(lastDayStr);
		int lastMonth = lastInt/100;*/



		//查询报警数据
		for(BeidouSafetyWarning.BeidouSafetyWarningFile beidouSafetyWarningFile : safetyWarningFileList){
			String carPlateNum = beidouSafetyWarningFile.getCarPlateNum();
			if(!carPlateNum.contains("冀C")){
				continue;
			}
			String alarmId = beidouSafetyWarningFile.getbId();
			String alarmPk = compId + "_" + alarmId;
			BigdataSafetyWarningFile safetyWarningFile = new BigdataSafetyWarningFile();
			safetyWarningFile.setCountDate(dayInt);
			safetyWarningFile.setCountMonth(curMonth);
			safetyWarningFile.setCreateTime(new Date());
			String fileName = beidouSafetyWarningFile.getFileName();
			safetyWarningFile.setFileName(fileName);
			String fileType = beidouSafetyWarningFile.getFileType();
			safetyWarningFile.setFileType(fileType);
			String fileUrl = beidouSafetyWarningFile.getFileUrl();
			safetyWarningFile.setFileUrl(fileUrl);
			safetyWarningFile.setIsDownload("0");
			safetyWarningFile.setCarPlateNum(beidouSafetyWarningFile.getCarPlateNum());
			safetyWarningFile.setCarFrameNum(beidouSafetyWarningFile.getCarFrameNum());
			safetyWarningFile.setId(Guid.guid());
			safetyWarningFile.setOwnerSafetyWarningId(alarmPk);
			mapper.insert(safetyWarningFile);
		}

	}

}
