package com.pokik.model;

public class IndividualRide {
    private Location startLocation;
    private Location endLocation;
    private int earliestStart;
    private int latestFinish;

    public IndividualRide(int startRowIntersection, int startColumnIntersection, int endRowIntersection, int endColumnIntersection, int earliestStart, int latestFinish) {
        this.startLocation = new Location(startColumnIntersection, startRowIntersection);
        this.endLocation = new Location(endColumnIntersection, endRowIntersection);
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    public int getLength() {
        return this.startLocation.distance(this.endLocation);
    }
}