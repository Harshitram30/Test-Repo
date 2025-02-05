package com.hospital.entities.dto;

import java.sql.Date;

public class TrainedInDTO {
	
	private Integer physicianid;
	private Integer treatment;
	private Date certificationdate;
	private Date certificationexpires;
	public TrainedInDTO(Integer physicianid, Integer treatment, Date certificationdate, Date certificationexpires) {
		super();
		this.physicianid = physicianid;
		this.treatment = treatment;
		this.certificationdate = certificationdate;
		this.certificationexpires = certificationexpires;
	}
	public Integer getPhysicianid() {
		return physicianid;
	}
	public void setPhysicianid(Integer physicianid) {
		this.physicianid = physicianid;
	}
	public Integer getTreatment() {
		return treatment;
	}
	public void setTreatment(Integer treatment) {
		this.treatment = treatment;
	}
	public Date getCertificationdate() {
		return certificationdate;
	}
	public void setCertificationdate(Date certificationdate) {
		this.certificationdate = certificationdate;
	}
	public Date getCertificationexpires() {
		return certificationexpires;
	}
	public void setCertificationexpires(Date certificationexpires) {
		this.certificationexpires = certificationexpires;
	}
}
