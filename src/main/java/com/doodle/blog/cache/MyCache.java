package com.doodle.blog.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class MyCache {
    private static class InstanceHolder {
        private static MyCache cache = new MyCache();
    }

    public static MyCache getInstance() {
        return InstanceHolder.cache;
    }

    public final Cache<String, Object> buildCache(long expired) {
        return CacheBuilder.newBuilder()
                .maximumSize(5000)
                .expireAfterWrite(expired, TimeUnit.SECONDS)
                .build();
    }

    private MyCache() {

    }
}
