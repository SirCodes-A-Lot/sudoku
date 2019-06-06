package com.sudoku.boardObjects;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sudoku.constants.SudokuConstants;

public class Square {
	
	private int value;
	
	private int row;
	
	private int column;
	
	private Set<Integer> options;
	
	private boolean isSet;
	
	public Square(int row, int column) {
		this.row = row;
		this.column = column;
		this.isSet = false;
		this.options = new HashSet<Integer>();
		for (int i = 1; i < 10 ; i++) {
			this.options.add(i);
		}
	}

	public Square(int row, int column, int value) {
		this.row = row;
		this.column = column;
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
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
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
	
	public String removeOptionsReportOutcome(Set<Integer> optionsToRemove) {
		if (isSet) {
			return SudokuConstants.SQUARE_ALREADY_SET;
		}
		boolean optionsRemoved = options.removeAll(optionsToRemove);
		if (options.isEmpty()) {
			return SudokuConstants.NO_OPTIONS;
		} else if (options.size() == 1) {
			System.out.println("setting square value");
			Iterator<Integer> iterator = options.iterator();
			int value = iterator.next();
			System.out.println(value);
			setValue(value);
			return SudokuConstants.VALUE_SET;
		} else if (optionsRemoved) {
			return SudokuConstants.OPTIONS_REMOVED;
		} else {
			return SudokuConstants.NO_OPTIONS_REMOVED;
		}
	}
}
