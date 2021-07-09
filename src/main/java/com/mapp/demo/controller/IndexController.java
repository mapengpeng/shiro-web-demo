package com.mapp.demo.controller;


import com.mapp.shiro.config.ShiroConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {

    /**
     * get,post都走此处入口
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/403")
    public String unauthorizedUrl() {
        return "403";
    }

    @RequestMapping("/onlineUser")
    public String onlineUser() {
        return "onlineUser";
    }

    @RequestMapping("/dynamicAuthor")
    public String dynamicAuthor() {
        return "dynamicAuthor";
    }

    @RequestMapping("/encrypwd")
    public String encrypwd() {
        return "encrypwd";
    }

    @RequestMapping("/forceLogout")
    public String forceLogout(HttpServletRequest request) {
        request.setAttribute(ShiroConstants.DEFAULT_ERROR_MSG_ATTRIBUTE_NAME, ShiroConstants.FORCE_LOGOUT_ERROR_MSG);
        return "login";
    }

    @RequestMapping("/kickout")
    public String kickout(HttpServletRequest request) {
        request.setAttribute(ShiroConstants.DEFAULT_ERROR_MSG_ATTRIBUTE_NAME, ShiroConstants.KICKOUT_ERROR_MSG);
        return "login";
    }

}
