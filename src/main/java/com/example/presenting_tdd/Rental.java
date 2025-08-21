package com.example.presenting_tdd;

public class Rental {
    int daysRented;
    MovieType movieType;
    String title;


    public Rental() {}

    public Rental(String title, MovieType movieType, int daysRented) {
        this.title = title;
        this.movieType = movieType;
        this.daysRented = daysRented;
    }

    public void rentMovie(String title, MovieType movieType, int daysRented) {
        this.daysRented = daysRented;
        this.movieType = movieType;
    }

    public Integer getRentalPoints() {
        if (movieType == MovieType.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    public Double getCharge() {
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