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

import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.TrainedIn;
import com.hospital.entities.dto.DepartmentDTO;
import com.hospital.services.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	//running
	@PostMapping //http://localhost:9090/api/department
	public ResponseEntity<String> addDepartment(@RequestBody DepartmentDTO deptDTO) {
		Department d = new Department();
		d.setDepartmentid(deptDTO.getDepartmentid());
		d.setHead(deptDTO.getHead());
		d.setName(deptDTO.getName());
		service.addDepartment(d);
		return new ResponseEntity<String>("Record Created Successfully", HttpStatus.CREATED);
	}
	//running
	@GetMapping //http://localhost:9090/api/ department /
	public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> department = service.getAllDepartments();
		return new ResponseEntity<List<Department>>(department, HttpStatus.OK);

	}
	//running
	@GetMapping("/{id}") //http://localhost:9090/api/ department /{deptid}
	public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
		Department department = service.getById(id);
		return new ResponseEntity<Department>(department, HttpStatus.FOUND);
	}
	//running
	@GetMapping("/head/{id}")//http://localhost:9090/api/department/head/{deptid}
	public ResponseEntity<Physician> getHeadOfDepartmentById(@PathVariable Integer id) {
		Physician physician = service.getHeadById(id);
		return new ResponseEntity<Physician>(physician, HttpStatus.FOUND);
	}
	//running
	@GetMapping("/headcertification/{deptid}")//http://localhost:9090/api/department/headcertification/{deptid}
	public ResponseEntity<List<TrainedIn>> getCertificationByHeadId(@PathVariable Integer deptid) {
		List<TrainedIn> trainedIn = service.getCertificationByDepartmentId(deptid);
		if(trainedIn !=null) {
			return new ResponseEntity<List<TrainedIn>>(trainedIn, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//running
	@GetMapping("/get/{head}")//http://localhost:9090/api/department/get/{head}
	public ResponseEntity<List<Department>> getDepartmentByHead(@PathVariable Integer head) {
		List<Department> department = service.getDepartmentByHead(head);
		return new ResponseEntity<List<Department>>(department, HttpStatus.FOUND);
	}
	
	//running
	@PutMapping("update/headid/{deptid}")//http://localhost:9090/api/department/update/headid/{deptid}
	public ResponseEntity<Department> updateHeadBy(@PathVariable Integer deptid, @RequestBody DepartmentDTO departmentdto) {
		Department department = service.updateHeadBy(deptid,departmentdto.getHead());
		return new ResponseEntity<Department>(department, HttpStatus.OK);
		
	}
	
	//running
	@PutMapping("/update/deptname/{deptid}")//http://localhost:9090/api/department/update/deptname/{deptid}
	public ResponseEntity<Department> updateName(@PathVariable Integer deptid, @RequestBody DepartmentDTO departmentdto) {
		Department department = service.updateName(deptid,departmentdto.getName());
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}
}

