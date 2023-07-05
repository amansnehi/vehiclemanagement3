package com.aman.vehicleManagement.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Vehicle")
public class Vehicle {
	
	@Id
	@Size(max = 10, message = "Length of registrationNo is invalid.")
	private String registrationNo;
	
	@OneToOne(mappedBy="vehicle",cascade = CascadeType.ALL)
    private VehicleDetail vehicleDetail;
	
	@Column
	private int belongsToUserId;

	@Column(length = 10)
	@Pattern(regexp = "^(pending/approved/rejected)$", message = "notvalid")
	private String inspectionStatus;

	@Column
	private int inspectedByUserId;

	@Column
	private Date inspectedOn;

	
	@ManyToOne
    @JoinColumn(name = "vehicleTypeId", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_Vehicle_VehicleType"))
    private VehicleType vehicleType;

	public VehicleDetail getVehicleDetail() {
		return vehicleDetail;
	}

	public void setVehicleDetail(VehicleDetail vehicleDetail) {
		this.vehicleDetail = vehicleDetail;
	}

	public int getBelongsToUserId() {
		return belongsToUserId;
	}

	public void setBelongsToUserId(int belongsToUserId) {
		this.belongsToUserId = belongsToUserId;
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

	public Date getInspectedOn() {
		return inspectedOn;
	}

	public void setInspectedOn(Date inspectedOn) {
		this.inspectedOn = inspectedOn;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Override
	public String toString() {
		return "Vehicle [registrationNo=" + registrationNo + ", vehicleDetail=" + vehicleDetail + ", belongsToUserId="
				+ belongsToUserId + ", inspectionStatus=" + inspectionStatus + ", inspectedByUserId="
				+ inspectedByUserId + ", inspectedOn=" + inspectedOn + ", vehicleType=" + vehicleType + "]";
	}
	

	
}
