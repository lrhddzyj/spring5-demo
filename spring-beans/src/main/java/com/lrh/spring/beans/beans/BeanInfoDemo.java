package com.lrh.spring.beans.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.Arrays;

public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(System.out::println);

        Arrays.stream(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {

            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String name = propertyDescriptor.getName();
            if("age".equals(name)){
//                propertyDescriptor.setPropertyEditorClass();
            }

        });

    }
}
