package com.edgedo.common.base;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler, Exception ex) {
        String errMsg = "";
        if(ex instanceof  BusinessException){
            errMsg = ex.getMessage();
        }else{
            errMsg = "后台异常!";
            Logger.getLogger(this.getClass()).error("平台拦截异常!",ex);
            ex.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("success" , false);
        modelAndView.addObject("errMsg" , errMsg);
        modelAndView.addObject("code","-1");
        return modelAndView;
    }
}
