package com.edgedo.JT809.client;

import java.util.Timer;
import java.util.TimerTask;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BPKeepAliveTask extends TimerTask
{
  Timer timer = new Timer(true);

  private static final Logger LOGGER = LoggerFactory.getLogger(BPKeepAliveTask.class);

  public void run()
  {
    IoSession session = BPClient.getMainLinkSession();
    if (session != null) {
      byte[] sbuf = BPInterface.UpLinkTestReq();
      BPMessage smsg = new BPMessage(4101, sbuf);
      session.write(smsg);
      LOGGER.info("发送主链路保持消息");
    }
  }

  public void Start() {
    LOGGER.info("开启主链路保持消息定时器");
    this.timer.schedule(this, 0L, 20000L);
  }

  public void Stop() {
    LOGGER.info("关闭主链路保持消息定时器");
    this.timer.cancel();
  }
}