package com.randomsort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.randomsort.model.RandomNumber;
import com.randomsort.repo.RandomNumberRepository;

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
