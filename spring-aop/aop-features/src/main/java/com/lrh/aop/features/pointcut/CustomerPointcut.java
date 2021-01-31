package com.lrh.aop.features.pointcut;

import com.lrh.aop.features.service.EchoService;
import java.lang.reflect.Method;
import java.util.Objects;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * 自定义实现pointCut
 *
 * @author lirh
 * @version 2021年01月31日 11:00 下午
 */
public class CustomerPointcut extends StaticMethodMatcherPointcut {

  public CustomerPointcut(String methodName, Class targetClass) {
    this.methodName = methodName;
    this.targetClass = targetClass;
  }

  private String methodName;

  private Class targetClass;

  @Override
  public boolean matches(Method method, Class<?> targetClass) {
    System.out.println("进行pointcut match!!");
    return Objects.equals(method.getName(),methodName) && this.targetClass.isAssignableFrom(targetClass);
  }

  public String getMethodName() {
    return methodName;
  }

  public void setMethodName(String methodName) {
    this.methodName = methodName;
  }

  public Class getTargetClass() {
    return targetClass;
  }

  public void setTargetClass(Class targetClass) {
    this.targetClass = targetClass;
  }
}
