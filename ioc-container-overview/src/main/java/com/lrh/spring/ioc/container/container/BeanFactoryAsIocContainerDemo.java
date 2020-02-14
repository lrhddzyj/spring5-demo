package com.lrh.spring.ioc.container.container;

import com.lrh.spring.ioc.container.annotation.Vip;
import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryAsIocContainerDemo {

	public static void main(String[] args) {
		//创建BeanFactory容器
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		//Bean的读取来源
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		//XML 的读取元
		String xmlPath = "classpath:/META-INF/IocContainerOverview.xml";
		//加载配置
		int loadBeanDefinitions = beanDefinitionReader.loadBeanDefinitions(xmlPath);
		System.out.println("从XML 中加载的 Bean 的数量：" + loadBeanDefinitions);

		lookUpByAnnotation(defaultListableBeanFactory);
	}

	private static void lookUpByAnnotation(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Vip.class);
			System.out.println(beansWithAnnotation);
		}

	}


}
