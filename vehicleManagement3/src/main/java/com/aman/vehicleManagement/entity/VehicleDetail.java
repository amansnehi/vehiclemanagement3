package com.aman.vehicleManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;

import java.util.Date;

@Entity
@Table(name = "VehicleDetail")
public class VehicleDetail {

	@Id				
	private String registrationNo;

	@Column(length = 10)
	private String rtoName;

	@Column
	private Date registrationDate;

	@Column
	@FutureOrPresent
	private Date registrationExpiresOn;

//	@Column(length = 100)
//	private String rcDocUrl;

	@Column(length = 50)
	private String insuranceCompanyName;

	@Column
	private int insuranceNo;

	@Column
	private Date insurancedOn;

	@Column
	@FutureOrPresent
	private Date insuranceExpiresOn;

//	@Column(length = 100)
//	private String insuranceCertificateDocUrl;

	@Column
	private int pucCertificateNo;

	@Column
	@NotNull
	private Date pucIssuedOn;

	@Column
	@FutureOrPresent
	private Date pucValidUntil;

//	@Column(length = 100)
//	private String pucDocUrl;

	@OneToOne
	@JoinColumn(name = "registrationNo", referencedColumnName = "registrationNo")
	private Vehicle vehicle;
	// Getters and setters

	public String getRtoName() {
		return rtoName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public void setRtoName(String rtoName) {
		this.rtoName = rtoName;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getRegistrationExpiresOn() {
		return registrationExpiresOn;
	}

	public void setRegistrationExpiresOn(Date registrationExpiresOn) {
		this.registrationExpiresOn = registrationExpiresOn;
	}

//	public String getRcDocUrl() {
//		return rcDocUrl;
//	}
//
//	public void setRcDocUrl(String rcDocUrl) {
//		this.rcDocUrl = rcDocUrl;
//	}

	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}

	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}

	public int getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(int insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public Date getInsurancedOn() {
		return insurancedOn;
	}

	public void setInsurancedOn(Date insurancedOn) {
		this.insurancedOn = insurancedOn;
	}

	public Date getInsuranceExpiresOn() {
		return insuranceExpiresOn;
	}

	public void setInsuranceExpiresOn(Date insuranceExpiresOn) {
		this.insuranceExpiresOn = insuranceExpiresOn;
	}

//	public String getInsuranceCertificateDocUrl() {
//		return insuranceCertificateDocUrl;
//	}
//
//	public void setInsuranceCertificateDocUrl(String insuranceCertificateDocUrl) {
//		this.insuranceCertificateDocUrl = insuranceCertificateDocUrl;
//	}

	public int getPucCertificateNo() {
		return pucCertificateNo;
	}

	public void setPucCertificateNo(int pucCertificateNo) {
		this.pucCertificateNo = pucCertificateNo;
	}

	public Date getPucIssuedOn() {
		return pucIssuedOn;
	}

	public void setPucIssuedOn(Date pucIssuedOn) {
		this.pucIssuedOn = pucIssuedOn;
	}

	public Date getPucValidUntil() {
		return pucValidUntil;
	}

	public void setPucValidUntil(Date pucValidUntil) {
		this.pucValidUntil = pucValidUntil;
	}

//	public String getPucDocUrl() {
//		return pucDocUrl;
//	}
//
//	public void setPucDocUrl(String pucDocUrl) {
//		this.pucDocUrl = pucDocUrl;
//	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "VehicleDetail [registrationNo=" + registrationNo + ", rtoName=" + rtoName + ", registrationDate="
				+ registrationDate + ", registrationExpiresOn=" + registrationExpiresOn + ", insuranceCompanyName="
				+ insuranceCompanyName + ", insuranceNo=" + insuranceNo + ", insurancedOn=" + insurancedOn
				+ ", insuranceExpiresOn=" + insuranceExpiresOn + ", pucCertificateNo=" + pucCertificateNo
				+ ", pucIssuedOn=" + pucIssuedOn + ", pucValidUntil=" + pucValidUntil + ", vehicle=" + vehicle + "]";
	}

	

	

	

}
