package com.lrh.aop.features.service;

/**
 * EchoService 默认实现
 * @author lirh
 * @version 2021年01月06日 8:31 上午
 */
public class DefaultEchoServiceImpl implements EchoService {

  @Override
  public String echo(String message) {
    return "[ECHO]:" + message;
  }

}
