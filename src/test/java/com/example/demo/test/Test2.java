package com.example.demo.test;

import org.junit.Test;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/20/15:36
 * @Description:
 */
public class Test2 {

    private int age;

    public void say(){
        String name = "myy";
        //局部内部类
        class InnerClass{
            public void hello(){
                System.out.println(name + "你好");
            }
        }
        //想要使用局部内部类还是需要new的
        InnerClass tClass = new InnerClass();
        tClass.hello();
        System.out.println("这个方法中包含局部内部类");
    }


    @Test
    public void test(){
        MyInterface myInterface = new MyInterface() {
            @Override
            public void sayHello() {
                System.out.println("aaaaaaa");
            }
        };
        myInterface.sayHello();


        MyClass myClass = new MyClass();
        myClass.age = 10;
        myClass.hello();
    }
}
