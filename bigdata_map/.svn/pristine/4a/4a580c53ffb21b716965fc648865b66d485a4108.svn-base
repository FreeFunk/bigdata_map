package com.edgedo.JT809.client;

public class BPMessage
{
  //业务类型
  private Integer type;
  //报文长度
  private Integer len;
  //报文序列号
  private Integer seq;
  private Integer id;
  private Integer key;
  private boolean encrypt;
  private byte[] ver;
  private byte[] buf;

  public BPMessage(int type, byte[] data)
  {
    this.type = Integer.valueOf(type);
    this.len = Integer.valueOf(0);
    this.seq = Integer.valueOf(0);
    this.id = Integer.valueOf(0);
    this.key = Integer.valueOf(0);
    this.encrypt = false;
    this.ver = null;
    this.buf = data;
  }

  public BPMessage(int type, int len, int seq, int id, int key, boolean encrypt, byte[] ver, byte[] buf) {
    this.type = Integer.valueOf(type);
    this.len = Integer.valueOf(len);
    this.seq = Integer.valueOf(seq);
    this.id = Integer.valueOf(id);
    this.key = Integer.valueOf(key);
    this.encrypt = encrypt;
    this.ver = ver;
    this.buf = buf;
  }

  public void setType(Integer type)
  {
    this.type = type;
  }

  public Integer getType()
  {
    return this.type;
  }

  public void setLen(Integer len)
  {
    this.len = len;
  }

  public Integer getLen()
  {
    return this.len;
  }

  public void setSeq(Integer seq)
  {
    this.seq = seq;
  }

  public Integer getSeq()
  {
    return this.seq;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getId()
  {
    return this.id;
  }

  public void setKey(Integer key)
  {
    this.key = key;
  }

  public Integer getKey()
  {
    return this.key;
  }

  public void setVer(byte[] ver)
  {
    this.ver = ver;
  }

  public byte[] getVer()
  {
    return this.ver;
  }

  public void setBuf(byte[] buf)
  {
    this.buf = buf;
  }

  public byte[] getBuf()
  {
    if (this.buf == null)
      this.buf = new byte[0];
    return this.buf;
  }

  public void setEncrypt(boolean encrypt)
  {
    this.encrypt = encrypt;
  }

  public boolean isEncrypt()
  {
    return this.encrypt;
  }

  public byte[] getBytes() {
    //根据JTT809-2011协议要求，数据头的报文字节数就是22个
    byte[] data = new byte[22 + this.buf.length];
    /*********************设置数据头 begin ****************/
    //把所有四字节的报文统一设置
    for (int i = 0; i < 4; i++){
      //数据长度 MGS_LENGTH
      // 这个26字节=整个数据头的长度(30字节)- 系统发送时间UTC-TIME(8字节) + 头标识(2字节) + 尾标识(2字节)
      data[(0 + i)] = ((byte)(26 + this.buf.length >> 8 * (3 - i) & 0xFF));
      //报文序列号 MSG_SN
      data[(4 + i)] = ((byte)(this.seq.intValue() >> 8 * (3 - i) & 0xFF));
      //下级平台接入码 MSG_GNSSCENTERID
      data[(10 + i)] = ((byte)(this.id.intValue() >> 8 * (3 - i) & 0xFF));
      //数据加密的秘钥 ENCRYPT_KEY
      data[(18 + i)] = ((byte)(this.key.intValue() >> 8 * (3 - i) & 0xFF));
    }
    //设置业务数据类型 MSG_ID
    data[8] = ((byte)(this.type.intValue() >> 8 & 0xFF));
    data[9] = ((byte)(this.type.intValue() & 0xFF));
    //设置版本标识 VERSION_FLAG
    data[14] = ((byte)(this.ver[0] & 0xFF));
    data[15] = ((byte)(this.ver[1] & 0xFF));
    data[16] = ((byte)(this.ver[2] & 0xFF));
    //设置是否加密 ENCRYPT_FLAG 0不加密，1加密
    data[17] = ((byte)(this.encrypt ? 1 : 0));
    //剩下的18-21这四个字节留给加密秘钥
    /*********************设置数据头 end ****************/
    //将数据体拷贝到数组中
    for (int i = 0; i < this.buf.length; i++) {
      data[(22 + i)] = this.buf[i];
    }
    return data;
  }
}