package com.example.demo;

import org.junit.Test;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/20/16:41
 * @Description:
 */
public class Circle {   // 外部类

    private double radius = 0;

    public static int count = 1;

    public String name = "Circle";

    public class Draw {  // 内部类
        //成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
        public void drawSahpe() {
            String name = "Draw";

            System.out.println(radius + "drawSahpe"); // 外部类的private成员
            System.out.println("count:" + count); // 外部类的静态成员

            System.out.println("name:" + name);
            // 当成员内部类拥有和外部类同名的成员变量或者方法时，会发生隐藏现象，
            // 即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问
            // 外部类.this.成员变量
            // 外部类.this.成员方法
            System.out.println("name1:"+Circle.this.name);

        }

        public class InnerDraw{

            public void test(){
                System.out.println("11111111");
            }
        }
    }

    @Test
    public void test(){
        // 虽然成员内部类可以无条件地访问外部类的成员，而外部类想访问成员内部类的成员却不是这么随心所欲了。
        // 在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问
        Draw draw = new Draw();
        draw.drawSahpe();
        System.out.println(name);

        // 成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是必须存在一个外部类的对象。
        // 创建成员内部类对象的一般方式如下
        Draw.InnerDraw innerDraw = new Draw().new InnerDraw();
        innerDraw.test();

    }


}
