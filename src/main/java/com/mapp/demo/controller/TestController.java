package com.mapp.demo.controller;

import com.mapp.shiro.entity.Authority;
import com.mapp.shiro.util.ShiroUtil;
import com.mapp.shiro.util.StaticData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/getVersion")
    public Object getVersion() {
        Map<String, String> res = new HashMap<>();
        res.put("version", "0.1");
        res.put("name", "皮皮马权限管理系统");
        res.put("author", "mapp");

        return res;
    }

    @RequestMapping("/saveAuthorty")
    public Object saveAuthorty(Authority authority) {
        // 模拟数据库新增
        StaticData.AUTHORITIES.add(authority);
        // 重新加载权限
        ShiroUtil.reloadFilterChainDefinitionMap();

        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("msg", "权限设置成功！");
        return res;
    }
}
