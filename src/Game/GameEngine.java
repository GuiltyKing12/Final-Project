package Game;

public class GameEngine {
	private GameBoard board;
	//private GameDisplay display;
	
	public GameEngine() {
		board = new GameBoard();
		//display = new GameDisplay();
		
		board.initialize();
		//display.setup();
	}
	
	public GameBoard getBoard() {
		return board;
	}
	
	public void advanceNextLevel() {
		
	}
	
	/*public GameDisplay getDisplay() {
	 * 
	 * }
	 */
}
