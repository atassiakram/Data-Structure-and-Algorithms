/*
 * Incomplete Experiment 1
 *
 * CSI2510 Algorithmes et Structures de Donnees
 * www.uottawa.ca
 *
 * Robert Laganiere, 2022
 *
 */
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.util.Scanner;

/**
 * Same class as Exp1, but dedicated towards timing the program
 */

public class Exp2 {


    /**
     *
     * @param args: eps is set at arg[0], file is chosen at arg[1], how many points to iterate through is chosen at arg[2]
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {


        //Total time RangeQuery
        long totalTime=0;

        //choose which RangeQuery to use
        String rangeQueryType = args[0];

        //takes the epsilon value
        double eps= Double.parseDouble(args[1]);

        // reads the csv file
        List<Point3D> points= Exp1.read(args[2]);

        //iterate by
        int iterateBy = Integer.parseInt(args[3]);


        if(rangeQueryType.equals("lin")){
            // for each 10 points, calculate how long it takes for the rangeQuery method
            NearestNeighbors nn = new NearestNeighbors(points);
            for(int i=0;i<points.size();i+= iterateBy){
                Point3D query = points.get(i);
                //start timer
                long startTime = System.nanoTime();
                nn.rangeQuery(query,eps);
                //end timer
                long endTime = System.nanoTime();

                //calculate the time it took for the Linear rangeQuery
                long crntTime = endTime - startTime;
                totalTime += crntTime;
            }

        }else if(rangeQueryType.equals("kd")){
            // for each 10 points, calculate how long it takes for the rangeQuery method
            NearestNeighborsKD nn = new NearestNeighborsKD(points);
            for(int i=0;i<points.size();i+= iterateBy) {
                Point3D query = points.get(i);
                //start timer
                long startTime = System.nanoTime();
                nn.rangeQuery(query, eps);
                //end timer
                long endTime = System.nanoTime();

                //calculate the time it took for the K-D Tree rangeQuery
                long crntTime = endTime - startTime;
                totalTime += crntTime;
            }
        } else{
            System.out.println("Invalid RangeQuery Type");
        }

        //cover total time from nanoseconds to milliseconds
        double totalTimeMS = (double) totalTime/1000000;

        //take the average time for a better reference
        int numOfIterations = points.size()/iterateBy;

        double averageTime = totalTimeMS/numOfIterations;

        //print out the results
        System.out.println("RangeQuery total time: "+totalTimeMS+"ms");
        System.out.println("Average time: "+averageTime+"ms");



    }
}

