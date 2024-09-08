package com.pattern.factory.factoryMethod.database.query;

public class PostgreSqlQuery implements Query{
    @Override
    public void execute() {
        System.out.println("PostgreSql:query");
    }
}
