package com.sudoku.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;
import com.sudoku.constants.Constants;

@Service
public class RecursiveSolverService {
	
	private SliceAndDiceService sliceAndDiceService;
	
	@Autowired
	public RecursiveSolverService(SliceAndDiceService sliceAndDiceService) {
		this.sliceAndDiceService = sliceAndDiceService;
	}
	
	public ArrayList<String> solveBoardFromStringArray(ArrayList<String> inputBoardValues) {
		Board board = new Board();
		board.setBoardFromListOfStringValues(inputBoardValues);
		solveRecursively(board, Constants.MAX_RECURSIONS);
		ArrayList<String> outputBoardValues = board.getBoardAsListOfStringValues();
		return outputBoardValues;
	}

	private Board solveRecursively(Board board, int recursions) {
		if (board.isSolved() || recursions == 0) {
			return board;
		} else {
			//Slice and dice
			
			//exclusiveOptions
			
			//if progress made
			recursions -=1;
			return solveRecursively(board, recursions);
		}
	}
}
