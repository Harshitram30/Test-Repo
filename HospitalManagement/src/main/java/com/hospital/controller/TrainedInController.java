package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.Physician;
import com.hospital.entities.Procedure;
import com.hospital.entities.TrainedIn;
import com.hospital.entities.dto.TrainedInDTO;
import com.hospital.services.TrainedInService;

@RestController
@RequestMapping("/api/trained_in")
public class TrainedInController {

	@Autowired
	private TrainedInService service;

	//running
	@GetMapping
	public ResponseEntity<List<TrainedIn>> getWithCertification() {
		List<TrainedIn> certificate = service.getProcedureByCertification();
		return new ResponseEntity<List<TrainedIn>>(certificate, HttpStatus.FOUND);

	}
	
	//running
	@GetMapping("/treatment/test")
	public ResponseEntity<List<Procedure>> getTreatment(@RequestParam("id") Integer physicianid){
		List<Procedure> list = service.getTreatment(physicianid);
		return new ResponseEntity<List<Procedure>>(list, HttpStatus.FOUND);
	
	}
	
	//running
	@GetMapping("/physician/{procedureid}")
	public ResponseEntity<List<Physician>> getPhysician(@PathVariable Integer procedureid) {
		List<Physician> list = service.getPhysicican(procedureid);
		return new ResponseEntity<List<Physician>>(list, HttpStatus.FOUND);
	}

	
    @PutMapping("/certificationexpiry/{physicianid}/{procedureid}")
    public ResponseEntity<TrainedIn> updatePhysicianAndProcedure(@PathVariable Integer physicianid,@PathVariable Integer procedureid,@RequestBody TrainedInDTO trainedindto) {
    	TrainedIn trained=service.updateCertificationExpires(physicianid, procedureid, trainedindto.getCertificationexpires());
    	return new ResponseEntity<TrainedIn>(trained, HttpStatus.OK);
    
    }
}

