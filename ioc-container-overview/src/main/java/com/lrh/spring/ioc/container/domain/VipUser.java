package com.lrh.spring.ioc.container.domain;

import com.lrh.spring.ioc.container.annotation.Vip;
import org.springframework.context.annotation.Primary;

@Vip
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
