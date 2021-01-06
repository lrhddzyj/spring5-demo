package com.lrh.aop.overview;

import java.lang.reflect.Method;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.MethodCallback;
import org.springframework.util.ReflectionUtils.MethodFilter;

/**
 * AOP 目标过滤示例
 * @author lirh
 * @version 2021年01月06日 11:11 下午
 */
public class TargetFilterDemo {

  public static void main(String[] args) throws ClassNotFoundException {
    String targetClassName = "com.lrh.aop.overview.EchoService";
    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
    Class<?> targetClass = contextClassLoader.loadClass(targetClassName);

    //Spring 反射工具类 查找方法
    Method echo = ReflectionUtils.findMethod(targetClass, "echo",String.class);
    System.out.println(echo);

    //过滤方法 ，throws 类型为NullPointException的方法

    ReflectionUtils.doWithMethods(targetClass, new MethodCallback() {
      @Override
      public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
        System.out.println("参数只有一个且为String类型，并且仅抛出NullPointException的Method:" + method);
      }
    }, new MethodFilter() {
      @Override
      public boolean matches(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        return parameterTypes.length == 1
            && String.class.equals(parameterTypes[0])
            && exceptionTypes.length == 1
            && NullPointerException.class.equals(exceptionTypes[0]);
      }
    });





  }

}
