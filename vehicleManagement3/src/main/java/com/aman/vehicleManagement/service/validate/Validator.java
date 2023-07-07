package com.aman.vehicleManagement.service.validate;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.aman.vehicleManagement.entity.dto.RegisterVehicleDto;
import com.aman.vehicleManagement.service.exceptions.InvalidDateException;
import com.aman.vehicleManagement.service.exceptions.InvalidRegistrationNumberException;
import com.aman.vehicleManagement.service.exceptions.InvalidVehicleException;
@Component
public class Validator {

	private static final String REGISTRATION_NUMBER_REGEX = "[A-Za-z]{2}\\d{2}[A-Za-z]{2}\\d{4}";
	public void checkDetails(RegisterVehicleDto registerVehicleDto) throws  InvalidRegistrationNumberException,InvalidDateException,InvalidVehicleException{
		Date currentDate = new Date();
		if (registerVehicleDto.getRegistrationNo() == null || registerVehicleDto.getRegistrationNo().length() != 10 || !registerVehicleDto.getRegistrationNo().matches(REGISTRATION_NUMBER_REGEX)) {
            throw new InvalidRegistrationNumberException("Invalid registration number format");
        }
		if (registerVehicleDto.getRegistrationExpiresOn() != null && registerVehicleDto.getRegistrationExpiresOn().before(currentDate)) {
            throw new InvalidDateException("Registration expiration date cannot be in the past");
        }

        if (registerVehicleDto.getInsuranceExpiresOn() != null && registerVehicleDto.getInsuranceExpiresOn().before(currentDate)) {
            throw new InvalidDateException("Insurance expiration date cannot be in the past");
        }

        if (registerVehicleDto.getPucValidUntil() != null && registerVehicleDto.getPucValidUntil().before(currentDate)) {
            throw new InvalidDateException("PUC valid until date cannot be in the past");
        }
        if (isVehicleOlderThan15Years(registerVehicleDto.getRegistrationDate())) {
            throw new InvalidVehicleException("Vehicles older than 15 years are not allowed to register.");
        }
        if (!isRCValidForMinimumPeriod(registerVehicleDto.getRegistrationExpiresOn(), 2)) {
            throw new InvalidVehicleException("RC should be valid for at least 2 years.");
        }
        if (!isInsuranceValidForMinimumPeriod(registerVehicleDto.getInsuranceExpiresOn(), 1)) {
            throw new InvalidVehicleException("Insurance should be valid for at least 1 year.");
        }
        if (!isPUCValidForMinimumPeriod(registerVehicleDto.getPucValidUntil(), 6)) {
            throw new InvalidVehicleException("PUC should be valid for a minimum of 6 months.");
        }
	}
	private boolean isVehicleOlderThan15Years(Date registrationDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -15); // Subtract 15 years from the current date

        Date fifteenYearsAgo = calendar.getTime();
        return registrationDate.before(fifteenYearsAgo);
    }
	private boolean isRCValidForMinimumPeriod(Date expiryDate, int minimumYears) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, minimumYears); // Add minimumYears to the current date

        Date minimumExpiryDate = calendar.getTime();
        return expiryDate.after(minimumExpiryDate);
    }

    private boolean isInsuranceValidForMinimumPeriod(Date expiryDate, int minimumYears) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, minimumYears); // Add minimumYears to the current date

        Date minimumExpiryDate = calendar.getTime();
        return expiryDate.after(minimumExpiryDate);
    }

    private boolean isPUCValidForMinimumPeriod(Date expiryDate, int minimumMonths) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, minimumMonths); // Add minimumMonths to the current date

        Date minimumExpiryDate = calendar.getTime();
        return expiryDate.after(minimumExpiryDate);
    }
}
