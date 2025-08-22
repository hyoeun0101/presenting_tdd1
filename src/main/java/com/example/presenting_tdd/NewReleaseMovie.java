package com.example.presenting_tdd;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, MovieType.NEW_RELEASE);
    }

    @Override
    public Integer getRentalPoints(int daysRented) {
        if (movieType == MovieType.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    @Override
    public Double getCharge(int daysRented) {
        double charge = 0;
        if (movieType == MovieType.CHILDREN) {
            charge = 1.5;
            if (daysRented > 3) {
                charge += (daysRented - 3) * 1.5;
            }
        } else if (movieType == MovieType.REGULAR) {
            charge = 2;
            if (daysRented > 2) {
                charge += (daysRented - 2) * 1.5;
            }
        } else if (movieType == MovieType.NEW_RELEASE) {
            charge += daysRented * 3;
        }
        return charge;
    }
}
