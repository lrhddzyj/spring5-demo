package com.lrh.spring.bean.lifecycle;

import com.lrh.spring.bean.lifecycle.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * 面向资源 xml properties 或是http的管道资源
 * 元数据 properties 配置BeanDefinition
 *
 */
public class BeanMetadataConfigurationDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

//        String userProperties = "classpath:/META-INF/user.properties";
        String classpathProperties = "/META-INF/user.properties";

        Resource resource = new ClassPathResource(classpathProperties);
        //指定读取文件的编码
        EncodedResource encodedResource = new EncodedResource(resource,"gbk");
        int i = propertiesBeanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("加载了BeanDefinition的数量：" + i);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user.toString());

    }
}
