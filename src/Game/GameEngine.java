package Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GameEngine extends JFrame {
	public static final int WIDTH = 630;
	public static final int LENGTH = 950;
	
	private GameBoard board;

	private DisplayGUI display;

	private QuestionBank questionBank;
	private int gameLevel;
	
	public GameEngine() {
		initialize();
		
		// TEST:
		
		Question randQ = questionBank.getRandomQuestion();
		System.out.println(randQ.toString() + " = " + randQ.getSolution().toString() + " = " + String.valueOf(randQ.getSolution().getValue()));
	}
	
	public void initialize() {
		setTitle("Maze Runner");
		getContentPane().setPreferredSize(new Dimension(WIDTH, LENGTH));
		setUpMenuBar();
		
		gameLevel = 0;
		board = new GameBoard();
		questionBank = new QuestionBank(gameLevel);
		board.initialize();
		display = new DisplayGUI(board);
		
		display.setQuestionField(questionBank.getRandomQuestion());
		add(board, BorderLayout.CENTER);
		add(display, BorderLayout.SOUTH);
		
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

		questionBank = new QuestionBank(gameLevel);
		
	}
	
	public GameBoard getBoard() {
		return board;
	}
	
	public void advanceNextLevel() {
		
	}
	
	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
		game.board.printLegend();
		game.board.printBoard();
	}
}
