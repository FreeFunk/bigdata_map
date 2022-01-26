package com.edgedo.JT809.client;

import com.edgedo.JT809.codec.BPMessageCodecFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.Executors;

import com.edgedo.common.util.IocUtil;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class BPClient extends Thread {
	private static IoSession mainLinkSession = null;
	private static IoSession subLinkSession = null;
	private static boolean clientlogin = false;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BPClient.class);
	private static SocketAcceptor acceptor = null;
	public static BPClientConfig cfg  = IocUtil.getBean(BPClientConfig.class);
	private static IoConnector connector = null;

	public BPClient() {
	}

	public static boolean write(BPMessage msg) {
		if (mainLinkSession != null)
			mainLinkSession.write(msg);
		else if (subLinkSession != null)
			subLinkSession.write(msg);
		else {
			return false;
		}
		return true;
	}

	public static void setClientlogin(boolean clientlogin) {
		BPClient.clientlogin = clientlogin;
	}

	public static boolean isClientlogin() {
		return clientlogin;
	}

	public static IoSession getMainLinkSession() {
		return mainLinkSession;
	}

	public static void setMainLinkSession(IoSession mainLinkSession) {
		BPClient.mainLinkSession = mainLinkSession;
	}

	public static IoSession getSubLinkSession() {
		return subLinkSession;
	}

	public static void setSubLinkSession(IoSession subLinkSession) {
		BPClient.subLinkSession = subLinkSession;
	}

	public static void begin() {

		acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new BPMessageCodecFactory()));
		acceptor.getFilterChain().addLast("threadPool",
				new ExecutorFilter(Executors.newFixedThreadPool(10000)));

		acceptor.setHandler(new BPClientHandler(false));
		acceptor.setBacklog(1024);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,
				cfg.getTimeOut().intValue());
		acceptor.setReuseAddress(true);
		try {
			acceptor.bind(new InetSocketAddress(cfg.getLocalPort().intValue()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("从链路服务器已启动,监听端口:" + cfg.getLocalPort());

		connector = new NioSocketConnector();
		connector.setConnectTimeoutMillis(10000L);
		BPClientHandler handler = new BPClientHandler(true);
		connector.setHandler(handler);
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new BPMessageCodecFactory()));
		connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,
				cfg.getTimeOut().intValue());
	}

	public static void end() {
		if (acceptor.isActive()) {
			for (IoSession session : acceptor.getManagedSessions().values()) {
				session.close(true);
			}
		}
		if(mainLinkSession!=null){
			mainLinkSession.close(true);
			mainLinkSession=null;
		}
		if(subLinkSession!=null){
			subLinkSession.close(true);
			subLinkSession=null;
		}
		clientlogin = false;
	}
	//登录不成功或者断开 持续登录
	public void run() {
		try {
			ConnectFuture connFuture = null;
			while (true)
				if (isClientlogin()) {
					Thread.sleep(5000L);
				} else {
					if (connFuture == null) {
						LOGGER.info("正在连接 " + cfg.getServAddr() + ":"
								+ cfg.getServPort()
								+ " 服务器--------------------");
						connFuture = connector
								.connect(new InetSocketAddress(cfg
										.getServAddr(), cfg.getServPort()
										.intValue()));
						connFuture.awaitUninterruptibly();
					}
					if ((connFuture.isConnected())
							&& (((BPClientHandler) connector.getHandler())
									.isConnected())) {
						clientlogin=true;
						Thread.sleep(5000L);
					} else {
						end();
						LOGGER.error("连接失败,等待" + cfg.getReconnectWaitTime()
								+ "秒后重连---------------------------");
						connFuture = null;
						Thread.sleep(cfg.getReconnectWaitTime().intValue() * 1000);
					}
				}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}