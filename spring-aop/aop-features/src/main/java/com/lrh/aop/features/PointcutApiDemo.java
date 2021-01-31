package com.lrh.aop.features;

import com.lrh.aop.features.interceptor.EchoServiceMethodInterceptor;
import com.lrh.aop.features.pointcut.CustomerPointcut;
import com.lrh.aop.features.service.DefaultEchoServiceImpl;
import com.lrh.aop.features.service.EchoService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * 自定义Pointcut api使用示例
 *
 * @author lirh
 * @version 2021年01月31日 11:06 下午
 */
public class PointcutApiDemo {

  public static void main(String[] args) {
    CustomerPointcut echoServicePointcut = new CustomerPointcut("echo", EchoService.class);

    DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(echoServicePointcut,
        new EchoServiceMethodInterceptor());

    DefaultEchoServiceImpl defaultEchoService = new DefaultEchoServiceImpl();
    ProxyFactory proxyFactory = new ProxyFactory(defaultEchoService);
    proxyFactory.addAdvisor(defaultPointcutAdvisor);

    EchoService echoService = (EchoService)proxyFactory.getProxy();

    echoService.echo("abc");
  }

}
