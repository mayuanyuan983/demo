package com.example.demo.service;

import com.example.demo.entity.UserCreateVO;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/13/20:47
 * @Description:
 */

@Service
@Validated
public class UserService {
    public Long createUser(@Valid UserCreateVO create) {
        // TODO: 创建用户
        return null;
    }
}