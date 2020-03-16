package com.lrh.spring.bean.lifecycle.domain;

public class VipUser extends User {

	private String vipLevel;

	public String getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(String vipLevel) {
		this.vipLevel = vipLevel;
	}

	@Override
	public String toString() {
		return "VipUser{" +
				"vipLevel='" + vipLevel + '\'' +
				"} " + super.toString();
	}
}
