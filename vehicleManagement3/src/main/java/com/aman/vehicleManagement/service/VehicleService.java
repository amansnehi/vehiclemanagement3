package com.aman.vehicleManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import com.aman.vehicleManagement.entity.Vehicle;
import com.aman.vehicleManagement.entity.VehicleDetail;
import com.aman.vehicleManagement.entity.VehicleType;
import com.aman.vehicleManagement.entity.dto.RegisterVehicleDto;
import com.aman.vehicleManagement.entity.dto.UpdateVehicleRegistrationDTO;
import com.aman.vehicleManagement.entity.dto.VehicleDetailDto;
import com.aman.vehicleManagement.entity.dto.VehicleDto;
import com.aman.vehicleManagement.entity.dto.VehicleTypeDto;
import com.aman.vehicleManagement.repo.VehicleRepo;
import com.aman.vehicleManagement.repo.VehicleTypeRepo;

@Service
public class VehicleService {
	
	private VehicleRepo vehicleRepo;
	
	private VehicleTypeRepo vehicleTypeRepo;
	
	private final ModelMapper modelMapper;
	
	@Autowired
	public VehicleService(VehicleRepo vehicleRepo, VehicleTypeRepo vehicleTypeRepo) {
		super();
		this.vehicleRepo = vehicleRepo;
		this.vehicleTypeRepo = vehicleTypeRepo;
		this.modelMapper = new ModelMapper();
	}
	public Vehicle addVehicle(RegisterVehicleDto registerVehicleDto) {

		Vehicle vehicle = modelMapper.map(registerVehicleDto,Vehicle.class);
//		VehicleDetail vehicleDetail = modelMapper.map(registerVehicleDto,VehicleDetail.class);
		VehicleDetail vehicleDetail = new VehicleDetail();
		vehicleDetail.setRtoName(registerVehicleDto.getRtoName());
		vehicleDetail.setRegistrationDate(registerVehicleDto.getRegistrationDate());
		vehicleDetail.setRegistrationExpiresOn(registerVehicleDto.getRegistrationExpiresOn());
		vehicleDetail.setRcDocUrl(registerVehicleDto.getRcDocUrl());
		vehicleDetail.setInsuranceCompanyName(registerVehicleDto.getInsuranceCompanyName());
		vehicleDetail.setInsuranceNo(registerVehicleDto.getInsuranceNo());
		vehicleDetail.setInsurancedOn(registerVehicleDto.getInsurancedOn());
		vehicleDetail.setInsuranceExpiresOn(registerVehicleDto.getInsuranceExpiresOn());
		vehicleDetail.setInsuranceCertificateDocUrl(registerVehicleDto.getInsuranceCertificateDocUrl());
		vehicleDetail.setPucCertificateNo(registerVehicleDto.getPucCertificateNo());
		vehicleDetail.setPucValidUntil(registerVehicleDto.getPucValidUntil());
		vehicleDetail.setPucIssuedOn(registerVehicleDto.getPucIssuedOn());
		vehicleDetail.setPucDocUrl(registerVehicleDto.getPucDocUrl());
		vehicleDetail.setRegistrationNo(registerVehicleDto.getRegistrationNo());
		VehicleType vehicleType = new VehicleType();
		vehicleType = vehicleTypeRepo.getVehicleTypeById(registerVehicleDto.getVehicleTypeId());
		vehicle.setVehicleType(vehicleType);
		vehicle.setVehicleDetail(vehicleDetail);
		vehicle.setInspectionStatus("pending");
		vehicleRepo.save(vehicle);
		return vehicle;
		
		
		
	}
	public VehicleDto getVehicleDetailsByUserId(int userId){
		Vehicle vehicle =  vehicleRepo.findByBelongsToUserId(userId);
		VehicleDto temp = modelMapper.map(vehicle,VehicleDto.class);
		VehicleDetailDto vehicleDetailDto = modelMapper.map(vehicle.getVehicleDetail(),VehicleDetailDto.class);
		VehicleTypeDto vehicleTypeDto =  modelMapper.map(vehicle.getVehicleType(),VehicleTypeDto.class);
		temp.setVehicleDetailDto(vehicleDetailDto);
		temp.setVehicleTypeDto(vehicleTypeDto);
		return temp;

	}
	
	public void deleteVehicleDetailByResigtrationNo(String regNo) {
		 vehicleRepo.deleteById(regNo);
	}
	
	public List<VehicleDto> getAllPendingVehicles(int pageNo){
		int pageSize = 1; // Number of records per page
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id"));
        List<VehicleDto> allVehicleDto = new ArrayList<>();
		List<Vehicle> allVehicle=vehicleRepo.findPendingApprovals(pageable);
		for(Vehicle ivehicle : allVehicle) {
			VehicleDto temp = modelMapper.map(ivehicle,VehicleDto.class);
			VehicleDetailDto vehicleDetailDto = modelMapper.map(ivehicle.getVehicleDetail(),VehicleDetailDto.class);
			VehicleTypeDto vehicleTypeDto =  modelMapper.map(ivehicle.getVehicleType(),VehicleTypeDto.class);
			temp.setVehicleDetailDto(vehicleDetailDto);
			temp.setVehicleTypeDto(vehicleTypeDto);
			
			allVehicleDto.add(temp);
		}
		return allVehicleDto; 
        
	}
}
