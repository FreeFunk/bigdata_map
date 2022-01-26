package com.edgedo.util;

import com.edgedo.common.util.IocUtil;
import com.edgedo.common.util.MD5Util;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class BeidouCompSignUtil {



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
