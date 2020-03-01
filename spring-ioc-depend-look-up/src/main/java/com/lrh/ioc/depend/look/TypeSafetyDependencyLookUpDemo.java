package com.lrh.ioc.depend.look;

import com.lrh.ioc.depend.look.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 安全与分安全的依赖查找
 *
 */
public class TypeSafetyDependencyLookUpDemo {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(TypeSafetyDependencyLookUpDemo.class);
        annotationConfigApplicationContext.refresh();

        displayObjectFactoryGetBean(annotationConfigApplicationContext);
        displayObjectProviderGetBean(annotationConfigApplicationContext);
        displayObjectFactoryGetBean(annotationConfigApplicationContext);
        displayListableBeanFactoryGetBean(annotationConfigApplicationContext);


        annotationConfigApplicationContext.close();
    }

    /**
     * 通过ListableBeanFactory 依赖查找 -> 安全的
     * @param annotationConfigApplicationContext
     */
    private static void displayListableBeanFactoryGetBean(ListableBeanFactory annotationConfigApplicationContext) {
        displayBeansException("displayListableBeanFactoryGetBean",() -> annotationConfigApplicationContext.getBeansOfType(User.class));
    }

    /**
     * 通过ObjectProvider 的依赖查找 -> 安全的
     * @param annotationConfigApplicationContext
     */
    private static void displayObjectProviderGetBean(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        ObjectProvider<User> beanProvider = annotationConfigApplicationContext.getBeanProvider(User.class);
        displayBeansException("displayObjectProviderGetBean",() -> beanProvider.getIfAvailable());
    }

    /**
     * 通过ObjectFactory 的依赖查找 -> 非安全的
     *
     * @param annotationConfigApplicationContext
     */
    private static void displayObjectFactoryGetBean(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        ObjectFactory<User> objectFactory = annotationConfigApplicationContext.getBeanProvider(User.class);
        displayBeansException("displayObjectFactoryGetBean:",() -> objectFactory.getObject());
    }

    /**
     * 通过BeanFactory 的依赖查找    -> 非安全
     * @param beanFactory
     */
    public static void displayObjectFactoryGetBean(BeanFactory beanFactory) throws InterruptedException {
        displayBeansException("displayBeanFactoryGetBean:",() -> beanFactory.getBean(User.class));
    }

    private static void displayBeansException(String source, Runnable runnable) {
        System.err.println("来源："+ source);
        System.err.println("==================================");
        try {
            runnable.run();
        } catch (BeansException e) {

            e.printStackTrace();
        }

    }


}
