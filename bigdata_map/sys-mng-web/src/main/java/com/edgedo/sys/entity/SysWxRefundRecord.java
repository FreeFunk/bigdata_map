package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_wx_refund_record")
public class SysWxRefundRecord implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:创建时间
	 */
	@TableField(value="CREATE_TIME",exist=true)
	java.util.Date createTime;
	
	/**
	 * 属性描述:退款类型
	 */
	@TableField(value="REFUND_TYPE",exist=true)
	String refundType;
	
	/**
	 * 属性描述:公众账号ID
	 */
	@TableField(value="APP_ID",exist=true)
	String appId;
	
	/**
	 * 属性描述:商户号
	 */
	@TableField(value="MCH_ID",exist=true)
	String mchId;
	
	/**
	 * 属性描述:随机字符串
	 */
	@TableField(value="NONCE_STR",exist=true)
	String nonceStr;
	
	/**
	 * 属性描述:签名
	 */
	@TableField(value="SIGN",exist=true)
	String sign;
	
	/**
	 * 属性描述:签名类型
	 */
	@TableField(value="SIGN_TYPE",exist=true)
	String signType;
	
	/**
	 * 属性描述:微信订单号
	 */
	@TableField(value="TRANSACTION_ID",exist=true)
	String transactionId;
	
	/**
	 * 属性描述:商户订单号
	 */
	@TableField(value="OUT_TRADE_NO",exist=true)
	String outTradeNo;
	
	/**
	 * 属性描述:商户退款单号
	 */
	@TableField(value="OUT_REFUND_NO",exist=true)
	String outRefundNo;
	
	/**
	 * 属性描述:订单金额
	 */
	@TableField(value="TOTAL_FEE",exist=true)
	Long totalFee;
	
	/**
	 * 属性描述:退款金额
	 */
	@TableField(value="REFUND_FEE",exist=true)
	Long refundFee;
	
	/**
	 * 属性描述:货币种类
	 */
	@TableField(value="REFUND_FEE_TYPE",exist=true)
	String refundFeeType;
	
	/**
	 * 属性描述:操作员(默认商户id)
	 */
	@TableField(value="OP_USER_ID",exist=true)
	String opUserId;
	
	/**
	 * 属性描述:退款资金来源
	 */
	@TableField(value="REFUND_ACCOUNT",exist=true)
	String refundAccount;
	
	/**
	 * 属性描述:返回状态码
	 */
	@TableField(value="RETURN_CODE",exist=true)
	String returnCode;
	
	/**
	 * 属性描述:返回信息
	 */
	@TableField(value="RETURN_MSG",exist=true)
	String returnMsg;
	
	/**
	 * 属性描述:预支付订单号
	 */
	@TableField(value="PREPAY_ID",exist=true)
	String prepayId;
	
	/**
	 * 属性描述:微信退款单号
	 */
	@TableField(value="REFUND_ID",exist=true)
	String refundId;
	
	/**
	 * 属性描述:退款渠道
	 */
	@TableField(value="REFUND_CHANNEL",exist=true)
	String refundChannel;
	
	/**
	 * 属性描述:应结退款金额
	 */
	@TableField(value="SETTLEMENT_REFUND_FEE",exist=true)
	Long settlementRefundFee;
	
	/**
	 * 属性描述:应结订单金额
	 */
	@TableField(value="SETTLEMENT_TOTAL_FEE",exist=true)
	Long settlementTotalFee;
	
	
	
	
	
	
	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public java.util.Date getCreateTime(){
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date createTime){
		this.createTime=createTime;
	}
	
	
	public String getRefundType(){
		return this.refundType;
	}
	
	public void setRefundType(String refundType){
		this.refundType=refundType;
	}
	
	
	public String getAppId(){
		return this.appId;
	}
	
	public void setAppId(String appId){
		this.appId=appId;
	}
	
	
	public String getMchId(){
		return this.mchId;
	}
	
	public void setMchId(String mchId){
		this.mchId=mchId;
	}
	
	
	public String getNonceStr(){
		return this.nonceStr;
	}
	
	public void setNonceStr(String nonceStr){
		this.nonceStr=nonceStr;
	}
	
	
	public String getSign(){
		return this.sign;
	}
	
	public void setSign(String sign){
		this.sign=sign;
	}
	
	
	public String getSignType(){
		return this.signType;
	}
	
	public void setSignType(String signType){
		this.signType=signType;
	}
	
	
	public String getTransactionId(){
		return this.transactionId;
	}
	
	public void setTransactionId(String transactionId){
		this.transactionId=transactionId;
	}
	
	
	public String getOutTradeNo(){
		return this.outTradeNo;
	}
	
	public void setOutTradeNo(String outTradeNo){
		this.outTradeNo=outTradeNo;
	}
	
	
	public String getOutRefundNo(){
		return this.outRefundNo;
	}
	
	public void setOutRefundNo(String outRefundNo){
		this.outRefundNo=outRefundNo;
	}
	
	
	public Long getTotalFee(){
		return this.totalFee;
	}
	
	public void setTotalFee(Long totalFee){
		this.totalFee=totalFee;
	}
	
	
	public Long getRefundFee(){
		return this.refundFee;
	}
	
	public void setRefundFee(Long refundFee){
		this.refundFee=refundFee;
	}
	
	
	public String getRefundFeeType(){
		return this.refundFeeType;
	}
	
	public void setRefundFeeType(String refundFeeType){
		this.refundFeeType=refundFeeType;
	}
	
	
	public String getOpUserId(){
		return this.opUserId;
	}
	
	public void setOpUserId(String opUserId){
		this.opUserId=opUserId;
	}
	
	
	public String getRefundAccount(){
		return this.refundAccount;
	}
	
	public void setRefundAccount(String refundAccount){
		this.refundAccount=refundAccount;
	}
	
	
	public String getReturnCode(){
		return this.returnCode;
	}
	
	public void setReturnCode(String returnCode){
		this.returnCode=returnCode;
	}
	
	
	public String getReturnMsg(){
		return this.returnMsg;
	}
	
	public void setReturnMsg(String returnMsg){
		this.returnMsg=returnMsg;
	}
	
	
	public String getPrepayId(){
		return this.prepayId;
	}
	
	public void setPrepayId(String prepayId){
		this.prepayId=prepayId;
	}
	
	
	public String getRefundId(){
		return this.refundId;
	}
	
	public void setRefundId(String refundId){
		this.refundId=refundId;
	}
	
	
	public String getRefundChannel(){
		return this.refundChannel;
	}
	
	public void setRefundChannel(String refundChannel){
		this.refundChannel=refundChannel;
	}
	
	
	public Long getSettlementRefundFee(){
		return this.settlementRefundFee;
	}
	
	public void setSettlementRefundFee(Long settlementRefundFee){
		this.settlementRefundFee=settlementRefundFee;
	}
	
	
	public Long getSettlementTotalFee(){
		return this.settlementTotalFee;
	}
	
	public void setSettlementTotalFee(Long settlementTotalFee){
		this.settlementTotalFee=settlementTotalFee;
	}
	
	
	
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", createTime=").append(createTime);			
			sb.append(", refundType=").append(refundType);			
			sb.append(", appId=").append(appId);			
			sb.append(", mchId=").append(mchId);			
			sb.append(", nonceStr=").append(nonceStr);			
			sb.append(", sign=").append(sign);			
			sb.append(", signType=").append(signType);			
			sb.append(", transactionId=").append(transactionId);			
			sb.append(", outTradeNo=").append(outTradeNo);			
			sb.append(", outRefundNo=").append(outRefundNo);			
			sb.append(", totalFee=").append(totalFee);			
			sb.append(", refundFee=").append(refundFee);			
			sb.append(", refundFeeType=").append(refundFeeType);			
			sb.append(", opUserId=").append(opUserId);			
			sb.append(", refundAccount=").append(refundAccount);			
			sb.append(", returnCode=").append(returnCode);			
			sb.append(", returnMsg=").append(returnMsg);			
			sb.append(", prepayId=").append(prepayId);			
			sb.append(", refundId=").append(refundId);			
			sb.append(", refundChannel=").append(refundChannel);			
			sb.append(", settlementRefundFee=").append(settlementRefundFee);			
			sb.append(", settlementTotalFee=").append(settlementTotalFee);			
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
        SysWxRefundRecord other = (SysWxRefundRecord) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getCreateTime() == null ? other.getId() == null : this.getCreateTime().equals(other.getCreateTime()))		
				        		&&(this.getRefundType() == null ? other.getId() == null : this.getRefundType().equals(other.getRefundType()))		
				        		&&(this.getAppId() == null ? other.getId() == null : this.getAppId().equals(other.getAppId()))		
				        		&&(this.getMchId() == null ? other.getId() == null : this.getMchId().equals(other.getMchId()))		
				        		&&(this.getNonceStr() == null ? other.getId() == null : this.getNonceStr().equals(other.getNonceStr()))		
				        		&&(this.getSign() == null ? other.getId() == null : this.getSign().equals(other.getSign()))		
				        		&&(this.getSignType() == null ? other.getId() == null : this.getSignType().equals(other.getSignType()))		
				        		&&(this.getTransactionId() == null ? other.getId() == null : this.getTransactionId().equals(other.getTransactionId()))		
				        		&&(this.getOutTradeNo() == null ? other.getId() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))		
				        		&&(this.getOutRefundNo() == null ? other.getId() == null : this.getOutRefundNo().equals(other.getOutRefundNo()))		
				        		&&(this.getTotalFee() == null ? other.getId() == null : this.getTotalFee().equals(other.getTotalFee()))		
				        		&&(this.getRefundFee() == null ? other.getId() == null : this.getRefundFee().equals(other.getRefundFee()))		
				        		&&(this.getRefundFeeType() == null ? other.getId() == null : this.getRefundFeeType().equals(other.getRefundFeeType()))		
				        		&&(this.getOpUserId() == null ? other.getId() == null : this.getOpUserId().equals(other.getOpUserId()))		
				        		&&(this.getRefundAccount() == null ? other.getId() == null : this.getRefundAccount().equals(other.getRefundAccount()))		
				        		&&(this.getReturnCode() == null ? other.getId() == null : this.getReturnCode().equals(other.getReturnCode()))		
				        		&&(this.getReturnMsg() == null ? other.getId() == null : this.getReturnMsg().equals(other.getReturnMsg()))		
				        		&&(this.getPrepayId() == null ? other.getId() == null : this.getPrepayId().equals(other.getPrepayId()))		
				        		&&(this.getRefundId() == null ? other.getId() == null : this.getRefundId().equals(other.getRefundId()))		
				        		&&(this.getRefundChannel() == null ? other.getId() == null : this.getRefundChannel().equals(other.getRefundChannel()))		
				        		&&(this.getSettlementRefundFee() == null ? other.getId() == null : this.getSettlementRefundFee().equals(other.getSettlementRefundFee()))		
				        		&&(this.getSettlementTotalFee() == null ? other.getId() == null : this.getSettlementTotalFee().equals(other.getSettlementTotalFee()))		
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());		
		        result = prime * result + ((getRefundType() == null) ? 0 : getRefundType().hashCode());		
		        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());		
		        result = prime * result + ((getMchId() == null) ? 0 : getMchId().hashCode());		
		        result = prime * result + ((getNonceStr() == null) ? 0 : getNonceStr().hashCode());		
		        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());		
		        result = prime * result + ((getSignType() == null) ? 0 : getSignType().hashCode());		
		        result = prime * result + ((getTransactionId() == null) ? 0 : getTransactionId().hashCode());		
		        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());		
		        result = prime * result + ((getOutRefundNo() == null) ? 0 : getOutRefundNo().hashCode());		
		        result = prime * result + ((getTotalFee() == null) ? 0 : getTotalFee().hashCode());		
		        result = prime * result + ((getRefundFee() == null) ? 0 : getRefundFee().hashCode());		
		        result = prime * result + ((getRefundFeeType() == null) ? 0 : getRefundFeeType().hashCode());		
		        result = prime * result + ((getOpUserId() == null) ? 0 : getOpUserId().hashCode());		
		        result = prime * result + ((getRefundAccount() == null) ? 0 : getRefundAccount().hashCode());		
		        result = prime * result + ((getReturnCode() == null) ? 0 : getReturnCode().hashCode());		
		        result = prime * result + ((getReturnMsg() == null) ? 0 : getReturnMsg().hashCode());		
		        result = prime * result + ((getPrepayId() == null) ? 0 : getPrepayId().hashCode());		
		        result = prime * result + ((getRefundId() == null) ? 0 : getRefundId().hashCode());		
		        result = prime * result + ((getRefundChannel() == null) ? 0 : getRefundChannel().hashCode());		
		        result = prime * result + ((getSettlementRefundFee() == null) ? 0 : getSettlementRefundFee().hashCode());		
		        result = prime * result + ((getSettlementTotalFee() == null) ? 0 : getSettlementTotalFee().hashCode());		
		;
        return result;
    }

}
