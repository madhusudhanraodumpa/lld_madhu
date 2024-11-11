package com.design.distributedcache.datastore;

import java.util.List;

public interface DataStore <K,V>{
    V get(K key);
    boolean set(K key,V value);
    void remove(K key);
    List<K> keys();
    int size();
}
