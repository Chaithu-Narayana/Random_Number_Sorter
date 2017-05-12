package com.randomsort.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.randomsort.model.RandomNumber;

public interface RandomNumberRepository extends CrudRepository<RandomNumber, Integer> {
	
	List<RandomNumber> findAllByOrderByIdDesc();

}
