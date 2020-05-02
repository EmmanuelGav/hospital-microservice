package com.project.hospital.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.hospital.controllers.dtos.PatientDTO;
import com.project.hospital.controllers.exceptions.ControledException;
import com.project.hospital.models.Patient;
import com.project.hospital.service.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private PatientService patientService;
    
	@GetMapping("all")
	List<Patient> getAll() {
		return patientService.getAll();
	}
	
	@PostMapping
	Patient save(@Valid @RequestBody PatientDTO patientDTO) throws ControledException {
		Patient patient = modelMapper.map(patientDTO, Patient.class);
		
		Optional<Patient> existingPatient = patientService.getOne(patient.getId());
		if(existingPatient.isPresent()) {
			throw new ControledException("The patient already has been registered.");
		}
		
		return patientService.save(patient);
	}
	
	@PutMapping
	Patient update(@Valid @RequestBody PatientDTO patientDTO) throws ControledException {
		Patient patient = modelMapper.map(patientDTO, Patient.class);

		Optional<Patient> existingPatient = patientService.getOne(patient.getId());
		if(!existingPatient.isPresent()) {
			throw new ControledException("The patient has not registered.");
		}
		patient.setPatientId(existingPatient.get().getPatientId());
		
		return patientService.update(patient);
	}
}
