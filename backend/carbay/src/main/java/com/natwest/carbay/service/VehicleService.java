package com.natwest.carbay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.natwest.carbay.repo.VehicleRepo;


@Service
public class VehicleService {

	// Set dependency
	public VehicleRepo repo;

	@Autowired
	public VehicleService(VehicleRepo repo) {
		this.repo = repo;
	}
	
	// CRUD functionality
	
	// CREATE
	
	// READ
	
	// UPDATE
	
	// DELETE
	
	// Search for a vehicle by id
	
}