package com.example.presenting_tdd;

enum MovieType {
    CHILDREN,
    REGULAR,
    NEW_RELEASE,
}
public class Customer {
    public void rentMovie(String title, MovieType movieType, int daysRented) {

    }

    public Integer getRentalPoints() {
        return 1;
    }

    public Double getCharge() {
        return 1.5;
    }
}
