package com.cognizant.ormlearn;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

	}
	
	private static void getAllCountriesTest(){

		LOGGER.info("Start");
		
		try {
			Country country = countryService.findCountryByCode("IN");

			LOGGER.debug("Country:{}", country);

			LOGGER.info("End");
		}
		catch(CountryNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		
		getAllCountriesTest();
	}

}
