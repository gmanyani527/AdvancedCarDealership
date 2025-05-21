package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class ContractDataManager {


    public Contract getContract() {
        Contract contract = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\gmany\\OneDrive\\Desktop\\Pluralsight\\workshops\\AdvancedCarDealership\\contracts_with_headings.csv"));
            String line;

            if ((line = br.readLine()) != null) {
                String[] dealerInfo = line.split("\\|");
                String name = dealerInfo[0];
                String address = dealerInfo[1];
                String phone = dealerInfo[2];

                dealership = new Dealership(name, address, phone);
            }

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // skip empty lines
                }
                String[] parts = line.split("\\|");
                if (parts.length != 8) {
                    System.out.println("Skipping bad line: " + line);
                    continue; // skip invalid lines
                }
                int vin = Integer.parseInt(parts[0]);
                String make = parts[1];
                int year = Integer.parseInt(parts[2]);
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, make, year, model, vehicleType, color, odometer, price);

                dealership.addVehicle(vehicle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contract;
    }


}
