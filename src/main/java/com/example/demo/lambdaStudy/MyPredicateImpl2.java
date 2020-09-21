package com.example.demo.lambdaStudy;

import com.example.demo.entity.Employee;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/18/19:45
 * @Description:
 */
public class MyPredicateImpl2 implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
