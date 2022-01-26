package com.edgedo.sys.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;

@TableName("sys_wx_pay_record")
public class SysWxPayRecord implements Serializable{
	
		
	/**
	 * 属性描述:主键
	 */
	@TableField(value="ID",exist=true)
	String id;
	
	/**
	 * 属性描述:支付类型
	 */
	@TableField(value="PAY_TYPE",exist=true)
	String payType;
	
	/**
	 * 属性描述:订单主键
	 */
	@TableField(value="BILL_ID",exist=true)
	String billId;
	
	/**
	 * 属性描述:订单类型
	 */
	@TableField(value="BILL_TYPE",exist=true)
	String billType;
	
	/**
	 * 属性描述:TRANSACTION_ID
	 */
	@TableField(value="TRANSACTION_ID",exist=true)
	String transactionId;
	
	/**
	 * 属性描述:支付结果
	 */
	@TableField(value="PAY_RESULT",exist=true)
	String payResult;
	
	/**
	 * 属性描述:支付金额
	 */
	@TableField(value="PAY_MONEY",exist=true)
	java.math.BigDecimal payMoney;
	
	/**
	 * 属性描述:NOTIFY_BODY
	 */
	@TableField(value="NOTIFY_BODY",exist=true)
	String notifyBody;
	
	/**
	 * 属性描述:PREPAY_BODY
	 */
	@TableField(value="PREPAY_BODY",exist=true)
	String prepayBody;
	
	/**
	 * 属性描述:城市服务appid
	 */
	@TableField(value="APP_ID",exist=true)
	String appId;

	
	/**
	 * 属性描述:设备信息
	 */
	@TableField(value="DEVICE_INFO",exist=true)
	String deviceInfo;
	
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
	 * 属性描述:商品描述
	 */
	@TableField(value="BODY",exist=true)
	String body;
	
	/**
	 * 属性描述:商品详情
	 */
	@TableField(value="DETAIL",exist=true)
	String detail;
	
	/**
	 * 属性描述:附加数据
	 */
	@TableField(value="ATTACH",exist=true)
	String attach;
	
	/**
	 * 属性描述:商户订单号
	 */
	@TableField(value="OUT_TRADE_NO",exist=true)
	String outTradeNo;
	
	/**
	 * 属性描述:订单总金额
	 */
	@TableField(value="TOTAL_FEE",exist=true)
	java.math.BigDecimal totalFee;
	
	/**
	 * 属性描述:终端ip
	 */
	@TableField(value="SPBILL_CREATE_IP",exist=true)
	String spbillCreateIp;
	
	/**
	 * 属性描述:COUPON_FEE
	 */
	@TableField(value="COUPON_FEE",exist=true)
	java.math.BigDecimal couponFee;
	
	/**
	 * 属性描述:交易起始时间
	 */
	@TableField(value="TIME_START",exist=true)
	String timeStart;
	
	/**
	 * 属性描述:交易结束时间
	 */
	@TableField(value="TIME_EXPIRE",exist=true)
	String timeExpire;
	
	/**
	 * 属性描述:商品标记
	 */
	@TableField(value="GOODS_TAG",exist=true)
	String goodsTag;
	
	/**
	 * 属性描述:回调地址
	 */
	@TableField(value="NOTIFY_URL",exist=true)
	String notifyUrl;
	
	/**
	 * 属性描述:支付方式
	 */
	@TableField(value="TRADE_TYPE",exist=true)
	String tradeType;
	
	/**
	 * 属性描述:商品id
	 */
	@TableField(value="PRODUCT_ID",exist=true)
	String productId;
	
	/**
	 * 属性描述:微信OPENID
	 */
	@TableField(value="OPENID",exist=true)
	String openid;
	
	/**
	 * 属性描述:PREPAY_ID
	 */
	@TableField(value="PREPAY_ID",exist=true)
	String prepayId;
	
	/**
	 * 属性描述:RETURN_MSG
	 */
	@TableField(value="RETURN_MSG",exist=true)
	String returnMsg;
	
	/**
	 * 属性描述:RESULT_CODE
	 */
	@TableField(value="RESULT_CODE",exist=true)
	String resultCode;
	
	/**
	 * 属性描述:ERR_CODE
	 */
	@TableField(value="ERR_CODE",exist=true)
	String errCode;
	
	/**
	 * 属性描述:ERR_CODE_DES
	 */
	@TableField(value="ERR_CODE_DES",exist=true)
	String errCodeDes;
	
	/**
	 * 属性描述:银行类型
	 */
	@TableField(value="BANK_TYPE",exist=true)
	String bankType;
	
	/**
	 * 属性描述:TIME_END
	 */
	@TableField(value="TIME_END",exist=true)
	String timeEnd;
	
	/**
	 * 属性描述:PREPAY_TIME
	 */
	@TableField(value="PREPAY_TIME",exist=true)
	java.util.Date prepayTime;
	
	/**
	 * 属性描述:PAY_TIME
	 */
	@TableField(value="PAY_TIME",exist=true)
	java.util.Date payTime;
	
	/**
	 * 属性描述:成功返回地址
	 */
	@TableField(value="SUCCESS_URL",exist=true)
	String successUrl;
	/**
	 * 属性描述:成功返回地址
	 */
	@TableField(value="FAIL_URL",exist=true)
	String failUrl;


	public String getId(){
		return this.id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getPayType(){
		return this.payType;
	}
	
	public void setPayType(String payType){
		this.payType=payType;
	}
	
	
	public String getBillId(){
		return this.billId;
	}
	
	public void setBillId(String billId){
		this.billId=billId;
	}
	
	
	public String getBillType(){
		return this.billType;
	}
	
	public void setBillType(String billType){
		this.billType=billType;
	}
	
	
	public String getTransactionId(){
		return this.transactionId;
	}
	
	public void setTransactionId(String transactionId){
		this.transactionId=transactionId;
	}
	
	
	public String getPayResult(){
		return this.payResult;
	}
	
	public void setPayResult(String payResult){
		this.payResult=payResult;
	}
	
	
	public java.math.BigDecimal getPayMoney(){
		return this.payMoney;
	}
	
	public void setPayMoney(java.math.BigDecimal payMoney){
		this.payMoney=payMoney;
	}
	
	
	public String getNotifyBody(){
		return this.notifyBody;
	}
	
	public void setNotifyBody(String notifyBody){
		this.notifyBody=notifyBody;
	}
	
	
	public String getPrepayBody(){
		return this.prepayBody;
	}
	
	public void setPrepayBody(String prepayBody){
		this.prepayBody=prepayBody;
	}
	
	
	public String getAppId(){
		return this.appId;
	}
	
	public void setAppId(String appId){
		this.appId=appId;
	}

	
	public String getDeviceInfo(){
		return this.deviceInfo;
	}
	
	public void setDeviceInfo(String deviceInfo){
		this.deviceInfo=deviceInfo;
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
	
	
	public String getBody(){
		return this.body;
	}
	
	public void setBody(String body){
		this.body=body;
	}
	
	
	public String getDetail(){
		return this.detail;
	}
	
	public void setDetail(String detail){
		this.detail=detail;
	}
	
	
	public String getAttach(){
		return this.attach;
	}
	
	public void setAttach(String attach){
		this.attach=attach;
	}
	
	
	public String getOutTradeNo(){
		return this.outTradeNo;
	}
	
	public void setOutTradeNo(String outTradeNo){
		this.outTradeNo=outTradeNo;
	}
	
	
	public java.math.BigDecimal getTotalFee(){
		return this.totalFee;
	}
	
	public void setTotalFee(java.math.BigDecimal totalFee){
		this.totalFee=totalFee;
	}
	
	
	public String getSpbillCreateIp(){
		return this.spbillCreateIp;
	}
	
	public void setSpbillCreateIp(String spbillCreateIp){
		this.spbillCreateIp=spbillCreateIp;
	}
	
	
	public java.math.BigDecimal getCouponFee(){
		return this.couponFee;
	}
	
	public void setCouponFee(java.math.BigDecimal couponFee){
		this.couponFee=couponFee;
	}
	
	
	public String getTimeStart(){
		return this.timeStart;
	}
	
	public void setTimeStart(String timeStart){
		this.timeStart=timeStart;
	}
	
	
	public String getTimeExpire(){
		return this.timeExpire;
	}
	
	public void setTimeExpire(String timeExpire){
		this.timeExpire=timeExpire;
	}
	
	
	public String getGoodsTag(){
		return this.goodsTag;
	}
	
	public void setGoodsTag(String goodsTag){
		this.goodsTag=goodsTag;
	}
	
	
	public String getNotifyUrl(){
		return this.notifyUrl;
	}
	
	public void setNotifyUrl(String notifyUrl){
		this.notifyUrl=notifyUrl;
	}
	
	
	public String getTradeType(){
		return this.tradeType;
	}
	
	public void setTradeType(String tradeType){
		this.tradeType=tradeType;
	}
	
	
	public String getProductId(){
		return this.productId;
	}
	
	public void setProductId(String productId){
		this.productId=productId;
	}
	
	
	public String getOpenid(){
		return this.openid;
	}
	
	public void setOpenid(String openid){
		this.openid=openid;
	}
	
	
	public String getPrepayId(){
		return this.prepayId;
	}
	
	public void setPrepayId(String prepayId){
		this.prepayId=prepayId;
	}
	
	
	public String getReturnMsg(){
		return this.returnMsg;
	}
	
	public void setReturnMsg(String returnMsg){
		this.returnMsg=returnMsg;
	}
	
	
	public String getResultCode(){
		return this.resultCode;
	}
	
	public void setResultCode(String resultCode){
		this.resultCode=resultCode;
	}
	
	
	public String getErrCode(){
		return this.errCode;
	}
	
	public void setErrCode(String errCode){
		this.errCode=errCode;
	}
	
	
	public String getErrCodeDes(){
		return this.errCodeDes;
	}
	
	public void setErrCodeDes(String errCodeDes){
		this.errCodeDes=errCodeDes;
	}
	
	
	public String getBankType(){
		return this.bankType;
	}
	
	public void setBankType(String bankType){
		this.bankType=bankType;
	}
	
	
	public String getTimeEnd(){
		return this.timeEnd;
	}
	
	public void setTimeEnd(String timeEnd){
		this.timeEnd=timeEnd;
	}
	
	
	public java.util.Date getPrepayTime(){
		return this.prepayTime;
	}
	
	public void setPrepayTime(java.util.Date prepayTime){
		this.prepayTime=prepayTime;
	}
	
	
	public java.util.Date getPayTime(){
		return this.payTime;
	}
	
	public void setPayTime(java.util.Date payTime){
		this.payTime=payTime;
	}
	
	
	public String getSuccessUrl(){
		return this.successUrl;
	}
	
	public void setSuccessUrl(String successUrl){
		this.successUrl=successUrl;
	}

	public String getFailUrl() {
		return failUrl;
	}

	public void setFailUrl(String failUrl) {
		this.failUrl = failUrl;
	}


	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
			sb.append(", id=").append(id);			
			sb.append(", payType=").append(payType);			
			sb.append(", billId=").append(billId);			
			sb.append(", billType=").append(billType);			
			sb.append(", transactionId=").append(transactionId);			
			sb.append(", payResult=").append(payResult);			
			sb.append(", payMoney=").append(payMoney);			
			sb.append(", notifyBody=").append(notifyBody);			
			sb.append(", prepayBody=").append(prepayBody);			
			sb.append(", appId=").append(appId);			
			sb.append(", deviceInfo=").append(deviceInfo);
			sb.append(", nonceStr=").append(nonceStr);			
			sb.append(", sign=").append(sign);			
			sb.append(", body=").append(body);			
			sb.append(", detail=").append(detail);			
			sb.append(", attach=").append(attach);			
			sb.append(", outTradeNo=").append(outTradeNo);			
			sb.append(", totalFee=").append(totalFee);			
			sb.append(", spbillCreateIp=").append(spbillCreateIp);			
			sb.append(", couponFee=").append(couponFee);			
			sb.append(", timeStart=").append(timeStart);			
			sb.append(", timeExpire=").append(timeExpire);			
			sb.append(", goodsTag=").append(goodsTag);			
			sb.append(", notifyUrl=").append(notifyUrl);			
			sb.append(", tradeType=").append(tradeType);			
			sb.append(", productId=").append(productId);			
			sb.append(", openid=").append(openid);			
			sb.append(", prepayId=").append(prepayId);			
			sb.append(", returnMsg=").append(returnMsg);			
			sb.append(", resultCode=").append(resultCode);			
			sb.append(", errCode=").append(errCode);			
			sb.append(", errCodeDes=").append(errCodeDes);			
			sb.append(", bankType=").append(bankType);			
			sb.append(", timeEnd=").append(timeEnd);			
			sb.append(", prepayTime=").append(prepayTime);			
			sb.append(", payTime=").append(payTime);			
			sb.append(", successUrl=").append(successUrl);
			sb.append(", failUrl=").append(failUrl);
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
        SysWxPayRecord other = (SysWxPayRecord) that;
        boolean flag = true;
        return  flag
        		&&(this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))		
				        		&&(this.getPayType() == null ? other.getId() == null : this.getPayType().equals(other.getPayType()))		
				        		&&(this.getBillId() == null ? other.getId() == null : this.getBillId().equals(other.getBillId()))		
				        		&&(this.getBillType() == null ? other.getId() == null : this.getBillType().equals(other.getBillType()))		
				        		&&(this.getTransactionId() == null ? other.getId() == null : this.getTransactionId().equals(other.getTransactionId()))		
				        		&&(this.getPayResult() == null ? other.getId() == null : this.getPayResult().equals(other.getPayResult()))		
				        		&&(this.getPayMoney() == null ? other.getId() == null : this.getPayMoney().equals(other.getPayMoney()))		
				        		&&(this.getNotifyBody() == null ? other.getId() == null : this.getNotifyBody().equals(other.getNotifyBody()))		
				        		&&(this.getPrepayBody() == null ? other.getId() == null : this.getPrepayBody().equals(other.getPrepayBody()))		
				        		&&(this.getAppId() == null ? other.getId() == null : this.getAppId().equals(other.getAppId()))		
				        		&&(this.getDeviceInfo() == null ? other.getId() == null : this.getDeviceInfo().equals(other.getDeviceInfo()))
				        		&&(this.getNonceStr() == null ? other.getId() == null : this.getNonceStr().equals(other.getNonceStr()))		
				        		&&(this.getSign() == null ? other.getId() == null : this.getSign().equals(other.getSign()))		
				        		&&(this.getBody() == null ? other.getId() == null : this.getBody().equals(other.getBody()))		
				        		&&(this.getDetail() == null ? other.getId() == null : this.getDetail().equals(other.getDetail()))		
				        		&&(this.getAttach() == null ? other.getId() == null : this.getAttach().equals(other.getAttach()))		
				        		&&(this.getOutTradeNo() == null ? other.getId() == null : this.getOutTradeNo().equals(other.getOutTradeNo()))		
				        		&&(this.getTotalFee() == null ? other.getId() == null : this.getTotalFee().equals(other.getTotalFee()))		
				        		&&(this.getSpbillCreateIp() == null ? other.getId() == null : this.getSpbillCreateIp().equals(other.getSpbillCreateIp()))		
				        		&&(this.getCouponFee() == null ? other.getId() == null : this.getCouponFee().equals(other.getCouponFee()))		
				        		&&(this.getTimeStart() == null ? other.getId() == null : this.getTimeStart().equals(other.getTimeStart()))		
				        		&&(this.getTimeExpire() == null ? other.getId() == null : this.getTimeExpire().equals(other.getTimeExpire()))		
				        		&&(this.getGoodsTag() == null ? other.getId() == null : this.getGoodsTag().equals(other.getGoodsTag()))		
				        		&&(this.getNotifyUrl() == null ? other.getId() == null : this.getNotifyUrl().equals(other.getNotifyUrl()))		
				        		&&(this.getTradeType() == null ? other.getId() == null : this.getTradeType().equals(other.getTradeType()))		
				        		&&(this.getProductId() == null ? other.getId() == null : this.getProductId().equals(other.getProductId()))		
				        		&&(this.getOpenid() == null ? other.getId() == null : this.getOpenid().equals(other.getOpenid()))		
				        		&&(this.getPrepayId() == null ? other.getId() == null : this.getPrepayId().equals(other.getPrepayId()))		
				        		&&(this.getReturnMsg() == null ? other.getId() == null : this.getReturnMsg().equals(other.getReturnMsg()))		
				        		&&(this.getResultCode() == null ? other.getId() == null : this.getResultCode().equals(other.getResultCode()))		
				        		&&(this.getErrCode() == null ? other.getId() == null : this.getErrCode().equals(other.getErrCode()))		
				        		&&(this.getErrCodeDes() == null ? other.getId() == null : this.getErrCodeDes().equals(other.getErrCodeDes()))		
				        		&&(this.getBankType() == null ? other.getId() == null : this.getBankType().equals(other.getBankType()))		
				        		&&(this.getTimeEnd() == null ? other.getId() == null : this.getTimeEnd().equals(other.getTimeEnd()))		
				        		&&(this.getPrepayTime() == null ? other.getId() == null : this.getPrepayTime().equals(other.getPrepayTime()))		
				        		&&(this.getPayTime() == null ? other.getId() == null : this.getPayTime().equals(other.getPayTime()))		
				        		&&(this.getSuccessUrl() == null ? other.getId() == null : this.getSuccessUrl().equals(other.getSuccessUrl()))
								&&(this.getFailUrl() == null ? other.getId() == null : this.getFailUrl().equals(other.getFailUrl()))
				;
    }

  
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());		
		        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());		
		        result = prime * result + ((getBillId() == null) ? 0 : getBillId().hashCode());		
		        result = prime * result + ((getBillType() == null) ? 0 : getBillType().hashCode());		
		        result = prime * result + ((getTransactionId() == null) ? 0 : getTransactionId().hashCode());		
		        result = prime * result + ((getPayResult() == null) ? 0 : getPayResult().hashCode());		
		        result = prime * result + ((getPayMoney() == null) ? 0 : getPayMoney().hashCode());		
		        result = prime * result + ((getNotifyBody() == null) ? 0 : getNotifyBody().hashCode());		
		        result = prime * result + ((getPrepayBody() == null) ? 0 : getPrepayBody().hashCode());		
		        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());		
		        result = prime * result + ((getDeviceInfo() == null) ? 0 : getDeviceInfo().hashCode());
		        result = prime * result + ((getNonceStr() == null) ? 0 : getNonceStr().hashCode());		
		        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());		
		        result = prime * result + ((getBody() == null) ? 0 : getBody().hashCode());		
		        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());		
		        result = prime * result + ((getAttach() == null) ? 0 : getAttach().hashCode());		
		        result = prime * result + ((getOutTradeNo() == null) ? 0 : getOutTradeNo().hashCode());		
		        result = prime * result + ((getTotalFee() == null) ? 0 : getTotalFee().hashCode());		
		        result = prime * result + ((getSpbillCreateIp() == null) ? 0 : getSpbillCreateIp().hashCode());		
		        result = prime * result + ((getCouponFee() == null) ? 0 : getCouponFee().hashCode());		
		        result = prime * result + ((getTimeStart() == null) ? 0 : getTimeStart().hashCode());		
		        result = prime * result + ((getTimeExpire() == null) ? 0 : getTimeExpire().hashCode());		
		        result = prime * result + ((getGoodsTag() == null) ? 0 : getGoodsTag().hashCode());		
		        result = prime * result + ((getNotifyUrl() == null) ? 0 : getNotifyUrl().hashCode());		
		        result = prime * result + ((getTradeType() == null) ? 0 : getTradeType().hashCode());		
		        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());		
		        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());		
		        result = prime * result + ((getPrepayId() == null) ? 0 : getPrepayId().hashCode());		
		        result = prime * result + ((getReturnMsg() == null) ? 0 : getReturnMsg().hashCode());		
		        result = prime * result + ((getResultCode() == null) ? 0 : getResultCode().hashCode());		
		        result = prime * result + ((getErrCode() == null) ? 0 : getErrCode().hashCode());		
		        result = prime * result + ((getErrCodeDes() == null) ? 0 : getErrCodeDes().hashCode());		
		        result = prime * result + ((getBankType() == null) ? 0 : getBankType().hashCode());		
		        result = prime * result + ((getTimeEnd() == null) ? 0 : getTimeEnd().hashCode());		
		        result = prime * result + ((getPrepayTime() == null) ? 0 : getPrepayTime().hashCode());		
		        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());		
		        result = prime * result + ((getSuccessUrl() == null) ? 0 : getSuccessUrl().hashCode());
				result = prime * result + ((getFailUrl() == null) ? 0 : getFailUrl().hashCode());
        return result;
    }

}
