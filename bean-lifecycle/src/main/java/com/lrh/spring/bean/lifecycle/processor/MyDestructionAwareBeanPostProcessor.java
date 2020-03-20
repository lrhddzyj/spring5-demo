package com.lrh.spring.bean.lifecycle.processor;

import com.lrh.spring.bean.lifecycle.domain.UserHolder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if(ObjectUtils.nullSafeEquals(beanName,"userHolder") && UserHolder.class.equals(bean.getClass())){
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("userHolder description - v8");
            System.out.println("postProcessBeforeDestruction() :" + userHolder.getDescription());
        }
    }
}
