package com.pattern.factory.factoryMethod.database.data;

import com.pattern.factory.factoryMethod.database.query.MangoDbQuery;
import com.pattern.factory.factoryMethod.database.query.MySqlQuery;
import com.pattern.factory.factoryMethod.database.query.Query;

public class MangoDblDatabase implements Database{
    @Override
    public void connect() {
        System.out.println("MangoDb connect...");
    }

    @Override
    public void setUrl(String url) {
        System.out.println("MangoDb url...");
    }

    @Override
    public void setUsername(String userName) {
        System.out.println("MangoDb username...");
    }

    @Override
    public void setPassword(String password) {
        System.out.println("MangoDb password...");
    }

    @Override
    public Query createQuery() {
        return new MangoDbQuery();
    }
}
