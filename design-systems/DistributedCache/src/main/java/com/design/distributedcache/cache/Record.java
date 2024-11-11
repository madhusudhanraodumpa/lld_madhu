package com.design.distributedcache.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Record {
    private Map<Integer,String> map;

    public Record() {
        map = new ConcurrentHashMap<>();
    }
}
