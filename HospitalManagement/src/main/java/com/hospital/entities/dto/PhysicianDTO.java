package com.hospital.entities.dto;

public class PhysicianDTO {

	private Integer employeeid;
	private String name;
	private String position;
	private Integer ssn;
	
	public PhysicianDTO(){
		super();
	}
	
	public PhysicianDTO(Integer employeeid, String name, String position, Integer ssn) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.position = position;
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

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	
}
