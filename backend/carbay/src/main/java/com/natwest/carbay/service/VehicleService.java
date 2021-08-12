package com.natwest.carbay.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.natwest.carbay.domain.Vehicle;
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
	public Vehicle createVehicle(Vehicle vehicle) {
		
		// Return new vehicle created for display on front-end
		Vehicle newVehicle = this.repo.saveAndFlush(vehicle);
		return(newVehicle);
	}
	
	// READ
	public List<Vehicle> readAllVehicle() {
		return this.repo.findAll();
	}
	
	// UPDATE
	
	// DELETE
	
	// Search for a vehicle by id
	
}