package com.caeb2.actions.bean;

import com.caeb2.util.TextUtils;

public class IdentificationDocument {

	private String type;
	private String number;

	public IdentificationDocument() {
		this("V", "");
	}

	public IdentificationDocument(String type, String number) {
		this.type = type;
		this.number = number;
	}

	public IdentificationDocument(String identificationDocument) {
		setIdentificationDocument(identificationDocument);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setIdentificationDocument(String document) {
		this.type = document.substring(0, 1);
		this.number = document.substring(1);
	}

	public void fromString(String document) {
		setIdentificationDocument(document);
	}

	@Override
	public String toString() {
		return isValid() ? type + number : "";
	}

	public boolean isValid() {
		return !(TextUtils.isEmptyOrNull(type) || TextUtils.isEmptyOrNull(number));
	}

}
