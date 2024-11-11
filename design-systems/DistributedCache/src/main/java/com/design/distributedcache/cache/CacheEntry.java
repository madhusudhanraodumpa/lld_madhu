package com.design.distributedcache.cache;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CacheEntry<K, V> {
    private K key;
    private V value;

    public CacheEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
