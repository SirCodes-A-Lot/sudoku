package com.sudoku.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;

@Service
public class RecursiveSolverService {
	
	public ArrayList<String> solveBoardFromStringArray(ArrayList<String> inputBoardValues) {
		Board board = new Board();
		board.setBoardFromListOfStringValues(inputBoardValues);
		solveRecursively(board);
		ArrayList<String> outputBoardValues = board.getBoardAsListOfStringValues();
		return outputBoardValues;
	}

	private Board solveRecursively(Board board) {
		if (board.isSolved()) {
			return board;
		} else {
			//TODO do other logic delete line below
			board.setSolved(true);
			//Slice and dice
			
			//exclusiveOptions
			
			//if progress made
			return solveRecursively(board);
		}
	}
}
