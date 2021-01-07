package com.lrh.aop.features.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author lirh
 * @version 2021年01月07日 12:41 下午
 */
@Aspect
public class AspectJConfiguration {

  @Pointcut("execution(public * *(..))")
  private void anyPublicMethod() {
    System.out.println("@Pointcut at any public method");
  }

  @Before("anyPublicMethod()")
  public void beforeAnyPublicMethod() {
    System.out.println("execute beforeAnyPublicMethod");
  }

  @Around("anyPublicMethod()")
  public Object aroundAnyPublicMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("execute aroundAnyPublicMethod");
    return proceedingJoinPoint.proceed();
  }

  @After("anyPublicMethod()")
  public void afterAnyPublicMethod() {
    System.out.println("execute afterAnyPublicMethod");
  }





}
