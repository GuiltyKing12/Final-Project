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
	private final static int WIDTH = 750;
	private final static int LENGTH = 1000;
	
	private GameBoard board;

	private DisplayGUI display;

	private QuestionBank questionBank;
	private int gameLevel;
	
	public GameEngine() {
		initialize();
	}
	
	public void initialize() {
		setTitle("Maze Runner");
		setUpMenuBar();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(WIDTH, LENGTH / 2));
		panel.setLayout(new GridLayout(2, 1));
		
		gameLevel = 0;
		board = new GameBoard();
		questionBank = new QuestionBank(gameLevel);
		display = new DisplayGUI(board);
		board.initialize();
		
		setSize(WIDTH, LENGTH);
		panel.add(board);
		panel.add(display);
		add(panel, BorderLayout.CENTER);
		
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
	}
}
