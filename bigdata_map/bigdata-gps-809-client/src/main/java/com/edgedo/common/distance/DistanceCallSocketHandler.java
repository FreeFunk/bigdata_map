package com.edgedo.common.distance;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.common.util.IocUtil;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangZhen
 * @description 改变日志等级的 socket监听
 * @date 2020/1/19
 */
public class DistanceCallSocketHandler extends IoHandlerAdapter{

    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceCallSocketHandler.class);

    private boolean connected;

    public DistanceCallSocketHandler(){
        this.connected = false;
    }

    public void sessionCreated(IoSession session) throws Exception{
        this.connected = true;
    }

    public void sessionOpened(IoSession session) throws Exception{
        InetSocketAddress remoteAddress = (InetSocketAddress)session.getRemoteAddress();
        String servinfo = remoteAddress.getAddress().getHostAddress() + ":" + remoteAddress.getPort();
        session.setAttribute("servinfo", servinfo);
        LOGGER.info("a client [" + servinfo  + "] linked on for change distance level " );

    }

    public void messageReceived(IoSession session, Object message) throws Exception
    {
        if(message instanceof DistanceCallMessage){
            //这是要远程执行的代码类型
            DistanceCallMessage callInfo = (DistanceCallMessage)message;
            String clsName = callInfo.getClassName();
            String methodName = callInfo.getMethod();
            String paramStr = callInfo.getParamString();
            try {
                Class targetClass = Class.forName(clsName);
                Object targetObj = IocUtil.getBean(targetClass);
                Method targetMethod = targetClass.getMethod(methodName,String.class);
                Object returnObj = null;
                if(paramStr==null){
                    returnObj = targetMethod.invoke(targetObj);
                }else{
                    returnObj = targetMethod.invoke(targetObj,paramStr);
                }
                Map<String,Object> resp = new HashMap<String,Object>();
                resp.put("success",true);
                resp.put("data",returnObj);
                String response = JSONObject.toJSONString(resp);
                session.write(response);
            }catch (Exception e){
                LOGGER.error("----远程调用失败!",e);
            }
        }

    }

    public void messageSent(IoSession session, Object message) throws Exception
    {
    }

    public void sessionClosed(IoSession session) throws Exception
    {
        Object servinfo = session.getAttribute("servinfo");
        //关闭链路连接
        LOGGER.info("close link " + servinfo + " session");
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


}
