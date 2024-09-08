package com.pattern.builder;

public class Client {

    public static void main(String[] args) throws Exception{
//        b.setAge(24);
//        b.setName("madhu");
//        b.setPsp(65);
//        b.setGender("male");
//        if(b.validate()) {
//            Student st= new Student(b);
//        }else {
//            throw new Exception("something something");
//        }

        Student st= Student.getBuilder()
                .setAge(24)
                .setPsp(65)
                .setAddress("hjshd")
                .setGender("Male")
                .setName("madhu").build();

        System.out.println("student object is created");

    }
}
