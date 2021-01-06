package com.lrh.spring.beans.denfinition;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lrh
 * @date: 2020/11/28 19:16
 */
public class AnnotationFactoryBeanDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

    annotationConfigApplicationContext.register(AnnotationFactoryBeanDemo.class);

    annotationConfigApplicationContext.refresh();

    User bean = annotationConfigApplicationContext.getBean(User.class);
    System.out.println(bean);

    annotationConfigApplicationContext.close();
  }


  public interface NewUserFactory {

   default User createUser(){
       User user = new User();
       user.setName("11");
       user.setAge(1);
       return user;
   }

  }

  @Component
  public static class DefaultNewUserFactory implements NewUserFactory {

  }




}
