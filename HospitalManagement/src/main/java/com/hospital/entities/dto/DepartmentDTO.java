package com.hospital.entities.dto;

public class DepartmentDTO {
	
	public DepartmentDTO(Integer departmentid, String name, Integer head) {
		super();
		this.departmentid = departmentid;
		this.name = name;
		this.head = head;
	}
	private Integer departmentid;
	private String name;
	private Integer head;
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHead() {
		return head;
	}
	public void setHead(Integer head) {
		this.head = head;
	}

}

