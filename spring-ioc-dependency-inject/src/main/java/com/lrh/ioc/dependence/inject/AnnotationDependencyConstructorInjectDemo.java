package com.lrh.ioc.dependence.inject;

import com.lrh.ioc.dependence.inject.domain.User;
import com.lrh.ioc.dependence.inject.domain.UserHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class AnnotationDependencyConstructorInjectDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencySetterInjectDemo.class);

        applicationContext.refresh();
        Map<String, UserHolder> beansOfType = applicationContext.getBeansOfType(UserHolder.class);
        System.out.println(beansOfType);
        applicationContext.close();
    }


    //构造器的方式注入
    @Bean
    public UserHolder userHolder(User user) {
        return new UserHolder(user);
    }


    @Bean
    public User user() {
        User user = new User();
        user.setId("111");
        user.setName("111-name");
        return user;
    }

}
