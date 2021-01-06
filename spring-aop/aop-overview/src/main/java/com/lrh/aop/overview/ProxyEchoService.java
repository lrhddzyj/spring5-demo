package com.lrh.aop.overview;

/**
 * EchoService 的静态代理
 *
 * @author lirh
 * @version 2021年01月06日 8:45 上午
 */
public class ProxyEchoService implements EchoService {

  private EchoService echoService;

  public ProxyEchoService(EchoService echoService) {
    this.echoService = echoService;
  }

  @Override
  public String echo(String message) {
    return echoService.echo(message);
  }

}
