package com.mapp.demo.service;

import com.mapp.demo.entity.BaseUser;
import com.mapp.shiro.provider.UserDetailService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 实现用户信息接口
 */
@Component
public class BaseUserServiceImpl implements UserDetailService {

    private HashMap<String, BaseUser> userMap = new HashMap<>();

    @PostConstruct
    public void init() {
        BaseUser one = new BaseUser();
        one.setUsername("test");
        one.setPassword("cb4e19a385f2fb9dbb38a5e98ff96f0a1e10e5553436f41767927bce1eecb6b5");
        BaseUser two = new BaseUser();
        two.setUsername("admin");
        two.setPassword("cb4e19a385f2fb9dbb38a5e98ff96f0a1e10e5553436f41767927bce1eecb6b5");
        BaseUser three = new BaseUser();
        three.setUsername("admin3");
        three.setPassword("cb4e19a385f2fb9dbb38a5e98ff96f0a1e10e5553436f41767927bce1eecb6b5");
        this.userMap.put("test", one);
        this.userMap.put("admin", two);
        this.userMap.put("admin3", three);
    }

    @Override
    public BaseUser loadUserDetail(String username) {
        return this.userMap.get(username);
    }

    @Override
    public Set<String> getRoles(String username) {
        Set<String> roles = new HashSet();
        if ("admin".equalsIgnoreCase(username)) {
            roles.add("ADMIN");
        }

        return roles;
    }

    @Override
    public Set<String> getPermissions(String username) {
        Set<String> permissions = new HashSet();
        return permissions;
    }
}
