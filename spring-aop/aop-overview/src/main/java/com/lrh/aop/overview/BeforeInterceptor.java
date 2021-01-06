package com.lrh.aop.overview;

import java.lang.reflect.Method;

/**
 * 前置拦截
 * @author lirh
 * @version 2021年01月06日 11:32 下午
 */
public interface BeforeInterceptor {

  /** 前置拦截器
   * @param proxy
   * @param method
   * @param args
   */
  Object before(Object proxy, Method method, Object[] args);
}
