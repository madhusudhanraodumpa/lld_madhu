package com.pattern.factory.factoryMethod.database.data;

import com.pattern.factory.factoryMethod.database.query.MySqlQuery;
import com.pattern.factory.factoryMethod.database.query.PostgreSqlQuery;
import com.pattern.factory.factoryMethod.database.query.Query;

public class PostgreSqlDatabase implements Database{
    @Override
    public void connect() {
        System.out.println("PostgreSql connect...");
    }

    @Override
    public void setUrl(String url) {
        System.out.println("PostgreSql url...");
    }

    @Override
    public void setUsername(String userName) {
        System.out.println("PostgreSql username...");
    }

    @Override
    public void setPassword(String password) {
        System.out.println("PostgreSql password...");
    }

    @Override
    public Query createQuery() {
        return new PostgreSqlQuery();
    }
}
