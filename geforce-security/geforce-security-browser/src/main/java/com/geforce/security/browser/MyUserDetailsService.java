package com.geforce.security.browser;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author geforce
 * @date 2017/11/9
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登陆用户名:"  + username);
        if (StringUtils.isBlank(username)){
            throw new UsernameNotFoundException("用户名不能为空");
        }
        String password = passwordEncoder.encode("123");
        logger.info("数据库的密码是:"+password);
        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));


    }
}
