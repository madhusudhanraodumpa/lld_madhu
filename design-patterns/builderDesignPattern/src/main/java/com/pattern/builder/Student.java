package com.pattern.builder;

public class Student {
    private String name;
    private int age;
    private String address;
    private double psp;
    private String gender;

    private Student(Builder b) {
        this.address=b.getAddress();
        this.age=b.getAge();
        this.gender=b.getGender();
        this.psp=b.getPsp();
        this.name=b.getName();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }
        public Student build() throws Exception {
            if(this.validate()) {
                return new Student(this);
            }
            throw new Exception("Build method throwing Exception");

        }

        public boolean validate() {
            if(age>24 && psp<70) {
                return false;
            }
            if(age<18){
                return false;
            }
            return true;

        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public double getPsp() {
            return psp;
        }

        public String getGender() {
            return gender;
        }

        private String name;
        private int age;
        private String address;
        private double psp;
        private String gender;


    }


}
