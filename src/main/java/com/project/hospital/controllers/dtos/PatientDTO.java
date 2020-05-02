package com.project.hospital.controllers.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class PatientDTO {

	Long patientId;
	
	@Size(min = 5, max = 20, message = "The maximum length must be 20 and the minimum length must be 5")
	String id;

	@Size(min = 5, max = 255, message = "The maximum length must be 255 and the minimum length must be 5")
	String firstName;

	@Size(min = 5, max = 255, message = "The maximum length must be 255 and the minimum length must be 5")
	String lastName;

	@Size(min = 5, max = 255, message = "The maximum length must be 255 and the minimum length must be 5")
    @Email(message = "The field email must be a valid")
	String email;

	@Size(min = 5, max = 20, message = "The maximum length must be 20 and the minimum length must be 5")
	String phone;

	public PatientDTO() {}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
