package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.hospital.entities.AffiliatedWith;
import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.dto.AffiliatedWithDTO;
import com.hospital.services.AffiliatedWithService;


@RestController
@RequestMapping("api/affiliated_with")
public class AffiliatedWithController {

	@Autowired
	private AffiliatedWithService service;
	
	//running
	@PostMapping("/post") //http://localhost:9090/api/affiliated_with/post
	public ResponseEntity<String> add(@RequestBody AffiliatedWithDTO afwDTO){
		AffiliatedWith afw = new AffiliatedWith();
		afw.setPhysician(afwDTO.getPhysician());
		afw.setDepartment(afwDTO.getDepartment());
		afw.setPrimaryaffiliation(afwDTO.getPrimaryaffiliation());
		service.add(afw);
		return new ResponseEntity<String>("Record Created Successfully", HttpStatus.CREATED);
	}
	//running
	@GetMapping("/physicians/{deptid}")//http://localhost:9090/api/affiliated_with/physicians/{deptid}
	public ResponseEntity<List<Physician>> getPhysicianByDept(@PathVariable Integer deptid){
		List<Physician> phy = service.getPhysicianByDepartment(deptid);
		if(phy != null) {
			return new ResponseEntity<List<Physician>>(phy, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//running
	@GetMapping("/department/{physicianid}")//http://localhost:9090/api/ affiliated_with /department/{physicianid}
	public ResponseEntity<List<Department>> getDepartmentByPhysician(@PathVariable Integer physicianid){
		List<Department> dep = service.getDepartmentByPhysician(physicianid);
		if(dep != null) {
			return new ResponseEntity<List<Department>>(dep, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//running
	@GetMapping("/countphysician/{deptid}") //http://localhost:9090/api/affiliated_with /countphysician/{deptid}
	public ResponseEntity<Integer> getPhysicianCount(@PathVariable Integer deptid) {
		 Integer phy = service.getByPhysicianId(deptid);
		 return new ResponseEntity<Integer>(phy, HttpStatus.OK);
	}
	
	//running for unique value
	@GetMapping("/primary/{physicianid}")//http://localhost:9090/api/affiliated_with/primary/{physicianid}
	public ResponseEntity<Boolean> getPrimaryAffiliationByPhysician(@PathVariable Integer physicianid){
		boolean pa=service.getPrimaryAffiliationByPhysician(physicianid);
		return new ResponseEntity<Boolean>(pa, HttpStatus.FOUND);
	}
	
	//running
	@PutMapping("/primary/{physicianid}/{pa}")//http://localhost:9090/api/affiliated_with/primary/{physicianid}/{pa}
	public ResponseEntity<Boolean> updatePrimaryAffiliation(@PathVariable Integer physicianid, @PathVariable boolean pa){
		boolean priaff=service.updatePrimaryAffiliation(physicianid, pa);
		return new ResponseEntity<Boolean>(priaff, HttpStatus.FOUND);
	}
	
}
