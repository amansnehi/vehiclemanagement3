package com.aman.vehicleManagement.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aman.vehicleManagement.entity.Vehicle;
import com.aman.vehicleManagement.entity.dto.RegisterVehicleDto;
import com.aman.vehicleManagement.entity.dto.VehicleDto;
import com.aman.vehicleManagement.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/addvehicle")
	public String addVehicle(@RequestBody RegisterVehicleDto registerVehicleDto) {
		return vehicleService.addVehicle(registerVehicleDto).toString();
	}
	
	@GetMapping("/{id}")
	public List<VehicleDto> getAllVehicleDetailsByUserId(@PathVariable(name="id") Integer userId){
		return vehicleService.getVehicleDetailsByUserId(userId);
	}
	
	@DeleteMapping("/{registrationNo}")
	public void deleteVehicleDetailsByRegistrationNo(@PathVariable(name="registrationNo") String regNo) {
		vehicleService.deleteVehicleDetailByResigtrationNo(regNo);
	}

	@GetMapping("/pendingapprovals/{pageno}")
	public List<VehicleDto> getPendingVehicles(@PathVariable(name="pageno") Integer pageNo){
		return vehicleService.getAllPendingVehicles(pageNo);
	}
	
//	@GetMapping("/pendingapprovals/{pageno}")
//	public List<Vehicle> getPendingVehicles(@PathVariable(name="pageno") Integer pageNo){
//		return vehicleService.getAllPendingVehicles(pageNo);
//	}
}
