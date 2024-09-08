package com.pattern.prototype.prototype3;

public class Client {
    public static void main(String[] args) {

        StudentRegistry studentRegistry = init();

        Student madhu=studentRegistry.getRegistry("april23").copy();
                madhu.setAge(30);
                madhu.setName("madhu");
                madhu.setGender("gender");

        Student raju=studentRegistry.getRegistry("april23").copy();
        raju.setAge(35);
        raju.setName("raju");
        raju.setGender("gender");

        System.out.println(madhu.hashCode());
        System.out.println(madhu.toString());
        System.out.println(raju.hashCode());
        System.out.println(raju.toString());



    }
    public static StudentRegistry init() {

        StudentRegistry studentRegistry=new StudentRegistry();
        studentRegistry.addRegistry(new Student("nov 22 batch"),"nov22batch");
        studentRegistry.addRegistry(new Student("april 23 batch inter"),"april23");
        return studentRegistry;
    }
}
