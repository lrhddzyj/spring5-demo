package com.lrh.spring.beans.denfinition;

import com.lrh.spring.beans.factory.DefaultUserFactory2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * 非延迟初始化：容器启动之前已经初始化
 *
 * 延迟初始化：容易启动之后 使用的时候初始化
 */
public class BeanLazyInitializationDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(BeanLazyInitializationDemo.class);

        annotationConfigApplicationContext.refresh();
        System.out.println("Spring 应用已启动.....");

        annotationConfigApplicationContext.getBean("userFactory2");

        annotationConfigApplicationContext.close();
    }


    @Bean(initMethod = "initUserFactory")
    @Lazy
    public DefaultUserFactory2 userFactory2(){
        return new DefaultUserFactory2();
    }


}
