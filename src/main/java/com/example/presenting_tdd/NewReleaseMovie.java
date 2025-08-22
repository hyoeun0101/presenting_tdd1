package com.example.presenting_tdd;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, MovieType.NEW_RELEASE);
    }

    @Override
    public Integer getRentalPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }

    @Override
    public Double getCharge(int daysRented) {
        return (double) (daysRented * 3);
    }
}
