package com.edgedo.sys.service;

import java.math.BigDecimal;
import java.util.*;

import com.edgedo.common.base.BusinessException;
import com.edgedo.common.util.Guid;
import com.edgedo.common.util.IocUtil;
import com.edgedo.pay.PayOperatorService;
import com.edgedo.sys.entity.SysWxPayRecord;
import com.edgedo.sys.mapper.SysWxPayRecordMapper;
import com.edgedo.sys.queryvo.SysWxPayRecordQuery;
import com.edgedo.sys.queryvo.SysWxPayRecordView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SysWxPayRecordService {
	
	
	@Autowired
	private SysWxPayRecordMapper mapper;

	
	public List<SysWxPayRecordView> listPage(SysWxPayRecordQuery query){
		List list = mapper.listPage(query);
		query.setList(list);
		return list;
	}
	
	/***
	 * 新增方法
	 * @return
	 */
	public String insert(SysWxPayRecord voObj) {
		voObj.setId(Guid.guid());
		mapper.insert(voObj);
		return "";
	}
	
	/***
	 * 动态修改方法
	 * @param
	 * @return
	 */
	public String update(SysWxPayRecord voObj) {
		mapper.updateById(voObj);
		return "";
	}
	
	/***
	 * 全修改
	 * @param
	 * @return
	 */
	public String updateAll(SysWxPayRecord voObj) {
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
	public SysWxPayRecord loadById(String id) {
		return mapper.selectById(id);
	}

	/**
	 * 调用微信接口
	 * @return
	 */
	/*public SortedMap<String,Object> updateWxPrepay(
			SysWxPayRecord record,String openId,
			String remoteIpAddr, String userAgent) throws Exception {
		record.setOpenid(openId);
		record.setSpbillCreateIp(remoteIpAddr);
		SortedMap<String,Object> responseMap =  SjpxbFuwuUtil.miniFuwuPrepay(record,userAgent);
		//调用微信接口的预支付记录
		if("SUCCESS".equals(responseMap.get("result_code")) ){
			//插入预支付成功的记录
			record.setOpenid(openId);
			record.setPrepayId(responseMap.get("prepay_id")+"");
			record.setSpbillCreateIp(remoteIpAddr);
			record.setPrepayTime(new Date());
			record.setPayType("WX");
			mapper.insert(record);
		}
		return responseMap;
	}*/

	/*public SortedMap<String,Object> updateWxPrepay(
			SysWxPayRecord record,String openId,
			String remoteIpAddr, String userAgent) throws Exception {
		SortedMap<String,Object> resultParams = new TreeMap<String,Object>();
		String orginalId = record.getOraId();
		SysWxConfig ptWxConfig = WxPayUtil.getSysWxConfig(orginalId);
		SysWxPayConfig payConfig =WxPayUtil.getSysWxPayConfig(orginalId);
		if(ptWxConfig == null){
			resultParams.put("result_code", "FAIL");
			resultParams.put("err_msg","未找到微信支付配置！");
			return resultParams;
		}
		String appId = ptWxConfig.getAppId();
		String mchid = payConfig.getMchid();
		String payKey = payConfig.getPayKey();
		//主键 用来判断记录ID
		String guid = record.getOutTradeNo();
		SortedMap<String,Object> parameters = new TreeMap<String,Object>();

		parameters.put("appid",appId);
		parameters.put("mch_id",mchid);
		parameters.put("nonce_str", WxCommonUtil.createNonceStr(16));
		parameters.put("body", record.getBody());
		parameters.put("out_trade_no",guid);
		parameters.put("total_fee", ""+record.getTotalFee().longValue());
		parameters.put("spbill_create_ip",record.getSpbillCreateIp());
		parameters.put("notify_url", record.getNotifyUrl());
		parameters.put("trade_type", record.getTradeType());
		parameters.put("openid", openId);
		//附加数据
		parameters.put("attach", guid);
		String sign = WxPayUtil.createSign("UTF-8", parameters,payKey);
		parameters.put("sign", sign);

		String requestXML = WxPayUtil.getRequestXml(parameters);
		System.out.println("requestXML:"+requestXML);
		//预支付操作返回结果
		Map<String,String> responseMap = WxPayUtil.unifiedOrder(requestXML);

		if("SUCCESS".equals(responseMap.get("return_code")) && "SUCCESS".equals(responseMap.get("result_code")) ){
			//预支付调用成功
			String payNonceStr = WxCommonUtil.createNonceStr(16);

			resultParams.put("appId", appId);
			resultParams.put("timeStamp", System.currentTimeMillis());
			resultParams.put("nonceStr", payNonceStr);
			resultParams.put("package", "prepay_id="+responseMap.get("prepay_id"));
			resultParams.put("signType", "MD5");
			String paySign =  WxPayUtil.createSign("UTF-8", resultParams,payKey);
			resultParams.put("packageValue", "prepay_id="+responseMap.get("prepay_id"));//这里用packageValue是预防package是关键字在js获取值出错
			resultParams.put("result_code", "SUCCESS");
			resultParams.put("paySign", paySign);//paySign的生成规则和Sign的生成规则一致
			resultParams.put("sendUrl", payConfig.getSuccessUrl());//付款成功后跳转的页面
			resultParams.put("attach", guid);//附加数据
			char agent = userAgent.charAt(userAgent.indexOf("MicroMessenger")+15);
			resultParams.put("agent", new String(new char[]{agent}));//微信版本号，用于前面提到的判断用户手机微信的版本是否是5.0以上版本。
			resultParams.put("success_url",record.getSuccessUrl());
			resultParams.put("fail_url",record.getFailUrl());
			//插入预支付成功的记录
			record.setAppId(appId);
			record.setMchId(mchid);
			record.setNonceStr(payNonceStr);
			record.setOpenid(openId);
			record.setPrepayId(responseMap.get("prepay_id"));
			record.setSign(paySign);
			record.setSpbillCreateIp(remoteIpAddr);
			record.setPrepayTime(new Date());
			record.setPrepayBody(WxCommonUtil.transMapToString(resultParams));
			record.setPayType("WX");
			mapper.insert(record);
		}else{
			System.out.println("return_msg===================="+responseMap.get("return_msg"));
			resultParams.put("result_code", "FAIL");
			String errMsg = (responseMap.get("return_msg")==null || "OK".equals(responseMap.get("return_msg"))?"": responseMap.get("return_msg"))+ (responseMap.get("err_code_des")==null?"": responseMap.get("err_code_des"));
			resultParams.put("err_msg",errMsg);

		}
		return resultParams;
	}*/

	/**
	 * 修改预支付记录为已处理，需判断预支付记录状态
	 * @param record
	 * @return
	 */
	public int updateSuccess(SysWxPayRecord record) {
		return mapper.updateSuccess(record);
	}

	/**
	 * 收到支付成功回调的通知
	 * @param payRec
	 * @return
	 */
	public String updateWxPayCallBack(SysWxPayRecord payRec) {

		//BILLType是全路径类名
		String billType = payRec.getBillType();
		try {
			System.out.print("===============updateWxPayCallBack:2");
			Object operator = IocUtil.getBean(Class.forName(billType));
			if(operator==null){
				return "未找到处理方式";
			}else{
				SysWxPayRecord record = loadById(payRec.getId());
				//已支付的不能重复更新
				record.setPayResult("SUCCESS");
				record.setPayTime(new Date());
				record.setPayMoney(payRec.getPayMoney());
				record.setTransactionId(payRec.getTransactionId());
				record.setDeviceInfo(payRec.getDeviceInfo());
				record.setBankType(payRec.getBankType());
				record.setTimeEnd(payRec.getTimeEnd());
				record.setOpenid(payRec.getOpenid());
				record.setNotifyBody(payRec.getNotifyBody());
				int count = updateSuccess(record);
				if(count>0){
					PayOperatorService operatorService = (PayOperatorService)operator;
					operatorService.updatePaySuccess(record);
				}
			}
			return null;
		} catch (ClassNotFoundException e) {
			return "未找到处理方式";
		} catch (BusinessException e) {
			return e.getMessage();
		}

	}
}
