package Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.sun.javafx.geom.Vec2d;

public class DisplayGUI extends JPanel{
	private JTextArea question;
	JTextField playerName = new JTextField(15);
	private GameBoard board;
	private JPanel mainPanel;
	private int margin = 5;
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	
	public DisplayGUI(GameBoard board) {
		//setLayout(new FlowLayout());
		setLayout(new BorderLayout(3, 1));
		this.board = board;
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(3, 1));
		
		setPlayerInfo();
		setPlayerControls();
		add(mainPanel);
		setQuestionDisplay();
	}
	
	public void setPlayerInfo() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, margin, margin));
		
		JTextField playerScore = new JTextField(10);
		JTextField test = new JTextField();
		
		playerName.setText(board.getPlayer().getName());
		playerName.setEditable(false);
		panel.add(playerName);
		
		playerScore.setBorder(new TitledBorder(new EtchedBorder(), "Score"));
		String score = Integer.toString(board.getPlayer().getScore());
		playerScore.setText(score);
		playerScore.setEditable(false);
		panel.add(playerScore);
		
		test.setText("These are Lives");
		test.setBorder(new TitledBorder(new EtchedBorder(), "Lives"));
		test.setEditable(false);
		panel.add(test);
		mainPanel.add(panel, BorderLayout.NORTH);
		
	}
	
	/**
	 * 
	 */
	public void setPlayerName(String name) {
		playerName.setText(name);
	}
	
	
	public void setQuestionDisplay() {
		JPanel panel = new JPanel();
		question = new JTextArea(1,20);
		question.setText("This is a question!!!");
		question.setBorder(new TitledBorder(new EtchedBorder(), "Question"));
		question.setEditable(false);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		panel.add(question);
		mainPanel.add(panel, BorderLayout.CENTER);
	}
	
	public void setPlayerControls() {
		JPanel playerControl = new JPanel();
		//playerControl.setPreferredSize(new Dimension(getWidth() / 2, getHeight() / 2));
		playerControl.setLayout(new BorderLayout(1, 3));
		up = new JButton("UP");
		up.addActionListener(new moveControlListener());
		down = new JButton("DOWN");
		down.addActionListener(new moveControlListener());
		left = new JButton("LEFT");
		left.addActionListener(new moveControlListener());
		right = new JButton("RIGHT");
		right.addActionListener(new moveControlListener());
		
		playerControl.add(up, BorderLayout.NORTH);
		playerControl.add(down, BorderLayout.CENTER);
		playerControl.add(left, BorderLayout.WEST);
		playerControl.add(right, BorderLayout.EAST);
		
		mainPanel.add(playerControl, BorderLayout.SOUTH);
	}

	public void setQuestionField(Question question) {
		this.question.setText(question.toString());
	}
	
	public Boolean checkCanMove(int col, int row) {
		if(board.getCellAt(row, col).getInitial() == 'N') {
			return false;
		}
		return true;
	}
	
	private class moveControlListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int currentCol = (int) board.getPlayer().getPosition().y;
			int currentRow = (int) board.getPlayer().getPosition().x;
			if(e.getSource() == up && checkCanMove(currentRow - 1, currentCol)) {
				board.getPlayer().move(new Vec2d(currentRow - 1, currentCol));
			}
			else if(e.getSource() == down && checkCanMove(currentRow + 1, currentCol)) {
				board.getPlayer().move(new Vec2d(currentRow + 1, currentCol));
			}
			else if(e.getSource() == left && checkCanMove(currentRow, currentCol - 1)) {
				board.getPlayer().move(new Vec2d(currentRow, currentCol - 1));
			}
			else if(e.getSource() == right && checkCanMove(currentRow, currentCol + 1)) {
				board.getPlayer().move(new Vec2d(currentRow, currentCol + 1));
			}
			board.repaint();
		}
	}
}
