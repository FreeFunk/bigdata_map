package com.edgedo.util;

import com.edgedo.bigdata.entity.BigdataAlarmRecord;
import com.edgedo.bigdata.entity.BigdataBeidouComp;
import com.edgedo.bigdata.queryvo.BigdataBeidouCompView;
import com.edgedo.bigdata.service.BigdataBeidouCompService;
import com.edgedo.common.base.BusinessException;
import com.edgedo.common.util.IocUtil;
import com.edgedo.common.util.MD5Util;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class BeidouCompSignUtil {

    public static Map<String,BigdataBeidouCompView> compMap = null;
    //校验sign
    public static boolean checkParamsAndSign(HttpServletRequest request) {

        //签名
        Enumeration<String> en = request.getParameterNames();
        SortedMap<String, Object> param = new TreeMap<String, Object>();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            param.put(key, request.getParameter(key));
        }
        String compId = (String) param.get("compId");
        if(compId==null || compId.length()==0){
            return false;
        }
        if(compMap == null){
            initCompMap();
        }
        String sign = (String) param.get("sign");
        param.remove("sign");
        BigdataBeidouCompView comp = compMap.get(compId);
        if(comp==null){
            return false;
        }
        String ipAddress = request.getRemoteAddr();
        String compIp = comp.getIpAddress();
        if(!compIp.equals("*") && !compIp.contains(ipAddress)){
            throw new BusinessException("ip address not allowed!");
        }
        String token = comp.getSingKey();
        String signNew = createSign("UTF-8", param, token);
        if(signNew.equals(sign)){
            return true;
        }
        return false;
    }

    /**
     * 初始化运营商Map
     */
    private static void initCompMap() {
        compMap = new HashMap<String,BigdataBeidouCompView>();
        BigdataBeidouCompService beidouCompService = IocUtil.getBean(BigdataBeidouCompService.class);
        List<BigdataBeidouCompView> compList = beidouCompService.listAll();
        for(BigdataBeidouCompView comp: compList){
            String compState = comp.getCompState();
            if(compState.equals("1")){
                compMap.put(comp.getId(),comp);
            }
        }
    }


    /**
	    * @param characterEncoding 编码格式
	    * @param parameters 请求参数
	    * @param payKey 支付秘钥
	    * @return
    */
    public static String createSign(String characterEncoding,
                                    SortedMap<String,Object> parameters,String payKey){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + payKey);
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }
}
