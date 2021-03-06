package com.lrh.spring.bean.lifecycle;

import com.lrh.spring.bean.lifecycle.domain.User;
import com.lrh.spring.bean.lifecycle.domain.UserHolder;
import com.lrh.spring.bean.lifecycle.domain.VipUser;
import com.lrh.spring.bean.lifecycle.processor.MyDestructionAwareBeanPostProcessor;
import com.lrh.spring.bean.lifecycle.processor.MyInitializationAwareBeanPostProcessor;
import com.lrh.spring.bean.lifecycle.processor.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 *
 * Bean 销毁的生命周期DEMO
 *
 */
public class BeanDestructionLifecycleDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new MyInitializationAwareBeanPostProcessor());
        beanFactory.addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());//插入的顺序决定了调用的顺序呢 可以与CommonAnnotationBeanPostProcessor换位置再试
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());//支持@PostConstruct @PreDestroy 注解

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String xmlPath = "classpath:/META-INF/bean-instantiation-lifecycle2.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlPath);


        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        VipUser vipUser = beanFactory.getBean("vipUser", VipUser.class);
        System.out.println(vipUser);
        UserHolder userHolder = beanFactory.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);


        //通常在ApplicationContext 中使用 ，refresh 启动方法中会显式的调用
        beanFactory.preInstantiateSingletons();

        beanFactory.destroyBean("userHolder",userHolder);

    }

}
