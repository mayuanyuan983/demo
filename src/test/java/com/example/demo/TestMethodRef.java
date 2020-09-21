package com.example.demo;

import com.example.demo.entity.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/19/9:37
 * @Description:
 * 一、方法引用：若Lambda 体中的内容方法已经实现了，我们可以使用方法引用
 * 可以理解为方法引用是Lambda 表达式的另外一种表现形式
 *
 * 主要有三种语法格式：
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 * 注意：
 * Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * 若Lambda 参数列表中的第一参数是实例方法的调用者，第二个参数是实例方法的参数时，可以使用ClassName::method
 *
 * 二、构造器引用
 *
 * 格式：
 * ClassName::new
 *
 * 注意：需要调用的构造器的参数列表要与函数式接口的抽象方法的参数列表保持一致
 *
 * 三、数组引用
 *
 * Type::new    Type:类型
 */
public class TestMethodRef {

    @Test
    public void test1(){
        Consumer<String> con = x -> System.out.println(x);

        //println是实例方法
        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        PrintStream ps1 = System.out;
        Consumer<String> con2 = x -> ps1.println(x);

        //参数列表和返回值类型要完全一致
        Consumer<String> con3 = System.out::println;
        con3.accept("aaaa");
    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        System.out.println(sup2.get());
    }

    //类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println(com.compare(3,2));

        Comparator<Integer> com1 = Integer::compare;
        System.out.println(com1.compare(1,3));
    }

    //类::实例方法名
    //两个参数，第一个参数是实例方法的调用者，第二个参数是实例方法的参数
    @Test
    public void test4(){
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("aa", "aa"));
    }

    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> sup = () -> new Employee();

        //构造器引用--无参构造
        Supplier<Employee> sup2 = Employee::new;
        Employee emp = sup.get();
        //打印内存地址-->重写toString方法
        System.out.println(emp);

    }
    @Test
    public void test6(){
        //调用哪个构造器，取决于函数式接口的参数列表
        Function<Integer, Employee> fun = (x) -> new Employee(x);

        Function<Integer, Employee> fun1 = Employee::new;
        Employee emp = fun1.apply(202);
        System.out.println(emp);

        BiFunction<Integer, Integer, Employee> bf = Employee::new;
        Employee emp1 = bf.apply(1,33);
        System.out.println(emp1);

    }

    //数组引用
    @Test
    public void test7(){
        Function<Integer,String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs2.length);
    }
}
