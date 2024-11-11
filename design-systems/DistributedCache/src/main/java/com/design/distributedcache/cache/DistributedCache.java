package com.design.distributedcache.cache;

import com.design.distributedcache.datastore.DataStore;
import com.design.distributedcache.evictionstrategy.EvictionStrategy;
import com.design.distributedcache.evictionstrategy.EvictionStrategyFactory;
import com.design.distributedcache.evictionstrategy.EvictionStrategyType;
import com.design.distributedcache.exception.WriteToDataStoreException;
import com.design.distributedcache.writestrategy.WriteStrategy;
import com.design.distributedcache.writestrategy.WriteStrategyFactory;
import com.design.distributedcache.writestrategy.WriteStrategyType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class DistributedCache<K,V> implements Cache<K,V>{
    private final ConsistentHashing<K,V> consistentHashing;
    private final RequestCollapser requestCollapser;
    private  int prefetchThreshold;
    private  int prefetchSize;

    public DistributedCache(int numberOfReplicas,List<CacheNode<K,V>> nodes, int prefetchSize,int prefetchThreshold) {
        this.consistentHashing = new ConsistentHashing<>(numberOfReplicas,nodes);
        this.requestCollapser = new RequestCollapser();
        this.prefetchSize = prefetchSize;
        this.prefetchThreshold = prefetchThreshold;
    }

    @Override
    public V get(K key) {
        if(key==null) return null;
        CacheNode<K,V> cacheNode = consistentHashing.get(key);
        if(cacheNode==null) return null;
        CacheEntry<K,V> cacheEntry =  cacheNode.get(key);
        if(cacheEntry!=null) {
            return cacheEntry.getValue();
        }
        return null;
    }

    @Override
    public void set(K key, V value) throws WriteToDataStoreException {
        if(key==null) return;
        CacheNode<K,V> cacheNode = consistentHashing.get(key);
        if(cacheNode==null) return;
        cacheNode.put(key,value);
    }

    @Override
    public void remove(K key) {
    if(key==null) return;
    CacheNode<K,V> cacheNode = consistentHashing.get(key);
    if(cacheNode==null) return;
    cacheNode.remove(key);

    }

    @Override
    public List<K> keys() {
        return List.of();
    }

    @Override
    public int size() {
        return 0;
    }
    // Implement your own logic for prefetching the keys
    private List<K> prefetchKeys(K key) {
        return new ArrayList<>();
    }


    private void prefetch(K key) {
        if (prefetchThreshold <= 0 || prefetchSize <= 0) {
            return;
        }

        List<K> keysToPrefetch = prefetchKeys(key);

        for (int i = 0; i < prefetchSize && i < keysToPrefetch.size(); i++) {
            K prefetchKey = keysToPrefetch.get(i);
            CacheNode<K,V> node = consistentHashing.get(prefetchKey);
            if (node != null) {
                // Prefetch the key asynchronously
                node.get(prefetchKey);
            }
        }
    }
}
