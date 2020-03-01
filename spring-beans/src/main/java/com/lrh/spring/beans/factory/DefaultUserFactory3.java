package com.lrh.spring.beans.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class DefaultUserFactory3 implements UserFactory, DisposableBean {


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
    public void destroy() throws Exception {

    }
}
