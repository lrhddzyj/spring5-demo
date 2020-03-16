package com.lrh.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * 注解的Bean 定义
 */
public class AnnotatedBeanDefinitionAfterDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beforeBeanDefinitionCount = beanFactory.getBeanDefinitionCount();
        annotatedBeanDefinitionReader.registerBean(AnnotatedBeanDefinitionAfterDemo.class);
        int afterBeanDefinitionCount = beanFactory.getBeanDefinitionCount();
        int count = afterBeanDefinitionCount - beforeBeanDefinitionCount;
        System.out.println("读取BeanDefinition 的数量: " + count);

        AnnotatedBeanDefinitionAfterDemo demo = beanFactory.getBean("annotatedBeanDefinitionParsingDemo", AnnotatedBeanDefinitionAfterDemo.class);
        System.out.println(demo);

    }
}
