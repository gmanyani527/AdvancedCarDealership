package com.pluralsight;

public class SalesContract extends Contract {

    private double salesTax = .05;
    private int recordingFee = 100;
    private int processingFee;
    private boolean isFinance;
    private double vehiclePrice;

    public SalesContract(String date, String name, String email, String vehicleSold, double vehiclePrice, boolean isFinance) {
        super(date, name, email, vehicleSold);
        this.salesTax = .05;
        this.vehiclePrice = vehiclePrice;
        this.processingFee = (vehiclePrice < 10000) ? 295 : 495;
        this.isFinance = isFinance;
    }


    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public double getSalesTaxAmount() {
        return vehiclePrice * salesTax;
    }
    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return isFinance;
    }

    public void setFinance(boolean finance) {
        isFinance = finance;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    @Override
    public double getTotalPrice() {
        return vehiclePrice + getSalesTaxAmount() + getRecordingFee() + getProcessingFee();
    }


    @Override
    public double getMonthlyPayment() {
        if (!isFinance) {
            return 0.0;
        }

        double totalPrice = getTotalPrice();
        double interestRate;
        int termMonths;

        if (vehiclePrice >= 10000) {
            interestRate = 0.0425;
            termMonths = 48;
        } else {
            interestRate = 0.0525;
            termMonths = 24;
        }

        double monthlyInterestRate = interestRate / 12;
        return totalPrice * (monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -termMonths)));
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "date='" + super.getDate() + '\'' +
                ", customer='" + super.getName() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", vehicle='" + super.getVehicleSold() + '\'' +
                ", vehiclePrice=" + vehiclePrice +
                ", salesTax=" + salesTax +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", isFinance=" + isFinance +
                '}';
    }
}
