package com.example.presenting_tdd;

import java.util.ArrayList;
import java.util.List;


public class RentalCalculator {
    private List<Rental> rentals = new ArrayList<>();

    public void rentMovie(String title, MovieType movieType, int daysRented) {
        rentals.add(new Rental(title, movieType, daysRented));
    }

    public Integer getRentalPoints() {
        return rentals.stream()
                .mapToInt(Rental::getRentalPoints)
                .sum();
    }

    public Double getCharge() {
        return rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }
}
