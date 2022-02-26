package com.company;

public class Main {

    public static void main(String[] args) {
	    Futarok f = new Futarok("fuvar.csv");
        System.out.println("Number of trips: "+f.getListLength());
        System.out.println("Income of the driver: "+f.getIncomeByTaxiId(6185)+", driver's trips: "+f.getTripsByTaxiId(6185));
        System.out.println("All distance (miles): "+f.getAllDistance());
        System.out.println("Longest trip: "+f.getMaxDistance());
        System.out.println("Richest tip/price: "+f.getBestTipPerPriceRatio());
        System.out.println("Driver's distance (kilometers): "+f.getDistanceInKm(4261));
        System.out.println("Mistakes in "+f.getMistakes()+" rows");
        System.out.println("Travel time in those rows (seconds): "+f.getMistakesTime());
        System.out.println("Income of those rows: "+f.getMistakesIncome());
        System.out.println(f.isInData(1452) != null ? "Is in data": "No data found");
        System.out.println("Shortest trips:\n"+f.getShortestTravel(3));
        System.out.println("Number of trips on 24th December: "+f.getCountOnDec24());
        System.out.println("Tip/trip ratio on 31st December: "+f.getTipOnDec31());
    }
}
