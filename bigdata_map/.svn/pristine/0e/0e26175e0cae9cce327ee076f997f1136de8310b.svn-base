package com.edgedo.JT809.client;

import java.net.InetSocketAddress;

import com.edgedo.common.util.IocUtil;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BPClientHandler extends IoHandlerAdapter
{
  private static final Logger LOGGER = LoggerFactory.getLogger(BPClientHandler.class);
  private boolean connected;
  private boolean isClient;

  public BPClientHandler(boolean flag)
  {
    this.connected = false;
    this.isClient = flag;
  }

  public void sessionCreated(IoSession session) throws Exception
  {
    this.connected = true;
  }

  public void sessionOpened(IoSession session) throws Exception
  {
    InetSocketAddress remoteAddress = (InetSocketAddress)session.getRemoteAddress();
    String servinfo = remoteAddress.getAddress().getHostAddress() + ":" + remoteAddress.getPort();
    session.setAttribute("servinfo", servinfo);

    if (isClient()) {
      LOGGER.info("开始连接主链路到  " + servinfo + " 服务器..............");

      BPClientConfig cfg = IocUtil.getBean(BPClientConfig.class);
      int uid = cfg.getUserID().intValue();
      String pass = cfg.getUserPass();
      String ip = cfg.getLocalAddr();
      short port = cfg.getLocalPort().shortValue();
      byte[] buf = BPInterface.UpConnectReq(uid, pass, ip, port);
      BPMessage smsg = new BPMessage(4097, buf);
      session.write(smsg);
    } else {
      LOGGER.info("从链路收到  " + servinfo + " 客户端的连接.");
    }
  }

  public void messageReceived(IoSession session, Object message) throws Exception
  {
    if ((message instanceof BPMessage)) {
      BPMessage msg = (BPMessage)message;
      BPMessageParser.Parser(session, msg);
    }
  }

  public void messageSent(IoSession session, Object message) throws Exception
  {
  }

  public void sessionClosed(IoSession session) throws Exception
  {
    this.connected = false;
    String servinfo = (String)session.getAttribute("servinfo");
    if (isClient()){
      LOGGER.info("关闭主链路 " + servinfo + " 链接");
      BPClient.setClientlogin(false);
    }else {
      LOGGER.info("关闭从链路 " + servinfo + " 链接");
    }
    BPKeepAliveTask task = (BPKeepAliveTask)session.getAttribute("keepalivetask");
    if (task != null)
      task.Stop();
  }

  public void sessionIdle(IoSession session, IdleStatus status)
    throws Exception
  {
    if (status == IdleStatus.BOTH_IDLE){
      exceptionCaught(session, new Throwable("客户端当前连接超时 [ 接收时间:" + session.getLastReadTime() + ",发送时间:" + session.getLastWriteTime() + " ]"));
     }
  }

  public void exceptionCaught(IoSession session, Throwable cause)
    throws Exception
  {
    String servinfo = (String)session.getAttribute("servinfo");
    LOGGER.info(servinfo + " 异常!-----------" + cause.getLocalizedMessage());
    cause.printStackTrace();
  }

  public boolean isConnected() {
    return this.connected;
  }

  public boolean isClient() {
    return this.isClient;
  }
}