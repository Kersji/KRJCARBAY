package com.natwest.carbay.service;

import java.util.List;
import java.util.Optional;

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
	public Vehicle updateVehicle(Long id, Vehicle vehicle) {
		
		Vehicle saveVehicle;
			
		// Retrieve vehicle to be updated by id
		Vehicle updVehicle = this.repo.getById(id);

		// Set updated fields
		updVehicle.setRegistration_number(vehicle.getRegistration_number());
		updVehicle.setMake(vehicle.getMake());
		updVehicle.setModel(vehicle.getModel());
		updVehicle.setColour(vehicle.getColour());
		updVehicle.setMileage(vehicle.getMileage());
		updVehicle.setEngine_size(vehicle.getEngine_size());
		updVehicle.setRegistration_date(vehicle.getRegistration_date());
		updVehicle.setFuel_type(vehicle.getFuel_type());
		updVehicle.setGearbox_type(vehicle.getGearbox_type());
		updVehicle.setBody_type(vehicle.getBody_type());

		//Save changes to the database
		saveVehicle = this.repo.save(updVehicle);
		return saveVehicle;
	}	
	
	// DELETE
	public void deleteVehicle(Long id) {
		this.repo.deleteById(id);
	}
	
	// Search for a vehicle by id
	public Vehicle searchVehicle(Long id) {
		
		Optional<Vehicle> schVehicle = this.repo.findById(id);
		return schVehicle.get();
	}
}