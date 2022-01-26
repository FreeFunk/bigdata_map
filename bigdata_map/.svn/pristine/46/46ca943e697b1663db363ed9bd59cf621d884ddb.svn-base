package com.edgedo.JT809.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BPGnssData
{
  private boolean encrypt;
  private Date date;
  private Double lat;
  private Double lng;
  private Short speed;
  private Short drspeed;
  private Integer mileage;
  private Short direction;
  private Short altitude;
  private Integer alarm;
  private Integer state;

  public BPGnssData(boolean encrypt, Date date, double lng, double lat, short speed, short drspeed, int mileage, short direction, short altitude, int state, int alarm)
  {
    this.encrypt = encrypt;
    this.date = date;
    this.lat = Double.valueOf(lat);
    this.lng = Double.valueOf(lng);
    this.speed = Short.valueOf(speed);
    this.drspeed = Short.valueOf(drspeed);
    this.mileage = Integer.valueOf(mileage);
    this.direction = Short.valueOf(direction);
    this.altitude = Short.valueOf(altitude);
    this.alarm = Integer.valueOf(alarm);
    this.state = Integer.valueOf(state);
  }

  public BPGnssData(byte[] buf) {
    if (buf.length != 36)
      return;
    this.encrypt = (buf[0] > 0);
    String strdate = ((buf[3] & 0xFF) << 8 | buf[4] & 0xFF & 0xFFFF) + "-" + buf[2] + "-" + buf[1] + " " + buf[5] + ":" + buf[6] + ":" + buf[7];
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      this.date = sdf.parse(strdate);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    this.lng = Double.valueOf(((buf[8] & 0xFF) << 24 | (buf[9] & 0xFF) << 16 | (buf[10] & 0xFF) << 8 | buf[11] & 0xFF) / 1000000.0D);
    this.lat = Double.valueOf(((buf[12] & 0xFF) << 24 | (buf[13] & 0xFF) << 16 | (buf[14] & 0xFF) << 8 | buf[15] & 0xFF) / 1000000.0D);
    this.speed = Short.valueOf((short)((buf[16] & 0xFF) << 8 | buf[17] & 0xFF & 0xFFFF));
    this.drspeed = Short.valueOf((short)((buf[18] & 0xFF) << 8 | buf[19] & 0xFF & 0xFFFF));
    this.mileage = Integer.valueOf((buf[20] & 0xFF) << 24 | (buf[21] & 0xFF) << 16 | (buf[22] & 0xFF) << 8 | buf[23] & 0xFF);
    this.direction = Short.valueOf((short)((buf[24] & 0xFF) << 8 | buf[25] & 0xFF & 0xFFFF));
    this.altitude = Short.valueOf((short)((buf[26] & 0xFF) << 8 | buf[27] & 0xFF & 0xFFFF));
    this.state = Integer.valueOf((buf[28] & 0xFF) << 24 | (buf[29] & 0xFF) << 16 | (buf[30] & 0xFF) << 8 | buf[31] & 0xFF);
    this.alarm = Integer.valueOf((buf[32] & 0xFF) << 24 | (buf[33] & 0xFF) << 16 | (buf[34] & 0xFF) << 8 | buf[35] & 0xFF);
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Double getLat() {
    return this.lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public boolean isEncrypt() {
    return this.encrypt;
  }

  public void setEncrypt(boolean encrypt) {
    this.encrypt = encrypt;
  }

  public Double getLng() {
    return this.lng;
  }

  public void setLng(Double lng) {
    this.lng = lng;
  }

  public Short getSpeed() {
    return this.speed;
  }

  public void setSpeed(Short speed) {
    this.speed = speed;
  }

  public Short getDrspeed() {
    return this.drspeed;
  }

  public void setDrspeed(Short drspeed) {
    this.drspeed = drspeed;
  }

  public Integer getMileage() {
    return this.mileage;
  }

  public void setMileage(Integer mileage) {
    this.mileage = mileage;
  }

  public Short getDirection() {
    return this.direction;
  }

  public void setDirection(Short direction) {
    this.direction = direction;
  }

  public Short getAltitude() {
    return this.altitude;
  }

  public void setAltitude(Short altitude) {
    this.altitude = altitude;
  }

  public Integer getAlarm() {
    return this.alarm;
  }

  public void setAlarm(Integer alarm) {
    this.alarm = alarm;
  }

  public Integer getState() {
    return this.state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  /**
   * @Author WangZhen
   * @Description 获得字节 & 0xFF 是为了保持低8位的2进制的bit的一致性。
   * @Date 2020/2/12 9:36
   **/
  public byte[] getBytes() {
    byte[] data = new byte[36];
    data[0] = ((byte)(this.encrypt ? 1 : 0));
    Calendar cal = Calendar.getInstance();
    cal.setTime(this.date);
    data[1] = ((byte)cal.get(Calendar.DATE));
    data[2] = ((byte)(cal.get(Calendar.MONTH) + 1));
    short year = (short)cal.get(Calendar.YEAR);
    data[3] = ((byte)(year >> 8 & 0xFF));
    data[4] = ((byte)(year & 0xFF));
    data[5] = ((byte)cal.get(Calendar.HOUR_OF_DAY));
    data[6] = ((byte)cal.get(Calendar.MINUTE));
    data[7] = ((byte)cal.get(Calendar.SECOND));
    int nlng = (int)(this.lng.doubleValue() * 1000000.0D);
    int nlat = (int)(this.lat.doubleValue() * 1000000.0D);
    for (int i = 0; i < 4; i++) {
      data[(8 + i)] = ((byte)(nlng >> 8 * (3 - i) & 0xFF));
      data[(12 + i)] = ((byte)(nlat >> 8 * (3 - i) & 0xFF));
      data[(20 + i)] = ((byte)(this.mileage.intValue() >> 8 * (3 - i) & 0xFF));
      data[(28 + i)] = ((byte)(this.state.intValue() >> 8 * (3 - i) & 0xFF));
      data[(32 + i)] = ((byte)(this.alarm.intValue() >> 8 * (3 - i) & 0xFF));
    }
    data[16] = ((byte)(this.speed.shortValue() >> 8 & 0xFF));
    data[17] = ((byte)(this.speed.shortValue() & 0xFF));
    data[18] = ((byte)(this.drspeed.shortValue() >> 8 & 0xFF));
    data[19] = ((byte)(this.drspeed.shortValue() & 0xFF));
    data[24] = ((byte)(this.direction.shortValue() >> 8 & 0xFF));
    data[25] = ((byte)(this.direction.shortValue() & 0xFF));
    data[26] = ((byte)(this.altitude.shortValue() >> 8 & 0xFF));
    data[27] = ((byte)(this.altitude.shortValue() & 0xFF));
    return data;
  }
}