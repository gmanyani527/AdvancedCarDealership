package com.pluralsight;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double leaseFee;
    private double originalPrice;
    private static final double INTEREST_RATE = 0.04;
    private static final int TERM_MONTHS = 36;

    public LeaseContract(String date, String name, String email, Vehicle vehicleSold) {
        super(date, name, email, vehicleSold);
        this.originalPrice = vehicleSold.getPrice();
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

    @Override
    public double getTotalPrice() {
        return originalPrice + leaseFee;
    }
    @Override
    public double getMonthlyPayment() {
        double depreciation = originalPrice - expectedEndingValue;
        double monthlyRate = INTEREST_RATE / 12;

        double monthlyPayment = (depreciation + leaseFee) *
                (monthlyRate / (1 - Math.pow(1 + monthlyRate, -TERM_MONTHS)));


        return monthlyPayment;


    }

    @Override
    public String toString() {
        return "LeaseContract{" +
                "date='" + super.getDate() + '\'' +
                ", customer='" + super.getName() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", vehicle='" + super.getVehicleSold() + '\'' +
                ", originalPrice=" + originalPrice +
                ", expectedEndingValue=" + expectedEndingValue +
                ", leaseFee=" + leaseFee +
                '}';
    }



}
