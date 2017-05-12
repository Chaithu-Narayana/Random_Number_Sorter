package com.demo.sorter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.sorter.model.RandomNumber;

/**
 * Interface for generic CRUD operations on the Number Sorting repository  
 *
 */
public interface RandomNumberRepository extends CrudRepository<RandomNumber, Integer> {
	
	List<RandomNumber> findAllByOrderByIdDesc();

}
