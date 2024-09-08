package com.pattern.prototype.prototype1;

public class Student {
    private String name;
    private int age;
    private String address;
    private String gender;
    private double psp;



    public Student createCopy() {
        Student student = new Student();
        student.age=this.age;
        student.gender=this.gender;
        student.name=this.name;
        student.address=this.address;
        student.psp=this.psp;
        System.out.println("Student object is created");
        return student;

    }
}
