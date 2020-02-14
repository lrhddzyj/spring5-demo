package com.lrh.spring.beans.denfinition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

/**
 *
 * 特殊的方式实例化Bean
 *
 *
 */
public class BeanInstantiationWithSpecialMethodDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-special-method-context.xml");







	}

}
