package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;

import com.sun.javafx.geom.Vec2d;

public class GameBoard extends JPanel {
	private int rows = 25;
	private int cols = 25;
	private static final int WIDTH = 1000;
	private static final int LENGTH = 950;
	private int cellSize = 25;
	private ArrayList<String> boardConfigFile;
	private String legendConfigFile;
	private BoardCell[][] board;
	private Map<Character, String> legend;
	private List<BoardCell> solutionCells;
	private Player player;
	
	public GameBoard() {
		setPreferredSize(new Dimension(WIDTH, LENGTH));
		player = new Player();
		initialize();
	}
	
	public void initialize() {
		this.boardConfigFile = new ArrayList<String>();
		this.solutionCells = new ArrayList<BoardCell>();
		this.legend = new HashMap<Character, String>();
		this.board = new BoardCell[rows][cols];
		
		initializeConfigFiles();
		initializeLegend();
		initializeLevel("floorEasy.csv");
		initializeSolutionCellList();
	}
	
	public void initializeConfigFiles() {
		boardConfigFile.add("floorEasy.csv");
		boardConfigFile.add("floorMedium.csv");
		boardConfigFile.add("floorHard.csv");		
		this.legendConfigFile = "Legend.txt";
	}
	
	private void initializeLegend() {
		try {
			FileReader fin = new FileReader(legendConfigFile);
			BufferedReader br = new BufferedReader(fin);
			
			String line = "";

			while((line = br.readLine()) != null){
				String[] parts = line.split(",");
				
				legend.put(parts[0].charAt(0), parts[1]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		
	}
	
	public void initializeLevel(String configFile) {
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
					else {
						board[rowCounter][i] = new BoardCell(c, rowCounter, i);
					}
				}
				rowCounter++;
			}
			rows = rowCounter;
			cols = columnCheck;
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		}
	}
	
	public void updateGame() {
		Vec2d playerPos = getPlayer().getPosition();
		
		if (isPositionSolutionCell((int)(playerPos.y), (int)(playerPos.x))) {		
			// Implement logic - Do we want a dialogue to pop up giving player an option to select this answer or do something else.
			System.out.println("Player: " + playerPos.x + " " + playerPos.y + " isSoln: " + isPositionSolutionCell((int)playerPos.y, (int)playerPos.x) + " -> IMPLEMENT new dialogue asking whether player wants to submit this answer or not.");
		}
	}
	
	private void initializeSolutionCellList() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j].getIsSolutionCell()) {
					solutionCells.add(board[i][j]);

				}
			}
		}
	}
	
	public boolean isPositionSolutionCell(int x, int y) {
		if (board[x][y].getIsSolutionCell()) {
			return true;
		}
		return false;
	}
	
	public void startLevel() {
		// will draw the board
		// uses the boardConfigFile arrayList -> randomly choose one
		Random rand = new Random();
		initializeLevel(boardConfigFile.get(rand.nextInt(3)));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				board[i][j].draw(g, cellSize);
			}
		}
		
		g.setColor(Color.BLACK);
		for(int i = 0; i < solutionCells.size(); i++) {
			g.drawString("x", (int)(solutionCells.get(i).getRow() * cellSize + 0.45 * cellSize), (int)(solutionCells.get(i).getCol() * cellSize + 0.65 * cellSize));
		}
		
		player.draw(g, cellSize);
	}
	
	public List<BoardCell> getSolutionCells() {
		return solutionCells;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	public BoardCell[][] getBoard() {
		return board;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setSolutionCells(List<BoardCell> solutionCells) {
		this.solutionCells = solutionCells;
	}
	
	public void setBoard(BoardCell[][] board) {
		this.board = board;
	}

	// DEBUG METHODS: used for verifying correctness
	public void printBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(board[i][j].getInitial() + " ");
			}
			System.out.println();
		}
	}
	
	public void printLegend() {
		for (char key : legend.keySet()) {
			System.out.println("( " + key + ", " + legend.get(key) + " )");
		}
	}
	
	public void printSolutionCellList() {
		for (int i = 0; i < solutionCells.size(); i++) {
			
			System.out.print("Location: " + "( " + solutionCells.get(i).getRow() + ", " + solutionCells.get(i).getCol() + " )\t");
			System.out.println("Initial: " + solutionCells.get(i).getInitial());
		}
	}
	
	// TEST METHODS: used for tests
	public ArrayList<String> getLoadFile() {
		return boardConfigFile;
	}

	public BoardCell getCellAt(int i, int j) {
		return board[i][j];
	}

	public void setCellSize(int cellSize) {
		this.cellSize = cellSize;
	}
	
	public int getCellSize() {
		return cellSize;
	}
	
}
