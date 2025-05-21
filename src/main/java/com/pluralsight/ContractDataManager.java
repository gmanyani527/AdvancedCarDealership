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
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\gmany\\OneDrive\\Desktop\\Pluralsight\\workshops\\AdvancedCarDealership\\contracts_with_headings.csv"));
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
        return new SalesContract(
                parts[1], // date
                parts[2], // name
                parts[3], // email
                parts[4], // vehicleSold
                Double.parseDouble(parts[12]), // salesTax
                Double.parseDouble(parts[11]), // vehiclePrice
                parts[16].equalsIgnoreCase("YES") // isFinance
        );
    }

    public static LeaseContract parseLeaseContract(String[] parts) {
        return new LeaseContract(
                parts[1],
                parts[2],
                parts[3],
                parts[4],
                Double.parseDouble(parts[11])
        );
    }
    }



