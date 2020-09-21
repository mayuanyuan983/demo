package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.lambdaStudy.MyPredicate;
import com.example.demo.lambdaStudy.MyPredicateImpl;
import com.example.demo.lambdaStudy.MyPredicateImpl2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/18/19:20
 * @Description:
 */
public class TestLambda {

    /***
    * @Description 原来的匿名内部类
    * @Param []
    * @return void
    * @throws
    */
    @Test
    public void test1(){
        System.out.println("1");
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);

    }

    /***
    * @Description Lambda 表达式
    * @Param []
    * @return void
    * @throws
    */
    @Test
    public void test2(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //数组转集合
    List<Employee> employss = Arrays.asList(
            new Employee("张三", 18 , 9999.99),
            new Employee("李四", 28 , 5552.12),
            new Employee("王五", 38 , 8888.99),
            new Employee("赵六", 48 , 1898.99),
            new Employee("田七", 58 , 4543.22)
    );


    @Test
    public void test3(){
        List<Employee> list = filterEmployees(employss);
        for (Employee e: list) {
            System.out.println(e);
        }
    }

    //获取当前公司员工年领大于35的员工信息
    public List<Employee> filterEmployees(List<Employee> list){
        List<Employee> emps = new ArrayList<>();

        for (Employee e: employss) {
            if(e.getAge() >= 35){
                emps.add(e);
            }
        }

        return emps;
    }

    //获取当前公司员工工资大于5000的员工信息
    public List<Employee> filterEmployees2(List<Employee> list){
        List<Employee> emps = new ArrayList<>();

        for (Employee e: employss) {
            if(e.getSalary() >= 5000){
                emps.add(e);
            }
        }

        return emps;
    }

    //优化 设计模式-策略模式 给什么策略，按什么过滤
    @Test
    public void test4(){
        List<Employee> list = filterEmployee(employss, new MyPredicateImpl());

        for (Employee e : list){
            System.out.println(e);
        }
        System.out.println("-------------------");
        List<Employee> list1 = filterEmployee(employss, new MyPredicateImpl2());
        for (Employee e : list1){
            System.out.println(e);
        }
    }


    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp){
        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list) {
            if(mp.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }


    //优化二： 匿名内部类 不需要写一堆类
    @Test
    public void test5(){
        List<Employee> list = filterEmployee(employss, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });

        for (Employee e : list){
            System.out.println(e);
        }
    }

    //优化三 ：lambdab表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployee(employss, employee -> employee.getSalary() >= 5000);
        list.forEach(System.out::println);
    }

    //优化四：Stream API
    @Test
    public void test7(){
        employss.stream()
                .filter(employee -> employee.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("--------------------");

        employss.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
