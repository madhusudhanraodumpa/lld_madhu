package com.pattern.factory.factoryMethod.database.data;

import com.pattern.factory.factoryMethod.database.query.MySqlQuery;
import com.pattern.factory.factoryMethod.database.query.Query;

public class MySqlDatabase implements Database{
    @Override
    public void connect() {
        System.out.println("MySql connect...");
    }

    @Override
    public void setUrl(String url) {
        System.out.println("MySql url...");
    }

    @Override
    public void setUsername(String userName) {
        System.out.println("MySql username...");
    }

    @Override
    public void setPassword(String password) {
        System.out.println("MySql password...");
    }

    @Override
    public Query createQuery() {
        return new MySqlQuery();
    }
}
