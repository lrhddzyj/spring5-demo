package com.lrh.ioc.dependence.inject;

import com.lrh.ioc.dependence.inject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 依赖注入解析过程
 *
 * @author lirh
 * @version 2021年02月28日 5:45 下午
 * @see {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency(DependencyDescriptor,
 * String)}
 */
public class AutowireDependencyResolveProcess {

  @Autowired
  User user;


  public static void main(String[] args) {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    applicationContext.register(AutowireDependencyResolveProcess.class);
    applicationContext.refresh();

    applicationContext.close();
  }


  @Bean
  @Primary
  public User user() {
    User user = User.createUser();
    return user;
  }

  @Bean
  public User user2() {
    User user = new User();
    user.setId("1000");
    user.setName("abc");
    return user;
  }


}
