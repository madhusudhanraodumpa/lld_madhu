package com.design.distributedcache.datastore;

import com.design.distributedcache.database.MySqlDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("MySqlDataStore")
public class MySqlDataStore<K,V> implements DataStore<K,V>{
    private MySqlDatabase mySqlDatabase;


    @Autowired
    public MySqlDataStore(MySqlDatabase mySqlDatabase) {
        this.mySqlDatabase = mySqlDatabase;

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean set(K key, V value) {
        //mySqlDatabase.write();
        return true;
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
