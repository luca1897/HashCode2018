package com.pokik.solver;

import com.pokik.model.Ride;
import com.pokik.model.Vehicle;

public class SolverByVehicles extends Solver {

    public SolverByVehicles(String filename){
        super(filename);
    }

    @Override
    public void solve() {
        super.solve();
        for(Vehicle vehicle : vehicles)
        {
            while (true)
            {
                Ride bestRide = null;
                int bestDistance = Integer.MAX_VALUE;

                for (Ride ride : data.getRides())
                {
                    if(takenRides.contains(ride))
                        continue;

                    int distance = calculateDistance(vehicle.getStepsDone(),vehicle,ride);
                    if(distance < bestDistance && distance + ride.getLength() <= ride.getLatestFinish() - vehicle.getStepsDone())
                    {
                        bestRide = ride;
                        bestDistance = distance;
                    }

                }

                if(bestRide == null )
                    break;

                vehicle.setRideAndMoveToEnd(bestRide);
                takenRides.add(bestRide);
                rides.remove(bestRide);
            }
        }
    }
}
