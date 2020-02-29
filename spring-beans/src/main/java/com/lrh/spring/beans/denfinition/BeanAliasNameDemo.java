package com.lrh.spring.beans.denfinition;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 定义Bean的 别名 并通过别名查找Bean
 *
 */
public class BeanAliasNameDemo {

    public static void main(String[] args) {

        String xmlPath = "classpath:/META-INF/bean-name-alias-context.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        applicationContext.refresh();
        lookUpWithAliasName(applicationContext);
        applicationContext.close();

    }

    private static void lookUpWithAliasName(ApplicationContext applicationContext) {
        User xiaoli = applicationContext.getBean("xiaoLi", User.class);
        User user = applicationContext.getBean("user", User.class);
        System.out.println("xiaoli 是否与 user bean 相同 ：" + (xiaoli == user));
    }
}
