package com.aman.vehicleManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.vehicleManagement.entity.VehicleType;
import com.aman.vehicleManagement.entity.dto.VehicleTypeDto;
import com.aman.vehicleManagement.repo.VehicleTypeRepo;

@Service
public class VehicleTypesService{
	
	private final ModelMapper modelMapper;
	private VehicleTypeRepo vehicleTypeRepo; 
	
	@Autowired
	public VehicleTypesService(VehicleTypeRepo vehicleTypeRepo) {
		super();
		this.modelMapper =new ModelMapper();
		this.vehicleTypeRepo = vehicleTypeRepo;
	}

	public List<VehicleTypeDto> getAllVehicleTypes(){
		List<VehicleTypeDto> allVehicleTypeDto = new ArrayList<>();
		List<VehicleType> allVehicleType = vehicleTypeRepo.findAll();
		
		for(VehicleType vehicleTypeDetail: allVehicleType) {
			VehicleTypeDto temp = modelMapper.map(vehicleTypeDetail,VehicleTypeDto.class);
			allVehicleTypeDto.add(temp);
		}
		return allVehicleTypeDto;
	}
}
