package com.randomsort.controller;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SortRandomNumbersController {
	
	private static int minValue, minIndex, swapCount;
	
	@GetMapping("/sortRandomNumbers/{numbers}")
	public String sortRandomNumbers(@PathVariable String numbers){
		return intArrayToString(sort(stringToArray(numbers))).concat(":").concat(String.valueOf(swapCount));
	}
	
	public String intArrayToString(int[] array)
	{
		StringJoiner joiner = new StringJoiner(", ");
		Arrays.stream(array).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}
	
	public int[] stringToArray(String value)
	{
		return Arrays.stream(value.split(",")).map(String::trim).mapToInt(Integer::valueOf).toArray();
	}
	public int[] sort(int arr[])
	{
		IntStream.range(0, arr.length).forEach(index ->{
			minValue = arr[index];
			minIndex = index;
			IntStream.range(index+1, arr.length).forEach(value -> {
				if(arr[value]<=minValue)
				{
					minValue = arr[value];
					minIndex = value;
				}
			});
			if(minIndex != index)
			{
				swapCount++;
				arr[index] = arr[index] + arr[minIndex];
				arr[minIndex] = arr[index] - arr[minIndex];
				arr[index] = arr[index] - arr[minIndex];
			}
		});
		return arr;
	}
}
