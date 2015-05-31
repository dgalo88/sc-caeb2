package com.caeb2.sections;

public class IdentifyingStructure {
	private String street;
	private String nameHousing;
	private String homePhone;
	
	public IdentifyingStructure(String street,String nameHousing,String homePhone) {
		this.street=street;
		this.nameHousing=nameHousing;
		this.homePhone=homePhone;
	}
	
	public IdentifyingStructure() {
		// TODO Auto-generated constructor stub
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNameHousing() {
		return nameHousing;
	}

	public void setNameHousing(String nameHousing) {
		this.nameHousing = nameHousing;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

}
