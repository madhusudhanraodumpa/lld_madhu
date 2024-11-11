package com.design.distributedcache.evictionstrategy;

import com.design.distributedcache.cache.CacheEntry;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component("LRUCacheStrategy")
public class LRUCacheStrategy<K,V> implements EvictionStrategy<K,V> {
    private final LinkedHashMap<K, CacheEntry<K,V>> lruCache;

    public LRUCacheStrategy() {
        this.lruCache = new LinkedHashMap<>();
    }


    @Override
    public CacheEntry<K,V> evict(Map<K, CacheEntry<K, V>> cache) {
        CacheEntry<K,V> eldest = lruCache.entrySet().iterator().next().getValue();
        cache.remove(eldest.getKey());
        lruCache.remove(eldest.getKey());
        return eldest;
    }

    @Override
    public void upate(CacheEntry<K, V> cacheEntry) {
        lruCache.remove(cacheEntry.getKey());
        lruCache.put(cacheEntry.getKey(),cacheEntry);

    }
}
