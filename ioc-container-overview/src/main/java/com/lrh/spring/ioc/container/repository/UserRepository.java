package com.lrh.spring.ioc.container.repository;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

public class UserRepository {

	private Collection<User> users; // 自建Bean

	private BeanFactory beanFactory;  //内建 非Bean对象（依赖）

	private ObjectFactory<User> userObjectFactory;  //自建对象的工厂Bean

	private ObjectFactory<ApplicationContext> applicationContextObjectFactory; //内建对象的工厂Bean

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public ObjectFactory<User> getUserObjectFactory() {
		return userObjectFactory;
	}

	public void setUserObjectFactory(ObjectFactory<User> userObjectFactory) {
		this.userObjectFactory = userObjectFactory;
	}

	public ObjectFactory<ApplicationContext> getApplicationContextObjectFactory() {
		return applicationContextObjectFactory;
	}

	public void setApplicationContextObjectFactory(ObjectFactory<ApplicationContext> applicationContextObjectFactory) {
		this.applicationContextObjectFactory = applicationContextObjectFactory;
	}
}
