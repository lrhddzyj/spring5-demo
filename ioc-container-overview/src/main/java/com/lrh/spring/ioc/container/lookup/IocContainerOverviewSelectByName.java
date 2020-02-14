package com.lrh.spring.ioc.container.lookup;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过名称来从Spring 容器中查找Bean
 *
 * BeanFactory 是spring容器的核心 实现Bean的容易 Spring 中有很多对应的实现 ApplicationContext等
 *
 * FactoryBean 是个Bean 能从BeanFactory中查找对应的Bean
 *
 */
public class IocContainerOverviewSelectByName {

	private static final String xmlPath = "classpath:/META-INF/IocContainerOverview.xml";

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(xmlPath);
		lookUpRealTime(beanFactory);
		lookUpLazy(beanFactory);
	}

	private static void lookUpLazy(BeanFactory beanFactory)  {
		//通过Bean的方式创建
		ObjectFactory<User> factoryBean = (ObjectFactory<User>)beanFactory.getBean("userObjectFactoryBean");
		User u = factoryBean.getObject();
		System.out.println("延迟查找：" + u);
	}

	private static void lookUpRealTime(BeanFactory beanFactory) {
		User user = (User) beanFactory.getBean("user");
		System.out.println("实时查找： " + user);
	}


}
