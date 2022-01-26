package com.edgedo.JT809.client;

public class BPCtrlMessage extends BPBaseMessage
{
  public BPCtrlMessage(String vehid, short color, short type, byte[] data)
  {
    super(vehid, color, type, data);
  }

  public BPCtrlMessage(byte[] buf) throws Exception {
    super(buf);
  }
}