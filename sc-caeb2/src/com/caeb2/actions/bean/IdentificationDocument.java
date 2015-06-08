package com.caeb2.actions.bean;

public class IdentificationDocument {

	private String type;
	private int number;

	public IdentificationDocument() {
		this("V", 0);
	}

	public IdentificationDocument(String type, int number) {
		this.type = type;
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return type + "-" + String.valueOf(number);
	}

}
