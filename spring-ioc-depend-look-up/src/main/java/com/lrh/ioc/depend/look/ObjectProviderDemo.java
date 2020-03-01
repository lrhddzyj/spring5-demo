package com.lrh.ioc.depend.look;

import com.lrh.ioc.depend.look.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 * ObjectProvider 单一类型的查找 （延迟查找）
 *
 */
public class ObjectProviderDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ObjectProviderDemo.class);
        annotationConfigApplicationContext.refresh();

        lookUpWithObjectProvider(annotationConfigApplicationContext);
//        lookUpWithObjectProviderIfAvailable(annotationConfigApplicationContext);
        lookUpBeansWithObjectProviderIfAvailable(annotationConfigApplicationContext);

        annotationConfigApplicationContext.close();
    }


    /**
     * 单一Bean的查找
     * @param annotationConfigApplicationContext
     */
    private static void lookUpWithObjectProviderIfAvailable(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        ObjectProvider<User> beanProvider = annotationConfigApplicationContext.getBeanProvider(User.class);
        User u = beanProvider.getIfAvailable(User::createUser);
        System.out.println(u);

    }

    /**
     * 集合Bean的查找 Steam查找
     * @param annotationConfigApplicationContext
     */
    private static void lookUpBeansWithObjectProviderIfAvailable(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        ObjectProvider<User> beanProvider = annotationConfigApplicationContext.getBeanProvider(User.class);
        beanProvider.stream().forEach(System.out::println);
    }

    private static void lookUpWithObjectProvider(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        ObjectProvider<String> beanProvider = annotationConfigApplicationContext.getBeanProvider(String.class);
        System.out.println(beanProvider.getObject());
    }


    @Bean
    public User user(){
        User u = new User();
        u.setId("u");
        u.setName("@Bean 定义出来的BEAN");
        return u;
    }

    @Bean
    public User user2(){
        User u = new User();
        u.setId("u2");
        u.setName("@Bean 定义出来的BEAN");
        return u;
    }


    @Bean
    public String helloWorld(){
        return "helloWorld";
    }


}
