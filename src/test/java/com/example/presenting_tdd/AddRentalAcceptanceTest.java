package com.example.presenting_tdd;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddRentalAcceptanceTest {

    @Autowired
    private MovieRepository movieRepository;

    private final String childrensMovieTitle = "childrenMovieTitle";

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void walking_skeleton() {
        movieRepository.save(new Movie(childrensMovieTitle.trim()));

        final Movie rentalResponse =
                given()
                .when()
                        .get("/rentals?title=childrenMovieTitle")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(Movie.class);


        System.out.println(rentalResponse);
    }




}