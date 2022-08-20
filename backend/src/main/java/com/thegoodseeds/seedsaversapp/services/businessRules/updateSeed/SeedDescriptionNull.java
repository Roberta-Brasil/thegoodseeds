package com.thegoodseeds.seedsaversapp.services.businessRules.updateSeed;

import org.springframework.stereotype.Component;

import com.thegoodseeds.seedsaversapp.dtos.request.SeedRequestDTO;
import com.thegoodseeds.seedsaversapp.entities.Seed;

@Component
public class SeedDescriptionNull implements UpdateSeedValidation {

	@Override
	public void validation(Seed seed, SeedRequestDTO seedDTO) {

		if (seedDTO.getSeedDescription() != null) {
			seed.setSeedDescription(seedDTO.getSeedDescription());

		}
	}

}
