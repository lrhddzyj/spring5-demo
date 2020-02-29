package com.lrh.spring.beans.factory;

import com.lrh.spring.ioc.container.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 *{@link User} 的 {@link FactoryBean} 实现
 *
 *
 */
public class UserFactoryBean implements FactoryBean<User>{


	@Override
	public User getObject() throws Exception {
		User user = new User();
		user.setName("通过FactoryBean方式生成的Bean");
		user.setAge(20);
		return user;
	}

	@Override
	public Class<User> getObjectType() {
		return User.class;
	}
}
