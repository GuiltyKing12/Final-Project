package Game;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class DisplayGUI extends JPanel{
	private final static int WIDTH = 250;
	private final static int LENGTH = 250;
	private JTextArea question;
	private GameBoard board;
	
	public DisplayGUI(GameBoard board) {
		this.board = board;
		setPlayerInfo();
		setPlayerControls();
		setQuestionDisplay();
		setLivesDisplay();
	}
	
	public void setPlayerInfo() {
		/*JTextField playerName = new JTextField();
		JTextField playerScore = new JTextField();
		
		playerName.setText(board.getPlayer().getName());
		add(playerName);
		
		playerScore.setBorder(new TitledBorder(new EtchedBorder(), "Score"));
		String score = Integer.toString(board.getPlayer().getScore());
		playerScore.setText(score);
		add(playerScore);*/
		
	}
	
	public void setQuestionDisplay() {
		question = new JTextArea();
		question.setText("This is a question!!!");
		question.setBorder(new TitledBorder(new EtchedBorder(), "Question"));
		question.setEditable(false);
		add(question);
	}
	
	public void setLivesDisplay() {
		JTextField test = new JTextField();
		test.setText("These are Lives");
		test.setBorder(new TitledBorder(new EtchedBorder(), "Lives"));
		test.setEditable(false);
		add(test);
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
		
		add(playerControl);
	}

}
