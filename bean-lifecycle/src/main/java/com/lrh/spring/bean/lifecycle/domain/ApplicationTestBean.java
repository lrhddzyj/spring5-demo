package com.lrh.spring.bean.lifecycle.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

public class ApplicationTestBean implements EnvironmentAware, EmbeddedValueResolverAware,
        ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware,ApplicationContextAware {

    ApplicationContext applicationContext;

    ApplicationEventPublisher applicationEventPublisher;

    StringValueResolver resolver;

    Environment environment;

    MessageSource messageSource;

    ResourceLoader resourceLoader;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public String toString() {
        return "ApplicationTestBean{" +
                "applicationContext=" + applicationContext +
                ", applicationEventPublisher=" + applicationEventPublisher +
                ", resolver=" + resolver +
                ", environment=" + environment +
                ", messageSource=" + messageSource +
                ", resourceLoader=" + resourceLoader +
                '}';
    }
}
