package com.natwest.carbay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.natwest.carbay.domain.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long>{
	
}