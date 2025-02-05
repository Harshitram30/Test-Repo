package com.hospital.services.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Physician;
import com.hospital.entities.Procedure;
import com.hospital.entities.TrainedIn;
import com.hospital.repositories.TrainedInRepository;
import com.hospital.services.TrainedInService;

@Service
public class TrainedInServiceImpl implements TrainedInService {

	@Autowired
	private TrainedInRepository trainedInRepository;

	@Override
	public boolean addCertificate(TrainedIn certificate) {
		trainedInRepository.save(certificate);
		return true;
	}

	@Override
	public List<TrainedIn> getProcedureByCertification() {
		return trainedInRepository.findAll();

	}

	@Override
	public List<Procedure> getTreatment(Integer physicianid) {
		return trainedInRepository.findTreatmentByPhysician(physicianid);

	}

	@Override
	public List<Physician> getPhysicican(Integer procedureid) {
		return trainedInRepository.findPhysicianByTreatment(procedureid);

	}

	@Override
	public TrainedIn updateCertificationExpires(Integer physicianid, Integer procedureid, Date certificationexpires) {
		TrainedIn trained = trainedInRepository.findByPhysicianAndProcedure(physicianid, procedureid);
		if (trained != null) {
			trained.setCertificationexpires(certificationexpires);
			trainedInRepository.save(trained);
		}
		return trained;
	}

}
