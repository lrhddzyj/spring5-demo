package com.lrh.ioc.dependence.inject;

import com.lrh.ioc.dependence.inject.domain.User;
import com.lrh.ioc.dependence.inject.domain.UserHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * 注解方式 构造函数 和 setter 依赖注入
 *
 */
public class AnnotationDependencySetterInjectDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencySetterInjectDemo.class);

        applicationContext.refresh();
        Map<String, UserHolder> beansOfType = applicationContext.getBeansOfType(UserHolder.class);
        System.out.println(beansOfType);
        applicationContext.close();
    }


    //setter方式注入
    @Bean
    public UserHolder userHolder2(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId("111");
        user.setName("111-name");
        return user;
    }



}
