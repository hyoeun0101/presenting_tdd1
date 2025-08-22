package com.example.presenting_tdd;

public class MovieRepository {
    static Movie findMovieBy(String title, MovieType movieType) {
        return Movie.of(title, movieType);
    }
}