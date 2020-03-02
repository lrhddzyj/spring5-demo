package com.lrh.spring.dependency.source;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

public class DependencySourceDemo {



    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private ApplicationContext applicationContext;


    @Autowired
    private ResourceLoader resourceLoader;


    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;



    @PostConstruct
    public void init(){
        System.out.println("beanFactory == applicationContext: " + (beanFactory == applicationContext));
        System.out.println("beanFactory == applicationContext.getAutowireCapableBeanFactory(): " + (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("beanFactory == resourceLoader: " + (beanFactory == resourceLoader));
        System.out.println("beanFactory == applicationEventPublisher: " + (beanFactory == applicationEventPublisher));
        System.out.println("applicationContext == resourceLoader: " + (applicationContext == resourceLoader));
        System.out.println("applicationContext == applicationEventPublisher: " + (applicationContext == applicationEventPublisher));
        System.out.println("resourceLoader == applicationEventPublisher: " + (resourceLoader == applicationEventPublisher));
    }

    @PostConstruct
    public void initByLookUp(){
        getBean(BeanFactory.class);
        getBean(ApplicationContext.class);
        getBean(ResourceLoader.class);
        getBean(ApplicationEventPublisher.class);
    }

    public <T> T getBean(Class<T> beanType){
        try {
            return beanFactory.getBean(beanType);
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("当前类型" + beanType.getName() + "无法在BeanFactory中被找到!");
            return null;
        }
    }




    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(DependencySourceDemo.class);
        annotationConfigApplicationContext.refresh();
        annotationConfigApplicationContext.close();
    }
}
