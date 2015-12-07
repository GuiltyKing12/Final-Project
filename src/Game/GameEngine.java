package Game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameEngine extends JFrame {
	public static final int WIDTH = 630;
	public static final int LENGTH = 950;
	
	private GameBoard board;

	private DisplayGUI display;

	private CardLayout gameLayout;
	private JPanel screen;
	private JPanel mainMenu;
	private JPanel game;
	private JButton play;
	private JButton instruction;
	private JButton exit;
	
	private QuestionBank questionBank;
	private int gameLevel;
	
	public GameEngine() {
		gameLayout = new CardLayout();
		screen = new JPanel();
		mainMenu = new JPanel();
		game = new JPanel();
		
		screen.setLayout(gameLayout);
		initialize();
		
		// TEST:
		
		Question randQ = questionBank.getRandomQuestion();
		System.out.println(randQ.toString() + " = " + randQ.getSolution().toString() + " = " + String.valueOf(randQ.getSolution().getValue()));
	}
	
	public void initialize() {
		setTitle("Maze Runner");
		getContentPane().setPreferredSize(new Dimension(WIDTH, LENGTH));
		
		setUpMenuBar();
		setUpMainMenu();
		setUpGame();
		
		add(screen);
		gameLayout.show(screen, "Main Menu");
		
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
		play = new JButton("Start Game");
		play.addActionListener(new MainMenuListener());
		instruction = new JButton("Instruction");
		instruction.addActionListener(new MainMenuListener());
		exit = new JButton("Exit");
		exit.addActionListener(new ExitListener());
		
		mainMenu.add(play);
		mainMenu.add(instruction);
		mainMenu.add(exit);
		
		screen.add(mainMenu, "Main Menu");
	}
	
	public void setUpGame() {
		gameLevel = 0;
		board = new GameBoard();
		questionBank = new QuestionBank(gameLevel);
		board.initialize();
		display = new DisplayGUI(board);
		
		display.setQuestionField(questionBank.getRandomQuestion());
		game.add(board, BorderLayout.CENTER);
		game.add(display, BorderLayout.EAST);
		
		screen.add(game, "Game");
	}
	
	public GameBoard getBoard() {
		return board;
	}
	
	public void advanceNextLevel() {
		
	}
	
	public void getInstructions() {
		String message = "Welcome to Maze Runner! \n In maze runner your objective is to esacpe the maze by answering \n "
				+ "fraction questions.  \n A question will be given and the answer will be somewhere in the maze.  "
				+ "\n You must go through the maze and find the correct answers, for every wrong answer you lose a life. \n"
				+ " You only have three lives, so be careful. \n You can also find items that give you back one life.";
		JOptionPane.showMessageDialog(this, message, "Instructions", JOptionPane.INFORMATION_MESSAGE );
	}
	
	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class MainMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == play) {
				getContentPane().setPreferredSize(null);
				getContentPane().setPreferredSize(new Dimension(WIDTH, LENGTH));
				gameLayout.show(screen, "Game");
			}
			else if(e.getSource() == instruction) {
				getInstructions();
			}
		}
	}
	
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		//game.board.printLegend();
		//game.board.printBoard();
	}
}
