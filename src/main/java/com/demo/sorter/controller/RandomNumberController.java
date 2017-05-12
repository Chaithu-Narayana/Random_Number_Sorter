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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView generateRandomNumbers() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping(value = "/generaterandomnumbers", method = RequestMethod.POST)
	public ModelAndView generateRandomNumbers(@RequestParam("number") int number) {
		ModelAndView model = new ModelAndView("index");

		model.addObject("randomNumbers", getRandomNumbers(number));
		return model;
	}

	private String getRandomNumbers(int number) {
		String[] array = new String[number];
		Random randomGenerator = new Random();
		for (int idx = 0; idx < number; ++idx) {
			array[idx] = String.valueOf(randomGenerator.nextInt(100 + number));
		}
		return String.join(",", array);
	}

	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	public ModelAndView sort(@RequestParam("generatedRandomNumbers") String randomNumbers) {
		ModelAndView model = new ModelAndView("index");
		List<RandomNumber> randomNumbersList = new ArrayList<RandomNumber>();

		RandomNumber randomNumber = new RandomNumber();
		randomNumber.setInput(randomNumbers);
		/*String sortedString[] = new RestTemplate()
				.getForObject("http://localhost:8081/sortRandomNumbers/" + randomNumbers, String.class).split(":");*/
		String sortedString[] = new RestTemplate()
				.getForObject(sorterApp.getMicroserviceUrl() + randomNumbers, String.class).split(":");
		randomNumber.setOutput(sortedString[0]);
		randomNumber.setCount(sortedString[1]);
		randomNumberService.saveRandomNumber(randomNumber);
		randomNumberService.getSortedNumbers().forEach(randomNumbersList::add);

		model.addObject("randomNumbersList", randomNumbersList);
		return model;
	}
}
