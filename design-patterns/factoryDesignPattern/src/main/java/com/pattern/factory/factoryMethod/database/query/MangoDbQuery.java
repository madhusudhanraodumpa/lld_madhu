package com.pattern.factory.factoryMethod.database.query;

public class MangoDbQuery implements Query{
    @Override
    public void execute() {
        System.out.println("MangoDb:query");
    }
}
