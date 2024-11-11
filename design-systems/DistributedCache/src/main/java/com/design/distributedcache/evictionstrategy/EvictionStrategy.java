package com.design.distributedcache.evictionstrategy;

import com.design.distributedcache.cache.CacheEntry;

import java.util.Map;

public interface EvictionStrategy<K,V> {
    CacheEntry<K,V> evict(Map<K, CacheEntry<K,V>> cache);

    void upate(CacheEntry<K, V> cacheEntry);
}
