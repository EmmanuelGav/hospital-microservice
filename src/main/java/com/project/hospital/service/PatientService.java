package com.project.hospital.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hospital.models.Patient;
import com.project.hospital.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	public Optional<Patient> getOne(String id) {
		return Optional.ofNullable(patientRepository.getById(id));
	}
	
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public Patient update(Patient patient) {
		return patientRepository.save(patient);
	}
}
