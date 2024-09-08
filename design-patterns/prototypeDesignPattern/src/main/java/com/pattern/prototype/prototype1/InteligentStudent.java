package com.pattern.prototype.prototype1;

public class InteligentStudent extends Student{

    private int iq;
    public void doSomething() {

    }
    public InteligentStudent createCopy() {
        InteligentStudent inteligentStudent = new InteligentStudent();
        inteligentStudent.iq=this.iq;
        System.out.println("Inteligent object is created");
        return inteligentStudent;
    }
}
