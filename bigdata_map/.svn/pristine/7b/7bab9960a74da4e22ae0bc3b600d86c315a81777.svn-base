package com.edgedo.JT809.client;

public class BPBaseMessage
{
  private String vehid;
  private short color;
  private int type;
  private int length;
  private byte[] data;

  public BPBaseMessage(String vehid, short color, short type, byte[] data)
  {
    this.vehid = vehid;
    this.color = color;
    this.type = type;
    this.length = data.length;
    this.data = data;
  }

  public BPBaseMessage(byte[] buf) throws Exception {
    byte[] tmp = new byte[21];
    for (int i = 0; i < 20; i++)
      tmp[i] = buf[i];
    this.vehid = new String(tmp, "GBK");
    this.color = buf[21];
    this.type = (((buf[22] & 0xFF) << 8 | buf[23] & 0xFF) & 0xFFFF);
    this.length = ((buf[24] & 0xFF) << 24 | (buf[25] & 0xFF) << 16 | (buf[26] & 0xFF) << 8 | buf[27] & 0xFF);
    this.data = new byte[this.length];
    for (int i = 0; i < this.length; i++)
      this.data[i] = buf[(28 + i)];
  }

  public void setVehid(String vehid)
  {
    this.vehid = vehid;
  }

  public String getVehid()
  {
    return this.vehid;
  }

  public void setColor(short color)
  {
    this.color = color;
  }

  public short getColor()
  {
    return this.color;
  }

  public void setType(short type)
  {
    this.type = type;
  }

  public int getType()
  {
    return this.type;
  }

  public void setLength(int length)
  {
    this.length = length;
  }

  public int getLength()
  {
    return this.length;
  }

  public void setData(byte[] data)
  {
    this.data = data;
  }

  public byte[] getData()
  {
    return this.data;
  }

  public byte[] getBytes() {
    byte[] buf = new byte[28 + this.data.length];
    byte[] tmp = this.vehid.getBytes();
    for (int i = 0; i < 20; i++) {
      if (i > tmp.length - 1)
        break;
      buf[i] = tmp[i];
    }
    buf[21] = ((byte)this.color);
    buf[22] = ((byte)(this.type >> 8 & 0xFF));
    buf[23] = ((byte)(this.type & 0xFF));
    for (int i = 0; i < 4; i++)
      buf[(24 + i)] = ((byte)(this.length >> 8 * (3 - i) & 0xFF));
    for (int i = 0; i < this.data.length; i++)
      buf[(28 + i)] = this.data[i];
    return buf;
  }
}