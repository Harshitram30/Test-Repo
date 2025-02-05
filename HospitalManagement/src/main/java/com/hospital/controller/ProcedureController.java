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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.entities.Procedure;
import com.hospital.entities.dto.ProcedureDTO;
import com.hospital.exceptions.NotFoundException;
import com.hospital.services.ProcedureService;

@RestController
@RequestMapping("api/procedure")
public class ProcedureController {

	@Autowired
	private ProcedureService service;

	@PostMapping
	public ResponseEntity<String> addTreatment(@RequestBody ProcedureDTO proceduredto) {
		Procedure procedure = new Procedure();
		procedure.setCode(proceduredto.getCode());
		procedure.setName(proceduredto.getName());
		procedure.setCost(proceduredto.getCost());
		service.addTreatment(procedure);
		return new ResponseEntity<String>("Record Created Successfully", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Procedure>> getAllProcedures() {
		List<Procedure> procedures = service.getAll();
		return new ResponseEntity<List<Procedure>>(procedures, HttpStatus.OK);
	}

	@GetMapping("/cost/{id}")
	public ResponseEntity<Procedure> getCostById(@PathVariable Integer id) {
		Procedure procedure = service.getCostBy(id);
		if (procedure != null) {
			return ResponseEntity.ok(procedure);
		} else {
			throw new NotFoundException("Invalid Id");
		}
	}

	@GetMapping("/cost1/{name}")
	public ResponseEntity<Procedure> getCostByName(@PathVariable String name) {
		Procedure procedure = service.getCostByName(name);
		if (procedure != null) {
			return ResponseEntity.ok(procedure);
		} else {
			throw new NotFoundException("Invalid name");
		}
	}

	@PutMapping("/cost/id/{id}")
	public ResponseEntity<Procedure> updateCostById(@PathVariable Integer id, @RequestBody ProcedureDTO proceduredto) {
		Procedure procedure = service.updateCostBy(id, proceduredto.getCost());
		if (procedure != null) {
			return ResponseEntity.ok(procedure);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("/name/{id}")
	public ResponseEntity<Procedure> updateNameById(@PathVariable Integer id, @RequestBody ProcedureDTO proceduredto) {
		Procedure procedure = service.updateNameBy(id, proceduredto.getName());
		if (procedure != null) {
			return ResponseEntity.ok(procedure);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
