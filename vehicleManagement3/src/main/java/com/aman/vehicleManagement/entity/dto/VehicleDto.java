package com.aman.vehicleManagement.entity.dto;

import java.util.Date;

import com.aman.vehicleManagement.entity.VehicleDetail;
import com.aman.vehicleManagement.entity.VehicleType;


public class VehicleDto {
	
	private String registrationNo;
	private int belongsToUserId;
	private Integer inspectedByUserId;
	private Date inspectedOn;
	private String inspectionStatus;
	private int vehicleTypeId;
	
	private VehicleDetailDto vehicleDetailDto;
	private VehicleTypeDto vehicleTypeDto;
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public int getBelongsToUserId() {
		return belongsToUserId;
	}
	public void setBelongsToUserId(int belongsToUserId) {
		this.belongsToUserId = belongsToUserId;
	}
	public Integer getInspectedByUserId() {
		return inspectedByUserId;
	}
	public void setInspectedByUserId(Integer inspectedByUserId) {
		this.inspectedByUserId = inspectedByUserId;
	}
	public Date getInspectedOn() {
		return inspectedOn;
	}
	public void setInspectedOn(Date inspectedOn) {
		this.inspectedOn = inspectedOn;
	}
	public String getInspectionStatus() {
		return inspectionStatus;
	}
	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}
	public int getVehicleTypeId() {
		return vehicleTypeId;
	}
	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}
	public VehicleDetailDto getVehicleDetailDto() {
		return vehicleDetailDto;
	}
	public void setVehicleDetailDto(VehicleDetailDto vehicleDetailDto) {
		this.vehicleDetailDto = vehicleDetailDto;
	}
	public VehicleTypeDto getVehicleTypeDto() {
		return vehicleTypeDto;
	}
	public void setVehicleTypeDto(VehicleTypeDto vehicleTypeDto) {
		this.vehicleTypeDto = vehicleTypeDto;
	}
	
	
}
