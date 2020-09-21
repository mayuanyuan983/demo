package com.example.demo.lambdaStudy;

import com.example.demo.entity.Employee;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/18/19:39
 * @Description:
 */
public class MyPredicateImpl implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
