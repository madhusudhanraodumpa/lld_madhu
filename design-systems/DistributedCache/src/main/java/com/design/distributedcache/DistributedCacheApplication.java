package com.design.distributedcache;

import com.design.distributedcache.cache.Cache;
import com.design.distributedcache.cache.CacheNode;
import com.design.distributedcache.cache.DistributedCache;
import com.design.distributedcache.database.MySqlDatabase;
import com.design.distributedcache.datastore.MySqlDataStore;
import com.design.distributedcache.evictionstrategy.EvictionStrategyType;
import com.design.distributedcache.exception.WriteToDataStoreException;
import com.design.distributedcache.writestrategy.WriteStrategyType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DistributedCacheApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<CacheNode<String,String>> cacheNodes = List.of(
                new CacheNode<>(WriteStrategyType.WRITE_BACK_CACHE, EvictionStrategyType.LRU,"us-prod-node",5,new MySqlDataStore<>(new MySqlDatabase())),
                new CacheNode<>(WriteStrategyType.WRITE_BACK_CACHE, EvictionStrategyType.LRU,"uk-prod-node",5,new MySqlDataStore<>(new MySqlDatabase()))
                );

        Cache<String,String> cache = new DistributedCache<>(2,cacheNodes,5,5);

        while (true){
            System.out.println("print what type of query");
            String command = scanner.next();
            if(command.equalsIgnoreCase("G")) {
                System.out.println("please enter the key");
                String key = scanner.next();
                System.out.println("value got it from cache  = "+cache.get(key));
            }
            if(command.equalsIgnoreCase("W")) {
                System.out.println("please enter the key and value");
                String key = scanner.next();
                String value = scanner.next();
                try {
                    cache.set(key,value);
                } catch (WriteToDataStoreException e) {
                    throw new RuntimeException(e);
                }
            }
            if(command.equalsIgnoreCase("R")) {
                System.out.println("please enter the removed key");
                String key = scanner.next();
                cache.remove(key);
            }

        }

      //  SpringApplication.run(DistributedCacheApplication.class, args);
    }

}
