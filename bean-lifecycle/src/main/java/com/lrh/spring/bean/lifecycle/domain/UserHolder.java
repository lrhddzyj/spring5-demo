package com.lrh.spring.bean.lifecycle.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserHolder implements BeanNameAware, BeanClassLoaderAware,
        BeanFactoryAware, InitializingBean , SmartInitializingSingleton,DisposableBean {

    private User user;


    private String description;


    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * 依赖于注解驱动
     * 初始化之前就会调用注解的方法
     */
    @PostConstruct
    public void init(){
        this.description = "userHolder description v2";
        System.out.println("@PostConstruct : " + description);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.description = "userHolder description v3";
        System.out.println("InitializingBean.afterPropertiesSet() : " + description);
    }

    public void customerInitMethod(){
        this.description = "userHolder description v4";
        System.out.println(" customerInitMethod() : " + description);
    }

    @PreDestroy
    public void destroyMethod(){
        this.description = "userHolder description v7";
        System.out.println("@PreDestroy :" + description);
    }

    @Override
    public void destroy() throws Exception {
        this.description = "userHolder description v9";
        System.out.println("DisposableBean destroy :" + description);
    }

    public void customerDestroyMethod(){
        this.description = "userHolder description v10";
        System.out.println("customerDestroyMethod : " + description);
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                ", description='" + description + '\'' +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    private String beanName;
    private BeanFactory beanFactory;
    private ClassLoader classLoader;


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }


    //当所有的Bean初始化完成之后完成的回调接口
    @Override
    public void afterSingletonsInstantiated() {
        this.description = "userHolder description - v6";
        System.out.println("afterSingletonsInstantiated() : " + description);

    }


}
