package com.edgedo.common.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectHelper {
	  public ReflectHelper() {
	    }

	    public static Field getFieldByFieldName(Object obj, String fieldName) {
	        Class superClass = obj.getClass();

	        while(superClass != Object.class) {
	            try {
	                return superClass.getDeclaredField(fieldName);
	            } catch (NoSuchFieldException var4) {
	                superClass = superClass.getSuperclass();
	            }
	        }

	        return null;
	    }

	    public static Object getValueByFieldName(Object obj, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
	        Field field = getFieldByFieldName(obj, fieldName);
	        Object value = null;
	        if (field != null) {
	            if (field.isAccessible()) {
	                value = field.get(obj);
	            } else {
	                field.setAccessible(true);
	                value = field.get(obj);
	                field.setAccessible(false);
	            }
	        }

	        return value;
	    }

	    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
	        Field field = obj.getClass().getDeclaredField(fieldName);
	        if (field.isAccessible()) {
	            field.set(obj, value);
	        } else {
	            field.setAccessible(true);
	            field.set(obj, value);
	            field.setAccessible(false);
	        }

	    }

	    public static List<String> getFields(Class t) {
	        Field[] fields = t.getDeclaredFields();
	        List<String> list = new ArrayList();
	        Field[] var6 = fields;
	        int var5 = fields.length;

	        for(int var4 = 0; var4 < var5; ++var4) {
	            Field f = var6[var4];
	            String name = f.getName();
	            list.add(name);
	        }

	        return list;
	    }

	    public static Object getDefaultConstrucotrObject(Class type) {
	        Object o = null;

	        try {
	            Constructor cons = type.getDeclaredConstructor();
	            o = cons.newInstance();
	        } catch (Exception var3) {
	            var3.printStackTrace();
	        }

	        return o;
	    }
}
