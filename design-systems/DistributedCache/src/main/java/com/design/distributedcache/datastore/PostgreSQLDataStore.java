package com.design.distributedcache.datastore;

import org.springframework.stereotype.Component;

import java.util.List;
@Component("PostgreSQLDataStore")
public class PostgreSQLDataStore<K,V> implements DataStore<K,V> {
    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean set(K key, V value) {
    return false;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public List<K> keys() {
        return List.of();
    }

    @Override
    public int size() {
        return 0;
    }
}
