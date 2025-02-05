package com.hospital.services.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;
import com.hospital.repositories.AppointmentRepository;
import com.hospital.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentRepository repository;

	public boolean createAppointment(Appointment appointment) {
		try {
			repository.save(appointment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Appointment> getAllAppointments() {
		return repository.findAll();
	}

	public List<Appointment> getAppointmentsByStartDate(Timestamp startdate) {
		try {
			return repository.findByStartDateTime(startdate);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.");
		}
	}
	
	public Optional<Patient> findPatientByAppointmentId(Integer appointmentId) {
		return repository.findPatientByAppointmentId(appointmentId);
	}

	public Optional<Physician> getPhysicianByAppointmentId(Integer appointmentId) {
		return repository.findPhysicianByAppointmentId(appointmentId);
	}

	public Optional<Nurse> getNurseByAppointmentId(Integer appointmentId) {
		return repository.findNurseByAppointmentId(appointmentId);
	}

	public Room getRoomByAppointmentId(Integer appointmentId) {
		return repository.findRoomByAppointmentId(appointmentId);
	}

	public List<Physician> getPhysiciansByPatientId(Integer patientId) {
		return repository.findPhysiciansByPatientId(patientId);
	}

	public Physician getPhysicianByPatientIdAndDate(Integer patientId, Timestamp date) {
		return repository.findPhysicianByPatientIdAndDate(patientId, date);
	}
	
	public List<Nurse> getNursesByPatientId(Integer patientId) {
		return repository.findNursesByPatientId(patientId);
	}

	public Nurse getNurseByPatientIdAndDate(Integer patientId, Timestamp date) {
		return repository.findNurseByPatientIdAndDate(patientId, date);
	}

	public List<Date> getAppointmentDatesByPatientId(Integer patientId) {
		return repository.findAppointmentDatesByPatientId(patientId);
	}

	public Room getRoomDetailsByPatientIdAndDate(Integer patientId, Timestamp date) {
		return repository.findRoomByPatientIdAndDate(patientId, date);
	}

	public List<Room> getRoomByPhysicianIdAndDate(Integer employeeid, Timestamp date) {
		return repository.findRoomByPhysicianIdAndDate(employeeid, date);
	}

	// PRIYANKA
	public List<Patient> getPatientByPhysician(Integer physicianid) {
		return repository.findPatientByPhysician(physicianid);
	}

	public List<Patient> getPatientByPhysicianAndDate(Integer physicianid, Timestamp date) {
		return repository.findPatientByPhysicianAndDate(physicianid, date);
	}

	public Patient getPatientByPhysicianAndPatientId(Integer physicianid, Integer patientid) {
		return repository.findPatientByPhysicianAndPatientId(physicianid, patientid);
	}

	public List<Patient> getPatientByNurse(Integer nurseid) {
		return repository.findPatientByNurse(nurseid);
	}

	public List<Patient> getPatientByNurseAndDate(Integer nurseid, Timestamp date) {
		return repository.findPatientByNurseAndDate(nurseid, date);
	}

	public List<Room> getRoomDetailsByNurseAndDate(Integer nurseid, Timestamp date) {
		return repository.findRoomDetailsByNurseAndDate(nurseid, date);
	}

	public Appointment updateExaminationRoomBy(Integer appointmentid, String examinationroom) {
		Appointment app = repository.findById(appointmentid).get();
		if (app != null) {
			app.setExaminationroom(examinationroom);
			repository.save(app);
		}
		return app;
	}
	
}
