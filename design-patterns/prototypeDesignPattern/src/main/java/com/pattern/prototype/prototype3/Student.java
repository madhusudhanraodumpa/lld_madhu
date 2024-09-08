package com.pattern.prototype.prototype3;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", batch='" + batch + '\'' +
                '}';
    }

    private String name;
private int age;
private String gender;
private String batch;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Student(Student o){
        this.name=o.name;
        this.batch=o.batch;
        this.age=o.age;
        this.gender=o.gender;
    }
    public Student(String batchName) {
        this.batch=batchName;
    }
    public Student copy() {
        return new Student(this);
    }
}
