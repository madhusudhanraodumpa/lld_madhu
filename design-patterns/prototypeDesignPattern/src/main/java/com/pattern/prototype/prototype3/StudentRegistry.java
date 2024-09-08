package com.pattern.prototype.prototype3;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {

    Map<String,Student> map=new HashMap<>();

    public void addRegistry(Student st,String batchName) {
        map.put(batchName,st);
    }

    public Student getRegistry(String batchName) {
        return map.get(batchName);
    }

}
