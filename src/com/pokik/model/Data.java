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

  public Data(int rows, int columns, int numVehicles, int numRides, int perRideBonus, int numOfSteps, ArrayList<Ride> rides) {
    this.rows = rows;
    this.columns = columns;
    this.numVehicles = numVehicles;
    this.numRides = numRides;
    this.perRideBonus = perRideBonus;
    this.numOfSteps = numOfSteps;
    this.rides = rides;
  }

  public ArrayList<Ride> getRides() {
    return rides;
  }

  private ArrayList<Ride> rides;

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


}
