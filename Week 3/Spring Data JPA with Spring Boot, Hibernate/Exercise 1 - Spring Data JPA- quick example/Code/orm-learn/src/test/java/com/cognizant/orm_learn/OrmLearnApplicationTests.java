package com.cognizant.orm_learn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.service.CountryService;

@SpringBootTest
class OrmLearnApplicationTests {

	@Test
	void testGetAllCountries(){
		// Arrange
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class);
		CountryService service = context.getBean(CountryService.class);

		// Act
		String result = service.getAllCountries().toString();

		// Assert
		assertEquals("[Country Code: IN, Country Name: India, Country Code: US, Country Name: United States of America]", result);
	}

}
