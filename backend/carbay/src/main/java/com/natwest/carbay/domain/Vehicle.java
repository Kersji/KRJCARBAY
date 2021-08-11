package com.natwest.carbay.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Marking class Vehicle as a Table
public class Vehicle {
	
	    // Define the primary key 
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long vehicle_id;				// Vehicle Id
		
		// Fields
		private String 	registration_number;	// Vehicle registration number
		private String 	make;					// Vehicle make
		private String 	model;					// Vehicle model
		private	String	colour;					// Vehicle colour
		private int		mileage;				// Vehicle mileage
		private float	engine_size;			// Vehicle engine size
		private String	registration_date;		// Vehicle registration date
		private	String	fuel_type;				// Vehicle fuel type
		private	String	gearbox_type;			// Vehicle gear box type
		private	String	body_type;				// Vehicle body type
		
		// Default Constructor
		public Vehicle() {}
		
		// Constructor with all fields excluding vehicle_id
		public Vehicle(String registration_number, String make, String model, String colour, int mileage,
				float engine_size, String registration_date, String fuel_type, String gearbox_type, String body_type) {
			super();
			this.registration_number = registration_number;
			this.make = make;
			this.model = model;
			this.colour = colour;
			this.mileage = mileage;
			this.engine_size = engine_size;
			this.registration_date = registration_date;
			this.fuel_type = fuel_type;
			this.gearbox_type = gearbox_type;
			this.body_type = body_type;
		}

		// Constructor with all fields
		public Vehicle(Long vehicle_id, String registration_number, String make, String model, String colour,
				int mileage, float engine_size, String registration_date, String fuel_type, String gearbox_type,
				String body_type) {
			super();
			this.vehicle_id = vehicle_id;
			this.registration_number = registration_number;
			this.make = make;
			this.model = model;
			this.colour = colour;
			this.mileage = mileage;
			this.engine_size = engine_size;
			this.registration_date = registration_date;
			this.fuel_type = fuel_type;
			this.gearbox_type = gearbox_type;
			this.body_type = body_type;
		}

		// Getters
		public Long getVehicle_id() {
			return vehicle_id;
		}

		public String getRegistration_number() {
			return registration_number;
		}

		public String getMake() {
			return make;
		}

		public String getModel() {
			return model;
		}

		public String getColour() {
			return colour;
		}

		public int getMileage() {
			return mileage;
		}

		public float getEngine_size() {
			return engine_size;
		}

		public String getRegistration_date() {
			return registration_date;
		}

		public String getFuel_type() {
			return fuel_type;
		}

		public String getGearbox_type() {
			return gearbox_type;
		}

		public String getBody_type() {
			return body_type;
		}

		// Setters
		public void setVehicle_id(Long vehicle_id) {
			this.vehicle_id = vehicle_id;
		}

		public void setRegistration_number(String registration_number) {
			this.registration_number = registration_number;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public void setColour(String colour) {
			this.colour = colour;
		}

		public void setMileage(int mileage) {
			this.mileage = mileage;
		}

		public void setEngine_size(float engine_size) {
			this.engine_size = engine_size;
		}

		public void setRegistration_date(String registration_date) {
			this.registration_date = registration_date;
		}

		public void setFuel_type(String fuel_type) {
			this.fuel_type = fuel_type;
		}

		public void setGearbox_type(String gearbox_type) {
			this.gearbox_type = gearbox_type;
		}

		public void setBody_type(String body_type) {
			this.body_type = body_type;
		}
		
}