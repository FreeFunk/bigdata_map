package com.edgedo.common.base;

import com.edgedo.common.shiro.User;
import com.edgedo.common.util.FileUtil;
import com.edgedo.common.util.FreemarkerUtil;
import com.edgedo.common.util.JWTUtil;
import com.edgedo.common.util.ObjectUtil;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.commons.io.IOUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseController {
	
	public boolean validatePhotoCode(String code){
        HttpSession session= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        Object obj =  session.getAttribute("captchaToken");
        if(code ==null || obj==null || !((String)obj).equals(code.trim().toLowerCase())){
            return false;
        }else{
            session.removeAttribute("captchaToken");
            return true;
        }
    }


    /**
     * 获得当前登录用户
     * @return
     */
    public User getLoginUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return JWTUtil.getTokenUser(request);
    }



    /**
     *  下载文件时候使用
     * @param filePath 文件路径
     * @param  fileName 文件名
     */
    public void outFileToBrowser(String filePath,String fileName){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        BufferedInputStream bis  = null;
        BufferedOutputStream bos = null;
        try {
            String extend = FileUtil.getFileExtend(filePath);
            fileName = fileName + "." + extend;
            File temFile = new File(filePath);
            if(!temFile.exists()){
                response.getWriter().write("ERROR:File Not Found");
                return ;
            }
            String browser = request.getHeader("user-agent");
            Pattern p = Pattern.compile(".*MSIE.*?;.*");
            Matcher m = p.matcher(browser);
            if(m.matches()){
                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8").replace("+",""));
            }else{
                response.setHeader("Content-Disposition", "attachment; filename=" +new String(fileName.getBytes("UTF-8"),"ISO8859-1").replace(" ", ""));
            }
            response.setContentType("application/x-download");
            bis  = new BufferedInputStream(new FileInputStream(temFile));
            bos = new BufferedOutputStream(response.getOutputStream());
            IOUtils.copy(bis, bos);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *  查看图片
     */
    public void outInputStreamImgToBrowser(InputStream is){

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        BufferedInputStream bis  = null;
        BufferedOutputStream bos = null;
        try {
            bis  = new BufferedInputStream(is);
            bos = new BufferedOutputStream(response.getOutputStream());
            IOUtils.copy(bis, bos);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 导出excel文件
     * @param fileName
     * @param list
     */
    public void exportExcelToBrowser(String fileName,String[] keys,String[] headers,List list){
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("keys",keys);
        data.put("headers",headers);
        data.put("list",list);
        fileName +=".xls";
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String tplForder = request.getServletContext().getRealPath("/WEB-INF/export/tpl");
        String tplPath = tplForder+File.separator+"common_xls_template.ftl";
        OutputStream os = null;
        try {

            String browser = request.getHeader("user-agent");
            Pattern p = Pattern.compile(".*MSIE.*?;.*");
            Matcher m = p.matcher(browser);
            if(m.matches()){
                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8").replace("+",""));
            }else{
                response.setHeader("Content-Disposition", "attachment; filename=" +new String(fileName.getBytes("UTF-8"),"ISO8859-1").replace(" ", ""));
            }
            response.setContentType("application/x-download");
            os = response.getOutputStream();
            FreemarkerUtil.framemarkerGen(tplPath, data, os);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 获取ip地址
     * @return
     */
    public String getIpAddr() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("PRoxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获得用户的软件版本
     * @return
     */
    public String getUserAgent() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userAgent = request.getHeader("user-agent");
        return userAgent;
    }



    public  String getDiviceType(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object obj =  request.getParameter("DIVICETYPE");
        if(obj!=null){
            return obj.toString();
        }
        return "PC端";
    }


    public String redirectToUrl(String url,HttpServletResponse response){
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将字符串直接输出到浏览器
     * @param str
     */
    public void outStringToBrowser(String str){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        PrintWriter pw = null;

        try {
            pw = response.getWriter();
            pw.write(str);
            pw.flush();
        } catch (Exception var22) {
            var22.printStackTrace();
        } finally {
            if(pw != null) {
                pw.close();
            }
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Date.class, new CustomerDateEditor(true));
    }

  	
  	/**
  	 * 成功返回数据
  	 * @param model
  	 * @param data
  	 */
  	public ModelAndView buildResponse(ModelAndView model , Object data){
  		model.addObject("success" ,true );
  		model.addObject("data" , data );
  		//和前端配合0
        model.addObject("code","0");
  		return model;
  	}
  	

  	/**
  	 * 成功不返回数据
  	 * @param model
  	 */
  	public ModelAndView buildResponse(ModelAndView model){
  		model.addObject("success" ,true );
        model.addObject("code","0");
  		return model;
  	}
  	
  	
  	/**
  	 * 查询和分页
  	 * @param model
  	 * @param query
  	 */
  	public ModelAndView buildResponse(ModelAndView model, QueryObj query){
        model.addObject("code" , "0");
  		Map<String,Object> mapInfo = ObjectUtil.beanToMap(query);
  		model.addAllObjects(mapInfo);
  		return model;
  	}
  	
	/**
  	 * 错误消息
  	 * @param model
  	 * @param errMsg
  	 */
  	public ModelAndView buildErrorResponse(ModelAndView model , String errMsg){
        model.addObject("code" , "-1");
  		model.addObject("success" , false);
  		model.addObject("errMsg" , errMsg);
  		return model;
  	}

    /**
     * 错误消息
     * @param model
     * @param errMsg
     * @param errCode
     */
    public ModelAndView buildErrorResponse(ModelAndView model , String errMsg, String errCode){
        model.addObject("code" , "-1");
        model.addObject("success" , false);
        model.addObject("errMsg" , errMsg);
        model.addObject("errCode" , errCode);
        return model;
    }


}
