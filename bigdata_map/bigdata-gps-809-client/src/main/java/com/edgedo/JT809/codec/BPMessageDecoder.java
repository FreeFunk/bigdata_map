package com.edgedo.JT809.codec;

import com.edgedo.JT809.client.BPClientConfig;
import com.edgedo.JT809.client.BPMessage;

import java.util.Arrays;

import com.edgedo.common.util.IocUtil;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BPMessageDecoder extends ProtocolDecoderAdapter
{
  private static final Logger LOGGER = LoggerFactory.getLogger(BPMessageDecoder.class);

  public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput output) throws Exception
  {
    try
    {
      byte[] buf = new byte[in.limit()];
      in.get(buf);
      byte[] data = (byte[])session.getAttribute("debuffer");
      if (data != null)
      {
        byte[] tmp = new byte[data.length + buf.length];
        System.arraycopy(data, 0, tmp, 0, data.length);
        System.arraycopy(buf, 0, tmp, data.length, buf.length);
        buf = tmp;
      }

      if (buf.length > 0)
        if (buf[0] == 91) {
          int start = -1; int end = -1;
          for (int i = 0; i < buf.length; i++) {
            boolean flag = false;
            if (buf[i] == 91)
            {
              start = i;
              end = -1;
            }
            if (buf[i] == 93)
            {
              end = i;
              flag = true;
            }

            if ((flag) && (start != -1) && (end != -1)) {
              byte[] tmp = new byte[end - start + 1];
              for (int j = 0; j < tmp.length; j++)
                tmp[j] = buf[(start + j)];
              doDecode(output, tmp);
            }

          }

          if (end == -1) {
            byte[] tmp = new byte[buf.length - start];
            for (int i = 0; i < tmp.length; i++)
              tmp[i] = buf[(start + i)];
            session.setAttribute("debuffer", tmp);
          }
        }
        else {
          int idx = 0;
          for (int i = 0; i < buf.length; i++) {
            if (buf[i] == 91)
            {
              idx = i;
              break;
            }
          }
          if (idx > 0) {
            byte[] tmp = new byte[buf.length - idx];
            for (int i = 0; i < tmp.length; i++)
              tmp[i] = buf[(idx + i)];
            session.setAttribute("debuffer", tmp);
          } else {
            session.getHandler().exceptionCaught(session, new Throwable("���շ����������� [  ]"));
            session.removeAttribute("debuffer");
          }
        }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public boolean isValidData(byte[] bs) {
    if ((bs[0] == 91) && (bs[(bs.length - 1)] == 93))
      return true;
    return false;
  }

  public void doDecode(ProtocolDecoderOutput output, byte[] buf)
  {
//    System.out.println(Arrays.toString(buf));
    byte[] bs = escape_inbuffer(buf);

    int len = (bs[0] & 0xFF) << 24 | (bs[1] & 0xFF) << 16 | (bs[2] & 0xFF) << 8 | bs[3] & 0xFF;
    int seq = (bs[4] & 0xFF) << 24 | (bs[5] & 0xFF) << 16 | (bs[6] & 0xFF) << 8 | bs[7] & 0xFF;
    int type = (bs[8] & 0xFF) << 8 | bs[9] & 0xFF & 0xFFFF;
    int id = (bs[10] & 0xFF) << 24 | (bs[11] & 0xFF) << 16 | (bs[12] & 0xFF) << 8 | bs[13] & 0xFF;
    byte[] ver = new byte[3];
    ver[0] = bs[14];
    ver[1] = bs[15];
    ver[2] = bs[16];
    boolean encrypt = bs[17] > 0;
    int key = (bs[18] & 0xFF) << 24 | (bs[19] & 0xFF) << 16 | (bs[20] & 0xFF) << 8 | bs[21] & 0xFF;
    byte[] recvdata = new byte[bs.length - 22];
    System.arraycopy(bs, 22, recvdata, 0, bs.length - 22);
    if (encrypt) {
      BPClientConfig cfg = IocUtil.getBean(BPClientConfig.class);
      cfg.setEncryptKey(Integer.valueOf(key));
      cfg.setVersion(ver);
      if (recvdata != null)
        BPMessageEncrypt.encrypt(key, recvdata);
    }
    BPMessage message = new BPMessage(type, len, seq, id, key, encrypt, ver, recvdata);
    output.write(message);
  }

  public byte[] escape_inbuffer(byte[] bs)
  {
    int i = 1; int j = 0;
    for (; i < bs.length - 1; i++)
    {
      byte c = bs[i];
      if (c == 90)
      {
        if (bs[(i + 1)] == 1)
          c = 91;
        i++;
      }
      if (c == 94)
      {
        if (bs[(i + 1)] == 1)
          c = 93;
        i++;
      }
      bs[(j++)] = c;
    }

    byte[] tmps = new byte[j - 2];
    tmps = Arrays.copyOf(bs, j - 2);
    return tmps;
  }
}