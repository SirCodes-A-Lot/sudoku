package com.sudoku.boardObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sudoku.constants.Constants;

public class Square {
	
	private int value;
	
	private int row;
	
	private int column;
	
	private Set<Integer> options;
	
	private boolean isSet;
	
	public Square(int row, int column) {
		this.isSet = false;
		this.options = new HashSet<Integer>();
		for (int i = 0; i < 10 ; i++) {
			this.options.add(i);
		}
	}

	public Square(int row, int column, int value) {
		this.value = value;
		this.isSet = true;
		
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
		this.isSet = true;
	}
	
	public Set<Integer> getOptions() {
		return options;
	}
	
	public void setOptions(Set<Integer> options) {
		this.options = options;
	}
	
	public boolean isSet() {
		return isSet;
	}
	
	public String removeOptionsReportOutcome(ArrayList<Integer> optionsToRemove) {
		if (isSet) {
			return Constants.SQUARE_ALREADY_SET;
		}
		boolean optionsRemoved = false;
		for (int i = 0; i < optionsToRemove.size(); i++) {
			boolean isRemoved = options.remove(optionsToRemove.get(i));
			if (isRemoved) {
				optionsRemoved = true;
			}
		}
		if (options.isEmpty()) {
			return Constants.NO_OPTIONS;
		} else if (options.size() == 1) {
			Iterator<Integer> iterator = options.iterator();
			int value = iterator.next();
			setValue(value);
			return Constants.VALUE_SET;
		} else if (optionsRemoved) {
			return Constants.OPTIONS_REMOVED;
		} else {
			return Constants.NO_OPTIONS_REMOVED;
		}
	}
}
