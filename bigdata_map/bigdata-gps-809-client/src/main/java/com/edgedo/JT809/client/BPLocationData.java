package com.edgedo.JT809.client;

public class BPLocationData
{
  private byte encrypt;
  private byte[] time;
  private int lng;
  private int lat;
  private short speed;
  private short drsp;
  private int mileage;
  private short direction;
  private short higth;
  private int state;
  private int alarm;

  public BPLocationData(byte[] buf)
  {
    this.encrypt = buf[0];
    for (int i = 0; i < 7; i++)
      this.time[i] = buf[(1 + i)];
    this.lng = ((buf[8] & 0xFF) << 24 | (buf[9] & 0xFF) << 16 | (buf[10] & 0xFF) << 8 | buf[11] & 0xFF);
    this.lat = ((buf[12] & 0xFF) << 24 | (buf[13] & 0xFF) << 16 | (buf[14] & 0xFF) << 8 | buf[15] & 0xFF);
    this.speed = ((short)((buf[16] & 0xFF) << 8 | buf[17] & 0xFF));
    this.drsp = ((short)((buf[18] & 0xFF) << 8 | buf[19] & 0xFF));
    this.mileage = ((buf[20] & 0xFF) << 24 | (buf[21] & 0xFF) << 16 | (buf[22] & 0xFF) << 8 | buf[23] & 0xFF);
    this.direction = ((short)((buf[24] & 0xFF) << 8 | buf[25] & 0xFF));
    this.higth = ((short)((buf[26] & 0xFF) << 8 | buf[27] & 0xFF));
    this.state = ((buf[28] & 0xFF) << 24 | (buf[29] & 0xFF) << 16 | (buf[30] & 0xFF) << 8 | buf[31] & 0xFF);
    this.alarm = ((buf[32] & 0xFF) << 24 | (buf[33] & 0xFF) << 16 | (buf[34] & 0xFF) << 8 | buf[35] & 0xFF);
  }

  public BPLocationData(byte encrypt, byte[] time, int lng, int lat, short speed, short drsp, int mileage, short direction, short higth, int state, int alarm) {
    this.encrypt = encrypt;
    this.time = time;
    this.lng = lng;
    this.lat = lat;
    this.speed = speed;
    this.drsp = drsp;
    this.mileage = mileage;
    this.direction = direction;
    this.higth = higth;
    this.state = state;
    this.alarm = alarm;
  }

  public void setEncrypt(byte encrypt)
  {
    this.encrypt = encrypt;
  }

  public byte getEncrypt()
  {
    return this.encrypt;
  }

  public void setTime(byte[] time)
  {
    this.time = time;
  }

  public byte[] getTime()
  {
    return this.time;
  }

  public void setLng(int lng)
  {
    this.lng = lng;
  }

  public int getLng()
  {
    return this.lng;
  }

  public void setLat(int lat)
  {
    this.lat = lat;
  }

  public int getLat()
  {
    return this.lat;
  }

  public void setSpeed(short speed)
  {
    this.speed = speed;
  }

  public short getSpeed()
  {
    return this.speed;
  }

  public void setDrsp(short drsp)
  {
    this.drsp = drsp;
  }

  public short getDrsp()
  {
    return this.drsp;
  }

  public void setMileage(int mileage)
  {
    this.mileage = mileage;
  }

  public int getMileage()
  {
    return this.mileage;
  }

  public void setDirection(short direction)
  {
    this.direction = direction;
  }

  public short getDirection()
  {
    return this.direction;
  }

  public void setHigth(short higth)
  {
    this.higth = higth;
  }

  public short getHigth()
  {
    return this.higth;
  }

  public void setState(int state)
  {
    this.state = state;
  }

  public int getState()
  {
    return this.state;
  }

  public void setAlarm(int alarm)
  {
    this.alarm = alarm;
  }

  public int getAlarm()
  {
    return this.alarm;
  }

  public byte[] getBytes() {
    byte[] buf = new byte[36];
    buf[0] = this.encrypt;
    for (int i = 0; i < 7; i++)
      buf[(1 + i)] = this.time[i];
    for (int i = 0; i < 4; i++) {
      buf[(8 + i)] = ((byte)(this.lng >> 8 * (3 - i) & 0xFF));
      buf[(12 + i)] = ((byte)(this.lat >> 8 * (3 - i) & 0xFF));
      buf[(20 + i)] = ((byte)(this.mileage >> 8 * (3 - i) & 0xFF));
      buf[(28 + i)] = ((byte)(this.state >> 8 * (3 - i) & 0xFF));
      buf[(32 + i)] = ((byte)(this.alarm >> 8 * (3 - i) & 0xFF));
    }

    buf[16] = ((byte)(this.speed >> 8 & 0xFF));
    buf[17] = ((byte)(this.speed & 0xFF));
    buf[18] = ((byte)(this.drsp >> 8 & 0xFF));
    buf[19] = ((byte)(this.drsp & 0xFF));
    buf[24] = ((byte)(this.direction >> 8 & 0xFF));
    buf[25] = ((byte)(this.direction & 0xFF));
    buf[26] = ((byte)(this.higth >> 8 & 0xFF));
    buf[27] = ((byte)(this.higth & 0xFF));
    return buf;
  }
}