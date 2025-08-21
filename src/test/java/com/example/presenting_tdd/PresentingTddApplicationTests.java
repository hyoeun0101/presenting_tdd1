package com.example.presenting_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.completionStage;

//@SpringBootTest
class PresentingTddApplicationTests {

	private Customer customer;

	@BeforeEach
	void setUp() {
		customer = new Customer();
	}

	@Test
	void childrensMovie_3일_대여한_경우() {
        rentMovieAndAssertPointsAndCharge("title", MovieType.CHILDREN, 3, 1, 1.5);
	}

	@Test
	void childrensMovie_3일이상_대여한_경우() {
        rentMovieAndAssertPointsAndCharge("title", MovieType.CHILDREN, 4, 1, 3.0);
	}

	private void rentMovieAndAssertPointsAndCharge(String title, MovieType children, int daysRented, int expectedPoints, double expectedCharge) {
		customer.rentMovie(title, children, daysRented);
		assertThat(customer.getRentalPoints()).isEqualTo(expectedPoints);
		assertThat(customer.getCharge()).isEqualTo(expectedCharge);
	}
}
