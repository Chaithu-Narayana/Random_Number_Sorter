package com.demo.sorter.controller;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Microservice controller that performs the sorting operation
 *
 */
@RestController
public class SortingController {
	
	private static int minValue, minIndex, swapCount;
	
	/**
	 * Sort all the numbers that are supplied using an algorithm
	 * 
	 * @param numbers
	 * @return
	 */
	@GetMapping("/sortRandomNumbers/{numbers}")
	public String sortRandomNumbers(@PathVariable String numbers){
		long startTime = System.currentTimeMillis();
		String sortedOutput = intArrayToString(sort(stringToArray(numbers))).concat(":").concat(String.valueOf(swapCount));
		return sortedOutput.concat(":").concat(String.valueOf(System.currentTimeMillis() - startTime));
	}
	
	/**
	 * Converts the given array into a comma separated string
	 * 
	 * @param array
	 * @return
	 */
	public String intArrayToString(int[] array)
	{
		StringJoiner joiner = new StringJoiner(", ");
		Arrays.stream(array).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}
	
	/**
	 * Converts the given comma separated string into an array
	 * 
	 * @param value
	 * @return
	 */
	public int[] stringToArray(String value)
	{
		return Arrays.stream(value.split(",")).map(String::trim).mapToInt(Integer::valueOf).toArray();
	}
	
	/**
	 * Sort the supplied array of nos in ascending order using Selection sort
	 * 
	 * @param arr
	 * @return
	 */
	public int[] sort(int arr[])
	{
		// Find the minimum digit in each iteration and push it to the left most position
		IntStream.range(0, arr.length).forEach(index ->{
			minValue = arr[index];
			minIndex = index;
			
			// Find the minimum no. and its position in the current iteration
			IntStream.range(index+1, arr.length).forEach(value -> {
				if(arr[value]<=minValue)
				{
					minValue = arr[value];
					minIndex = value;
				}
			});
			if(minIndex != index)
			{
				// Increment the no. of swaps
				swapCount++;
				
				// Swap the two positions without using a temp variable
				arr[index] = arr[index] + arr[minIndex];
				arr[minIndex] = arr[index] - arr[minIndex];
				arr[index] = arr[index] - arr[minIndex];
			}
		});
		return arr;
	}
}
