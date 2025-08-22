package com.example.presenting_tdd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Movie {
    public Movie() {}

    public Movie(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private MovieType type;
}


enum MovieType {
    CHILDREN,
    REGULAR,
    NEW_RELEASE,
}