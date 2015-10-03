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

	public IdentificationDocument(String identificationDocument) {
		this.type = identificationDocument.substring(0, 1);
		this.number = Integer.valueOf(identificationDocument.substring(1));
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

	public void setIdentificationDocument(String document) {
		this.type = document.substring(0, 1);
		this.number = Integer.valueOf(document.substring(1));
	}

	public IdentificationDocument fromString(String document) {
		return new IdentificationDocument(document);
	}

	@Override
	public String toString() {
		return type + String.valueOf(number);
	}

}
