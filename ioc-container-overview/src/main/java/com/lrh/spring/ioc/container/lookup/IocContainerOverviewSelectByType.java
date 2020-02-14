package com.lrh.spring.ioc.container.lookup;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 *  通过类型来查找Bean
 *
 */
public class IocContainerOverviewSelectByType {

	private static final String xmlPath = "classpath:/META-INF/IocContainerOverview.xml";

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(xmlPath);

		lookSingleByType(beanFactory);
		lookCollectionByType(beanFactory);
	}

	private static void lookCollectionByType(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
			System.out.println("查找所有 User 类的Bean对象" + userMap);
		}

	}

	private static void lookSingleByType(BeanFactory beanFactory) {
		User user = beanFactory.getBean(User.class);
		System.out.println("实时查找： " + user);
	}
}
