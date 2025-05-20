package com.pluralsight;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double leaseFee;
    private double originalPrice;
    private static final double INTEREST_RATE = 0.04;
    private static final int TERM_MONTHS = 36;

    public LeaseContract(String date, String customerName, String email, String vehicleSold, double originalPrice) {
        super(date, customerName, email, vehicleSold);
        this.originalPrice = originalPrice;
        this.expectedEndingValue = 0.5 * originalPrice;
        this.leaseFee = 0.07 * originalPrice;
    }


    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }



}
