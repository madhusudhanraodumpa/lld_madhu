package com.pattern.prototype.prototype2;

public class Client {
    public static void main(String[] args) {

        Student st=new InteligentStudent();
        Student st1= st.createCopy();




        System.out.println(st);
        System.out.println(st1);



    }
}
