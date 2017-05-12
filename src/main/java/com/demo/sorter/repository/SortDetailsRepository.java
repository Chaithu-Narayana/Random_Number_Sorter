package com.demo.sorter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.sorter.model.SortDetails;

/**
 * Interface for generic CRUD operations on the Number Sorting repository  
 *
 */
public interface SortDetailsRepository extends CrudRepository<SortDetails, Integer> {
	
	List<SortDetails> findAllByOrderByIdDesc();

}
