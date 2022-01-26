package com.edgedo;


import com.edgedo.common.util.HttpRequestUtil;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ApplicationTests {

    public static void main(String[] args) throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("carPlate","冀C08525");
        param.put("searchDay","20190628");
        int i=0;
        String url = "http://49.4.67.20:8110/cartrail/loadCarTrail.jsn";
        HttpRequestUtil.HttpResuestResponseStreamWrap res = HttpRequestUtil.postRequestByte(url,param);
        InputStream is = res.getInputStream();
        res.close();
//        String url = "http://localhost:8110/cartrail/loadCarTrail.jsn";

    }

}
