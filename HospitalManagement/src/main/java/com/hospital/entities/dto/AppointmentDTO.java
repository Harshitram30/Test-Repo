package com.hospital.entities.dto;

import java.sql.Timestamp;

public class AppointmentDTO {

	private Integer appointmentid;
	private Integer patient;
	private Integer prepnurse;
	private Integer physician;
	private Timestamp startDateTime;
	private Timestamp endDateTime;
	private String examinationroom;
	
	public AppointmentDTO() {
		super();
	}

	public AppointmentDTO(Integer appointmentid, Integer patient, Integer prepnurse, Integer physician, Timestamp startDateTime, Timestamp endDateTime, String examinationroom) {
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

}
