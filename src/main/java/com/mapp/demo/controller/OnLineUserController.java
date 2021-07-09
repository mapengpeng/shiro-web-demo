package com.mapp.demo.controller;

import com.mapp.shiro.entity.OnLineUser;
import com.mapp.shiro.util.ShiroUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OnLineUserController {

    @RequestMapping("/getOnlineUser")
    public Object getOnlineUser() {
        Map<String, Object> res = new HashMap<>();
        List<OnLineUser> onLineUser = ShiroUtil.getOnLineUser();

        res.put("count", onLineUser.size());
        res.put("data", onLineUser);
        res.put("code", 0);
        res.put("msg", "");

        return res;
    }

    @RequestMapping("/doForceLogout")
    public Object doForceLogout(String sessionId) {

        ShiroUtil.forceLogout(sessionId);

        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("msg", "强制退出成功！");
        return res;
    }
}
