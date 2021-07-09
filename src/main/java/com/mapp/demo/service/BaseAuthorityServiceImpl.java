package com.mapp.demo.service;

import com.mapp.shiro.entity.Authority;
import com.mapp.shiro.provider.AuthorityService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * 实现权限接口
 */
@Component
public class BaseAuthorityServiceImpl implements AuthorityService {

    private Set<Authority> authorities = new HashSet();

    @PostConstruct
    public void init() {
        Authority one = new Authority();
        one.setUrl("/user/index");
        one.setRoles("ADMIN,TEST,OTHER");
        Authority two = new Authority();
        two.setUrl("/onLineUser");
        two.setRoles("ADMIN");
        authorities.add(one);
        authorities.add(two);
    }

    /**
     * 角色权限绑定
     *
     * roles[ADMIN,OTHER,...]
     *
     * url ： 请求资源地址
     * roles :  访问该资源需要的角色，读多个角色，逗号（,）分开
     *
     * /user/index => ADMI,TEST,OTHER,...
     */
    @Override
    public Set<Authority> getAuthorityList() {
        return authorities;
    }
}
