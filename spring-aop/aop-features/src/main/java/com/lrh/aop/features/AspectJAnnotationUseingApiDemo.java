package com.lrh.aop.features;

import com.lrh.aop.features.aspect.AspectJConfiguration;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * AspectJ API示例
 * @author lirh
 * @version 2021年01月07日 11:00 下午
 */
public class AspectJAnnotationUseingApiDemo {

  public static void main(String[] args) {
    Map<String, Object> cache = new HashMap();
    //创建Proxy工厂（AspectJ）
    AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(cache);
    //增加AspectJ配置类
//    aspectJProxyFactory.addAspect(AspectJConfiguration.class);


    aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {
      @Override
      public void before(Method method, Object[] args, Object target) throws Throwable {
        if ("put".equals(method.getName())) {
          System.out.printf("当前存放的Key: %s,Value : %s \n", args[0], args[1]);
        }
      }
    });

    Map<String, Object> cacheProxy = aspectJProxyFactory.getProxy();
    cacheProxy.put("a", "a");

  }
}
