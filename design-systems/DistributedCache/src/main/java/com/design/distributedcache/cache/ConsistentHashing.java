package com.design.distributedcache.cache;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;


public class ConsistentHashing <K,V>{
    @Getter
    private final int numberOfReplicas;
    private final SortedMap<Integer,CacheNode<K,V>> circle = new ConcurrentSkipListMap<>();
    public  ConsistentHashing(int numberOfReplicas, List<CacheNode<K,V>> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        for (CacheNode<K,V> node : nodes) {
            add(node);
        }

    }
    public void add(CacheNode<K,V> node) {

        for (int i=0;i<numberOfReplicas;i++) {
            circle.put((node.getNodeId()+i).hashCode(),node);
        }

    }
    public void remove(CacheNode<?,?> node) {

        for (int i=0;i<numberOfReplicas;i++) {
            circle.remove((node.getNodeId()+i).hashCode(),node);
        }

    }

    public CacheNode<K,V> get(K key) {
        if(circle.isEmpty()) return null;

        int hash = key.hashCode();

        if(!circle.containsKey(hash)) {
            SortedMap<Integer, CacheNode<K, V>> tailMap= circle.tailMap(hash);
            hash=  tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();

        }
        return  circle.get(hash);

    }

}
