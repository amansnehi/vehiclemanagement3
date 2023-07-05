package com.aman.vehicleManagement.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "VehicleType")
public class VehicleType {
    @Id
    private int id;
   
    @Column(length = 10)
    private String type;

    @Column
    private int maxPassengersAllowed;

    @Column
    private int farePerKM;
    
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

	public int getMaxPassengersAllowed() {
		return maxPassengersAllowed;
	}

	public void setMaxPassengersAllowed(int maxPassengersAllowed) {
		this.maxPassengersAllowed = maxPassengersAllowed;
	}

	public int getFarePerKM() {
		return farePerKM;
	}

	public void setFarePerKM(int farePerKM) {
		this.farePerKM = farePerKM;
	}

	@Override
	public String toString() {
		return "VehicleType [id=" + id + ", type=" + type + ", maxPassengersAllowed=" + maxPassengersAllowed
				+ ", farePerKM=" + farePerKM + "]";
	}

	

   
}

