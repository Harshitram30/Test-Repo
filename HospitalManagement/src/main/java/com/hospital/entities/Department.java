package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "departmentid", nullable = false)
	private Integer departmentid;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "head", nullable = false)
	private Integer head;
	
	//Mapping
	@OneToMany(mappedBy = "department2")
	@JsonManagedReference
	private List<AffiliatedWith> listOfAffiliatedWith;

	@ManyToOne
	@JoinColumn(name = "head", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonBackReference
	private Physician physician;
	
	public Department() {
		super();
	}

	public Department(Integer departmentid, String name, Integer head) {
		super();
		this.departmentid = departmentid;
		this.name = name;
		this.head = head;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getDepartmentid() {
		return this.departmentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setHead(Integer head) {
		this.head = head;
	}

	public Integer getHead() {
		return this.head;
	}

	public List<AffiliatedWith> getListOfAffiliatedWith() {
		return this.listOfAffiliatedWith;
	}

	public Physician getPhysician() {
		return this.physician;
	}

	public void setListOfAffiliatedWith(List<AffiliatedWith> listOfAffiliatedWith) {
		this.listOfAffiliatedWith = listOfAffiliatedWith;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public String toString() {
		return "Department [departmentid=" + departmentid + ", name=" + name + ", head=" + head + "]";
	}

}
