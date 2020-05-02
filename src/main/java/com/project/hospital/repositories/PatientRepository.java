package com.project.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.hospital.models.Patient;

@Service
public interface PatientRepository extends JpaRepository<Patient, Long>{

    @Query("SELECT p FROM Patient p WHERE p.id = ?1")
	public Patient getById(String id);
}
