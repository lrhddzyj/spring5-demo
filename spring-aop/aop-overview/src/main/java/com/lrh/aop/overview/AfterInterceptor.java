package com.lrh.aop.overview;

import java.lang.reflect.Method;

/**
 * @author lirh
 * @version 2021年01月06日 11:42 下午
 */
public interface AfterInterceptor {

  /**
   * 后置处理器函数
   * @param proxy
   * @param method
   * @param args
   * @param result
   * @return
   */
  Object after(Object proxy, Method method, Object[] args, Object result);

}
