package com.lrh.spring.beans.denfinition;

import com.lrh.spring.beans.factory.DefaultUserFactory2;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 外部单体Bean 注册实例
 */
public class SingleBeanRegisterBeanDemo {


    public static void main(String[] args) {


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(SingleBeanRegisterBeanDemo.class);

        DefaultUserFactory2 defaultUserFactory2 = new DefaultUserFactory2();
        ConfigurableListableBeanFactory configurableListableBeanFactory = annotationConfigApplicationContext.getBeanFactory();
        configurableListableBeanFactory.registerSingleton("userFactory2", defaultUserFactory2);

        System.out.println("Spring 应用已启动.....");
        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBean("userFactory2", DefaultUserFactory2.class));
        System.out.println(annotationConfigApplicationContext.getBean("userFactory2", DefaultUserFactory2.class) == defaultUserFactory2);


        annotationConfigApplicationContext.close();
    }


}
