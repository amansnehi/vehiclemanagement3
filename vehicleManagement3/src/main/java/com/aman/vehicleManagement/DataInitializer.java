package com.aman.vehicleManagement;



import com.aman.vehicleManagement.entity.VehicleType;
import com.aman.vehicleManagement.repo.VehicleTypeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final VehicleTypeRepo vehicleTypeRepo;

    @Autowired
    public DataInitializer(VehicleTypeRepo vehicleTypeRepo) {
        this.vehicleTypeRepo = vehicleTypeRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if vehicle types exist, if not, seed the data
        if (vehicleTypeRepo.count() == 0) {
            seedVehicleTypes();
        }
    }

    private void seedVehicleTypes() {
        VehicleType suv = new VehicleType();
        suv.setId(1);
        suv.setType("SUV");
        suv.setMaxPassengersAllowed(5);
        suv.setFarePerKM(70);
        vehicleTypeRepo.save(suv);

        VehicleType sedan = new VehicleType();
        sedan.setId(2);
        sedan.setType("SEDAN");
        sedan.setMaxPassengersAllowed(4);
        sedan.setFarePerKM(50);
        vehicleTypeRepo.save(sedan);

        VehicleType twoWheeler = new VehicleType();
        twoWheeler.setId(3);
        twoWheeler.setType("2wheeler");
        twoWheeler.setMaxPassengersAllowed(1);
        twoWheeler.setFarePerKM(20);
        vehicleTypeRepo.save(twoWheeler);
        
        
        
    }
}

