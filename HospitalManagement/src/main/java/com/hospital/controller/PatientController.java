package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.Patient;
import com.hospital.entities.dto.PatientDTO;
import com.hospital.exceptions.NotFoundException;
import com.hospital.services.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService service;
	
	@PostMapping
	public ResponseEntity<String> savePatient(@RequestBody PatientDTO patientDTO) {
		Patient newPatient = new Patient();
		newPatient.setSsn(patientDTO.getSsn());
		newPatient.setName(patientDTO.getName());
		newPatient.setAddress(patientDTO.getAddress());
		newPatient.setPhone(patientDTO.getPhone());
		newPatient.setInsuranceid(patientDTO.getInsuranceid());
		newPatient.setPcp(patientDTO.getPcp());
		service.addPatient(newPatient);
		return new ResponseEntity<String>("Record Created Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Patient>> getPatient(){
		List<Patient> patients=service.getAll();
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
	}
	
	@GetMapping("/{pcp}")
	public ResponseEntity<List<Patient>> getPatientBy(@PathVariable Integer pcp){
		List<Patient> patients=service.getByPcp(pcp);
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
	}
	
	@GetMapping("/{pcp}/{ssn}")
	public ResponseEntity<Patient> getPatientByPhysician(@PathVariable Integer pcp, @PathVariable Integer ssn){
		Patient patient = service.getDetailsByPcp(pcp, ssn);
		if(patient!=null) {
			return new ResponseEntity<Patient>(patient, HttpStatus.FOUND);
		}else {
			throw new NotFoundException("Patient not found");
		}
	}
	
	@GetMapping("/insurance/{ssn}")
	public ResponseEntity<Integer> getInsuranceId(@PathVariable Integer ssn){
		if(service.getById(ssn)!=null) {
			Integer insurance=service.getInsuranceIdBy(ssn);
			return new ResponseEntity<Integer>(insurance, HttpStatus.FOUND);
		}
		else {
			throw new NotFoundException("Patient not found");
		}
	}
	
	@PutMapping("/address/{ssn}")
	public ResponseEntity<Patient> updateAddress(@PathVariable Integer ssn, @RequestBody PatientDTO patientDTO){
		if(service.getById(ssn)!=null) {
			Patient patient = service.updateAddressBy(ssn, patientDTO.getAddress());
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}else {
			throw new NotFoundException("Patient not found");
		}
	}
	
	@PutMapping("/phone/{ssn}")
	public ResponseEntity<Patient> updatePhone(@PathVariable Integer ssn, @RequestBody PatientDTO patientDTO){
		if(service.getById(ssn)!=null) {
			Patient patient = service.updatePhoneBy(ssn, patientDTO.getPhone());
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}else {
			throw new NotFoundException("Patient not found");
		}
	}

}
