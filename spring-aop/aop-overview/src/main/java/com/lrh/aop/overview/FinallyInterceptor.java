package com.lrh.aop.overview;

import java.lang.reflect.Method;

/**
 * @author lirh
 * @version 2021年01月06日 11:46 下午
 */
public interface FinallyInterceptor {

  /**
   * finally 拦截处理
   * @param proxy
   * @param method
   * @param args
   * @param result
   * @return
   */
  Object finallyCall(Object proxy, Method method, Object[] args, Object result);

}
