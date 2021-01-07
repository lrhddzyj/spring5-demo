package com.lrh.aop.features;

import com.lrh.aop.features.service.EchoService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ProxyFactoryBean 示例
 *
 * @author lirh
 * @version 2021年01月07日 11:13 下午
 */
@Aspect
public class ProxyFactoryBeanDemo {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "classpath:/META-INF/spring-aop-conetext-proxyFactoryBean.xml");

    EchoService echoService = applicationContext.getBean("echoServiceProxyFactoryBean", EchoService.class);

    System.out.println(echoService.echo("Hello,World"));

    applicationContext.close();

  }

}
