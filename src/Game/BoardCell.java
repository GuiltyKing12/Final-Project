package Game;

import com.sun.javafx.geom.Vec2d;

public class BoardCell {
	private int row;					// Coordinate on the board
	private int col;
	private int cellSideSize;			// Dimension of each cell's side
	private boolean isSolutionCell;		// Is this cell a potential solution cell?
	private char initial;				// Read from the boardConfig File
	private char secondary;				// Read from the boardConfig File
	
	public BoardCell(char initial, int row, int col) {
		this.row = row;
		this.col = col;
		this.cellSideSize = 20;
		this.isSolutionCell = (initial == 'A') ? true : false;	// Sets isSolutionCell to true if (initial == 'A')
		this.initial = initial;
		this.secondary = '\0';
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
