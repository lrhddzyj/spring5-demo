package com.lrh.aop.overview;

/**
 * 静态代理demo
 * @author lirh
 * @version 2021年01月06日 8:52 上午
 */
public class StaticProxyDemo {

  public static void main(String[] args) {
    EchoService echoService = new ProxyEchoService(new DefaultEchoServiceImpl());
    System.out.println(echoService.echo("hello"));
  }


}
