package com.lrh.spring.beans.denfinition;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 的实例化方式  示例
 */
public class BeanInstantiationDemo {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
		User user = (User) beanFactory.getBean("userInstantiationFromStaticMethod");
		User user2 = (User) beanFactory.getBean("userInstantiationFromFactory");
		User user3 = (User) beanFactory.getBean("userInstantiationFromFactoryBean");
		System.out.println("静态工厂方法： " + user);
		System.out.println("实例（Bean）方法： " + user2);
		System.out.println("FactoryBean 方法： " + user3);
	}
}
