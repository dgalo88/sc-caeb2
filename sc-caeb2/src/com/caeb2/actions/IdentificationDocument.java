package com.caeb2.actions;

public class IdentificationDocument {

	private int number;
	private String type;

	public IdentificationDocument() {
		this(0, null);
	}

	public IdentificationDocument(int number, String type) {
		this.number = number;
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type + "-" + String.valueOf(number);
	}

}
