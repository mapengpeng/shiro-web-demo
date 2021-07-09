package com.mapp.demo.controller;


import cn.hutool.core.util.StrUtil;
import com.mapp.shiro.util.EncryUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 密码加密
 */
@RestController
public class EncryPasswordController {

    @RequestMapping("/doEncryPassword")
    public String encrypassword(String password) {
       if (StrUtil.isEmpty(password)) {
           password = "888888";
       }

       return EncryUtil.encryPwd(password);
    }
}
