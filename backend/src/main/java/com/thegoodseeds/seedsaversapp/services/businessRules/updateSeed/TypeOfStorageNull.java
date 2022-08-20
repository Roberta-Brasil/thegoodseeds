package com.thegoodseeds.seedsaversapp.services.businessRules.updateSeed;

import org.springframework.stereotype.Component;

import com.thegoodseeds.seedsaversapp.dtos.request.SeedRequestDTO;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;

@Component
public class TypeOfStorageNull implements UpdateSeedValidation {

	@Override
	public void validation(Seed seed, SeedRequestDTO seedDTO) {

		if (seedDTO.getTypeOfStorage() != null) {
			seed.setTypeOfStorage(TypeOfStorage.valueOf(seedDTO.getTypeOfStorage()));

		}
	}

}
