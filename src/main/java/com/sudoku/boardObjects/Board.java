package com.sudoku.boardObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	
	public ArrayList<Square> getBoxContainingCoOrdinates(int row, int column) {
		int startRow = row/3;
		int startColumn = column/3;
		return getBox (startRow, startColumn);
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

	public ArrayList<Square> getAllUnsetSquares() {
		ArrayList<Square> unsetSquares = new ArrayList<>();
		for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
			for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
				Square square = getSquare(rowNumber, columnNumber);
				if (!square.isSet()) {
					unsetSquares.add(square);
				}
			}
		}
		if (unsetSquares.size() == 0) {
			System.out.println("ERROR: get all unset squares called, but squares all set");
			System.out.println(getBoardAsListOfStringValues());
		}
		return unsetSquares;
	}
	
	public Set<Integer> getAdjacentSetSquareValues(Square square) {
		Set<Square> adjacentSquares = getAdjacentSquares(square);
		Set<Integer> adjacentSetSquareValues = new HashSet<>();
		Iterator<Square> iterator = adjacentSquares.iterator();
		while (iterator.hasNext()) {
			Square adjacentSquare = iterator.next();
			if (adjacentSquare.isSet()) {
				adjacentSetSquareValues.add(adjacentSquare.getValue());
			}
		}
		return adjacentSetSquareValues;
	}
	
	private Set<Square> getAdjacentSquares(Square square) {
		Set<Square> adjacentSquares = new HashSet<>();
		int squareRow = square.getRow();
		int squareColumn = square.getColumn();
		adjacentSquares.addAll(getBoxContainingCoOrdinates(squareRow, squareColumn));
		adjacentSquares.addAll(getRow(squareRow));
		adjacentSquares.addAll(getColumn(squareColumn));
		return adjacentSquares;
	}
}
