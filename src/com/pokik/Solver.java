package com.pokik;

import com.pokik.model.Data;
import com.pokik.model.Ride;
import com.pokik.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public abstract class Solver {

    public Data data;
    public String filename;

    public ArrayList<Ride> rides;
    public ArrayList<Vehicle> vehicles;
    public HashSet<Ride> takenRides;

    public Solver(String filename) {
        this.filename = filename;
    }

    private void readData() {
        try {
            Scanner scanner = new Scanner(new File(filename + ".in"));
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int numVehicles = scanner.nextInt();
            int numRides = scanner.nextInt();
            int numPerRideBonus = scanner.nextInt();
            int numOfSteps = scanner.nextInt();
            ArrayList<Ride> rides = new ArrayList<>();

            for (int i = 0; i < numRides; i++) {
                int startRowIntersection = scanner.nextInt();
                int startColumnIntersection = scanner.nextInt();
                int endRowIntersection = scanner.nextInt();
                int endColumnIntersection = scanner.nextInt();
                int earliestStart = scanner.nextInt();
                int latestFinish = scanner.nextInt();
                Ride ride = new Ride(startRowIntersection, startColumnIntersection, endRowIntersection, endColumnIntersection, earliestStart, latestFinish);
                rides.add(ride);
            }

            data = new Data(rows, columns, numVehicles, numRides, numPerRideBonus, numOfSteps, rides);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void createVehicles() {
        vehicles = new ArrayList<>();
        for (int i = 0; i < data.getNumVehicles(); i++) {
            vehicles.add(new Vehicle());
        }
    }

    public void solve() {
        readData();
        createVehicles();
        rides = new ArrayList<>(data.getRides());
        takenRides = new HashSet<>();
    }

    public int calculateDistance(int curStep, Vehicle vehicle, Ride ride) {
        int timeDistance = ride.getEarliestStart() - curStep;
        int spaceDistance = vehicle.getLocation().distance(ride.getStartLocation());
        return Integer.max(timeDistance, spaceDistance);
    }

    public void moveAllVehicles() {
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }


    public int getPoints() {
        int points = 0;
        for (Vehicle vehicle : vehicles) {
            for (Ride ride : vehicle.getCompletedRides()) {
                points += ride.getLength();
            }
            points += (vehicle.getBonus() * data.getPerRideBonus());
        }
        return points;
    }



    public void writeSolution() {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(filename + ".out"));
            for (Vehicle vehicle : vehicles) {
                printStream.print("" + vehicle.getCompletedRides().size());
                for (Ride ride : vehicle.getCompletedRides()) {
                    printStream.print(" " + data.getRides().indexOf(ride));
                }
                printStream.println();

            }
            printStream.flush();
            printStream.close();
        } catch (IOException e) {
            // FIXME
        }
    }
}
