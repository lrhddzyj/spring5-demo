package com.lrh.ioc.dependence.inject;

import com.lrh.ioc.dependence.inject.domain.User;
import com.lrh.ioc.dependence.inject.domain.UserHolder;
import com.lrh.ioc.dependence.inject.domain.UserHolder2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * Api 依赖注入
 */
public class ApiDependencyConstructorInjectDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApiDependencyConstructorInjectDemo.class);

        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();

        //注册Bean
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        applicationContext.refresh();

        Map<String, UserHolder2> beansOfType = applicationContext.getBeansOfType(UserHolder2.class);
        System.out.println(beansOfType);

        applicationContext.close();
    }


    //创建BeanDefinition constructor 注入bean引用
    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder2.class);
        beanDefinitionBuilder.addConstructorArgReference("user");
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
