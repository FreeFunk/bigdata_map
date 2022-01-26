package com.edgedo.JT809.client;

public class BPInterface
{
  public static byte[] UpConnectReq(int uid, String pass, String ip, short port)
  {
    byte[] data = new byte[46];
    for (int i = 0; i < 4; i++)
      data[(0 + i)] = ((byte)(uid >> 8 * (3 - i) & 0xFF));
    byte[] tmp = pass.getBytes();
    for (int i = 0; i < tmp.length; i++)
      data[(4 + i)] = tmp[i];
    tmp = ip.getBytes();
    for (int i = 0; i < tmp.length; i++)
      data[(12 + i)] = tmp[i];
    data[44] = ((byte)(port >> 8 & 0xFF));
    data[45] = ((byte)(port & 0xFF));
    return data;
  }

  public static byte[] UpDisConnectReq(int uid, String pass)
  {
    byte[] data = new byte[12];
    for (int i = 0; i < 4; i++)
      data[(0 + i)] = ((byte)(uid >> 8 * (3 - i) & 0xFF));
    byte[] tmp = pass.getBytes();
    for (int i = 0; i < 8; i++)
      data[(4 + i)] = tmp[i];
    return data;
  }

  public static byte[] UpDisConnectInform(int errorcode)
  {
    byte[] data = new byte[1];
    data[0] = ((byte)errorcode);
    return data;
  }

  public static byte[] UpCloseLinkInform(int reasoncode)
  {
    byte[] data = new byte[1];
    data[0] = ((byte)reasoncode);
    return data;
  }

  public static byte[] DownConnectRsp(int result)
  {
    byte[] data = new byte[1];
    data[0] = ((byte)result);
    return data;
  }

  public static byte[] DownDisConnectRsp()
  {
    return new byte[0];
  }

  public static byte[] DownLinkTestRsp()
  {
    return new byte[0];
  }

  public static byte[] UpLinkTestReq()
  {
    return new byte[0];
  }

  public static byte[] UpExgMsgRegister(String vid, short color, String platid, String prodid, String termtype, String termid, String sim)
  {
    byte[] data = new byte[61];
    byte[] tmp = platid.getBytes();
    for (int i = 0; i < 11; i++) {
      if (i > tmp.length - 1)
        break;
      data[i] = tmp[i];
    }

    tmp = prodid.getBytes();
    for (int i = 0; i < 11; i++) {
      if (i > tmp.length - 1)
        break;
      data[(11 + i)] = tmp[i];
    }

    tmp = termtype.getBytes();
    for (int i = 0; i < 20; i++) {
      if (i > tmp.length - 1)
        break;
      data[(22 + i)] = tmp[i];
    }

    tmp = termid.getBytes();
    for (int i = 0; i < 7; i++) {
      if (i > tmp.length - 1)
        break;
      data[(42 + i)] = tmp[i];
    }

    tmp = sim.getBytes();
    for (int i = 0; i < 12; i++) {
      if (i > tmp.length - 1)
        break;
      data[(49 + i)] = tmp[i];
    }

    return new BPExchangeMessage(vid, color, (short)4609, data).getBytes();
  }

  public static byte[] UpExgMsgRealLocation(String vid, short color, BPGnssData gnssdata)
  {
    return new BPExchangeMessage(vid, color, BPMessageType.UP_EXG_MSG_REAL_LOCATION, gnssdata.getBytes()).getBytes();
  }

  public static byte[] UpExgMsgHistoryLocation(String vid, short color, BPGnssData[] gnssdata)
  {
    byte[] data = new byte[gnssdata.length * 36 + 1];
    data[0] = ((byte)gnssdata.length);
    for (int i = 0; i < gnssdata.length; i++) {
      byte[] tmp = gnssdata[i].getBytes();
      System.arraycopy(tmp, 0, data, 1 + i * 36, 36);
    }
    return new BPExchangeMessage(vid, color, (short)4611, data).getBytes();
  }

  public static byte[] UpExgMsgReturnStartupAck(String vid, short color)
  {
    byte[] data = new byte[0];
    return new BPExchangeMessage(vid, color, (short)4613, data).getBytes();
  }

  public static byte[] UpExgMsgReturnEndAck(String vid, short color)
  {
    byte[] data = new byte[0];
    return new BPExchangeMessage(vid, color, (short)4614, data).getBytes();
  }

  public static byte[] UpExgMsgApplyForMonitorStartup(String vid, short color, long stime, long etime)
  {
    byte[] data = new byte[16];
    for (int i = 0; i < 8; i++) {
      data[(0 + i)] = ((byte)(int)(stime >> 8 * (7 - i) & 0xFF));
      data[(8 + i)] = ((byte)(int)(etime >> 8 * (7 - i) & 0xFF));
    }
    return new BPExchangeMessage(vid, color, (short)4615, data).getBytes();
  }

  public static byte[] UpExgMsgApplyForMonitorEnd(String vid, short color)
  {
    byte[] data = new byte[0];
    return new BPExchangeMessage(vid, color, (short)4616, data).getBytes();
  }

  public static byte[] UpExgMsgApplyHisGnssdataReq(String vid, short color, long stime, long etime)
  {
    byte[] data = new byte[16];
    for (int i = 0; i < 8; i++) {
      data[(0 + i)] = ((byte)(int)(stime >> 8 * (7 - i) & 0xFF));
      data[(8 + i)] = ((byte)(int)(etime >> 8 * (7 - i) & 0xFF));
    }
    return new BPExchangeMessage(vid, color, (short)4617, data).getBytes();
  }

  public static byte[] UpExgMsgReportDriverInfoAck(String vid, short color, String driverName, String driverID, String licence, String orgName)
  {
    byte[] data = new byte[276];
    byte[] tmp = driverName.getBytes();
    for (int i = 0; i < 16; i++) {
      if (i > tmp.length - 1)
        break;
      data[(0 + i)] = tmp[i];
    }
    tmp = driverID.getBytes();
    for (int i = 0; i < 20; i++) {
      if (i > tmp.length - 1)
        break;
      data[(16 + i)] = tmp[i];
    }
    tmp = licence.getBytes();
    for (int i = 0; i < 40; i++) {
      if (i > tmp.length - 1)
        break;
      data[(36 + i)] = tmp[i];
    }
    tmp = orgName.getBytes();
    for (int i = 0; i < 200; i++) {
      if (i > tmp.length - 1)
        break;
      data[(76 + i)] = tmp[i];
    }
    return new BPExchangeMessage(vid, color, (short)4618, data).getBytes();
  }

  public static byte[] UpExgMsgTakeEwaybillAck(String vid, short color, String ewaybillinfo)
  {
    byte[] tmp = ewaybillinfo.getBytes();
    byte[] data = new byte[tmp.length + 4];
    for (int i = 0; i < 4; i++)
      data[(0 + i)] = ((byte)(tmp.length >> 8 * (3 - i) & 0xFF));
    for (int i = 0; i < tmp.length; i++)
      data[(4 + i)] = tmp[i];
    return new BPExchangeMessage(vid, color, (short)4619, data).getBytes();
  }

  public static byte[] UpExgMsgReportDriverInfo(String vid, short color, String driverName, String driverID, String licence, String orgName)
  {
    byte[] data = new byte[276];
    byte[] tmp = driverName.getBytes();
    for (int i = 0; i < 16; i++) {
      if (i > tmp.length - 1)
        break;
      data[(0 + i)] = tmp[i];
    }
    tmp = driverID.getBytes();
    for (int i = 0; i < 20; i++) {
      if (i > tmp.length - 1)
        break;
      data[(16 + i)] = tmp[i];
    }
    tmp = licence.getBytes();
    for (int i = 0; i < 40; i++) {
      if (i > tmp.length - 1)
        break;
      data[(36 + i)] = tmp[i];
    }
    tmp = orgName.getBytes();
    for (int i = 0; i < 200; i++) {
      if (i > tmp.length - 1)
        break;
      data[(76 + i)] = tmp[i];
    }
    return new BPExchangeMessage(vid, color, (short)4620, data).getBytes();
  }

  public static byte[] UpExgMsgTakeEwaybillInfo(String vid, short color, String ewaybillinfo)
  {
    byte[] tmp = ewaybillinfo.getBytes();
    byte[] data = new byte[tmp.length + 4];
    for (int i = 0; i < 4; i++)
      data[(0 + i)] = ((byte)(tmp.length >> 8 * (3 - i) & 0xFF));
    for (int i = 0; i < tmp.length; i++)
      data[(4 + i)] = tmp[i];
    return new BPExchangeMessage(vid, color, (short)4621, data).getBytes();
  }

  public static byte[] UpPlatformMsgPostQueryAck(byte objtype, String objid, int infoid, String info)
  {
    byte[] data = new byte[21 + info.getBytes().length];
    data[0] = objtype;
    byte[] tmp = objid.getBytes();
    for (int i = 0; i < 12; i++) {
      if (i > tmp.length - 1)
        break;
      data[(1 + i)] = tmp[i];
    }
    tmp = info.getBytes();
    for (int i = 0; i < 4; i++) {
      data[(13 + i)] = ((byte)(infoid >> 8 * (3 - i) & 0xFF));
      data[(17 + i)] = ((byte)(tmp.length >> 8 * (3 - i) & 0xFF));
    }

    for (int i = 0; i < tmp.length; i++)
      data[(21 + i)] = tmp[i];
    return new BPlatformMessage((short)4865, data).getBytes();
  }

  public static byte[] UpPlatformMsgInfoAck(int infoid)
  {
    byte[] data = new byte[4];
    for (int i = 0; i < 4; i++)
      data[(0 + i)] = ((byte)(infoid >> 8 * (3 - i) & 0xFF));
    return new BPlatformMessage((short)4866, data).getBytes();
  }

  public static byte[] UpWarnMsgUrgeTodoAck(String vid, short color, int supervision_id, byte result)
  {
    byte[] data = new byte[5];
    for (int i = 0; i < 4; i++)
      data[(0 + i)] = ((byte)(supervision_id >> 8 * (3 - i) & 0xFF));
    data[4] = result;
    return new BPWarningMessage(vid, color, (short)5121, data).getBytes();
  }

  /**
   * @Author WangZhen
   * @Description 上报报警信息
   * 根据2013年的补充说明增加参数BPGnssData 参数
   * @param vid  车牌号
   * @param color 车牌颜色
   * @param warnsrc 报警源
   * @param warntype 报警类型
   * @param warntime 报警时间
   * @param infoid 报警id
   * @param info 报警信息
   * @param gnssData 位置相关报警
   * @Date 2020/2/12 15:21
   **/
  public static byte[] UpWarnMsgAdptInfo(
          String vid, short color, byte warnsrc, short warntype,
          long warntime, int infoid, String info,BPGnssData gnssData){
    //根据JTT 809-2011 技术协议 4.5.5.1.3 上报报警信息
    //还有一层父类封装 所以不再此处设置车牌号，车牌颜色，子业务类型，后续数据长度
    byte[] infoData = info.getBytes();
    int len = infoData.length;
    //55 = 报警来源1 + 报警类型2 + 报警时间8 + 信息id4 + 报警信息内容长度4 + GNSS位置36
    byte[] data = new byte[55 + len ];
    //报警信息来源 0x01:车载终端,0x02企业监管平台,0x03政府监管平台 0x09其他
    data[0] = warnsrc;
    //报警类型
    data[1] = ((byte)(warntype >> 8 & 0xFF));
    data[2] = ((byte)(warntype & 0xFF));
    //拼装报警时间
    for (int i = 0; i < 8; i++) {
      data[(3 + i)] = ((byte) (int) (warntime >> 8 * (7 - i) & 0xFF));
    }

    for (int i = 0; i < 4; i++) {
      //设置信息id
      data[(11 + i)] = ((byte)(infoid >> 8 * (3 - i) & 0xFF));
      //设置报警数据长度
      data[(15 + i)] = ((byte)(len >> 8 * (3 - i) & 0xFF));
    }
    //设置报警内容
    for (int i = 0; i < len; i++) {
      data[(19 + i)] = infoData[i];
    }
    //设置位置相关信息
    if(gnssData!=null){
      byte[] gnssBytes = gnssData.getBytes();
      System.arraycopy(
              gnssBytes,
              0,
              data,
              (data.length-gnssBytes.length),
              gnssBytes.length);
    }

    return new BPWarningMessage(vid, color, BPMessageType.UP_WARN_MSG_ADPT_INFO, data).getBytes();
  }


  public static byte[] UpWarnMsgAdptTodoInfo(String vid, short color, int infoid, byte result)
  {
    byte[] data = new byte[5];
    for (int i = 0; i < 4; i++)
      data[i] = ((byte)(infoid >> 8 * (3 - i) & 0xFF));
    data[4] = result;
    return new BPWarningMessage(vid, color, (short)5123, data).getBytes();
  }

  public static byte[] UpBaseMsgVehicleAddedAck(String vid, short color, String carinfo)
  {
    return new BPBaseMessage(vid, color, (short)5633, carinfo.getBytes()).getBytes();
  }

  public static byte[] UpCtrlMsgMonitorVehicleAck(String vid, short color, byte result)
  {
    byte[] data = new byte[1];
    data[0] = result;
    return new BPCtrlMessage(vid, color, (short)5377, data).getBytes();
  }

  public static byte[] UpCtrlMsgTakePhotoAck(String vid, short color, byte flag, BPGnssData gnssdata, byte channel, byte resolution, byte format, byte[] photodata)
  {
    byte[] data = new byte[44 + photodata.length];
    data[0] = flag;
    byte[] tmp = gnssdata.getBytes();
    for (int i = 0; i < 36; i++)
      data[(1 + i)] = tmp[i];
    data[37] = channel;
    for (int i = 0; i < 4; i++)
      data[(38 + i)] = ((byte)(photodata.length >> 8 * (3 - i) & 0xFF));
    data[42] = resolution;
    data[43] = format;
    for (int i = 0; i < photodata.length; i++)
      data[(44 + i)] = photodata[i];
    return new BPCtrlMessage(vid, color, (short)5378, data).getBytes();
  }

  public static byte[] UpCtrlMsgTextInfoAck(String vid, short color, int msgid, byte result)
  {
    byte[] data = new byte[5];
    for (int i = 0; i < 4; i++)
      data[(0 + i)] = ((byte)(msgid >> 8 * (3 - i) & 0xFF));
    data[4] = result;
    return new BPCtrlMessage(vid, color, (short)5379, data).getBytes();
  }

  public static byte[] UpCtrlMsgTakeTravelAck(String vid, short color, byte cmdtype, byte[] travelinfo)
  {
    byte[] data = new byte[travelinfo.length + 5];
    data[0] = cmdtype;
    for (int i = 0; i < 4; i++)
      data[(1 + i)] = ((byte)(travelinfo.length >> 8 * (3 - i) & 0xFF));
    for (int i = 0; i < travelinfo.length; i++)
      data[(5 + i)] = travelinfo[i];
    return new BPCtrlMessage(vid, color, (short)5380, data).getBytes();
  }

  public static byte[] UpCtrlMsgEmergencyMonitoringAck(String vid, short color, byte result)
  {
    byte[] data = new byte[1];
    data[0] = result;
    return new BPCtrlMessage(vid, color, (short)5381, data).getBytes();
  }
}