package com.design.distributedcache.evictionstrategy;

import com.design.distributedcache.cache.CacheEntry;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Component("LFUCacheStrategy")
public class LFUCacheStrategy<K,V> implements EvictionStrategy<K,V> {
    private final Map<K, Integer> frequencyMap;
    private final PriorityQueue<CacheEntry<K,V>> lfuCache;

    public LFUCacheStrategy() {
        this.frequencyMap = new HashMap<>();
        this.lfuCache = new PriorityQueue<>((e1, e2) -> frequencyMap.get(e1.getKey()) - frequencyMap.get(e2.getKey()));
    }

    @Override
    public CacheEntry<K,V> evict(Map<K, CacheEntry<K, V>> cache) {
        CacheEntry<K,V> leastFrequent = lfuCache.poll();
        cache.remove(leastFrequent.getKey());
        frequencyMap.remove(leastFrequent.getKey());
        return leastFrequent;
    }

    @Override
    public void upate(CacheEntry<K, V> cacheEntry) {
        frequencyMap.put(cacheEntry.getKey(), frequencyMap.getOrDefault(cacheEntry.getKey(), 0) + 1);
        lfuCache.remove(cacheEntry);
        lfuCache.offer(cacheEntry);
    }
}
