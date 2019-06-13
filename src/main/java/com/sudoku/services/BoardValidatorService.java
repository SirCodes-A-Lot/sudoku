package com.sudoku.services;

import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;
import com.sudoku.boardObjects.Square;

@Service
public class BoardValidatorService {
	
	/**
	 * checks that there are no duplicate values in any row column or box
	 * @return true if there are no duplicates
	 */
	public boolean isSudokuGridValid(Board board) {
		Iterator <Square> setSquareIterator = board.getAllSetSquares().iterator();
		while (setSquareIterator.hasNext()) {
			Square targetSquare = setSquareIterator.next();
			int targetSquareValue = targetSquare.getValue();
			Iterator<Integer> adjacentValueIterator = board.getAdjacentSetSquareValues(targetSquare).iterator();
			while (adjacentValueIterator.hasNext()) {
				int adjacentValue = adjacentValueIterator.next();
				if (targetSquareValue == adjacentValue) {
					System.out.println("ERROR: Sudoku is invalid, two adjacent squares have the same value");
					return false;
				}
			}
		}
		return true;
	}
}
