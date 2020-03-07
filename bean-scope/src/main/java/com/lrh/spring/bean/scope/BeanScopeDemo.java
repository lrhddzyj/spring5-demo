package com.lrh.spring.bean.scope;

import com.lrh.spring.bean.scope.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;

public class BeanScopeDemo implements DisposableBean {


    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static User singletonUser() {
        return User.createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        return User.createUser();
    }

    @Autowired
    private User singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser2;

    @Autowired
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> users;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(BeanScopeDemo.class);

        annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean 名称 ： %s 在初始化后回调...%n", bean.getClass().getName(), beanName);
                    //实例化完成之后可以托管给其他的Bean 来执行销毁动作（当然只有Prototype模式才需要 singleton受spring容器托管）
                    return bean;
                }
            });

        });
        annotationConfigApplicationContext.refresh();

        scopeBeanLookUp(annotationConfigApplicationContext);
        scopeBeanInject(annotationConfigApplicationContext);

        annotationConfigApplicationContext.close();
    }

    private static void scopeBeanInject(AnnotationConfigApplicationContext applicationContext) {
        BeanScopeDemo demo = applicationContext.getBean(BeanScopeDemo.class);
        System.out.println("demo.singletonUser = " + demo.singletonUser);
        System.out.println("demo.singletonUser2 = " + demo.singletonUser2);
        System.out.println("demo.prototypeUser = "+ demo.prototypeUser);
        System.out.println("demo.prototypeUser1 = "+ demo.prototypeUser1);
        System.out.println("demo.prototypeUser2 = "+ demo.prototypeUser2);
        System.out.println("demo.users = "+ demo.users);
    }

    private static void scopeBeanLookUp(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        for (int i = 0; i < 3; i++) {
            Map<String,User> userBeanMap = annotationConfigApplicationContext.getBeansOfType(User.class);
            System.out.println("第" + i + "次查找");
            System.out.println(userBeanMap);
        }

        System.out.println();

    }

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;


    //管理本Bean中注入的Prototype bean 的销毁
    @Override
    public void destroy() throws Exception {
        this.prototypeUser.close();
        this.prototypeUser1.close();
        this.prototypeUser2.close();
        users.forEach((s, user) -> {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(s);
            if(beanDefinition.isPrototype()){
                user.close();
            }
        });
    }
}
