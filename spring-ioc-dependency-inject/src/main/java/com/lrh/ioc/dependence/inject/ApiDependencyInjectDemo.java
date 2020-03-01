package com.lrh.ioc.dependence.inject;

import com.lrh.ioc.dependence.inject.domain.User;
import com.lrh.ioc.dependence.inject.domain.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * Api 依赖注入
 */
public class ApiDependencyInjectDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApiDependencyInjectDemo.class);

        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();

        //注册Bean
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        applicationContext.refresh();

        Map<String, UserHolder> beansOfType = applicationContext.getBeansOfType(UserHolder.class);
        System.out.println(beansOfType);

        applicationContext.close();
    }


    //创建BeanDefinition 注入BEAN引用
    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addPropertyReference("user", "user");
        return beanDefinitionBuilder.getBeanDefinition();
    }


    @Bean
    public User user() {
        User user = new User();
        user.setId("111");
        user.setName("111-name");
        return user;
    }

}
