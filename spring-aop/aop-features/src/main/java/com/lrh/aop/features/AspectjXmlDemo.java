package com.lrh.aop.features;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lirh
 * @version 2021年01月07日 8:28 上午
 */

public class AspectjXmlDemo {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "classpath:/META-INF/spring-aop-conetext.xml");

    applicationContext.refresh();

    AspectjXmlDemo aspectjAnnotationDemo = applicationContext.getBean(AspectjXmlDemo.class);
    aspectjAnnotationDemo.execute();

    applicationContext.close();
  }

  public void execute() {
    System.out.println("execute()。。。。。。");
  }


}
