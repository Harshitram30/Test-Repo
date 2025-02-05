package com.hospital.entities.dto;

public class PatientDTO {
	
	private Integer ssn;
	private String name;
	private String address;
	private String phone;
	private Integer insuranceid;
	private Integer pcp;
	
	public PatientDTO() {
		super();
	}
	public PatientDTO(Integer ssn, String name, String address, String phone, Integer insuranceid, Integer pcp) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.insuranceid = insuranceid;
		this.pcp = pcp;
	}
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getInsuranceid() {
		return insuranceid;
	}
	public void setInsuranceid(Integer insuranceid) {
		this.insuranceid = insuranceid;
	}
	public Integer getPcp() {
		return pcp;
	}
	public void setPcp(Integer pcp) {
		this.pcp = pcp;
	}

}
