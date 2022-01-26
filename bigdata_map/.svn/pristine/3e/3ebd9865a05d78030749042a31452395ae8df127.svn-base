package com.edgedo.common.util;


import com.alibaba.fastjson.JSONObject;
import com.edgedo.common.base.BusinessException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * 对象工具
 */
public class ObjectUtil {
    private static final String JAVAP = "java.";
    private static final String JAVADATESTR = "java.util.Date";
    /**
     * 将变动更新到之前的对象中
     * @param target 完整的查出来的对象
     * @param after 前台传进来不完全的对象
     */
    public static void copyBeanChange(Object target ,Object after) {
        try {
            Class cls = target.getClass();
            Method[] methods = cls.getMethods();
            Map<String, Method> methodMap = new HashMap<String, Method>();
            for (Method method : methods) {
                String methodName = method.getName();
                methodMap.put(methodName, method);
            }

            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                String temStr = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
                String setMethodStr = "set" + temStr;
                String getMethodStr = "get" + temStr;
                Method setMethod = methodMap.get(setMethodStr);
                Method getMethod = methodMap.get(getMethodStr);
                if (setMethod != null && getMethod != null) {
                    Object obj = getMethod.invoke(after);
                    if (obj != null) {
                        setMethod.invoke(target, obj);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将变动更新到之前的对象中
     * @param target 完整的查出来的对象
     * @param after 前台传进来不完全的对象
     */
    public static void copyBeanChange(Object target ,Object after,String property) {
        try {
            Class cls = target.getClass();
            Method[] methods = cls.getMethods();
            Map<String, Method> methodMap = new HashMap<String, Method>();
            for (Method method : methods) {
                String methodName = method.getName();
                methodMap.put(methodName, method);
            }
            String[] targetArr = property.split(",");
            for (String fieldName : targetArr) {

                String temStr = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
                String setMethodStr = "set" + temStr;
                String getMethodStr = "get" + temStr;
                Method setMethod = methodMap.get(setMethodStr);
                Method getMethod = methodMap.get(getMethodStr);
                if (setMethod != null && getMethod != null) {
                    Object obj = getMethod.invoke(after);
                    if (obj != null) {
                        setMethod.invoke(target, obj);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
  

    /**
     * 将变动更新到之前的对象中
     * @param target 完整的查出来的对象
     * @param after 前台传进来不完全的对象
     */
    public static void copyBeanChange(Object target ,String targetProperty,Map<String,Object> after,String afterProperty) {
        try {
            Class targetCls = target.getClass();
            Method[] targetMethods = targetCls.getMethods();
            Map<String, Method> targetMethodMap = new HashMap<String, Method>();
            for (Method method : targetMethods) {
                String methodName = method.getName();
                targetMethodMap.put(methodName, method);
            }

            String[] targetArr = targetProperty.split(",");
            String[] afterArr = afterProperty.split(",");
            for(int i=0;i<targetArr.length&&i<afterArr.length;i++){
                String targetField = targetArr[i];
                String afterField = afterArr[i];
                String temTargetFieldStr = targetField.substring(0, 1).toUpperCase() + targetField.substring(1, targetField.length());
                String setMethodStr = "set" + temTargetFieldStr;
                String getMethodStr = "get" + temTargetFieldStr;
                Method setMethod = targetMethodMap.get(setMethodStr);
                Method getMethod = targetMethodMap.get(getMethodStr);

                if (setMethod != null && setMethod != null) {
                    Class type = getMethod.getReturnType();
                    Object getValue = after.get(afterField);
                    if(getValue!=null && getValue.toString().length()>0){
                        if(type==String.class){
                            try {
                                setMethod.invoke(target,getValue.toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }else if(type==Integer.class || type==int.class){
                            try {
                                setMethod.invoke(target,new Integer(getValue.toString()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }else if(type==BigDecimal.class){
                            try {
                                setMethod.invoke(target,new BigDecimal(getValue.toString()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }else if(type==Double.class || type==double.class){
                            try {
                                setMethod.invoke(target,new Double(getValue.toString()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }else if(type==Float.class || type==float.class){
                            try {
                                setMethod.invoke(target,new Float(getValue.toString()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }else if(type==Date.class){
                            try {
                                String value = getValue.toString();
                                if(value.length()==10){
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    Date d = sdf.parse(getValue.toString());
                                    setMethod.invoke(target,d);
                                }else if(value.length()>10 && value.length()<19){
                                    String temValue = value.substring(0,10);
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    Date d = sdf.parse(temValue);
                                    setMethod.invoke(target,d);
                                }else if(value.length()>=19){
                                    String temValue = value.substring(0,19);
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    Date d = sdf.parse(temValue);
                                    setMethod.invoke(target,d);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }

                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void mapToBean(Map<String,String> map,Object afterObj){
        Class cls = afterObj.getClass();
        Method[] methods = cls.getMethods();
        Map<String, Method> methodMap = new HashMap<String, Method>();
        for (Method method : methods) {
            String methodName = method.getName();
            methodMap.put(methodName, method);
        }

        for(Entry<String,String> entry : map.entrySet()){
            String key = entry.getKey();
            String obj = entry.getValue();
            String value  = obj+"";
            String setMethodStr = "set" + key.substring(0, 1).toUpperCase() +  key.substring(1,key.length());
            String getMethodStr = "get" + key.substring(0, 1).toUpperCase() +  key.substring(1,key.length());
            Method getMetnod = methodMap.get(getMethodStr);
            if(getMetnod==null){
                continue;
            }
            Method setMetnod = methodMap.get(setMethodStr);
            Class type = getMetnod.getReturnType();
            if(setMetnod==null){
                continue;
            }
            if(type==String.class){
                try {
                    setMetnod.invoke(afterObj,value);
                } catch (Exception e) {
                    System.out.println(key+"====================:"+value);
                    e.printStackTrace();
                }
            }else if(type==Integer.class || type==int.class){
                try {
                    if(value.length()==0){value="0";}else {
                        value = value.split("\\.")[0];
                        value = value.replaceAll("\\D", "");
                    }
                    setMetnod.invoke(afterObj,new Integer(value));
                } catch (Exception e) {
                    System.out.println(key+"====================:"+value);
                    e.printStackTrace();
                }

            }else if(type==BigDecimal.class){
                try {
                    if(value.length()==0){value="0";}
                    setMetnod.invoke(afterObj,new BigDecimal(value));
                } catch (Exception e) {
                    System.out.println(key+"====================:"+value);
                    e.printStackTrace();
                }

            }else if(type==Long.class){
                try {
                    if(value.length()==0){value="0";}
                    setMetnod.invoke(afterObj,new Long(value));
                } catch (Exception e) {
                    System.out.println(key+"====================:"+value);
                    e.printStackTrace();
                }
            }else if(type==Double.class || type==double.class){
                try {
                    if(value.length()==0){value="0";}
                    setMetnod.invoke(afterObj,new Double(value));
                } catch (Exception e) {
                    System.out.println(key+"====================:"+value);
                    e.printStackTrace();
                }

            }else if(type==Float.class || type==float.class){
                try {
                    if(value.length()==0){value="0";}
                    setMetnod.invoke(afterObj,new Float(value));
                } catch (Exception e) {
                    System.out.println(key+"====================:"+value);
                    e.printStackTrace();
                }

            }else if(type==Date.class){
                try {
                    if(value!=null){

                        if(value.length()==10){
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date d = sdf.parse(value.toString());
                            setMetnod.invoke(afterObj,d);
                        }else if(value.length()>10 && value.length()<19){
                            String temValue = value.substring(0,10);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date d = sdf.parse(temValue);
                            setMetnod.invoke(afterObj,d);
                        }else if(value.length()>=19){
                            String temValue = value.substring(0,19);
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date d = sdf.parse(temValue);
                            setMetnod.invoke(afterObj,d);
                        }

                    }
                } catch (Exception e) {
                    System.out.println(key+"====================:"+value);
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * <p>方法描述：将map转换成bean</p>
     * @param map
     * @return bean 实例对象
     */
    public static <T> T mapToBean(Map<String,String> map,Class<T> cls){
        T t = null;
        try {
            t = cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mapToBean(map,t);
        return t;
    }
    
    /**
     * 对象变map
     * @param target 目标对象
     */
    public static Map<String,Object> beanToMap(Object target) {
    	Map<String,Object> result = new HashMap<String,Object>();
        try {
            Class cls = target.getClass();
            Method[] methods = cls.getMethods();
            Map<String, Method> methodMap = new HashMap<String, Method>();
            for (Method method : methods) {
                String methodName = method.getName();
                methodMap.put(methodName, method);
            }
            
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                String fieldName = field.getName();
                String temStr = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
                String getMethodStr = "get" + temStr;
                Method getMethod = methodMap.get(getMethodStr);
                if (getMethod != null) {
                    Object obj = getMethod.invoke(target);
                    result.put(fieldName, obj);
                }
            }
            
            Field[] pfeilds = cls.getSuperclass().getDeclaredFields(); 
            for (Field field : pfeilds) {
                String fieldName = field.getName();
                String temStr = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
                String getMethodStr = "get" + temStr;
                Method getMethod = methodMap.get(getMethodStr);
                if (getMethod != null) {
                    Object obj = getMethod.invoke(target);
                    result.put(fieldName, obj);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * 将json格式的字符串解析成Map对象
     */
    public static HashMap<String, String> jsonToMap(String json){
        HashMap<String, String> data = new HashMap<String, String>();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.parseObject(json);
		Set<Entry<String, Object>> entrySet = jsonObject.entrySet();
        // 遍历jsonObject数据，添加到Map对象
        for (Entry<String, Object> entry : entrySet){
            String key = entry.getKey();
            Object obj =  jsonObject.get(key);
            String value = entry.getValue().toString();
            data.put(key, value);
        }
        return data;
    }



    public static boolean isEmpty(Object aObj) {
        if (aObj instanceof String) {
            return isEmpty((String) aObj);
        } else if (aObj instanceof Long) {
            return isEmpty((Long) aObj);
        } else if (aObj instanceof Date) {
            return isEmpty((Date) aObj);
        } else if (aObj instanceof Collection) {
            return isEmpty((Collection) aObj);
        } else if (aObj instanceof Map) {
            return isEmpty((Map) aObj);
        } else if (aObj != null && aObj.getClass().isArray()) {
            return isEmptyArray(aObj);
        } else {
            return isNull(aObj);
        }
    }

    private static boolean isEmptyArray(Object array) {
        int length = 0;
        if (array instanceof int[]) {
            length = ((int[]) array).length;
        } else if (array instanceof byte[]) {
            length = ((byte[]) array).length;
        } else if (array instanceof short[]) {
            length = ((short[]) array).length;
        } else if (array instanceof char[]) {
            length = ((char[]) array).length;
        } else if (array instanceof float[]) {
            length = ((float[]) array).length;
        } else if (array instanceof double[]) {
            length = ((double[]) array).length;
        } else if (array instanceof long[]) {
            length = ((long[]) array).length;
        } else if (array instanceof boolean[]) {
            length = ((boolean[]) array).length;
        } else {
            length = ((Object[]) array).length;
        }
        if (length == 0) {
            return true;
        }
        return false;
    }


    public static boolean isEmpty(Date aDate) {
        if (aDate == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmpty(Long aLong) {
        if (aLong == null) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isEmpty(Map m) {
        if (m == null || m.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Collection c) {
        if (c == null || c.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String aStr) {
        if (aStr == null || aStr.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }



    public static String trim(String aStr) {
        if (aStr == null) {
            return "";
        } else {
            return aStr.trim();
        }
    }

    public static boolean isNull(Object oStr) {
        if (oStr == null) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean equals(String str1, String str2) {
        return str1 != null ? str1.equals(str2) : str2 == null;
    }

    public static boolean equals(Long L1, Long L2) {
        return L1 != null ? L1.equals(L2) : L2 == null;
    }

    public static boolean equals(Object obj1, Object obj2) {
        boolean result;
        if (obj1 != null) {
            result = obj1.equals(obj2);
        } else {
            result = (obj2 == null);
        }
        return result;
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 != null ? str1.equalsIgnoreCase(str2) : str2 == null;
    }


    /**
     * 利用递归调用将Object中的值全部进行获取
     * @param obj           对象
     * @param excludeFields 排除的属性
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, String> objectToMapString(Object obj, String... excludeFields) {
        try {
            Map<String, String> map = new HashMap<>();

            if (excludeFields.length != 0) {
                List<String> list = Arrays.asList(excludeFields);
                objectTransfer(obj, map, list);
            } else {
                objectTransfer(obj, map, null);
            }
            return map;
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("参数转换失败");
        }
    }


    /**
     * 递归调用函数
     *
     * @param obj           对象
     * @param map           map
     * @param excludeFields 对应参数
     * @return
     * @throws IllegalAccessException
     */
    private static Map<String, String> objectTransfer( Object obj, Map<String, String> map, List<String> excludeFields) throws IllegalAccessException {
        boolean isExclude=false;
        //默认字符串
        String timeFormatStr ="YYYY-MM-dd HH:mm:ss";
//        String formatStr = "YYYY-MM-dd HH:mm:ss";
        //设置格式化字符串
//        if (timeFormatStr != null && !timeFormatStr.isEmpty()) {
//            formatStr = timeFormatStr;
//        }
        if (excludeFields!=null){
            isExclude=true;
        }
        Class<?> clazz = obj.getClass();

        List<Field> fieldList = new ArrayList<>() ;
        while (clazz != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(clazz .getDeclaredFields()));
            clazz = clazz.getSuperclass(); //得到父类,然后赋给自己
        }
        //获取值
        for (Field field : fieldList) {
            String fieldName = field.getName();
//            String fieldName = clazz.getSimpleName() + "." + field.getName();
            //判断是不是需要跳过某个属性
            if (isExclude&&excludeFields.contains(fieldName)){
                continue;
            }
            //设置属性可以被访问
            field.setAccessible(true);
            Object value = field.get(obj);
            if(value!=null){
                Class<?> valueClass = value.getClass();
                if (valueClass.isPrimitive()) {
                    map.put(fieldName, value.toString());

                } else if (valueClass.getName().contains(JAVAP)) {//判断是不是基本类型
                    if (valueClass.getName().equals(JAVADATESTR)) {
                        //格式化Date类型
                        SimpleDateFormat sdf = new SimpleDateFormat(timeFormatStr);
                        Date date = (Date) value;
                        String dataStr = sdf.format(date);
                        map.put(fieldName, dataStr);

                    }else if(value instanceof Map){
                        Map<String,Object> temMap = (Map<String,Object> )value;
                        Set<String> keys =  temMap.keySet();
                        for(String key : keys){
                            Object temMapValue  =temMap.get(key);
                            if(temMapValue!=null){
                                map.put(fieldName+"."+key, temMapValue.toString());
                            }
                        }

                    } else {
                        map.put(fieldName, value.toString());
                    }
                } else {
                    objectTransfer(value, map,excludeFields);
                }
            }

        }
        return map;
    }

    public static void main(String[] args){
        System.out.println("maintainSerial,carFrameNum,mileageAddup,hegeCode,maitainComp,maintainDate,hegeSignDay,maintainType,maintainContent,zhijianYuan".toLowerCase());
    }

}