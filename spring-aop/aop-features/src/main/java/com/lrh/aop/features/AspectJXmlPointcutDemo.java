package com.lrh.aop.features;

import com.lrh.aop.features.aspect.AspectJConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AspectJ xml形式
 *
 * @author lirh
 * @version 2021年01月31日 10:48 下午
 */

public class AspectJXmlPointcutDemo {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "classpath:/META-INF/spring-aspectj-pointcut.xml");

    applicationContext.refresh();
    AspectJXmlPointcutDemo pointcutDemo = applicationContext.getBean(AspectJXmlPointcutDemo.class);
    pointcutDemo.execute();
    applicationContext.close();
  }


  public void execute() {
    System.out.println("execute()。。。。。。");
  }

}
