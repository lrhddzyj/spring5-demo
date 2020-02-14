package com.lrh.spring.beans.factory;

import com.lrh.spring.ioc.container.domain.User;

/**
 *
 * {@link User} 工厂类
 *
 */
public interface UserFactory {

	 default User createUser(){
		 User user = new User();
		 user.setName("通过工厂模式创建");
		 user.setAge(3);
		 return user;
	 }
}
