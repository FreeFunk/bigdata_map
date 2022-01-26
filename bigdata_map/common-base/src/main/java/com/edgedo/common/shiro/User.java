package com.edgedo.common.shiro;

import com.edgedo.common.util.JWTUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class User {
    //用户id
    String userId;
    //姓名或者昵称
    String userName;

    String defaultRole;

    /**
     * 属性描述: 省份id
     */
    String provinceId;

    /**
     * 属性描述: 城市id
     */
    String cityId;

    /**
     * 属性描述: 县区id
     */
    String xianquId;



    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }


    public String getXianquId() {
        return xianquId;
    }

    public void setXianquId(String xianquId) {
        this.xianquId = xianquId;
    }


    //从request中获取用户信息
    public static User getCurrentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            return JWTUtil.getTokenUser(request);
        } catch (Exception e) {
            return null;
        }
    }

    public String getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(String defaultRole) {
        this.defaultRole = defaultRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
