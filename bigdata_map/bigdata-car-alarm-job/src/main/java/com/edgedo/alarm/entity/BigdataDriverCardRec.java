package com.edgedo.alarm.entity;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BigdataDriverCardRec implements Serializable{


	/**
	 * 属性描述:业务主键
	 */
	String bid;
	/**
	 * 属性描述:车牌号
	 */
	String carPlateNum;

	/**
	 * 属性描述:车牌颜色
	 */
	String carPlateColor;

	/**
	 * 属性描述:驾驶员姓名
	 */
	String driverName;

	/**
	 * 属性描述:所属企业
	 */
	String company;

	/**
	 * 属性描述:驾驶员资格证号
	 */
	String licenceNum;

	/**
	 * 属性描述:记录类型(插卡/拔卡)
	 */
	String recType;

	/**
	 * 属性描述:插卡/拔卡时间
	 */
	java.util.Date cardTime;

	/**
	 * 属性描述:系统接收时间
	 */
	java.util.Date sysReceiveTime;


	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getCarPlateNum() {
		return carPlateNum;
	}

	public void setCarPlateNum(String carPlateNum) {
		this.carPlateNum = carPlateNum;
	}

	public String getCarPlateColor() {
		return carPlateColor;
	}

	public void setCarPlateColor(String carPlateColor) {
		this.carPlateColor = carPlateColor;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLicenceNum() {
		return licenceNum;
	}

	public void setLicenceNum(String licenceNum) {
		this.licenceNum = licenceNum;
	}

	public String getRecType() {
		return recType;
	}

	public void setRecType(String recType) {
		this.recType = recType;
	}

	public Date getCardTime() {
		return cardTime;
	}

	public void setCardTime(Date cardTime) {
		this.cardTime = cardTime;
	}

	public Date getSysReceiveTime() {
		return sysReceiveTime;
	}

	public void setSysReceiveTime(Date sysReceiveTime) {
		this.sysReceiveTime = sysReceiveTime;
	}




}
