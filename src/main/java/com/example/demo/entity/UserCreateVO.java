package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: mayuanyuan
 * @Date: 2020/09/13/20:45
 * @Description:
 */
@Getter
@Setter
@ToString
public class UserCreateVO {
    @NotBlank(message = "用户名称不能为空")
    private String name;
    @NotNull(message = "公司标识不能为空")
    private Long companyId;
}
