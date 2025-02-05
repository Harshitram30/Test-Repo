package com.hospital.entities;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hospital.entities.id.TrainedInId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trained_in")
@IdClass(TrainedInId.class)
public class TrainedIn implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "physician", nullable = false)
	private Integer physician;

	@Id
	@Column(name = "treatment", nullable = false)
	private Integer treatment;

	@Column(name = "certificationdate", nullable = false)
	private Date certificationdate;

	@Column(name = "certificationexpires", nullable = false)
	private Date certificationexpires;
	
	//Mapping
	@ManyToOne
	@JoinColumn(name = "treatment", referencedColumnName = "code", insertable = false, updatable = false)
	@JsonBackReference
	private Procedure procedure;

	@ManyToOne
	@JoinColumn(name = "physician", referencedColumnName = "employeeid", insertable = false, updatable = false)
	@JsonBackReference
	private Physician physician2;

	public TrainedIn() {
		super();
	}

	public TrainedIn(Integer physician, Integer treatment, Date certificationdate, Date certificationexpires) {
		super();
		this.physician = physician;
		this.treatment = treatment;
		this.certificationdate = certificationdate;
		this.certificationexpires = certificationexpires;
	}

	public Integer getPhysician() {
		return physician;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
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

	public Procedure getProcedure() {
		return this.procedure;
	}

	public Physician getPhysician2() {
		return this.physician2;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}

	public String toString() {
		return "TrainedIn [physician=" + physician + ", treatment=" + treatment + ", certificationdate="
				+ certificationdate + ", certificationexpires=" + certificationexpires + "]";
	}
	
}
