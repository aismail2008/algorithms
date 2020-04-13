package com.code.test.problemset.CrackingCodingInterview6.ch7.Q8_Othello;

public class Location {
	private int row;
	private int column;
	public Location(int r, int c) {
		row = r;
		column = c;
	}
	
	public boolean isSameAs(int r, int c) {
		return row == r && column == c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
}
