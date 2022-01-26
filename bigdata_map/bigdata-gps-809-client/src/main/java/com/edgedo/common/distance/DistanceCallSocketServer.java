package com.edgedo.common.distance;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author WangZhen
 * @description  日志等级转换的服务监听
 * @date 2020/1/19
 */
@Component
public class DistanceCallSocketServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCallSocketHandler.class);
    //监听日志改变端口
    @Value("${distanceCall.port}")
    private int log4j_changeport ;

    private static SocketAcceptor acceptor = null;

    public void startListen(){
        if(acceptor!=null){
            return;
        }
        acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
//        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        acceptor.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(
                        new ProtocolCodecFactory(){

                            @Override
                            public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
                                return new DistanceCallMsgEncoder();
                            }

                            @Override
                            public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
                                return new DistanceCallMsgDecoder();
                            }
                        }
                )
        );

        acceptor.setHandler(new DistanceCallSocketHandler());
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        try {
            acceptor.bind(new InetSocketAddress(log4j_changeport));
            LOGGER.error("--------------start distance Level Change Socket ,listen port : " + log4j_changeport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
