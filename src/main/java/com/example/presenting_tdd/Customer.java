package com.example.presenting_tdd;

enum MovieType {
    CHILDREN,
    REGULAR,
    NEW_RELEASE,
}
public class Customer {
    private int daysRented;

    public void rentMovie(String title, MovieType movieType, int daysRented) {
        this.daysRented = daysRented;
    }

    public Integer getRentalPoints() {
        return 1;
    }

    public Double getCharge() {
        double charge = 1.5;
        if (daysRented > 3) {
            charge += (daysRented -3) * 1.5;
        }
        return charge;
    }
}
