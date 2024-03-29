package com.sudoku.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudoku.boardObjects.Board;
import com.sudoku.boardObjects.Square;
import com.sudoku.constants.SudokuConstants;

@Service
public class RecursiveSolverService {
	
	private int guesses;
	
	private BoardValidatorService boardValidatorService;
	
	private SliceAndDiceService sliceAndDiceService;
	
	private BoardCloneService boardCloneService;
	
	
	
	@Autowired
	public RecursiveSolverService(BoardValidatorService boardValidatorService,
			SliceAndDiceService sliceAndDiceService, 
			BoardCloneService boardCloneService) {
		this.sliceAndDiceService = sliceAndDiceService;
		this.boardCloneService = boardCloneService;
		this.boardValidatorService = boardValidatorService;
	}
	
	public ArrayList<String> solveBoardFromStringArray(ArrayList<String> inputBoardValues) {
		guesses = SudokuConstants.MAX_GUESSES;
		Board board = new Board();
		Board outputBoard;
		board.setBoardFromListOfStringValues(inputBoardValues);
		if (boardValidatorService.isSudokuGridValid(board)) {
			outputBoard = solveRecursively(board);
		} else {
			outputBoard = board;
		}
		return outputBoard.getBoardAsListOfStringValues();
	}

	private Board solveRecursively(Board board) {
		if (board.isSolved() || guesses == 0 || board.isUnsolvable()) {
			return board;
		} else {
			//Slice and dice
			String sliceAndDiceOutcome = sliceAndDiceService.sliceAndDice(board);
			System.out.println("Is board solved: " + board.isSolved());
			System.out.println("board: " + board.getBoardAsListOfStringValues());
			//pointing pair plus could go here
			//if progress made cycle slice and dice and pointing pair plus by calling solve recursively here
			if (board.isSolved() || board.isUnsolvable()) {
				return board;
			}
			return divideAndGuessReturnFirstSolvedBoard(board);
		}
	}
	
	private Board divideAndGuessReturnFirstSolvedBoard(Board board) {
		Square targetSquare = board.getSquareWithFewestOptions();
		Iterator<Integer> optionsIterator = targetSquare.getOptions().iterator();
		Board outcomeBoardAfterTryingToSolve = null;
		while (optionsIterator.hasNext()) {
			if (guesses == 0) {
				return board;
			}
			guesses -=1;
			Integer option = optionsIterator.next();
			Board cloneBoard = boardCloneService.cloneBoard(board);
			Square cloneTargetSquare = cloneBoard.getSquare(targetSquare.getRow(), targetSquare.getColumn());
			cloneTargetSquare.setValue(option);
			outcomeBoardAfterTryingToSolve = solveRecursively(cloneBoard);
			if (outcomeBoardAfterTryingToSolve.isSolved()) {
				return outcomeBoardAfterTryingToSolve;
			}
		}
		return outcomeBoardAfterTryingToSolve;
	}
}
