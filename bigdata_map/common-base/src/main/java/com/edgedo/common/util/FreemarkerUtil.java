package com.edgedo.common.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

public class FreemarkerUtil {
	
	/*public static void framemarkerGen(Configuration configuration,PtStaticConfigFremarkerView config,Map<String,Object> data) {
		Writer out =null;
		try {
			String ftlPath = config.getFtlFileName();
			String targetPath = config.getTargetFiileName();
			Template temp =  configuration.getTemplate(ftlPath);
			File forder = new File(config.getTargetForder());
			if (!forder.exists()) {
				forder.mkdirs();
			}
			File target = new File(forder,targetPath);
			out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(target), "utf-8"));
			temp.process(data, out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}*/

	/**
	 * 根据模板路径，模板名，目标绝对路径生成文件
	 * @param templateRealPath 模板绝对路径名
	 * @param targetRealPath 目标绝对路径
	 * @param data 数据
	 */
	public static void framemarkerGen(String templateRealPath,String targetRealPath,Map<String,Object> data) {
		Writer out =null;
		try {
			int namSepratorLength = templateRealPath.lastIndexOf(File.separator);
			String templateForder = templateRealPath.substring(0, namSepratorLength);
			String ftllFileName = templateRealPath.substring(namSepratorLength);
			Configuration configuration = new Configuration();
			configuration.setDefaultEncoding("utf-8");
			configuration.setClassicCompatible(true);//
			configuration.setDirectoryForTemplateLoading(new File(templateForder));
			Template temp =  configuration.getTemplate(ftllFileName);
			File target = new File(targetRealPath);
			if (!target.getParentFile().exists()) {
				target.getParentFile().mkdirs();
			}
			out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(target), "utf-8"));
			temp.process(data, out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 根据模板路径，模板名，流输出
	 * @param templateRealPath 模板绝对路径名
	 * @param data 数据
	 */
	public static void framemarkerGen(String templateRealPath,Map<String,Object> data,OutputStream outputStream) {
		Writer out =null;
		try {
			int namSepratorLength = templateRealPath.lastIndexOf(File.separator);
			String templateForder = templateRealPath.substring(0, namSepratorLength);
			String ftllFileName = templateRealPath.substring(namSepratorLength);
			Configuration configuration = new Configuration();
			configuration.setDefaultEncoding("utf-8");
			configuration.setClassicCompatible(true);//
			configuration.setDirectoryForTemplateLoading(new File(templateForder));
			Template temp =  configuration.getTemplate(ftllFileName);
			out = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
			temp.process(data, out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
