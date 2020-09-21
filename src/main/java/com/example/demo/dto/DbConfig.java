package com.example.demo.dto;

import lombok.Data;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/21/21:09
 * @Description:
 */
@Data
public class DbConfig {
    private String driverClassName;

    private String url;

    private String userName;

    private String password;

    public DbConfig() {
    }

    public DbConfig(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
}
