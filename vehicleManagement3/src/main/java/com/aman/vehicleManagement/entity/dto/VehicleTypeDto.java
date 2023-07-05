package com.aman.vehicleManagement.entity.dto;

public class VehicleTypeDto {
	
	private int id;
	
	private String type;
	
	private int farePerKM;
	
	private int maxPassengersAllowed;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFarePerKM() {
		return farePerKM;
	}

	public void setFarePerKM(int farePerKM) {
		this.farePerKM = farePerKM;
	}

	public int getMaxPassengersAllowed() {
		return maxPassengersAllowed;
	}

	public void setMaxPassengersAllowed(int maxPassengersAllowed) {
		this.maxPassengersAllowed = maxPassengersAllowed;
	}
	
}
