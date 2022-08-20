package com.thegoodseeds.seedsaversapp.services.businessRules.updateSeed;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.thegoodseeds.seedsaversapp.dtos.request.SeedRequestDTO;
import com.thegoodseeds.seedsaversapp.entities.Seed;

@Component
public class DateOfCollectionNull implements UpdateSeedValidation {

	@Override
	public void validation(Seed seed, SeedRequestDTO seedDTO) {
		
		if (seedDTO.getDateOfCollection() != null) {
			seed.setDateOfCollection(returnLocalDate(seedDTO.getDateOfCollection()));
		}
	}

	private LocalDate returnLocalDate(String date) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate localDate = LocalDate.parse(date, dtf);

		return localDate;
	}
	
}

