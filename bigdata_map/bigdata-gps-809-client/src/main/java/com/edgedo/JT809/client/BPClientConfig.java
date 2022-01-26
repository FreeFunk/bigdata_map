package com.edgedo.JT809.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//配置文件加载对象
@Component
public class BPClientConfig{
  //上级平台ip地址
  @Value("${jt809.servAddr}")
  private String servAddr;
  //上级平台端口
  @Value("${jt809.servPort}")
  private Integer servPort;
  //上级平台用户账号
  @Value("${jt809.userID}")
  private Integer userID;
  //上级平台密码
  @Value("${jt809.userPass}")
  private String userPass;
  //本地监听ip
  @Value("${jt809.localAddr}")
  private String localAddr;
  //本地监听端口
  @Value("${jt809.localPort}")
  private Integer localPort;
  //超时时间
//  @Value("${jt809.timeOut}")
  private Integer timeOut=Integer.valueOf(180);

  private byte[] version = {1, 0, 0};
//  @Value("${jt809.encryptKey}")
  private Integer encryptKey=Integer.valueOf(0);
//  @Value("${jt809.centerID}")
  private Integer centerID=Integer.valueOf(4);
  @Value("${jt809.gonlycode}")
  private String gonlycode;
//  @Value("${jt809.reconnectWaitTime}")
  private Integer reconnectWaitTime=Integer.valueOf(10);
  @Value("${jt809.gincode}")
  private Integer gincode;
//  @Value("${jt809.gsystemname}")
  private String gsystemname = "XYX";
//  @Value("${jt809.M1}")
  private Integer M1=Integer.valueOf(10000000);
//  @Value("${jt809.IA1}")
  private Integer IA1=Integer.valueOf(20000000);
//  @Value("${jt809.IC1}")
  private Integer IC1=Integer.valueOf(30000000);



  public void setServAddr(String servAddr)
  {
    this.servAddr = servAddr;
  }

  public String getServAddr()
  {
    return this.servAddr;
  }

  public void setServPort(Integer servPort)
  {
    this.servPort = servPort;
  }

  public Integer getServPort()
  {
    return this.servPort;
  }

  public void setUserPass(String userPass)
  {
    this.userPass = userPass;
  }

  public String getUserPass()
  {
    return this.userPass;
  }

  public void setLocalAddr(String localAddr)
  {
    this.localAddr = localAddr;
  }

  public String getLocalAddr()
  {
    return this.localAddr;
  }

  public void setLocalPort(Integer localPort)
  {
    this.localPort = localPort;
  }

  public Integer getLocalPort()
  {
    return this.localPort;
  }

  public void setTimeOut(int timeOut)
  {
    this.timeOut = Integer.valueOf(timeOut);
  }

  public Integer getTimeOut()
  {
    return this.timeOut;
  }

  public void setReconnectWaitTime(int reconnectWaitTime)
  {
    this.reconnectWaitTime = Integer.valueOf(reconnectWaitTime);
  }

  public Integer getReconnectWaitTime()
  {
    return this.reconnectWaitTime;
  }

  public Integer getUserID() {
    return this.userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public void setVersion(byte[] version)
  {
    this.version = version;
  }

  public byte[] getVersion()
  {
    return this.version;
  }

  public void setEncryptKey(Integer encryptKey)
  {
    this.encryptKey = encryptKey;
  }

  public Integer getEncryptKey()
  {
    return this.encryptKey;
  }

  public boolean isEncrypt() {
    return this.encryptKey.intValue() > 0;
  }

  public void setCenterID(Integer centerID)
  {
    this.centerID = centerID;
  }

  public Integer getCenterID()
  {
    return this.centerID;
  }

  public String getGonlycode()
  {
    return this.gonlycode;
  }

  public void setGonlycode(String gonlycode) {
    this.gonlycode = gonlycode;
  }

  public Integer getGincode() {
    return this.gincode;
  }

  public void setGincode(Integer gincode) {
    this.gincode = gincode;
  }

  public String getGsystemname() {
    return this.gsystemname;
  }

  public void setGsystemname(String gsystemname) {
    this.gsystemname = gsystemname;
  }

  public Integer getM1() {
    return this.M1;
  }

  public void setM1(Integer m1) {
    this.M1 = m1;
  }

  public Integer getIA1() {
    return this.IA1;
  }

  public void setIA1(Integer iA1) {
    this.IA1 = iA1;
  }

  public Integer getIC1() {
    return this.IC1;
  }

  public void setIC1(Integer iC1) {
    this.IC1 = iC1;
  }
}