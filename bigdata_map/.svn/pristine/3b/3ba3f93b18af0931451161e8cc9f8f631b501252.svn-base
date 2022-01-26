package com.edgedo.JT809.client;

import com.edgedo.common.util.IocUtil;
import com.edgedo.common.util.TimeEncoding;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BPMessageParser
{
  private static final Logger LOGGER = LoggerFactory.getLogger(BPMessageParser.class);

  public static void Parser(IoSession session, BPMessage msg) throws Exception {
	byte[] buf = msg.getBuf();
    switch (msg.getType().intValue()) {
    case 0x1002:{
	      int result = buf[0];
	     // int verify_code = (buf[1] & 0xFF) << 24 | (buf[2] & 0xFF) << 16 | (buf[3] & 0xFF) << 8 | buf[4] & 0xFF;
	     // LOGGER.info("登录应答消息  RESULT:" + result + ",VERIFY_CODE:" + verify_code+",session---"+session);
	      BPClient.setMainLinkSession(session);
	      BPKeepAliveTask task = new BPKeepAliveTask();
	      session.setAttribute("keepalivetask", task);
	      task.Start();
	      
    	}
      break;
    case 0x1004:{
	      session.close(true);
	      BPClient.setMainLinkSession(null);
	      LOGGER.info("主链路注销应答消息");
	
	      LOGGER.info("Send--1009");
	      Thread.sleep(1000L);
    	}
      break;
    case 0x1006:{
    		LOGGER.info("主链路连接保持应答消息");
    		}
      break;
    case 0x9001:{
	      int verify_code = (buf[0] & 0xFF) << 24 | (buf[1] & 0xFF) << 16 | (buf[2] & 0xFF) << 8 | buf[3] & 0xFF;
	      LOGGER.info("从链路连接请求消息   VERIFY_CODE:" + verify_code);
	      BPClient.setSubLinkSession(session);
	      byte[] sbuf = BPInterface.DownConnectRsp(0);
	      BPMessage sendmsg = new BPMessage(0x9002, sbuf);
	      session.write(sendmsg);
	 /*     BPKeepAliveTask task = new BPKeepAliveTask();
	      session.setAttribute("keepalivetask", task);
	      task.Start();
	      Timer timer = new Timer(true);
	      timer.schedule(new BPRepayInfoTask(), 40000L);
	      */
	    	}
      break;
    case 0x9003:{
	      int verify_code = (buf[0] & 0xFF) << 24 | (buf[1] & 0xFF) << 16 | (buf[2] & 0xFF) << 8 | buf[3] & 0xFF;
	      LOGGER.info("从链路注销请求消息   VERIFY_CODE:" + verify_code);
	
	      byte[] sbuf = BPInterface.DownDisConnectRsp();
	      BPMessage sendmsg = new BPMessage(0x9004, sbuf);
	      session.write(sendmsg);
	
	      BPClient.setSubLinkSession(null);
	      Thread.sleep(800L);
	      session.close(true);
    	}
      break;
    case 0x9005:
      {
    	  LOGGER.info("从链路连接保持应答消息");
	      byte[] sbuf = BPInterface.DownLinkTestRsp();
	      BPMessage sendmsg = new BPMessage(0x9006, sbuf);
	      session.write(sendmsg);
      }
      break;
    case 0x9007:
    {
      int reason_code = buf[0];
      LOGGER.info("从链路断开通知消息   REASON_CODE:" + reason_code);
    }
      break;
    case 0x9101:{
      int total = (buf[0] & 0xFF) << 24 | (buf[1] & 0xFF) << 16 | (buf[2] & 0xFF) << 8 | buf[3] & 0xFF;
      long starttime = 0L;
      long endtime = 0L;
      for (int i = 0; i < 8; i++) {
        starttime <<= 8;
        starttime |= buf[(4 + i)] & 0xFF;
      }
      for (int i = 0; i < 8; i++) {
        endtime <<= 8;
        endtime |= buf[(12 + i)] & 0xFF;
      }

      LOGGER.info("接收车辆定位信息数量通知消息   DYNAMIC_INFO_TOTAL:" + total + ",START_TIME:" + starttime + ",END_TIME:" + endtime);
    }
      break;
    case 0x9200:
    {
      BPExchangeMessage submsg = new BPExchangeMessage(buf);
      byte[] data = submsg.getData();
      if (submsg.getType() == 0x9202)
      {
        LOGGER.info("交换车辆定位信息消息");
        BPGnssData gnssdata = new BPGnssData(data);
      }
      else if (submsg.getType() == 0x9203)
      {
        byte gnss_cnt = data[0];
        LOGGER.info("车辆定位信息交换补发消息  GNSS_CNT:" + gnss_cnt);
        String items = "";
        for (int i = 0; i < gnss_cnt; i++) {
          byte[] tmp = new byte[36];
          System.arraycopy(data, 1 + i * 36, tmp, 0, 36);
          BPGnssData gnssdata = new BPGnssData(tmp);
          items = items + submsg.getVehid().trim() + "," + submsg.getColor() + "," + TimeEncoding.datetimeToStr(gnssdata.getDate()) + "," + gnssdata.getLat() + "," + gnssdata.getLng() + "," + gnssdata.getSpeed() + "," + gnssdata.getDrspeed() + "," + gnssdata.getDirection() + "," + gnssdata.getMileage() + "," + gnssdata.getAltitude() + "," + gnssdata.getAlarm() + "," + gnssdata.getState() + "#";
        }

      }
      else if (submsg.getType() == 0x9204)
      {
        String carinfo = new String(data, "GBK");

        LOGGER.info("交换车辆静态信息消息   CAR_INFO:" + carinfo);
      } else if (submsg.getType() == 0x9205)
      {
        byte reason_code = data[0];
        LOGGER.info("启动车辆定位信息交换应答消息   REASON_CODE:" + reason_code);

        byte[] sbuf = BPInterface.UpExgMsgReturnStartupAck(submsg.getVehid(), submsg.getColor());
        BPMessage sendmsg = new BPMessage(0x1200, sbuf);
        BPClient.write(sendmsg);
      }
      else if (submsg.getType() == 0x9206)
      {
        byte reason_code = data[0];
        LOGGER.info("结束车辆定位信息交换请求消息\t REASON_CODE:" + reason_code);

        byte[] sbuf = BPInterface.UpExgMsgReturnEndAck(submsg.getVehid(), submsg.getColor());
        BPMessage sendmsg = new BPMessage(0x1200, sbuf);
        BPClient.write(sendmsg);
      } else if (submsg.getType() == 0x9207)
      {
        byte result = data[0];

        LOGGER.info("申请交换指定车辆定位信息应答消息   RESULT:" + result);
      } else if (submsg.getType() == 0x9208) {
        byte result = data[0];

        LOGGER.info("取消申请交换指定车辆定位信息应答消息  RESULT:" + result);
      } else if (submsg.getType() == 0x9209) {
        byte result = data[0];

        LOGGER.info("补发车辆定位信息应答消息  RESULT:" + result);
      } else if (submsg.getType() == 0x920A) {
        LOGGER.info("上报驾驶员身份识别信息请求消息");
      /*  String[] dnameMape = LastHeartStore.IT.getName("015128947008");
        if (dnameMape != null) {
          byte[] sbuf = BPInterface.UpExgMsgReportDriverInfoAck(submsg.getVehid(), submsg.getColor(), dnameMape[0], dnameMape[1], dnameMape[2], dnameMape[3]);
          BPMessage sendmsg = new BPMessage(0x1200, sbuf);
          BPClient.write(sendmsg);
        }*/

      }
      else if (submsg.getType() == 0x920B) {
        LOGGER.info("上报车辆电子运单请求消息");
      /*  String receipt = LastHeartStore.IT.getReceipt("015128947008");
        if (receipt != null) {
          byte[] sbuf = BPInterface.UpExgMsgTakeEwaybillAck(submsg.getVehid(), submsg.getColor(), receipt);
          BPMessage sendmsg = new BPMessage(0x1200, sbuf);
          BPClient.write(sendmsg);
        }*/

      }
    }
      break;
    case 0x9300:{
      BPlatformMessage submsg = new BPlatformMessage(buf);
      byte[] data = submsg.getData();

      byte objtype = data[0];
      byte[] tmp = new byte[12];
      for (int i = 0; i < 12; i++)
        tmp[i] = data[(1 + i)];
      String objid = new String(tmp, "GBK");
      int infoid = (data[13] & 0xFF) << 24 | (data[14] & 0xFF) << 16 | (data[15] & 0xFF) << 8 | data[16] & 0xFF;
      int infolength = (data[17] & 0xFF) << 24 | (data[18] & 0xFF) << 16 | (data[19] & 0xFF) << 8 | data[20] & 0xFF;
      tmp = new byte[infolength];
      for (int i = 0; i < infolength; i++)
        tmp[i] = data[(21 + i)];
      String info = new String(tmp, "GBK");

      if (submsg.getType() == 0x9301) {
        LOGGER.info(" 平台查岗请求消息 INFO_ID:" + infoid + ",INFO_LENGTH:" + infolength + ",INFO_CONTENT:" + info);
        
        if(info.indexOf("?")!=-1){
        	  ScriptEngineManager manager = new ScriptEngineManager();
        	  ScriptEngine engine = manager.getEngineByName("js");
        	  String[] Str=info.split("=");
        	  Integer result =(Integer) engine.eval(Str[0]);
        	  byte[] sbuf = BPInterface.UpPlatformMsgPostQueryAck(objtype,objid,infoid,String.valueOf(result));
        	  
        	  BPMessage sendmsg = new BPMessage(0x1300, sbuf);
        	  
              boolean f=BPClient.write(sendmsg);
              LOGGER.info(f+"--------平台查岗信息------"+objtype+","+objid+","+infoid+","+String.valueOf(result));
        	  
        }else{
        	String key = System.currentTimeMillis() + "#015128947008";
            String[] mdata = { "5", "9301", objtype+"", objid, infoid+"", info };
       
        }
        
       
      }
      else if (submsg.getType() == 0x9302) {
        LOGGER.info("下发平台间报文请求消息 INFO_ID:" + infoid + ",INFO_LENGTH:" + infolength + ",INFO_CONTENT:" + info);
        byte[] sbuf = BPInterface.UpPlatformMsgInfoAck(infoid);
        BPMessage sendmsg = new BPMessage(0x1300, sbuf);
        BPClient.write(sendmsg);
      }
    }
      break;
    case 0x9400:{
      BPWarningMessage submsg = new BPWarningMessage(buf);
      byte[] data = submsg.getData();

      byte warnsrc = data[0];
      short warntype = (short)((data[1] & 0xFF) << 8 | data[2] & 0xFF);
      long warntime = 0L;
      for (int i = 0; i < 8; i++) {
        warntime <<= 8;
        warntime |= data[(3 + i)] & 0xFF;
      }
      if (submsg.getType() == 0x9401) {
        int id = (data[11] & 0xFF) << 24 | (data[12] & 0xFF) << 16 | (data[13] & 0xFF) << 8 | data[14] & 0xFF;
        long endtime = 0L;
        for (int i = 0; i < 8; i++) {
          endtime <<= 8;
          endtime |= data[(15 + i)] & 0xFF;
        }
        byte level = data[23];
        byte[] tmp = new byte[16];
        for (int i = 0; i < 16; i++)
          tmp[i] = data[(24 + i)];
        String name = new String(tmp, "GBK");
        tmp = new byte[20];
        for (int i = 0; i < 20; i++)
          tmp[i] = data[(40 + i)];
        String tel = new String(tmp, "GBK");
        tmp = new byte[30];
        for (int i = 0; i < 30; i++)
          tmp[i] = data[(60 + i)];
        String email = new String(tmp, "GBK");
        LOGGER.info("报警督办请求消息  WARN_SRC:" + warnsrc + ",WARN_TYPE:" + warntype + ",WARN_TIME:" + warntime + 
          ",SUPERVISION_ID:" + id + ",SUPERVISION_ENDTIME:" + endtime + ",SUPERVISION_LEVEL:" + level + 
          ",SUPERVISION:" + name + ",SUPERVISION_TEL:" + tel + ",SUPERVISION_EMAL:" + email);

        byte[] sbuf = BPInterface.UpWarnMsgUrgeTodoAck(submsg.getVehid(), submsg.getColor(), id, (byte)0);
        BPMessage sendmsg = new BPMessage(5120, sbuf);
        BPClient.write(sendmsg);
      } else if (submsg.getType() == 0x9402)
      {
        int warnlength = (data[11] & 0xFF) << 24 | (data[12] & 0xFF) << 16 | (data[13] & 0xFF) << 8 | data[14] & 0xFF;
        byte[] tmp = new byte[warnlength];
        for (int i = 0; i < warnlength; i++)
          tmp[i] = data[(15 + i)];
        String warninfo = new String(tmp, "GBK");

        LOGGER.info("报警预警消息  WARN_SRC:" + warnsrc + ",WARN_TYPE:" + warntype + ",WARN_TIME:" + warntime + ",WARN_LENGTH:" + warnlength + ",WARN_CONTENT:" + warninfo);
      }
      else if (submsg.getType() == 0x9403)
      {
        int warnlength = (data[11] & 0xFF) << 24 | (data[12] & 0xFF) << 16 | (data[13] & 0xFF) << 8 | data[14] & 0xFF;
        byte[] tmp = new byte[warnlength];
        for (int i = 0; i < warnlength; i++)
          tmp[i] = data[(15 + i)];
        String warninfo = new String(tmp, "GBK");

        LOGGER.info("实时交换报警信息消息  WARN_SRC:" + warnsrc + ",WARN_TYPE:" + warntype + ",WARN_TIME:" + warntime + ",WARN_LENGTH:" + warnlength + ",WARN_CONTENT:" + warninfo);
      }
    }
      break;
    case 0x9600:
    {
      BPBaseMessage submsg = new BPBaseMessage(buf);

      if (submsg.getType() == 0x9601)
      {
        BPClientConfig cfg = IocUtil.getBean(BPClientConfig.class);

        String color = submsg.getColor()+"";

        String carinfo = "VIN:=" + submsg.getVehid().trim() + ";VEHICLE_COLOR:=" + color + ";VEHICLE_TYPE:=1;TRANS_TYPE:=010;VEHICLE_NATIONALITY:=131082;OWERS_ID:=1000;OWERS_NAME:=" + cfg.getGsystemname().trim() + ";OWERS_TEL:=15128947008;";
        LOGGER.info("补报车辆静态信息请求消息--" + carinfo);
        byte[] sbuf = BPInterface.UpBaseMsgVehicleAddedAck(submsg.getVehid(), submsg.getColor(), carinfo);
        BPMessage sendmsg = new BPMessage(5632, sbuf);
        BPClient.write(sendmsg);
      }
    }
      break;
    case 0x9500:
    {
      BPCtrlMessage submsg = new BPCtrlMessage(buf);
      byte[] data = submsg.getData();

      if (submsg.getType() == 0x9501) {
        String tel = new String(data, "GBK");
        LOGGER.info("车辆单向监听请求消息    MONITOR_TEL:" + tel);

        

        byte[] sbuf = BPInterface.UpCtrlMsgMonitorVehicleAck(submsg.getVehid(), submsg.getColor(), (byte)0);
        BPMessage sendmsg = new BPMessage(0x1500, sbuf);
        BPClient.write(sendmsg);
      }
      else if (submsg.getType() == 0x9502) {
        byte channel = data[0];
        byte resolution = data[1];
        LOGGER.info("车辆拍照请求消息    LENS_ID:" + channel + ",SIZE:" + resolution);
        byte[] setting = bulidTakePicture(channel, 1, (short)0, (byte)0, resolution, (byte)1, (byte)127, (byte)1, (byte)1, (byte)1);
       

       
      }
      else if (submsg.getType() == 0x9503) {
        int msgid = (data[0] & 0xFF) << 24 | (data[1] & 0xFF) << 16 | (data[2] & 0xFF) << 8 | data[3] & 0xFF;
        byte msgpriority = data[4];
        int msglength = (data[5] & 0xFF) << 24 | (data[6] & 0xFF) << 16 | (data[7] & 0xFF) << 8 | data[8] & 0xFF;
        byte[] tmp = new byte[msglength];
        for (int i = 0; i < msglength; i++)
          tmp[i] = data[(9 + i)];
        String msgcontent = new String(tmp, "GBK");
        LOGGER.info("下发车辆报文请求消息   MSG_SEQUENCE:" + msgid + ",MSG_PRIORITY:" + msgpriority + ",MSG_LENGTH:" + msglength + ",MSG_CONTENT:" + msgcontent);
        byte[] setting = bulidTextMsg((byte)1, msgcontent.getBytes("GBK"));
       

        byte[] sbuf = BPInterface.UpCtrlMsgTextInfoAck(submsg.getVehid(), submsg.getColor(), msgid, (byte)0);
        BPMessage sendmsg = new BPMessage(0x1500, sbuf);
        BPClient.write(sendmsg);
      }
      else if (submsg.getType() == 0x9504) {
        byte cmdtype = data[0];
        LOGGER.info("上报车辆行驶记录请求消息  cmdtype:" + cmdtype);
        byte[] setting = buildCarRecorderData(cmdtype, new byte[0]);
        
      }
      else if (submsg.getType() == 0x9505) {
        byte[] auth = new byte[10];
        for (int i = 0; i < 10; i++)
          auth[i] = data[i];
        byte[] tmp = new byte[20];
        for (int i = 0; i < 20; i++)
          tmp[i] = data[(10 + i)];
        String apn = new String(tmp, "GBK");
        tmp = new byte[49];
        for (int i = 0; i < 49; i++)
          tmp[i] = data[(30 + i)];
        String username = new String(tmp, "GBK");
        tmp = new byte[22];
        for (int i = 0; i < 22; i++)
          tmp[i] = data[(79 + i)];
        String password = new String(tmp, "GBK");
        tmp = new byte[32];
        for (int i = 0; i < 32; i++)
          tmp[i] = data[(101 + i)];
        String servip = new String(tmp, "GBK");
        short tcpport = (short)((data[''] & 0xFF) << 8 | data[''] & 0xFF);
        short udpport = (short)((data[''] & 0xFF) << 8 | data[''] & 0xFF);
        long endtime = 0L;
        for (int i = 0; i < 8; i++) {
          endtime <<= 8;
          endtime |= data[(137 + i)] & 0xFF;
        }

        String Authen = new String(auth, "GBK");
        LOGGER.info("车辆应急接入监管平台请求消息   AUTHENICATION_CODE:" + Authen + ",ACCESS_POINT_NAME:" + apn + ",USERNAME:" + username + 
          ",PASSWORD:" + password + ",SERVER_IP" + servip + ",TCP_PORT:" + tcpport + ",UDP_PORT:" + udpport + ",END_TIME:" + endtime);
        StringBuffer sbf = new StringBuffer();
        sbf.append("0").append(";").append(Authen).append(";").append(apn.trim()).append(";");
        sbf.append(username.trim()).append(";").append(password.trim()).append(";").append(servip.trim()).append(";").append(tcpport).append(";");
        sbf.append(udpport).append(";").append("0");

        byte[] setting = bulidTerminalControl((byte)2, sbf.toString());

       

        byte[] sbuf = BPInterface.UpCtrlMsgEmergencyMonitoringAck(submsg.getVehid(), submsg.getColor(), (byte)0);
        BPMessage sendmsg = new BPMessage(0x1500, sbuf);
        BPClient.write(sendmsg);
      }
    }
      break;
    }
  }

  public static byte[] bulidTakePicture(byte channel, int cmd, short time, byte saveflag, byte resolution, byte quality, byte b, byte c, byte s, byte h)
  {
    byte[] reply = new byte[12];
    reply[0] = channel;
    reply[1] = ((byte)(cmd >> 8 & 0xFF));
    reply[2] = ((byte)(cmd & 0xFF));
    reply[3] = ((byte)(time >> 8 & 0xFF));
    reply[4] = ((byte)(time & 0xFF));
    reply[5] = saveflag;
    reply[6] = resolution;
    reply[7] = quality;
    reply[8] = b;
    reply[9] = c;
    reply[10] = s;
    reply[11] = h;
    return reply;
  }

  public static byte[] bulidPhoneCall(byte flag, String arg) {
    byte[] reply = new byte[1 + arg.length()];
    reply[0] = flag;
    for (int i = 0; i < arg.length(); i++)
      reply[(1 + i)] = ((byte)(arg.charAt(i) & 0xFF));
    return reply;
  }

  public static byte[] bulidTerminalControl(byte cmd, String arg) {
    if ((cmd != 1) && (cmd != 2)) {
      byte[] reply = new byte[1];
      reply[0] = cmd;
      return reply;
    }
    byte[] reply = new byte[1 + arg.length()];
    reply[0] = cmd;
    for (int i = 0; i < arg.length(); i++)
      reply[(1 + i)] = ((byte)(arg.charAt(i) & 0xFF));
    return reply;
  }

  public static byte[] bulidTextMsg(byte flag, byte[] text)
  {
    byte[] reply = new byte[1 + text.length];
    reply[0] = flag;
    for (int i = 0; i < text.length; i++)
      reply[(1 + i)] = ((byte)(text[i] & 0xFF));
    return reply;
  }

  public static byte[] buildCarRecorderData(byte cmd, byte[] data) {
    byte[] reply = new byte[1 + data.length];
    reply[0] = cmd;
    for (int i = 0; i < data.length; i++)
      reply[(1 + i)] = data[i];
    return reply;
  }
  
  
  
/*  public static void main(String[] args){
	  String work="(3+3)*7=?";
	  System.out.println((3+3)*7);
	  
  }*/
  
  
  /*public static void main(String[] args) throws ScriptException {
	  ScriptEngineManager manager = new ScriptEngineManager();
	  ScriptEngine se = manager.getEngineByName("js");
	  String str ="(4+4)*3=?";
	  String[] res=str.split("=");
	  double result =(Double) se.eval(res[0]);
	  System.out.println(String.valueOf((int)result));
	  
	  Double resul1=24.0;
	  System.out.println(String.valueOf((resul1).intValue()));
  }*/
}