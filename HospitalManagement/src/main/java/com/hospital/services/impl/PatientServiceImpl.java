package com.hospital.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Patient;
import com.hospital.exceptions.NotFoundException;
import com.hospital.repositories.PatientRepository;
import com.hospital.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository repository;
	
	public boolean addPatient(Patient patient) {
		repository.save(patient);
		return true;
	}

	public List<Patient> getAll() {
		return repository.findAll();
	}

	public Patient getById(Integer ssn) {
		return repository.findById(ssn).get();
	}

	public List<Patient> getByPcp(Integer pcp) {
		return repository.findByPcp(pcp);
	}

	public Patient getDetailsByPcp(Integer pcp, Integer ssn) {
		return repository.getPatientDetailsBy(pcp, ssn);
	}

	public Integer getInsuranceIdBy(Integer ssn) {
		return repository.findById(ssn).get().getInsuranceid();
	}

	public Patient updateAddressBy(Integer ssn, String address) {
		Patient patient = repository.findById(ssn).get();
		if(patient!=null) {
			patient.setAddress(address);
			repository.save(patient);
		}
		return patient;
	}

	public Patient updatePhoneBy(Integer ssn, String phone) {
		Patient patient = repository.findById(ssn).get();
		if(patient!=null) {
			patient.setPhone(phone);
			repository.save(patient);
		}
		return patient;
	}

}
