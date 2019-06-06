package com.sudoku.services;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;
import com.sudoku.boardObjects.Square;
import com.sudoku.constants.SudokuConstants;

@Service
public class SliceAndDiceService {
	
	public Board sliceAndDice (Board board) {
		String sliceAndDiceOutcome = SudokuConstants.NO_OPTIONS_REMOVED;
		ArrayList<Square> squaresToBeSolvedQueue = board.getAllUnsetSquares();
		System.out.println(squaresToBeSolvedQueue.size());
		//iterate through queue
		while (!squaresToBeSolvedQueue.isEmpty()) {
			Square squareToSolve = squaresToBeSolvedQueue.get(0);
			squaresToBeSolvedQueue.remove(0);
			String outcomeFromRemoveOptions = removeOptionsFromSquare(board, squareToSolve);
			System.out.println(outcomeFromRemoveOptions);
			if (outcomeFromRemoveOptions == SudokuConstants.VALUE_SET) {
				//Add all unsolved adjacent squares to queue
			}
			//handle other outcomes
		}
		//remove options
		//add adjacent squares to queue
		return board;
	}
	
	private String removeOptionsFromSquare(Board board, Square square) {
		Set<Integer> adjacentSetSquareValues = board.getAdjacentSetSquareValues(square);
		return square.removeOptionsReportOutcome(adjacentSetSquareValues);
	}
}
