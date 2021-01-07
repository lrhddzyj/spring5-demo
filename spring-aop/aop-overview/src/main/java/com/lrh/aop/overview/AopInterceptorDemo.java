package com.lrh.aop.overview;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP 拦截器示例
 *
 * @author lirh
 * @version 2021年01月06日 11:30 下午
 */
public class AopInterceptorDemo {

  public static void main(String[] args) {

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    EchoService echoService = (EchoService) Proxy
        .newProxyInstance(classLoader, new Class[]{EchoService.class}, (proxy, method, args1) -> {
          if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
            BeforeInterceptor beforeInterceptor = new BeforeInterceptor() {
              @Override
              public Object before(Object proxy, Method method, Object[] args) {
                return System.currentTimeMillis();
              }
            };

            AfterInterceptor afterInterceptor = new AfterInterceptor() {
              @Override
              public Object after(Object proxy, Method method, Object[] args, Object result) {
                return System.currentTimeMillis();
              }
            };

            EchoService echoServiceImp = new DefaultEchoServiceImpl();
            Long startTime = 0L;
            Long endTime = 0L;
            Object result = null;

            try {
              startTime = (Long) beforeInterceptor.before(proxy, method, args);
              result = echoServiceImp.echo((String) args1[0]);
              endTime = (Long) afterInterceptor.after(proxy, method, args, result);
            } catch (Exception e) {
              ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor() {
                @Override
                public void exceptionCall(Object proxy, Method method, Object[] args,
                    Exception throwable) {
                  System.out.println("拦截到异常"+ throwable.getMessage());
                }
              };
              exceptionInterceptor.exceptionCall(proxy, method, args, e);

            } finally {
              TimeFinallyInterceptor timeFinallyInterceptor = new TimeFinallyInterceptor(startTime,
                  endTime);
              Long costTime = (Long) timeFinallyInterceptor.finallyCall(proxy, method, args, result);
              System.out.println("echo 执行耗时：" + costTime + "ms.");

            }
            return result;
          }
          return null;
        });

    System.out.println(echoService.echo("Hello word"));

  }

}

class TimeFinallyInterceptor implements FinallyInterceptor {

  private final Long startTime;

  private final Long endTime;

  public TimeFinallyInterceptor(Long startTime, Long endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public Object finallyCall(Object proxy, Method method, Object[] args, Object result) {
    return endTime - startTime;
  }
}
