package com.edgedo.JT809.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class BPMessageCodecFactory
  implements ProtocolCodecFactory
{
  private ProtocolEncoder encoder;
  private ProtocolDecoder decoder;

  public BPMessageCodecFactory()
  {
    this.encoder = new BPMessageEncoder();
    this.decoder = new BPMessageDecoder();
  }

  public ProtocolDecoder getDecoder(IoSession arg0)
    throws Exception
  {
    return this.decoder;
  }

  public ProtocolEncoder getEncoder(IoSession arg0)
    throws Exception
  {
    return this.encoder;
  }
}