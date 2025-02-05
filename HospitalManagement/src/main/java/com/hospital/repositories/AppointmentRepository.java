package com.hospital.repositories;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	List<Appointment> findByStartDateTime(Timestamp startDateTime);

	@Query("SELECT a.patient2 FROM Appointment a WHERE a.appointmentid = :appointmentId")
	Optional<Patient> findPatientByAppointmentId(@Param("appointmentId") Integer appointmentId);

	@Query("SELECT a.physician2 FROM Appointment a WHERE a.appointmentid = :appointmentId")
	Optional<Physician> findPhysicianByAppointmentId(@Param("appointmentId") Integer appointmentId);

	@Query("SELECT a.nurse FROM Appointment a WHERE a.appointmentid = :appointmentId")
	Optional<Nurse> findNurseByAppointmentId(@Param("appointmentId") Integer appointmentId);

	@Query("SELECT r FROM Room r JOIN r.listOfStay s JOIN s.patient2 p JOIN p.listOfAppointment a WHERE a.appointmentid = :appointmentId")
	Room findRoomByAppointmentId(@Param("appointmentId") Integer appointmentId);

	@Query("SELECT DISTINCT a.physician2 FROM Appointment a WHERE a.patient = :patientId")
	List<Physician> findPhysiciansByPatientId(@Param("patientId") Integer patientId);

	@Query("SELECT DISTINCT a.physician2 FROM Appointment a WHERE a.patient = :patientId AND DATE(a.startDateTime) = :date")
	Physician findPhysicianByPatientIdAndDate(@Param("patientId") Integer patientId, @Param("date") Timestamp date);

	@Query("SELECT n FROM Nurse n INNER JOIN n.listOfAppointment a WHERE a.patient = :patientId")
	List<Nurse> findNursesByPatientId(@Param("patientId") Integer patientId);

	@Query("SELECT a.nurse FROM Appointment a WHERE a.patient = :patientId AND DATE(a.startDateTime) = :date")
	Nurse findNurseByPatientIdAndDate(@Param("patientId") Integer patientId, @Param("date") Timestamp date);

//	@Query("SELECT DISTINCT DATE(a.startDateTime) FROM Appointment a WHERE a.patient = :patientId")
//    List<Timestamp> findAppointmentDatesForPatient(@Param("patientId") Integer patientId);

	@Query("SELECT DISTINCT DATE(a.startDateTime) FROM Appointment a WHERE a.patient = :patientId")
	List<Date> findAppointmentDatesByPatientId(@Param("patientId") Integer patientId);

	@Query("SELECT r FROM Room r JOIN r.listOfStay s JOIN s.patient2 p JOIN p.listOfPrescribes pr JOIN pr.appointment2 a WHERE a.patient= :patientId AND pr.date = :date")
	Room findRoomByPatientIdAndDate(@Param("patientId") Integer patientId, @Param("date") Timestamp date);

	@Query("SELECT r FROM Room r JOIN r.listOfStay s JOIN s.patient2 p JOIN p.listOfPrescribes pr JOIN pr.appointment2 a WHERE a.physician= :employeeid and pr.date= :date")
	List<Room> findRoomByPhysicianIdAndDate(@Param("employeeid") Integer employeeid, @Param("date") Timestamp date);

	// PRIYANKA
	@Query("select p from Patient p join p.physician phy join phy.listOfAppointment a where a.physician= :physicianid")
	List<Patient> findPatientByPhysician(@Param("physicianid") Integer physicianid);

	@Query("select p from Patient p join p.listOfPrescribes pr join pr.appointment2 a where a.physician= :physicianid and pr.date= :date")
	List<Patient> findPatientByPhysicianAndDate(@Param("physicianid") Integer physicianid,
			@Param("date") Timestamp date);

	@Query("select p from Patient p join p.physician phy join phy.listOfAppointment a where a.physician= :physicianid and a.patient= :patientid")
	Patient findPatientByPhysicianAndPatientId(@Param("physicianid") Integer physicianid,
			@Param("patientid") Integer patientid);

	@Query("select p from Patient p join p.listOfAppointment a where a.prepnurse= :nurseid")
	List<Patient> findPatientByNurse(@Param("nurseid") Integer nurseid);

	@Query("select p from Patient p join p.listOfPrescribes pr join pr.appointment2 a where a.prepnurse= :nurseid and pr.date= :date")
	List<Patient> findPatientByNurseAndDate(@Param("nurseid") Integer nurseid, @Param("date") Timestamp date);

	@Query("SELECT r FROM Room r JOIN r.listOfStay s JOIN s.patient2 p JOIN p.listOfPrescribes pr JOIN pr.appointment2 a WHERE a.prepnurse= :nurseid AND pr.date = :date")
	List<Room> findRoomDetailsByNurseAndDate(@Param("nurseid") Integer nurseid, @Param("date") Timestamp date);

}
