package com.pokik.model;

import com.pokik.Main;

import java.util.ArrayList;

public class Vehicle {
    private Location location = new Location(0, 0);
    private Ride doingRide = null;
    private ArrayList<Ride> completedRides = new ArrayList<>();
    private int missingSteps = 0;
    private int bonus = 0;
    private int stepsDone = 0;

    public ArrayList<Ride> getCompletedRides() {
        return completedRides;
    }

    public Ride getDoingRide() {
        return doingRide;
    }

    public void setDoingRide(int currentStep, Ride ride) {
        this.doingRide = ride;

        if (ride != null) {
            int spaceDistance = this.getLocation().distance(ride.getStartLocation());
            int timeDistance = ride.getEarliestStart() - currentStep;
            this.missingSteps = ride.getLength() + Integer.max(spaceDistance, timeDistance);
            if(spaceDistance + currentStep <= ride.getEarliestStart())
                bonus++;
        }
    }

    public void setRideAndMoveToEnd(Ride ride) {
        if(ride != null)
        {
            int spaceDistance = this.getLocation().distance(ride.getStartLocation());
            int timeDistance = ride.getEarliestStart() - stepsDone;
            this.missingSteps = ride.getLength() + Integer.max(spaceDistance, timeDistance);
            if(spaceDistance + stepsDone <= ride.getEarliestStart())
                bonus++;

            completedRides.add(ride);
            location = ride.getEndLocation();
            stepsDone += missingSteps;
        }
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setDoingRide(Ride ride)
    {
        this.doingRide = ride;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isRiding() {
        return doingRide != null;
    }

    public void setCompletedRides(ArrayList<Ride> completedRides) {
        this.completedRides = completedRides;
    }

    public int getMissingSteps() {
        return missingSteps;
    }

    public void setMissingSteps(int missingSteps) {
        this.missingSteps = missingSteps;
    }

    public void move() {
        if (isRiding()) {
            if (--missingSteps == 0) {
                completedRides.add(doingRide);
                location = doingRide.getEndLocation();
                doingRide = null;
            }
        }
    }

    public int getStepsDone() {
        return stepsDone;
    }

    public void setStepsDone(int stepsDone) {
        this.stepsDone = stepsDone;
    }
}