package com.aman.vehicleManagement.entity.dto;

import java.util.Date;


public class UpdateVehicleRegistrationDTO {
	
	private String RegistrationNo;

    private String InspectionStatus;

    private int InspectionByUserId;

    private Date InspectedOn;

	public String getRegistrationNo() {
		return RegistrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		RegistrationNo = registrationNo;
	}

	public String getInspectionStatus() {
		return InspectionStatus;
	}

	public void setInspectionStatus(String inspectionStatus) {
		InspectionStatus = inspectionStatus;
	}

	public int getInspectionByUserId() {
		return InspectionByUserId;
	}

	public void setInspectionByUserId(int inspectionByUserId) {
		InspectionByUserId = inspectionByUserId;
	}

	public Date getInspectedOn() {
		return InspectedOn;
	}

	public void setInspectedOn(Date inspectedOn) {
		InspectedOn = inspectedOn;
	}
    
    
}
