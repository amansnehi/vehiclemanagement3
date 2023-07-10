package com.aman.vehicleManagement.entity.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.aman.vehicleManagement.entity.VehicleDetail;
import com.aman.vehicleManagement.entity.VehicleType;

import jakarta.validation.constraints.FutureOrPresent;

public class RegisterVehicleDto {
	private String registrationNo;
	
	private int belongsToUserId;
	
	private int vehicleTypeId;

//	private Integer inspectedByUserId;
	
//	private Date inspectedOn;

	private String rtoName;
	
	private Date registrationDate;
	private Date registrationExpiresOn;
	
//	private String rcDocUrl;
	
	private String insuranceCompanyName;
	
	private int insuranceNo;
	
	private Date insurancedOn;
    private Date insuranceExpiresOn;
	
//    private String insuranceCertificateDocUrl;
    
    private int pucCertificateNo;
    
    
    private Date pucIssuedOn;
    
    private Date pucValidUntil;
    
//    private String pucDocUrl;

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

	
	public int getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

//	public Integer getInspectedByUserId() {
//		return inspectedByUserId;
//	}
//
//	public void setInspectedByUserId(Integer inspectedByUserId) {
//		this.inspectedByUserId = inspectedByUserId;
//	}
//
//	public Date getInspectedOn() {
//		return inspectedOn;
//	}
//
//	public void setInspectedOn(Date inspectedOn) {
//		this.inspectedOn = inspectedOn;
//	}

	public String getRtoName() {
		return rtoName;
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
//    
    

	
}
