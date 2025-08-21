package com.example.presenting_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.completionStage;

//@SpringBootTest
class PresentingTddApplicationTests {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @ParameterizedTest
    @MethodSource("provideMovieAndExpectedValues")
    public void rentalForVariousCase(String title, MovieType children, int daysRented, int expectedPoints, double expectedCharge) {
        rentMovieAndAssertPointsAndCharge(title, children, daysRented, expectedPoints, expectedCharge);
    }

    private void rentMovieAndAssertPointsAndCharge(String title, MovieType children, int daysRented, int expectedPoints, double expectedCharge) {
        customer.rentMovie(title, children, daysRented);
        assertThat(customer.getRentalPoints()).isEqualTo(expectedPoints);
        assertThat(customer.getCharge()).isEqualTo(expectedCharge);
    }

    public static Stream<Arguments> provideMovieAndExpectedValues() {
        return Stream.of(
                Arguments.of("childrenMovie1", MovieType.CHILDREN, 3, 1, 1.5)
                , Arguments.of("childrenMovie2", MovieType.CHILDREN, 4, 1, 3)
                , Arguments.of("regularMovie1", MovieType.REGULAR, 2, 1, 2)
                , Arguments.of("regularMovie2", MovieType.REGULAR, 3, 1, 3.5)
                , Arguments.of("newReleaseMovie1", MovieType.NEW_RELEASE, 1, 1, 3)
                , Arguments.of("newReleaseMovie2", MovieType.NEW_RELEASE, 2, 2, 6)
        );
    }
}
