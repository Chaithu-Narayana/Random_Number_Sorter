package com.demo.sorter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.sorter.model.RandomNumber;
import com.demo.sorter.repository.RandomNumberRepository;

/**
 * Services the operations requested by the Sorter App controller
 *
 */
@Service
public class RandomNumberService {

	@Autowired
	private RandomNumberRepository randomNumberRepository;
	
	/**
	 * Retrieves the previous results of sorted numbers from DB
	 * 
	 * @return
	 */
	public Iterable<RandomNumber> getSortedNumbers() {
		return randomNumberRepository.findAllByOrderByIdDesc();
	}

	/**
	 * Saves the details of the current sort request
	 * 
	 * @param randomNumber
	 * @return
	 */
	public RandomNumber saveRandomNumber(RandomNumber randomNumber) {
		return randomNumberRepository.save(randomNumber);
	}
}
