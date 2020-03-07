package com.lrh.spring.bean.scope;

import com.lrh.spring.bean.scope.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfiguration {

    @Bean
    @RequestScope
    public User requestScopeUser(){
        User user = new User();
        user.setName("RequestScope User");
        return user;
    }


    @Bean
    @SessionScope
    public User sessionScopeUser(){
        User user = new User();
        user.setName("SessionScope User");
        return user;
    }


    @Bean
    @ApplicationScope
    public User applicationScopeUser(){
        User user = new User();
        user.setName("ApplicationScope User");
        return user;
    }


}
