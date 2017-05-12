package com.demo.sorter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.sorter.model.SortDetails;
import com.demo.sorter.repository.SortDetailsRepository;

/**
 * Services the operations requested by the Sorter App controller
 *
 */
@Service
public class RandomNumberService {

	@Autowired
	private SortDetailsRepository randomNumberRepository;
	
	/**
	 * Retrieves the previous results of sorted numbers from DB
	 * 
	 * @return
	 */
	public Iterable<SortDetails> getSortedNumbers() {
		return randomNumberRepository.findAllByOrderByIdDesc();
	}

	/**
	 * Saves the details of the current sort request
	 * 
	 * @param randomNumber
	 * @return
	 */
	public SortDetails saveRandomNumber(SortDetails randomNumber) {
		return randomNumberRepository.save(randomNumber);
	}
}
