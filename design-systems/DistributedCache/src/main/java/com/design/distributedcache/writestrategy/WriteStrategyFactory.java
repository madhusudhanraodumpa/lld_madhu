package com.design.distributedcache.writestrategy;

public class WriteStrategyFactory {

    public static <K,V> WriteStrategy<K,V> createWriteStrategyByType(WriteStrategyType writeStrategyType) {
        return switch (writeStrategyType) {
            case WRITE_BACK_CACHE ->  new WriteBackCache<>();
            case WRITE_THROUGH_CACHE -> new WriteThroughCache<>();
            default->null;

        };
    }
}
