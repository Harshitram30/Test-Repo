package com.hospital.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hospital.entities.AffiliatedWith;
import com.hospital.entities.Department;
import com.hospital.entities.Physician;
import com.hospital.repositories.AffiliatedWithRepository;
import com.hospital.services.AffiliatedWithService;

@Service
public class AffiliatedWithServiceImpl implements AffiliatedWithService {

	@Autowired
	private AffiliatedWithRepository awrepo;

	public boolean add(AffiliatedWith afw) {
		awrepo.save(afw);
		return true;
	}
	
	@Override
	public List<Physician> getPhysicianByDepartment(Integer departmentid) {
		return awrepo.findPhysicianByDepartment(departmentid);
	}
	
	@Override
	public List<Department> getDepartmentByPhysician(Integer physicianid) {
		return awrepo.findDepartmentByPhysician(physicianid);
	}

	@Override
	public Integer getByPhysicianId(Integer deptId) {
		return awrepo.getPhysicianCount(deptId);
	}

	public boolean getPrimaryAffiliationByPhysician(Integer physicianId) {
		return awrepo.getPrimaryAffiliationByPhysician(physicianId);
	}
	
	public Boolean updatePrimaryAffiliation(Integer physicianid, boolean pa) {
		boolean afw = awrepo.getPrimaryAffiliationByPhysician(physicianid);
		if(afw!=pa) {
			afw=pa;
		}
		return pa;
	}
}
