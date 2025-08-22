package com.example.presenting_tdd;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title, MovieType.REGULAR);
    }

    @Override
    public Integer getRentalPoints(int daysRented) {
        return 1;
    }

    @Override
    public Double getCharge(int daysRented) {
        double charge = 2;
        if (daysRented > 2) {
            charge += (daysRented - 2) * 1.5;
        }
        return charge;
    }
}
