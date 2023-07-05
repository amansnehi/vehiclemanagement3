package com.aman.vehicleManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aman.vehicleManagement.entity.VehicleType;
import com.aman.vehicleManagement.entity.dto.VehicleTypeDto;

@Repository
public interface VehicleTypeRepo extends JpaRepository<VehicleType,Integer>{
	
	VehicleType getVehicleTypeById(int id);
}
