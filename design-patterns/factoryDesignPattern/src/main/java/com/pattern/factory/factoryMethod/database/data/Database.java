package com.pattern.factory.factoryMethod.database.data;

import com.pattern.factory.factoryMethod.database.query.Query;

public interface Database {
     void connect();
     void setUrl(String url);
     void setUsername(String userName);
     void setPassword(String password);

     Query createQuery();
}
