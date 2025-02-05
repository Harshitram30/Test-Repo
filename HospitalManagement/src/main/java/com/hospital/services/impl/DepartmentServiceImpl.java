package com.hospital.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.entities.TrainedIn;
import com.hospital.repositories.DepartmentRepository;
import com.hospital.services.DepartmentService;


@Service

public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public boolean addDepartment(Department department) {
		departmentRepository.save(department);
		return true;
	}

	// @Override
	public List<Department> getAllDepartments() {

		return departmentRepository.findAll();
	}

	// @Override
	public Department getById(Integer id) {
		Department department = departmentRepository.findById(id).get();
		return department;
	}

	// @Overrides
	public Physician getHeadById(Integer id) {
		return departmentRepository.findHeadById(id);

	}

	// @Override
	public List<TrainedIn> getCertificationByDepartmentId(Integer departmentid) {
		return departmentRepository.findCertificationByHeadId(departmentid);
	}

	public List<Department> getDepartmentByHead(Integer head) {
		return departmentRepository.findByHead(head);

	}

	@Override
	public Department updateName(Integer deptid, String name) {
		Department dept = departmentRepository.findById(deptid).get();
		if (dept != null) {
			dept.setName(name);
			departmentRepository.save(dept);
		}
		return dept;
	}

	@Override
	public Department updateHeadBy(Integer departmentid,Integer head) {
		Department dept = departmentRepository.findById(departmentid).get();
		if (dept != null) {
			dept.setHead(head);
			departmentRepository.save(dept);
		}
		return dept;
	}

}

