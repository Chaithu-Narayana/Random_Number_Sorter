package com.randomsort;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RandomNumber implements Serializable {
	private static final long serialVersionUID = 258653472782572573L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String input;
	private String output;
	private String count;

	public RandomNumber(){}
			
	public RandomNumber(String input, String output, String count) {
		super();

		this.input = input;
		this.output = output;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "RandomNumber [input=" + input + ", output=" + output + ", count=" + count + "]";
	}
}
