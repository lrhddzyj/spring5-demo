package com.lrh.spring.ioc.container.lookup;

import com.lrh.spring.ioc.container.annotation.Vip;
import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class IocContainerOverviewSelectByAnnotation {


	private static final String xmlClassPath = "classpath:/META-INF/IocContainerOverview.xml";

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(xmlClassPath);
		lookUpByAnnotation(beanFactory);
	}

	private static void lookUpByAnnotation(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Vip.class);
			System.out.println(beansWithAnnotation);
		}

	}


}
