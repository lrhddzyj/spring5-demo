package com.lrh.aop.features.pointcut;

import com.lrh.aop.features.service.EchoService;
import java.lang.reflect.Method;
import java.util.Objects;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ClassFilters;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

/**
 * 自定义实现pointCut
 *
 * @author lirh
 * @version 2021年01月31日 11:00 下午
 */
public class EchoServiceEchoMethodPointcut  implements Pointcut {

  public static final EchoServiceEchoMethodPointcut INSTANCE = new EchoServiceEchoMethodPointcut();

  @Override
  public ClassFilter getClassFilter() {



    return new ClassFilter() {
      @Override
      public boolean matches(Class<?> clazz) {
        return EchoService.class.isAssignableFrom(clazz);
      }
    };
  }

  @Override
  public MethodMatcher getMethodMatcher() {
    return new MethodMatcher() {
      @Override
      public boolean matches(Method method, Class<?> targetClass) {
      return   "echo".equals(method.getName()) &&
            method.getParameterTypes().length == 1 &&
            Objects.equals(String.class, method.getParameterTypes()[0]);
      }

      @Override
      public boolean isRuntime() {
        return false;
      }

      @Override
      public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return false;
      }
    };
  }
}
