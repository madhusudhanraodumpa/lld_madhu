package com.design.distributedcache.evictionstrategy;

public class EvictionStrategyFactory {

    public static <K, V> EvictionStrategy<K,V> getEvictionStrategyByType(EvictionStrategyType evictionStrategyType) {
        return switch (evictionStrategyType) {
            case LRU -> new LRUCacheStrategy<K, V>();
            case LFU -> new LFUCacheStrategy<K, V>();
            default -> null;
        };
    }
}
