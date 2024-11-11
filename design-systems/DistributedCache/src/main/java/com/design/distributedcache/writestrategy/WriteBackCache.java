package com.design.distributedcache.writestrategy;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("WriteBackCache")
public class WriteBackCache<K,V> implements WriteStrategy<K,V>{
    @Override
    public boolean write(K key, V value) {
        return false;
    }
}
