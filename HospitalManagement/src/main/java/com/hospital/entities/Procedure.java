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
@Table(name="procedures")
public class Procedure implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code", nullable = false)
	private Integer code;

	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "cost", nullable = false)
	private Double cost;
	
	//Mapping
	@OneToMany(mappedBy = "procedure")
	@JsonManagedReference
	private List<TrainedIn> listofTrainedIn;

	@OneToMany(mappedBy = "procedure2")
	@JsonManagedReference
	private List<Undergoes> listOfUndergoes;
	
	public Procedure() {
		super();
	}

	public Procedure(Integer code, String name, Double cost) {
		super();
		this.code = code;
		this.name = name;
		this.cost = cost;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public List<TrainedIn> getListofTrainedIn() {
		return listofTrainedIn;
	}

	public void setListofTrainedIn(List<TrainedIn> listofTrainedIn) {
		this.listofTrainedIn = listofTrainedIn;
	}

	public List<Undergoes> getListOfUndergoes() {
		return listOfUndergoes;
	}

	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
		this.listOfUndergoes = listOfUndergoes;
	}

	public String toString() {
		return "Procedure [code=" + code + ", name=" + name + ", cost=" + cost + "]";
	}
	
}
