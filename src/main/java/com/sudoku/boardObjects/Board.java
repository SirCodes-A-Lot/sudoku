package com.sudoku.boardObjects;

import java.util.ArrayList;

public class Board {

	ArrayList<ArrayList<Square>> squaresList;
	
	boolean isSolved = false;
	
	boolean isUnsolvable = false;
	
	public Board(ArrayList<ArrayList<Square>> squaresList) {
		this.squaresList = squaresList;
	}

	public Board() {
	}
	
	public void setBoardFromListOfStringValues(ArrayList<String>values) {
		int count = 0;
		squaresList = new ArrayList<>();
		for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
			ArrayList<Square> row = new ArrayList<>();
			for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
				String value = values.get(count);
				if (value == "") {
					row.add(new Square(rowNumber, columnNumber));
				} else {
					row.add(new Square(rowNumber, columnNumber, Integer.parseInt(value)));
				}
				count +=1;
			}
			squaresList.add(row);
		}
	}
	
	public boolean isSolved() {
		return isSolved;
	}

	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	public boolean isUnsolvable() {
		return isUnsolvable;
	}

	public void setUnsolvable(boolean isUnsolvable) {
		this.isUnsolvable = isUnsolvable;
	}

	public String toString () {
		return "here is the board";
	}
	
	public ArrayList<Square> getRow (int rowNumber) {
		return squaresList.get(rowNumber);
	}
	
	public ArrayList<Square> getColumn (int columnNumber) {
		ArrayList<Square> column = new ArrayList<>();
		for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
			column.add(squaresList.get(rowNumber).get(columnNumber));
		}
		return column;
	}
	
	public ArrayList<Square> getBox (int startRow, int startColumn) {
		ArrayList<Square> box = new ArrayList<>();
		for (int rowNumber = startRow; rowNumber < startRow + 3; rowNumber++) {
			ArrayList<Square> row = squaresList.get(rowNumber);
			for (int columnNumber = startColumn; columnNumber < startColumn + 3; startColumn++) {
				box.add(row.get(columnNumber));
			}
		}
		return box;
	}
	
	public Square getSquare(int rowNumber, int columnNumber) {
		return squaresList.get(rowNumber).get(columnNumber);
	}

	public ArrayList<String> getBoardAsListOfStringValues() {
		ArrayList<String> boardValues = new ArrayList<>();
		for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
			for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
				boardValues.add(Integer.toString(getSquare(rowNumber, columnNumber).getValue()));
			}
		}
		return boardValues;
	}
}
