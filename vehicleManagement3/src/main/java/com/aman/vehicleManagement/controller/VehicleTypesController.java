package com.aman.vehicleManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.vehicleManagement.entity.VehicleType;
import com.aman.vehicleManagement.entity.dto.VehicleTypeDto;
import com.aman.vehicleManagement.service.VehicleTypesService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleTypesController {
	
	@Autowired
	private VehicleTypesService vehicleTypesService;
	
	@GetMapping("/vehicletypes")
	public List<VehicleTypeDto> getAllVehicleTypes(){
		return vehicleTypesService.getAllVehicleTypes();
	}
	
	
}
