package com.example.presenting_tdd;

public class Rental {
     Movie movie;
    int daysRented;


    public Rental() {}

    public Rental(String title, MovieType movieType, int daysRented) {
        this.movie = Movie.of(title, movieType);
        this.daysRented = daysRented;
    }

    public Integer getRentalPoints() {
        return movie.getRentalPoints(daysRented);
    }

    public Double getCharge() {
        return movie.getCharge(daysRented);
    }
}