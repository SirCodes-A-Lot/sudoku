package com.sudoku.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;

@Service
public class RecursiveSolverService {
	
	private SliceAndDiceService sliceAndDiceService;
	
	private int MAX_RECURSIONS = 100;
	
	@Autowired
	public RecursiveSolverService(SliceAndDiceService sliceAndDiceService) {
		this.sliceAndDiceService = sliceAndDiceService;
	}
	
	public ArrayList<String> solveBoardFromStringArray(ArrayList<String> inputBoardValues) {
		Board board = new Board();
		board.setBoardFromListOfStringValues(inputBoardValues);
		solveRecursively(board, MAX_RECURSIONS);
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
