package com.aman.vehicleManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.aman.vehicleManagement.entity.Vehicle;
import com.aman.vehicleManagement.entity.VehicleDetail;
import com.aman.vehicleManagement.entity.VehicleType;
import com.aman.vehicleManagement.entity.dto.RegisterVehicleDto;
import com.aman.vehicleManagement.entity.dto.VehicleDetailDto;
import com.aman.vehicleManagement.entity.dto.VehicleDto;
import com.aman.vehicleManagement.entity.dto.VehicleTypeDto;
import com.aman.vehicleManagement.repo.VehicleRepo;
import com.aman.vehicleManagement.repo.VehicleTypeRepo;
import com.aman.vehicleManagement.service.exceptions.NotFoundExcep;
import com.aman.vehicleManagement.service.exceptions.UserNotFoundException;
import com.aman.vehicleManagement.service.validate.Validator;

@Service
public class VehicleService {

	private VehicleRepo vehicleRepo;

	private VehicleTypeRepo vehicleTypeRepo;

	private final ModelMapper modelMapper;
	private Validator validator;

	public VehicleService(VehicleRepo vehicleRepo, VehicleTypeRepo vehicleTypeRepo, Validator validator) {
		super();
		this.vehicleRepo = vehicleRepo;
		this.vehicleTypeRepo = vehicleTypeRepo;
		this.modelMapper = new ModelMapper();
		this.validator = validator;
	}

	public Vehicle addVehicle(RegisterVehicleDto registerVehicleDto) {

		validator.checkDetails(registerVehicleDto);
		Vehicle vehicle = modelMapper.map(registerVehicleDto, Vehicle.class);
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

	public VehicleDto getVehicleDetailsByUserId(int userId) throws UserNotFoundException {
		Vehicle vehicle = vehicleRepo.findByBelongsToUserId(userId);
		if (vehicle == null) {
			throw new UserNotFoundException("User not found with ID: " + userId);
		}
		VehicleDto temp = modelMapper.map(vehicle, VehicleDto.class);
		VehicleDetailDto vehicleDetailDto = modelMapper.map(vehicle.getVehicleDetail(), VehicleDetailDto.class);
		VehicleTypeDto vehicleTypeDto = modelMapper.map(vehicle.getVehicleType(), VehicleTypeDto.class);
		temp.setVehicleDetailDto(vehicleDetailDto);
		temp.setVehicleTypeDto(vehicleTypeDto);
		return temp;

	}

	public void deleteVehicleDetailByResigtrationNo(String regNo) throws NotFoundExcep{
//		 vehicleRepo.deleteById(regNo);
		boolean exists = vehicleRepo.existsById(regNo);
		System.out.println(exists);
		if (exists) {
			vehicleRepo.deleteById(regNo);
		} else {
			System.out.println("dajjfa");
			throw new NotFoundExcep("Vehicle details not found for registration number: " + regNo);
		}
	}

	public List<VehicleDto> getAllPendingVehicles(int pageNo) {
		int pageSize = 1; // Number of records per page
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id"));
		List<VehicleDto> allVehicleDto = new ArrayList<>();
		List<Vehicle> allVehicle = vehicleRepo.findPendingApprovals(pageable);
		for (Vehicle ivehicle : allVehicle) {
			VehicleDto temp = modelMapper.map(ivehicle, VehicleDto.class);
			VehicleDetailDto vehicleDetailDto = modelMapper.map(ivehicle.getVehicleDetail(), VehicleDetailDto.class);
			VehicleTypeDto vehicleTypeDto = modelMapper.map(ivehicle.getVehicleType(), VehicleTypeDto.class);
			temp.setVehicleDetailDto(vehicleDetailDto);
			temp.setVehicleTypeDto(vehicleTypeDto);

			allVehicleDto.add(temp);
		}
		return allVehicleDto;

	}
}
