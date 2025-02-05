package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hospital.entities.id.AffiliatedWithId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "affiliated_with")
@IdClass(AffiliatedWithId.class)
public class AffiliatedWith implements Serializable{
	
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "physician", nullable = false)
	private Integer physician;

	@Id
	@Column(name = "department", nullable = false)
	private Integer department;

	@Column(name = "primaryaffiliation", nullable = false)
	private Boolean primaryaffiliation;
	
	//Mapping
	@ManyToOne
	@JoinColumn(name = "physician", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonBackReference
	private Physician physician2;
	
	@ManyToOne
	@JoinColumn(name = "department", referencedColumnName = "departmentid", insertable = false, updatable = false)
	@JsonBackReference
	private Department department2;

	public AffiliatedWith() {
		super();
	}

	public AffiliatedWith(Integer physician, Integer department, Boolean primaryaffiliation) {
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

	public Physician getPhysician2() {
		return this.physician2;
	}

	public Department getDepartment2() {
		return this.department2;
	}

	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}

	public void setDepartment2(Department department2) {
		this.department2 = department2;
	}

	public String toString() {
		return "AffiliatedWith [physician=" + physician + ", department=" + department + ", primaryaffiliation="
				+ primaryaffiliation + "]";
	}
	
}
