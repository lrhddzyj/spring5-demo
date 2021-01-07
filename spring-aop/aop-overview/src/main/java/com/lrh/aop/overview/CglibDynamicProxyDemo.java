package com.lrh.aop.overview;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Cglib 动态代理demo
 *
 * @author lirh
 * @version 2021年01月06日 9:19 上午
 */
public class CglibDynamicProxyDemo {

  public static void main(String[] args) {
    Enhancer enhancer = new Enhancer();

    Class<?> superClass = DefaultEchoServiceImpl.class;
    enhancer.setSuperclass(superClass);
    //设置拦截接口
    enhancer.setInterfaces(new Class[]{EchoService.class});
    enhancer.setCallback(new MethodInterceptor() {

      /**
       * 方法拦截
       * @param source 拦截的对象
       * @param method 拦截的原始方法
       * @param args 方法参数
       * @param methodProxy  拦截的代理对象
       * @return
       * @throws Throwable
       */
      @Override
      public Object intercept(Object source, Method method, Object[] args, MethodProxy methodProxy)
          throws Throwable {
        long startTime = System.currentTimeMillis();
        //错误的调用，原始方法被调用后会导致一直被拦截又重新进来
//        Object methodResult = method.invoke(source, arguments);
//        System.out.println(methodResult);

        Object methodProxyResult = methodProxy.invokeSuper(source, args);
        System.out.println(methodProxyResult);

        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("[CGLIB 字节码提升] echo 方法的执行实现耗费：" + costTime + "ms。");

        return methodProxyResult;
      }
    });

    EchoService echoService = (EchoService) enhancer.create();
    echoService.echo("Hello");
  }

}
