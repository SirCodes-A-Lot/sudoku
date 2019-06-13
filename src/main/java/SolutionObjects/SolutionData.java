package SolutionObjects;

import com.sudoku.boardObjects.Board;

public class SolutionData {
	
	private boolean isDivideAndConquerUsed = false;
	
	private int optionsGuessed = 0;
	
	private String outcome;
	
	private Board startBoard;
	
	private Board outcomeBoard;
	
	private int solutionsFound = 0;
	
	private boolean isSameValueInRowColumnBox;
	
	private long timeTakenToSolve;

	public SolutionData(Board startBoard) {
		this.startBoard = startBoard;
	}

	public boolean isDivideAndConquerUsed() {
		return isDivideAndConquerUsed;
	}

	public int getOptionsGuessed() {
		return optionsGuessed;
	}

	public String getOutcome() {
		return outcome;
	}

	public Board getStartBoard() {
		return startBoard;
	}

	public Board getOutcomeBoard() {
		return outcomeBoard;
	}

	public int getSolutionsFound() {
		return solutionsFound;
	}

	public boolean isSameValueInRowColumnBox() {
		return isSameValueInRowColumnBox;
	}

	public long getTimeTakenToSolve() {
		return timeTakenToSolve;
	}
	
	public void setDivideAndConquerUsed(boolean isDivideAndConquerUsed) {
		this.isDivideAndConquerUsed = isDivideAndConquerUsed;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public void setOutcomeBoard(Board outcomeBoard) {
		this.outcomeBoard = outcomeBoard;
	}

	public void setSameValueInRowColumnBox(boolean isSameValueInRowColumnBox) {
		this.isSameValueInRowColumnBox = isSameValueInRowColumnBox;
	}

	public void setSolutionData(String outcome, Board outcomeBoard, Long timeTakenToSolve) {
		this.outcome = outcome;
		this.outcomeBoard = outcomeBoard;
		this.timeTakenToSolve = timeTakenToSolve;
	}

}
