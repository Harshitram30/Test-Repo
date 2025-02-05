package com.hospital.services.impl;

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.hospital.entities.Physician;
import com.hospital.repositories.PhysicianRepository;
import com.hospital.services.PhysicianService;

@Service
public class PhysicianServiceImpl implements PhysicianService{

	@Autowired
	private PhysicianRepository physicianrepo;
	
	@Override
	public boolean registerPhysician(Physician physician) {
		physicianrepo.save(physician);
		return true;
	}
	
	public Physician getByName(String name) {
		Physician physician = physicianrepo.findByName(name);
		if (physician!=null) {
			return physician;
		}
		throw new RuntimeException("The Physician" + name + "does not exists");
		//return null;
		
	}

	//@Override
	public List<Physician> getByPosition(String position) {
        List<Physician> physicians = physicianrepo.findByPosition(position);
        return physicians;
    }

	//@Override
	public Physician getByEmpId(Integer id) {
		Physician physician = physicianrepo.findById(id).get();
		return physician;
	}

	@Override
	public Physician updatePosition(Integer id,String position) {
		Physician physician=physicianrepo.findById(id).get();
		if(physician != null) {
			physician.setPosition(position);
			physicianrepo.save(physician);
		}
		return physician;
	}

	@Override
	public Physician updateName(Integer id, String name) {
		Physician physician = physicianrepo.findById(id).get();
		if(physician != null) {
			physician.setName(name);
			physicianrepo.save(physician);
		}
		return physician;
	}

	@Override
	public Physician updateSSN(Integer id, Integer ssn) {
		Physician physician = physicianrepo.findById(id).get();
		if(physician != null) {
			physician.setSsn(ssn);
			physicianrepo.save(physician);
		}
		return physician;
	}
	
}
