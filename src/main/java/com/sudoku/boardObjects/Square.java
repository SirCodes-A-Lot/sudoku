package com.sudoku.boardObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Square {
	
	public static String VALUE_SET = "value set";
	
	public static String NO_OPTIONS = "no options";
	
	public static String OPTIONS_REMOVED = "options removed";
	
	public static String NO_OPTIONS_REMOVED = "no options removed";
	
	public static String SQUARE_ALREADY_SET = "square already set";
	
	private int value;
	
	private Set<Integer> options;
	
	private boolean isSet;
	
	public Square() {
		this.isSet = false;
		this.options = new HashSet<Integer>();
		for (int i = 0; i < 10 ; i++) {
			this.options.add(i);
		}
	}

	public Square(int value) {
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
			return SQUARE_ALREADY_SET;
		}
		boolean optionsRemoved = false;
		for (int i = 0; i < optionsToRemove.size(); i++) {
			boolean isRemoved = options.remove(optionsToRemove.get(i));
			if (isRemoved) {
				optionsRemoved = true;
			}
		}
		if (options.isEmpty()) {
			return NO_OPTIONS;
		} else if (options.size() == 1) {
			Iterator<Integer> iterator = options.iterator();
			int value = iterator.next();
			setValue(value);
			return VALUE_SET;
		} else if (optionsRemoved) {
			return OPTIONS_REMOVED;
		} else {
			return NO_OPTIONS_REMOVED;
		}
	}
}
