package com.sudoku.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;
import com.sudoku.boardObjects.Square;
import com.sudoku.constants.SudokuConstants;

@Service
public class SliceAndDiceService {
	
	public String sliceAndDice (Board board) {
		System.out.println("--- begin slice and dice round ---");
		String sliceAndDiceOutcome = SudokuConstants.NO_OPTIONS_REMOVED;
		ArrayList<Square> squaresToBeSolvedQueue = board.getAllUnsetSquares();
		//iterate through queue
		while (!squaresToBeSolvedQueue.isEmpty()) {
			Square squareToSolve = squaresToBeSolvedQueue.get(0);
			squaresToBeSolvedQueue.remove(0);
			String outcomeFromRemoveOptions = removeOptionsFromSquare(board, squareToSolve);
			if (outcomeFromRemoveOptions == SudokuConstants.VALUE_SET) {
				sliceAndDiceOutcome = SudokuConstants.OPTIONS_REMOVED;
				squaresToBeSolvedQueue.addAll(board.getAdjacentUnsetSquares(squareToSolve));
			} else if (outcomeFromRemoveOptions == SudokuConstants.OPTIONS_REMOVED) {
				sliceAndDiceOutcome = SudokuConstants.OPTIONS_REMOVED;
			} else if (outcomeFromRemoveOptions == SudokuConstants.BOARD_IS_UNSOLVABLE) {
				board.setUnsolvable(true);
				sliceAndDiceOutcome = SudokuConstants.BOARD_IS_UNSOLVABLE;
				break;
			} else if (outcomeFromRemoveOptions == SudokuConstants.SQUARE_ALREADY_SET) {
				//happens when adjacent unset square was already in queue, no action needed.
				//could do turn squares to be solved queue into a set and avoid this outcome, report error here once done.
			}
		}

		System.out.println("--- end slice and dice round. outcome is: " + sliceAndDiceOutcome);
		return sliceAndDiceOutcome;
	}
	
	private String removeOptionsFromSquare(Board board, Square square) {
		Set<Integer> adjacentSetSquareValues = board.getAdjacentSetSquareValues(square);
		return square.removeOptionsReportOutcome(adjacentSetSquareValues);
	}
}
