package com.lrh.spring.ioc.container.domain;

public class User {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}


	/**
	 * 静态方法创建user
	 * @return
	 */
	public static User createNewUser(){
		User user = new User();
		user.setName("静态方法方式实例化");
		user.setAge(2);
		return user;
	}
}
