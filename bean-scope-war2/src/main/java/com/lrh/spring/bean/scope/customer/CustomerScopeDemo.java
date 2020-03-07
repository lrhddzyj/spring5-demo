package com.lrh.spring.bean.scope.customer;

import com.lrh.spring.bean.scope.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 自定义scope应用 demo
 */
public class CustomerScopeDemo {


    @Bean
    @Scope(ThreadLocalScope.SCOPE_NAME)
    public User threadLocalScopeUser(){
        User user = new User();
        user.setName("ThreadLocalScope User");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CustomerScopeDemo.class);
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
        });

        applicationContext.refresh();
        lookUp(applicationContext);

        applicationContext.close();
    }

    private static void lookUp(AnnotationConfigApplicationContext applicationContext) {

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                User threadLocalScopeUser = applicationContext.getBean(User.class);
                System.out.printf("当前线程 %s 持有的User是 %s \n", Thread.currentThread().getId(), threadLocalScopeUser);
            });

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }


}
