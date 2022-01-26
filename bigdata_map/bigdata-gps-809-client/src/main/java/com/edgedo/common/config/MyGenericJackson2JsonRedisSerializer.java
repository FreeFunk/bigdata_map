package com.edgedo.common.config;

import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

/**
 * @author WangZhen
 * @description
 * @date 2020/2/10
 */
public class MyGenericJackson2JsonRedisSerializer extends GenericJackson2JsonRedisSerializer {

    @Override
    public Object deserialize(@Nullable byte[] source)  {
        try{
            return deserialize(source, Object.class);
        }catch (SerializationException e){
            return new String(source);
        }
    }
}
