package com.pokik.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private int rows;
    private int columns;
    private int numVehicles;
    private int numRides;
    private int perRideBonus;
    private int numOfSteps;

    public ArrayList<IndividualRide> getIndividualRides() {
        return individualRides;
    }

    private ArrayList<IndividualRide> individualRides;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getNumVehicles() {
        return numVehicles;
    }

    public void setNumVehicles(int numVehicles) {
        this.numVehicles = numVehicles;
    }

    public int getNumRides() {
        return numRides;
    }

    public void setNumRides(int numRides) {
        this.numRides = numRides;
    }

    public int getPerRideBonus() {
        return perRideBonus;
    }

    public void setPerRideBonus(int perRideBonus) {
        this.perRideBonus = perRideBonus;
    }

    public int getNumOfSteps() {
        return numOfSteps;
    }

    public void setNumOfSteps(int numOfSteps) {
        this.numOfSteps = numOfSteps;
    }

    public Data(int rows, int columns, int numVehicles, int numRides, int perRideBonus, int numOfSteps, ArrayList<IndividualRide> individualRides) {
        this.rows = rows;
        this.columns = columns;
        this.numVehicles = numVehicles;
        this.numRides = numRides;
        this.perRideBonus = perRideBonus;
        this.numOfSteps = numOfSteps;
        this.individualRides = individualRides;
    }

    public static Data getFromFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int numVehicles = scanner.nextInt();
            int numRides = scanner.nextInt();
            int numPerRideBonus = scanner.nextInt();
            int numOfSteps = scanner.nextInt();
            ArrayList<IndividualRide> individualRides = new ArrayList<>();

            for(int i = 0; i < numRides; i++)
            {
                int startRowIntersection = scanner.nextInt();
                int startColumnIntersection = scanner.nextInt();
                int endRowIntersection = scanner.nextInt();
                int endColumnIntersection = scanner.nextInt();
                int earliestStart = scanner.nextInt();
                int latestFinish = scanner.nextInt();
                IndividualRide ride = new IndividualRide(startRowIntersection,startColumnIntersection,endRowIntersection,endColumnIntersection,earliestStart,latestFinish);
                individualRides.add(ride);
            }

            Data data = new Data(rows, columns, numVehicles, numRides, numPerRideBonus, numOfSteps,individualRides);

            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }





}