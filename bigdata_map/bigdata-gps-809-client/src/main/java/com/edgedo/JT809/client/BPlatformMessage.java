package com.edgedo.JT809.client;

public class BPlatformMessage
{
  private int type;
  private int length;
  private byte[] data;

  public BPlatformMessage(short type, byte[] data)
  {
    this.type = type;
    this.length = data.length;
    this.data = data;
  }

  public BPlatformMessage(byte[] buf) throws Exception {
    this.type = (((buf[0] & 0xFF) << 8 | buf[1] & 0xFF) & 0xFFFF);
    this.length = ((buf[2] & 0xFF) << 24 | (buf[3] & 0xFF) << 16 | (buf[4] & 0xFF) << 8 | buf[5] & 0xFF);
    this.data = new byte[this.length];
    for (int i = 0; i < this.length; i++)
      this.data[i] = buf[(6 + i)];
  }

  public void setData(byte[] data)
  {
    this.data = data;
  }

  public byte[] getData()
  {
    return this.data;
  }

  public void setLength(int length)
  {
    this.length = length;
  }

  public int getLength()
  {
    return this.length;
  }

  public int getType() {
    return this.type;
  }

  public void setType(short type) {
    this.type = type;
  }

  public byte[] getBytes() {
    byte[] buf = new byte[6 + this.data.length];
    buf[0] = ((byte)(this.type >> 8 & 0xFF));
    buf[1] = ((byte)(this.type & 0xFF));
    for (int i = 0; i < 4; i++)
      buf[(2 + i)] = ((byte)(this.length >> 8 * (3 - i) & 0xFF));
    for (int i = 0; i < this.data.length; i++)
      buf[(6 + i)] = this.data[i];
    return buf;
  }
}