package com.edgedo.bigdata.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.BigdataAlarmRecord;
import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.entity.BigdataDriverCardRec;
import com.edgedo.bigdata.service.BigdataAlarmRecordService;
import com.edgedo.bigdata.service.BigdataDriverCardRecService;
import com.edgedo.common.base.BaseController;
import com.edgedo.common.base.BusinessException;
import com.edgedo.common.base.annotation.Pass;
import com.edgedo.util.BeidouCompSignUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("/beidouData")
public class BeidouDataInterfaceController extends BaseController{

	@Autowired
	BigdataAlarmRecordService alarmRecordService;
	@Autowired
	BigdataDriverCardRecService driverCardRecService;

	/**
	 * 接收报警信息
	 * @param compId
	 * @param alarms
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/acceptAlarm")
	public ModelAndView acceptAlarm(String compId, String alarms, HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		boolean flag = BeidouCompSignUtil.checkParamsAndSign(req);
		if(!flag){throw new BusinessException("签名失败!");}
		BigdataBeidouComp beidouComp = BeidouCompSignUtil.compMap.get(compId);
		//1.转化成报警信息
		List<BigdataAlarmRecord> alarmList = JSONArray.parseArray(alarms,BigdataAlarmRecord.class);
		for(BigdataAlarmRecord alarmRecord : alarmList){
			alarmRecord.setCompId(beidouComp.getId());
			alarmRecord.setCompName(beidouComp.getCompName());
			String alarmType = alarmRecord.getAlarmType();
			//忽略紧急报警
			if(alarmType.equals("3")){
				continue;
			}
			//2.挨个存到数据库
			alarmRecordService.insertAcceptAlarm(alarmRecord);
		}
		return buildResponse(mav);
	}


	/**
	 * 接收司机身份卡记录
	 * @param compId
	 * @param cardRecs
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/acceptDriverCard")
	public ModelAndView acceptDriverCard(String compId,String cardRecs, HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		boolean flag = BeidouCompSignUtil.checkParamsAndSign(req);
		if(!flag){throw new BusinessException("签名失败!");}
		BigdataBeidouComp beidouComp = BeidouCompSignUtil.compMap.get(compId);
		//1.转化成司机插拔卡记录信息
		//System.out.println("cardRecs===="+cardRecs);
		List<BigdataDriverCardRec> carRecList = JSONArray.parseArray(cardRecs,BigdataDriverCardRec.class);
		for(BigdataDriverCardRec cardRec : carRecList){
			cardRec.setCompId(beidouComp.getId());
			cardRec.setCompName(beidouComp.getCompName());
			//2.挨个存到数据库
			driverCardRecService.insertAcceptDriverCardRec(cardRec);
		}
		return buildResponse(mav);
	}


}
