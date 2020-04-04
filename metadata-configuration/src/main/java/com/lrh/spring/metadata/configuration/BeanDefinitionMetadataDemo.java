package com.lrh.spring.metadata.configuration;

import com.lrh.spring.metadata.configuration.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.util.ObjectUtils;

public class BeanDefinitionMetadataDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				if (ObjectUtils.nullSafeEquals(beanName, "user") && User.class.equals(bean.getClass())) {
					BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
					String name = (String) beanDefinition.getAttribute("name");
					((User) bean).setName(name);
					System.out.printf("beanDefinition source is %s\n",beanDefinition.getSource());
				}
				return bean;
			}
		});

		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		beanDefinitionBuilder.addPropertyValue("name", "hello")
				.addPropertyValue("age", 16);

		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanDefinitionBuilder.getBeanDefinition();

		//附加属性（不影响Bean initialize populate）
		beanDefinition.setAttribute("name", "spring");

		//当前BeanDefinition来自何方 （辅助作用）
		beanDefinition.setSource(BeanDefinitionMetadataDemo.class);


		beanFactory.registerBeanDefinition("user", beanDefinition);

		User user1 = beanFactory.getBean("user", User.class);
		System.out.println(user1);


	}

}
