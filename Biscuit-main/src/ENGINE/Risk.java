package ENGINE;
/*
 * Ruben van Breda, 19200704
 * David Sebastian Fernandes, 19203219
 * Sagar Mahajan , 19204052
 * */
import java.awt.Color;

import javax.swing.JOptionPane;

import ENGINE.GameManager.Phase;
import GameObjects.Player;
import UI.MainFrame;
import UI.Map;
import UI.Map.Node;

public class Risk {
	
	static GameManager gm = new GameManager();
	static Player[] players;
	static MainFrame frame;
	
	public static void main(String[] args) {
		
		//Create window
		frame = new MainFrame(gm);
		gm.setUI(frame);
		//Get players Names
		GetPlayerDetails();
		
		gm.CreateGame(players);
		gm.addPrompt("Player 1 : "+ gm.players[0].name); //add to the log panel
		gm.addPrompt("Player 2 : "+ gm.players[1].name); //add to the log panel
		

//		//Node n = frame.map.getNodeWithName("S Africa");
//		System.out.println(gm.players[0].countries.size());
		
		while(gm.gameFinished == false) {
			
			if(gm.gameState == Phase.Deploy) {
				//TODO: Code for player to deploy troops
				
				
				gm.endPhase();
			}
			
			if(gm.gameState == Phase.Attack) {
				// TODO: Players can attack territories
				
				gm.endPhase();
			}
			
			if(gm.gameState == Phase.Fortify) {
				//TODO: Players can move around troops
				gm.endPhase();
			}
			gm.gameFinished = true; // for debugging this will be removed once the game loop is implemented
			gm.CheckWin();
			gm.nextTurn();
		}
	}
	
	static void GetPlayerDetails() {
		players = new Player[6]; //  initate the players array for 6 players
	
		String player1Name = JOptionPane.showInputDialog(constants.getName1);
		players[0] = new Player(player1Name,Color.red);
		String player2Name = JOptionPane.showInputDialog(constants.getName2);
		players[1] = new Player(player2Name ,Color.blue);
		
		// COMPUTER PLAYERS	
		players[2] = new Player("COMP1", Color.green);
		players[3] = new Player("COMP2", Color.orange);
		players[4] = new Player("COMP3", Color.pink);
		players[5] = new Player("COMP4", Color.magenta);
		
		frame.map.repaint(); // update map values with new colors
			
	}
}
