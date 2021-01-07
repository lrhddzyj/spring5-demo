package com.lrh.aop.features;

import com.lrh.aop.features.interceptor.EchoServiceMethodInterceptor;
import com.lrh.aop.features.service.DefaultEchoServiceImpl;
import com.lrh.aop.features.service.EchoService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ProxyFactory 示例
 *
 * @author lirh
 * @version 2021年01月07日 11:13 下午
 */
@Aspect
public class ProxyFactoryDemo {

  public static void main(String[] args) {
    DefaultEchoServiceImpl defaultEchoService = new DefaultEchoServiceImpl();
    //注入目标对象(被代理对象)
    ProxyFactory proxyFactory = new ProxyFactory(defaultEchoService);
    //添加Advice
    proxyFactory.addAdvice(new EchoServiceMethodInterceptor());
    EchoService echoService = (EchoService) proxyFactory.getProxy();
    System.out.println(echoService.echo("Hello world"));

  }

}
