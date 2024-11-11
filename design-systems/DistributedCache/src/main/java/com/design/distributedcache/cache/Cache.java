package com.design.distributedcache.cache;

import com.design.distributedcache.exception.WriteToDataStoreException;

import java.util.List;

public interface Cache <K,V> {
    V get(K key);
    void set(K key,V value) throws WriteToDataStoreException;
    void remove(K key);
    List<K> keys();
    int size();



}
