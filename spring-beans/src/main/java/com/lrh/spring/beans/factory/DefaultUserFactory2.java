package com.lrh.spring.beans.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultUserFactory2 implements UserFactory, InitializingBean, DisposableBean {


    // 1基于@PostConstruct 的注解初始化
    @PostConstruct
    public void  init(){
        System.out.println("DefaultUserFactory2 基于 @PostConstruct 初始化中....");
    }

    //2 自定义初始化方法
    public void initUserFactory() {
        System.out.println("DefaultUserFactory2  基于注解Bean init-method 指定初始化....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DefaultUserFactory2 基于InitializingBean#afterPropertiesSet 初始化...");
    }


    @PreDestroy
    public void close(){
        System.out.println("DefaultUserFactory2 基于 @PreDestroy 销毁中....");
    }


    //2 自定义初始化方法
    public void preClose() {
        System.out.println("DefaultUserFactory2  基于注解Bean destroy-method 指定销毁....");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DefaultUserFactory2 DisposableBean#destroy 销毁...");
    }
}
