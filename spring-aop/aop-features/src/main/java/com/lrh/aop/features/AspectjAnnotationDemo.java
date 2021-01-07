package com.lrh.aop.features;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lirh
 * @version 2021年01月07日 8:28 上午
 */
@Aspect
@EnableAspectJAutoProxy
public class AspectjAnnotationDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    applicationContext.register(AspectjAnnotationDemo.class);
    applicationContext.refresh();

    AspectjAnnotationDemo aspectjAnnotationDemo = applicationContext.getBean(AspectjAnnotationDemo.class);
    aspectjAnnotationDemo.execute();

    applicationContext.close();
  }

  public void execute() {
    System.out.println("execute()。。。。。。");
  }


}
