package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Futarok {
    private List<Futar> futarList;

    public Futarok(String filename) {
        futarList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            br.readLine();
            String line = br.readLine();
            while (line != null){
                futarList.add(new Futar(line));
                line= br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String st = "";
        for(Futar f: futarList){
            st += f +"\n";
        }
        return st;
    }

    public long getListLength(){
        return futarList.size();
    }
    public double getIncomeByTaxiId(int id){
        return futarList.stream().filter(f -> f.getTaxiId() == id).mapToDouble(f -> f.getPrice()+f.getTip()).sum();
    }
    public long getTripsByTaxiId(int id){
        return futarList.stream().filter(f -> f.getTaxiId() == id).count();
    }
    public double getAllDistance(){
        return futarList.stream().mapToDouble(Futar::getDistance).sum();
    }
    public Futar getMaxDistance(){
        return futarList.stream().max(Comparator.comparingDouble(Futar::getDistance)).get();
    }
    public Futar getBestTipPerPriceRatio(){
        return futarList.stream().max(Comparator.comparingDouble(f -> f.getTip()/f.getPrice())).get();
    }
    public double getDistanceInKm(int id){
        return futarList.stream().filter(f -> f.getTaxiId() == id).mapToDouble(f->f.getDistance()*1.6).sum();
    }
    public int getMistakes(){
        return futarList.stream().filter(futar -> futar.getPrice() > 0 && futar.getTravelSec() > 0 && futar.getDistance() == 0).toList().size();
    }
    public int getMistakesTime(){
        return futarList.stream().filter(futar -> futar.getPrice() > 0 && futar.getTravelSec() > 0 && futar.getDistance() == 0).mapToInt(Futar::getTravelSec).sum();
    }
    public double getMistakesIncome(){
        return futarList.stream().filter(futar -> futar.getPrice() > 0 && futar.getTravelSec() > 0 && futar.getDistance() == 0).mapToDouble(f -> f.getPrice()+f.getTip()).sum();
    }
    public Futar isInData(int id){
        try{
            return futarList.stream().filter(f -> f.getTaxiId() == id).findAny().get();
        }catch (Exception e){
            return null;
        }
    }
    public List<Futar> getShortestTravel(int number){
        return futarList.stream().filter(futar -> futar.getTravelSec() > 0).sorted(Comparator.comparingInt(Futar::getTravelSec)).distinct().limit(number).toList();
    }
    public long getCountOnDec24(){
        LocalDateTime dec24S = LocalDateTime.of(2016,12,24 , 0,0);
        LocalDateTime dec24E = LocalDateTime.of(2016,12,24 ,23,59,59);
        return futarList.stream().filter(f-> f.getStartTime().isBefore(dec24E) && f.getStartTime().isAfter(dec24S)).count();
    }
    public double getTipOnDec31() {
        LocalDateTime dec31S = LocalDateTime.of(2016, 12, 31, 0, 0);
        LocalDateTime dec31E = LocalDateTime.of(2016, 12, 31, 23, 59, 59);
        return futarList.stream().filter(f -> f.getStartTime().isBefore(dec31E) && f.getStartTime().isAfter(dec31S)).mapToDouble(Futar::getTip).sum()/futarList.stream().filter(f -> f.getStartTime().isBefore(dec31E) && f.getStartTime().isAfter(dec31S)).count();
    }
}