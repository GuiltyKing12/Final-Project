package Game;

import com.sun.javafx.geom.Vec2d;

public class BoardCell {
	private Vec2d position;			// Coordinate on the board
	private int cellSideSize;			// Dimension of each cell's side
	private boolean isSolutionCell;		// Is this cell a potential solution cell?
	private char initial;				// Read from the boardConfig File
	private char secondary;				// Read from the boardConfig File
	
	public BoardCell() {
		// TODO: implementation
		this.position = null;
		this.cellSideSize = 0;
		this.isSolutionCell = false;
		this.initial = '\0';
		this.secondary = '\0';
	}


	public Vec2d getPosition() {
		return position;
	}

	public void setPosition(Vec2d position) {
		this.position = position;
	}
	
	public boolean getIsSolutionCell() {
		return isSolutionCell;
	}
	
	public void setSolutionCell(boolean isSolutionCell) {
		this.isSolutionCell = isSolutionCell;
	}

}
