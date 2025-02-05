package com.hospital.entities.dto;

public class ProcedureDTO {

	private Integer code;
	private String name;
	private Double cost;

	public ProcedureDTO() {
		super();
	}
	
	public ProcedureDTO(Integer code, String name, Double cost) {
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

}
