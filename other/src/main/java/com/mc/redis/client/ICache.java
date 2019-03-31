package com.mc.redis.client;

import java.util.concurrent.TimeUnit;

public interface ICache {
    String get(String key);
    void put(String key, String value, long timeout, TimeUnit unit);
    void set(String key,String value);
}
