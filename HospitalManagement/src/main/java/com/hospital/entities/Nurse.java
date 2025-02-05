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
@Table(name = "nurse")
public class Nurse implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "employeeid", nullable = false)
    private Integer employeeid;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "position", nullable = false, length = 30)
    private String position;

    @Column(name = "registered", nullable = false)
    private Boolean registered;

    @Column(name = "ssn", nullable = false)
    private Integer ssn;
    
    //Mapping
    @OneToMany(mappedBy = "nurse2")
    @JsonManagedReference
    private List<OnCall> listOfOnCall;
    
    @OneToMany(mappedBy = "nurse")
    @JsonManagedReference
    private List<Appointment> listOfAppointment;
    
    @OneToMany(mappedBy = "nurse")
    @JsonManagedReference
    private List<Undergoes> listOfUndergoes;

    public Nurse() {
        super();
    }

    public Nurse(Integer employeeid, String name, String position, Boolean registered, Integer ssn) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.position = position;
		this.registered = registered;
		this.ssn = ssn;
	}

	public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getEmployeeid() {
        return this.employeeid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public Boolean getRegistered() {
        return this.registered;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public Integer getSsn() {
        return this.ssn;
    }

	public List<OnCall> getListOfOnCall() {
		return this.listOfOnCall;
	}

	public List<Appointment> getListOfAppointment() {
		return this.listOfAppointment;
	}

	public List<Undergoes> getListOfUndergoes() {
		return this.listOfUndergoes;
	}

	public void setListOfOnCall(List<OnCall> listOfOnCall) {
		this.listOfOnCall = listOfOnCall;
	}

	public void setListOfAppointment(List<Appointment> listOfAppointment) {
		this.listOfAppointment = listOfAppointment;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public String toString() {
		return "Nurse [employeeid=" + employeeid + ", name=" + name + ", position=" + position + ", registered="
				+ registered + ", ssn=" + ssn + "]";
	}

}
