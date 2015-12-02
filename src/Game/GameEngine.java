package Game;

public class GameEngine {
	private GameBoard board;
	private QuestionBank questionBank;
	private int gameLevel;
	//private GameDisplay display;
	
	public GameEngine() {
		initialize();
	}
	
	public void initialize() {
		gameLevel = 0;
		board = new GameBoard();
		questionBank = new QuestionBank(gameLevel);
		
		board.initialize();
		//display = new GameDisplay();
		//display.setup();
	}
	
	public GameBoard getBoard() {
		return board;
	}
	
	public void advanceNextLevel() {
		
	}
	
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
	}
	
	/*public GameDisplay getDisplay() {
	 * 
	 * }
	 */
}
