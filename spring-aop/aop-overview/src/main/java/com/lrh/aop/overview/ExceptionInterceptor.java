package com.lrh.aop.overview;

import java.lang.reflect.Method;

/**
 * @author lirh
 * @version 2021年01月06日 11:43 下午
 */
public interface ExceptionInterceptor {

  /**
   * 异常拦截处理
   * @param proxy
   * @param method
   * @param args
   * @param throwable
   */
  void exceptionCall(Object proxy, Method method, Object[] args, Throwable throwable);

}
