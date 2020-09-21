package com.example.demo;

import com.example.demo.lambdaStudy.MyFun;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/18/20:02
 * @Description:
 * Lambda 表达式的基础语法：Java8引入了一个新操作符 "->" 该操作符称为箭头操作符或Lambda 操作符
 * 箭头操作符将Lambda 表达式拆分成两部分：
 * 左侧：Lambda 表达式的参数列表 接口中抽象方法的参数列表
 * 右侧：Lambda 表达式中所需执行的功能，即Lambda 体 抽象方法实现的功能
 *
 * Lambda 必须需要接口的支持-----函数式接口--只能有一个方法
 *
 * 语法格式一：无参数，无返回值
 *      () -> System.out.println("Hello");
 *
 * 语法格式二：一参数，无返回值
 *      (x) -> System.out.println("Hello");
 *
 * 语法格式三：一个参数，小括号可以省略不写
 *      x -> System.out.println("Hello");
 *
 * 语法格式四：两个以上参数，有返回值，lambda体有多语句 需要写大括号
 *      Comparator<Integer> com = (x, y) -> {
 *             System.out.println("111");
 *             return Integer.compare(x, y);
 *      };
 * 语法格式五：Lambda 体只有一条语句，大括号和return 可以省略
 *
 * 语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即"类型推断"
 *      (Integer x, Integer y) -> Integer.compare(x, y);
 *
 * 二、Lambda 表达式需要”函数式接口“的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称之为函数式接口。可以使用注解@FunctionalInterface 修饰
 * @FunctionalInterface 可以检查这个接口是不是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1(){
        int num = 0; // jdk1.7前必须写上final --本质还是final
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello" + num);
            }
        };
        r.run();
        System.out.println("--------------");

        Runnable r1 = () -> System.out.println("Hello" + num);

        r1.run();
    }

    @Test
    public void test2(){
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("哈哈哈哈哈哈哈");
    }



    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
            return Integer.compare(x, y);
        };
        System.out.println(com.compare(1,2));;
    }

    @Test
    public void test4(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x,y);

        Comparator<Integer> com1 = (Integer x,Integer y) -> Integer.compare(x,y);
    }

    @Test
    public void test5(){
        //类型推断
        String[] args = {"aa", "bb"};

        List<String> list = new ArrayList<>();

        //jdk7不支持，因为jdk8对类型推断升级了，根据上下文推断类型
        show(new HashMap<>());
    }

    public void show(Map<String, Integer> map){

    }


    //需求。对一个树进行运算
    @Test
    public void test6(){
        Integer num = operation(100, x -> x * x);
        System.out.println(num);

        System.out.println(operation(200, y -> y + 200));
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }
}
