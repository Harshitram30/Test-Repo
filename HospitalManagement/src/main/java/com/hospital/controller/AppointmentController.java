package com.hospital.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.Appointment;
import com.hospital.entities.Nurse;
import com.hospital.entities.Patient;
import com.hospital.entities.Physician;
import com.hospital.entities.Room;
import com.hospital.entities.dto.AppointmentDTO;
import com.hospital.exceptions.NotFoundException;
import com.hospital.services.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService service;

	@PostMapping
	public ResponseEntity<String> addAppointment(@RequestBody AppointmentDTO appointmentdto) {
		Appointment app=new Appointment();
		app.setAppointmentid(appointmentdto.getAppointmentid());
		app.setPatient(appointmentdto.getPatient());
		app.setPrepnurse(appointmentdto.getPrepnurse());
		app.setPhysician(appointmentdto.getPhysician());
		app.setStartDateTime(appointmentdto.getStartDateTime());
		app.setEndDateTime(appointmentdto.getEndDateTime());
		app.setExaminationroom(appointmentdto.getExaminationroom());
		boolean isAppointmentCreated = service.createAppointment(app);
		if (isAppointmentCreated) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Record Created Successfully");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create appointment");
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Appointment>> getAppointments() {
		List<Appointment> appointments = service.getAllAppointments();
		return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
	}
	
	@GetMapping("/{startdate}")
	public ResponseEntity<List<Appointment>> getAppointmentsByStartDate(@PathVariable Timestamp startdate) {
		try {
			List<Appointment> appointments = service.getAppointmentsByStartDate(startdate);
			return new ResponseEntity<List<Appointment>>(appointments, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@GetMapping("/get/patient/{appointmentid}")
	public ResponseEntity<Patient> getPatientByAppointmentId(@PathVariable Integer appointmentid) {
		Optional<Patient> patient = service.findPatientByAppointmentId(appointmentid);
		if (patient.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(patient.get());
		} else {
			throw new NotFoundException("appointment id not found");
		}
	}

	@GetMapping("/physician/{appointmentid}")
	public ResponseEntity<Physician> getPhysicianByAppointmentId(@PathVariable Integer appointmentid) {
		Optional<Physician> physician = service.getPhysicianByAppointmentId(appointmentid);
		if (physician.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(physician.get());
		} else {
			throw new NotFoundException("Appointment id not found");
		}
	}
	
	@GetMapping("/nurse/{appointmentid}")
	public ResponseEntity<Nurse> getNurseByAppointmentId(@PathVariable Integer appointmentid) {
		Optional<Nurse> nurse = service.getNurseByAppointmentId(appointmentid);
		if (nurse.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(nurse.get());
		} else {
			throw new NotFoundException("Appointment id not found");
		}
	}
	
	@GetMapping("/examinationroom/{appointmentid}")
	public ResponseEntity<Room> getExaminationRoomByAppointmentId(@PathVariable Integer appointmentid) {
		Room room = service.getRoomByAppointmentId(appointmentid);
		if (room != null) {
			return ResponseEntity.status(HttpStatus.OK).body(room);
		} else {
			throw new NotFoundException("Appointment id not found");
		}
	}

	@GetMapping("/getphysician/{patientId}")
	public ResponseEntity<List<Physician>> getPhysiciansByPatientId(@PathVariable Integer patientId) {
		List<Physician> list = service.getPhysiciansByPatientId(patientId);
		if (list.isEmpty()) {
			throw new NotFoundException("Patient id not found");
		} else {
			return new ResponseEntity<List<Physician>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/physician/{patientId}/{timestamp}")
	public Physician getPhysicianByPatientIdAndTimestamp(@PathVariable Integer patientId,@PathVariable Timestamp timestamp) {
		return service.getPhysicianByPatientIdAndDate(patientId, timestamp);
	}

	@GetMapping("/getnurse/{patientId}")
	public ResponseEntity<List<Nurse>> getNursesByPatientId(@PathVariable Integer patientId) {
		try {
			List<Nurse> nurses = service.getNursesByPatientId(patientId);
			if (nurses != null && !nurses.isEmpty()) {
				return ResponseEntity.ok(nurses);
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/nurse/{patientId}/{date}")
	public ResponseEntity<Nurse> getNurseByPatientIdAndDate(@PathVariable Integer patientId,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		try {
			Timestamp timestamp = new Timestamp(date.getTime());
			Nurse nurse = service.getNurseByPatientIdAndDate(patientId, timestamp);
			if (nurse != null) {
				return ResponseEntity.status(HttpStatus.OK).body(nurse);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/date/{patientId}")
	public ResponseEntity<List<Date>> getAppointmentDatesByPatientId(@PathVariable Integer patientId) {
		List<Date> appointmentDates = service.getAppointmentDatesByPatientId(patientId);
		if (appointmentDates != null && !appointmentDates.isEmpty()) {
			return ResponseEntity.ok(appointmentDates);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/room/{patientId}/{date}")
	public ResponseEntity<Room> getRoomDetailsByPatientIdAndDate(@PathVariable Integer patientId,@PathVariable Timestamp date) {
		Room room = service.getRoomDetailsByPatientIdAndDate(patientId, date);
		if (room != null) {
			return new ResponseEntity<>(room, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getroom/{employeeid}/{date}")
	public ResponseEntity<List<Room>> getRoomByPhysicianIdAndDate(@PathVariable Integer employeeid,@PathVariable Timestamp date) {
		List<Room> list = service.getRoomByPhysicianIdAndDate(employeeid, date);
		if (list != null) {
			return new ResponseEntity<List<Room>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// PRIYANKA
	@GetMapping("/patient/{physicianid}")
	public ResponseEntity<List<Patient>> getPatientByPhysician(@PathVariable Integer physicianid) {
		List<Patient> patients = service.getPatientByPhysician(physicianid);
		if (patients != null) {
			return new ResponseEntity<List<Patient>>(patients, HttpStatus.FOUND);
		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new NotFoundException("Invalid PhysicianId");
		}
	}

	@GetMapping("/patient/{physicianid}/{date}")
	public ResponseEntity<List<Patient>> getPatientByPhysicianAndDate(@PathVariable Integer physicianid,@PathVariable Timestamp date) {
		List<Patient> patients = service.getPatientByPhysicianAndDate(physicianid, date);
		if (patients != null) {
			return new ResponseEntity<List<Patient>>(patients, HttpStatus.FOUND);
		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new NotFoundException("Invalid PhysicianId or Date");
		}
	}
	
	@GetMapping("/getpatient/{physicianid}/{patientid}")
	public ResponseEntity<Patient> getPatientByPhysicianAndPatientId(@PathVariable Integer physicianid,@PathVariable Integer patientid) {
		Patient patients = service.getPatientByPhysicianAndPatientId(physicianid, patientid);
		if (patients != null) {
			return new ResponseEntity<Patient>(patients, HttpStatus.FOUND);
		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new NotFoundException("Invalid PhysicianId or PatientId");
		}
	}

	@GetMapping("/getpatient/{nurseid}")
	public ResponseEntity<List<Patient>> getPatientByNurse(@PathVariable Integer nurseid) {
		List<Patient> patients = service.getPatientByNurse(nurseid);
		if (patients != null) {
			return new ResponseEntity<List<Patient>>(patients, HttpStatus.FOUND);
		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new NotFoundException("Invalid NurseId");
		}
	}

	@GetMapping("/getpatientby/{nurseid}/{date}")
	public ResponseEntity<List<Patient>> getPatientByNurseAndDate(@PathVariable Integer nurseid,@PathVariable Timestamp date) {
		List<Patient> patients = service.getPatientByNurseAndDate(nurseid, date);
		if (patients != null) {
			return new ResponseEntity<List<Patient>>(patients, HttpStatus.FOUND);
		} else {
			throw new NotFoundException("Invalid NurseId or Date");
		}
	}

	@GetMapping("get/room/{nurseid}/{date}")
	public ResponseEntity<List<Room>> getRoomDetailsByNurseAndDate(@PathVariable Integer nurseid,@PathVariable Timestamp date) {
		List<Room> room = service.getRoomDetailsByNurseAndDate(nurseid, date);
		if (room != null) {
			return new ResponseEntity<List<Room>>(room, HttpStatus.OK);
		} else {
			throw new NotFoundException("Invalid NurseId or Date");
		}
	}

	@PutMapping("/room/{appointmentid}")
	public ResponseEntity<Appointment> updateExaminationRoomBy(@PathVariable Integer appointmentid,@RequestBody String examinationroom) {
		Appointment app = service.updateExaminationRoomBy(appointmentid, examinationroom);
		return new ResponseEntity<Appointment>(app, HttpStatus.OK);
	}

}
