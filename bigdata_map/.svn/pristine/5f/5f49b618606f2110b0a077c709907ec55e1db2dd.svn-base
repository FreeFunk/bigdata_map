package com.edgedo.JT809.codec;

import com.edgedo.JT809.client.BPClientConfig;
import com.edgedo.JT809.client.BPMessage;
import com.edgedo.JT809.client.BPMessageType;
import com.edgedo.common.util.IocUtil;
import com.edgedo.common.util.TransformClass;

import java.util.Arrays;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BPMessageEncoder extends ProtocolEncoderAdapter
{
  private static final Logger LOGGER = LoggerFactory.getLogger(BPMessageEncoder.class);



  public void encode(IoSession session, Object message, ProtocolEncoderOutput output) throws Exception
  {
    if ((message instanceof BPMessage)) {
      BPMessage msg = (BPMessage)message;
      Integer seq = (Integer)session.getAttribute("seq");
      if (seq == null)
        seq = Integer.valueOf(0);
      seq = Integer.valueOf(seq.intValue() + 1);
      seq = Integer.valueOf(seq.intValue() % 65535);
      session.setAttribute("seq", seq);//设置发送的序列号
      BPClientConfig cfg = IocUtil.getBean(BPClientConfig.class);
      byte[] ver = cfg.getVersion();
      int id = cfg.getGincode().intValue();
      int key = 0;
      boolean encrypt = false;
      byte[] buf = msg.getBuf();
      if ((encrypt) && (buf != null)) {
        BPMessageEncrypt.encrypt(key, buf);
      }
      BPMessage sendmsg = new BPMessage(msg.getType().intValue(), buf.length, seq.intValue(), id, key, encrypt, ver, buf);
      //给数据报的开始添加"头标识-0x5b"和结尾添加"尾标识-0x5d"
      //如果数据报报文中出现0x5b或者0x5d进行转移0x5b=0x5a+0x01,0x5a=0x5a+0x02,0x5d=0x5e+0x01,0x5e=0x5e+0x02
      byte[] sdata = escape_outbuffer(sendmsg.getBytes());
      if(msg.getType().equals(BPMessageType.UP_WARN_MSG)){
        System.out.println(Arrays.toString(sdata));
      }
 	 
 	  String dd=TransformClass.Bytes2HexString(sdata);
 	  if(dd.indexOf("1201")!=-1) {
 		 LOGGER.info(dd);
 	  }
      IoBuffer buffer = IoBuffer.allocate(sdata.length, false);
      buffer.put(sdata);
      buffer.flip();
      output.write(buffer);
    }
  }

  /**
   * @Author WangZhen
   * @Description 获得数据校验码CRC16-CCITT
   * @Date 2020/2/11 16:14
   **/
  public static short crc16(byte[] buf)
  {
    int crc = 65535;
    int polynomial = 4129;

    for (int j = 0; j < buf.length; j++) {
      for (int i = 0; i < 8; i++) {
        boolean bit = (buf[j] >> 7 - i & 0x1) == 1;
        boolean c15 = (crc >> 15 & 0x1) == 1;
        crc <<= 1;
        if ((c15 ^ bit))
          crc ^= polynomial;
      }
    }
    return (short)(crc & 0xFFFF);
  }

  /**
   * @Author WangZhen
   * @Description
   * 给数据报的开始添加"头标识-0x5b"和结尾添加"尾标识-0x5d"
   * 如果数据报报文中出现0x5b或者0x5d进行转移
   * 0x5b=0x5a+0x01,0x5a=0x5a+0x02,0x5d=0x5e+0x01,0x5e=0x5e+0x02
   * @Date 2020/2/11 15:32
   **/
  public byte[] escape_outbuffer(byte[] bytesArr){
    byte headFlag = 0x5b;//91
    byte headFlagEncode = 0x5a;//90
    byte endFlag = 0x5d;//93
    byte endFlagEncode = 0x5e;//94
    byte encode1 = 0x01;//1
    byte encode2 = 0x02;//2
//    byte

    //创建一个2倍的空数组来盛放转换后的报文字节
    byte[] tmp = new byte[bytesArr.length * 2];
    //转换游标 j 从0开始
    int j = 0;
    //拼接头标识 head flag 0x5b=91
    tmp[(j++)] = headFlag;
    //对数据进行转码
    for (int i = 0; i < bytesArr.length; i++){
      byte by = bytesArr[i];
      //转换数据中的头标识
      if ((by == headFlag) || (by == headFlagEncode)){
        //转码
        tmp[(j++)] = headFlagEncode;
        if (by == headFlag) {
          by = encode1;
        }else {
          by = encode2;
        }
      }

      if ((by == endFlag) || (by == endFlagEncode)){
        //转码
        tmp[(j++)] = endFlagEncode;
        if (by == endFlag) {
          by = encode1;
        }else {
          by = encode2;
        }
      }
      //添加 转码补码
      tmp[(j++)] = by;
    }

    short chksum = crc16(bytesArr);//short  是2个字节
    byte[] cdata = new byte[2];
    //chksum >> 8  & 0xFF 无符号右移8位 然后在位与运算(?不知道干嘛?)
    cdata[0] = ((byte)(chksum >> 8 & 0xFF));//截取到高8位
    //截取低位
    cdata[1] = ((byte)(chksum & 0xFF));
    //对校验码进行转码
    for (int i = 0; i < cdata.length; i++){
      byte by = cdata[i];
      if ((by == headFlag) || (by == headFlagEncode)){
        tmp[(j++)] = headFlagEncode;
        if (by == headFlag) {
          by = encode1;
        }else {
          by = encode2;
        }
      }
      if ((by == endFlag) || (by == endFlagEncode)){
        tmp[(j++)] = endFlagEncode;
        if (by == endFlag) {
          by = encode1;
        }else {
          by = encode2;
        }
      }
      tmp[(j++)] = by;
    }
    //最后加上尾标识
    tmp[(j++)] = endFlag;
    byte[] result = null;//创建一个正好的字节数组
    //将已经转移好的字节数组内容转存到正好的数组result里
    result = Arrays.copyOf(tmp, j);
    return result;
  }

  public byte[] bulidPackHead(short type, int bodylen, int seq)
  {
    byte[] head = new byte[22];
    BPClientConfig cfg = IocUtil.getBean(BPClientConfig.class);
    byte[] ver = cfg.getVersion();
    int id = cfg.getGincode().intValue();
    int key = cfg.getEncryptKey().intValue();
    boolean encrypt = cfg.isEncrypt();
    int len = 26 + bodylen;

    for (int i = 0; i < 4; i++)
    {
      head[(0 + i)] = ((byte)(len >> 8 * (3 - i) & 0xFF));
      head[(4 + i)] = ((byte)(seq >> 8 * (3 - i) & 0xFF));
      head[(10 + i)] = ((byte)(id >> 8 * (3 - i) & 0xFF));
      head[(18 + i)] = ((byte)(key >> 8 * (3 - i) & 0xFF));
    }
    head[8] = ((byte)(type >> 8 & 0xFF));
    head[9] = ((byte)(type & 0xFF));
    head[14] = ((byte)(ver[0] & 0xFF));
    head[15] = ((byte)(ver[1] & 0xFF));
    head[16] = ((byte)(ver[2] & 0xFF));
    head[17] = ((byte)(encrypt ? 1 : 0));
    return head;
  }
}