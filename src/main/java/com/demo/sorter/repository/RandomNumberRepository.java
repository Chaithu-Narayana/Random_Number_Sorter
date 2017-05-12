package com.demo.sorter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.sorter.model.RandomNumber;

public interface RandomNumberRepository extends CrudRepository<RandomNumber, Integer> {
	
	List<RandomNumber> findAllByOrderByIdDesc();

}
