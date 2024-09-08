package com.pattern.prototype.prototype2;

public class InteligentStudent extends Student {


    public InteligentStudent(){}
    public InteligentStudent(InteligentStudent o) {
        super(o);
        this.iq=o.iq;
    }

    private int iq;
    public void doSomething() {

    }
    public InteligentStudent createCopy() {
        InteligentStudent inteligentStudent = new InteligentStudent(this);
        System.out.println("InteligentStudent object is created");
        return inteligentStudent;

    }
}
