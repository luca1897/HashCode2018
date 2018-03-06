package com.pokik;

import java.util.*;

public class Main {

    private static HashMap<String,Class> files = new HashMap<>();

    public static void main(String[] args) {

        files.put("/Users/xxxx/Desktop/Google/a_example", SolverByBestVehiclesAndBestRide.class);
        files.put("/Users/xxxx/Desktop/Google/b_should_be_easy", SolverByBestVehiclesAndBestRide.class);
        files.put("/Users/xxxx/Desktop/Google/c_no_hurry", SolverByBestRidesInVehicle.class);
        files.put("/Users/xxxx/Desktop/Google/d_metropolis", SolverByBestVehiclesAndBestRide.class);
        files.put("/Users/xxxx/Desktop/Google/e_high_bonus", SolverByBestVehiclesAndBestRide.class);

        try {
            for (String filepath : files.keySet()) {
                Solver sbb;
                if (filepath.equals("/Users/xxxx/Desktop/Google/c_no_hurry")) {
                    sbb = (SolverByBestRidesInVehicle) files.get(filepath).getConstructor(String.class).newInstance(filepath);
                } else
                    sbb = (SolverByBestVehiclesAndBestRide) files.get(filepath).getConstructor(String.class).newInstance(filepath);

                sbb.solve();
                sbb.writeSolution();
                System.out.println(String.valueOf(sbb.getPoints()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}