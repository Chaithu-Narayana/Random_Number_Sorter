package com.demo.sorter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.sorter.model.RandomNumber;
import com.demo.sorter.repository.RandomNumberRepository;

@Service
public class RandomNumberService {

	@Autowired
	private RandomNumberRepository randomNumberRepository;
	
	public Iterable<RandomNumber> getSortedNumbers() {
		//return randomNumberRepository.findAll(new Sort(Sort.Direction.DESC, id));
		return randomNumberRepository.findAllByOrderByIdDesc();
	}

	public RandomNumber saveRandomNumber(RandomNumber randomNumber) {
		return randomNumberRepository.save(randomNumber);
	}
}
