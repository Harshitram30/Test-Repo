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
@Table(name = "patient")
public class Patient implements Serializable{
	
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ssn", nullable = false)
	private Integer ssn;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "address", nullable = false, length = 30)
	private String address;

	@Column(name = "phone", nullable = false, length = 30)
	private String phone;

	@Column(name = "insuranceid", nullable = false)
	private Integer insuranceid;

	@Column(name = "pcp", nullable = false)
	private Integer pcp;
	
	//Mapping
	@OneToMany(mappedBy = "patient2")
	@JsonManagedReference
	private List<Prescribes> listOfPrescribes;
	
	@OneToMany(mappedBy = "patient2")
	@JsonManagedReference
	private List<Undergoes> listOfUndergoes;
	
	@OneToMany(mappedBy = "patient2")
	@JsonManagedReference
	private List<Appointment> listOfAppointment;
	
	@OneToMany(mappedBy = "patient2")
	@JsonManagedReference
	private List<Stay> listOfStay;
	
	@ManyToOne
	@JoinColumn(name = "pcp", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonBackReference
	private Physician physician;

	public Patient() {
		super();
	}

	public Patient(Integer ssn, String name, String address, String phone, Integer insuranceid, Integer pcp) {
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

	public List<Prescribes> getListOfPrescribes() {
		return listOfPrescribes;
	}

	public void setListOfPrescribes(List<Prescribes> listOfPrescribes) {
		this.listOfPrescribes = listOfPrescribes;
	}

	public List<Undergoes> getListOfUndergoes() {
		return listOfUndergoes;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public List<Appointment> getListOfAppointment() {
		return listOfAppointment;
	}

	public void setListOfAppointment(List<Appointment> listOfAppointment) {
		this.listOfAppointment = listOfAppointment;
	}

	public List<Stay> getListOfStay() {
		return listOfStay;
	}

	public void setListOfStay(List<Stay> listOfStay) {
		this.listOfStay = listOfStay;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}


	public String toString() {
		return "Patient [ssn=" + ssn + ", name=" + name + ", address=" + address + ", phone=" + phone + ", insuranceid="
				+ insuranceid + ", pcp=" + pcp + "]";
	}
	
	

}
