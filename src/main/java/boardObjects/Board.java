package boardObjects;

import java.util.ArrayList;

public class Board {

	ArrayList<ArrayList<Square>> squaresList;
	
	boolean isSolved = false;
	
	public Board(ArrayList<ArrayList<Square>> squaresList) {
		this.squaresList = squaresList;
		this.isSolved = false;
	}

	public Board() {
	}
	
	public void setBoardFromListOfStringValues(ArrayList<String>values) {
		int count = 0;
		squaresList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Square> row = new ArrayList<>();
			for (int j = 0; j < 10; j++) {
				String value = values.get(count);
				if (value == "") {
					row.add(new Square());
				} else {
					row.add(new Square(Integer.parseInt(value)));
				}
				count +=1;
			}
		}
	}
	//TODO finish toString and get row, col, block
	//public void toString
}
