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
		//Arrange
		//Act
		customer.rentMovie("title", MovieType.CHILDREN, 3);
		//Assert
		assertThat(customer.getRentalPoints()).isEqualTo(1);
		assertThat(customer.getCharge()).isEqualTo(1.5);
	}

	@Test
	void childrensMovie_3일이상_대여한_경우() {
		//Arrange
		//Act
		customer.rentMovie("title", MovieType.CHILDREN, 4);
		//Assert
		assertThat(customer.getRentalPoints()).isEqualTo(1);
		assertThat(customer.getCharge()).isEqualTo(3.0);
	}
}
