package com.lrh.spring.metadata.configuration;

import com.lrh.spring.metadata.configuration.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 *
 * 基于注解的yaml 的 外部化配置 demo
 */
@PropertySource(name = "yamlProperty",value = "classpath:/META-INF/user.yaml",factory = YamlPropertySourceFactory.class)
public class AnnotationYamlPropertySourceDemo {

    @Bean
    public User user(@Value("${user.name}") String name, @Value("${user.age}") Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationYamlPropertySourceDemo.class);
        applicationContext.refresh();

        System.out.println(applicationContext.getEnvironment().getPropertySources());
        User user = applicationContext.getBean("user", User.class);
        System.out.println(user);

        applicationContext.close();

    }

}
