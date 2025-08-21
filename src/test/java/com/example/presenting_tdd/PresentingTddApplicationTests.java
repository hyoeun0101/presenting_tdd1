package com.example.presenting_tdd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.completionStage;

//@SpringBootTest
class PresentingTddApplicationTests {

	@Test
	void canCreateCustomer() {
		new Customer();
	}

	@Test
	void childrensMovie_3일_대여한_경우() {
		//Arrange
		Customer customer = new Customer();
		//Act
		customer.rentMovie("title", MovieType.CHILDREN, 3);
		//Assert
		assertThat(customer.getRentalPoints()).isEqualTo(1);
		assertThat(customer.getCharge()).isEqualTo(1.5);
	}
}
