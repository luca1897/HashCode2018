package com.pokik;

import java.util.*;

public class Main {

    private static HashMap<String,Class> files = new HashMap<>();

    public static void main(String[] args) {

        files.put("/Users/xxxx/Desktop/Google/a_example", SolverByBestVehiclesAndBestRide.class);
        files.put("/Users/xxxx/Desktop/Google/b_should_be_easy", SolverByBestVehiclesAndBestRide.class);
        files.put("/Users/xxxx/Desktop/Google/c_no_hurry", SolverByVehicles.class);
        files.put("/Users/xxxx/Desktop/Google/d_metropolis", SolverByBestVehiclesAndBestRide.class);
        files.put("/Users/xxxx/Desktop/Google/e_high_bonus", SolverByBestVehiclesAndBestRide.class);

        try {
            for (String filepath : files.keySet()) {
                Solver sbb;
                sbb = (Solver) files.get(filepath).getConstructor(String.class).newInstance(filepath);
                sbb.solve();
                sbb.writeSolution();
                System.out.println(filepath + ": Points:" + String.valueOf(sbb.getPoints()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}