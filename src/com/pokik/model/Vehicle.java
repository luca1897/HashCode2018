package com.pokik.model;

import java.util.ArrayList;

public class Vehicle {
    private Location position = new Location(0, 0);
    private IndividualRide doingRide = null;
    private ArrayList<IndividualRide> completedRides = new ArrayList<>();
    private int missingStep = 0;

    public ArrayList<IndividualRide> getCompletedRides() {
        return completedRides;
    }

    public IndividualRide getDoingRide() {
        return doingRide;
    }

    public void setDoingRide(int currentStep, IndividualRide ride) {
        this.doingRide = ride;

        this.missingStep = ride.getLength() + Integer.max(ride.getEarliestStart() - currentStep, this.getPosition().distance(ride.getStartLocation()));
    }

    public Location getPosition() {
        return position;
    }

    public void setPosition(Location position) {
        this.position = position;
    }

    public boolean isRiding() {
        return doingRide != null;
    }

    public void move() {
        if (isRiding()) {
            missingStep--;
            if (missingStep == 0) {
                completedRides.add(doingRide);
                position = doingRide.getEndLocation();
                doingRide = null;
            }
        }
    }
}