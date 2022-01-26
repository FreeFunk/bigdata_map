package com.edgedo.common.distance;

/**
 * @author WangZhen
 * @description 远程调用类型配置，仅支持单个参数的方法调用
 * @date 2020/1/19
 */
public class DistanceCallMessage {
    //类名
    private String className;
    //方法名
    private String method;
    //参数字符串
    private String paramString;

    public DistanceCallMessage(String className, String method, String paramString) {
        this.className = className;
        this.method = method;
        this.paramString = paramString;
    }

    public DistanceCallMessage() {
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamString() {
        return paramString;
    }

    public void setParamString(String paramString) {
        this.paramString = paramString;
    }

    @Override
    public String toString() {
        return "DistanceCallMessage{" +
                "className='" + className + '\'' +
                ", method='" + method + '\'' +
                ", paramString='" + paramString + '\'' +
                '}';
    }
}
