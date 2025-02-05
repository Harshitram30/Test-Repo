package com.hospital.entities.dto;

public class AffiliatedWithDTO {

	private Integer physician;
	private Integer department;
	private Boolean primaryaffiliation;
	
	public AffiliatedWithDTO() {
		super();
	}

	public AffiliatedWithDTO(Integer physician, Integer department, Boolean primaryaffiliation) {
		super();
		this.physician = physician;
		this.department = department;
		this.primaryaffiliation = primaryaffiliation;
	}

	public Integer getPhysician() {
		return physician;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Boolean getPrimaryaffiliation() {
		return primaryaffiliation;
	}

	public void setPrimaryaffiliation(Boolean primaryaffiliation) {
		this.primaryaffiliation = primaryaffiliation;
	}
	
}
