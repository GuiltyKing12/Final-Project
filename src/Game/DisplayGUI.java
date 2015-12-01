package Game;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DisplayGUI extends JPanel{
	JTextArea question;
	public DisplayGUI() {
		setQuestionDisplay();
	}
	
	public void setQuestionDisplay() {
		question = new JTextArea();
		
	}

}
