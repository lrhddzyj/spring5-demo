package com.lrh.spring.beans.denfinition;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Bean的创建与注册 示例
 */

//@Import(value = AnnotationBeanDefinitionDemo.ConfigBean.class) //注解元信息注册（3）  通过导入配置
public class AnnotationBeanDefinitionAndRegistryDemo {

	public static void main(String[] args) {
		//创建BeanFactory 容器
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();

		//JAVA API 的方式（3） 注册 Configuration Class （配置类  作用相当于代替xml）
//		configApplicationContext.register(ConfigBean.class);
//		configApplicationContext.register(AnnotationBeanDefinitionDemo.class);

		// JAVA API 的方式（2） 命名方式调用注册
//		registerBeanDefinition(configApplicationContext,"new-zhangsan",User.class);
		//JAVA API 的方式（1） 非命名方式调用注册
		registerBeanDefinition(configApplicationContext,User.class);


		//启动上下文
		configApplicationContext.refresh();

		Map<String, User> beansOfType = configApplicationContext.getBeansOfType(User.class);

		System.out.println("输出所有User示例：");
		System.out.println(beansOfType);

		Map<String, ConfigBean> configBeanMap = configApplicationContext.getBeansOfType(ConfigBean.class);
		System.out.println("输出所有ConfigBean示例：");
		System.out.println(configBeanMap);

		// 关闭容器
		configApplicationContext.close();
	}

	//注解元信息注册（2） 定义当前类作为Spring Bean（组件）
	@Component
	public static class ConfigBean {

		// 注解元信息注册（1）  通过 java 注解的方式定义Bean
		@Bean(name = {"user", "zhangsan"})
		public User user() {
			User zhangSan = new User();
			zhangSan.setName("zhang san");
			zhangSan.setAge(32);
			return zhangSan;
		}
	}


	/**
	 *  通过Java api注册的方式
	 * @param beanDefinitionRegistry
	 * @param beanName
	 * @param beanClass
	 */
	public static void registerBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry, String beanName, Class<?> beanClass) {
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
		beanDefinitionBuilder.addPropertyValue("name", "zhangsan")
				.addPropertyValue("age", 32);

		if(StringUtils.hasText(beanName)) {
			//JAVA API 的方式（1）命名方式
 			beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
		}else{
			//JAVA API 的方式（2） 非命名的方式
			BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), beanDefinitionRegistry);
		}
	}

	public static  void registerBeanDefinition(BeanDefinitionRegistry registry,Class<?> beanClass){
		registerBeanDefinition(registry, null, beanClass);
	}


}
