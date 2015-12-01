package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.braul.clue.game.BadConfigFormatException;
import com.braul.clue.game.BoardCell;
import com.braul.clue.game.DoorDirection;
import com.sun.javafx.geom.Vec2d;

public class GameBoard {
	private Vec2d dimensions;
	private ArrayList<String> boardConfigFile;
	private BoardCell[][] board;
	private Map<Character, String> legend;
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
		Random rand = new Random();
		initializeLevel(boardConfigFile.get(rand.nextInt(3)));
		
	}
	
	public void initializeLevel(String configFile) {
		board = new BoardCell[50][50];
		legend = new HashMap<Character, String>;
		try {
			FileReader filo = new FileReader(configFile);
			BufferedReader br = new BufferedReader(filo);
			String line = "";
			int rowCounter = 0;
			int columnCheck = -1;
			while((line = br.readLine()) != null){
				String[] parts = line.split(",");
				if(columnCheck != -1){
					if(columnCheck != parts.length){
						br.close();
					}
				}
				columnCheck = parts.length;
				for(int i = 0; i < parts.length; i++){
					char c = parts[i].charAt(0);
					if(!legend.containsKey(c)){
						br.close();
					}
				}
				rowCounter++;
			}
			dimensions.x = rowCounter;
			dimensions.y = columnCheck;
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		}
	}
	
	// These are methods to use for the tests
	public ArrayList<String> getLoadFile() {
		return boardConfigFile;
	}
	
}
