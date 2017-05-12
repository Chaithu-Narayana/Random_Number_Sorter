package com.demo.sorter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents the DB record that we use for saving the details
 *
 */
@Entity
public class RandomNumber implements Serializable {
	private static final long serialVersionUID = 258653472782572573L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// The unordered set of nos
	private String input;

	// The sorted set of nos
	private String output;

	// The no of positions swapped
	private String count;

	// The time taken to sort the nos in milliseconds
	private String timeTakenInMillis;

	public RandomNumber() {
	}

	public RandomNumber(String input, String output, String count) {
		super();

		this.input = input;
		this.output = output;
		this.count = count;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public void setInput(String input) {
		this.input = input;
	}

	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @param output
	 *            the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RandomNumber [input=" + input + ", output=" + output + ", count=" + count + "]";
	}

	/**
	 * @return the timeTakenInMillis
	 */
	public String getTimeTakenInMillis() {
		return timeTakenInMillis;
	}

	/**
	 * @param timeTakenInMillis the timeTakenInMillis to set
	 */
	public void setTimeTakenInMillis(String timeTakenInMillis) {
		this.timeTakenInMillis = timeTakenInMillis;
	}
}
