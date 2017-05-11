package com.randomsort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomNumberService {

	@Autowired
	private RandomNumberRepository randomNumberRepository;
	
	public Iterable<RandomNumber> getSortedNumbers() {
		return randomNumberRepository.findAll();
	}

	public RandomNumber saveRandomNumber(RandomNumber randomNumber) {
		return randomNumberRepository.save(randomNumber);
	}
}
