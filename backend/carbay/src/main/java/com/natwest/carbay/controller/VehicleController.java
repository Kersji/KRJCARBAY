package com.natwest.carbay.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.natwest.carbay.domain.Vehicle;
import com.natwest.carbay.service.VehicleService;


@RestController
@RequestMapping("/CarBay")
@CrossOrigin
public class VehicleController {

	// Mapping URLs to Methods
	
		private VehicleService service;
		
		@Autowired
		public VehicleController(VehicleService service) {
			this.service = service;
		} 
		
		// CRUD functionality
		
		// CREATE
		@PostMapping("/createVehicle")
		public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
			return new ResponseEntity<Vehicle> (this.service.createVehicle(vehicle), 
					HttpStatus.CREATED);
		}
		
		// READ
		@GetMapping("/readAllVehicle")
		public ResponseEntity<List<Vehicle>> readAllVehicle() {
			return new ResponseEntity<List<Vehicle>> (this.service.readAllVehicle(), 
					HttpStatus.OK);
		}
		
		// UPDATE
		@PatchMapping("/updateVehicle/{id}")
		public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id,
				@RequestBody Vehicle vehicle) {
			
			return new ResponseEntity<Vehicle> (this.service.updateVehicle(id, vehicle), 
					HttpStatus.ACCEPTED);
		}
		
		// DELETE
		@DeleteMapping("/deleteVehicle/{id}")
		public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Long id) {
			this.service.deleteVehicle(id);
			return new ResponseEntity<Vehicle> (HttpStatus.NO_CONTENT);
		}
		
		// Search for a vehicle by id
		@GetMapping("/searchVehicle/{id}")
		public ResponseEntity<Vehicle> searchVehicle(@PathVariable Long id) {
			return new ResponseEntity<Vehicle> (this.service.searchVehicle(id), 
					HttpStatus.OK);	
		}
	
}