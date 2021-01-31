package com.lrh.aop.features.aspect;

/**
 * Aspect xml的形式
 *
 * @author lirh
 * @version 2021年01月07日 12:41 下午
 */
public class AspectJXmlConfiguration {

  public void beforeAnyPublicMethod() {
    System.out.println("execute beforeAnyPublicMethod");
  }

  /*@Around("anyPublicMethod()")
  public Object aroundAnyPublicMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("execute aroundAnyPublicMethod");
    return proceedingJoinPoint.proceed();
  }

  @After("anyPublicMethod()")
  public void afterAnyPublicMethod() {
    System.out.println("execute afterAnyPublicMethod");
  }*/





}
