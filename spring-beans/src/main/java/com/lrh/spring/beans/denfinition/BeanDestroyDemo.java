package com.lrh.spring.beans.denfinition;

import com.lrh.spring.beans.factory.DefaultUserFactory;
import com.lrh.spring.beans.factory.DefaultUserFactory2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class BeanDestroyDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(BeanDestroyDemo.class);

        annotationConfigApplicationContext.refresh();
        System.out.println("Spring 应用已启动.....");

        annotationConfigApplicationContext.getBean("defaultUserFactory2");

        System.out.println("Spring 准备关闭.....");

        annotationConfigApplicationContext.close();
        System.out.println("Spring 已关闭.....");
    }


    @Bean(destroyMethod = "preClose",initMethod = "initUserFactory")
    public DefaultUserFactory2 defaultUserFactory2(){
        return new DefaultUserFactory2();
    }



}
