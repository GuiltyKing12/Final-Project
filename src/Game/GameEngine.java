package Game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.javafx.geom.Vec2d;

public class GameEngine extends JFrame {
	public static int WIDTH = 1250;
	public static int HEIGHT = 700;
	private static final int MARGIN = 300;
	
	private GameBoard board;

	private DisplayGUI display;

	private CardLayout gameLayout;
	private JPanel screen;
	private JPanel mainMenu;
	private JPanel game;
	private JButton play;
	private JButton instruction;
	private JButton exit;
	private Boolean isStarted;
	private ComponentListener componentListener;
	private QuestionBank questionBank;
	private static Question activeQuestion;
	private int gameLevel;
	
	public GameEngine() {	
		initializeGame();
		initializeGUI();
	}
	
	public void initializeGame() {
		questionBank = new QuestionBank(gameLevel);
		activeQuestion = questionBank.getRandomQuestion();
		board = new GameBoard();
		gameLevel = 0;
		
		addFractionsToSolutionCells();
	}
	
	public void initializeGUI() {
		initializeGUIVariables();
		formatGUI();
		renderGUI();
	}
	
	public void initializeGUIVariables() {
		gameLayout = new CardLayout();
		screen = new JPanel();
		mainMenu = new JPanel();
		game = new JPanel();
		display = new DisplayGUI(board);
		componentListener = new ComponentListener();
		isStarted=false;
	}
	
	private void formatGUI() {
		gameLayout.setHgap(10);
		screen.setLayout(gameLayout);
		
		getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setTitle("Maze Runner");
		display.setQuestionField(activeQuestion);
		
		setUpMenuBar();
		setUpMainMenu();
		setUpGame();
		
		setLocation(300, 10);
	}
	
	private void addGUIListeners() {
		this.addComponentListener(componentListener);
		board.addComponentListener(componentListener);
		
	}
	
	private void renderGUI() {
		add(screen);
		gameLayout.show(screen, "Main Menu");
		
		addGUIListeners();
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setUpMenuBar() {
		JMenu menu = new JMenu("File");
		JMenuItem exit = new JMenuItem("Exit");
		
		exit.addActionListener(new ExitListener());
		menu.add(exit);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		add(menuBar, BorderLayout.NORTH);
	}
	
	public void setUpMainMenu() {
		mainMenu.setLayout(new GridLayout(0, 1));
		JPanel mainPanel = new JPanel();
		JPanel button1 = new JPanel();
		JPanel button2 = new JPanel();
		JPanel button3 = new JPanel();
		
		mainMenu.add(new JPanel());
		mainPanel.setLayout(new GridLayout(1, 3));
		play = new JButton("Start Game");
		play.setFont(new Font("TimesRoman", Font.BOLD, 20));
		play.setPreferredSize(new Dimension(WIDTH / 4, HEIGHT / 8));
		play.addActionListener(new MainMenuListener());
		button1.add(play);
		
		instruction = new JButton("Instruction");
		instruction.setFont(new Font("TimesRoman", Font.BOLD, 20));
		instruction.setPreferredSize(new Dimension(WIDTH / 4, HEIGHT / 8));
		instruction.addActionListener(new MainMenuListener());
		button2.add(instruction);
		
		exit = new JButton("Exit");
		exit.setFont(new Font("TimesRoman", Font.BOLD, 20));
		exit.setPreferredSize(new Dimension(WIDTH / 4, HEIGHT / 8));
		exit.addActionListener(new ExitListener());
		button3.add(exit);
		
		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);
		mainMenu.add(mainPanel);
		
		screen.add(mainMenu, "Main Menu");
	}
	
	public void setUpGame() {
		
		JPanel panel = new JPanel();
		game.setLayout(new GridLayout(1, 1));
		
		
		panel.add(display);
		game.add(board);
		game.add(panel);
		
		screen.add(game, "Game");
	}
	
	public GameBoard getBoard() {
		return board;
	}
	
	public void advanceNextLevel() {
		if(board.getPlayer().getScore() == 3) {
			//board.initializeLevel();
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.BOLD, 80));
		if(isStarted)
		{
			g.drawString("", WIDTH / 2 - MARGIN, HEIGHT / 4);
		}
		else
		{
			g.drawString("MAZE RUNNER", WIDTH / 2 - MARGIN, HEIGHT / 4);
		}
	}
	
	public void setupPlayer() {
		String playerName = JOptionPane.showInputDialog("Please enter your name:");
		board.getPlayer().setName(playerName);
		display.setPlayerName(playerName);
	}
	
	public void getInstructions() {
		String message = "Welcome to Maze Runner! \n In maze runner your objective is to esacpe the maze by answering fraction questions. "
				+ "\n A question will be given and the answer will be somewhere in the maze.  "
				+ "\n You must go through the maze and find the correct answers, for every wrong answer you lose a life. \n"
				+ " You only have three lives, so be careful. \n You can also find items that give you back one life.";
		JOptionPane.showMessageDialog(this, message, "Instructions", JOptionPane.INFORMATION_MESSAGE );
	}
	
	public void addFractionsToSolutionCells() {
		ArrayList<Fraction> temp = new ArrayList<Fraction>();
		boolean cellsContainZero = false;
		
		for (Question q : questionBank.getQuestions()) {
			temp.add(q.getSolution());
		}
		
		for (Fraction f : temp) {
			for (int i = 0; i < board.getSolutionCells().size(); i++) {
				BoardCell solutionCell = board.getSolutionCells().get(i);
				
				if (!solutionCell.getHasFraction()) {
					if (f.equals(0.0) && !cellsContainZero) {
						solutionCell.setFraction(f);
						cellsContainZero = true;
						
					}
					else if (f.equals(0.0) && cellsContainZero) {
						solutionCell.setFraction(new Question().getRandomFraction());
					}
					else if (!f.equals(0.0)) {
						solutionCell.setFraction(f);
					}
					solutionCell.setHasFraction(true);
					break;
				}
			}
		}
		
		for (BoardCell c : board.getSolutionCells()) {
			if (!c.getHasFraction()) {
				c.setFraction(new Question().getRandomFraction());
			}
		}
	}
	
	
	
	public static Question getActiveQuestion() {
		return activeQuestion;
	}
	
	public static void setActiveQuestion(Question question) {
		activeQuestion = question;
	}
	
	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class MainMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == play) {
				setupPlayer();
				gameLayout.show(screen, "Game");
				isStarted=true;
			}
			else if(e.getSource() == instruction) {
				getInstructions();
			}
		}
	}
	
	private class ComponentListener extends ComponentAdapter {		
		@Override
		public void componentResized(ComponentEvent e) {
			Dimension temp = new Dimension(getWidth(), getHeight());

			board.setCellSize((int)((temp.width + temp.height)/ (board.getRows() + board.getCols()) * 0.65));
			board.setBounds(5, 5, temp.width / 2, temp.height);
			display.setBounds(temp.width / 10, temp.height / 4, temp.width / 2, temp.height);
			game.setSize(temp);
			GameEngine.WIDTH = temp.width;
			GameEngine.HEIGHT = temp.height;

			repaint();
			super.componentResized(e);
		}
	}
	
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		//game.board.printLegend();
		//game.board.printBoard();
	}
}
