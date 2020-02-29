package com.lrh.spring.beans.denfinition;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 *  Bean 元信息的定义
 */
public class BeanDefinitionCreateDemo {

	public static void main(String[] args) {
		//1 ,通过BeanDefinitionBuilder创建Bean
		BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		definitionBuilder.addPropertyValue("name", "成龙大哥")
				.addPropertyValue("age", "65");
		//获取实例
		BeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();
		//beanDefinition 并非 Bean 的终态 可以通过自定义修改

		//2，通过AbstractBeanDefinition 以及派生类
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setBeanClass(User.class);
		MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
		mutablePropertyValues.add("name", "成龙")
				.add("age", "65");
		genericBeanDefinition.setPropertyValues(mutablePropertyValues);
		BeanDefinition originatingBeanDefinition = genericBeanDefinition.getOriginatingBeanDefinition();
	}

}
