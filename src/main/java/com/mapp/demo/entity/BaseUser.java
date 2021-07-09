package com.mapp.demo.entity;

import com.mapp.shiro.entity.UserDetail;
import lombok.Data;

/**
 * 用户实体 实现 UserDetail接口
 */
@Data
public class BaseUser implements UserDetail {

    private String username;
    private String password;

    private String sex;
    private String tel;
    private int age;
    private String address;


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
