package com.xinao.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: houyong
 * @Date: 2019/9/24 11:26
 * @describe
 */
@RestController
public class TestController {

    /**
     * 该用户有此权限
     * @param
     * @return
     */
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('admin')")
    public String success() {
        return "success";
    }


    /**
     * 该用户没有此权限
     * @param
     * @return
     */
    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('fail')")
    public String fail() {
        return "fail";
    }


    /**
     * 该接口放行,已经在resourceconfig中配置，不做限制
     * @param
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        return "success";
    }
}
