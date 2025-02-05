package com.hospital.entities.dto;

public class NurseDTO {

	private Integer employeeid;
	private String name;
	private String position;
	private Boolean registered;
	private Integer ssn;
	
	public NurseDTO() {
		super();
	}
	
	public NurseDTO(Integer employeeid, String name, String position, Boolean registered, Integer ssn) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.position = position;
		this.registered = registered;
		this.ssn = ssn;
	}
	
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Boolean getRegistered() {
		return registered;
	}
	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	
}
