package com.example.presenting_tdd;

enum MovieType {
    CHILDREN,
    REGULAR,
    NEW_RELEASE,
}

public abstract class Movie {
    MovieType movieType;
    String title;

    protected Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public static Movie of(String title, MovieType movieType) {
        switch (movieType) {
            case CHILDREN :
                return new ChildrenMovie(title);
            case REGULAR:
                return new RegularMovie(title);
            case NEW_RELEASE :
                return new NewReleaseMovie(title);
            default :
                throw new IllegalArgumentException("Invalid MovieType: " + movieType);
        }
    }

    public abstract Integer getRentalPoints(int daysRented);

    public abstract Double getCharge(int daysRented);
}