package com.example.demo.test;

import com.example.demo.TestLambda;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/20/15:12
 * @Description:
 */
public class Test1 {

    public void test (Product p)
    {
        System.out.println(p.getName()+"--------"+p.getPrice());
    }
    public static void main(String [ ] args )
    {
        Test1 as= new Test1 ();
        as.test(new Product()//此处实现接口并实现抽象方法
        {
            public double getPrice( )//实现方法
            {
                return 8888;
            }
            public String getName( )//实现方法
            {
                return "I can do it ";
            }

        });
    }


}
