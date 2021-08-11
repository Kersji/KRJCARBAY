package com.natwest.carbay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		// READ
		
		// UPDATE
		
		// DELETE
		
		// Search for a vehicle by id
		
	
}