package com.example.demo.lambdaStudy;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/18/19:38
 * @Description:
 */
@FunctionalInterface
public interface MyPredicate<T> {

    public boolean test(T t);


}
