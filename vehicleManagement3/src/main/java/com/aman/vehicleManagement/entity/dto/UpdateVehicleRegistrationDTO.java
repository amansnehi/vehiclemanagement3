package com.aman.vehicleManagement.entity.dto;

import java.util.Date;


public class UpdateVehicleRegistrationDTO {
	
	private String registrationNo;

    private String inspectionStatus;

    private int inspectedByUserId;
//
//    private Date inspectedOn;

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	public int getInspectedByUserId() {
		return inspectedByUserId;
	}

	public void setInspectedByUserId(int inspectedByUserId) {
		this.inspectedByUserId = inspectedByUserId;
	}

//	public Date getInspectedOn() {
//		return inspectedOn;
//	}
//
//	public void setInspectedOn(Date inspectedOn) {
//		this.inspectedOn = inspectedOn;
//	}

	
    
    
}
