package com.edgedo.sequrity;

import com.edgedo.common.base.BusinessException;
import com.edgedo.common.sequrity.CheckPermission;
import com.edgedo.common.shiro.User;
import com.edgedo.common.util.JWTUtil;
import com.edgedo.sys.entity.SysPower;
import com.edgedo.sys.queryvo.SysPowerView;
import com.edgedo.sys.service.SysPowerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 平台方法的权限aop
 */
@Aspect
@Component //声明组件
@ComponentScan //组件自动扫描
@EnableAspectJAutoProxy //spring自动切换JDK动态代理和CGLIB
public class CheckPermissionAspect {

    @Autowired
    SysPowerService sysPowerService;

    @Pointcut("@annotation(com.edgedo.common.sequrity.CheckPermission)")
    public void CheckPermissionAspect(){
    }

    @Around("CheckPermissionAspect()")
    public Object doBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object result = null;
        String[] values = getAnnotationValue(proceedingJoinPoint);
        Set<String> powerRequiredSet = new HashSet<String>();
        for(String str : values ){
            powerRequiredSet.add(str);
        }
        if (values.length>0) {
            //获得session中可用权限
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //查询用户的权限
            User user = JWTUtil.getTokenUser(request);
            List<SysPowerView> powerList = sysPowerService.selectPowerByUserId(user.getUserId());
            boolean flag = false;
            for(SysPowerView powerView : powerList){
                String powKey = powerView.getPowerKey();
                if(powerRequiredSet.contains(powKey)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                throw new BusinessException("您无权访问此请求!");
            }
        }
        result = proceedingJoinPoint.proceed();
        return result;
    }
    private String[] getAnnotationValue(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = joinPoint.getTarget().getClass();

        Method[] methods = targetClass.getMethods();
        String[] value = null;

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    CheckPermission a = (CheckPermission)method.getAnnotation(CheckPermission.class);
                    if (a == null) return null;
                    value = a.value();
                    break;
                }
            }
        }
        return value;
    }

}
