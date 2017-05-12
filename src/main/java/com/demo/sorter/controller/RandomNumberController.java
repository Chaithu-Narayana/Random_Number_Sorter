package com.demo.sorter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.demo.sorter.model.RandomNumber;
import com.demo.sorter.properties.SorterAppProperties;
import com.demo.sorter.service.RandomNumberService;

/**
 * The chief controller of the Sorter Application that handles all calls from the UI layer
 *
 */
@Controller
@RequestMapping("/index")
public class RandomNumberController {

	@Autowired
	private RandomNumberService randomNumberService;

	private SorterAppProperties sorterApp;

	@Autowired
	public void setGlobal(SorterAppProperties sorterApp) {
		this.sorterApp = sorterApp;
	}

	/**
	 * Assists in launching the homepage of the App before any service is requested.
	 *
	 * @return returns the view that needs to be displayed on the start-up
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView generateRandomNumbers() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	/**
	 * Overloaded method to generate Random numbers based on the input supplied by the user
	 * 
	 * @param number
	 * @return returns the view that displays the generated random numbers
	 */
	@RequestMapping(value = "/generaterandomnumbers", method = RequestMethod.POST)
	public ModelAndView generateRandomNumbers(@RequestParam("number") int number) {
		ModelAndView model = new ModelAndView("index");

		model.addObject("randomNumbers", getRandomNumbers(number));
		return model;
	}

	/**
	 * Generate the requested no. of random numbers
	 * 
	 * @param number
	 * @return
	 */
	private String getRandomNumbers(int number) {
		String[] array = new String[number];
		Random randomGenerator = new Random();
		for (int idx = 0; idx < number; ++idx) {
			array[idx] = String.valueOf(randomGenerator.nextInt(100 + number));
		}
		return String.join(",", array);
	}

	/**
	 * Invokes the 'Sorting' microservice to sort the random numbers, saves details to the DB and returns the results
	 * 
	 * @param randomNumbers
	 * @return
	 */
	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	public ModelAndView sort(@RequestParam("generatedRandomNumbers") String randomNumbers) {
		ModelAndView model = new ModelAndView("index");
		List<RandomNumber> randomNumbersList = new ArrayList<RandomNumber>();

		RandomNumber randomNumber = new RandomNumber();
		randomNumber.setInput(randomNumbers);

		//Invoke the REST microservice to sort the unordered numbers
		String sortedString[] = new RestTemplate()
				.getForObject(sorterApp.getMicroserviceUrl() + randomNumbers, String.class).split(":");
		randomNumber.setOutput(sortedString[0]);
		randomNumber.setCount(sortedString[1]);
		randomNumber.setTimeTakenInMillis(sortedString[2]);
		randomNumberService.saveRandomNumber(randomNumber);
		randomNumberService.getSortedNumbers().forEach(randomNumbersList::add);

		model.addObject("randomNumbersList", randomNumbersList);
		return model;
	}
}
