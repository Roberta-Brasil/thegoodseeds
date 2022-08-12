package com.thegoodseeds.seedsaversapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thegoodseeds.seedsaversapp.dtos.request.SeedRequestDto;
import com.thegoodseeds.seedsaversapp.dtos.response.SeedResponseDto;
import com.thegoodseeds.seedsaversapp.entities.Seed;
import com.thegoodseeds.seedsaversapp.enums.TypeOfStorage;
import com.thegoodseeds.seedsaversapp.repositories.SeedRepository;

@Service
public class SeedService {
	
	@Autowired
	private SeedRepository seedRepo;
	
	public List<SeedResponseDto> findAll() {
		
		
		List<Seed> seeds = seedRepo.findAll();
		
		List<SeedResponseDto> seedsDto = seeds.stream().map(SeedResponseDto::new).collect(Collectors.toList());
		
		
		return seedsDto;
	}
	
	public SeedResponseDto insert(SeedRequestDto obj) {
		
		
		Seed seed = setAttributes(obj);
		
		return new SeedResponseDto(seed);
		
	}
	
	private Seed setAttributes(SeedRequestDto obj) {
		
		Seed seed = new Seed();
		seed.setPopularName(obj.getPopularName());
		seed.setTypeOfStorage(TypeOfStorage.valueOf(obj.getTypeOfStorage()));
		seed.setSeedImg(obj.getSeedImg());
		
		return seed;
	}

}
