package com.edgedo.common.distance;

import com.alibaba.fastjson.JSONObject;
import com.edgedo.JT809.client.BPMessage;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

/**
 * @author WangZhen
 * @description
 * @date 2020/1/19
 */
public class DistanceCallMsgDecoder extends ProtocolDecoderAdapter {

    @Override
    public void decode(
            IoSession ioSession,
            IoBuffer ioBuffer,
            ProtocolDecoderOutput output) throws Exception {
        byte[] buf = new byte[ioBuffer.limit()];
        ioBuffer.get(buf);
        String str = new String(buf);
        Object  obj  = JSONObject.parseObject(str,DistanceCallMessage.class);
        output.write(obj);


    }
}
