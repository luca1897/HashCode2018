package com.pokik;

import com.pokik.model.Ride;
import com.pokik.model.Vehicle;

public class SolverByBestVehiclesAndBestRide extends Solver {

    public SolverByBestVehiclesAndBestRide(String filename) {
        super(filename);
    }

    @Override
    public void solve() {
        super.solve();
        for (int step = 0; step < data.getNumOfSteps(); step++) {
            while (true) {
                // searching for the best vehicle which may take the best ride
                Vehicle bestVehicle = null;
                Ride bestRide = null;
                double curBestPoints = Integer.MAX_VALUE;

                for (Vehicle vehicle : vehicles) {
                    if (vehicle.isRiding()) {
                        continue;
                    }

                    for (Ride ride : rides) {
                        if (takenRides.contains(ride))
                            continue;

                        int distance = calculateDistance(step, vehicle, ride);
                        // if a ride may obtain a bonus, favor it
                        if (step + distance <= ride.getEarliestStart())
                            distance -= data.getPerRideBonus();
                        if (distance <= curBestPoints && distance + ride.getLength() <= ride.getLatestFinish() - step) {
                            curBestPoints = distance;
                            bestRide = ride;
                            bestVehicle = vehicle;
                        }
                    }
                }

                if (bestRide == null)
                    break;

                bestVehicle.setDoingRide(step, bestRide);
                rides.remove(bestRide);
                takenRides.add(bestRide);
            }

            moveAllVehicles();
        }

    }
}
