package com.design.distributedcache.writestrategy;

import org.springframework.stereotype.Component;

@Component("WriteThroughCache")
public class WriteThroughCache<K,V> implements WriteStrategy<K,V>{
    @Override
    public boolean write(Object key, Object value) {
        return false;
    }
}
