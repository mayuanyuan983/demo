package com.example.demo.study;

import com.example.demo.entity.BaseUser;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/13/20:04
 * @Description:
 */
@Slf4j
public class CodeReview {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();

    }


    private static void test4() {
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // TODO: 处理line
            }
        } catch (IOException e) {
            log.error("读取文件异常", e);
        }
    }

    private static void test3() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("cities.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                // TODO: 处理line
            }
        } catch (IOException e) {
            log.error("读取文件异常", e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("关闭文件异常", e);
                }
            }
        }
    }

    private static void test2() {
        String phone = "15811112222";
        String title = isMember(phone) ? "会员" : "游客";
        System.out.println(title);
    }

    private static void test1() {
        String phone = "15811112222";
        String title;
        if (isMember(phone)) {
            title = "会员";
        } else {
            title = "游客";
        }
        System.out.println(title);
    }

    public static boolean isMember(String phone){

        return true;
    }
}
