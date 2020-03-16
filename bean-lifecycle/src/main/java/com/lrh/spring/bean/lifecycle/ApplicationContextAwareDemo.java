package com.lrh.spring.bean.lifecycle;

import com.lrh.spring.bean.lifecycle.domain.ApplicationTestBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextAwareDemo {

    public static void main(String[] args) {
        String xmlPath = "classpath:/META-INF/application-aware-lifecycle.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        ApplicationTestBean applicationTestBean = applicationContext.getBeanFactory().getBean("applicationTestBean", ApplicationTestBean.class);
        System.out.println(applicationTestBean);
    }



}
