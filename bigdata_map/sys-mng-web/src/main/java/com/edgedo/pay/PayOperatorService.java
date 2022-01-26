package com.edgedo.pay;


import com.edgedo.common.base.BusinessException;
import com.edgedo.sys.entity.SysWxPayRecord;

public interface PayOperatorService {
    /**
     * 支付成功
     * @param payRecord 预支付订单
     * @return
     */
    String updatePaySuccess(SysWxPayRecord payRecord) throws BusinessException;

}
