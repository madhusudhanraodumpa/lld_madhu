package com.design.distributedcache.writestrategy;

public interface WriteStrategy<K,V> {
    boolean write(K key, V value);
}
