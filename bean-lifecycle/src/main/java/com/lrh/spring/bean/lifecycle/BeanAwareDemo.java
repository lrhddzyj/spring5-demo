package com.lrh.spring.bean.lifecycle;

import com.lrh.spring.bean.lifecycle.domain.User;
import com.lrh.spring.bean.lifecycle.domain.UserHolder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 按照顺序Aware
 * 但只有后5个都需要ApplicationContext
 * {@link org.springframework.beans.factory.BeanNameAware}
 * {@link org.springframework.beans.factory.BeanClassLoaderAware}
 * {@link org.springframework.beans.factory.BeanFactoryAware}
 *
 * {@link org.springframework.context.EnvironmentAware}
 * {@link org.springframework.context.EmbeddedValueResolverAware}
 * {@link org.springframework.context.ResourceLoaderAware}
 * {@link org.springframework.context.ApplicationEventPublisherAware}
 * {@link org.springframework.context.MessageSourceAware}
 * {@link org.springframework.context.ApplicationContextAware}
 *
 *
 */
public class BeanAwareDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlPath = "classpath:/META-INF/bean-aware-lifecycle.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);

        User user = beanFactory.getBean("user", User.class);
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);

    }

}
