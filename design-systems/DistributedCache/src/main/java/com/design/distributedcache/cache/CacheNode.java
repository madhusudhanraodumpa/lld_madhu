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

import java.util.HashMap;
import java.util.Map;


public class CacheNode<K,V> {

    private final WriteStrategy<K,V> writeStrategy;
    private final EvictionStrategy<K,V> evictionStrategy;
    @Getter
    private final String nodeId;
    private final int capacity;
    private final Map<K,CacheEntry<K,V>> cache;
    private final WriteStrategyType writeStrategyType;
    private final DataStore<K,V> dataStore;


    public CacheNode(WriteStrategyType writeStrategyType, EvictionStrategyType evictionStrategyType, String nodeId, int capacity, DataStore<K,V> dataStore) {
        this.writeStrategy = WriteStrategyFactory.createWriteStrategyByType(writeStrategyType);
        this.evictionStrategy = EvictionStrategyFactory.getEvictionStrategyByType(evictionStrategyType);
        this.writeStrategyType = writeStrategyType;
        this.nodeId = nodeId;
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.dataStore = dataStore;
    }
    public CacheEntry<K,V> get(K key) {
        if(key ==null) return null;
        CacheEntry<K,V> cacheEntry =  cache.get(key);
        System.out.println("Cache Got "+key+" from node "+nodeId);
        if(cacheEntry==null) {
            V value = readDatafromDataStore(key);
            if(value==null) {
                return null;
            }
            cacheEntry = new CacheEntry<>(key,value);
            cache.put(key,cacheEntry);
            evictionStrategy.upate(cacheEntry);
        } else {
            evictionStrategy.upate(cacheEntry);
        }
        return cacheEntry;
    }



    public void put(K key, V value) throws WriteToDataStoreException {

        if(key==null) return;

        if(cache.size()>=capacity) {
            CacheEntry<K,V> evictedCacheEntry  = evictionStrategy.evict(cache);
            System.out.println("Evicted: " + evictedCacheEntry.getKey() + " from node " + nodeId);
        }
        CacheEntry<K,V> cacheEntry = new CacheEntry<>(key,value);


        cache.put(key,cacheEntry);
        System.out.println("Cache added "+key+" to node "+nodeId);
        evictionStrategy.upate(cacheEntry);
        if(writeStrategyType.equals(WriteStrategyType.WRITE_THROUGH_CACHE)) {
            boolean isWriteSuccess = writeDataToDataStore(key,value);
            if(!isWriteSuccess) {
                cache.remove(key);
                throw new WriteToDataStoreException("Write to database is failed.");
            }
        }
    }

    private boolean writeDataToDataStore(K key, V value) {
        return dataStore.set(key,value);
    }

    public void remove(K key) {
        cache.remove(key);
        removeDatafromDataStore(key);
    }

    private void removeDatafromDataStore(K key) {
        dataStore.remove(key);
    }

    private V readDatafromDataStore(K key) {
        return dataStore.get(key);
    }

}
