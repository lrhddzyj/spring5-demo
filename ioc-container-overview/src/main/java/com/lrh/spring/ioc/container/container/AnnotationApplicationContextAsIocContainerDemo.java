package com.lrh.spring.ioc.container.container;

import com.lrh.spring.ioc.container.annotation.Vip;
import com.lrh.spring.ioc.container.domain.User;
import com.lrh.spring.ioc.container.domain.VipUser;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class AnnotationApplicationContextAsIocContainerDemo {

	public static void main(String[] args) {
		//创建BeanFactory容器
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		//Bean的读取来源
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(defaultListableBeanFactory);

		//加载配置
		annotationConfigApplicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);

		//启动应用上下文
		annotationConfigApplicationContext.refresh();

		lookUpByAnnotation(defaultListableBeanFactory);
	}

	/**
	 * 通过注解定义Bean
	 * @return
	 */
	@Bean
	public User user(){
		VipUser ming = new VipUser();
		ming.setName("ming");
		ming.setAge(18);
		ming.setVipLevel("黄金");
		return ming;
	}



	private static void lookUpByAnnotation(BeanFactory beanFactory) {
		if(beanFactory instanceof ListableBeanFactory){
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Vip.class);
			System.out.println(beansWithAnnotation);
		}

	}


}
