package com.sudoku.boardObjects;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	private Board board;
	
	private ArrayList<String> EMPTY_BOARD_AS_STRING = new ArrayList<String>(Arrays.asList(
			"","","","","","","","","",
			"","","","","","","","","",
			"","","","","","","","","",
			"","","","","","","","","",
			"","","","","","","","","",
			"","","","","","","","","",
			"","","","","","","","","",
			"","","","","","","","","",
			"","","","","","","","",""));
	
	@Before
	public void setup() {
		board = new Board();
	}

}
