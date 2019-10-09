package com.xinao.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: houyong
 * @Date: 2019/10/07 16:10
 * @describe
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            return null;
        }

        //取出正确密码，这里暂时使用静态密码
        String password = passwordEncoder.encode("123");


        //权限标识串,静态添加
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("admin");
        grantedAuthorities.add(authority);

        User userDetails = new User(username, password, grantedAuthorities);
        return userDetails;
    }
}
