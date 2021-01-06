package com.lrh.spring.beans.denfinition;

import com.lrh.spring.beans.factory.DefaultUserFactory;
import com.lrh.spring.beans.factory.UserFactory;
import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * 1,通过serviceLoader 实例化Bean
 *
 * 步骤：1，在resources下创建目录 META-INF/services （从ServiceLoader接口中获知）
 *      2，一般这种方式是通过接口的方式实现，创建一个接口路径的文件名 内容为 接口的实现，可以放多个实现，每行一个
 *      3，ServiceLoader.load() 加载对应的Bean (并未加载到Sring context)
 *
 *      4，加载到SpringContext 的方式 使用ServiceLoaderFactoryBean配置
 *
 *
 * 2,通过AutowireCapableBeanFactory
 *
 * 3，通过BeanDefinitionRegistry
 *
 */
@Configuration
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-special-method-context.xml");
//        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("serviceLoaderFactoryBean", ServiceLoader.class);

//        displayServiceLoader(serviceLoader);

        //通过autowireCapableBeanFactory 实例化Bean
//        createBeanWithAutoWireCapableBeanFactory(beanFactory);
        ServiceLoaderFactoryBean serviceLoaderFactoryBean = new ServiceLoaderFactoryBean();
        serviceLoaderFactoryBean.setServiceType(UserFactory.class);

        ConfigurableListableBeanFactory beanFactory1 = beanFactory.getBeanFactory();
        beanFactory1.registerSingleton("ss",serviceLoaderFactoryBean);


        beanFactory.refresh();

        Map<String, ServiceLoader> beansOfType2 = beanFactory.getBeansOfType(ServiceLoader.class);
        System.out.println(beansOfType2);

        Map<String, UserFactory> beansOfType1 = beanFactory.getBeansOfType(UserFactory.class);
        System.out.println(beansOfType1);

        //  demoServiceLoader();

        Map<String, ServiceLoader> beansOfType =
                beanFactory.getBeansOfType(ServiceLoader.class);
        System.out.println(beansOfType);
        beanFactory.close();
    }


    // 通过autowireCapableBeanFactory 实例化Bean
    private static void createBeanWithAutoWireCapableBeanFactory(ApplicationContext beanFactory) {
        AutowireCapableBeanFactory autowireCapableBeanFactory = beanFactory.getAutowireCapableBeanFactory();
        DefaultUserFactory bean = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
        System.out.println(bean.createUser());
    }


    //展示用ServiceLoader方式实例化的 user Bean（User）
    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }

    }

    //加载并获取serviceLoader定义的Bean(但并未注册到BeanFactory)
    private static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }





//测试没成功!
    public ServiceLoader<UserFactory> userFactories(ServiceLoaderFactoryBean serviceLoaderFactoryBean) throws Exception {
        return (ServiceLoader)serviceLoaderFactoryBean.getObject();

    }




}
