package com.lrh.spring.bean.scope.entity;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User implements BeanNameAware {

    private String id;

    private String name;

    private  transient String beanName;


    public String getBeanName() {
        return beanName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User createUser(){
        User user = new User();
        user.setId("1");
        user.setName("静态工厂方法创建");
        return user;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                '}';
//    }


    @PostConstruct
    public void init(){
        System.out.println("用户对象初始化!");
    }


    @PreDestroy
    public void close(){
        System.out.println(this.beanName + " 正在被销毁!");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
