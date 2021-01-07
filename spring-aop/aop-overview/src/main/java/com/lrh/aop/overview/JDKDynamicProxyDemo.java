package com.lrh.aop.overview;

import java.lang.reflect.Proxy;

/**
 * JDK 动态代理demo
 * @author lirh
 * @version 2021年01月06日 8:55 上午
 */
public class JDKDynamicProxyDemo {

  public static void main(String[] args) {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    EchoService echoService = (EchoService)Proxy
        .newProxyInstance(classLoader, new Class[]{EchoService.class}, (proxy, method, args1) -> {
          if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
            ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoServiceImpl());
            return proxyEchoService.echo((String) args1[0]);
          }
          return null;
        });

    //验证是否是同一个Proxy$Class
    EchoService echoService1 = (EchoService)Proxy
        .newProxyInstance(classLoader, new Class[]{EchoService.class}, (proxy, method, args1) -> {
          if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
            ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoServiceImpl());
            return proxyEchoService.echo((String) args1[0]);
          }
          return null;
        });

    System.out.println(echoService.echo("Hello word"));



  }



}
