package com.edgedo.drawing.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("bigdata_driver_card_rec")
public class BigdataDriverCardRec implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	java.lang.String id;
	
	/**
	 * 属性描述:业务主键
	 */
	@TableField(value="B_ID",exist=true)
	java.lang.String bid;
	
	/**
	 * 属性描述:所属运营商
	 */
	@TableField(value="COMP_ID",exist=true)
	java.lang.String compId;
	
	/**
	 * 属性描述:运营商名
	 */
	@TableField(value="COMP_NAME",exist=true)
	java.lang.String compName;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:车牌号
	 */
	@TableField(value="CAR_PLATE_NUM",exist=true)
	java.lang.String carPlateNum;
	
	/**
	 * 属性描述:车牌颜色
	 */
	@TableField(value="CAR_PLATE_COLOR",exist=true)
	java.lang.String carPlateColor;
	
	/**
	 * 属性描述:驾驶员姓名
	 */
	@TableField(value="DRIVER_NAME",exist=true)
	java.lang.String driverName;
	
	/**
	 * 属性描述:所属企业
	 */
	@TableField(value="COMPANY",exist=true)
	java.lang.String company;
	
	/**
	 * 属性描述:驾驶员资格证号
	 */
	@TableField(value="LICENCE_NUM",exist=true)
	java.lang.String licenceNum;
	
	/**
	 * 属性描述:记录类型(插卡/拔卡)
	 */
	@TableField(value="REC_TYPE",exist=true)
	java.lang.String recType;
	
	/**
	 * 属性描述:插卡/拔卡时间
	 */
	@TableField(value="CARD_TIME",exist=true)
	java.util.Date cardTime;
	
	/**
	 * 属性描述:系统接收时间
	 */
	@TableField(value="SYS_RECEIVE_TIME",exist=true)
	java.util.Date sysReceiveTime;

	/**
	 * 属性描述:统计日期
	 */
	@TableField(value="COUNT_DATE",exist=true)
	Integer countDate;
	/**
	 * 属性描述:统计日期
	 */
	@TableField(value="COUNT_MONTH",exist=true)
	Integer countMonth;

	public Integer getCountDate() {
		return countDate;
	}

	public void setCountDate(Integer countDate) {
		this.countDate = countDate;
	}

	public Integer getCountMonth() {
		return countMonth;
	}

	public void setCountMonth(Integer countMonth) {
		this.countMonth = countMonth;
	}

	public java.lang.String getId(){
		return this.id;
	}
	
	public void setId(java.lang.String id){
		this.id=id;
	}
	
	
	public java.lang.String getBid(){
		return this.bid;
	}
	
	public void setBid(java.lang.String bid){
		this.bid=bid;
	}
	
	
	public java.lang.String getCompId(){
		return this.compId;
	}
	
	public void setCompId(java.lang.String compId){
		this.compId=compId;
	}
	
	
	public java.lang.String getCompName(){
		return this.compName;
	}
	
	public void setCompName(java.lang.String compName){
		this.compName=compName;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public java.lang.String getCarPlateNum(){
		return this.carPlateNum;
	}
	
	public void setCarPlateNum(java.lang.String carPlateNum){
		this.carPlateNum=carPlateNum;
	}
	
	
	public java.lang.String getCarPlateColor(){
		return this.carPlateColor;
	}
	
	public void setCarPlateColor(java.lang.String carPlateColor){
		this.carPlateColor=carPlateColor;
	}
	
	
	public java.lang.String getDriverName(){
		return this.driverName;
	}
	
	public void setDriverName(java.lang.String driverName){
		this.driverName=driverName;
	}
	
	
	public java.lang.String getCompany(){
		return this.company;
	}
	
	public void setCompany(java.lang.String company){
		this.company=company;
	}
	
	
	public java.lang.String getLicenceNum(){
		return this.licenceNum;
	}
	
	public void setLicenceNum(java.lang.String licenceNum){
		this.licenceNum=licenceNum;
	}
	
	
	public java.lang.String getRecType(){
		return this.recType;
	}
	
	public void setRecType(java.lang.String recType){
		this.recType=recType;
	}
	
	
	public java.util.Date getCardTime(){
		return this.cardTime;
	}
	
	public void setCardTime(java.util.Date cardTime){
		this.cardTime=cardTime;
	}
	
	
	public java.util.Date getSysReceiveTime(){
		return this.sysReceiveTime;
	}
	
	public void setSysReceiveTime(java.util.Date sysReceiveTime){
		this.sysReceiveTime=sysReceiveTime;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", bid=").append(bid);			
			sb.append(", compId=").append(compId);			
			sb.append(", compName=").append(compName);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", carPlateNum=").append(carPlateNum);			
			sb.append(", carPlateColor=").append(carPlateColor);			
			sb.append(", driverName=").append(driverName);			
			sb.append(", company=").append(company);			
			sb.append(", licenceNum=").append(licenceNum);			
			sb.append(", recType=").append(recType);			
			sb.append(", cardTime=").append(cardTime);			
			sb.append(", sysReceiveTime=").append(sysReceiveTime);			
        sb.append("]");
        return sb.toString();
    }

   
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BigdataDriverCardRec other = (BigdataDriverCardRec) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getBid() == null ? other.getId() == null : this.getBid().equals(other.getBid()))		
				        		&&(this.getCompId() == null ? other.getId() == null : this.getCompId().equals(other.getCompId()))		
				        		&&(this.getCompName() == null ? other.getId() == null : this.getCompName().equals(other.getCompName()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getCarPlateNum() == null ? other.getId() == null : this.getCarPlateNum().equals(other.getCarPlateNum()))		
				        		&&(this.getCarPlateColor() == null ? other.getId() == null : this.getCarPlateColor().equals(other.getCarPlateColor()))		
				        		&&(this.getDriverName() == null ? other.getId() == null : this.getDriverName().equals(other.getDriverName()))		
				        		&&(this.getCompany() == null ? other.getId() == null : this.getCompany().equals(other.getCompany()))		
				        		&&(this.getLicenceNum() == null ? other.getId() == null : this.getLicenceNum().equals(other.getLicenceNum()))		
				        		&&(this.getRecType() == null ? other.getId() == null : this.getRecType().equals(other.getRecType()))		
				        		&&(this.getCardTime() == null ? other.getId() == null : this.getCardTime().equals(other.getCardTime()))		
				        		&&(this.getSysReceiveTime() == null ? other.getId() == null : this.getSysReceiveTime().equals(other.getSysReceiveTime()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getBid() == null) ? 0 : getBid().hashCode());		
		        result = prime * result + ((getCompId() == null) ? 0 : getCompId().hashCode());		
		        result = prime * result + ((getCompName() == null) ? 0 : getCompName().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getCarPlateNum() == null) ? 0 : getCarPlateNum().hashCode());		
		        result = prime * result + ((getCarPlateColor() == null) ? 0 : getCarPlateColor().hashCode());		
		        result = prime * result + ((getDriverName() == null) ? 0 : getDriverName().hashCode());		
		        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());		
		        result = prime * result + ((getLicenceNum() == null) ? 0 : getLicenceNum().hashCode());		
		        result = prime * result + ((getRecType() == null) ? 0 : getRecType().hashCode());		
		        result = prime * result + ((getCardTime() == null) ? 0 : getCardTime().hashCode());		
		        result = prime * result + ((getSysReceiveTime() == null) ? 0 : getSysReceiveTime().hashCode());		
		;
        return result;
    }

}
