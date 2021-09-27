package UI;
/*
 * Ruben van Breda, 19200704
 * David Sebastian Fernandes, 19203219
 * Sagar Mahajan , 19204052
 * */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import ENGINE.constants;
import GameObjects.Player;
import ENGINE.GameManager;

public class Map extends JPanel{
	
	
	private class Point {
		int x;
		int y;
		
	    Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public class Node{
		
		
		public Point p;
		public int units;
		public int connections;
		public String name;
		
		public Node(String name, Point point) {
			this.name = name;
			this.p = point;
		}
	}
	
	static JPanel map_pl;
	public Graphics2D g2D;
	public Graphics g;
	public GameManager gm;
	
	public static ArrayList<Node> nodes;
	
	public Map(Graphics g, GameManager gm) {
		this.gm = gm;
		this.g = g;
		init(g);
		
		
	}
	
	
	


	public void init(Graphics g){
		
		nodes = new ArrayList<Node>(constants.NUM_COUNTRIES);
		
		map_pl = new JPanel();
		map_pl.setBackground(Color.green);
		map_pl.setBounds(0,0,100,100);
	
		
		add(map_pl); // need to add this
	
		
	}
	
	public void SetGameManager(GameManager gm) {
		this.gm = gm;
	}
	
	public void paint(Graphics g) {
		g2D = (Graphics2D)g;
		g2D.setPaint(Color.black);
		
		
		
		if(gm.players != null && gm.players.length >= 2) {
			populateCountriesWithPlayers();
		}
		else {
			for(int i = 0; i < constants.NUM_COUNTRIES; i++) {
				Point p = new Point(constants.COUNTRY_COORD[i][0],constants.COUNTRY_COORD[i][1]);
				createNode(constants.COUNTRY_NAMES[i],p, new Player("COMP",Color.black),0);
				//gm.nextTurn();
			}
		}
		
		
	}
	

	
	Node createNode(String name,Point p,Player player, int units) {
		
		Node n = new Node(name,p);
		g2D.setColor(player.color);
		g2D.fillOval(p.x, p.y, 15, 15);
		g2D.drawString(name, p.x, p.y-10);
		g2D.drawString(""+units, p.x, p.y+30);
		nodes.add(n);
		player.addCountry(n);
		
		return n;
	}
	
	void populateCountriesWithPlayers() {
		/*
		 * 9 nodes each for the 2 players, 6 each for the neutral players
		 * */
		
		// TODO: Bug countries are not being added to the player, its not persistent.
		
		for(int i = 0; i < constants.NUM_COUNTRIES; i++) {
			Point p = new Point(constants.COUNTRY_COORD[i][0],constants.COUNTRY_COORD[i][1]); // get location 
			if(i < 6 || i > 10 && i < 15 || i > 20 && i < 25 || i > 33 && i < 38){ // distribute the user/players with 9 territories
//				Player cur_player = (i%2==0)?gm.players[0]:gm.players[1]
				nodes.add(createNode(constants.COUNTRY_NAMES[i],p, (i%2==0)?gm.players[0]:gm.players[1],1));
				
			}
			else { // the remaining countries get distributed amongst the AI players
				if(gm.turnCount <= 1) { gm.turnCount = 2; } // avoid adding players 1 and 2
				if(gm.turnCount > gm.players.length) {gm.turnCount = 1;} // make sure it doesn'st extend the length
				nodes.add(createNode(constants.COUNTRY_NAMES[i],p, gm.currentPlayer() ,1));
			}
			gm.nextTurn();
			
			
		}
		
		System.out.println("Node "+nodes.get(0).name);
		
	}
	
	public Node getNodeWithName(String name) {
		
		for(Node i: nodes) {
			if(i.name.equalsIgnoreCase(name)) {
				return i;
			}
		}
		return null;
	}
	
	public ArrayList<Node> getNodes(){
		return nodes;
	}
	
	public void DisplayNodes() {
		for (Node n: nodes) {
			System.out.println(n.name);
		}
	}
	
}