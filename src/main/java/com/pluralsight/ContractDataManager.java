package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.*;
public class ContractDataManager {


    public void ContractReader() {
        List<SalesContract> salesContracts = new ArrayList<>();
        List<LeaseContract> leaseContracts = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/gmany/OneDrive/Desktop/Pluralsight/workshops/AdvancedCarDealership/contracts_with_headings.csv"));
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith("Type|") || line.trim().isEmpty()) {
                    continue; // Skip header or blank lines
                }

                String[] parts = line.split("\\|");

                if (parts.length == 0) continue;

                String type = parts[0].trim();

                if (type.equalsIgnoreCase("SALE")) {
                    salesContracts.add(parseSaleContract(parts));
                } else if (type.equalsIgnoreCase("LEASE")) {
                    leaseContracts.add(parseLeaseContract(parts));
                }
            }

            System.out.println("Total SALE contracts: " + salesContracts.size());
            for (SalesContract s : salesContracts) {
                System.out.println(s);
            }

            System.out.println("Total LEASE contracts: " + leaseContracts.size());
            for (LeaseContract l : leaseContracts) {
                System.out.println(l);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SalesContract parseSaleContract(String[] parts) {
        Vehicle vehicle = new Vehicle(
                Integer.parseInt(parts[4]),  // VIN
                parts[6],                    // Make
                Integer.parseInt(parts[5]),  // Year
                parts[7],                    // Model
                parts[8],                    // Type
                parts[9],                    // Color
                Integer.parseInt(parts[10]), // Odometer
                Double.parseDouble(parts[11]) // Price
        );

        boolean isFinance = parts.length > 16 && parts[16].equalsIgnoreCase("YES");

        return new SalesContract(
                parts[1],  // Date
                parts[2],  // Name
                parts[3],  // Email
                vehicle,
                isFinance  // Finance option
        );
    }



    public static LeaseContract parseLeaseContract(String[] parts) {
        // Reconstruct Vehicle
        Vehicle vehicle = new Vehicle(
                Integer.parseInt(parts[4]),  // VIN
                parts[6],                    // Make
                Integer.parseInt(parts[5]),  // Year
                parts[7],                    // Model
                parts[8],                    // Type
                parts[9],                    // Color
                Integer.parseInt(parts[10]), // Odometer
                Double.parseDouble(parts[11]) // Price
        );

        // Return LeaseContract
        return new LeaseContract(
                parts[1],   // Date
                parts[2],   // Name
                parts[3],   // Email
                vehicle
        );
    }


    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\gmany\\OneDrive\\Desktop\\Pluralsight\\workshops\\AdvancedCarDealership\\contracts_with_headings.csv", true))) {

            String record = "";
            Vehicle v = contract.getVehicleSold();

            if (contract instanceof SalesContract) {
                SalesContract sc = (SalesContract) contract;
                record = String.join("|",
                        "SALE",
                        sc.getDate(),
                        sc.getName(),
                        sc.getEmail(),
                        String.valueOf(v.getVin()),
                        String.valueOf(v.getYear()),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        String.valueOf(v.getOdometer()),
                        String.valueOf(v.getPrice()),
                        String.valueOf(sc.getSalesTaxAmount()),
                        String.valueOf(sc.getRecordingFee()),
                        String.valueOf(sc.getProcessingFee()),
                        String.valueOf(sc.getTotalPrice()),
                        sc.isFinance() ? "YES" : "NO",
                        String.valueOf(sc.getMonthlyPayment())
                );
            } else if (contract instanceof LeaseContract) {
                LeaseContract lc = (LeaseContract) contract;
                record = String.join("|",
                        "LEASE",
                        lc.getDate(),
                        lc.getName(),
                        lc.getEmail(),
                        String.valueOf(v.getVin()),
                        String.valueOf(v.getYear()),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        String.valueOf(v.getOdometer()),
                        String.valueOf(v.getPrice()),
                        String.valueOf(lc.getExpectedEndingValue()),
                        String.valueOf(lc.getLeaseFee()),
                        String.valueOf(lc.getTotalPrice()),
                        String.valueOf(lc.getMonthlyPayment())
                );
            }

            writer.write(record);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



