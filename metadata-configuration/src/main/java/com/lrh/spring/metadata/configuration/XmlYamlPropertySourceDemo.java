package com.lrh.spring.metadata.configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 *
 * 基于xml 的 外部化配置 demo
 */
public class XmlYamlPropertySourceDemo {

    public static void main(String[] args) {

        String xmlClassPath = "classpath:/META-INF/yaml-property-source-context.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlClassPath);

        applicationContext.refresh();

        Map<String,Object> userYaml = applicationContext.getBean("userYaml", Map.class);
        System.out.println(userYaml);

        applicationContext.close();

    }

}
