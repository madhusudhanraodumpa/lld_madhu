package com.pattern.prototype.prototype2;

public class Student {
    private String name;
    private int age;
    private String address;
    private String gender;
    private double psp;

    public Student(){}
    public Student(Student o) {
        this.address=o.address;
        this.name=o.name;
        this.gender=o.gender;
        this.psp=o.psp;
        this.age=o.age;
    }



    public Student createCopy() {
        Student student = new Student(this);

        System.out.println("Student object is created");
        return student;

    }
}
