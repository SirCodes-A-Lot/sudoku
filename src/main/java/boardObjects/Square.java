package boardObjects;

import java.util.ArrayList;

public class Square {
	int value;
	ArrayList<Integer> options;
	boolean isSet;
	
	public Square() {
		this.isSet = false;
		this.options = new ArrayList<Integer>();
		for (int i = 0; i < 10 ; i++) {
			this.options.add(i);
		}
	}

	public Square(int value) {
		this.value = value;
		this.isSet = true;
		
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
		this.isSet = true;
	}
	public ArrayList<Integer> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<Integer> options) {
		this.options = options;
	}
	public boolean isSet() {
		return isSet;
	}
}
