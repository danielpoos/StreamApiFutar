package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Futar {


    private int taxiId, travelSec;
    private LocalDateTime startTime;
    private double distance, price, tip;
    private String method;

    public Futar(String row) {
        String[] datarow = row.split(";");
        this.taxiId = Integer.parseInt(datarow[0]);
        String[] t = datarow[1].split(" ");
        this.startTime = LocalDateTime.of(Integer.parseInt(t[0].split("-")[0]),Integer.parseInt(t[0].split("-")[1]),Integer.parseInt(t[0].split("-")[2]),Integer.parseInt(t[1].split(":")[0]),Integer.parseInt(t[1].split(":")[1]),Integer.parseInt(t[1].split(":")[2]) );
        this.travelSec = Integer.parseInt(datarow[2]);
        this.distance = Double.parseDouble(datarow[3].replace(",", "."));
        this.price = Double.parseDouble(datarow[4].replace(",", "."));
        this.tip = Double.parseDouble(datarow[5].replace(",", "."));
        this.method = datarow[6];
    }

    @Override
    public String toString() {
        return String.format("Taxi id: %-4d travel time: %-4d distance: %f price: %f tip: %f method: %-11s\n",taxiId,travelSec,distance,price, tip, method);
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    public int getTravelSec() {
        return travelSec;
    }

    public void setTravelSec(int travelSec) {
        this.travelSec = travelSec;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
