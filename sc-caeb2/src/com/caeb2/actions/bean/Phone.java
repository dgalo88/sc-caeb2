package com.caeb2.actions.bean;

import com.caeb2.util.TextUtils;

public class Phone {

	private String code;
	private String number;

	public Phone(String code, String number) {
		this.code = code;
		this.number = number;
	}

	public Phone() {
		this("", "");
	}

	public Phone(String phone) {
		fromString(phone);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void fromString(String phone) {

		String[] phoneSplitted = phone.split("-");

		this.code = phoneSplitted[0];
		this.number = phoneSplitted[1];

	}

	@Override
	public String toString() {
		return code + "-" + number;
	}

	public boolean isValid() {
		return !(TextUtils.isEmptyOrNull(code) || TextUtils.isEmptyOrNull(number));
	}

}
