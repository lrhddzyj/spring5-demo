package com.lrh.spring.bean.lifecycle;

import com.lrh.spring.bean.lifecycle.domain.User;
import com.lrh.spring.bean.lifecycle.domain.VipUser;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * bean 的父子关系的merge
 */
public class MergedBeanDefinitionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlPath = "classpath:/META-INF/merged-bean-definition.xml";
        int i = xmlBeanDefinitionReader.loadBeanDefinitions(xmlPath);

        System.out.println("读取到BeanDefinition 的数量:" + i);

        User user = beanFactory.getBean("user", User.class);
        VipUser vipUser = beanFactory.getBean("vipUser", VipUser.class);

        System.out.println(user);
        System.out.println(vipUser);

    }

}
