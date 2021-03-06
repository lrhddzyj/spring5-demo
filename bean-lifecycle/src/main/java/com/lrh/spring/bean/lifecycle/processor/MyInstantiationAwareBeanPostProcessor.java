package com.lrh.spring.bean.lifecycle.processor;

import com.lrh.spring.bean.lifecycle.domain.User;
import com.lrh.spring.bean.lifecycle.domain.UserHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.beans.PropertyDescriptor;

public  class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        // Bean实例化之前 还没生成Bean
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

//            if(ObjectUtils.nullSafeEquals(beanName,"vipUser") && VipUser.class.equals(beanClass)){
//                VipUser specialBeanInstantiationUser = new VipUser();
//                specialBeanInstantiationUser.setName("Transformed V1");
//                return specialBeanInstantiationUser;
//            }

            return null;
        }


        // 已经生成Bean 还未赋值 通过返回值判断是不是需要自动赋值 false 则不会自动赋值
        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//            if(ObjectUtils.nullSafeEquals(beanName,"user") && User.class.equals(bean.getClass())){
//                ((User) bean).setName("AA");
//                return false;
//
//            }
            return true;
        }

        //已经生成 Bean(但并未赋值) 赋值回调之前的操作 spring>5.1
        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
                throws BeansException {
            if(ObjectUtils.nullSafeEquals(beanName,"user") && User.class.equals(bean.getClass())){
                MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
                mutablePropertyValues.addPropertyValue("name","AAA");
                mutablePropertyValues.addPropertyValue("age","1000");
                return mutablePropertyValues;
            }
            return null;
        }

        //已经生成 Bean(但并未赋值) 赋值回调之前的操作 spring <=5.0
//        @Override
//        public PropertyValues postProcessPropertyValues(
//                PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
//            if(ObjectUtils.nullSafeEquals(beanName,"user") && User.class.equals(bean.getClass())){
//                MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
//
//                mutablePropertyValues.addPropertyValue("name","Transformed V2");
////                mutablePropertyValues.addPropertyValue("age","1000");
//
//                return mutablePropertyValues;
//            }
//
//            return pvs;
//        }


    }
