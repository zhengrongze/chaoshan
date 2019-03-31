package com.mc.redis.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ICacheImpl
 * @Author ZhengRongZe
 * @Date 2019/3/4 23:22
 **/
@Service
public class RedisICacheImpl implements ICache {

    @Autowired
    private RedisDao redisDao;

    public String get(String key) {
        return redisDao.get(key);
    }

    public void put(String key, String value, long timeout, TimeUnit unit) {
        redisDao.put(key,value,timeout,unit);
    }

    public void set(String key, String value) {
        redisDao.set(key,value);
    }
}
