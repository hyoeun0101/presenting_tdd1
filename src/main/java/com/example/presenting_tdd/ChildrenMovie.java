package com.example.presenting_tdd;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title, MovieType.CHILDREN);
    }

    @Override
    public Integer getRentalPoints(int daysRented) {
        return 1;
    }

    @Override
    public Double getCharge(int daysRented) {
        double charge = 1.5;
        if (daysRented > 3) {
            charge += (daysRented - 3) * 1.5;
        }
        return charge;
    }
}
