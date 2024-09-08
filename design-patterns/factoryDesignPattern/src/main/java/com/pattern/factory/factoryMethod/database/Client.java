package com.pattern.factory.factoryMethod.database;

import com.pattern.factory.factoryMethod.database.data.Database;
import com.pattern.factory.factoryMethod.database.data.MangoDblDatabase;
import com.pattern.factory.factoryMethod.database.data.MySqlDatabase;
import com.pattern.factory.factoryMethod.database.data.PostgreSqlDatabase;
import com.pattern.factory.factoryMethod.database.query.MangoDbQuery;
import com.pattern.factory.factoryMethod.database.query.PostgreSqlQuery;

public class Client {
    public static void main(String[] args) {
        Database database=new MangoDblDatabase();
        database.createQuery().execute();


    }
}
