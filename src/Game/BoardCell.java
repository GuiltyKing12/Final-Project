package Game;

import java.awt.Color;
import java.awt.Graphics;

public class BoardCell {
	private int row;					// Coordinate on the board
	private int col;
	private boolean isSolutionCell;		// Is this cell a potential solution cell?
	private char initial;				// Read from the boardConfig File
	private char secondary;				// Read from the boardConfig File
	private Fraction fraction;
	
	public BoardCell(char initial, int row, int col) {
		this.row = row;
		this.col = col;
		this.isSolutionCell = (initial == 'A') ? true : false;	// Sets isSolutionCell to true if (initial == 'A')
		this.initial = initial;
		this.secondary = '\0';
	}

	public void draw(Graphics g, int size) {
		switch(initial) {
			case 'N': g.setColor(Color.BLACK);
					  break;
			case 'W': g.setColor(Color.YELLOW);
					  break;
			case 'A': g.setColor(Color.GREEN);
					  break;
			case 'I': g.setColor(Color.RED);
					  break;
		}
		g.fillRect(row*size, col*size, size, size);
		
		g.setColor(Color.GRAY);
		g.drawRect(row*size, col*size, size, size);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}

	public void setPosition(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public boolean getIsSolutionCell() {
		return isSolutionCell;
	}
	
	public void setSolutionCell(boolean isSolutionCell) {
		this.isSolutionCell = isSolutionCell;
	}
	
	public char getInitial() {
		return initial;
	}

}
