package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hospital.entities.Physician;
import com.hospital.entities.dto.PhysicianDTO;
import com.hospital.repositories.PhysicianRepository;
import com.hospital.services.PhysicianService;

@RestController
@RequestMapping("api/physician")
public class PhysicianController {

	@Autowired
	private PhysicianService service;

	//running
	@PostMapping //http://localhost:9090/api/physician
	public ResponseEntity<Physician> savePhysician(@RequestBody PhysicianDTO physicianDTO){
		Physician physician = new Physician();
		physician.setEmployeeid(physicianDTO.getEmployeeid());
		physician.setName(physicianDTO.getName());
		physician.setPosition(physicianDTO.getPosition());
		physician.setSsn(physicianDTO.getSsn());
		service.registerPhysician(physician);
		return new ResponseEntity<Physician> (physician, HttpStatus.OK);
	}

	//running for unique values
	@GetMapping("/name/{name}") //http://localhost:9090/api/physician/name/{name}
	public ResponseEntity<Physician> getPhysician(@PathVariable String name){
		Physician physician = service.getByName(name);
		return new ResponseEntity<Physician>(physician, HttpStatus.FOUND);
	}

	//running
	@GetMapping("/position/{position}") //http://localhost:9090/api/physician/position/{pos}
	public ResponseEntity<List<Physician>> getByPosition(@PathVariable("position") String position) {
		List<Physician> physician = service.getByPosition(position);
		if(physician.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return ResponseEntity.ok(physician);
		}
	}

	//running
	@GetMapping("/{id}") //http://localhost:9090/api/physician/{empid}
	public ResponseEntity<Physician> getPhysician(@PathVariable Integer id){
		Physician physician = service.getByEmpId(id);
		return new ResponseEntity<Physician>(physician, HttpStatus.FOUND);
	}

	//running
	@PutMapping("/update/position/{id}") //http://localhost:9090/api/physician/update/position/{empid}
	public ResponseEntity<Physician> updatePosition(@PathVariable Integer id,@RequestBody PhysicianDTO physicianDTO){
		Physician physician = service.updatePosition(id, physicianDTO.getPosition());
		if(physician==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Physician>(physician, HttpStatus.FOUND);
		}
	}

	//running
	@PutMapping("/update/name/{id}") //http://localhost:9090/api/physician/update/name/{empid}
	public ResponseEntity<Physician> updateName(@PathVariable Integer id, @RequestBody PhysicianDTO physicianDTO){
		Physician physician = service.updateName(id, physicianDTO.getName());
		if(physician==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Physician>(physician, HttpStatus.FOUND);
		}

	}

	//running
	@PutMapping("/update/ssn/{id}") //http://localhost:9090/api/physyician/update/ssn/{empid}
	public ResponseEntity<Physician> updateSsn(@PathVariable Integer id, @RequestBody PhysicianDTO physicianDTO){
		Physician physician = service.updateSSN(id, physicianDTO.getSsn());
		if(physician == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<Physician>(physician, HttpStatus.FOUND);
		}

	}
}
