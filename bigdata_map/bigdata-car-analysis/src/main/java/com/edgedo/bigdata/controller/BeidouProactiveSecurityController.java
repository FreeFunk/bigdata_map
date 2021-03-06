package com.edgedo.bigdata.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edgedo.bigdata.entity.*;
import com.edgedo.bigdata.service.BigdataBeidouCompService;
import com.edgedo.bigdata.service.BigdataBeidouSafetyCarInfoService;
import com.edgedo.bigdata.service.BigdataSafetyWarningFileService;
import com.edgedo.bigdata.service.BigdataSafetyWarningService;
import com.edgedo.common.base.BaseController;
import com.edgedo.util.BeidouCompSignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主动安全报警接收
 */
@Controller
public class BeidouProactiveSecurityController extends BaseController {

    @Autowired
    BigdataSafetyWarningService safetyWarningService;
    @Autowired
    BigdataSafetyWarningFileService safetyWarningFileService;
    @Autowired
    BigdataBeidouCompService bigdataBeidouCompService;
    @Autowired
    BigdataBeidouSafetyCarInfoService bigdataBeidouSafetyCarInfoService;

    /**
     *  接收报警
     * @param request
     * @param response
     */
    @RequestMapping(value = "/clalarm")
    public void clalarm( HttpServletRequest request,
            HttpServletResponse response){
        try {
            InputStream is = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line=reader.readLine())!=null){
                sb.append(line);
            }
            String reqBody = sb.toString();
            reqBody = reqBody.replaceAll("\\\\�", "");
            System.out.println("reqBody==="+reqBody);
            JSONObject jsonObj = JSONObject.parseObject(reqBody);
            String userid = jsonObj.get("userid")+ "";
            String userkey = jsonObj.get("userkey") + "";
            String datacount = jsonObj.get("datacount") + "";
            String datalist = jsonObj.get("datalist") + "";
            List<BeidouProactiveSecurityAlarm1> alarmList = JSONArray.parseArray(datalist,BeidouProactiveSecurityAlarm1.class);
            safetyWarningService.updateAccepAlarms(alarmList,userid,userkey);
            Map<String,Object> res =  new HashMap<String,Object>();
            res.put("status","200");
            res.put("message","success");
            try {
                response.getWriter().write(JSONObject.toJSONString(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //最后失败会走这里
        Map<String,Object> res =  new HashMap<String,Object>();
        res.put("status","500");
        res.put("message","fail");
        try {
            response.getWriter().write(JSONObject.toJSONString(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 接收报警附件
     * @param request
     * @param response
     */
    @RequestMapping(value = "/alarmfiles")
    public void alarmfiles(
            HttpServletRequest request,
            HttpServletResponse response){
        try {
            InputStream is = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line=reader.readLine())!=null){
                sb.append(line);
            }
            String reqBody = sb.toString();
            JSONObject jsonObj = JSONObject.parseObject(reqBody);
            String userid = jsonObj.get("userid")+ "";
            String userkey = jsonObj.get("userkey") + "";
            String datacount = jsonObj.get("datacount") + "";
            String datalist = jsonObj.get("datalist") + "";
            List<BeidouProactiveSecurityAlarm1.BeidouProactiveSecurityAlarm1File> alarmFileList = JSONArray.parseArray(datalist,BeidouProactiveSecurityAlarm1.BeidouProactiveSecurityAlarm1File.class);
            safetyWarningFileService.updateAccepAlarmsFiles(alarmFileList,userid,userkey);
            Map<String,Object> res =  new HashMap<String,Object>();
            res.put("status","200");
            res.put("message","success");
            try {
                response.getWriter().write(JSONObject.toJSONString(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        String datalist = request.getParameter("datalist");
        Map<String,Object> res =  new HashMap<String,Object>();
        res.put("status","200");
        res.put("message","success");
        try {
            response.getWriter().write(JSONObject.toJSONString(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实时位置信息
     * @param request
     * @param response
     */
    @RequestMapping(value = "/clgps")
    public void clgps(
            HttpServletRequest request,
            HttpServletResponse response){
        try {
            InputStream is = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line=reader.readLine())!=null){
                sb.append(line);
            }
            String reqBody = sb.toString();
           //System.out.println("实时位置数据:" + reqBody);
            JSONObject jsonObj = JSONObject.parseObject(reqBody);
            String userid = jsonObj.get("userid")+ "";
            String userkey = jsonObj.get("userkey") + "";
            String datacount = jsonObj.get("datacount") + "";
            String datalist = jsonObj.get("datalist") + "";
            List<CarRealtimeGps> carRealtimeGpsList = JSONArray.parseArray(datalist,CarRealtimeGps.class);
            safetyWarningService.updateCarGps(carRealtimeGpsList,userid,userkey);
            Map<String,Object> res =  new HashMap<String,Object>();
            res.put("status","200");
            res.put("message","success");
            try {
                response.getWriter().write(JSONObject.toJSONString(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> res =  new HashMap<String,Object>();
        res.put("status","200");
        res.put("message","success");
        try {
            response.getWriter().write(JSONObject.toJSONString(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实时位置信息
     * @param request
     * @param response
     */
    @RequestMapping(value = "/acceptCarGps")
    public void acceptCarGps(
            HttpServletRequest request,
            HttpServletResponse response){
        try {
            String compId = request.getParameter("compId");
            String dataList = request.getParameter("dataList");
            boolean flag = BeidouCompSignUtil.checkParamsAndSign(request);
            if(!flag){
                Map<String,Object> res =  new HashMap<String,Object>();
                res.put("status","409");
                res.put("message","sign fail");
                response.getWriter().write(JSONObject.toJSONString(res));
                return;
            }
            List<CarRealtimeGps> carRealtimeGpsList = JSONArray.parseArray(dataList,CarRealtimeGps.class);
            safetyWarningService.acceptCarGps(carRealtimeGpsList,compId);
            Map<String,Object> res =  new HashMap<String,Object>();
            res.put("status","200");
            res.put("message","success");
            try {
                response.getWriter().write(JSONObject.toJSONString(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> res =  new HashMap<String,Object>();
        res.put("status","200");
        res.put("message","success");
        try {
            response.getWriter().write(JSONObject.toJSONString(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //接收主动安全报警
    @RequestMapping(value = "/acceptSaftyWarning")
    public void acceptSaftyWarning( HttpServletRequest request,
                         HttpServletResponse response){
        System.out.println("acceptSaftyWarning=======================");
        try {
            String compId = request.getParameter("compId");
            String dataList = request.getParameter("dataList");
            boolean flag = BeidouCompSignUtil.checkParamsAndSign(request);
             if(!flag){
                Map<String,Object> res =  new HashMap<String,Object>();
                res.put("status","409");
                res.put("message","sign fail");
                response.getWriter().write(JSONObject.toJSONString(res));
                return;
            }
            List<BeidouSafetyWarning> safetyWarningList = JSONArray.parseArray(dataList,BeidouSafetyWarning.class);
            safetyWarningService.updateSafetyWarning(safetyWarningList,compId);
            Map<String,Object> res =  new HashMap<String,Object>();
            res.put("status","200");
            res.put("message","success");
            try {
                response.getWriter().write(JSONObject.toJSONString(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //最后失败会走这里
        Map<String,Object> res =  new HashMap<String,Object>();
        res.put("status","500");
        res.put("message","fail");
        try {
            response.getWriter().write(JSONObject.toJSONString(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;

    }


    /**
     * 接收报警附件
     * @param request
     * @param response
     */
    @RequestMapping(value = "/acceptSaftyWarningFiles")
    public void acceptSaftyWarningFiles(
            HttpServletRequest request,
            HttpServletResponse response){
        try {
            String compId = request.getParameter("compId");
            String dataList = request.getParameter("dataList");
            boolean flag = BeidouCompSignUtil.checkParamsAndSign(request);
            if(!flag){
                Map<String,Object> res =  new HashMap<String,Object>();
                res.put("status","409");
                res.put("message","sign fail");
                response.getWriter().write(JSONObject.toJSONString(res));
                return;
            }
            List<BeidouSafetyWarning.BeidouSafetyWarningFile> safetyWarningFileList = JSONArray.parseArray(dataList,BeidouSafetyWarning.BeidouSafetyWarningFile.class);
            safetyWarningFileService.acceptSaftyWarningFiles(safetyWarningFileList,compId);
            Map<String,Object> res =  new HashMap<String,Object>();
            res.put("status","200");
            res.put("message","success");
            try {
                response.getWriter().write(JSONObject.toJSONString(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        String datalist = request.getParameter("datalist");
        //System.out.println("报警数据=====datalist:" + datalist);
        Map<String,Object> res =  new HashMap<String,Object>();
        res.put("status","200");
        res.put("message","success");
        try {
            response.getWriter().write(JSONObject.toJSONString(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //接收主动安全的车辆信息
    @RequestMapping(value = "/acceptSaftyCarInfo")
    public void acceptSaftyCarInfo( HttpServletRequest request,
                                    HttpServletResponse response){
        try {
            String compId = request.getParameter("compId");
//            String signKey = request.getParameter("signKey");
            String dataList = request.getParameter("dataList");
            boolean flag = BeidouCompSignUtil.checkParamsAndSign(request);
            if(!flag){
                Map<String,Object> res =  new HashMap<String,Object>();
                res.put("status","409");
                res.put("message","sign fail");
                response.getWriter().write(JSONObject.toJSONString(res));
                return;
            }
            List<BeidouSafetyCarInfo> safetyCarInfoList = JSONArray.parseArray(dataList,BeidouSafetyCarInfo.class);
            bigdataBeidouSafetyCarInfoService.updateSafetyCarInfo(safetyCarInfoList,compId);
            Map<String,Object> res =  new HashMap<String,Object>();
            res.put("status","200");
            res.put("message","success");
            try {
                response.getWriter().write(JSONObject.toJSONString(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //最后失败会走这里
        Map<String,Object> res =  new HashMap<String,Object>();
        res.put("status","500");
        res.put("message","fail");
        try {
            response.getWriter().write(JSONObject.toJSONString(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;

    }

    //接收报警处理的信息（处理方式，回复内容，处理时间等）
    /*@RequestMapping(value = "/acceptAlarmHandleInfo")
    public void acceptAlarmHandleInfo( HttpServletRequest request,
                                    HttpServletResponse response){
        try {
            String compId = request.getParameter("compId");
//            String signKey = request.getParameter("signKey");
            String dataList = request.getParameter("dataList");
            boolean flag = BeidouCompSignUtil.checkParamsAndSign(request);
            if(!flag){
                Map<String,Object> res =  new HashMap<String,Object>();
                res.put("status","409");
                res.put("message","sign fail");
                response.getWriter().write(JSONObject.toJSONString(res));
                return;
            }
            List<BeidouAlarmHandleInfo> alarmHandleInfoList = JSONArray.parseArray(dataList,BeidouAlarmHandleInfo.class);
            safetyWarningService.updateAlarmHandleInfo(alarmHandleInfoList,compId);
            Map<String,Object> res =  new HashMap<String,Object>();
            res.put("status","200");
            res.put("message","success");
            try {
                response.getWriter().write(JSONObject.toJSONString(res));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        //最后失败会走这里
        Map<String,Object> res =  new HashMap<String,Object>();
        res.put("status","500");
        res.put("message","fail");
        try {
            response.getWriter().write(JSONObject.toJSONString(res));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;

    }*/




    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    public  String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
