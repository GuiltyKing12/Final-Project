package Game;

import java.util.List;

import com.sun.javafx.geom.Vec2d;

public class GameBoard {
	private Vec2d dimensions;
	private String boardConfigFile;
	private BoardCell[][] board;
	private List<BoardCell> solutionCells;
	
	public GameBoard() {
		// TODO: implementation
		this.dimensions.x = 0;
		this.dimensions.y = 0;
		this.boardConfigFile = null;
		this.setBoard(null);
		this.solutionCells = null;
	}
	
	public void loadBoardFromConfigFile() {
		// TODO: implementation
	}
	
	public List<BoardCell> getSolutionCells() {
		return solutionCells;
	}
	
	public Vec2d getDimensions() {
		return dimensions;
	}

	public BoardCell[][] getBoard() {
		return board;
	}
	
	public void setSolutionCells(List<BoardCell> solutionCells) {
		this.solutionCells = solutionCells;
	}
	
	public void setDimensions(Vec2d dimensions) {
		this.dimensions = dimensions;
	}

	public void setBoard(BoardCell[][] board) {
		this.board = board;
	}
}
