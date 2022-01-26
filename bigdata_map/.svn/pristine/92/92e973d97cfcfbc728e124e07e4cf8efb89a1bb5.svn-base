// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TimeEncoding.java

package com.edgedo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeEncoding
{

	public static final String ALLTIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATATIME_FORMAT = "yyyy-MM-dd";

	public TimeEncoding()
	{
	}

	public static String getCurrTime(String formattime)
	{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat(formattime);
		return df.format(date);
	}

	public static String getCurrTime()
	{
		return getCurrTime("yyyy-MM-dd HH:mm:ss");
	}

	public static Date getFormatTime(String formattime)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try
		{
			date = sdf.parse(formattime);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	public static String datetimeToStr(Date datetime)
	{
		return dateToStr("yyyy-MM-dd HH:mm:ss", datetime);
	}

	private static String dateToStr(String Patten, Date date)
	{
		String str = null;
		SimpleDateFormat format = null;
		format = new SimpleDateFormat(Patten);
		try
		{
			str = format.format(date);
		}
		catch (Exception e)
		{
			System.out.println((new StringBuilder("dateToStrPException::>>")).append(e.toString()).toString());
		}
		return str;
	}

	public static long datestrToMill(String datetime)
	{
		long millionSeconds = 0L;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			millionSeconds = sdf.parse(datetime).getTime();
		}
		catch (Exception e)
		{
			System.out.println((new StringBuilder("datestrToMillException::>>")).append(e.toString()).toString());
		}
		return millionSeconds;
	}
}
