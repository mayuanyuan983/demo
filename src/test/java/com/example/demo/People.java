package com.example.demo;

public class People {

    public void test(){
        // 局部内部类
        // 局部内部类就像是方法里面的一个局部变量一样，是不能有 public、protected、private 以及 static 修饰符的。
        class Man{
            int age = 1;
        }
    }
}
