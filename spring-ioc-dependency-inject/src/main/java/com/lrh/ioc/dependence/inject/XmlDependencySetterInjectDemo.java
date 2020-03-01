package com.lrh.ioc.dependence.inject;

import com.lrh.ioc.dependence.inject.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml 依赖setter的依赖注入
 */
public class XmlDependencySetterInjectDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String xmlPath = "classpath:/META-INF/xml-dependency-inject.xml";
        xmlBeanDefinitionReader.loadBeanDefinitions(xmlPath);

        UserHolder userHolder = defaultListableBeanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }

}
