package com.pattern.factory.factoryMethod.database.query;

public class MySqlQuery implements Query{
    @Override
    public void execute() {
        System.out.println("Mysql:query");
    }
}
