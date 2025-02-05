package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "physician")
public class Physician implements Serializable{
	
	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employeeid", nullable = false)
	private Integer employeeid;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "position", nullable = false, length = 30)
	private String position;

	@Column(name = "ssn", nullable = false)
	private Integer ssn;
	
	//Mapping
	@OneToMany(mappedBy = "physician")
	@JsonManagedReference
	private List<Department> listOfDepartment;
	
	@OneToMany(mappedBy = "physician2")
	@JsonManagedReference
	private List<Undergoes> listOfUndergoes;
	
	@OneToMany(mappedBy = "physician2")
	@JsonManagedReference
	private List<AffiliatedWith> listOfAffiliatedWith;
	
	@OneToMany(mappedBy = "physician2")
	@JsonManagedReference
	private List<TrainedIn> listOfTrainedIn;
	
	@OneToMany(mappedBy = "physician2")
	@JsonManagedReference
	private List<Prescribes> listOfPrescribes;
	
	@OneToMany(mappedBy = "physician")
	@JsonManagedReference
	private List<Patient> listOfPatient;
	
	@OneToMany(mappedBy = "physician2")
	@JsonManagedReference
	private List<Appointment> listOfAppointment;

	public Physician() {
		super();
	}

	public Physician(Integer employeeid, String name, String position, Integer ssn) {
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

	public List<Department> getListOfDepartment() {
		return listOfDepartment;
	}

	public void setListOfDepartment(List<Department> listOfDepartment) {
		this.listOfDepartment = listOfDepartment;
	}

	public List<Undergoes> getListOfUndergoes() {
		return listOfUndergoes;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public List<AffiliatedWith> getListOfAffiliatedWith() {
		return listOfAffiliatedWith;
	}

	public void setListOfAffiliatedWith(List<AffiliatedWith> listOfAffiliatedWith) {
		this.listOfAffiliatedWith = listOfAffiliatedWith;
	}

	public List<TrainedIn> getListOfTrainedIn() {
		return listOfTrainedIn;
	}

	public void setListOfTrainedIn(List<TrainedIn> listOfTrainedIn) {
		this.listOfTrainedIn = listOfTrainedIn;
	}

	public List<Prescribes> getListOfPrescribes() {
		return listOfPrescribes;
	}

	public void setListOfPrescribes(List<Prescribes> listOfPrescribes) {
		this.listOfPrescribes = listOfPrescribes;
	}

	public List<Patient> getListOfPatient() {
		return listOfPatient;
	}

	public void setListOfPatient(List<Patient> listOfPatient) {
		this.listOfPatient = listOfPatient;
	}

	public List<Appointment> getListOfAppointment() {
		return listOfAppointment;
	}

	public void setListOfAppointment(List<Appointment> listOfAppointment) {
		this.listOfAppointment = listOfAppointment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return "Physician [employeeid=" + employeeid + ", name=" + name + ", position=" + position + ", ssn=" + ssn
				+ "]";
	}

}
