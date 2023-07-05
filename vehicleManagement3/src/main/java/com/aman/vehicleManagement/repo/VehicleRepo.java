package com.aman.vehicleManagement.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aman.vehicleManagement.entity.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,String>{

	List<Vehicle> findAllByBelongsToUserId(int userId);
	
	@Query("SELECT v FROM Vehicle v " +
            "WHERE v.inspectionStatus = 'Pending'")
	List<Vehicle> findPendingApprovals(Pageable pageable);
	
	
	
}
