package com.edgedo.JT809.codec;

import com.edgedo.JT809.client.BPClientConfig;
import com.edgedo.common.util.IocUtil;

public class BPMessageEncrypt
{

	public BPMessageEncrypt()
	{
	}

	public static void encrypt(long key, byte buf[])
	{
		BPClientConfig cfg = IocUtil.getBean(BPClientConfig.class);
		int idx = 0;
		if (key == 0L)
			key = 1L;
		int mkey = cfg.getM1().intValue();
		if (mkey == 0)
			mkey = 1;
		while (idx < buf.length) 
		{
			key = (long)cfg.getIA1().intValue() * (key % (long)mkey) + (long)cfg.getIC1().intValue() & 0xffffffffL;
			buf[idx++] ^= (byte)(int)(key >> 20 & 255L);
		}
	}
}