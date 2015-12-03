package Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class DisplayGUI extends JPanel{
	private JTextArea question;
	private GameBoard board;
	private JPanel mainPanel;
	
	public DisplayGUI(GameBoard board) {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(600, 500));
		this.board = board;
		
		mainPanel = new JPanel();
		setPlayerInfo();
		setPlayerControls();
		add(mainPanel);
		setQuestionDisplay();
	}
	
	public void setPlayerInfo() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2, 5, 5));
		JTextField playerName = new JTextField(15);
		JTextField playerScore = new JTextField(10);
		JTextField test = new JTextField();
		
		playerName.setText(board.getPlayer().getName());
		playerName.setEditable(false);
		panel.add(playerName);
		
		panel.add(new JPanel());
		
		playerScore.setBorder(new TitledBorder(new EtchedBorder(), "Score"));
		String score = Integer.toString(board.getPlayer().getScore());
		playerScore.setText(score);
		playerScore.setEditable(false);
		panel.add(playerScore);
		
		test.setText("These are Lives");
		test.setBorder(new TitledBorder(new EtchedBorder(), "Lives"));
		test.setEditable(false);
		panel.add(test);
		mainPanel.add(panel);
		
	}
	
	public void setQuestionDisplay() {
		question = new JTextArea(5,50);
		question.setText("This is a question!!!");
		question.setBorder(new TitledBorder(new EtchedBorder(), "Question"));
		question.setEditable(false);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		add(question);
	}
	
	public void setPlayerControls() {
		JPanel playerControl = new JPanel();
		playerControl.setLayout(new BorderLayout());
		JButton up = new JButton("UP");
		JButton down = new JButton("DOWN");
		JButton left = new JButton("LEFT");
		JButton right = new JButton("RIGHT");
		
		playerControl.add(up, BorderLayout.NORTH);
		playerControl.add(down, BorderLayout.SOUTH);
		playerControl.add(left, BorderLayout.WEST);
		playerControl.add(right, BorderLayout.EAST);
		
		mainPanel.add(playerControl);
	}

	public void setQuestionField(Question question) {
		this.question.setText(question.toString());
	}
}
