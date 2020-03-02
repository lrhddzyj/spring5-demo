package com.lrh.ioc.dependence.inject;

import com.lrh.ioc.dependence.inject.annotation.CustomerInjected;
import com.lrh.ioc.dependence.inject.annotation.MyCustomerAutowired;
import com.lrh.ioc.dependence.inject.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;
import javax.inject.Inject;

public class CustomerInjectAnnotationDemo {

    @Resource(name = "user1")
    private User user1;

    @Autowired
    private User user2;

    @Inject
    private ObjectProvider<User> users;


    @MyCustomerAutowired
    private User user3;

    @CustomerInjected
    private User user4;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CustomerInjectAnnotationDemo.class);

        applicationContext.refresh();


        CustomerInjectAnnotationDemo demo = applicationContext.getBean(CustomerInjectAnnotationDemo.class);
        System.out.println(demo.user1);
        System.out.println(demo.user2);
        System.out.println(demo.user3);
        System.out.println(demo.user4);

        applicationContext.close();

    }


    /**
     *  Bean 用 static 定义的情况下会提前注入Bean
     * @return
     */
    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE - 3)
    public static AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor(){
        AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationType(CustomerInjected.class);
        return autowiredAnnotationBeanPostProcessor;
    }



    @Bean
    public User user1(){
        User user = new User();
        user.setId("1");
        user.setName("A");
        return user;
    }


     @Bean
    public User user2(){
        User user = new User();
        user.setId("2");
        user.setName("B");
        return user;
    }

    @Bean
    public User user3(){
        User user = new User();
        user.setId("3");
        user.setName("C");
        return user;
    }

    @Bean
    public User user4(){
        User user = new User();
        user.setId("4");
        user.setName("D");
        return user;
    }









}