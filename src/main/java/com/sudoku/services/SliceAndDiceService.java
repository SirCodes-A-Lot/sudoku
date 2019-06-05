package com.sudoku.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;
import com.sudoku.boardObjects.Square;

@Service
public class SliceAndDiceService {
	
	public Board sliceAndDice (Board board) {
		String sliceAndDiceOutcome;
		ArrayList<Square> squaresToBeSolvedQueue = board.getAllUnsetSquares();
		//iterate through queue
		while (!squaresToBeSolvedQueue.isEmpty()) {
			String outComeFromRemoveOptions = removeOptionsFromSquare();
		}
		//remove options
		//add adjacent squares to queue
		return board;
	}
	
	private String removeOptionsFromSquare() {
		ArrayList<Square> adjacentSetSquares = new ArrayList<>();
		return null;
	}
}
