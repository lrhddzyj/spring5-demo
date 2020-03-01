package com.lrh.ioc.depend.look;

import com.lrh.ioc.depend.look.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 层次性的依赖查找
 */
public class HierarchicalDependencyLookUpDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(HierarchicalDependencyLookUpDemo.class);
        BeanFactory parentBeanFactory = createParentBeanFactory();

        ConfigurableListableBeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();

        beanFactory.setParentBeanFactory(parentBeanFactory);

        annotationConfigApplicationContext.refresh();

        System.out.println("父 BeanFactory 中的 User bean :" + parentBeanFactory.getBean(User.class));

        System.out.println("当前 BeanFactory 中的 User bean :" + beanFactory.getBean(User.class));

        System.out.println("当前 ApplicationContext 中所有的 User bean :" + annotationConfigApplicationContext.getBeansOfType(User.class));

        System.out.println("当前 ApplicationContext 中的 User bean :" + annotationConfigApplicationContext.getBean(User.class));

        System.out.println("通过BeanFactoryUtils 实现层次性的查找：" + BeanFactoryUtils.beansOfTypeIncludingAncestors(beanFactory, User.class));

        //这里会报错 因为父BeanFactory 中有了一个User Bean 当前BeanFactory中也有一个User Bean 不唯一
        System.out.println("通过BeanFactoryUtils 实现层次性的查找：" + BeanFactoryUtils.beanOfTypeIncludingAncestors(beanFactory, User.class));

        annotationConfigApplicationContext.close();

    }


    @Bean(name = "user2")
    public User user(){
        User user = new User();
        user.setId("user2");
        user.setName("local Bean user2");
        return user;
    }


//    private static ApplicationContext createParentBeanFactory() {
//        return new ClassPathXmlApplicationContext("classpath:/META-INF/IocContainerOverview.xml");
//    }


    private static BeanFactory createParentBeanFactory() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:/META-INF/IocContainerOverview.xml");
        return defaultListableBeanFactory;
    }
}
