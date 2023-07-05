package com.aman.vehicleManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aman.vehicleManagement.entity.VehicleDetail;

@Repository
public interface VehicleDetailRepo extends JpaRepository<VehicleDetail,String>{

	
	
}
