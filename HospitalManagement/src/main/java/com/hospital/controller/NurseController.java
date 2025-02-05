package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.Nurse;
import com.hospital.entities.dto.NurseDTO;
import com.hospital.exceptions.NotFoundException;
import com.hospital.services.NurseService;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {
	
	@Autowired
	private NurseService service;
	
	@PostMapping
	public ResponseEntity<String> saveNurse(@RequestBody NurseDTO nurseDTO) {
		Nurse nurse = new Nurse();
        nurse.setEmployeeid(nurseDTO.getEmployeeid());
        nurse.setName(nurseDTO.getName());
        nurse.setPosition(nurseDTO.getPosition());
        nurse.setRegistered(nurseDTO.getRegistered());
        nurse.setSsn(nurseDTO.getSsn());
        service.registerNurse(nurse);
		return new ResponseEntity<String>("Record Created Successfully", HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Nurse>> getNurse(){
		List<Nurse> nurses=service.getAll();
		return new ResponseEntity<List<Nurse>>(nurses, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Nurse> getNurseBy(@PathVariable Integer id) {
		Nurse nurse=service.getById(id);
		if(nurse==null) {
			throw new NotFoundException("Nurse not found");
		}else {
			return new ResponseEntity<Nurse>(nurse, HttpStatus.FOUND);
		}
	}
	
	@GetMapping("/position/{id}")
	public ResponseEntity<String> getPositionBy(@PathVariable Integer id) {
		String pos=service.getPositionBy(id);
		if(pos==null) {
			throw new NotFoundException("Position of nurse not found");
		}else {
			return new ResponseEntity<String>(pos, HttpStatus.FOUND);
		}
	}
	
	@GetMapping("/registered/{id}")
	public ResponseEntity<Boolean> getRegisteredBy(@PathVariable Integer id){
		Boolean register=service.getRegisteredBy(id);
		return new ResponseEntity<Boolean>(register, HttpStatus.FOUND);
	}
	
	@PutMapping("/registered/{id}")
	public ResponseEntity<Nurse> updateRegisteredBy(@PathVariable Integer id, @RequestBody NurseDTO nurseDTO){
		Nurse n= service.getById(id);
		if(n!=null) {
			Nurse nurse = service.updateRegisteredBy(id, nurseDTO.getRegistered());
			return new ResponseEntity<Nurse>(nurse, HttpStatus.OK);
		}else {
			throw new NotFoundException("Nurse not found");
		}
	}
	
	@PutMapping("/ssn/{id}")
	public ResponseEntity<Nurse> updateSsnBy(@PathVariable Integer id, @RequestBody NurseDTO nurseDTO){
		Nurse n= service.getById(id);
		if(n!=null) {
			Nurse nurse = service.updateSsnBy(id, nurseDTO.getSsn());
			return new ResponseEntity<Nurse>(nurse, HttpStatus.OK);
		}else {
			throw new NotFoundException("Nurse not found");
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		Nurse n= service.getById(id);
		if(n!=null) {
			service.deleteBy(id);
			return new ResponseEntity<String>("Record Deleted Successfully", HttpStatus.OK);
		}else {
			throw new NotFoundException("Nurse not found");
		}
	}

}
