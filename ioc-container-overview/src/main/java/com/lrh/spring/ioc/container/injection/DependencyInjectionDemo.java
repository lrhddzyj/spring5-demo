package com.lrh.spring.ioc.container.injection;

import com.lrh.spring.ioc.container.domain.User;
import com.lrh.spring.ioc.container.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入的例子
 *
 */
public class DependencyInjectionDemo {

	private static final String xmlPath = "classpath:/META-INF/IocContainerOverviewInjection.xml";

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(xmlPath);
		injectWithXml(beanFactory);

	}




	private static void injectWithXml(BeanFactory beanFactory) {
		UserRepository userRepository = (UserRepository)beanFactory.getBean("userRepository");

		ObjectFactory<User> userObjectFactory = userRepository.getUserObjectFactory();
		ObjectFactory<ApplicationContext> applicationContextObjectFactory = userRepository.getApplicationContextObjectFactory();

		System.out.println(beanFactory);
		System.out.println(userObjectFactory.getObject());
		System.out.println(applicationContextObjectFactory.getObject());
		System.out.println(userRepository.getBeanFactory());
		System.out.println(beanFactory == 	userRepository.getUserObjectFactory());
		System.out.println(beanFactory == userRepository.getBeanFactory());
	}


}
