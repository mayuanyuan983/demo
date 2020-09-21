package com.example.demo;

import com.example.demo.entity.Employee;
import com.example.demo.lambdaStudy.MyFunction;
import com.example.demo.lambdaStudy.MyFunction2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/18/20:44
 * @Description:
 */
public class TestLambda3 {

    List<Employee> employss = Arrays.asList(
            new Employee("张三", 78 , 9999.99),
            new Employee("李四", 88 , 5552.12),
            new Employee("王五", 78 , 8888.99),
            new Employee("赵六", 98 , 1898.99),
            new Employee("田七", 58 , 4543.22)
    );

    @Test
    public void test(){
        Collections.sort(employss, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        employss.forEach(System.out::println);
    }

    //需求：用于处理字符串
    @Test
    public void test2(){
        String trimStr = strHandler("/1tt t2   ",str -> str.trim());
        System.out.println(trimStr);

        String upper = strHandler("adsss", str -> str.toUpperCase());
        System.out.println(upper);

        String newStr = strHandler("嘻嘻hhhhhhhhhhh", str -> str.substring(2,5));
        System.out.println(newStr);
    }

    public String strHandler(String str, MyFunction mf){
        return mf.getValue(str);
    }


    //需求 对于两个Long型数据进行处理
    @Test
    public void test3(){
        op(100L, 200L, (x,y) -> x + y);

        op(100L, 200L, (x,y) -> x * y);
    }

    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf){
        System.out.println(mf.getValue(l1, l2));
    }
}
