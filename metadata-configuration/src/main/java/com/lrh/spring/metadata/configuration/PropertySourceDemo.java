package com.lrh.spring.metadata.configuration;

import com.lrh.spring.metadata.configuration.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

@PropertySource(value = "classpath:/META-INF/user.properties")
public class PropertySourceDemo {

    @Bean
    public User user(@Value("${user.name}") String name, @Value("${user.age}") Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        MutablePropertySources propertySources = applicationContext.getEnvironment().getPropertySources();
        //添加Properties 操作必须在refresh 方法前完成
        Map<String, Object> properties = new HashMap<>();
        properties.put("user.age", 1000);
        org.springframework.core.env.PropertySource propertySource = new MapPropertySource("customer-properties", properties);
        propertySources.addFirst(propertySource);

        applicationContext.register(PropertySourceDemo.class);

        applicationContext.refresh();

        User user = applicationContext.getBean("user", User.class);

        System.out.println(user);

        System.out.println(propertySources);

        applicationContext.close();
    }

}
