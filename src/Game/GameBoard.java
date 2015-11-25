package Game;

import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.geom.Vec2d;

public class GameBoard {
	private Vec2d dimensions;
	private ArrayList<String> boardConfigFile;
	private BoardCell[][] board;
	private List<BoardCell> solutionCells;
	private Player player;
	
	public GameBoard() {
		// TODO: implementation
		this.dimensions = null;
		this.boardConfigFile = null;
		this.board = null;
		this.solutionCells = null;
	}
	
	public void initialize() {
		// will call all the functions below
	}
	
	public void loadBoardFromConfigFile() {
		boardConfigFile.add("CSV file 1");
		boardConfigFile.add("CSV file 2");
		boardConfigFile.add("CSV file 3");
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
	
	public Player getPlayer() {
		return player;
	}
	
	public void setSolutionCells(List<BoardCell> solutionCells) {
		//this.solutionCells = solutionCells;
	}
	
	public void setDimensions(Vec2d dimensions) {
		//this.dimensions = dimensions;
	}

	public void setBoard(BoardCell[][] board) {
		//this.board = board;
	}
	
	public void startLevel() {
		// will draw the board
		// uses the boardConfigFile arrayList -> randomly choose one
	}
	
	// These are methods to use for the tests
	public ArrayList<String> getLoadFile() {
		return boardConfigFile;
	}
	
}
