package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointmentid", nullable = false)
	private Integer appointmentid;

	@Column(name = "patient", nullable = false)
	private Integer patient;

	@Column(name = "prepnurse")
	private Integer prepnurse;

	@Column(name = "physician", nullable = false)
	private Integer physician;

	@Column(name = "start_dt_time", nullable = false)
	private Timestamp startDateTime;
	
	@Column(name = "end_dt_time", nullable = false)
	private Timestamp endDateTime;

	@Column(name = "examinationroom", nullable = false)
	private String examinationroom;

	//Mapping
	@OneToMany(mappedBy = "appointment2")
	@JsonManagedReference
	private List<Prescribes> listOfPrescribes;
	
	@ManyToOne
	@JoinColumn(name = "patient", referencedColumnName = "ssn", insertable = false, updatable = false)
	@JsonBackReference
	private Patient patient2;
	
	@ManyToOne
	@JoinColumn(name = "physician", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonBackReference
	private Physician physician2;

	@ManyToOne
	@JoinColumn(name = "prepnurse", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonBackReference
	private Nurse nurse;
	
	public Appointment() {
		super();
	}

	public Appointment(Integer appointmentid, Integer patient, Integer prepnurse, Integer physician,
			Timestamp startDateTime, Timestamp endDateTime, String examinationroom) {
		super();
		this.appointmentid = appointmentid;
		this.patient = patient;
		this.prepnurse = prepnurse;
		this.physician = physician;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.examinationroom = examinationroom;
	}

	public Integer getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public Integer getPatient() {
		return patient;
	}

	public void setPatient(Integer patient) {
		this.patient = patient;
	}

	public Integer getPrepnurse() {
		return prepnurse;
	}

	public void setPrepnurse(Integer prepnurse) {
		this.prepnurse = prepnurse;
	}

	public Integer getPhysician() {
		return physician;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getExaminationroom() {
		return examinationroom;
	}

	public void setExaminationroom(String examinationroom) {
		this.examinationroom = examinationroom;
	}

	public List<Prescribes> getListOfPrescribes() {
		return this.listOfPrescribes;
	}

	public Patient getPatient2() {
		return this.patient2;
	}

	public Physician getPhysician2() {
		return this.physician2;
	}

	public Nurse getNurse() {
		return this.nurse;
	}

	public void setListOfPrescribes(List<Prescribes> listOfPrescribes) {
		this.listOfPrescribes = listOfPrescribes;
	}

	public void setPatient2(Patient patient2) {
		this.patient2 = patient2;
	}

	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", patient=" + patient + ", prepnurse=" + prepnurse
				+ ", physician=" + physician + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime
				+ ", examinationroom=" + examinationroom + "]";
	}

}
