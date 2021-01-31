package com.lrh.aop.features;

import com.lrh.aop.features.aspect.AspectJConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *   AspectJ 注解 示例
 * @author lirh
 * @version 2021年01月07日 12:38 下午
 */
@EnableAspectJAutoProxy
public class AspectJAnnotatedPointcutDemo {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    applicationContext.register(AspectJAnnotatedPointcutDemo.class,AspectJConfiguration.class);

    applicationContext.refresh();
    AspectJAnnotatedPointcutDemo pointcutDemo = applicationContext.getBean(AspectJAnnotatedPointcutDemo.class);
    pointcutDemo.execute();
    applicationContext.close();
  }


  public void execute() {
    System.out.println("execute()。。。。。。");
  }



}
