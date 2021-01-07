package com.lrh.aop.features.interceptor;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author lirh
 * @version 2021年01月07日 11:23 下午
 */
public class EchoServiceMethodInterceptor implements MethodInterceptor {

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    Method method = invocation.getMethod();
    System.out.println("拦截 EchoService 的方法：" + method);
    return invocation.proceed();
  }
}
