// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   TransformClass.java

package com.edgedo.common.util;

import java.math.BigInteger;

public class TransformClass
{

	private static final byte hex[] = "0123456789ABCDEF".getBytes();

	public TransformClass()
	{
	}

	public static String Bytes2HexString(byte b[])
	{
		byte buff[] = new byte[2 * b.length];
		for (int i = 0; i < b.length; i++)
		{
			buff[2 * i] = hex[b[i] >> 4 & 0xf];
			buff[2 * i + 1] = hex[b[i] & 0xf];
		}

		return new String(buff);
	}

	public static byte[] HexString2Bytes(String hexString)
	{
		return (new BigInteger(hexString, 16)).toByteArray();
	}

}
