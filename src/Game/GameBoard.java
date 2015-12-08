package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.javafx.geom.Vec2d;

public class GameBoard extends JPanel {
	private int rows = 25;
	private int cols = 25;
	private static final int WIDTH = 1200;
	private static final int LENGTH = 1100;
	private int cellSize = 25;
	private ArrayList<String> boardConfigFiles;
	private String legendConfigFile;
	private BoardCell[][] board;
	private Map<Character, String> legend;
	private List<BoardCell> solutionCells;
	private Player player;
	
	public GameBoard() {
		setPreferredSize(new Dimension(WIDTH, LENGTH));
		initialize();
	}
	
	public void initialize() {
		player = new Player();
		this.boardConfigFiles = new ArrayList<String>();
		this.solutionCells = new ArrayList<BoardCell>();
		this.legend = new HashMap<Character, String>();
		this.board = new BoardCell[rows][cols];
		
		initializeConfigFiles();
		initializeLegend();
		//initializeLevel("floorEasy.csv");
		initializeLevel(1);
		initializeSolutionCellList();
	}
	
	public void initializeConfigFiles() {
		boardConfigFiles.add("/data/floorEasy.csv");
		boardConfigFiles.add("/data/floorMedium.csv");
		boardConfigFiles.add("/data/floorHard.csv");		
		this.legendConfigFile = "/data/Legend.txt";
	}
	
	private void initializeLegend() {
		try {
			//FileReader fin = new FileReader(legendConfigFile);
			FileInputStream streamIn = new FileInputStream(legendConfigFile);
			Reader r = new InputStreamReader(streamIn);
			BufferedReader br = new BufferedReader(r);
			
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
	
	public void initializeLevel(int level) {
		try {
			//FileReader filo = new FileReader(configFile);
			FileInputStream streamIn = new FileInputStream(boardConfigFiles.get(level-1));
			Reader r = new InputStreamReader(streamIn);
			BufferedReader br = new BufferedReader(r);

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
	
	public void showGuessDialog() {
		int playerXPos = (int)player.getPosition().x;
		int playerYPos = (int)player.getPosition().y;
		Question question = GameEngine.getActiveQuestion();
		Fraction guess = getCellAt(playerYPos, playerXPos).getFraction();
		Fraction activeSolution = question.getSolution();
		
		if (isPositionSolutionCell(playerYPos, playerXPos)) {
			repaint();
			int reply = JOptionPane.showConfirmDialog(null, "Is this your answer?", "No", JOptionPane.YES_NO_OPTION);
			if(reply == JOptionPane.YES_OPTION) {
				if (question.getType() == QuestionType.LESS) {
					if (guess.isLessThan(activeSolution.getValue())) {
						System.out.println(guess.toString() + " < " + activeSolution.toString());
						player.setScore(player.getScore() + 1);
						GameEngine.setActiveQuestion();
					}
					else {
						System.out.println(guess.toString() + " !< " + activeSolution.toString());
						player.setLives(player.getLives() - 1);
						
					}
				}
				else if (question.getType() == QuestionType.GREATER){
					if (guess.isGreaterThan(activeSolution.getValue())) {
						System.out.println(guess.toString() + " > " + activeSolution.toString());
						player.setScore(player.getScore() + 1);
						GameEngine.setActiveQuestion();
					}
					else {
						System.out.println(guess.toString() + " !> " + activeSolution.toString());
						player.setLives(player.getLives() - 1);
						
					}
				}
				else {
					if (guess.getValue() == activeSolution.getValue()) {		
						System.out.println(guess.toString() + " == " + activeSolution.toString());
						player.setScore(player.getScore() + 1);
						GameEngine.setActiveQuestion();
					}
					else {
						System.out.println(guess.toString() + " != " + activeSolution.toString());
						player.setLives(player.getLives() - 1);
						
					}
				}
			}
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
	
/*	public void startLevel() {
		// will draw the board
		// uses the boardConfigFile arrayList -> randomly choose one
		Random rand = new Random();
		initializeLevel(boardConfigFile.get(rand.nextInt(3)));
	}*/
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if (board[i][j].getIsSolutionCell()) {
					board[i][j].draw(g, cellSize, true);
				}
				else {
					board[i][j].draw(g, cellSize, false);
				}
			}
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
		return boardConfigFiles;
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