package com.hospital.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Nurse;
import com.hospital.repositories.NurseRepository;
import com.hospital.services.NurseService;

@Service
public class NurseServiceImpl implements NurseService{

	@Autowired
	private NurseRepository repository;
	
	public boolean registerNurse(Nurse nurse) {
		repository.save(nurse);
		return true;
	}

	public List<Nurse> getAll() {
		return repository.findAll();
	}

	public Nurse getById(Integer id) {
		return repository.findById(id).get();
	}

	public String getPositionBy(Integer id) {
		return repository.findById(id).get().getPosition();
	}

	public boolean getRegisteredBy(Integer id) {
		return repository.findById(id).get().getRegistered();
	}

	public Nurse updateRegisteredBy(Integer id, Boolean registered) {
		Nurse nurse = repository.findById(id).get();
		if(nurse!=null) {
			nurse.setRegistered(registered);
			repository.save(nurse);
		}
		return nurse;
	}

	public Nurse updateSsnBy(Integer id, Integer ssn) {
		Nurse nurse = repository.findById(id).get();
		if(nurse!=null) {
			nurse.setSsn(ssn);
			repository.save(nurse);
		}
		return nurse;
	}

	public boolean deleteBy(Integer id) {
		repository.deleteById(id);
		return true;
	}
	

}
