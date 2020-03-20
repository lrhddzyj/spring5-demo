package com.lrh.spring.bean.lifecycle.processor;

import com.lrh.spring.bean.lifecycle.domain.UserHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

public class MyInitializationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals(beanName,"userHolder") && UserHolder.class.equals(bean.getClass())){
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("userHolder description - v1");
            System.out.println("postProcessBeforeInitialization() :" + userHolder.getDescription());
            return userHolder;

        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals(beanName,"userHolder") && UserHolder.class.equals(bean.getClass())){
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("userHolder description - v5");
            System.out.println("postProcessAfterInitialization() :" + userHolder.getDescription());
            return userHolder;

        }

        return bean;
    }
}
