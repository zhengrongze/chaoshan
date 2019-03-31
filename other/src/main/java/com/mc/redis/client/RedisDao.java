package com.mc.redis.client;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 封装了一些redis的操作
 */
@Component
public class RedisDao implements InitializingBean{

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void afterPropertiesSet() throws Exception {
        this.keySerializer = redisTemplate.getKeySerializer();
        this.valueOps = redisTemplate.opsForValue();
        this.listOps = redisTemplate.opsForList();
        this.hashOps = redisTemplate.opsForHash();
        this.setOps = redisTemplate.opsForSet();
        this.zSetOps = redisTemplate.opsForZSet();
    }


    private RedisSerializer<?> keySerializer;
    private ValueOperations<String,String> valueOps;
    private ListOperations<String,String> listOps;
    private HashOperations<String,String,String> hashOps;
    private SetOperations<String,String> setOps;
    private ZSetOperations<String,String> zSetOps;

    /**
     * 模糊查询key
     * @param pattern
     * @return
     */
    public Set<String> findKeys(String pattern){
        return redisTemplate.keys(pattern);
    }
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }
    /*-------------valueOps get ------------*/
    public String get(String key) {
        return valueOps.get(key);
    }
    public void put(String key, String value, long timeout, TimeUnit unit){
        valueOps.set(key,value,timeout,unit);
    }
    public void set(String key,String value){
         valueOps.set(key,value);
    }

}
