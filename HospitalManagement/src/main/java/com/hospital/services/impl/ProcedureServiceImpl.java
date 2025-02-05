package com.hospital.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.entities.Procedure;
import com.hospital.repositories.ProcedureRepository;
import com.hospital.services.ProcedureService;

@Service
public class ProcedureServiceImpl implements ProcedureService {
	
	@Autowired
	private ProcedureRepository procedureRepository;

	public boolean addTreatment(Procedure procedure) {
		procedureRepository.save(procedure);
		return true;
	}

	public List<Procedure> getAll() {
		return procedureRepository.findAll();
	}

	public Procedure getCostBy(Integer id) {
		Optional<Procedure> optionalProcedure = procedureRepository.findById(id);
		return optionalProcedure.get();
	}

	public Procedure getCostByName(String name) {
		return procedureRepository.findCostByName(name);
	}

	public Procedure updateCostBy(Integer id, Double cost) {
		Optional<Procedure> optionalProcedure = procedureRepository.findById(id);
		if (optionalProcedure.isPresent()) {
			Procedure procedure = optionalProcedure.get();
			procedure.setCost(cost);
			procedureRepository.save(procedure);
			return procedure;
		}
		return null;
	}

	public Procedure updateNameBy(Integer id, String name) {
		Optional<Procedure> optionalProcedure = procedureRepository.findById(id);
		if (optionalProcedure.isPresent()) {
			Procedure procedure = optionalProcedure.get();
			procedure.setName(name);
			procedureRepository.save(procedure);
			return procedure;
		}
		return null;
	}
	
	public String deleteBy(Integer id) {
		procedureRepository.deleteById(id);
		return "Record Deleted Successfully";
	}
}
