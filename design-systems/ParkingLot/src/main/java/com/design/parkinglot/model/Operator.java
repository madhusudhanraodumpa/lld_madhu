package com.design.parkinglot.model;

public class Operator extends BaseModel{
    private String name;
    private Long empId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }
}
