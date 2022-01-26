package com.edgedo.common.shiro;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.common.base.Constant;
import com.edgedo.common.base.SuccessObj;
import com.edgedo.common.util.JWTUtil;
import com.edgedo.common.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 代码的执行流程preHandle->isAccessAllowed->isLoginAttempt->executeLogin
 */
public class JWTFilter extends BasicHttpAuthenticationFilter {

    /**
     * 判断用户是否想要登入。
     * 检测header里面是否包含access-token字段即可
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("access-token");
        return authorization == null;
    }

    /**
     *
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginAttempt(request, response)) {
            try {
                User shiroUser = JWTUtil.getTokenUser((HttpServletRequest)request);
                if(shiroUser==null){
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }



    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        String requestUri = httpServletRequest.getRequestURI();
        //如果请求的数据没有扩展名那么就返回index
        if(!(requestUri.endsWith(".jsn") || requestUri.endsWith(".do")|| requestUri.endsWith(".action"))){
            ((HttpServletResponse) response).sendRedirect("/login.html");
            return false;
        }
        String authorization = httpServletRequest.getHeader("access-token");
        if (verificationPassAnnotation(request, response, httpServletRequest, authorization)){
            return true;
        }
        if(ObjectUtil.isEmpty(authorization)){
            responseError(request, response);
            return false;
        }
        //看看是否能解析出来合法的用户
        boolean flag = JWTUtil.verify(httpServletRequest);
        if(flag){
            super.preHandle(request, response);
            return true;
        }else{
            responseError(request, response);
            return false;
        }
    }

    /**
     * 验证请求方法是否有@Pass注解,有则直接放行
     * @param request
     * @param response
     * @param httpServletRequest
     * @param authorization
     * @return
     * @throws Exception
     */
    private boolean verificationPassAnnotation(ServletRequest request, ServletResponse response, HttpServletRequest httpServletRequest, String authorization) throws Exception {
        for (String urlMethod: Constant.METHOD_URL_SET) {
            String[] split = urlMethod.split(":--:");
            String requestUri = httpServletRequest.getRequestURI();
            String[] uriArr = requestUri.split("\\.");
            String realUri = uriArr[0];
            String reqMethod = httpServletRequest.getMethod();
            if(split[0].equals(realUri)
                    && (split[1].equals(reqMethod) ||  split[1].equals("RequestMapping"))){
                Constant.isPass=true;
                if(ObjectUtil.isEmpty(authorization)){
                    //如果当前url不需要认证，则注入当前登录用户时，给一个空的
                    httpServletRequest.setAttribute("currentUser",null);
                    return true;
                }else {
                    super.preHandle(request, response);
                }
            }
            if(StringUtils.countMatches(urlMethod, "{")>0 &&
                    StringUtils.countMatches(urlMethod, "/") == StringUtils.countMatches(split[0], "/")
                    && (split[1].equals(httpServletRequest.getMethod()) ||  split[1].equals("RequestMapping"))){
                if(isSameUrl(split[0],httpServletRequest.getRequestURI())){
                    Constant.isPass=true;
                    if(ObjectUtil.isEmpty(authorization)){
                        httpServletRequest.setAttribute("currentUser",null);
                        return true;
                    }else {
                        super.preHandle(request, response);
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断路径参数的url是否和controller方法url一致
     * @param localUrl
     * @param requestUrl
     * @return
     */
    private boolean isSameUrl(String localUrl,String requestUrl){
        String[] tempLocalUrls = localUrl.split("/");
        String[] tempRequestUrls = requestUrl.split("/");
        if(tempLocalUrls.length != tempRequestUrls.length){
            return false;
        }
        StringBuilder sbLocalUrl =new StringBuilder();
        StringBuilder sbRequestUrl =new StringBuilder();
        for (int i = 0; i < tempLocalUrls.length; i++) {
            if(StringUtils.countMatches(tempLocalUrls[i], "{") > 0){
                tempLocalUrls[i]="*";
                tempRequestUrls[i]="*";
            }
            sbLocalUrl.append(tempLocalUrls[i]+"/");
            sbRequestUrl.append(tempRequestUrls[i]+"/");
        }
        return sbLocalUrl.toString().trim().equals(sbRequestUrl.toString().trim());
    }

    /**
     * 非法url返回身份错误信息
     */
    private void responseError(ServletRequest request, ServletResponse response) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("utf-8");
            out = response.getWriter();
            response.setContentType("application/json; charset=utf-8");
            SuccessObj notLoginResponse = new SuccessObj();
            notLoginResponse.setSuccess(false);
            notLoginResponse.setErrMsg("用户未登录");
            notLoginResponse.setErrType("not_login");
            notLoginResponse.setCode(1001);
            out.print(JSONObject.toJSONString(notLoginResponse));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
