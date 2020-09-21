package com.example.demo.entity;

import lombok.Data;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/18/19:27
 * @Description:
 */
@Data
public class Employee {

    private  int id;

    private String name;

    private int age;

    private double salary;

    public Employee() {
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee(int age) {
        this.age = age;
    }

    public Employee(int id, int age) {
        this.id = id;
        this.age = age;
    }
}
