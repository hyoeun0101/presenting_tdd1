package com.example.presenting_tdd;

public class Movie {
    MovieType movieType;
    String title;

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public Integer getRentalPoints(int daysRented) {
        if (movieType == MovieType.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }

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