package com.lrh.spring.bean.lifecycle;

import com.lrh.spring.bean.lifecycle.domain.User;
import com.lrh.spring.bean.lifecycle.domain.VipUser;
import com.lrh.spring.bean.lifecycle.processor.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 *  Bean 实例化前 的演示Demo
 * {@link InstantiationAwareBeanPostProcessor}
 */
public class BeanInstantiationLifecycleDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlPath = "classpath:/META-INF/bean-instantiation-lifecycle2.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);


        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        VipUser vipUser = beanFactory.getBean("vipUser", VipUser.class);
        System.out.println(vipUser);

    }









}
