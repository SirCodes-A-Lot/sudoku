package com.sudoku.services;

import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;

@Service
public class BoardCloneService {
	
	public Board cloneBoard(Board board) {
		if (board.isUnsolvable() || board.isSolved()) {
			System.out.println("ERROR: trying to clone board that is solved or unsolveable");
			return null;
		}
		Board cloneBoard = new Board();
		cloneBoard.setBoardFromListOfStringValues(board.getBoardAsListOfStringValues());
		return cloneBoard;
	}

}
