package com.capinfo.engine.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DictBean {
	private String code;
	private String name;
	private String orderId;
	private String fcode;

	public DictBean(String code) {
		this.code = code;
	}

	public DictBean() {
	}

	public DictBean(String code, String name, String orderId, String fcode) {
		this.code = code;
		this.name = name;
		this.orderId = orderId;
		this.fcode = fcode;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getFcode() {
		return fcode;
	}
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		DictBean dictBean = (DictBean) o;

		return new EqualsBuilder()
				.append(code, dictBean.code)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(code)
				.toHashCode();
	}
}
