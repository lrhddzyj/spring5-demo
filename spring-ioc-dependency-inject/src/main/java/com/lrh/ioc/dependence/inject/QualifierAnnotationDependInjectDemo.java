package com.lrh.ioc.dependence.inject;

import com.lrh.ioc.dependence.inject.annotation.Vip;
import com.lrh.ioc.dependence.inject.domain.User;
import com.lrh.ioc.dependence.inject.domain.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

public class QualifierAnnotationDependInjectDemo {

//    @Autowired
//    @Qualifier
//    private User user;
//

    @Autowired
    @Qualifier
    private List<User> users;


    @Autowired
    @Vip
    private User vipUser;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierAnnotationDependInjectDemo.class);

        applicationContext.refresh();
//        Map<String, UserHolder> beansOfType = applicationContext.getBeansOfType(UserHolder.class);
//        System.out.println(beansOfType);

        QualifierAnnotationDependInjectDemo demo = applicationContext.getBean(QualifierAnnotationDependInjectDemo.class);
        System.out.println(demo.vipUser);
        System.out.println(demo.users);

        applicationContext.close();
    }



    @Bean
    @Qualifier
    public User userA(){
        User user = new User();
        user.setId("100");
        user.setName("A");
        return user;
    }


    @Bean
    @Qualifier
    public User userA1(){
        User user = new User();
        user.setId("100");
        user.setName("A1");
        return user;
    }

    @Bean
    @Vip
    public User userB(){
        User user = new User();
        user.setId("200");
        user.setName("B");
        return user;
    }

}
