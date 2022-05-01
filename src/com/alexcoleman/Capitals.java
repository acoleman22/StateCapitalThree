package com.alexcoleman;

public class Capitals {
        private String name;
        private long populations;
        private double squareMileage;


    public Capitals() {
    }

    public Capitals(String name, long populations, double squareMileage) {
            this.name = name;
            this.populations = populations;
            this.squareMileage = squareMileage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPopulations() {
            return populations;
        }

        public void setPopulations(long populations) {
            this.populations = populations;
        }

        public double getSquareMileage() {
            return squareMileage;
        }

        public void setSquareMileage(double squareMileage) {
            this.squareMileage = squareMileage;
        }
    }

