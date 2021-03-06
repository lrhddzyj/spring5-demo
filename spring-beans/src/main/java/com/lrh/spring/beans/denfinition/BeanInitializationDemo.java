package com.lrh.spring.beans.denfinition;

import com.lrh.spring.beans.factory.DefaultUserFactory2;
import com.lrh.spring.beans.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Bean 初始化 示例
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(BeanInitializationDemo.class);

        annotationConfigApplicationContext.refresh();

        annotationConfigApplicationContext.close();
    }


    @Bean(initMethod = "initUserFactory")
    public DefaultUserFactory2 userFactory2(){
        return new DefaultUserFactory2();
    }



}
