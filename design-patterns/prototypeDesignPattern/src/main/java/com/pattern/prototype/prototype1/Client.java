package com.pattern.prototype.prototype1;

public class Client {
    public static void main(String[] args) {

        Student st=new Student();

        Student st1=st.createCopy();

        System.out.println(st);
        System.out.println(st1);



    }
}
