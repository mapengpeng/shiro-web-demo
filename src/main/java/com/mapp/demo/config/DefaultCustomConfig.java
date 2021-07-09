package com.mapp.demo.config;

import com.mapp.demo.service.BaseAuthorityServiceImpl;
import com.mapp.demo.service.BaseUserServiceImpl;
import com.mapp.shiro.config.CustomConfig;
import com.mapp.shiro.provider.AuthorityService;
import com.mapp.shiro.provider.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import java.util.Map;

/**
 * 引入starter的项目必须实现该接口
 */
@Component
public class DefaultCustomConfig implements CustomConfig {

    @Autowired
    private BaseUserServiceImpl userService;
    @Autowired
    private BaseAuthorityServiceImpl authorityService;

    /**
     * 获取用户信息实现类
     * @return
     */
    @Override
    public UserDetailService getUserDetailService() {
        return userService;
    }

    /**
     * 获取权限信息实现类
     * @return
     */
    @Override
    public AuthorityService getAuthorityService() {
        return authorityService;
    }

    /**
     * 自定义shiro过滤器
     * @return
     */
    @Override
    public Map<String, Filter> getFilters() {
        return null;
    }

    /**
     * 自定义shiro过滤器规则
     * @return
     */
    @Override
    public Map<String, String> getFilterChainDefinition() {
        return null;
    }

}
