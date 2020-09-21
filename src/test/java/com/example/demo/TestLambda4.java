package com.example.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/18/21:31
 * @Description:
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> ：消费型接口
 *      void accept(T t); ---有参数，无返回值
 * Supplier<T>：供给型接口
 *      T get(); ---无参数，有返回值
 * Function<T, R> ：函数型接口
 *      R apply(T t); ---有参数，有返回值
 * Predicate<T>：断言型接口
 *      boolean test(T t); ---返回boolean
 *
 *
 *      BiPredicate<T, U>
 */
public class TestLambda4 {

    //Consumer<T> ：消费型接口
    @Test
    public void test1(){
        happy(10000, m -> System.out.println("111111"));
    }


    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    //Supplier<T>：供给型接口
    @Test
    public void test2(){
        List<Integer> list = getNumList(10,() -> (int) Math.random() * 100);
        list.forEach(System.out::println);
    }

    //产生指定个整数放入集合
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    //Function<T, R> ：函数型接口
    @Test
    public void test3(){
        String newStr = strHandler("sss", str -> str.toUpperCase());
        System.out.println(newStr);
    }

    //用于处理字符串
    public String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }

    //Predicate<T>：断言型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Je","JJss","ww");
        List<String> strList = filterStr(list, str -> str.length() > 3);
        System.out.println(strList);
    }

    //将满足条件的字符串放入集合
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for(String str : list){
            if(pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }
}
