package com.hospital.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;

public interface AppointmentService {

	boolean createAppointment(Appointment appointment);
	List<Appointment> getAllAppointments();
	List<Appointment> getAppointmentsByStartDate(Timestamp startdate);
	Optional<Patient> findPatientByAppointmentId(Integer appointmentId);
	Optional<Physician> getPhysicianByAppointmentId(Integer appointmentId);
	Optional<Nurse> getNurseByAppointmentId(Integer appointmentId);
	Room getRoomByAppointmentId(Integer appointmentId);
	List<Physician> getPhysiciansByPatientId(Integer patientId);
	Physician getPhysicianByPatientIdAndDate(Integer patientId, Timestamp date);
	List<Nurse> getNursesByPatientId(Integer patientId);
	Nurse getNurseByPatientIdAndDate(Integer patientId, Timestamp date);
	List<Date> getAppointmentDatesByPatientId(Integer patientId);
	Room getRoomDetailsByPatientIdAndDate(Integer patientId, Timestamp date);
	List<Room> getRoomByPhysicianIdAndDate(Integer employeeid, Timestamp date);

	// PRIYANKA
	List<Patient> getPatientByPhysician(Integer physicianid);
	List<Patient> getPatientByPhysicianAndDate(Integer physicianid, Timestamp date);
	Patient getPatientByPhysicianAndPatientId(Integer physicianid, Integer patientid);
	List<Patient> getPatientByNurse(Integer nurseid);
	List<Patient> getPatientByNurseAndDate(Integer nurseid, Timestamp date);
	List<Room> getRoomDetailsByNurseAndDate(Integer nurseid, Timestamp date);
	Appointment updateExaminationRoomBy(Integer appointmentid, String examinationroom);
	
}
