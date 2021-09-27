package ENGINE;
/*
 * Ruben van Breda, 19200704
 * David Sebastian Fernandes, 19203219
 * Sagar Mahajan , 19204052
 * */
import java.awt.Color;

import GameObjects.Dice;
import GameObjects.Player;
import UI.MainFrame;
import UI.Map;
import UI.log;

public class GameManager {
	
	//Could we use a linked list here as we going from node to node?
	public enum Phase{
		Deploy,
		Attack,
		Fortify,
		waiting
	}

	public Phase gameState = Phase.waiting;
	public boolean gameFinished = false;
	public String gamePrompt = constants.getName1; // this will determine how the action button responds
	public MainFrame frame;
	public Map map;
	
	public Player[] players;
	public Dice dice = new Dice();
	
	
	private Player currentPlayer;
	public int turnCount = 0;
	
	public void CreateGame(Player[] _players) {
		if(_players == null) throw new IllegalArgumentException("Creating a game with players = null, "
				+ "ensure that players are set before passing in this function");
		players = _players;
		currentPlayer = players[0];
	}
	
	public void setUI(MainFrame m) { // pass the UI object to the game manager
		this.frame = m;
	}
	
	//Moving to the next phase 
	public void endPhase() {
		switch(gameState) {
		case Deploy:
			gameState = Phase.Attack;
			break;
		case Attack:
			gameState = Phase.Fortify;
			break;
		case Fortify:
			gameState = Phase.waiting;
			break;
		case waiting:
			gameState = Phase.Deploy;
			break;
		default:
			System.out.println("Add a logger class.");
			
		}
		System.out.println("endPhase");
	}
	
	
	// Gets the next player to play
	public void nextTurn() {
		if(players == null) {throw new RuntimeException("Players is null");}
		
		if(turnCount > players.length -1) {
			turnCount = 0;
		}else {
			currentPlayer = players[turnCount];
			turnCount++;
		}
		
	}
	
	public Player currentPlayer() { return currentPlayer;}
	
	public boolean CheckWin() {
		//TODO: Check if all territories are occupied by one player
		return false;
	}
	
	public void endGame() {
		// TODO: end the game and return to main menu
	}
	
	/*
	 * @param the player's instruction passed in the UserInput field
	 * it will run the correct play for command
	 * */
	public void playCommand(String com) {
	
		//frame.userInputUI.MoveField.setText("Command: "+com); // testing code connection
		//addPrompt("yeahh");
		
		switch(gamePrompt) {
			case constants.getName1:
				if(com != "") {
					players[0] = new Player(com,Color.red);
				}
				break;
			case constants.getName2:
				if(com != "") {
					players[1] = new Player(com,Color.blue);
				} 
				break;
				
//			case constants.makeMove:
//					MakeMove(com);
//				break;
		}
	}
	
	private void MakeMove(String com) {
		// TODO Auto-generated method stub
	
	
	}

	public void addPrompt(String str) {
		frame.userInputUI.lg.updateText(""+str);
	}
	
	
	
	
}
