package com.example.demo;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/20/22:04
 * @Description:
 */
public class StaticTest {
    private static int a = 0;

    private int b = 0;

    static public class StatiTest1{
        public void t(){
            System.out.println(a);

        }
    }

    public void t(){
        StatiTest1 statiTest1 = new StatiTest1();
        statiTest1.t();

        T1.T2 t2 = new T1.T2();
        ;
    }


    public static class T1{

        static public class T2{


        }
    }
}
