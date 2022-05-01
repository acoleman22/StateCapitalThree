package com.alexcoleman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StateCapitalApp {
    public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
            Map<String, Capitals> stateCapitals = new HashMap<>();
            String DELIMITER = "::";
            String state;
            long population;



            Scanner sc = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));

            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] currentLineArray = currentLine.split(DELIMITER);

                state = currentLineArray[0];
                String capitalName = currentLineArray[1];
                population = Long.parseLong(currentLineArray[2]);
                double squareMil = Double.parseDouble(currentLineArray[3]);
                Capitals curCapital = new Capitals(capitalName,population,squareMil);

                stateCapitals.put(state, curCapital);


            }
            printStatePairs(stateCapitals);
        }
    public static void printStatePairs(Map<String,Capitals> stateCapitals){
        System.out.println("There were "+stateCapitals.size()+ " State/Capital pairs loaded");

        Set<String> keys = stateCapitals.keySet();

        for(String currentKey : keys){
            System.out.print(currentKey+" - ");
            System.out.print(stateCapitals.get(currentKey).getName());
            System.out.print(" | Pop: "+stateCapitals.get(currentKey).getPopulations());
            System.out.println(" | Area: "+ stateCapitals.get(currentKey).getSquareMileage());

            }
        popLimitPrint(stateCapitals,keys);
        sqMilPrint(stateCapitals,keys);

    }
    public static void popLimitPrint(Map<String,Capitals> stateCapitals, Set<String> keys){
        System.out.println("Please enter lower limit for capitals city population ");
        long popLimit =Long.parseLong(scanner.nextLine());

        System.out.println("Listing capitals with populations higher then "+ popLimit);
        for(String currentKey : keys){

            if(stateCapitals.get(currentKey).getPopulations()> popLimit){
                System.out.print(currentKey+" - ");
                System.out.print(stateCapitals.get(currentKey).getName());
                System.out.print(" | Pop: "+stateCapitals.get(currentKey).getPopulations());
                System.out.println(" | Area: "+ stateCapitals.get(currentKey).getSquareMileage());
            }
        }
    }

    public static void sqMilPrint(Map<String,Capitals> stateCapitals, Set<String> keys){
        System.out.println("Please enter upper limit for capitals city population ");
        double sqMilMax =Double.parseDouble (scanner.nextLine());

        System.out.println("Listing capitals with Area less than "+ sqMilMax);
        for(String currentKey : keys){

            if(stateCapitals.get(currentKey).getSquareMileage()< sqMilMax){
                System.out.print(currentKey+" - ");
                System.out.print(stateCapitals.get(currentKey).getName());
                System.out.print(" | Pop: "+stateCapitals.get(currentKey).getPopulations());
                System.out.println(" | Area: "+ stateCapitals.get(currentKey).getSquareMileage());
            }
        }
    }



    }

